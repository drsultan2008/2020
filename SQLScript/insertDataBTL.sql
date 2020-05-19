use tea03

set identity_insert Customer on
insert into Customer
(phone,name,level)
values
(0985166754,'Trinh Thi Thu Thuy',1),
(0885168754,'Pham Duc Manh',0),
(0985138754,'Dinh Thu Hoai',2),
(0985368754,'Chu Nguyen Chuong',1),
(0985668754,'Le Van Hanh',0),
(0355168754,'Cao Quoc Toan',1),
(0148516875,'Tran Thi Thu Trang',3),
(0385168754,'Nguyen Quoc Toan',2),
(0945168754,'Trinh Thi Hien',1),
(0355568754,'Ly Thi Huong',0),
(0985168754,'Le Thi Chien',0),
(0979168754,'Dinh Quang Khang',2),
(0907168754,'Nguyen Thi Huyen',1),
(0990168754,'Can Thi Gio',0),
(0346168754,'Ly Cao Hai',1),
(0901168754,'Pham Thi Thu',2);
set identity_insert Customer off

select * from Customer
-------------------------------------------------------------------

set identity_insert Employee on
insert into Employee
(id,phone,name,birthday,timeWork,[level],[address],avatar)
values
(1,0356978432,'Nguyen Thi Huyen Trang','17/05/1995',6,2,'Nam Dinh','urlTrang'),
(2,0125415779,'Dinh Van Hoang','11/09/2000',5,1,'Ninh Binh','urlHoang'),
(3,0257978732,'Tran Dinh Trong','15/02/1997',8,3,'Thai Binh','urlTrong'),
(4,0474362332,'Ly Quoc Khanh','09/03/1998',9,3,'Hai Duong','urlKhanh'),
(5,0558978567,'Trinh Ai Hong','26/08/1992',12,4,'Ha Noi','urlHong'),
(6,0691968432,'Le Thu Thuy','10/10/1996',6,2,'Bac Giang','urlThuy'),
(7,0756956490,'Chau Viet Cuong','31/12/1999',8,2,'Ninh Binh','urlCuong'),
(8,0886324562,'Tran Thi Thu Trang','17/11/2000',6,2,'Ha Nam','urlTrang'),
(9,0979953261,'Trinh Thi Hien','22/02/1991',4,2,'Nam Dinh','urlHien'),
(10,010124126,'Nguyen Van Cuong','09/05/1990',9,2,'Nghe An','urlCuong'),
(11,011625371,'Nguyen Quoc Truong','06/06/1994',10,2,'Phu Tho','urlTruong'),
(12,012625272,'Tran Van Duy','12/09/1998',11,2,'Thai Binh','urlDuy'),
(13,013462760,'Le Minh Hai','15/05/1992',8,2,'Hai Duong','urlHai'),
(14,014095404,'Do Duc Manh','25/12/1998',8,2,'Ninh Binh','urlManh'),
(15,015394620,'Do Thu Quynh','19/07/2000',8,2,'Ha Noi','urlQuynh'),
(16,016385232,'Nguyen Kim Tuyen','11/11/1991',8,2,'Ha Noi','urlTuyen');
set identity_insert Employee off
select * from Employee

----------------------------------------------------------------------------

set identity_insert [Resource] on
insert into [Resource]
(id,[date],amount)
values
(1,'12/04/2020',100),
(2,'12/04/2020',100),
(3,'12/04/2020',100),
(4,'12/04/2020',100),
(5,'25/06/2020',50),
(6,'25/06/2020',50),
(7,'31/07/2020',120),
(8,'31/07/2020',120),
(9,'31/07/2020',120),
(10,'10/09/2020',200),
(11,'10/09/2020',200),
(12,'12/11/2020',150),
(13,'12/11/2020',150),
(14,'12/11/2020',150),
(15,'22/12/2020',100),
(16,'22/12/2020',100);
set identity_insert [Resource] off
select * from [Resource]

-------------------------------------------------------------------

