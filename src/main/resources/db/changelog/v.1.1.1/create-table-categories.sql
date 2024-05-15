CREATE TABLE categories
(
    id            SERIAL PRIMARY KEY,
    category_name VARCHAR(255) UNIQUE,
    description   TEXT,
    account_id    BIGINT,
    created_at    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts (id)
);
