insert into brand (name) values ('brand-name1');
insert into brand (name) values ('brand-name2');
insert into brand (name) values ('brand-name3');

insert into caliber (value) values ('caliber-value1');
insert into caliber (value) values ('caliber-value2');
insert into caliber (value) values ('caliber-value3');
insert into caliber (value) values ('caliber-value4');

insert into type (lower, medium, upper) values ('lower1', 'medium1', 'upper1');
insert into type (lower, medium, upper) values ('lower2', 'medium2', 'upper2');

insert into weapon_platform (name) values ('weapon_platform-name-1');
insert into weapon_platform (name) values ('weapon_platform-name-2');
insert into weapon_platform (name) values ('weapon_platform-name-3');
insert into weapon_platform (name) values ('weapon_platform-name-4');

insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Gun',  1,  10, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 1,    1, 1);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Gun',  2,  10, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     2, 2,    1, 2);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Gun',  3,  10, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     3, 2,    2, 3);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Gun',  4,  10, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 3,    2, 4);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Part', 5,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 1);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Part', 6,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 2);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Part', 7,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 3);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Ammo', 8,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     2, 2,    2, null);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Ammo', 9,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 3,    2, null);
insert into product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
values ('Ammo', 10, 10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 4,    2, null);


insert into shop (address, description, name, website) values ('address1', 'desc1', 'shop-name1', 'www.com.1');
insert into shop (address, description, name, website) values ('address2', 'desc2', 'shop-name2', 'www.com.2');

insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', false, 'link', 10, 5, 1,  1);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 2,  1);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 3,  1);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 4,  1);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', false, 'link', 10, 5, 5,  1);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', false, 'link', 10, 5, 6,  2);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 7,  2);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 8,  2);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', true,  'link', 10, 0, 9,  2);
insert into product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) values ('info', false, 'link', 10, 5, 10, 2);
