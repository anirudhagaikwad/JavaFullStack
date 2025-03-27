package controller;


import model.Book;
import model.Author;
import model.Category;
import model.User;
import util.HibernateUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/books/*")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();

        out.println("<html><head><title>Online Book Shop - Books</title>");
        out.println("<link rel='stylesheet' href='style.css'></head><body>");
        out.println("<header><nav>" + getNavBar(user) + "</nav></header>");
        out.println("<div class='container'>");

        try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
            if ("/add".equals(pathInfo) && user != null) {
                out.println("<h1>Add New Book</h1>");
                out.println("<form method='post' action='/books/add'>");
                out.println("<input type='text' name='title' placeholder='Book Title' required>");
                out.println("<input type='number' name='price' placeholder='Price' step='0.01' required>");
                out.println("<input type='number' name='stock' placeholder='Stock' required>");
                out.println("<input type='text' name='isbn' placeholder='ISBN (optional)'>");
                out.println("<input type='text' name='authorFirstName' placeholder='Author First Name' required>");
                out.println("<input type='text' name='authorLastName' placeholder='Author Last Name' required>");
                out.println("<input type='text' name='categoryName' placeholder='Category Name' required>");
                out.println("<button type='submit'>Add Book</button>");
                out.println("</form>");
            } else {
                out.println("<h1>Our Books</h1>");
                List<Book> books = dbSession.createQuery("FROM Book b JOIN FETCH b.author JOIN FETCH b.category", Book.class).list();
                out.println("<div class='book-grid'>");
                for (Book book : books) {
                    out.println("<div class='book-card'>");
                    out.println("<h3>" + book.getTitle() + "</h3>");
                    out.println("<p>Author: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + "</p>");
                    out.println("<p>Category: " + book.getCategory().getName() + "</p>");
                    out.println("<p class='price'>$" + book.getPrice() + "</p>");
                    out.println("<p>Stock: " + book.getStock() + "</p>");
                    if (user != null) {
                        out.println("<form method='post' action='/cart/add'><input type='hidden' name='bookId' value='" + book.getBookId() + "'>");
                        out.println("<button type='submit'>Add to Cart</button></form>");
                    }
                    out.println("</div>");
                }
                out.println("</div>");
            }
        }
        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String pathInfo = req.getPathInfo();

        if (user == null) {
            resp.sendRedirect("/auth/login");
            return;
        }

        out.println("<html><head><title>Online Book Shop - Books</title>");
        out.println("<link rel='stylesheet' href='/static/css/style.css'></head><body>");
        out.println("<header><nav>" + getNavBar(user) + "</nav></header>");
        out.println("<div class='container'>");

        try (Session dbSession = HibernateUtil.getSessionFactory().openSession()) {
            if ("/add".equals(pathInfo)) {
                Book book = new Book();
                book.setTitle(req.getParameter("title"));
                book.setPrice(new BigDecimal(req.getParameter("price")));
                book.setStock(Integer.parseInt(req.getParameter("stock")));
                book.setIsbn(req.getParameter("isbn"));

                Author author = new Author();
                author.setFirstName(req.getParameter("authorFirstName"));
                author.setLastName(req.getParameter("authorLastName"));
                dbSession.beginTransaction();
                dbSession.persist(author);
                dbSession.getTransaction().commit();

                Category category = new Category();
                category.setName(req.getParameter("categoryName"));
                dbSession.beginTransaction();
                dbSession.persist(category);
                dbSession.getTransaction().commit();

                book.setAuthor(author);
                book.setCategory(category);

                dbSession.beginTransaction();
                dbSession.persist(book);
                dbSession.getTransaction().commit();

                out.println("<h1>Success</h1><p>Book added! <a href='/books'>Back to Books</a>.</p>");
            }
        } catch (Exception e) {
            out.println("<h1>Error</h1><p>Failed to add book: " + e.getMessage() + "</p>");
        }
        out.println("</div></body></html>");
    }

    private String getNavBar(User user) {
        StringBuilder nav = new StringBuilder("<ul class='nav-list'>");
        nav.append("<li><a href='/auth'>Home</a></li>");
        nav.append("<li><a href='/books'>Books</a></li>");
        nav.append("<li><a href='/cart'>Cart</a></li>");
        if (user != null) {
            nav.append("<li><a href='/orders'>Orders</a></li>");
            nav.append("<li><a href='/books/add'>Add Book</a></li>");
            nav.append("<li><a href='/auth/logout'>Logout (" + user.getUsername() + ")</a></li>");
        } else {
            nav.append("<li><a href='/auth/login'>Login</a></li>");
            nav.append("<li><a href='/auth/register'>Register</a></li>");
        }
        nav.append("</ul>");
        return nav.toString();
    }
}