CREATE TABLE regions (
    region_id SERIAL PRIMARY KEY,
    region_name VARCHAR(25) DEFAULT NULL
);

CREATE TABLE countries (
    country_id CHAR(2) PRIMARY KEY,
    country_name VARCHAR(40) DEFAULT NULL,
    region_id INT NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON DELETE CASCADE ON UPDATE CASCADE
);