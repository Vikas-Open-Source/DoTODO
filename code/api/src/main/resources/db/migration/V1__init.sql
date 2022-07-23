CREATE TABLE if not exists users(
    name varchar(50) NOT NULL,
    email varchar(50) PRIMARY KEY,
    password varchar(20) NOT NULL,
    phone varchar(15) NOT NULL
);


CREATE TABLE if not exists user_token(
    email varchar(50) NOT NULL,
    token varchar(36),
    created_timestamp timestamp,
    updated_timestamp timestamp,
    FOREIGN KEY (email) REFERENCES users(email)
);