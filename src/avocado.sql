
create table avocado
(
no number constraint person_pk primary key,
name varchar2(15) not null,
age varchar2(3),
job varchar2(15)
);

create sequence person_seq
start with 1
increment by 1
nocycle
nocache;

select * from person;