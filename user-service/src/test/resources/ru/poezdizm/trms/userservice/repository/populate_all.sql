DO
'
    DECLARE u_id UUID;
    BEGIN
        u_id := gen_random_uuid();

        insert into currency(id, name)
        values (999, ''EUR'');

        insert into app_user(id, name)
        values (u_id, ''test_user'');

        insert into wallet(user_id, currency_id, amount)
        values (u_id, 999, 123.45);
END;
'  LANGUAGE PLPGSQL;