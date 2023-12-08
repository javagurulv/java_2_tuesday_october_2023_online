select * from age_groups;
select * from clients;
select * from fitness_centres;
select * from member_card;
select * from workouts;

select * from age_groups where id = 112;
select * from clients where id = 1234;
select * from fitness_centres where id = 114;
select * from member_card where id = 1002;
select * from workouts where id = 113;

select * from age_groups where age_group = "ADULT";
select * from clients where first_name = "firtnameA" and last_name = "lastnameA";
select * from clients where gender = "male" order by last_name desc;
select * from clients where gender = "male" limit 1;


