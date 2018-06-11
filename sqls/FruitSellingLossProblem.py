
/*
Enter your query here.
Please append a semicolon ";" at the end of the query

Tables creation and data inserts queries for the reference:

CREATE TABLE Fruits
(
    id   SMALLINT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL
);
INSERT INTO fruits VALUES
(1,'Apple'
 );
INSERT INTO fruits VALUES
(2,'Mango'
 );
INSERT INTO fruits VALUES
(3,'Guava'
 );
CREATE TABLE FruitCosts
(
    fruitid SMALLINT REFERENCES fruits(id), --foreign key to fruits.id
Cost  SMALLINT NOT NULL,
                   YEAR  SMALLINT NOT NULL,
                                      MONTH SMALLINT NOT NULL
);
INSERT INTO FruitCosts VALUES
(1,10,2017,1
 );
INSERT INTO FruitCosts VALUES
(1,11,2017,2
 );
INSERT INTO FruitCosts VALUES
(1,12,2017,3
 );
INSERT INTO FruitCosts VALUES
(1,9,2017,4
 );
INSERT INTO FruitCosts VALUES
(1,13,2017,5
 );
INSERT INTO FruitCosts VALUES
(1,13,2017,6
 );
INSERT INTO FruitCosts VALUES
(2,20,2017,1
 );
INSERT INTO FruitCosts VALUES
(2,21,2017,2
 );
INSERT INTO FruitCosts VALUES
(2,22,2017,3
 );
INSERT INTO FruitCosts VALUES
(2,19,2017,4
 );
INSERT INTO FruitCosts VALUES
(2,23,2017,5
 );
INSERT INTO FruitCosts VALUES
(2,23,2017,6
 );
INSERT INTO FruitCosts VALUES
(3,20,2017,4
 );
CREATE TABLE FruitTransactions
(
    TransactionId SMALLINT PRIMARY KEY,
                                   FruitId       SMALLINT REFERENCES fruits(id), --foreign key to fruits.id
YEAR     SMALLINT NOT NULL,
                      MONTH    SMALLINT NOT NULL,
                                            DAY      SMALLINT NOT NULL,
                                                                  quantity SMALLINT NOT NULL, --the number of fruits sold, such as 10
totalAmountPaid SMALLINT NOT NULL --the total paid by the customer combined, such as 50 if it was 10 fruits at 5 each.
);
INSERT INTO FruitTransactions VALUES
(1,1,2017,2,1,20,50
 );
INSERT INTO FruitTransactions VALUES
(2,2,2017,3,1,20,50
 );
INSERT INTO FruitTransactions VALUES
(3,2,2017,1,1,20,50
 );
INSERT INTO FruitTransactions VALUES
(4,1,2017,4,1,20,50
 );
INSERT INTO FruitTransactions VALUES
(5,1,2017,5,1,20,50
 );
INSERT INTO FruitTransactions VALUES
(6,1,2017,2,1,20,55
 );
INSERT INTO FruitTransactions VALUES
(7,2,2017,1,1,15,50
 );
INSERT INTO FruitTransactions VALUES
(8,2,2017,1,1,10,50
 );
INSERT INTO FruitTransactions VALUES
(9,2,2017,1,1,10,50
 );
INSERT INTO FruitTransactions VALUES
(10,2,2017,1,1,10,50
 );
INSERT INTO FruitTransactions VALUES
(11,2,2017,1,1,10,50
 );
INSERT INTO FruitTransactions VALUES
(12,1,2017,2,1,20,55
 );
INSERT INTO FruitTransactions VALUES
(13,1,2017,2,1,20,55
 );
INSERT INTO FruitTransactions VALUES
(14,1,2017,2,1,20,55
 );
INSERT INTO FruitTransactions VALUES
(15,3,2017,4,1,20,55
 );
INSERT INTO FruitTransactions VALUES
(16,3,2017,4,1,15,50
 );
*/

select f.name, ft.YEAR, ft.MONTH, count(ft.TransactionId), sum(ft.quantity), sum(ft.totalAmountPaid - fc.Cost * ft.quantity)
from FruitTransactions ft
join
FruitCosts fc
on ft.FruitId = fc.fruitid and ft.YEAR = fc.YEAR and ft.MONTH = fc.MONTH
join
Fruits f
on fc.fruitid = f.id
where (ft.totalAmountPaid - fc.Cost * ft.quantity) < 0
group by ft.FruitId, ft.YEAR, ft.MONTH
having count(*) >= 5
