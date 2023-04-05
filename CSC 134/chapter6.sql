/* CHAPTER 6 RESTRICTING */

/* 
    WHERE CLAUSE: used to specify conditions that must be true for a record to be included in a query result.
    syntax --> SELECT column_name FROM table_name WHERE condition;

    Mathematical Comparison Operators: how a record relates a specific value
    = equal to
    <> not equal to
    > greater than, < less than
    >=, greater than or equal to,  <= less than or equal to
    != not equal to
    ^= not equal to

    BETWEEN, AND, IN, OR, NOT, LIKE, IS NULL: Searching for values that include patterns, ranges or NULL values
    BETWEEN: used to specify a range of values
    syntax --> SELECT column_name FROM table_name WHERE column_name BETWEEN value1 AND value2;
    
    AND: used to specify multiple conditions in a WHERE clause
    syntax --> SELECT column_name FROM table_name WHERE condition1 AND condition2 AND condition3;

    IN: used to specify multiple values in a WHERE clause
    syntax --> SELECT column_name FROM table_name WHERE column_name IN (value1, value2, value3);

    OR: used to specify at least one condition in a WHERE clause
    syntax --> SELECT column_name FROM table_name WHERE condition1 OR condition2 OR condition3;

    NOT: used to reverse the result of a condition
    syntax --> SELECT column_name FROM table_name WHERE NOT condition;

    LIKE: used to search for a specified pattern in a column
    syntax --> SELECT column_name FROM table_name WHERE column_name LIKE pattern;
    
    IS NULL: used to test for NULL values
    syntax --> SELECT column_name FROM table_name WHERE column_name IS NULL;

    AND, OR, NOT: used to join multiple or reveerse the meaning of a search condition through NOT

    String literals are enclosed in single quotes, 

    EX 6.1: 
    -- all folks whose salary greater than 30,000.
    SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary > 30000;

    When filtering text data, it is case sensitive.
    SELECT fname, lname, salary , city FROM MENDO_CHECK_PERSON WHERE city='Davis' ; 

    6.2 DATES
    When searching for dates need string literal in single quotes, and the date format must be YYYY-MM-DD. This is because
    Oracle displays the date field with letters and hyphens, thus not considered numeric value.
    EX:
    SELECT fname, lname, salary, DOB FROM MENDO_CHECK_PERSON WHERE DOB > '1990-01-01';
    alternatively can also use the TO_DATE function to convert a string literal to a date value.
    EX: SELECT fname, lname, salary, DOB FROM MENDO_CHECK_PERSON WHERE DOB > TO_DATE('1990-01-01', 'YYYY-MM-DD');

    6.3 LOWER, UPPER
    UPPER: function converts all leters to uppercase; if values in string not letters they are unaffected
    LOWER: function converts all letters to lowercase; if values in string not letters they are unaffected
    SYNTAX: SELECT UPPER(column_name) FROM table_name;
    SYNTAX: SELECT LOWER(column_name) FROM table_name;
    SYNTAX: SELECT fname, lname, city FROM MENDO_CHECK_PERSON WHERE UPPER(city) = 'DAVIS'; // bypass case-sensitivity

    6.4 AND, BETWEEN
    Can use AND / OR clause to combine search conditions
    the NOT operator can also be used to reverse the meaning of a search condition, though it is also a logical operator in Oracle.

    When AND used both conditions must be met for resulting query to result in true (i.e. populate said query)
    When OR used only one condition must be met for resulting query to result in true (i.e. populate said query)

    -- EX: Can be used to check for two conditions
    SELECT fname, lname,DOB, salary FROM MENDO_CHECK_PERSON WHERE salary>30000 and salary <80000;
    
    6.4b BETWEEN
    The two values defining the range for SQL BETWEEN clause can be dates, numbers or just text. (inclusive of both end points)
    EX: SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary BETWEEN 30000 AND 80000;

    6.5b IN, OR
    IN operator allows you to specify multiple values in a WHERE clause.
    EX: SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE LOWER(city) IN ('davis', 'sacramento', 'elk grove', 'roseville');

    6.5b Order of precendece
    Arithmetic operators solved first, Comparison operators solved next, Logical operators have a lower precedence & are evaluated last in order (NOT, AND, OR).

    6.6 ANY/ ALL
    ANY: similar to OR. Compares a value to each value in a list or returned by a query. Must be preceded by =, !=, >, <, <=, >=
    EX: SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary >ANY(30000, 40000); -- returns all employees with salary greater than 30,000 or 40,000
    ALL: similar to AND operators. Compares a value to each value in a list or returned by a query. Must be preceded by =, !=, >, <, <=, >=
    EX: SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary >ALL(30000, 40000); -- returns all employees with salary greater than 30,000 and 40,000, logically incorrect though since would yield no results

    6.7 LIKE CLAUSE
    LIKE: its used with wildcard operators to search for patterns; those which are available to us are:
    '%' Percent symbol: any number of characters (zero, one, or more)
    -- EX: it must end with S whether it is upper or lower case (S)
    SELECT fname, lname, city FROM MENDO_CHECK_PERSON WHERE UPPER(city) LIKE '%S';
    '_' underscore symbol: represents exactly one character
    -- EX: second letter can be anything (_) means a single character
    SELECT fname, lname, city FROM MENDO_CHECK_PERSON WHERE city LIKE 'D_avis';

    6.8 NULL

    A NULL value means no value has been stored in that field. Don’t confuse a NULL value with a blank space. A NULL is the absence of data in a field
    when searching for NULL values must use the IS NULL operator

 */

 /* CHECK 6A */
