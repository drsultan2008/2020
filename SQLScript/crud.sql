use `tea03`;
-- DELETE FROM Employee WHERE id = 2;
-- UPDATE Employee 
-- SET id = 1
-- WHERE id = 2;

-- INSERT INTO Employee VALUES 
-- -- 	(1,392301017,'Le Quang Duy',DATE('2000-02-03'),0,'Tech Lead','Ninh Binh','urlDuy');
-- 	(5,392301017,'Pham Thi thu Hien ',DATE('2000-12-22'),0,'Doctor','Ninh Binh','urlHien');

-- INSERT INTO Customer VALUE
-- 	(0,'Obama',0);
-- 	

-- INSERT INTO Voucher
-- VALUES (2,1.1,'010101',1);

-- insert into Customer
-- (phone,name,level)
-- VAlUES
-- (0985166754,'Trinh Thi Thu Thuy',1),
-- (0885168754,'Pham Duc Manh',0),
-- (0985138754,'Dinh Thu Hoai',2),
-- (0985368754,'Chu Nguyen Chuong',1),
-- (0985668754,'Le Van Hanh',0),
-- (0355168754,'Cao Quoc Toan',1),
-- (0148516875,'Tran Thi Thu Trang',3),
-- (0385168754,'Nguyen Quoc Toan',2),
-- (0945168754,'Trinh Thi Hien',1),
-- (0355568754,'Ly Thi Huong',0),
-- (0985168754,'Le Thi Chien',0),
-- (0979168754,'Dinh Quang Khang',2),
-- (0907168754,'Nguyen Thi Huyen',1),
-- (0990168754,'Can Thi Gio',0),
-- (0346168754,'Ly Cao Hai',1),
-- (0901168754,'Pham Thi Thu',2);

-- insert into Employee
-- (id,phone,name,birthday,timeWork,level,address,avatar)
-- values
-- (1,0356978432,'Nguyen Thi Huyen Trang',DATE('1995-05-17'),6,2,'Nam Dinh','urlTrang'),
-- (2,0125415779,'Dinh Van Hoang',DATE('2000-09-11'),5,1,'Ninh Binh','urlHoang'),
-- (3,0257978732,'Tran Dinh Trong',DATE('1997-02-15'),8,3,'Thai Binh','urlTrong'),
-- (4,0474362332,'Ly Quoc Khanh',DATE('1998-03-09'),9,3,'Hai Duong','urlKhanh'),
-- (5,0558978567,'Trinh Ai Hong',DATE('1992-08-26'),12,4,'Ha Noi','urlHong'),
-- (6,0691968432,'Le Thu Thuy',DATE('1996-10-10'),6,2,'Bac Giang','urlThuy'),
-- (7,0756956490,'Chau Viet Cuong',DATE('1999-12-31'),8,2,'Ninh Binh','urlCuong'),
-- (8,0886324562,'Tran Thi Thu Trang',DATE('2000-11-17'),6,2,'Ha Nam','urlTrang'),
-- (9,0979953261,'Trinh Thi Hien',DATE('1991-02-22'),4,2,'Nam Dinh','urlHien'),
-- (10,010124126,'Nguyen Van Cuong',DATE('1990-05-09'),9,2,'Nghe An','urlCuong'),
-- (11,011625371,'Nguyen Quoc Truong',DATE('1994-06-06'),10,2,'Phu Tho','urlTruong'),
-- (12,012625272,'Tran Van Duy',DATE('1998-09-12'),11,2,'Thai Binh','urlDuy'),
-- (13,013462760,'Le Minh Hai',DATE('1992-05-15'),8,2,'Hai Duong','urlHai'),
-- (14,014095404,'Do Duc Manh',DATE('1998-12-25'),8,2,'Ninh Binh','urlManh'),
-- (15,015394620,'Do Thu Quynh',DATE('2000-07-19'),8,2,'Ha Noi','urlQuynh'),
-- (16,016385232,'Nguyen Kim Tuyen',DATE('1991-11-11'),8,2,'Ha Noi','urlTuyen');

-- insert into Resource
-- (id,date,amount)
-- values
-- (1,DATE('2020-04-12'),100),
-- (2,DATE('2020-04-12'),100),
-- (3,DATE('2020-04-12'),100),
-- (4,DATE('2020-04-12'),100),
-- (5,DATE('2020-06-25'),50),
-- (6,DATE('2020-06-25'),50),
-- (7,DATE('2020-07-31'),120),
-- (8,DATE('2020-07-31'),120),
-- (9,DATE('2020-07-31'),120),
-- (10,DATE('2020-09-10'),200),
-- (11,DATE('2020-09-10'),200),
-- (12,DATE('2020-11-12'),150),
-- (13,DATE('2020-11-12'),150),
-- (14,DATE('2020-11-12'),150),
-- (15,DATE('2020-11-22'),100),
-- (16,DATE('2020-11-22'),100);

-- insert into Tea
-- (id,name,price,status)
-- values
-- (1,'Tra Sua Tran Chau Trang',30000,1),
-- (2,'Tra Sua Oreo Cake Cream',35000,0),
-- (3,'Tra Sua Tran Chau Duong Den',30000,0),
-- (4,'Tra Xoai Kem Cheese',40000,1),
-- (5,'Tra Sua Khoai Mon',25000,1),
-- (6,'Tra Sua Matcha Dau Do',30000,1),
-- (7,'Tra Sua Oreo Chocolate Cream',45000,0),
-- (8,'Tra Sua Pudding Dau Do',50000,1),
-- (9,'Tra Sua Tran Chau Den',30000,1),
-- (10,'Tra Sua Suong Sao',35000,1),
-- (11,'Tra Sua Earl Grey',40000,0),
-- (12,'Tra Sua Caramel',35000,1),
-- (13,'Tra Sua Ca Phe',30000,1),
-- (14,'Luc Tra Sua',50000,1),
-- (15,'Tra Sua Chese Milk Foam',40000,1);

