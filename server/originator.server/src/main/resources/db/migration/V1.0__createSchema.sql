create table subject (subject_id bigint(20) auto_increment primary key, subject_name varchar(50) not null);
create table que_type (type_id bigint(20) auto_increment primary key, type_name varchar(50) not null);
create table user (user_id bigint(20) auto_increment primary key, first_name varchar(50) not null, last_name varchar(50) not null, email varchar(50) not null, password varchar(255) not null);
create table questions (question_id bigint(20) auto_increment primary key, question varchar(255) not null,
type_id bigint(20) references que_type(type_id), answer varchar(255) not null, is_image bit(1) default 0, subject_id bigint(20) references subject(subject_id));

create table choices (choice_id bigint(20) auto_increment primary key, choice varchar(255) not null,
is_image bit(1) default 0, question_id bigint(20) references questions(question_id));