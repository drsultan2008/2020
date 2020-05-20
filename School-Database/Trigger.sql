use `tea03`;

delimiter //
DROP TRIGGER CheckOdd ;
CREATE TRIGGER CheckOdd BEFORE INSERT ON Employee
    FOR EACH ROW
    BEGIN
            IF (timestampdiff(year,New.birthday,now()) < 18) THEN
            CALL `Insert not allowed`;
        END IF;
    END;
//Voucher
delimiter ; 