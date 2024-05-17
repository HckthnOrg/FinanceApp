CREATE TABLE transactions
(
    id          SERIAL PRIMARY KEY,
    value       BIGINT,
    type        VARCHAR(255),
    description TEXT,
    category_id BIGINT,
    date        DATE,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);
