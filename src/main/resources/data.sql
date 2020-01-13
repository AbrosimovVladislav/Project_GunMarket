CREATE OR REPLACE FUNCTION insertNewRatingOnNewShop() RETURNS TRIGGER AS $shopTrigger$
    DECLARE
        i BIGINT;
    BEGIN
        IF NEW.rating_id IS NULL THEN
            INSERT INTO rating (value) VALUES (0) RETURNING rating_id into i;
            NEW.rating_id := i;
        END IF;
        RETURN NEW;
    END;
$shopTrigger$ LANGUAGE plpgsql;;

CREATE TRIGGER shopTrigger BEFORE INSERT ON shop
FOR EACH ROW
EXECUTE FUNCTION insertNewRatingOnNewShop();;

CREATE OR REPLACE FUNCTION insertNewRatingOnNewProduct() RETURNS TRIGGER AS $productTrigger$
    DECLARE
        i BIGINT;
    BEGIN
        IF NEW.rating_id IS NULL THEN
            INSERT INTO rating (value) VALUES (0) RETURNING rating_id into i;
            NEW.rating_id := i;
        END IF;
        RETURN NEW;
    END;
$productTrigger$ LANGUAGE plpgsql;;

CREATE TRIGGER productTrigger BEFORE INSERT ON product
FOR EACH ROW
EXECUTE FUNCTION insertNewRatingOnNewProduct();;

INSERT INTO brand (full_name, short_name) VALUES ('brand-name1','brand-name1');;
INSERT INTO brand (full_name, short_name) VALUES ('brand-name2','brand-name2');;
INSERT INTO brand (full_name, short_name) VALUES ('brand-name3','brand-name3');;

INSERT INTO caliber (value) VALUES ('caliber-value1');;
INSERT INTO caliber (value) VALUES ('caliber-value2');;
INSERT INTO caliber (value) VALUES ('caliber-value3');;
INSERT INTO caliber (value) VALUES ('caliber-value4');;

INSERT INTO type (menu_item, upper, medium, lower) VALUES ('defaultMenuItem','defaultUpper1', 'defaultMedium1', 'defaultLower1');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Gladkostvol','upper', 'medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Nareznoe', 'upper','medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Ooop', 'upper','medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Shp', 'upper','medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Ammo', 'upper','medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Part', 'upper','medium', 'lower');;
INSERT INTO type (menu_item, upper, medium, lower) VALUES ('Other', 'upper','medium', 'lower');;

INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-1');;
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-2');;
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-3');;
INSERT INTO weapon_platform (name) VALUES ('weapon_platform-name-4');;

INSERT INTO product (product_type, product_id,   model, weight, color, params, barrel_length, capacity, total_length, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  1, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', '10',    null,     1, 1,    2, 1);;
INSERT INTO product (product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  2, 'ak-47',   'b_l', '10', 't_l', 'weight', null,    null,     2, 2,    3, 2);;
INSERT INTO product (product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  3, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     3, 2,    4, 3);;
INSERT INTO product (product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('GUN',  4, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', null,    null,     1, 3,    5, 4);;
INSERT INTO product (product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 5, 'model',   null,  null,     null,  null,     'color', 'params', 2, null, 7, 1);;
INSERT INTO product (product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 6,  'model',   null,  null,     null,  null,     'color', 'params', 2, null, 7, 2);;
INSERT INTO product (product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('PART', 7,  'model',   null,  null,     null,  null,     'color', 'params', 2, null, 7, 3);;
INSERT INTO product (product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 8,  '5.45 hp', null,  null,     null,  'weight', null,    null,     2, 2,    6, null);;
INSERT INTO product (product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 9,  '5.45 hp', null,  null,     null,  'weight', null,    null,     3, 3,    6, null);;
INSERT INTO product (product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('AMMO', 10, '5.45 hp', null,  null,     null,  'weight', null,    null,     3, 4,    6, null);;

INSERT INTO rating (value) VALUES (2);;
INSERT INTO rating (value) VALUES (4);;

INSERT INTO shop (name, website,rating_id) VALUES ('shop-name1', 'www.com.1',11);;
INSERT INTO shop (name, website,rating_id) VALUES ('shop-name2', 'www.com.2',12);;

UPDATE rating SET value=2 WHERE rating_id = (SELECT r.rating_id FROM rating r INNER JOIN shop s on r.rating_id = s.rating_id WHERE s.shop_id=1);;
UPDATE rating SET value=5 WHERE rating_id = (SELECT r.rating_id FROM rating r INNER JOIN shop s on r.rating_id = s.rating_id WHERE s.shop_id=2);;

INSERT INTO address (name,shop_id) VALUES ('address1',1);;
INSERT INTO address (name,shop_id) VALUES ('address2',1);;
INSERT INTO address (name,shop_id) VALUES ('address3',2);;
INSERT INTO address (name,shop_id) VALUES ('address4',2);;

INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('1:1','info', false, 'link', 10, 5, 1,  1, 0.1);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('2:1','info', true,  'link', 20, 0, 2,  1, 0.2);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('3:1','info', true,  'link', 30, 0, 3,  1, 0.3);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('4:1','info', true,  'link', 40, 0, 4,  1, 0.4);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('5:1','info', false, 'link', 50, 5, 5,  1, 0.5);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('6:2','info', false, 'link', 60, 5, 6,  2, 0.6);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('7:2','info', true,  'link', 70, 0, 7,  2, 0.7);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('8:2','info', true,  'link', 80, 0, 8,  2, 0.8);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('9:2','info', true,  'link', 90, 0, 9,  2, 0.9);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('10:2','info', false, 'link', 100, 5, 10, 2, 0.99);;
INSERT INTO product_in_shop (product_in_shop_id, additional_info, in_stock, link, price, sale, product_id, shop_id, popularity) VALUES ('1:2','info', false, 'link', 110, 5, 1, 2, 0.99);;

-- ----------------------------------------------------------------1---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','brand','short_name','brand.shortName');;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Gladkostvol', 'Бренд', 'CHECKBOX', 1);;
-- ----------------------------------------------------------------2---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product_in_shop','price','productInShop.price');;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Gladkostvol', 'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Nareznoe', 'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Ooop', 'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Shp',  'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Ammo', 'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Part', 'Цена', 'RANGE', 2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id) VALUES ('Other','Цена', 'RANGE', 2);;