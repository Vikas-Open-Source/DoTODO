CREATE TABLE if not exists users(
    name varchar(50) NOT NULL,
    username varchar(20) PRIMARY KEY,
    email varchar(50) NOT NULL,
    password varchar(20) NOT NULL,
    phone varchar(15) NOT NULL
);


CREATE TABLE if not exists user_token(
    username varchar(20) NOT NULL,
    token varchar(36) PRIMARY KEY,
    created_timestamp timestamp,
    updated_timestamp timestamp,
    FOREIGN KEY (username) REFERENCES users(username)
);