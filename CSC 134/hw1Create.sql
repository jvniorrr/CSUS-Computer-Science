-- 1A: Create student table
CREATE TABLE mendo_student(
  SSN   VARCHAR2(20) PRIMARY KEY,
  lname VARCHAR2(20),
  fname VARCHAR2(20),
  age NUMBER,
  salary NUMBER,
  dob NUMBER
);

-- 1B: add a candidate key based on the lname and fname; candidate and unique key are the same
ALTER TABLE mendo_student ADD CONSTRAINT mendo_student_lname_fname_key UNIQUE (lname, fname);

-- 1C: add a check constraint such that the age is greater than 10 but less than 50. provide a name for check constraint
ALTER TABLE mendo_student ADD CONSTRAINT mendo_student_age_check CHECK (age > 10 and age < 50);

-- 1D: add a column called address
ALTER TABLE mendo_student ADD address VARCHAR2(20);

-- 1E: Modify the dob column to be of datatype data and also not null. Also name it dob_nn
ALTER TABLE mendo_student MODIFY dob DATE NOT NULL;

-- 1F: Create a composite index on ssn and dob
CREATE INDEX mendot_student_ssn_dob_index ON mendo_student (ssn, dob);

-- 1G: add a column called transferable with a not null constraint. Do not assign a name to the constraint. OF TYPE character.
ALTER TABLE mendo_student ADD transferable CHAR(1) NOT NULL;

-- 1H: Add a check constraint on the column transferable to allow only 'y', 'Y', 'N', 'N'. Give the constraint a name.
ALTER TABLE mendo_student ADD CONSTRAINT transferable_check  CHECK (transferable IN ('y', 'Y', 'n', 'N'));

-- 1I: Drop the age column
ALTER TABLE mendo_student DROP COLUMN age;


-- #2A: Create a second table called class that will hold following data. We decide the data type. Class_code & class_description. In the create table statement make Class description teh candidate key and also make it not null.
CREATE TABLE mendo_class(
    class_code NUMBER,
    class_desc VARCHAR2(20) UNIQUE NOT NULL
);

-- 2B: Add the primary key. Give the cosntraint a name.
ALTER TABLE mendo_class ADD CONSTRAINT mendo_class_pk PRIMARY KEY (class_code);

-- 2C: Create an index on the class decription
CREATE INDEX classs_desc_index ON mendo_class (class_desc);

-- 3A: Create a third table called student_Class. this table is an association table that contains information on the different class that the students are taking. It should only contain 2 columns.
CREATE TABLE mendo_student_class(
    ssn VARCHAR2(20),
    class_code NUMBER
);

-- 3B: Add the primary give. Name the constraint
ALTER TABLE mendo_student_class ADD CONSTRAINT mendo_student_class_pk PRIMARY KEY (ssn, class_code);

-- 3C: Add the Foreign key constraints. Name the constraints
ALTER TABLE mendo_student_class ADD CONSTRAINT mendo_student_class_ssn_fk FOREIGN KEY (ssn) REFERENCES mendo_student (ssn);
ALTER TABLE mendo_student_class ADD CONSTRAINT mendo_student_class_code_fk FOREIGN KEY (class_code) REFERENCES mendo_class (class_code);