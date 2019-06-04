create table cars (
  id integer primary key
  , name text not null
  , grade_id integer
  , shop_id integer
  , imagePath text not null
  , deleted boolean default false not null
) ;

create table grades (
  id integer primary key
  , name text not null
  , price integer
) ;

create table shops ( 
  id integer primary key
  , name text not null
  , address text
) ;

create table options (
  id integer primary key
  , name text not null
  , price integer not null
) ;

create table reservation_cars (
    id serial primary key
    , car_id integer not null
    , reservation_id integer not null
    , start_date timestamp not null
    , end_date timestamp not null
    , user_id integer not null
);