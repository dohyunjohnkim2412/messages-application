DROP TABLE IF EXISTS MESSAGES;

CREATE TABLE MESSAGES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(512) NOT NULL,
    created_on DATE NOT NULL
);