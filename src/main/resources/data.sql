INSERT INTO brand (full_name, short_name) VALUES ('brand-name1','brand-name1');
INSERT INTO brand (full_name, short_name) VALUES ('brand-name2','brand-name2');
INSERT INTO brand (full_name, short_name) VALUES ('brand-name3','brand-name3');

INSERT INTO caliber (value) VALUES ('caliber-value1');
INSERT INTO caliber (value) VALUES ('caliber-value2');
INSERT INTO caliber (value) VALUES ('caliber-value3');
INSERT INTO caliber (value) VALUES ('caliber-value4');

INSERT INTO type (lower, medium, upper) VALUES ('lower1', 'medium1', 'upper1');
INSERT INTO type (lower, medium, upper) VALUES ('lower2', 'medium2', 'upper2');

INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-1');
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-2');
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-3');
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-4');

INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Gun',  1,  100, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 1,    1, 1);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Gun',  2,  90, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     2, 2,    1, 2);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Gun',  3,  80, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     3, 2,    2, 3);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Gun',  4,  70, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 3,    2, 4);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Part', 5,  60, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 1);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Part', 6,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 2);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Part', 7,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 3);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Ammo', 8,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     2, 2,    2, null);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Ammo', 9,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 3,    2, null);
INSERT INTO product (dtype, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Ammo', 10, 10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 4,    2, null);

INSERT INTO shop (address, name, website) VALUES ('address1', 'shop-name1', 'www.com.1');
INSERT INTO shop (address, name, website) VALUES ('address2', 'shop-name2', 'www.com.2');

INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', false, 'link', 10, 5, 1,  1);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 2,  1);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 3,  1);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 4,  1);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', false, 'link', 10, 5, 5,  1);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', false, 'link', 10, 5, 6,  2);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 7,  2);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 8,  2);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', true,  'link', 10, 0, 9,  2);
INSERT INTO product_in_shop (additional_info, in_stock, link, price, sale, product_id, shop_id) VALUES ('info', false, 'link', 10, 5, 10, 2);
