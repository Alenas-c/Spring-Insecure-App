CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO users (username, password) VALUES ('admin', 'password123');
INSERT INTO users (username, password) VALUES ('user1', 'user123');
