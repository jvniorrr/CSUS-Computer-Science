/* CHAPTER 9 SUBQUERIES

Ex 9A
-- drop and create patient table, disease table, and patient_disease table
DROP TABLE mendo_patient_disease;
DROP TABLE mendo_patient;
CREATE TABLE mendo_Patient (
    Patient_id      NUMBER PRIMARY KEY,
    Fname           VARCHAR2(20),
    Lname           VARCHAR2(20),
    Gender          CHAR,
    DOB             DATE,
    salary          NUMBER ,
    city            VARCHAR2(20),
    state           VARCHAR2(20) 
);
INSERT INTO mendo_ values (111,'john','Doe','m','11-FEB-1978',25000, 
'Davis','CA');
INSERT INTO mendo_ values (112,'john','Smith','m','01-MAR-1981',40000, 
'Davis','CA');
INSERT INTO mendo_ values (113,'jill','Crane','m','12-APR1999',NULL,'Reno','NV');
INSERT INTO mendo_ values (114,'billy','Bob','f','05-MAY-1985',60000,'Las 
Vegas','NV');
INSERT INTO mendo_ values (115,'dove','Grime','f','04-JUN1960',20000,'Sacramento','CA');

-- drop disease table
DROP TABLE mendo_disease;
CREATE TABLE mendo_disease
(
    disease_id          NUMBER PRIMARY KEY,
    disease_desc        VARCHAR2(20)
);
INSERT INTO disease VALUES (11,'Cancer'); 
INSERT INTO disease VALUES (22,'Malaria');
INSERT INTO disease VALUES (33,'Flu');

-- create and popuilate the patient_disease table
CREATE TABLE mendo_patient_disease (
    Patient_id          NUMBER REFERENCES mendo_patient,
    disease_id          NUMBER REFERENCES mendo_disease,
    PRIMARY KEY             (patient_id, disease_id)
);
INSERT INTO mendo_patient_disease VALUES (111,11);
INSERT INTO mendo_patient_disease VALUES (111,22);
INSERT INTO mendo_patient_disease VALUES (113,11);

Notes:
- A subquery is a SELECT statement used within another SQL command.
- This first query is the subquery. The subquery’s results are passed as input to the outer query ( also called the parent query) 
- You can nest subqueries inside the FROM, WHERE, or HAVING clauses of other subqueries

- A subquery must be a complete query in itself— in other words, it must have at least a SELECT and a FROM clause.
    1. A subquery, except one in the FROM clause, can’t have an ORDER BY clause. If you need to display output in a specific order, include an ORDER BY clause as the outer query’s last clause. 
    2. subquery must be enclosed in parentheses to separate from the outer query
    3. If you place a subquery in the outer query’s WHERE or HAVING clause, you can do so only on the right side of the comparison operator.

9C. Using Subqueries - one single row

- A single- row subquery can return only one row of results consisting of only one column to the outer 
query.

9D. Multiple Rows
- Multiple- row subqueries are nested queries that can return more than one row of results to the parent query
- Valid multiple- row operators include IN, ALL, and ANY must be used. Of the three, the IN Operator is used most often.
SYNTAX: 
SELECT fname, lname FROM patient WHERE patient_id IN( SELECT
    patient_id
FROM
    patient_disease
WHERE
    disease_id =(
        SELECT
            disease_id
        FROM
            disease
        WHERE
            disease_desc = 'Cancer'
    )
);


9E. Single and Multiple Rows
--Notice the concatenation operator in the subquery.
--The concatenation operator takes the two pieces of data and connect them together 
--to make it appear as one single piece. 
SELECT disease_desc FROM disease WHERE disease_id IN (
 SELECT disease_id FROM patient_disease WHERE patient_id=(
 SELECT patient_id FROM patient WHERE (fname || lname)=('johnDoe')));

9F. Multipl Column subquery
- multiple column subquery returns more than one column of data to the outer query. 
- syntax: WHERE(col1, col2) IN (subquery); 

--Notice that fname and lname are enclosed in parantheses in the outer query. It works
--like the concatenation operator in that fname and lname become a single piece of data
--which are compared against fname and lname in the inner query. The (IN) operator is used
--because it is possible that the inner query may yield multiple rows.
SELECT patient_id FROM MENDO_CHECK_PERSON WHERE (fname,lname) IN (
 SELECT fname,lname FROM special_names);

9G. Group Functions and Subqueries
-Invalid. Must use a subquery. For every row that is processed from the patient table we have to compare
its salary against the AVG(salary). We cannot combine a group function with row level processing which is why this gives us an error.
SELECT fname,lname, salary FROM MENDO_CHECK_PERSON WHERE salary > AVG(salary);

-- for using dob DATE fields
SELECT fname, lname, DOB FROM MENDO_CHECK_PERSON where MONTHS_BETWEEN(sysdate,DOB) > (SELECT AVG(MONTHS_BETWEEN(sysdate,DOB)) FROM MENDO_CHECK_PERSON);

9H. Create table and subqueries
- can also perform CREATE TABLE AS using subqueries. 

9I. Update and delete using subqueries
--This example updates the salary for all those patients who have cancer.
UPDATE patient SET salary=salary*2 WHERE patient_id IN 
(SELECT patient_id FROM patient_disease WHERE disease_id=(SELECT disease_id FROM disease WHERE disease_desc='Cancer')) ;

--This example deletes all the records from the patient_disease table for all those who have cancer.
DELETE FROM patient_disease WHERE disease_id IN (
 SELECT disease_id FROM disease WHERE disease_desc='Cancer');

 */

/* CHECK 9A */
-- 1. 
-- SELECT NVL(salary, ) FROM MENDO_CHECK_PERSON;