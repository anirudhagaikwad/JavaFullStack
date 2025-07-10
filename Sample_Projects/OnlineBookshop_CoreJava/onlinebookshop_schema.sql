-- Drop existing tables if any
DROP TABLE IF EXISTS Order_Items, Orders, Books, Categories, Authors, Users CASCADE;

-- Users
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

-- Authors
CREATE TABLE Authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

-- Categories
CREATE TABLE Categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

-- Books
CREATE TABLE Books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(150),
    price DECIMAL(10,2),
    author_id INT REFERENCES Authors(author_id),
    category_id INT REFERENCES Categories(category_id)
);

-- Orders
CREATE TABLE Orders (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES Users(user_id),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Order Items
CREATE TABLE Order_Items (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES Orders(order_id),
    book_id INT REFERENCES Books(book_id),
    quantity INT
);

-- Sample Authors
INSERT INTO Authors (name) VALUES ('J.K. Rowling'), ('George Orwell'), ('J.R.R. Tolkien');

-- Sample Categories
INSERT INTO Categories (name) VALUES ('Fantasy'), ('Dystopian'), ('Adventure');

-- Sample Users
INSERT INTO Users (name, email, password) VALUES
('Alice', 'alice@example.com', 'alice123'),
('Bob', 'bob@example.com', 'bob123');

-- Sample Books
INSERT INTO Books (title, price, author_id, category_id) VALUES
('Harry Potter and the Sorcerer''s Stone', 499.99, 1, 1),
('1984', 299.99, 2, 2),
('The Hobbit', 399.99, 3, 3);