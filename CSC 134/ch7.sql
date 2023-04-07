/* CHAPTER 7 SORTING */

/* 
7A. Order By 
    - Order by clause is used to query results in a sorted order., Clause is listed at the end of the SELECT statement.
    Syntax: SELECT column_name FROM table_name ORDER BY column_name ASC/DESC; -- ASC is default if not specified

7B. NULLs
    - when sorting in asc order, values are listed: 1. Blank & Special Characters, 2. Numberic Value, 3.Character values (uppercase first), 4. NULL value


7C. Secondary Sorts
    - some cases might want to include a secondary sort, which specifies second field to sort if an exact match occurs between two or more rows in the primary sort.
    Syntax: SELECT column_name FROM table_name ORDER BY column_name fname, lname; -- orders by fname, then lname if fname is the same
 
7D. Position
    - can order by position number
    Syntax: SELECT column_name FROM table_name ORDER BY 1; -- orders by first column

7E. Column versus alias
    - can order by column name or alias name
    Syntax: SELECT NVL(salary, 0) pay from MENDO_CHECK_PERSON ORDER BY pay; -- orders by alias name, lists 0 in middle of results
    Syntax: SELECT NVL(salary, 0) FROM MENDO_CHECK_PERSON ORDER BY salary; -- orders by column name, lists 0 at end of results; orders before the zero has been substituted.
 */

 /* CHECK 7A */
--  1. Display the fname and lname (use alias lastname) of the people whose salaries are NULL. Do a sort within a sort using lastname and firstname.
SELECT fname, lname lastname FROM MENDO_CHECK_PERSON WHERE salary IS NULL ORDER BY lname, fname;