-- insert into Topping
-- (id,price)
-- values
-- (1,5000),
-- (2,6000),
-- (3,5000),
-- (4,7000),
-- (5,8000),
-- (6,6000),
-- (7,5000),
-- (8,8000),
-- (9,5000),
-- (10,7000),
-- (11,7000),
-- (12,6000),
-- (13,5000),
-- (14,5000),
-- (15,5000),
-- (16,7000);

-- insert into Voucher
-- (code,percent,time,phoneNumber)
-- values
-- (1,1,DATE('2020-12-22'),985166754),
-- (3,0.2,DATE('2020-11-22'),985138754),
-- (4,0.2,DATE('2020-05-19'),985368754),
-- (5,0.3,DATE('2020-05-30'),985668754),
-- (7,0.3,DATE('2020-05-08'),148516875),
-- (8,0.1,DATE('2020-05-19'),385168754),
-- (9,0.25,DATE('2020-05-19'),385168754),
-- (10,0.35,DATE('2020-05-19'),385168754);

-- insert into TeaTopping
-- (teaId,toppingId)
-- values
-- (1,2),
-- (2,1),
-- (1,5),
-- (3,6),
-- (2,7),
-- (8,12),
-- (6,11),
-- (5,9),
-- (3,10),
-- (8,8),
-- (7,13);

-- insert into TeaResource
-- (teaId,resourceId,amount)
-- values
-- (1,7,10),
-- (2,10,5),
-- (5,12,15),
-- (4,2,12),
-- (5,7,8),
-- (8,9,13),
-- (6,11,10),
-- (2,9,5),
-- (5,6,15),
-- (9,14,10),
-- (3,4,10),
-- (1,3,12);

-- insert into Bill
-- (id,time,employeeId,customerId,codeVoucher)
-- values
-- (1,DATE('2020-05-12'),1,0148516875,1),
-- (2,DATE('2020-05-13'),1,0346168754,5),
-- (3,DATE('2020-05-14'),2,0355168754,1),
-- (4,DATE('2020-05-12'),5,0355568754,7),
-- (5,DATE('2020-05-13'),8,0385168754,5),
-- (6,DATE('2020-05-14'),9,0979168754,4),
-- (7,DATE('2020-05-15'),7,0985138754,10),
-- (8,DATE('2020-05-15'),5,0985166754,1),
-- (9,DATE('2020-05-12'),4,0985168754,1),
-- (10,DATE('2020-05-15'),9,0985368754,3),
-- (11,DATE('2020-05-17'),7,0985668754,4),
-- (12,DATE('2020-05-20'),8,0990168754,5);

-- insert into TeaBill
-- (teaId,billId,amount,price)
-- values
-- (1,1,3,105000),
-- (2,3,5,200000),
-- (4,2,2,80000),
-- (5,6,1,30000),
-- (7,5,2,100000),
-- (8,10,3,90000),
-- (3,3,4,100000),
-- (11,3,1,35000),
-- (5,10,2,60000),
-- (4,7,5,180000),
-- (7,12,2,60000),
-- (15,3,5,250000);

-- INSERT INTO ToppingBill 
-- VALUES
-- 	(2,20,1);

-- UPDATE Customer
-- SET birthday = DATE('2000-03-02')
-- WHERE phone = 148516875 OR phone = 355168754;

-- ALTER TABLE Topping
-- ADD COLUMN name varchar(50) DEFAULT NULL;

-- UPDATE Topping
-- SET name = 'Tran chau'
-- WHERE id = 1;

-- UPDATE Topping
-- SET name = 'Nhan Dua'
-- WHERE id = 2;

-- UPDATE Topping
-- SET name = 'Nhan Sam'
-- WHERE id = 3;

-- UPDATE Topping
-- SET name = 'Qua dao'
-- WHERE id = 4;

-- UPDATE Topping
-- SET name = 'Dua chuot'
-- WHERE id = 5;

-- UPDATE Topping
-- SET name = 'Mat ong'
-- WHERE id = 6;

-- UPDATE Topping
-- SET name = 'Cocacola'
-- WHERE id = 7;

-- UPDATE Topping
-- SET name = 'Socola'
-- WHERE id = 8;

-- UPDATE Topping
-- SET name = 'Tequyla'
-- WHERE id = 9;

-- UPDATE Topping
-- SET name = 'Qua nhot'
-- WHERE id = 10;

-- UPDATE Topping
-- SET name = 'Vi qua chanh'
-- WHERE id = 11;

-- UPDATE Topping
-- SET name = 'Vi qua sau rieng'
-- WHERE id = 12;

-- UPDATE Topping
-- SET name = 'Nhan hat dieu'
-- WHERE id = 13;

-- UPDATE Topping
-- SET name = 'Nhan qua nhot'
-- WHERE id = 14;

-- UPDATE Topping
-- SET name = 'Vi valy'
-- WHERE id = 15;

-- UPDATE Topping
-- SET name = 'Vi la ngon'
-- WHERE id = 16;

-- UPDATE Customer
-- SET birthday = DATE('2010-05-05')
-- WHERE phone = 979168754;