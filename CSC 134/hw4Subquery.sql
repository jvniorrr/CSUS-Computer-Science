/* 1. using a single SQL statement display fname, lname of all the students who are taking 
'database programming' class regardless of case. */
SELECT
    fname,
    lname
FROM
    MENDO_STUDENT
WHERE
    -- match the ssn and assure in the list of students who are taking 'database programming' class regardless of case
    ssn IN (
        SELECT
            ssn
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            -- match the ssn assuring in the list of students who are taking 'database programming' class regardless of case
            class_code = (
                SELECT
                    class_code
                FROM
                    MENDO_CLASS
                WHERE
                    -- get the ssn of students who are taking 'database programming' class regardless of case
                    lower(class_description) = 'database programming'
            )
    );

/* 2. Using a single SQL statement display all the rows from the student_class table where class 
description is not null */
SELECT
    *
FROM
    MENDO_STUDENT_CLASS
WHERE
    -- match the class code of the student class table with the class code of the class table where class description is not null
    class_code IN (
        -- get the rows from the class table where class description is not null
        SELECT
            class_code
        FROM
            MENDO_CLASS
        WHERE
            class_description IS NOT NULL
    );

/* 3. Using a single SQL statement display fname, lname of all the students whose first name is
anything except John, Jack, Bob and who are taking 'operating systems' class regardless of case and
their phone number is not null. */
SELECT
    fname,
    lname
FROM
    MENDO_STUDENT
WHERE
    -- get the data row of students whose first name is anything except John, Jack, Bob
    LOWER(fname) NOT IN ('john', 'jack', 'bob') 
    -- get the data row of students who's phone number is not null
    AND phone IS NOT NULL
    -- get the data row of students who are taking 'operating systems' class regardless of case; so should match single row for class_code
    AND ssn IN (
        SELECT
            ssn
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            class_code IN (
                SELECT
                    class_code
                FROM
                    MENDO_CLASS
                WHERE
                    LOWER(class_description) = 'operating systems'
            )
    );
/* 4. Using a single SQL statement display ssn, fname, lname, age/2 of all the students whose first name begins with the letter j and age is greater than 25
and are taking any class that contains 'intro' in its description (Have to convert the dob into a number). Order the results by age/2 in descending order. Use an alias
for the order by clause */
SELECT
    ssn,
    fname,
    lnam,
    (TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) / 2) AS half_age
FROM
    MENDO_STUDENT
WHERE
    LOWER(fname) LIKE '%j'
    AND TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > 25
    AND ssn IN (
        SELECT
            ssn
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            class_code IN (
                SELECT
                    class_code
                FROM
                    MENDO_CLASS
                WHERE
                    LOWER(class_description) LIKE '%intro%'
            )
    )
ORDER BY
    half_age DESC;
    
/* 5. Using a single SQL statement display fname, lname from the student table where last name contains the letters 'nn' (e.g. Benny, Bonny, Sonny) and is enrolled
in any class that contains the letter 'h' in its description regardless of case. Order the results by lname. When using order by user the position and 
not the name of the column. */
SELECT fname, lname
FROM
    MENDO_STUDENT
WHERE
    LOWER(lname) LIKE '%nn%'

    AND ssn IN (
        SELECT
            ssn
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            class_code IN (
                SELECT
                    class_code
                FROM
                    MENDO_CLASS
                WHERE
                    LOWER(class_description) LIKE '%h%'
            )
    );

/* 6. Using a single SQL statement delete all the rows from the class table for all classes that are associated with students who live in Sacramento
and earn less than 15000 (NOTE: you are deleting from the class table) */
DELETE FROM
    MENDO_CLASS
WHERE
    -- get the class codes of the classes that are associated with students who live in sacramento and earn less than 15000
    class_code IN (
        SELECT
            class_code
        FROM
            MENDO_STUDENT_CLASS
        WHERE
        -- get the ssn of the students who live in sacramento and earn less than 15000
            ssn IN (
                SELECT
                    ssn
                FROM
                    MENDO_STUDENT
                WHERE
                    LOWER(city) = 'sacramento'
                    AND salary < 15000
            )
    );

/* 7. Using a single SQL statement use a combination of create and select to create a new table called class2
that contains the list of all the classes that are taken by students who are older than 30 years old. */
CREATE TABLE MENDO_CLASS2 AS 
SELECT
    *
FROM 
    MENDO_CLASS
WHERE
    -- get the class codes of the classes that are taken by students who are older than 30 years old
    class_code IN (
        SELECT
            class_code
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            -- get the ssn of the students who are older than 30 years old
            ssn IN (
                SELECT
                    ssn
                FROM
                    MENDO_STUDENT
                WHERE
                    TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > 30
            )
    );

/* 8. Update the salary to 75000 for all students who are enrolled in 'Database programming' 
regardless of case and live in CA. Might be wrong... */
UPDATE
    MENDO_STUDENT
SET
    salary = 75000
WHERE
    ssn IN (
        -- get the rows where the ssn matches the ssn of the students who are enrolled in 'Database programming' regardless of case and live in CA
        SELECT
            ssn
        FROM
            MENDO_STUDENT_CLASS
        WHERE
            class_code IN (
                -- get the rows or class codes of the classes with description 'database programming'
                SELECT
                    class_code
                FROM
                    MENDO_CLASS
                WHERE
                    LOWER(class_description) = 'database programming'
            )
    )
    AND UPPER(city) = 'CA';