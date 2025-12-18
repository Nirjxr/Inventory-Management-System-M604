# Inventory-Management-System-M604
Inventory Management System with Java Spring Boot
Inventory Management System using Java Spring Boot

Overview:
This is a backend Inventory Management System built with Java Spring Boot. 
It allows managing products, suppliers, and stock transactions with full CRUD operations. 
The system integrates with a SQL database and provides RESTful APIs to interact with the data.

Features:
- Add, update, delete, and view products
- Manage multiple suppliers
- Record stock transactions (in/out) with details and dates
- REST API endpoints for easy interaction
- Error handling with global exception management
- Transactional stock updates to maintain consistency

Database:
- Tables: Product, Supplier, StockTransaction
- Relationships: Product -> Supplier (Many-to-One), StockTransaction -> Product (Many-to-One)

API Endpoints:
- GET /products : List all products
- POST /products : Add new product
- PUT /products/{id} : Update product
- GET /stocktransactions : List all stock transactions

Demo Video:
A 5-minute video demonstrating the project is available here:(https://drive.google.com/file/d/1KKiW_iP-gqU7UqPekjDTWxlKxT9Ew1xO/view?usp=sharing)

How to Run:
1. Clone the repository
2. Configure your SQL database in application.properties
3. Run the Spring Boot application using Maven




