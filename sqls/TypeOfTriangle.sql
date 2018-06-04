/*
    https://www.hackerrank.com/challenges/what-type-of-triangle/problem
*/

SELECT CASE
            when A = B && B = C THEN 'Equilateral'
            when A >= B + C || B >= A + C || C >= A + B THEN 'Not A Triangle'
            when  A = B || C = B || A = C THEN 'Isosceles'
            when A != B && B != C && A !=C THEN 'Scalene'
        END
FROM TRIANGLES
