insert into clients(first_name, last_name, personal_code, gender)
values ("firstnameA", "lastnameA", 11111, "female");

insert into clients(id, first_name, last_name, personal_code, gender)
values (1235, "firstnameB", "lastnameB", 22222, "male");

insert into clients(id, first_name, last_name, personal_code, gender)
values (1234, "firstnameC", "lastnameC", 33333, "male");

insert into age_groups(id, age_group)
values (112, "ADULT");

insert into workouts(id, workout)
values (113, "GYM");

insert into fitness_centres(id, fitness_centre)
values (114, "IMANTA");

insert into age_groups(id, age_group)
values (115, "CHILD");

insert into workouts(id, workout)
values (116, "GROUP_CLASSES");

insert into fitness_centres(id, fitness_centre)
values (117, "SAGA");

insert into member_card(client_id, age_group_id, workout_id, fitness_centre_id, term_of_contract)
values (1234, 112, 113, 114, "2024-10-10 23:00:00");

insert into member_card(client_id, age_group_id, workout_id, fitness_centre_id, term_of_contract)
values (1235, 115, 116, 117, "2024-09-10 23:00:00");

