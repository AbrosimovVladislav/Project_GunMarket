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

INSERT INTO product (product_type, product_id, average_price, model, weight, color, params, barrel_length, capacity, total_length, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  1,  100, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 1,    1, 1);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  2,  90, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     2, 2,    1, 2);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  3,  80, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     3, 2,    2, 3);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  4,  70, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 3,    2, 4);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 5,  60, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 1);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 6,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 2);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 7,  10, 'model',   null,  null,       null,  null,     'color', 'params', 2, null, 1, 3);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 8,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     2, 2,    2, null);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 9,  10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 3,    2, null);
INSERT INTO product (product_type, product_id, average_price, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 10, 10, '5.45 hp', null,  null,       null,  'weight', null,    null,     3, 4,    2, null);

INSERT INTO shop (name, website) VALUES ('shop-name1', 'www.com.1');
INSERT INTO shop (name, website) VALUES ('shop-name2', 'www.com.2');

INSERT INTO address (name,shop_id) VALUES ('address1',1);
INSERT INTO address (name,shop_id) VALUES ('address2',1);
INSERT INTO address (name,shop_id) VALUES ('address3',2);
INSERT INTO address (name,shop_id) VALUES ('address4',2);

INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('1:1','info', false, 'link', 10, 5, 1,  1, 0.1);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('2:1','info', true,  'link', 10, 0, 2,  1, 0.2);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('3:1','info', true,  'link', 10, 0, 3,  1, 0.3);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('4:1','info', true,  'link', 10, 0, 4,  1, 0.4);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('5:1','info', false, 'link', 10, 5, 5,  1, 0.5);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('6:2','info', false, 'link', 10, 5, 6,  2, 0.6);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('7:2','info', true,  'link', 10, 0, 7,  2, 0.7);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('8:2','info', true,  'link', 10, 0, 8,  2, 0.8);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('9:2','info', true,  'link', 10, 0, 9,  2, 0.9);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('10:2','info', false, 'link', 10, 5, 10, 2, 0.99);
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('1:2','info', false, 'link', 10, 5, 1, 2, 0.99);

INSERT INTO rating (value, product_id) VALUES ('J',1);
INSERT INTO rating (value, product_id) VALUES ('I',2);
INSERT INTO rating (value, product_id) VALUES ('H',3);
INSERT INTO rating (value, product_id) VALUES ('G',4);
INSERT INTO rating (value, product_id) VALUES ('F',5);
INSERT INTO rating (value, product_id) VALUES ('E',6);
INSERT INTO rating (value, product_id) VALUES ('D',7);
INSERT INTO rating (value, product_id) VALUES ('C',8);
INSERT INTO rating (value, product_id) VALUES ('B',9);
INSERT INTO rating (value, product_id) VALUES ('A',10);

INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment1',2,1,null);
INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment2',8,1,null);
INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment3',5,2,null);
INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment4',5,null,1);
INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment5',5,null,1);
INSERT INTO review (pros, cons, comment, mark, product_id, shop_id) VALUES ('+','-','comment6',5,null,2);


