create sequence hibernate_sequence start with 1 increment by 1;
create table users(
    username varchar(255) not null,
    first_name varchar(255) not null,
    surname varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    enabled boolean not null,
    primary key (username)
);
create table item(
    id bigint not null,
    title varchar(255) not null,
    description varchar(255) not null,
    avg_rating double precision,
    category varchar(255) not null,
    primary key(id)
);
create table rank(
    id bigint not null,
    rating integer not null check ( rating <= 5 and rating >= 1),
    comment varchar(1000),
    ranking_by_username varchar(255) not null,
    item_info_id bigint not null,
    primary key (id)
);
create table users_ranked_items(
    authors_ranked_username varchar(255) not null,
    ranked_items_id bigint not null
);
create table user_roles (
    user_username varchar(255) not null,
    roles varchar(255)
);

alter table users add constraint  UK_46ccwnsi9409t36lurvtyljak unique (email);

-- I use " on delete cascade " If i would delete or update the Rank class by the user.
alter table rank add constraint  UK_rnmswl6u0o5dwjq14nm5248je foreign key (ranking_by_username) references users on delete cascade;

alter table rank add constraint FK4t4a8c1ploau9vfknu3t6tl7d foreign key (item_info_id) references item;
alter table users_ranked_items add constraint FKwqtq0m711iiym2m781dqr6n4 foreign key (ranked_items_id) references item;
alter table users_ranked_items add constraint FKlqrv1aj0pon999jbi5esfpe4k foreign key (authors_ranked_username) references users;
alter table user_roles add constraint FKs9rxtuttxq2ln7mtp37s4clce foreign key (user_username) references users;