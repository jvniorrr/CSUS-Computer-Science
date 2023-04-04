/* CHECK 5A */
-- 1. Create the person table and insert some records before starting with the questions
CREATE TABLE MENDO_CHECK_PERSON (
    Patient_id NUMBER PRIMARY KEY,
    Fname   VARCHAR2(20),
    Lname   VARCHAR2(20),
    Gender  CHAR,
    DOB     DATE,
    salary  NUMBER ,
    city    VARCHAR2(20),
    state   VARCHAR2(20)
);
INSERT INTO MENDO_CHECK_PERSON values (111,'john','Doe','m','11-FEB-1978',25000, 
'Davis','CA');
INSERT INTO MENDO_CHECK_PERSON values (112,'john','Smith','m','01-MAR-1981',40000, 
'Davis','CA');
INSERT INTO MENDO_CHECK_PERSON values (113,'jill','Crane','m','12-APR1999',50000,'Reno','NV');
INSERT INTO MENDO_CHECK_PERSON values (114,'billy','Bob','f','05-MAY-1985',60000,'Las 
Vegas','NV');
INSERT INTO MENDO_CHECK_PERSON values (115,'dove','Grime','f','04-JUN1960',20000,'Sacramento','CA');

-- 2. Display the contents of the Person table. Use the alias Last name.
SELECT patient_id, fname, lname as "Last Name", gender, DOB, salary, city, state FROM MENDO_CHECK_PERSON;

-- 3. Concatenate the firstname, lastname and the salary separated by a space, using the concat function
SELECT CONCAT(fname, CONCAT(' ', CONCAT(lname, CONCAT(' ', salary)))) FROM MENDO_CHECK_PERSON;

-- 4. Display all the unique lastnames from the Person table.
SELECT DISTINCT lname FROM MENDO_CHECK_PERSON;

/* 
dual used for testing purposes essentially, holds one single row. 
INITCAP: function that sets the first character in each word to uppercase and the rest to lowercase
syntax --> INITCAP('string') == 'String'

SUBSTR: function that returns a substring of a string   
syntax --> SUBSTR('string', start, length) == 'str'

INSTR: function that searches for string in specified set of characters or a sub-string; returns a numeric value of the position of the first occurrence of the string in the set of characters or sub-string
syntax --> INSTR('Tech on the net', 'e', [start, nth, occurrence]) == 2

REPLACE: functions similar to 'search and replace'. it replaces a specified string with another string
syntax --> SELECT REPLACE('123tech123', '123') FROM DUAL; == 'tech'
syntax --> SELECT REPLACE('123tech123', '123', '456') FROM DUAL; == '456tech456'
 */

 /* CHECK 5B */
-- 1. Display the first three letters of the last name. Make sure the first letter is in uppercase
SELECT INITCAP(SUBSTR(lname, 1, 3)) FROM MENDO_CHECK_PERSON;

-- 2. Identify the location of the letter in all the firstnames.
SELECT INSTR(fname, 'e') FROM MENDO_CHECK_PERSON;

/* 
    5.11
    LPAD, RPAD: functions that add characters to the left or right of a string

    LPAD: function that can be used to padd or fill in the are to the left a character string with a specific character - or even blank space.
    syntax --> LPAD('string', 3, '*') `== '***string'
    syntax --> RPAD('string', 3, '*') `== 'string***'

    ROUND: function is ROUNED(d, u) where d represents the date data, or field to round, and u represents the unit to use for rounding.
    a date can be rounded by the unit of month or year
    syntax --> SELECT ROUND(12.5) FROM DUAL; == 13
    syntax --> SELECT ROUND(12.56, 1) FROM DUAL; == 12.6
    syntax --> SELECT ROUND(12.55, 1) FROM DUAL; == 12.5

    TRUNC: rather than rounding, TRUNC function truncates a number to a specified number of decimal places. Any number after the position are simply removed
    TRUNCT(n, p) where n represents the numerica data or field to truncate, and p represents the position of the digit where data should be truncated
    syntax --> SELECT TRUNC(12.56, 1) FROM DUAL; == 12.5
    syntax --> SELECT TRUNC(12.56, 0) FROM DUAL; == 12

    CEIL: returns the ceiling value (next highest integer above a number)
    syntax --> SELECT CEIL(12.56) FROM DUAL; == 13
    syntax --> SELECT CEIL(12.1) FROM DUAL; == 13

    FLOOR: returns the floor value (next lowest integer below a number)
    syntax --> SELECT FLOOR(12.56) FROM DUAL; == 12
    syntax --> SELECT FLOOR(12.1) FROM DUAL; == 12

    MOD: returns the remainder of a division operation
    syntax --> SELECT MOD(12, 5) FROM DUAL; == 2

    ABS: returns the absolute value of a number
    syntax --> SELECT ABS(-12) FROM DUAL; == 12

    POWER: returns the value of a number raised to a power
    POWER(x, y) where x represents the number to be raised to a power, and y represents the power to which the number is raised
    syntax --> SELECT POWER(2, 3) FROM DUAL; == 8


 */

/* CHECK 5C */
-- 1.  Using a select statement, display the age (make everyone six months older) in years
SELECT ADD_MONTHS(DOB, 6) DOB FROM MENDO_CHECK_PERSON;

/* 
    5.15 NVL and NVL2 Functions
    you can use the nvl function to address problems caused when performining arithmetic operatiosn with fields that might containt NULL values
    NVL works as a substitute for NULL values. If the first argument is NULL, then the second argument is returned.
    syntax --> SELECT fname, NVL(salary, 0) FROM MENDO_CHECK_PERSON; // if salary is null, then 0 is returned

    NVL2 works as a substitute for NULL values. If the first argument is NULL, then the third argument is returned. If the first argument is not NULL, then the second argument is returned.
    syntax of NVL2 function is NVL2(x, y, z) where y represents what should be substituted if x isnt null and z represents what should be substituted if x is null.
    syntax --> SELECT fname, NVL2(salary, salary, 0) FROM MENDO_CHECK_PERSON; // if salary is null, then 0 is returned, if salary is not null, then salary is returned


    5.16 DECODE
    DECODE function takes a specified value and compares it to values in a list, if match found the specified result is returned. else a default result is returned.
    syntax --> DECODE(V, L1, R1, L2, R2, ..., D), where V is value your searching for, L1 represents th first value in list, r1 represents theresult to return if L1 and V equivalnt
    and so on, and D is the default result to return if no match is found.
    SYNTAX --> SELECT DECODE(1, 1, 'one', 2, 'two', 'other') FROM DUAL; == 'one'
    SYNTAX --> SELECT gender, DECODE (gender, 'm', 'MALE', 'f', 'FEMALE', 'UNKNOWN') FROM MENDO_CHECK_PERSON;

    5.17 SIGN
    syntax for sign is: SIGN(number) where numere is the number to test for its sign
    if number < 0then sign returns -1
    if number > 0 then sign returns 1
    if number = 0 then sign returns 0

    5.18 CASE
    CASE expression syntax is similar to if else, oracle reads them left to right.
    when a particular condition is satisified (WHEN part) the expression returns the tagged value (THEN part) . 
    if no condition is satisfied, the ELSE part is returned.
    syntax --> SELECT fname, salary, CASE WHEN salary > 10000 THEN 'HIGH' WHEN salary > 5000 THEN 'MEDIUM' ELSE 'LOW' END FROM MENDO_CHECK_PERSON;

    5.19 TO_NUMBER
    TO_NUMBER function voncerts a value to a numeric data type, if possible
    For example, the string value 2009 stored in a date or character string could be converted to a numeric data type to use in calculations.
    if the string being converted contains non-numeric characters, the fxn returns an error
    
 */

/* CHECK 5D */
-- 4) Display the lastname and salary for each person. If the salary is blank, display poor otherwise display the salary.
-- SELECT lname, NVL(salary, 'poor') FROM MENDO_CHECK_PERSON;
-- SELECT lname, NVL2(salary, salary, 'poor') FROM MENDO_CHECK_PERSON;
-- SELECT lname, DECODE(salary, NULL, 'poor', salary) FROM MENDO_CHECK_PERSON;

-- 5) What is the purpose of the dual table?
-- the dual table is a dummy table essentially for testing purposes. it is used to test the functionality of a query before it is applied to a real table.
-- it is a table with one row. it is used to test the functionality of a query before it is applied to a real table.