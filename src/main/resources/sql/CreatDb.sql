create database gunmarket;

  use gunmarket;

create table shop
(
  shop_Id int auto_increment primary key,
  name    varchar(64)  null,
  constraint shop_id_uindex
  unique (shop_Id)
);

create table product
(
  product_id int auto_increment primary key,
  name     varchar(64)  null,
  constraint product_id_uindex
  unique (product_id)
);