use `tea03`;

-- SELECT Tea.name,TeaBill.amount,Bill.time FROM Tea LEFT JOIN TeaBill ON Tea.id = TeaBill.teaId LEFT JOIN Bill ON TeaBill.billId = Bill.id WHERE Bill.time LIKE '25/04/2020' ORDER BY TeaBill.amount DESC LIMIT 1;

-- Đưa ra sản phẩm đắt nhất hay rẻ nhất của cửa hàng.
-- SELECT * FROM Tea ORDER By price DESC LIMIT 1;
-- SELECT * FROM Tea ORDER By price LIMIT 1;

-- Đưa ra thông tin chi tiết của một sản phẩm.
-- SELECT * FROM Tea WHERE name LIKE 'Tra Sua Khoai Mon' OR id = 5;

-- Đưa ra sản phẩm bán chạy nhất trong tháng N.
-- SELECT * FROM Tea LEFT JOIN TeaBill ON TeaBill.teaId = Tea.id LEFT JOIN Bill ON Bill.id = TeaBill.billId WHERE MONTH(Bill.time) = 6 ORDER BY TeaBill.amount DESC LIMIT 1;

-- Đưa ra số lượng bán của một sản phẩm cụ thể nào đó.
-- SELECT SUM(TeaBill.amount) AS AMOUNT FROM Tea LEFT JOIN TeaBill ON TeaBill.teaId = Tea.id WHERE Tea.name LIKE 'Tra Sua Khoai Mon';

-- Tính tổng tiền một hóa đơn nào đó.
-- SELECT Tea.name,TeaBill.amount,TeaBill.amount*Tea.price FROM Bill LEFT JOIN TeaBill ON TeaBill.billId = Bill.id LEFT JOIN Tea ON Tea.id = TeaBill.teaId WHERE Bill.id = 20;
-- SELECT ToppingBill.amount*Topping.price FROM Bill LEFT JOIN ToppingBill ON ToppingBill.billId = Bill.id LEFT JOIN Topping ON Topping.id = ToppingBill.toppingId WHERE ToppingBill.billId = 20;

-- Tổng hợp các thức uống và số lượng bán ra trong khoảng thời gian cụ thể.
-- SELECT Tea.name,TeaBill.amount,Bill.time FROM Tea LEFT JOIN TeaBill ON TeaBill.teaId= Tea.id LEFT JOIN Bill ON Bill.id = TeaBill.billId WHERE Bill.time >= DATE('2020-05-14') AND Bill.time <=DAte('2020-05-15');

-- Đưa ra danh sách khách hàng có sinh nhật dd/mm

-- SELECT * FROM Customer WHERE MONTH(birthday) = MONTH(DATE('2020-03-02')) AND DAY(birthday) = DAY(DATE('2020-03-02'));

-- Đưa ra đồ uống yêu thích của một khách hàng.
-- SELECT Customer.name,Tea.name FROM Customer LEFT JOIN Bill ON Bill.customerId = Customer.phone LEFT JOIN TeaBill ON TeaBill.billId = Bill.id LEFT JOIN Tea ON Tea.id = TeaBill.teaId WHERE phone = 990168754 ORDER BY TeaBill.amount DESC LIMIT 1;

-- Đưa ra danh sách các đồ uống có chứa một topping A nào đó.
-- SELECT * FROM Tea CROSS JOIN Topping;

-- Lấy ra danh sách các chương trình khuyến mãi trong ngày.
-- SELECT * FROM Voucher WHERE time <= DATE('2020-05-19');

-- Tính độ tuổi trung bình của khách hàng.
-- SELECT ROUND(AVG(timestampdiff(year,birthday,NOW())),0) FROM Customer;

-- Đưa ra sinh nhật của nhân viên trong ngày.
-- SELECT * FROM Employee WHERE DAY(birthday) = DAY(DATE('2020-02-03')) AND MONTH(birthday) = MONTH(DATE('2020-02-03'));

-- Thống kê doanh thu cửa hàng trong ngày.
-- SELECT * FROM Bill LEFT JOIN TeaBill ON TeaBill.billId = Bill.id LEFT JOIN ToppingBill ON ToppingBill.billId = Bill.id WHERE Bill.time = DATE('2020-05-12');

-- Thông tin của một khách hàng hoặc nhân viên cụ thể.
-- SELECT * FROM Customer WHERE name LIKE 'Pham Duc Manh';
-- SELECT * FROM Employee WHERE name LIKE 'Pham Thi thu Hien' OR id = 2;

-- Đưa ra các đồ uống còn bán ở cửa hàng.
-- SELECT * FROM Tea WHERE status = 1;