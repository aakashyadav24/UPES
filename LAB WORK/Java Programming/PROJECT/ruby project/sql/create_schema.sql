CREATE DATABASE IF NOT EXISTS musicdb;
USE musicdb;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS playlist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    user_id INT,
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS media_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150),
    artist VARCHAR(150),
    album VARCHAR(150),
    duration INT,
    type VARCHAR(50),
    playlist_id INT,
    FOREIGN KEY (playlist_id) REFERENCES playlist(id) ON DELETE CASCADE
);
