create database bai_tap_noname;
use bai_tap_noname;
create table Product(
	id int auto_increment primary key,
    productCode varchar(10),
    productName varchar(50),
    productPrice double,
    productAmount int,
    productDescription varchar(200),
    productStatus varchar(100)
);
insert into Product(productCode ,productName,productPrice, productAmount, productDescription, productStatus) 
values('54553144','xe dap',2000000,20,'nhieu mau, xe chinh hang','con hang'),
('c515456','xe may',40000000,15,'Max speed: 100km/h','con hang');

-- 1.tạo unique index trên cột productCode
create unique index idx_productCode on Product(productCode);
-- 2.Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index idx_productName_price on Product(productname, productPrice);
-- 3.Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from product where productname = 'xe dap';
-- 4.So sánh câu truy vấn trước và sau khi tạo index
-- 5. Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view ProductView as
select productCode, productName, productPrice, productStatus
from product;
-- 6. Tiến hành sửa đổi view
create or replace view productView as
select productCode, productname, productPrice, productStatus, productDescription 
FROM Product;
-- 7. Tiến hành xoá view
drop view if exists productView;
-- 8. Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure getAllProduct()
begin
	select * from product;
end //
delimiter ;
call getAllProduct;
-- 9. Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure addProduct(
	IN in_id INT,
    IN in_productCode VARCHAR(10),
    IN in_productName VARCHAR(50),
    IN in_productPrice DOUBLE,
    IN in_productAmount INT,
    IN in_productDescription VARCHAR(200),
    IN in_productStatus VARCHAR(100)
)
begin 
	insert into Product(productCode, productName, productPrice, productAmount, productDescription, productStatus)
    value (in_productCode, in_productName, in_productPrice, in_productAmount, in_productDescription, in_productStatus);
end //
delimiter ;    

call updateProduct(2,6666,'xe oto', 5000000000,10,'lamborghini','mau đen, phiên bản giới hạn');
-- 10. Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
CREATE PROCEDURE UpdateProduct(
    IN in_id INT,
    IN in_productCode VARCHAR(10),
    IN in_productName VARCHAR(50),
    IN in_productPrice DOUBLE,
    IN in_productAmount INT,
    IN in_productDescription VARCHAR(200),
    IN in_productStatus VARCHAR(100)
)
BEGIN
    UPDATE Product
    SET productCode = in_productCode,
        productName = in_productName,
        productPrice = in_productPrice,
        productAmount = in_productAmount,
        productDescription = in_productDescription,
        productStatus = in_productStatus
    WHERE id = in_id;
END //
delimiter ;
select * from Product;
-- 11. Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure deleteProduct(
	in_id int
)
begin
	delete from Product where id = in_id;
end //
delimiter ;