/*
Enter your query here.
https://www.hackerrank.com/challenges/the-blunder/problem
*/


select  CEILING(avg(Salary) - AVG(CAST(REPLACE(CAST(Salary AS CHAR), "0", "") AS BINARY)))  from EMPLOYEES
