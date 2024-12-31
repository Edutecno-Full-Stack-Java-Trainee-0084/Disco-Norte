-- Creacion de tablas
CREATE TABLE branch (
    branch_id SERIAL PRIMARY KEY,
    branch_description VARCHAR(50) NOT NULL
);

CREATE TABLE membership_type (
    membership_type_id SERIAL PRIMARY KEY,
    membership_type_description VARCHAR(50) NOT NULL
);

CREATE TABLE gender (
    gender_id SERIAL PRIMARY KEY,
    gender_description VARCHAR(50) NOT NULL
);

CREATE TABLE member (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    branch_id BIGINT UNSIGNED NOT NULL,
    membership_type_id BIGINT UNSIGNED NOT NULL,
    gender_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES branch (branch_id),
    FOREIGN KEY (gender_id) REFERENCES gender (gender_id),
    FOREIGN KEY (membership_type_id) REFERENCES membership_type (membership_type_id)
);

CREATE TABLE album (
    album_id SERIAL PRIMARY KEY,
    artist_name VARCHAR(100) NOT NULL,
    album_title VARCHAR(200) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    music_genre VARCHAR(50) NOT NULL,
    label VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    price INT NOT NULL
);

CREATE TABLE member_purchase (
    member_purchase_id SERIAL PRIMARY KEY,
    member_id BIGINT UNSIGNED NOT NULL,
    album_id BIGINT UNSIGNED NOT NULL,
    quantity INT NOT NULL,
    branch_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member (member_id),
    FOREIGN KEY (album_id) REFERENCES album (album_id),
    FOREIGN KEY (branch_id) REFERENCES branch (branch_id)
);

CREATE TABLE seller (
    seller_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    branch_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES branch (branch_id)
);

-- Inserciones

-- Branches
INSERT INTO branch (branch_description) VALUES ('Main Branch');
INSERT INTO branch (branch_description) VALUES ('West Branch');
INSERT INTO branch (branch_description) VALUES ('East Branch');

-- Membership Types
INSERT INTO membership_type (membership_type_description) VALUES ('Basic');
INSERT INTO membership_type (membership_type_description) VALUES ('Premium');
INSERT INTO membership_type (membership_type_description) VALUES ('VIP');

-- Genders
INSERT INTO gender (gender_description) VALUES ('Male');
INSERT INTO gender (gender_description) VALUES ('Female');
INSERT INTO gender (gender_description) VALUES ('Non-binary');

-- Members
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Maria', 'Garcia', 'maria.garcia@example.com', '1992-03-15', 1, 1, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('David', 'Wilson', 'david.wilson@example.com', '1988-07-22', 2, 2, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Emma', 'Brown', 'emma.brown@example.com', '1995-11-30', 3, 3, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Lucas', 'Martinez', 'lucas.martinez@example.com', '1993-04-18', 1, 2, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Sophie', 'Anderson', 'sophie.anderson@example.com', '1991-09-25', 2, 1, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Sam', 'Taylor', 'sam.taylor@example.com', '1997-06-12', 3, 3, 3);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Oliver', 'White', 'oliver.white@example.com', '1994-02-28', 1, 1, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Isabella', 'Lee', 'isabella.lee@example.com', '1989-12-05', 2, 2, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Jordan', 'Chen', 'jordan.chen@example.com', '1996-08-14', 3, 1, 3);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Sophia', 'Kim', 'sophia.kim@example.com', '1990-05-20', 1, 3, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('William', 'Clark', 'william.clark@example.com', '1987-10-08', 2, 2, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Eva', 'Rodriguez', 'eva.rodriguez@example.com', '1998-01-17', 3, 1, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Daniel', 'Nguyen', 'daniel.nguyen@example.com', '1993-07-24', 1, 3, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Mia', 'Patel', 'mia.patel@example.com', '1992-11-11', 2, 1, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Avery', 'Singh', 'avery.singh@example.com', '1995-03-29', 3, 2, 3);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('James', 'Thompson', 'james.thompson@example.com', '1991-06-15', 1, 1, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Emily', 'Wang', 'emily.wang@example.com', '1994-09-02', 2, 3, 2);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Riley', 'Cohen', 'riley.cohen@example.com', '1997-12-19', 3, 2, 3);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Nathan', 'Lopez', 'nathan.lopez@example.com', '1988-04-07', 1, 1, 1);
INSERT INTO member (first_name, last_name, email, birth_date, branch_id, membership_type_id, gender_id) VALUES ('Ava', 'Gonzalez', 'ava.gonzalez@example.com', '1996-08-23', 2, 2, 2);

