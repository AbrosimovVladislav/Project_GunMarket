create database gunmarket;

  use gunmarket;

create table caliber
(
  caliber_Id    bigint       not null
    primary key,
  caliber_value varchar(255) null
)
  engine = MyISAM;

create table manufacturer
(
  manufacturer_Id   bigint       not null
    primary key,
  manufacturer_name varchar(255) null
)
  engine = MyISAM;

create table weaponplatform
(
  weaponPlatform_Id   bigint       not null
    primary key,
  weaponPlatform_name varchar(255) null
)
  engine = MyISAM;

create table product
(
  product_Id          bigint       not null
    primary key,
  DTYPE               varchar(31)  not null,
  product_name        varchar(255) null,
  product_price       varchar(255) null,
  product_category    varchar(255) null,
  gun_subcategory     varchar(255) null,
  part_inner_or_outer varchar(255) null,
  part_subcategory    varchar(255) null,
  caliber_Id          bigint       not null,
  manufacturer_Id     bigint       not null,
  weaponPlatform_Id   bigint       not null
)
  engine = MyISAM;

create index FKbhrx8b3q5gc028eqboyifrid5
  on product (weaponPlatform_Id);

create index FKljcdsn5t3hwpl7apqjbr94tu
  on product (caliber_Id);

create index FKstwveqd7hqo77su1vancy832y
  on product (manufacturer_Id);

create table shop
(
  shop_Id bigint       not null
    primary key,
  address varchar(255) null,
  name    varchar(255) null,
  website varchar(255) null
)
  engine = MyISAM;

create table shop_product
(
  shop_Id    bigint not null,
  product_Id bigint not null,
  primary key (shop_Id, product_Id)
)
  engine = MyISAM;

create index FKhw852msmm9o4wlxskihuveygq
  on shop_product (product_Id);



