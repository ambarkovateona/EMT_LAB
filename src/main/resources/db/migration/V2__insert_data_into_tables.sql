insert into country (name, continent)
values ('United Kingdom', 'Europe'),
       ('United States', 'North America'),
       ('France', 'Europe'),
       ('Germany', 'Europe'),
       ('Russia', 'Europe/Asia');

insert into authors (created_at, updated_at, name, surname, country_id)
values (now(), now(), 'Jane', 'Austen',
        (select id from country where name = 'United Kingdom')),
       (now(), now(), 'George', 'Orwell',
        (select id from country where name = 'United Kingdom')),
       (now(), now(), 'Ernest', 'Hemingway',
        (select id from country where name = 'United States')),
       (now(), now(), 'Victor', 'Hugo',
        (select id from country where name = 'France')),
       (now(), now(), 'Johann', 'Goethe',
        (select id from country where name = 'Germany')),
       (now(), now(), 'Leo', 'Tolstoy',
        (select id from country where name = 'Russia'));

insert into books (created_at, updated_at, name, category, author_id, state, available_copies)
values (now(), now(), 'Pride and Prejudice', 'CLASSICS',
        (select id from authors where name = 'Jane' and surname = 'Austen'),
        'GOOD', 5),
       (now(), now(), '1984', 'THRILER',
        (select id from authors where name = 'George' and surname = 'Orwell'),
        'GOOD', 8),
       (now(), now(), 'Animal Farm', 'DRAMA',
        (select id from authors where name = 'George' and surname = 'Orwell'),
        'GOOD', 4),
       (now(), now(), 'The Old Man and the Sea', 'NOVEL',
        (select id from authors where name = 'Ernest' and surname = 'Hemingway'),
        'GOOD', 6),
       (now(), now(), 'Les Miserables', 'HISTORY',
        (select id from authors where name = 'Victor' and surname = 'Hugo'),
        'GOOD', 3),
       (now(), now(), 'Faust', 'CLASSICS',
        (select id from authors where name = 'Johann' and surname = 'Goethe'),
        'BAD', 0),
       (now(), now(), 'War and Peace', 'HISTORY',
        (select id from authors where name = 'Leo' and surname = 'Tolstoy'),
        'GOOD', 7);