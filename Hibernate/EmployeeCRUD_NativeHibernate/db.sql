CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10)
);

CREATE TABLE empdetails (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    address_id INTEGER REFERENCES address(id)
);

