package com.example.javaweb.database;

public class Tables {
    /**
    1. products
    create table products(
        id int primary key auto_increment,
        name varchar(256) not null unique,
        price float not null,
        img varchar(256) default 'default.jpg',
        category_id int,
        created_at timestamp default current_timestamp,
        foreign key (category_id) references category(id)
    );
     */
}
