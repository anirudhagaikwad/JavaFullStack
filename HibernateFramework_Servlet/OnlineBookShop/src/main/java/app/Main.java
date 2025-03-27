package app;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import java.io.File;
import controller.*;
import util.HibernateUtil;

import org.apache.catalina.servlets.DefaultServlet;

public class Main {
    public static void main(String[] args) throws Exception {
    	// Test Hibernate initialization
        System.out.println("Initializing Hibernate...");
        HibernateUtil.getSessionFactory(); // This should create tables if configured correctly
        System.out.println("Hibernate initialized");
        
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8088);


        String projectRoot = new File(".").getCanonicalPath();
        String docBase = new File(projectRoot, "src/main/webapp").getAbsolutePath();
        File docBaseFile = new File(docBase);
        System.out.println("Project Root: " + projectRoot);
        System.out.println("DocBase: " + docBase);
        System.out.println("DocBase exists: " + docBaseFile.exists());
        System.out.println("DocBase is directory: " + docBaseFile.isDirectory());
       // System.out.println("Checking test.html: " + new File(docBaseFile, "test.html").exists());
        
        Context context = tomcat.addContext("", docBase);
        context.addWelcomeFile("/auth");

        // Add DefaultServlet for static files correctly
        Tomcat.addServlet(context, "default", new DefaultServlet());
        context.addServletMappingDecoded("/*", "default");

        // Ensure static files are served properly
        context.setResources(new org.apache.catalina.webresources.StandardRoot(context));

     // Add servlets with mappings
        tomcat.addServlet("", "AuthServlet", "controller.AuthServlet");
        context.addServletMappingDecoded("/auth/*", "AuthServlet");

        tomcat.addServlet("", "BookServlet", "controller.BookServlet");
        tomcat.addServlet("", "CartServlet", "controller.CartServlet");
        tomcat.addServlet("", "OrderServlet", "controller.OrderServlet");
        context.addServletMappingDecoded("/books/*", "BookServlet");
        context.addServletMappingDecoded("/cart/*", "CartServlet");
        context.addServletMappingDecoded("/orders/*", "OrderServlet");
        
     // Ensure connector is initialized
        tomcat.getConnector(); // This forces connector setup
        
        System.out.println("Starting Tomcat...");
        tomcat.start();
        System.out.println("Tomcat started on http://localhost:8088");
        tomcat.getServer().await();
    }
}

/*
Full Navigation Sequence Browser
Start: http://localhost:8088/auth
Register: http://localhost:8088/auth/register → Submit form → /auth/login
Login: http://localhost:8088/auth/login → Submit form → /auth
Books: http://localhost:8088/books → Add to cart → /cart
Cart: http://localhost:8088/cart → Checkout → /orders
Orders: http://localhost:8088/orders
Logout: http://localhost:8088/auth/logout → /auth/login

------------------------------------------------------------


### Testing with Postman (Form Data)
start with `x-www-form-urlencoded` in Postman, which matches the browser behavior.

#### 1. Register a User
- Request:
  - Method: `POST`
  - URL: `http://localhost:8088/auth/register`
  - Headers: `Content-Type: application/x-www-form-urlencoded`
  - Body (Form Data):
    ```
    username=testuser6
    email=test6@example.com
    password=pass123
    ```
- Send:
  - Click "Send" in Postman.
- Expected Response:
  - Status: `200 OK`
  - Body: HTML with `<h1>Success</h1><p>Registered successfully! <a href='/auth/login'>Login</a>.</p>`
- Verify: Check database (`SELECT * FROM Users;`).

#### 2. Log In
- Request:
  - Method: `POST`
  - URL: `http://localhost:8088/auth/login`
  - Headers: `Content-Type: application/x-www-form-urlencoded`
  - Body (Form Data):
    ```
    username=testuser6
    password=pass123
    ```
- Send:
- Expected Response:
  - Status: `302 Found`
  - Headers: `Location: /auth`
  - Cookies: `JSESSIONID=<value>` (save this!)
- Action:
  - Copy the `JSESSIONID` from the "Cookies" tab in Postman.
  - Add to subsequent requests: Headers → `Cookie: JSESSIONID=<value>`.

#### 3. Add a Book (Optional, if no books exist)
- Request:
  - Method: `POST`
  - URL: `http://localhost:8088/books/add`
  - Headers:
    - `Content-Type: application/x-www-form-urlencoded`
    - `Cookie: JSESSIONID=<value>`
  - Body (Form Data):
    ```
    title=TestBook2
    price=29.99
    stock=5
    isbn=9876543210987
    authorFirstName=Jane
    authorLastName=Doe
    categoryName=Fiction
    ```
- Send:
- Expected Response:
  - Status: `200 OK`
  - Body: HTML with `<h1>Success</h1><p>Book added! <a href='/books'>Back to Books</a>.</p>`
- Verify: `SELECT * FROM Books;`

#### 4. Add to Cart
- Request:
  - Method: `POST`
  - URL: `http://localhost:8088/cart/add`
  - Headers:
    - `Content-Type: application/x-www-form-urlencoded`
    - `Cookie: JSESSIONID=<value>`
  - Body (Form Data):
    ```
    bookId=1
    ```
  - (Use a valid `bookId` from your `Books` table.)
- Send:
- Expected Response:
  - Status: `302 Found`
  - Headers: `Location: /cart`
- Verify: Follow redirect manually (GET `/cart`) or check console logs ("Added new item to cart").

#### 5. View Cart
- Request:
  - Method: `GET`
  - URL: `http://localhost:8088/cart`
  - Headers: `Cookie: JSESSIONID=<value>`
- Send:
- Expected Response:
  - Status: `200 OK`
  - Body: HTML with cart items (e.g., `<h3>TestBook2</h3>`).

#### 6. Checkout
- Request:
  - Method: `POST`
  - URL: `http://localhost:8088/cart/checkout`
  - Headers:
    - `Content-Type: application/x-www-form-urlencoded`
    - `Cookie: JSESSIONID=<value>`
  - Body: None (empty form submission)
- Send:
- Expected Response:
  - Status: `200 OK`
  - Body: HTML with `<h1>Success</h1><p>Order placed! <a href='/orders'>View Orders</a>.</p>`
- Verify: `SELECT * FROM Orders;` and `SELECT * FROM Order_Items;`

#### 7. View Orders
- Request:
  - Method: `GET`
  - URL: `http://localhost:8088/orders`
  - Headers: `Cookie: JSESSIONID=<value>`
- Send:
- Expected Response:
  - Status: `200 OK`
  - Body: HTML with order details.

#### 8. Logout
- Request:
  - Method: `GET`
  - URL: `http://localhost:8088/auth/logout`
  - Headers: `Cookie: JSESSIONID=<value>`
- Send:
- Expected Response:
  - Status: `302 Found`
  - Headers: `Location: /auth/login`


*/