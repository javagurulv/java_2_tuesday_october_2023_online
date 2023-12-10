insert into clients(first_name, last_name, personal_code)
values ('firstnameA', 'lastnameA', 11111);

insert into clients(id, first_name, last_name, personal_code)
values (102, 'firstnameB', 'lastnameB', 22222);

insert into clients(id, first_name, last_name, personal_code)
values (103, 'firstnameC', 'lastnameC', 33333);

insert into clients(id, first_name, last_name, personal_code)
values (103, 'firstnameD', 'lastnameD', 33A22);

insert into age_groups(age_group)
values ('CHILD');

insert into age_groups(id, age_group)
values (2, 'ADULT');

insert into age_groups(id, age_group)
values (3, 'SENIOR');


insert into workouts(workout)
values ('GYM');

insert into workouts(id, workout)
values (2, 'SWIMMING_POOL');

insert into workouts(id, workout)
values (3, 'GROUP_CLASSES');


insert into fitness_centres(fitness_centre)
values ('IMANTA');

insert into fitness_centres(id, fitness_centre)
values (101, 'AKROPOLE');

insert into fitness_centres(id, fitness_centre)
values (102, 'SAGA');

insert into fitness_centres(id, fitness_centre)
values (103, 'RIGA_PLAZA');

insert into fitness_centres(id, fitness_centre)
values (104, 'ZOLITUDE');


insert into member_card(client_id, age_group_id, workout_id, fitness_centre_id, term_of_contract)
values (102, 2, 2, 101, '2024-10-10 23:59:59');

insert into member_card(client_id, age_group_id, workout_id, fitness_centre_id, term_of_contract)
values (103, 3, 3, 104, '2024-09-10 23:59:59');