-- Albums
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Queen', 'A Night at the Opera', '43:08', 'Rock', 'EMI', 80, 24.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Pink Floyd', 'The Dark Side of the Moon', '43:00', 'Progressive Rock', 'Harvest', 60, 27.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Taylor Swift', '1989', '48:41', 'Pop', 'Big Machine', 90, 21.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Ed Sheeran', '÷', '46:00', 'Pop', 'Atlantic', 70, 20.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Kendrick Lamar', 'DAMN.', '54:54', 'Hip Hop', 'Aftermath', 55, 23.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Lady Gaga', 'The Fame', '51:53', 'Pop', 'Interscope', 65, 19.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Nirvana', 'Nevermind', '42:38', 'Grunge', 'DGC', 45, 26.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('David Bowie', 'Heroes', '40:12', 'Art Rock', 'RCA', 40, 28.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Dua Lipa', 'Future Nostalgia', '37:17', 'Pop', 'Warner', 85, 22.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('AC/DC', 'Back in Black', '42:11', 'Hard Rock', 'Atlantic', 50, 25.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Bob Marley', 'Legend', '73:36', 'Reggae', 'Island', 70, 21.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Coldplay', 'Parachutes', '41:47', 'Alternative Rock', 'Parlophone', 60, 20.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Drake', 'Scorpion', '89:44', 'Hip Hop', 'OVO', 75, 24.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Madonna', 'Like a Prayer', '51:16', 'Pop', 'Sire', 40, 23.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Radiohead', 'OK Computer', '53:21', 'Alternative Rock', 'Parlophone', 55, 27.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Bruno Mars', '24K Magic', '33:28', 'R&B', 'Atlantic', 80, 21.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Metallica', 'Master of Puppets', '54:47', 'Metal', 'Elektra', 45, 26.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Beyoncé', 'Lemonade', '45:41', 'R&B', 'Parkwood', 70, 25.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('The Weeknd', 'After Hours', '56:19', 'R&B', 'XO', 65, 22.99);
INSERT INTO album (artist_name, album_title, duration, music_genre, label, stock, price) VALUES ('Arctic Monkeys', 'AM', '41:43', 'Alternative Rock', 'Domino', 50, 23.99);

-- Member Purchases
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (4, 4, 2, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (5, 5, 1, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (6, 6, 3, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (7, 7, 1, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (8, 8, 2, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (9, 9, 1, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (10, 10, 3, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (11, 11, 2, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (12, 12, 1, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (13, 13, 2, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (14, 14, 1, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (15, 15, 3, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (16, 16, 2, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (17, 17, 1, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (18, 18, 2, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (19, 19, 1, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (20, 20, 3, 2);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (4, 15, 2, 3);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (7, 12, 1, 1);
INSERT INTO member_purchase (member_id, album_id, quantity, branch_id) VALUES (10, 8, 2, 2);

-- Sellers
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Emily', 'Wilson', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Michael', 'Anderson', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Jessica', 'Martinez', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Andrew', 'Thompson', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Rachel', 'Garcia', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Daniel', 'Rodriguez', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Lauren', 'Lee', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Kevin', 'Nguyen', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Amanda', 'Kim', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Brian', 'Chen', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Michelle', 'Wang', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Steven', 'Lopez', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Jennifer', 'Patel', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Thomas', 'Singh', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Ashley', 'White', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Robert', 'Clark', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Melissa', 'Lewis', 2);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('William', 'Hall', 3);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('Nicole', 'Young', 1);
INSERT INTO seller (first_name, last_name, branch_id) VALUES ('David', 'Walker', 2);

-- Visualización básica de las tablas
SELECT * FROM album;
SELECT * FROM branch;
SELECT * FROM gender;
SELECT * FROM member;
SELECT * FROM member_purchase;
SELECT * FROM membership_type;
SELECT * FROM seller;

-- Respuestas a: 3. SQL Queries

-- 1. Purchase Analysis
-- Total purchases and revenue per branch
-- Total de compras e ingresos por sucursal
SELECT
    b.branch_description AS branch,
    COUNT(mp.member_purchase_id) AS total_purchases,
    SUM(mp.quantity * a.price) AS total_revenue
FROM
    member_purchase mp
JOIN
    branch b ON mp.branch_id = b.branch_id
JOIN
    album a ON mp.album_id = a.album_id
GROUP BY
    b.branch_description;

-- 2. Top Purchased Albums
-- Most purchased albums with total revenue
-- Los albumes más comprados con total de ingresos
SELECT
    a.album_title AS album,
    a.artist_name AS artist,
    SUM(mp.quantity) AS total_units_sold,
    SUM(mp.quantity * a.price) AS total_revenue
FROM
    member_purchase mp
JOIN
    album a ON mp.album_id = a.album_id
GROUP BY
    a.album_id, a.album_title, a.artist_name
ORDER BY
    total_units_sold DESC;

-- 3. Member Purchase History
-- List of all purchases made by each member, grouped by membership type.
-- Lista de todas las compras realizadas por cada miembro, agrupada por tipo de membresía.
SELECT
    mt.membership_type_description AS membership_type,
    m.member_id,
    CONCAT(m.first_name, ' ', m.last_name) AS member_name,
    a.album_title AS album,
    mp.quantity AS quantity_purchased,
    (mp.quantity * a.price) AS total_spent
FROM
    member_purchase mp
JOIN
    member m ON mp.member_id = m.member_id
JOIN
    album a ON mp.album_id = a.album_id
JOIN
    membership_type mt ON m.membership_type_id = mt.membership_type_id
ORDER BY
    mt.membership_type_description,
    m.member_id;

-- 4. Branch-wise Album Sales
-- Quantity of albums sold per branch, grouped by album.
-- Cantidad de albumes vendidos por sucursal, agrupados por album
SELECT
    b.branch_description AS branch,
    a.album_title AS album,
    SUM(mp.quantity) AS total_quantity_sold
FROM
    member_purchase mp
JOIN
    branch b ON mp.branch_id = b.branch_id
JOIN
    album a ON mp.album_id = a.album_id
GROUP BY
    b.branch_description, a.album_title
ORDER BY
    b.branch_description, total_quantity_sold DESC;

-- 5. Revenue by Membership Type
-- Total revenue generated by each membership type.
-- Total de ingresos generados por cada tipo de membresia.
SELECT
    mt.membership_type_description AS membership_type,
    SUM(mp.quantity * a.price) AS total_revenue
FROM
    member_purchase mp
JOIN
    member m ON mp.member_id = m.member_id
JOIN
    membership_type mt ON m.membership_type_id = mt.membership_type_id
JOIN
    album a ON mp.album_id = a.album_id
GROUP BY
    mt.membership_type_description
ORDER BY
    total_revenue DESC;