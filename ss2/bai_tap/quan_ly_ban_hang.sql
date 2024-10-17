create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table Customer(
	id int primary key,
    name varchar(50) not  null,
    age int 
);
create table product(
	id int primary key,
    name varchar(50),
    price double
);
create table `Order`(
	id int primary key,
    Customer_id int,
    `date` date,
    TotalPrice double,
	CONSTRAINT FK_Customer foreign key(Customer_id) references Customer(id)  ON DELETE CASCADE
);

create table OrderDetail(
    Order_id int,
    Product_id int,
    Quantity float,
	primary key (Order_id, Product_id),
    CONSTRAINT FK_Order foreign key (Order_id) references `Order`(id) ON DELETE CASCADE,
     CONSTRAINT FK_Product FOREIGN KEY(Product_id) references Product(id)
);
