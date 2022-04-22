--liquibase formatted sql

--changeset lrygl:1

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists APPLICATION_USERS CASCADE;


cREATE TABLE IF NOT EXISTS application_users(
    id SERIAL CONSTRAINT application_users_pk PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    username VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    company VARCHAR(100),
    profileImageUrl VARCHAR(100),
    lastLoginDate DATE,
    lastLoginDateDisplay DATE,
    joinDate DATE,
    updatedDate DATE,
    role VARCHAR,
    authorities VARCHAR,
    isActive BOOLEAN,
    isNotLocked BOOLEAN
)

select * from application_users au ;


CREATE TABLE IF NOT EXISTS course(
    id int CONSTRAINT course_pk PRIMARY KEY,
    courseId uuid DEFAULT uuid_generate_v4() NOT NULL
)

CREATE TABLE user_courses(
    id int NOT NULL CONSTRAINT user_course_pk PRIMARY KEY,
    userId int NOT null,
    courseId int NOT NULL,
    dateJoined date NOT null,

    FOREIGN KEY (userId) REFERENCES application_users(id),
    FOREIGN KEY (courseId) REFERENCES course(id)
)



create table lesson()

create table course_lesson()

insert into APPLICATION_USERS values (
	DEFAULT,'Lubomír','Rýgl','lordxray','123','lrygl@gmail.com','Mentors.cz','123'

)

