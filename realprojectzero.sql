--This schema will represent my real Project Zero for my presentation. 
/* For my presentation, I am going to be working on a library management system WHERE
you can KEEP track OF the person checking OUT a book, the book AND it's ATTRIBUTES, AND the checkouts made */

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	full_name TEXT GENERATED ALWAYS AS (first_name || ' ' || last_name) STORED
	
);
--We are creating the user here

INSERT INTO users (first_name, last_name, email)
VALUES ('John','Smith','johnsmith@gmail.com'),('Patrick','Johnson','patrickjohnson1@hotmail.com'),
('Akshat','Patel','akshatpatel1@gmail.com'),('Rahul','Sharma','rahulsharma5@gmail.com');

SELECT * FROM users;


CREATE TABLE books (
	book_id serial PRIMARY KEY,
	title TEXT NOT NULL,
	genre TEXT NOT NULL,
	author TEXT NOT NULL
);

INSERT INTO books (title, genre, author)
VALUES ('1984','dystopian fiction','George Orwell'),('The Chamber of Secrets','fantasy literature','JK Rowling'),
('Lord of the Flies','allegorical fiction','William Golding'),('The Great Gatsby','tragedy','F Scott Fitzgerald');
--We are assigning values to the books

SELECT * FROM books;

CREATE TABLE checkouts (
	checkout_id serial PRIMARY KEY,
	book_id int,
	user_id int,
	checkout_date DATE,
	return_date DATE,
	FOREIGN KEY (book_id) REFERENCES books(book_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);
INSERT INTO checkouts (book_id, user_id, checkout_date, return_date)
VALUES (1,1,'2024-10-15','2024-11-20'),
(2,2,'2024-10-10','2024-11-30'),
(3,3,'2024-10-01','2024-11-15'),
(4,4,'2024-09-25','2024-10-30')
;

SELECT * FROM checkouts;


