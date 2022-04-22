--liquibase formatted sql

--changeset lrygl:1
CREATE TABLE IF NOT EXISTS application_user(
    id int,
    first_name varchar(100),
    last_name varchar(100)

)