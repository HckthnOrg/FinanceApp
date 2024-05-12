CREATE TABLE IF NOT EXISTS users
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255)        NOT NULL,
    email       VARCHAR(255) UNIQUE NOT NULL,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    role        VARCHAR(50)         NOT NULL,
    created_at  TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);
