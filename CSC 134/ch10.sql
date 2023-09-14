
/* 


    IN CLASS:
    
    -- create table Cols A, B, C, D
    A,      B,       C,      D
    ColA,   ColB,    ColC,   ColD
    1,      2,       3,      4
    2,      3,       4,      5,
    3,      4,       5,      6, 
    4,      5,       6,      7, 

    join-group in class
    How many rows in each one?
    1. Select * from  A, B, C, D where cola=colb;
        Rewrite using on clause

    2. Select * from  A, B, C, D WHERE cola=colb and colb=colc;
        Rows: 2 x 4 = 8
        Rewrite using ON clause: SELECT * FROM a, b, c, d ON a.cola=b.colb AND b.colb=c.colc;
        SELECT * FROM a JOIN b on AND b join c on ON a.cola=b.colb AND b.colb=c.colc;
    
    3. SELECT * FROM, A, B, C, D WHERE cola=colb AND cola=colc;
        Rows: 2 x 4 = 8
        Rewrite using on clause

    4. SELECT * FROM A, B, C, D WHERE cola=colb(+)
        Rewrite using left and right outer join
        SELECT * FROM A LEFT OUTER JOIN B ON cola-colb, c, d
        SELECT * FROM B RIGHT OUTER JOIN A ON cola-colb, c, d

    5. SELECT * FROM A, B, C , D WHERE cola=colb+) AND colb=colc(+)
        Rewrite using left and right outer join
        SELECT FROM A LEFT OUTER JOIN B ON cola=colb, C LEFT OUTER JOIN D ON colb=colc
    
 */

 /* CHECK 10C 
 
 1. Display the fname and personality description of all with salaries greater than 10000. Union the results with all those who are making less than 5000. 

 2a. SELECT name, NVL(personality_desc, 'no_personality') from person p WHERE NOT EXISTS( SELECT perid FROM personality pp WHERE pp.perid=p.perid);
 2b. SELECT name, 'no personlaity' FROM person MINUS SELECT 'no personality' FROM personality WHERE desc IS NOT NULL;
 2c. SELECT name, NVL(personality_desc, 'no_personality') from person p WHERE perid NOT IN (SELECT perid FROM personality pp WHERE pp.perid=p.perid);

 in the case the inner sub query has the fields 'null' would need to use the EXISTS clause to check for nulls in the inner sub query
 */


 /* SUMMARY
 
 1. How  many rows will be returned in a Cartesion paroduct of two tables one which has 5 records and the other 10? 
    50
2. What is CROSS JOIN?
    A cross join is a join that returns all possible combinations of rows from the two tables. Its the Cartesian product of the two tables.
3. How many join conditions do you need in the where clause to do an inner join between five tables?
    4
4. Which of the following create a cartesian product
    a) SELECT title, authorid FROM books, bookauthor; 
    b) SELECT title, name FROM  books, bookauthor, WHERE books.isbn=books.isbn;
    c) all the above; <-- correct
    e) a and b
    f) a and c
    g) b and c

5. How do you get the following result set? (write the SQL statement)
    SELECT name, description FROM candidate, party WHERE candidate.partyid!=9;
    SELECt name, description FROM candidate, party WHERE EXISTS (SELECT description FROM party);
    SELECT name, description FROM candidate, party WHERE description NOT IN ('independent', 'Green', 'libertarian');

    SELECT name, description FROM candidate c WHERE NOT EXISTS (SELECT c_id from candidate WHEERE c_id=c.c_id AND partyid!=9);

    SELECT name, description FROM candidate natural join party;
    SELECT name, description FROM candidate c, party p WHERE c.id=p.id;
    SELECT name, description FROM candidate c join party p on c.id=p.id;
    SELECT name, description from candidate join party using (id);

6. How do you get the following reuslt set?
name description
---- ------------
jack republican
john democrat
jill republican

SELECT name, description FROM candidate c, party p WHERE p.id(+)=c.id;
SELECT name, description FROM candidate c RIGHT OUTER JOIN party p ON p.id=c.id;

8. How do you display the id that is in the party table but not in the candidate table using exists, in and minus) 
    SELECT id FROM party WHERE NOT EXISTS (SELECT id FROM candidate WHERE id=party.id);
    SELECT id FROM party WHERE id NOT IN (SELECT id FROM candidate);
    SELECT id FROM party MINUS SELECT id FROM candidate;
  */


/* NOTES
Cartesian Product / Cross Join: replicates every col in table one with every col in table two
Equality Join / Equijoin or Inner Join or Simple Join: Creates join by using commmonly named & defined col's
Non-Equality Join: joins tablers when there are no equivalent rows in tables to be joined
Self-join: joins table to itself
Outer Join: includes records of a table when there is no matching record in other table
set operators; UNION, UNION ALL, INTERSECT, and MINUS: used to combine results of two or more SELECT statements
    UNION: combines results of two or more SELECT statements, removes duplicates
    UNION ALL: combines results of two or more SELECT statements, includes duplicates
    INTERSECT: returns rows that are common to both result sets
    MINUS: returns rows that are in the first result set but not in the second result set

WHERE: in traditional approach, WHERE clause indicates which col's should be joined
NATURAL JOIN: the kwd's are used in the FROM clause to join tables containing a common column w/ the same name & function.
JOIN ... USING: the JOIN kwd is used in the FROM clause; combined w/ the USING clause, it identifies the cmmon column used to join the tables
JOIN ... ON: the JOIN kwd is sused in the FROM clause. the ON clause idenfities col's used to join the tables
OUTER JOIN can be used with LEFT, RIGHT, FULL: indicates that at least one of tables doesn't have a matching row in other table


 */