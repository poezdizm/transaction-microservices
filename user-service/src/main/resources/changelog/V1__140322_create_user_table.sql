create extension pgcrypto;

create table app_user (
    id UUID primary key default gen_random_uuid(),
    name varchar not null
);