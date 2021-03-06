drop table roles, users, user_roles;


create table users
(
    id       int          not null auto_increment primary key,
    username varchar(255) not null,
    lastName varchar(255) not null,
    email    varchar(255) not null,
    age      int          not null,
    password varchar(255) not null
);

create table roles
(
    id   int          not null auto_increment primary key,
    name varchar(255) not null
);

create table user_roles
(
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),

    unique (user_id, role_id)

);

insert into users
values (1, 'admin', 'admins', 'j@mail.ru', 23, '$2a$12$O9oNtRJoRCuRjH6O/aCUyerSFkS1tmZMBaoKSAfgts.XIfAEEw4VO');
insert into users
values (2, 'user', 'users', 'user@mail.ru', 20, '$2a$12$O9oNtRJoRCuRjH6O/aCUyerSFkS1tmZMBaoKSAfgts.XIfAEEw4VO');
insert into users
values (3, 'user1', 'users1', 'user1@mail.ru', 22, '$2a$12$O9oNtRJoRCuRjH6O/aCUyerSFkS1tmZMBaoKSAfgts.XIfAEEw4VO');

insert into roles
values (1, 'ROLE_USER');
insert into roles
values (2, 'ROLE_ADMIN');

insert into user_roles
values (1, 2);
insert into user_roles
values (2, 1);
insert into user_roles
values (3, 1);

select *
from users;
select *
from roles;
select *
from user_roles;