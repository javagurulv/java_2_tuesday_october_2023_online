
SELECT * FROM member_card
INNER JOIN fitness_centres ON member_card.fitness_centre_id = fitness_centres.id
WHERE fitness_centres.fitness_centre = "IMANTA";

SELECT *FROM member_card
INNER JOIN workouts ON member_card.workout_id = workouts.id
WHERE workouts.workout = "GYM";

SELECT clients.first_name, clients.last_name FROM clients
INNER JOIN member_card ON clients.id = member_card.client_id
WHERE clients.gender = "male";

SELECT clients.first_name, clients.last_name FROM clients
INNER JOIN member_card ON clients.id = member_card.client_id
WHERE clients.gender = "male"
ORDER BY clients.last_name ASC;