/* 1. Write a single SQL statement that displays the number of people with the same lastname. The
results should contain lastname and the count for each lastname. Exclude from the list all those who 
live in CA. */
SELECT lname, COUNT(*) FROM MENDO_STUDENT WHERE STATE NOT IN ('CA') GROUP BY lname;

/* 2. Write a single SQL statement that displays the number of people living in each of the states.
The results should display the state and the number of people living in each state. Exclude from the 
list all those who are living in cities that contain the letter h */
SELECT state, COUNT(*) FROM MENDO_STUDENT WHERE city NOT LIKE '%h%' GROUP BY state;

/* 3. Use a single SQL statement that displays the ssn and the number of classes a student is taking 
with the column head "number of classes" where the number of classes is less than 2, order by ssn descending. */
SELECT
    ssn,
    COUNT(*) "number of classes" -- count the number of classes for each ssn
FROM
    MENDO_STUDENT_CLASS
GROUP BY
    ssn -- group by ssn
HAVING
    COUNT(*) < 2 -- only get the ssns that have less than 2 classes
ORDER BY
    ssn DESC; -- order by ssn descending

/* 4. Write a single SQL statement that displays the average age for each city, state combination
for all students whose salary is greater than the average salary and are taking some kind of 
'Intro' class. Also exclude the city 'Berkely' from the list regardless of case. Sort by city in ascending
order and state in descending order. */
SELECT
    city,
    state,
    AVG(TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12)) "average age"
FROM
    MENDO_STUDENT
WHERE
    ssn IN (
        -- get the rows where ssn is in the student class table and the class description contains 'intro'
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
    -- exclude the city 'Berkely' from the list regardless of case
    AND LOWER(city) NOT IN ('berkely')
    AND salary > (
        SELECT
            AVG(salary)
        FROM
            MENDO_STUDENT
    )
-- group by city and state
GROUP BY
    city,
    state
ORDER BY
    city ASC,
    state DESC;
    
/* 5. Write a single SQL statement that displays the States in lower case along with the rounded average
age for the different states with the alias name "average of ages" for all the students who are taking a class
that contains 'principles' in its description regardless of case. */
SELECT
    LOWER(state),
    AVG(ROUND(MONTHS_BETWEEN(SYSDATE, dob) / 12)) AS "average of ages"
FROM
    MENDO_STUDENT
WHERE
    ssn IN (
        -- get the rows of students who are taking a class that contains 'principles' in its description
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
                    LOWER(class_description) LIKE '%principles%'

)
)
GROUP BY
    state;