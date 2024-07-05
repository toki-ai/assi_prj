CREATE DATABASE pizza;
USE pizza;
-- Create Customers table
CREATE TABLE Customers (
    CustomerID INT IDENTITY(1,1) PRIMARY KEY,
    Password NVARCHAR(255),
    ContactName NVARCHAR(255),
    Address NVARCHAR(255),
    Phone NVARCHAR(50)
);

-- Create Categories table
CREATE TABLE Categories (
    CategoryID INT IDENTITY(1,1) PRIMARY KEY,
    CategoryName NVARCHAR(255),
    Description NVARCHAR(MAX)
);

-- Create Suppliers table
CREATE TABLE Suppliers (
    SupplierID INT IDENTITY(1,1) PRIMARY KEY,
    CompanyName NVARCHAR(255),
    Address NVARCHAR(255),
    Phone NVARCHAR(50)
);

-- Create Products table
CREATE TABLE Products (
    ProductID INT IDENTITY(1,1) PRIMARY KEY,
    ProductName NVARCHAR(255),
    SupplierID INT,
    CategoryID INT,
    QuantityPerUnit NVARCHAR(255),
    UnitPrice FLOAT,
    ProductImage NVARCHAR(MAX),
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Create Orders table
CREATE TABLE Orders (
    OrderID INT IDENTITY(1,1) PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    RequiredDate DATE,
    ShippedDate DATE,
    Freight FLOAT,
    ShipAddress NVARCHAR(255),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Order Details table
CREATE TABLE OrderDetails (
    OrderID INT,
    ProductID INT,
    UnitPrice FLOAT,
    Quantity INT,
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Create Account table with Type reflecting roles
CREATE TABLE Account (
    AccountID INT IDENTITY(1,1) PRIMARY KEY,
    UserName NVARCHAR(255),
    Password NVARCHAR(255),
    FullName NVARCHAR(255),
    Type INT -- Type 1 for Staff, Type 2 for Normal Users
);

-- Insert data into Customers table
INSERT INTO Customers (Password, ContactName, Address, Phone) VALUES
('password123', 'John Doe', '123 Elm St', '555-1234'),
('password456', 'Jane Smith', '456 Oak St', '555-5678'),
('password789', 'Alice Johnson', '789 Oak St', '555-9012');

-- Insert data into Categories table
INSERT INTO Categories (CategoryName, Description) VALUES
('Pizza', 'Various types of pizzas'),
('Beverage', 'Soft drinks and other beverages'),
('Dessert', 'Sweet treats and desserts');

-- Insert data into Suppliers table
INSERT INTO Suppliers (CompanyName, Address, Phone) VALUES
('Pizza Supply Co', '123 Supplier St', '555-1111'),
('Beverage Supply Co', '456 Supplier Ave', '555-2222'),
('Dessert Supply Co', '789 Supplier Blvd', '555-3333');

-- Insert data into Products table
INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage) VALUES
('Margherita Pizza', 1, 1, '1 pizza', 8.99, 'https://images.ctfassets.net/nw5k25xfqsik/64VwvKFqxMWQORE10Tn8pY/200c0538099dc4d1cf62fd07ce59c2af/20220211142754-margherita-9920.jpg'),
('Pepperoni Pizza', 1, 1, '1 pizza', 9.99, 'https://againstthegraingourmet.com/cdn/shop/products/Pepperoni_Pizza_Beauty_1000x1000.jpg?v=1658703726'),
('Coke', 2, 2, '1 bottle', 1.99, 'https://ucccafe.mugengroup.ph/wp-content/uploads/sites/4/2023/09/COKE-min.jpg'),
('Diet Coke', 2, 2, '1 bottle', 1.99, 'https://www.coca-cola.com/content/dam/onexp/us/en/brands/diet-coke/en_diet%20coke_prod_caffeine%20free_diet_group_750x750.jpg'),
('Chocolate Cake', 3, 3, '1 slice', 3.99, 'https://stylesweet.com/wp-content/uploads/2022/06/ChocolateCakeForTwo_Featured.jpg'),
('Ice Cream', 3, 3, '1 scoop', 2.99, 'https://cdn.loveandlemons.com/wp-content/uploads/2023/06/homemade-ice-cream.jpg');

-- Insert data into Orders table
INSERT INTO Orders (CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES
(1, '2024-07-01', '2024-07-02', '2024-07-01', 2.50, '123 Main St'),
(2, '2024-07-02', '2024-07-03', '2024-07-02', 2.50, '456 Elm St'),
(3, '2024-07-03', '2024-07-04', '2024-07-03', 2.50, '789 Oak St');

INSERT INTO Orders (CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES
(1, '2024-06-01', '2024-06-02', '2024-06-01', 3.00, '123 Main St'),
(2, '2024-06-02', '2024-06-03', '2024-06-02', 3.00, '456 Elm St'),
(3, '2024-06-03', '2024-06-04', '2024-06-03', 3.00, '789 Oak St');


INSERT INTO Orders (CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES
(1, '2024-07-06', '2024-07-07', '2024-07-06', 2.75, '123 Main St'),
(2, '2024-07-06', '2024-07-07', '2024-07-06', 2.75, '456 Elm St'),
(3, '2024-07-06', '2024-07-07', '2024-07-06', 2.75, '789 Oak St');

-- Insert data into Order Details table
INSERT INTO OrderDetails (OrderID, ProductID, UnitPrice, Quantity) VALUES
(1, 1, 8.99, 2),
(1, 3, 1.99, 3),
(2, 2, 9.99, 1),
(2, 4, 1.99, 2),
(3, 1, 8.99, 1),
(3, 5, 3.99, 2);

-- Insert data into Account table
INSERT INTO Account (UserName, Password, FullName, Type) VALUES
('admin', '123', 'Admin', 1),
('johndoe', 'password123', 'John Doe', 2),
('janesmith', 'password456', 'Jane Smith', 2),
('alicejohnson', 'password789', 'Alice Johnson', 2); 
