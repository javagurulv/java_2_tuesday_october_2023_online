update clients
set first_name = "firstnameF", last_name = "lastnameF", personal_code = 5555, gender = "male"
where personal_code = 22222;

update clients
set first_name = "firstnameD"
where personal_code = 11111;

update clients
set last_name = "lastnameD"
where personal_code = 11111;