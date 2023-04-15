/* 1. Using a single SQL statement display the patient’s ssn concatenated with the square root of 
age separated by a comma with a column heading “Patient Info” for all those patients whose age is 
greater than the minimum age */
SELECT
    -- display concatenated ssn and square root of age
    ssn || ', ' || SQRT(age) AS "Patient Info"
FROM
    PATIENT
WHERE
    -- retrieve the patients whose age is greater than the minimum age
    age > (
        SELECT
            MIN(age)
        FROM
            PATIENT
    );
    

/* 2. Using a single SQL statement give a listing of all the patients whose age is greater than
the average age (Include the null in your average) and are suffering from cancer regardless of
case */
SELECT *
FROM
    PATIENT
WHERE
    -- get the patients who are suffering from cancer
    ssn IN (
        SELECT
            ssn
        FROM
            PATIENT_DISEASE
        WHERE
            disease_code IN (
                SELECT
                    disease_code
                FROM
                    DISEASE
                WHERE
                    LOWER(disease_description) = 'cancer';

)
) -- get row information where the age is greater than the average age; include the null values in the average
AND TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > (
    SELECT
        AVG(TRUNC(MONTHS_BETWEEN(SYSDATE, NVL(DOB, 0)) / 12))
    FROM
        PATIENT
);



/* 3. Using a single SQL statement give a listing of all the patients who have Diabetes and are older
than 95 */
SELECT
    *
FROM
    PATIENT
WHERE
    --patients older than 95 
    age > 95
    AND ssn IN (
        SELECT
            ssn
        FROM
            PATIENT_DISEASE
        WHERE
            -- get the disease code of the diabetes disease
            disease_code = (
                SELECT
                    disease_code
                FROM
                    DISEASE
                WHERE
                    LOWER(disease_description) = 'diabetes'
            )
    );
 

/* 4. Using a single SQL statement give a listing of all the disease descriptions of where the patients
are making less than 50000*/
SELECT disease_description
FROM
    DISEASE
WHERE
    disease_code IN (
        SELECT
            disease_code
        FROM
            PATIENT_DISEASE
        WHERE
            -- get the patient rows where the salary is less than 50000
            ssn IN (
                SELECT
                    ssn
                FROM
                    PATIENT
                WHERE
                    salary < 50000;

)
);


/* 5. Using a single SQL statement give a listing of all the patients who have yellow fever whose
last name begins with either B or the 3rd character of their last name contains a G */
SELECT
    *
FROM
    PATIENT
WHERE
    SSN IN (
        SELECT
            SSN
        FROM
            PATIENT_DISEASE
        WHERE
            DISEASE_CODE =(
                SELECT
                    DISEASE_CODE
                FROM
                    DISEASE
                WHERE
                    UPPER(DISEASE_DESCRIPTION) = 'YELLOW FEVER'
            )
            AND UPPER(LNAME) LIKE 'B%'
            OR UPPER(LNAME) LIKE '__G%'
    );

/* 6. Using a single SQL statement give a listing of all patients who are suffering from malaria
whose salary is less than the average salary plus the MINIMUM salary. */
SELECT
    *
FROM
    PATIENT
WHERE
    SSN IN (
        SELECT
            SSN
        FROM
            PATIENT_DISEASE
        WHERE
            DISEASE_CODE =(
                SELECT
                    DISEASE_CODE
                FROM
                    DISEASEW
                WHERE
                    UPPER(DISEASE_DESCRIPTION) = 'MALARIA'
            )
            AND SALARY < (
                SELECT
                    AVG(SALARY) + MIN(SALARY),
                FROM
                    PATIENT
            )
    );


/* 7. Using a single SQL statement give a listing of the patient’s name, address and salary plus 5
divided by 3 everything raised to the power of two and date of birth (MM/YY/DD Format). order
by lastname in descending order and the calculated expression in ascending Order
 */
SELECT
    FNAME,
    LNAME,
    STATE,
    POWER((SALARY + 5) / 3, 2) AS SALARY_CALC,
    TO_DATE(dob, 'MM/YY/DD')
FROM
    PATIENT
ORDER BY
    LNAME DESC,
    SALARY_CALC ASC;


/* 8. Create a new table patient2 that contains only patient Information for people who have had ear
problems */
CREATE TABLE PATIENT2 AS
SELECT
    *
FROM
    PATIENT
WHERE
    SSN IN (
        SELECT
            SSN
        FROM
            PATIENT_DISEASE
        WHERE
            DISEASE_CODE IN (
                SELECT
                    DISEASE_CODE
                FROM
                    DISEASE
                WHERE
                    UPPER(DISEASE_DESCRIPTION) LIKE '%EAR%'
            )
    );


/* 9.  Insert into the new patient table all the people whose salaries are greater than the minimum
salary */
INSERT INTO
    PATIENT2
SELECT
    *
FROM
    PATIENT
WHERE
    SALARY > (
        SELECT
            MIN(SALARY)
        FROM
            PATIENT
    );


/* 10. Update the patient Information such that you switch the first name and the last name of the
patients for all those who are suffering from yellow fever */
UPDATE
    PATIENT
SET
    FNAME = 'Suffering',
    LNAME = 'Yellow Fever'
WHERE
    SSN IN (
        SELECT
            SSN
        FROM
            PATIENT_DISEASE
        WHERE
            DISEASE_CODE =(
                SELECT
                    DISEASE_CODE
                FROM
                    DISEASE
                WHERE
                    UPPER(DISEASE_DESCRIPTION) LIKE '%YELLOW FEVER%'
            )
    );



/* 11. sing a single SQL statement display the ssn and the number of diseases a patient has as
long as the count does not exceed 2 */
-- TODO: REVIEW
SELECT
    SSN,
    COUNT(DISEASE_CODE)
FROM
    PATIENT_DISEASE
GROUP BY
    SSN
HAVING
    COUNT(DISEASE_CODE) < 2;


/* 12. sing a single SQL statement display the diseases and the number of people who have that
disease */
SELECT
    DISEASE_DESCRIPTION,
    COUNT(*) AS NUM_PATIENTS
FROM
    DISEASE
WHERE
    DISEASE_CODE IN (
        SELECT
            DISEASE_CODE
        FROM
            PATIENT_DISEASE
    )
GROUP BY
    DISEASE_DESCRIPTION;


/* 13. Using a single SQL statement display the state and the sum of salary for each state for all
those people who are older than 20 , order by the sum in descending order */
SELECT
    STATE,
    SUM(SALARY) AS TOTAL_SALARY
FROM
    PATIENT
WHERE
    age > 20
GROUP BY
    STATE
ORDER BY
    TOTAL_SALARY DESC;


/* 14. Using a single SQL statement display the rich if the salary is greater than 50000 else
display poor */
SELECT
    CASE
        WHEN SALARY > 50000 THEN 'rich'
        ELSE 'poor'
    END AS salary_status
FROM
    PATIENT;

/* 15. Using a single SQL statement display the ssn, their age and the number of diseases a patient has as long as the count does not exceed 2 */
SELECT
    SSN,
    AGE,
    COUNT(DISEASE_CODE) AS NUM_DISEASES
FROM
    PATIENT
WHERE
    SSN IN (
        SELECT
            SSN
        FROM
            PATIENT_DISEASE
    )
HAVING
    COUNT(DISEASE_CODE) < 2
