INSERT INTO clients(first_name, last_name, personal_code)
VALUES ('firstnameA', 'lastnameA', 11111);

INSERT INTO clients(id, first_name, last_name, personal_code)
VALUES (102, 'firstnameB', 'lastnameB', 22222);

INSERT INTO clients(id, first_name, last_name, personal_code)
VALUES (103, 'firstnameC', 'lastnameC', 33333);

INSERT INTO clients(id, first_name, last_name, personal_code)
VALUES (103, 'firstnameD', 'lastnameD', 33A22);

INSERT INTO age_groups(age_group)
VALUES ('CHILD');

INSERT INTO age_groups(id, age_group)
VALUES (2, 'ADULT');

INSERT INTO age_groups(id, age_group)
VALUES (3, 'SENIOR');


INSERT INTO workouts(workout)
VALUES ('GYM');

INSERT INTO workouts(id, workout)
VALUES (2, 'SWIMMING_POOL');

INSERT INTO workouts(id, workout)
VALUES (3, 'GROUP_CLASSES');


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

