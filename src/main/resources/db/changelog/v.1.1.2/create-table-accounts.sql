CREATE TABLE accounts
(
    id                 SERIAL PRIMARY KEY,
    user_id            BIGINT NOT NULL,
    balance            BIGINT,
    transaction_amount BIGINT,
    created_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);