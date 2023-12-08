select * from member_card
inner join fitness_centres on member_card.fitness_centre_id = fitness_centres.id
where fitness_centres.fitness_centre = "IMANTA";

select * from member_card
inner join workouts on member_card.workout_id = workouts.id
where workouts.workout = "GYM";

select clients.first_name, clients.last_name from clients
inner join member_card on clients.id = member_card.client_id
where clients.gender = "male";

select clients.first_name, clients.last_name from clients
inner join member_card on clients.id = member_card.client_id
where clients.gender = "male"
order by clients.last_name asc;