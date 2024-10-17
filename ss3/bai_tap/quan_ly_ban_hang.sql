create database thao_tac_quan_ly_ban_hang;
use thao_tac_quan_ly_ban_hang;
create table Customer(
	id int primary key auto_increment,
    name varchar(50) not  null,
    age int 
);
create table Product(
	id int primary key auto_increment,
    name varchar(50),
    price double
);
create table `Order`(
	id int primary key auto_increment,
    Customer_id int,
    `date` date,
    TotalPrice double,
	CONSTRAINT FK_Customer foreign key(Customer_id) references Customer(id)  ON DELETE CASCADE
);

create table OrderDetail(
    Order_id int,
    Product_id int,
    Quantity float,
	primary key (Order_id, Product_id) ,
    CONSTRAINT FK_Order foreign key (Order_id) references `Order`(id) ON DELETE CASCADE,
     CONSTRAINT FK_Product FOREIGN KEY(Product_id) references Product(id)
);
insert into Customer(name, age)
values('Minh Quan',10),('Ngoc Oanh',20),('Hong Ha',50);
insert into `Order`(Customer_id, date,totalPrice)
values(1,'2006-3-21',Null),(2,'2006-3-23',Null),(1,'2006-3-16',Null);

insert into Product(name,price)
values ('May Giat',3),('Tu Lanh',5),('Dieu Hoa',7),('Quat',1),('Bep Dien',2);
insert into OrderDetail(Order_id, Product_id, quantity)
values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select id  Orderid, `date` Orderdate, totalPrice Orderprice
from `Order`;
-- show danh sách các khách đã mua hàng, và ds sản phẩm được mua bởi các khách

select Customer.name as CustomerName, Product.name ProductName
from Custommer C
join `Order` on C.id = O.Customer_id
join orderDetail on O.id = OD.order_id
join Product on OD.Product_id = P.id
order by Customer.id;  

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT C.name
FROM   Customer C
LEFT JOIN `Order` O ON C.id = O.Customer_id
WHERE O.customer_id IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = quantity*price
SELECT o.id AS Order_ID, 
       o.date AS Order_Date, 
       SUM(od.Quantity * p.price) AS Total_Amount
FROM `Order` o
JOIN OrderDetail od ON o.id = od.Order_id
JOIN Product p ON od.Product_id = p.id
GROUP BY o.id;
