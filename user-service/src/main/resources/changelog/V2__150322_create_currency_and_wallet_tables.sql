create table currency (
    id smallserial primary key,
    name varchar(3) not null check (upper(name) = name)
);

create table wallet (
    id UUID primary key default gen_random_uuid(),
    user_id UUID not null references app_user (id),
    currency_id bigint not null references currency (id),
    amount numeric(100,2) not null check (amount > 0)
);