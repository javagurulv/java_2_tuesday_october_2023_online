
SELECT * FROM clients;
SELECT * FROM age_groups;
SELECT * FROM workouts;
SELECT * FROM fitness_centres;
SELECT * FROM member_card;


SELECT * FROM clients WHERE id = 102;
SELECT * FROM age_groups WHERE id = 2;
SELECT * FROM workouts WHERE id = 3;
SELECT * FROM fitness_centres WHERE id = 2;
SELECT * FROM member_card WHERE id = 1;


SELECT * FROM clients WHERE first_name = 'firstnameB';

SELECT * FROM clients WHERE first_name = 'firstnameA' AND last_name = 'lastnameA';

SELECT * FROM clients ORDER BY last_name DESC;

SELECT * FROM clients WHERE first_name = 'firstnameA' LIMIT 5;


