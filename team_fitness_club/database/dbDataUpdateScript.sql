
UPDATE clients
SET first_name = 'firstnameF', last_name = 'lastnameF', personal_code = 5555
WHERE personal_code = 22222;

UPDATE clients
SET first_name = "firstnameD"
WHERE personal_code = 11111;

UPDATE clients
SET last_name = "lastnameD"
WHERE personal_code = 11111;