set identity_insert Tea on
insert into Tea
(id,name,price,status)
values
(1,'Tra Sua Tran Chau Trang',30000,1),
(2,'Tra Sua Oreo Cake Cream',35000,0),
(3,'Tra Sua Tran Chau Duong Den',30000,0),
(4,'Tra Xoai Kem Cheese',40000,1),
(5,'Tra Sua Khoai Mon',25000,1),
(6,'Tra Sua Matcha Dau Do',30000,1),
(7,'Tra Sua Oreo Chocolate Cream',45000,0),
(8,'Tra Sua Pudding Dau Do',50000,1),
(9,'Tra Sua Tran Chau Den',30000,1),
(10,'Tra Sua Suong Sao',35000,1),
(11,'Tra Sua Earl Grey',40000,0),
(12,'Tra Sua Caramel',35000,1),
(13,'Tra Sua Ca Phe',30000,1),
(14,'Luc Tra Sua',50000,1),
(15,'Tra Sua Chese Milk Foam',40000,1);
set identity_insert Tea off
select * from Tea


------------------------------------------------------------

set identity_insert Topping on
insert into Topping
(id,price)
values
(1,5000),
(2,6000),
(3,5000),
(4,7000),
(5,8000),
(6,6000),
(7,5000),
(8,8000),
(9,5000),
(10,7000),
(11,7000),
(12,6000),
(13,5000),
(14,5000),
(15,5000),
(16,7000);
set identity_insert Topping off
select * from Topping


----------------------------------------------------------
set identity_insert Voucher on
insert into Voucher
(code,[percent],[time],phoneNumber)
values
(1,0.5,'22/12/2020',0148516875),
(2,0.3,'10/09/2020',0346168754),
(3,0.2,'11/12/2020',0990168754),
(4,0.2,'08/09/2020',0985668754),
(5,0.3,'15/10/2020',0985138754),
(6,0.4,'19/11/2020',0979168754),
(7,0.3,'25/08/2020',0907168754),
(8,0.1,'25/10/2020',0985668754),
(9,0.25,'11/12/2020',0385168754),
(10,0.35,'11/12/2020',0885168754);
set identity_insert Voucher off
select * from Voucher

---------------------------------------------------------

insert into TeaTopping
(teaId,toppingId)
values
(1,2),
(2,1),
(1,5),
(3,6),
(2,7),
(8,12),
(6,11),
(5,9),
(3,10),
(8,8),
(7,13);
select * from TeaTopping

-----------------------------------------------------
insert into TeaResource
(teaId,resourceId,amount)
values
(1,7,10),
(2,10,5),
(5,12,15),
(4,2,12),
(5,7,8),
(8,9,13),
(6,11,10),
(2,9,5),
(5,6,15),
(9,14,10),
(3,4,10),
(1,3,12);
select * from TeaResource

----------------------------------------------------------
set identity_insert Bill on
insert into Bill
(id,[time],employeeId,customerId,codeVoucher)
values
(1,'12/01/2019',1,0148516875,1),
(2,'25/02/2019',1,0346168754,5),
(3,'05/02/2020',2,0355168754,1),
(4,'31/03/2020',5,0355568754,6),
(5,'24/04/2020',8,0385168754,2),
(6,'25/04/2020',9,0979168754,4),
(7,'25/04/2020',7,0985138754,10),
(8,'10/05/2020',5,0985166754,2),
(9,'10/05/2020',4,0985168754,2),
(10,'20/06/2020',9,0985368754,3),
(11,'25/10/2020',7,0985668754,4),
(12,'25/10/2020',8,0990168754,5);
set identity_insert Bill off
select * from Bill

--------------------------------------------------------
insert into TeaBill
(teaId,billId,amount,price)
values
(1,1,3,105000),
(2,3,5,200000),
(4,2,2,80000),
(5,6,1,30000),
(7,5,2,100000),
(8,10,3,90000),
(3,3,4,100000),
(11,3,1,35000),
(5,10,2,60000),
(4,7,5,180000),
(7,12,2,60000),
(15,3,5,250000);
-- select * from TeaBill

select * from Tea
select * from Bill