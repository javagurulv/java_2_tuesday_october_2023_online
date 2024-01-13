SELECT client_id
FROM clients
INNER JOIN member_card
ON clients.client_id = member_card.term_of_contract
WHERE term_of_contract IS NULL;

SELECT fitness_center_id
FROM fitness_centres
INNER JOIN member_card
ON fitness_centres.fitness_center_id = member_card.client_id
WHERE term_of_contract IS NULL;

SELECT * FROM member_card
INNER JOIN fitness_centres
ON member_card.fitness_center_id = fitness_centres.id
WHERE fitness_centres.fitness_centre = "IMANTA";

SELECT *FROM member_card
INNER JOIN workouts
ON member_card.workout_id = workouts.id
WHERE workouts.workout = "GYM";
