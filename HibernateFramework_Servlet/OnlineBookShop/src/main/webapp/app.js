let currentUser = null;

document.addEventListener('DOMContentLoaded', () => {
    checkAuthStatus();
    const path = window.location.pathname;
    if (path.includes('books.html')) loadBooks();
    if (path.includes('cart.html')) loadCart();
    if (path.includes('orders.html')) loadOrders();
});

async function checkAuthStatus() {
    try {
        const response = await fetch('/api/auth/status');
        if (response.ok) {
            currentUser = await response.json();
            updateNav();
        }
    } catch (error) {
        console.error('Error checking auth status:', error);
    }
}

function updateNav() {
    const nav = document.querySelector('nav');
    if (currentUser) {
        nav.innerHTML = `
            <ul class="nav-list">
                <li><a href="/index.html">Home</a></li>
                <li><a href="/books.html">Books</a></li>
                <li><a href="/cart.html">Cart</a></li>
                <li><a href="/orders.html">Orders</a></li>
                <li><a href="/add-book.html">Add Book</a></li>
                <li><a href="#" onclick="logout()">Logout (${currentUser.username})</a></li>
            </ul>
        `;
    } else {
        nav.innerHTML = `
            <ul class="nav-list">
                <li><a href="/index.html">Home</a></li>
                <li><a href="/books.html">Books</a></li>
                <li><a href="/cart.html">Cart</a></li>
                <li><a href="/login.html">Login</a></li>
                <li><a href="/register.html">Register</a></li>
            </ul>
        `;
    }
}

async function login(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, passwordHash: password })
        });
        
        if (response.ok) {
            currentUser = await response.json();
            window.location.href = '/index.html';
        } else {
            alert('Login failed');
        }
    } catch (error) {
        console.error('Login error:', error);
    }
}

async function register(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/api/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, email, passwordHash: password })
        });
        
        if (response.ok) {
            window.location.href = '/login.html';
        } else {
            alert('Registration failed');
        }
    } catch (error) {
        console.error('Registration error:', error);
    }
}

async function logout() {
    await fetch('/api/auth/logout');
    currentUser = null;
    window.location.href = '/index.html';
}

async function loadBooks() {
    try {
        const response = await fetch('/api/books');
        const books = await response.json();
        displayBooks(books);
    } catch (error) {
        console.error('Error loading books:', error);
    }
}

function displayBooks(books) {
    const bookGrid = document.getElementById('bookGrid');
    bookGrid.innerHTML = '';

    books.forEach(book => {
        const bookCard = document.createElement('div');
        bookCard.className = 'book-card';
        bookCard.innerHTML = `
            <h3>${book.title}</h3>
            <p>Author: ${book.author.firstName} ${book.author.lastName}</p>
            <p>Category: ${book.category.name}</p>
            <p class="price">$${book.price}</p>
            <p>Stock: ${book.stock}</p>
            <button onclick="addToCart(${book.bookId})">Add to Cart</button>
        `;
        bookGrid.appendChild(bookCard);
    });
}

async function addToCart(bookId) {
    if (!currentUser) {
        window.location.href = '/login.html';
        return;
    }

    try {
        const response = await fetch('/api/cart', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ bookId })
        });
        
        if (response.ok) {
            alert('Added to cart!');
        }
    } catch (error) {
        console.error('Error adding to cart:', error);
    }
}

async function loadCart() {
    if (!currentUser) {
        window.location.href = '/login.html';
        return;
    }

    try {
        const response = await fetch('/api/cart');
        const cartItems = await response.json();
        displayCart(cartItems);
    } catch (error) {
        console.error('Error loading cart:', error);
    }
}

function displayCart(cartItems) {
    const cartGrid = document.getElementById('cartGrid');
    cartGrid.innerHTML = '';

    cartItems.forEach(item => {
        const cartItem = document.createElement('div');
        cartItem.className = 'cart-item';
        cartItem.innerHTML = `
            <h3>${item.book.title}</h3>
            <p>Price: $${item.book.price}</p>
            <p>Quantity: ${item.quantity}</p>
            <p>Total: $${(item.book.price * item.quantity).toFixed(2)}</p>
        `;
        cartGrid.appendChild(cartItem);
    });

    if (cartItems.length > 0) {
        const checkoutBtn = document.createElement('button');
        checkoutBtn.textContent = 'Checkout';
        checkoutBtn.onclick = checkout;
        cartGrid.appendChild(checkoutBtn);
    }
}

async function checkout() {
    try {
        const response = await fetch('/api/orders', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        });
        
        if (response.ok) {
            alert('Order placed successfully!');
            window.location.href = '/orders.html';
        }
    } catch (error) {
        console.error('Checkout error:', error);
    }
}

async function loadOrders() {
    if (!currentUser) {
        window.location.href = '/login.html';
        return;
    }

    try {
        const response = await fetch('/api/orders');
        const orders = await response.json();
        displayOrders(orders);
    } catch (error) {
        console.error('Error loading orders:', error);
    }
}

function displayOrders(orders) {
    const orderGrid = document.getElementById('orderGrid');
    orderGrid.innerHTML = '';

    orders.forEach(order => {
        const orderCard = document.createElement('div');
        orderCard.className = 'order-card';
        let itemsHtml = order.orderItems.map(item => `
            <p>${item.book.title} - ${item.quantity} x $${item.unitPrice}</p>
        `).join('');
        
        orderCard.innerHTML = `
            <h3>Order #${order.orderId}</h3>
            <p>Date: ${new Date(order.orderDate).toLocaleString()}</p>
            ${itemsHtml}
            <p>Total: $${order.totalAmount}</p>
            <p>Status: ${order.status}</p>
        `;
        orderGrid.appendChild(orderCard);
    });
}

async function addBook(event) {
    event.preventDefault();
    if (!currentUser) {
        window.location.href = '/login.html';
        return;
    }

    const book = {
        title: document.getElementById('title').value,
        price: parseFloat(document.getElementById('price').value),
        stock: parseInt(document.getElementById('stock').value),
        isbn: document.getElementById('isbn').value || null,
        author: {
            firstName: document.getElementById('authorFirstName').value,
            lastName: document.getElementById('authorLastName').value
        },
        category: {
            name: document.getElementById('categoryName').value
        }
    };

    try {
        const response = await fetch('/api/books', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(book)
        });

        if (response.ok) {
            alert('Book added successfully!');
            window.location.href = '/books.html';
        } else {
            const error = await response.json();
            alert('Failed to add book: ' + error.message);
        }
    } catch (error) {
        console.error('Error adding book:', error);
        alert('Error adding book');
    }
}