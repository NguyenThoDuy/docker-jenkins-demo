-- Tạo bảng
CREATE TABLE tbl_user (
                       id INT PRIMARY KEY,
                       username VARCHAR(255),
                       email VARCHAR(255)
);

-- Insert dữ liệu mẫu
INSERT INTO tbl_user (id, username, email) VALUES
                                            (1, 'user1', 'user1@example.com'),
                                            (2, 'user2', 'user2@example.com'),
                                            (3, 'user3', 'user3@example.com');
