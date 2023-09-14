/* Display all the people and all the potential personality types that they can have. Display
name and personality description
a. With and without CROSS JOIN */

/* create tables for me and represent them */
CREATE TABLE mendo_People
(
    PersonID INT PRIMARY KEY,
    PersonName VARCHAR(50) NOT NULL,
    PersonalityTypeID INT NOT NULL
);

CREATE TABLE mendo_PersonalityTypes
(
    PersonalityTypeID INT PRIMARY KEY,
    PersonalityDescription VARCHAR(50) NOT NULL
);

/* insert data into tables */
INSERT INTO mendo_PersonalityTypes VALUES (1, 'Introvert');
INSERT INTO mendo_PersonalityTypes VALUES (2, 'Extrovert');
INSERT INTO mendo_PersonalityTypes VALUES (3, 'Ambivert');


INSERT INTO mendo_People VALUES (1, 'Mendo', 1);
INSERT INTO mendo_People VALUES (2, 'Iraj', 2);
INSERT INTO mendo_People VALUES (3, 'Sbzavery', 3);

/* display all the people and all the potential personality types that they can have. Display
name and personality description */
SELECT * FROM mendo_People CROSS JOIN mendo_PersonalityTypes;
SELECT * FROM MENDO_PEOPLE, mendo_PersonalityTypes;

/* 2. Display the name and personailty description of all those people who have a personality 
    a. Use both the old and new Oracle syntax 
*/
SELECT personName, PersonalityDescription FROM MENDO_PEOPLE NATURAL JOIN mendo_PersonalityTypes;
SELECT personName, PersonalityDescription FROM MENDO_PEOPLE p, mendo_PersonalityTypes pp WHERE p.PersonalityTypeID = pp.PersonalityTypeID;

/* 1. Display name and description of all those who have a personality and also those who don’t.
For those who don’t have a personality, display “Bland” for description. */
SELECT personName, NVL(PersonalityDescription, 'Bland') FROM MENDO_PEOPLE p, mendo_PersonalityTypes pp WHERE p.PersonalityTypeID = pp.PersonalityTypeID(+);
SELECT personName, NVL(PersonalityDescription, 'Bland') FROM MENDO_PEOPLE LEFT OUTER JOIN mendo_PersonalityTypes ON MENDO_PEOPLE.PersonalityTypeID = mendo_PersonalityTypes.PersonalityTypeID;
SELECT personName, NVL(PersonalityDescription, 'Bland') FROM MENDO_PEOPLE RIGHT OUTER JOIN mendo_PersonalityTypes ON mendo_PersonalityTypes.PersonalityTypeID = MENDO_PEOPLE.PersonalityTypeID;

/* 2. Display the name and description of all those who have a personality, all those who don’t have a personality and 
all personalities that are not associated with anyone. (Display fname, lname, personality description)
 */
SELECT personName, PersonalityDescription FROM MENDO_PEOPLE p FULL OUTER JOIN mendo_PersonalityTypes pp ON p.PersonalityTypeID = pp.PersonalityTypeID;

SELECT personName FROM MENDO_PEOPLE WHERE EXISTS (SELECT * FROM mendo_PersonalityTypes);


CREATE TABLE mendo_hourly
(
    Lname         VARCHAR2(20),
Hrly_wage     NUMBER
);
INSERT INTO mendo_hourly VALUES ('Smith',10.25);
INSERT INTO mendo_hourly VALUES ('Wesseon',30.50);
INSERT INTO mendo_hourly VALUES ('Smith',10.25);
INSERT INTO mendo_hourly VALUES ('Wesseon',30.50);
CREATE TABLE mendo_salaried
(
   Lname    VARCHAR2(20),
   salary   NUMBER
);
INSERT INTO mendo_salaried VALUES ('Smith',500);
INSERT INTO mendo_salaried VALUES ('Jones',600);

/* 10C
1. Display the fname and personality description of all with salaries greater than 10000. Union
the results with all those who are making less than 5000. */
SELECT lname, personalityDesc FROM mendo_salaired WHERE salary > 1000
UNION
SELECT lname, personalityDesc FROM mendo_salaired WHERE salary < 5000;

/* 2. Display the name of all those who don’t have a personality. Display name and “No
personality”
a. Use not exists
b. Use minus
c. Use not in */
SELECT personName, 'No personality' FROM MENDO_PEOPLE p WHERE NOT EXISTS (SELECT * FROM mendo_PersonalityTypes pt WHERE p.PersonalityTypeID = pt.PersonalityTypeID);
SELECT personName, 'No personality' FROM MENDO_PEOPLE p WHERE p.PersonalityTypeID NOT IN (SELECT PersonalityTypeID FROM mendo_PersonalityTypes);

-- minus
SELECT personName, 'no personality' FROM MENDO_PEOPLE
MINUS
SELECT personName FROM MENDO_PEOPLE p WHERE p.PersonalityTypeID IN (SELECT PersonalityTypeID FROM mendo_PersonalityTypes);


SELECT * FROM party, candidate; -- cross join
SELECT * FROM candidate CROSS JOIN party; -- cartesian product

/* 1) Display the name and the corresponding description based on the candidates
salary (Use union and be cautious of the types) Order by name
< 50000 Honest
>50000 and < 100000 Not so honest
>100000 80000 */
SELECT lname, partydesc, 'Honest' FROM CANDIDATE c, PARTY p WHERE salary > 5000 AND p.partyid = c.partyid
UNION SELECT lname, partydesc, 'Not so honest' FROM CANDIDATE c, PARTY p WHERE salary BETWEEN 50000 and 100000 AND p.partyid = c.partyid
UNION SELECT lname, partydesc, '80000' FROM CANDIDATE c, PARTY p WHERE salary > 100000 AND p.partyid = c.partyid
ORDER BY lname;


/**
/**
2) Display the name and the corresponding description based on the candidates
salary (Use a plain case statement in chapter 5)
< 50000 Honest
>50000 and < 100000 Not so honest
>100000 80000
*/
SELECT
    lname,
    partydesc,
    CASE
        WHEN salary < 50000 THEN 'Honest'
        WHEN salary BETWEEN 50000
        AND 100000 THEN 'Not so honest'
        ELSE '80000'
    END AS salary
FROM
    CANDIDATE c,
    PARTY p
WHERE
    p.partyid = c.partyid;

/**
3) Display the name of all the people who are not associated with a party (use not in).
This is a bit tricky because people who don’t have a party_id will have a null and you
cannot compare a null using not in because it doesn’t know how to deal with non-data.
You can put the party_id in an NVL function in the where clause to resolve this issue
*/
SELECT fname, lname FROM MENDO_CANDIDATE WHERE partyid NOT IN (SELECT NVL(partyid, 0) FROM MENDO_CANDIDATE);