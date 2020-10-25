insert into users (id, first_name, last_name, email, password, role)
values (5, 'Leo', 'Jones', 'LeoJones@example.com', 'basicPassword', 'STUDENT');

insert into users (id, first_name, last_name, email, password, role)
values (6, 'Jonathan', 'Henry', 'JonathanHenry@example.com', 'otherPassword', 'AUTHOR');

insert into users (id, first_name, last_name, email, password, role)
values (7, 'Kathy', 'Perry', 'KathyPerry@example.com', 'kathyHello', 'STUDENT');

insert into courses (id, description, author_id)
values (8, 'Java Course', 6);

insert into courses (id, description, author_id)
values (9, 'SQL Course', 6);

insert into problems (ID, DESCRIPTION, DIFFICULTY, REFERENCE_SOLUTION, TEMPLATE, COURSE_ID)
values (10, 'First problem', 'EASY', 'Reference solution', 'Basic Template', 8);

insert into problems (ID, DESCRIPTION, DIFFICULTY, REFERENCE_SOLUTION, TEMPLATE, COURSE_ID)
values (11, 'Second problem', 'MEDIUM', 'Reference solution', 'Basic Template', 8);

insert into problems (ID, DESCRIPTION, DIFFICULTY, REFERENCE_SOLUTION, TEMPLATE, COURSE_ID)
values (12, 'Third problem', 'HARD', 'Reference solution', 'Basic Template', 8);

insert into problem_constraints (ID, MAXRAM, MAX_SIZE, MAX_TIME, TEST_CLASS, PROBLEM_ID)
values (13, 256, 16, 5000, 'Test class', 10);

insert into problem_constraints (ID, TEST_CLASS, PROBLEM_ID)
values (14, 'Test class', 10);