-- 1) Display all the records from the person table whos age is between 30 and 35.
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE age BETWEEN 30 AND 35;
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE AGE > 30 and AGE < 35;

-- 2) Display all the individuals whose last name is 'Fickle' or 'Grapes' regardless of case (Use OR and IN)
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE LOWER(lname) IN ('fickle', 'grapes');
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE LOWER(lname) = 'fickle' OR LOWER(lname) = 'grapes';

-- 3) Display all whose last names who starts with B and ends with L, regardless of case.
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE LOWER(lname) LIKE 'b%s';

-- 4)  Display all those whose lastname contains the letter B in the third position.
SELECT fname, lname, age FROM MENDO_CHECK_PERSON WHERE LOWER(lname) LIKE '__b%';

-- 5)  Display poor if the salary is NULL, otherwise display the actual salary plus an additional $2000.
SELECT fname, lname, NVL2(salary, salary + 2000, 'poor') FROM MENDO_CHECK_PERSON;
-- use case
SELECT fname, lname, CASE WHEN salary IS NULLTHEN 'poor' ELSE salary + 2000 END FROM MENDO_CHECK_PERSON;

-- 6)  Display all the people whose salaries are not NULL
SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary IS NOT NULL;

-- 7) Display all the people whose salary is NULL and the lastname contains a C regardless of case
SELECT fname, lname, salary FROM MENDO_CHECK_PERSON WHERE salary IS NULL AND LOWER(lname) LIKE '%c'; 

/* 6.9 CREATING TABLES W/ SELECT STATEMENTS.

    You can create tables using select statements and pull certain fields / columns into a new table
    CREATE TABLE patient_temp AS SELECT fname, lname, salary, city FROM patient WHERE city='Mavis'; 
    -- the above line creates a new table called patient_temp and populates it with rows from the patient table where the city is Mavis

    -- Creating a table and using an alias name.
    
    6.10 Updating tables using the update statement
    UPDATE statement allows you to update a single record or multiple records in a table.
    UPDATE table_name SET column = expression WHERE predicatel

 */

 /* CHECK 6B */
--  1. Create a  brand new table called Person2 which contains only those folks who are making less than 10000 and whose lastname ends with the letter ‘j’, regardless of case.
CREATE TABLE MENDO_PERSON2 AS SELECT * FROM MENDO_CHECK_PERSON WHERE salary < 10000 AND loweR(lname) LIKE '%j';

-- 2.  Update the salaries to 8000 for all the people in person2 who are making more than 20000 or are older than 40 years old.
UPDATE MENDO_PERSON2 SET salary = 8000 WHERE salary > 20000 OR age > 40;