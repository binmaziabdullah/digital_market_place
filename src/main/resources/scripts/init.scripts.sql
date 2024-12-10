DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(255)                          NOT NULL,
    password   VARCHAR(255)                          NOT NULL,
    role       ENUM ('ADMIN', 'CREATOR', 'CUSTOMER') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS courses;
CREATE TABLE courses
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_by_id  BIGINT         NOT NULL,
    title          VARCHAR(255)   NOT NULL,
    description    TEXT,
    price          double         NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT courses_created_by_id_fk FOREIGN KEY (created_by_id) REFERENCES user (id)
);

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id     BIGINT NOT NULL,
    user_id       BIGINT NOT NULL,
    purchase_date DATE   NOT NULL,
    CONSTRAINT courses_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT courses_course_id_fk FOREIGN KEY (course_id) REFERENCES courses (id)
);