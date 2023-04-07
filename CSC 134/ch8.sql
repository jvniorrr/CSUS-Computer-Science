/* Chapter 8 Group By 
- Group functions also called multiple-row functuins, return one result per group of rows processed. 
- Multiple-row functions covered in this chapter: SUM, AVG, COUNT, MIN, MAX
- When using the GROUP BY clause, remember following: 
    - if a group function is used in the SELECT clause, any single (non-aggregate) columns listed in the SELECT clause must also be listed in the GROUP BY clause.
    - col's used to group data in the GROUP BY clause don't have to be in the SELECT clause. Tehy're included in SELECT clause only to have these groups.
    - results returned from a SELECT statement that includes a GROUP BY clause are displayed in ascending order of columns listed in the GROUP BY clause. 

    - to have different sort sequences, use the ORDER BY clause. When a SELECT statement includes all three clauses, the order in they were evaluated are as follows:
        1. the WHERE clause * the GROUP  BY clause
        2. the HAVING clause IN essence, the WHERE clause filters the data before grouping, and the HAVING clause filters the groups after the grouping occurs

    EXAMPLES: Group by city
    SELECT city, SUM(salary) from MENDO_CHECK_PERSON GROUP BY city;
    SELECT state, SUM(salary) from MENDO_CHECK_PERSON GROUP BY state;

8.2 SUM
- SUM functionused to calculate the total amount stored in a numeric field for a group of records. 
syntax: SELECT SUM(salary) FROM MENDO_CHECK_PERSON;

8.3 DISTINCT
- the optional DISTINCT keyword instructs ORACLE to include only unique numeric values in its calculations
- the ALL keyword instructs Oracle to include multiple occurrences of numeric values when totaling a field.
- if the DISTINCT or ALL keywords aren't included when using the SUM function, Oracle assuumes the ALLL keyword by default.

8.4 AVG
- the AVG function calculates the average of numeric values in a specified column.
- syntax: SELECT AVG(ALL salary) FROM MENDO_CHECK_PERSON;
= syntax: -- suppresses duplicates and then gives an average
SELECT AVG(DISTINCT salary) FROM MENDO_CHECK_PERSON;

8.5 COUNT
- COUNT function counts the records having non-NULL values in a specified field, or count the total records meeting a specified condition, including those containing NULL values. 
syntax: SELECT COUNT(*) FROM MENDO_CHECK_PERSON; -- counts all records
syntax: SELECT COUNT(salary) FROM MENDO_CHECK_PERSON; -- counts all records with non-null salary
SELECT COUNT (city) from MENDO_CHECK_PERSON; -- counts the number rows based on the contents of the city. if the city for a given row contains a NULL then it will not be counted.

8.6 MAX
- MAX function returns the largest value stored in the specified column.
SYNTAX: MAX([DISTINCT | ALL] column_name)
syntax: SELECT MAX(salary) FROM MENDO_CHECK_PERSON;
SELECT city, MAX(salary) FROM MENDO_CHECK_PERSON GROUP BY city;

8.7 MIN
- MIN function returns the smallest value in a specifieid column. 
SYNTAX: MIN([DISTINCT | ALL] column_name)
syntax: SELECT MIN(salary) FROM MENDO_CHECK_PERSON;
SELECT city, MIN(salary) FROM MENDO_CHECK_PERSON GROUP BY city;
-- display the lowest salary fro each city category and display the number of records in each group
SELECT city, MIN(salary), COUNT(*) FROM MENDO_CHECK_PERSON GROUP BY city;

8.8 DATES AND GROUP FUNCTIONS
-- displays oldest person, youngest peson, the number of records
SELECT MIN(dob), MAX(dob), COUNT(dob), COUNT(DISTINCT dob) FROM MENDO_CHECK_PERSON;

*/

/* CHECK 8A */
-- 1. Display the count of all people who make less than 10000 for each of the different personality types.
SELECT personality, COUNT(*) FROM MENDO_CHECK_PERSON WHERE salary < 10000 GROUP BY personality;
-- SELECT personality_type, COUNT(salary) FROM MENDO_CHECK_PERSON WHERE salary < 1000 GROUP BY personality_type;

-- 2.  Display the average age and maximum salary for each personality type. Display both the average age and personality types.
SELECT AVG(MONTHS_BETWEEN(SYSDATE, dob) /12), MAX(salary) FROM MENDO_CHECK_PERSON GROUP BY personality_type;  
-- SELECT personality, AVG(age), MAX(salary) FROM MENDO_CHECK_PERSON GROUP BY personality;

-- 3. whats wrong with following statement?
--  SELECT * FROM MENDO_CHECK_PERSON WHERE salary> AVG(salary); -- salary is not a column in the patient table
-- correct statement: SELECT * FROM MENDO_CHECK_PERSON WHERE salary > (SELECT AVG(salary) FROM MENDO_CHECK_PERSON);
--  SELECT fname AS firstname, SUM (salary) summation FROM MENDO_CHECK_PERSON WHERE firstname=’john’ HAVING summation>10000;
-- correct statement: SELECT fname AS firstname, SUM (salary) summation FROM MENDO_CHECK_PERSON WHERE firstname='john' GROUP BY firstname HAVING summation>10000;


/* SUMMARY
--Display oldest person, youngest person, average salary (Does not include NULLs) and sum of all salaries.
SELECT min(DOB), max (DOB), count(DOB), AVG(salary), sum(salary) FROM MENDO_CHECK_PERSON;
 */