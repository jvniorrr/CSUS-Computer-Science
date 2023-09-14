-- #1A
CREATE TABLE mendo_student(ssn VARCHAR2(20) PRIMARY KEY, lname VARCHAR2(20), fname VARCHAR2(20), age NUMBER, salary NUMBER, dob NUMBER);

-- #1B
ALTER TABLE mendo_student ADD CONSTRAINT name_uk UNIQUE (lname, fname);
-- #1C
ALTER TABLE mendo_student ADD CONSTRAINT age_ck CHECK(age > 10 AND age < 50);
-- #1D
ALTER TABLE mendo_student ADD (address VARCHAR2(2));
-- #1E
ALTER TABLE mendo_student MODIFY dob DATE NOT NULL;
-- #1F
CREATE INDEX mendo_student_ssn_dob_idx ON mendo_student(ssn, dob);
-- #1G
ALTER TABLE mendo_student ADD (transferable CHAR(1)) NOT NULL;
-- #1H
ALTER TABLE mendo_student ADD CONSTRAINT transferable_ck CHECK(transferable in ('y', 'Y', 'n', 'N'));
-- #1I
ALTER TABLE mendo_student DROP COLUMN (age);

-- #2A
CREATE TABLE mendo_class(
    class_code NUMBER,
    class_description VARCHAR2(20) UNIQUE NOT NULL,
);
-- #2B
ALTER TABLE mendo_class ADD CONTRAINT class_code_pk PRIMARY KEY (class_code);
-- #2C
CREATE INDEX mendo_class_description_idx ON mendo_class(class_description);

-- #3A
CREATE TABLE student_class(
    student_ssn VARCHAR2(20),
    student_class_code NUMBER
);
-- #3B
ALTER TABLE student_class ADD CONSTRAINT student_class_pk PRIMARY KEY(student_ssn, student_class_code);
-- #3C
ALTER TABLE student_class ADD CONSTRAINT student_class_ssn_fk FOREIGN KEY(student_ssn) REFERENCES mendo_student(ssn);
ALTER TABLE student_class ADD CONSTRAINT student_class_code_fk FOREIGN KEY(student_class_code) REFERENCES mendo_class(class_code);