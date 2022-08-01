CREATE TABLE if not exists users(
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(50) PRIMARY KEY,
    password varchar(20) NOT NULL
);


CREATE TABLE if not exists user_token(
    email varchar(50) PRIMARY KEY,
    token varchar(36),
    last_updated_timestamp timestamp,
    FOREIGN KEY (email) REFERENCES users(email)
);