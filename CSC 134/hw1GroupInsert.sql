-- 1: Recreate the candidate table Candidate
    --  Candidate_id   (Primary key)
    --  First_name      (UK  composite)
    --  Last_Name     (UK  composite)
    --  DOB 
    --  Salary              (check constraint Salary > 10000 and less than 50000) 
    --  Party_id           (FK)

CREATE TABLE mendo_candidate(
    candidate_id NUMBER CONSTRAINT mendo_candidate_pk PRIMARY KEY,
    first_name VARCHAR2(20) UNIQUE,
    last_name VARCHAR2(20) UNIQUE,
    dob DATE,
    salary NUMBER,
    party_id NUMBER,
    CONSTRAINT mendo_candidate_salary_check CHECK (salary > 10000 and salary < 50000),
    CONSTRAINT mendo_candidate_party_id_fk FOREIGN KEY (party_id) REFERENCES mendo_party (party_id)
);

-- Recreate the part table as such:
-- Party
--      Party_id        (Primary key)
--      	     PartyDesc    (Unique key)
CREATE TABLE mendo_party(
    party_id NUMBER CONSTRAINT mendo_party_pk PRIMARY KEY,
    party_desc VARCHAR2(20) UNIQUE
);


-- 2: INSERT two rows into each of the above tables. You have to populate the tables in the proper order.
-- populate the party table first
INSERT INTO mendo_party VALUES(1, 'Democrat');
INSERT INTO mendo_party VALUES(2, 'Republican');
-- populate the candidate table
INSERT INTO mendo_candidate VALUES(1, 'John', 'Smith', '01-JAN-1980', 20000, 1);
INSERT INTO mendo_candidate VALUES(2, 'Jones', 'John', '02-MAR-1999', 40000, 2);

-- 3: Insert two rows into the candidate table. Populate the candidate table, in one row insert the date using the (mmddyy) format and another insert using (ddyymm) format
INSERT INTO mendo_candidate VALUES(3, 'Johnny', 'Appleseed', TO_DATE('020599', 'mmddyy'), 20000, 1);
INSERT INTO mendo_candidate VALUES(4, 'Chris', 'Hall', TO_DATE('199902', 'ddyymm'), 30000, 1);

-- 4: Display the DOB information from the cnadidate table in mmddyyyy format
SELECT TO_CHAR(dob, 'mmddyyyy') as DOB FROM mendo_candidate;

-- 5: Display the DOB information from the candidate table in ddyyymm hh12:mi:ss format
SELECT TO_CHAR(dob, 'ddyyymm hh12:mi:ss') as DOB FROM mendo_candidate;

-- 6: Insert another row into candidate table such that it violates the check constraint
INSERT INTO mendo_candidate VALUES(5, 'Chuck', 'Liddel', TO_DATE('011298', 'mmddyy'), 60000, 1);

-- 7: Insert another row into party such that it violates the unique constraint
INSERT INTO mendo_party VALUES(3, 'Democrat');

-- 8: Display the constraint information on both tables using the system table user_constraints
SELECT * FROM user_constraints WHERE table_name = 'MENDO_PARTY' OR table_name = 'MENDO_CANDIDATE'; 