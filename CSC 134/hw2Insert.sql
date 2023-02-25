-- BUILDING ON TOP OF HW1 CREATED TABLES

-- 1A: Insert three rows of valid data into the student_class table
DESC mendo_student;
DESC mendo_class;
-- INSERTION TO MENDO_STUDENT
INSERT INTO mendo_student  VALUES( '100', 'doe', 'john', 25000, '01 FEB 90', '123 Address', 'Y');
INSERT INTO mendo_student  VALUES( '101', 'last', 'chris', 30000, '05 FEB 95', '101 Address', 'N');
INSERT INTO mendo_student  VALUES( '102', 'hall', 'adan', 19000, '02 MAR 90', '199 Address', 'y');

-- 1A: Insert three rows of valid data into student_class table
INSERT INTO mendo_student_class VALUES('100', 1);
INSERT INTO mendo_student_class VALUES('101', 2);
INSERT INTO mendo_student_class VALUES('102', 3);

-- 1B: Insert two rows of valid data into the class table according to the following. Make sure that you provide a value for every column.
-- INSERTION TO MENDO_CLASS
INSERT INTO mendo_class VALUES (1, 'CSC');
INSERT INTO mendo_class VALUES (2, 'CPE');
INSERT INTO mendo_class VALUES (3, 'CE');

-- 1C: INSERT two rows of valid data into the student table according to the following. Provide a value for every column.
-- For the 1st row,, use the to date fuinction to insert into the DOB column in the format(yyddmm)
-- For the 2nd row, use the default date format. (use default)
INSERT INTO mendo_student VALUES('104', 'smith', 'jane', 35000, TO_DATE('901402', 'yyddmm'), '14 Address', 'Y');
INSERT INTO mendo_student VALUES('106', 'jones', 'john', 50000, '01 JAN 90', '15 Address', 'n');


-- 2A: Insert a row of invalid data into student table such that it violates the primary key.
INSERT INTO mendo_student VALUES('100', 'john', 'doe', 500, '23 JAN 95', '50 Main st', 'n');

-- 2B: Insert a row of invalid data into student table that violates the candidate key. 
INSERT INTO mendo_student VALUES('110', 'doe', 'john', 50, '05 FEB 99', '123 Hornet Drive', 'N');

-- 2C: Insert a row of invalid data into student table such that it violates the check constraint.
INSERT INTO mendo_student VALUES('107', 'jones', 'john', 10000, '08 APR 99', '123 Hornet Drive', 'C');

-- 2D: Insert a row of invalid data into the student class table such that it violates the foreign key to the class table.
INSERT INTO mendo_student_class VALUES('104', 4);

-- 2E: Insert a row iof invalid data into student_class such that it violates the foreign key to the student table.
INSERT INTO mendo_student_class VALUES('200', 3);

-- 2F: Insert a row of invalid data into the student_class table such that it violates the primary key in the student_class table.
INSERT INTO mendo_student VALUES('100', 'hall', 'chris', 20000, '01 MAY 90', '7 Hornet Drive', 'n');

-- 3A: Disable the foreign key constyraint to the student table.
ALTER TABLE mendo_student_class DISABLE CONSTRAINT MENDO_STUDENT_CLASS_SSN_FK;

-- 3B: Insert a rows of data into the student_class table such that it would violate the foreign key constraint if the above  constraint to the student table  was enabled
INSERT INTO mendo_student_class VALUES('200', 3);

-- 3C: Enable the foreign key constraint to the student table.
ALTER TABLE mendo_student_class ENABLE CONSTRAINT MENDO_STUDENT_CLASS_SSN_FK;

-- 4A: Delete the data from the student class table.
DELETE FROM mendo_student_class;

-- 4B: Tructate the student table.
TRUNCATE TABLE mendo_student;

-- 4C: Drop the inex we create on the student table
DROP INDEX mendot_student_ssn_dob_index;

-- 4D: Drop the foreign key constraints
ALTER TABLE mendo_student_class DROP CONSTRAINT MENDO_STUDENT_CLASS_SSN_FK;

-- 4E: Drop the student table
DROP TABLE mendo_student;