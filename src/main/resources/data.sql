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

INSERT INTO product (condition, operating_principle, product_type, product_id,   model, weight, color, params, barrel_length, capacity, total_length, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Полуавтоматическое','GUN',  1, 'ak-47',   'b_l', 'capacity', 't_l', 'weight', '10',    '1000',     1, 1,    2, 1);;
INSERT INTO product (condition, operating_principle,product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Полуавтоматическое','GUN',  2, 'ak-47',   'b_l', '10', '1000', 'weight', null,    null,     2, 2,    3, 2);;
INSERT INTO product (condition, operating_principle,product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Полуавтоматическое','GUN',  3, 'ak-47',   'b_l', '10', '1000', 'weight', null,    null,     3, 2,    4, 3);;
INSERT INTO product (condition, operating_principle,product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Полуавтоматическое','GUN',  4, 'ak-47',   'b_l', '30', '1000', 'weight', null,    null,     1, 3,    5, 4);;
INSERT INTO product (condition, operating_principle,product_type, product_id,   model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Помповое','PART', 5, 'model',   null,  '10',     '1030',  null,     'color', 'params', 2, null, 7, 1);;
INSERT INTO product (condition, operating_principle,product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Помповое','PART', 6,  'model',   null,  '30',     '1330',  null,     'color', 'params', 2, null, 7, 2);;
INSERT INTO product (condition, operating_principle,product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','Помповое','PART', 7,  'model',   null,  '15',     '1220',  null,     'color', 'params', 2, null, 7, 3);;
INSERT INTO product (condition, operating_principle,product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','ПродольноСкользящее','AMMO', 8,  '5.45 hp', null,  '17',     '1001',  'weight', null,    null,     2, 2,    6, null);;
INSERT INTO product (condition, operating_principle,product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','ПродольноСкользящее','AMMO', 9,  '5.45 hp', null,  '2',     '1200',  'weight', null,    null,     3, 3,    6, null);;
INSERT INTO product (condition, operating_principle,product_type, product_id, model, barrel_length, capacity, total_length, weight, color, params, brand_id, caliber_id, type_id, weapon_platform_id)
VALUES ('Новое','ПродольноСкользящее','AMMO', 10, '5.45 hp', null,  '10',     '1040',  'weight', null,    null,     3, 4,    6, null);;

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

-- Filter Items
-- Gun filters *****************************************************************************************************************
-- ----------------------------------------------------------------1 PRICE---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product_in_shop','price','productInShop.price');;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Gladkostvol', 'Цена', 'RANGE', 1,1);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Цена', 'RANGE', 1,1);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Цена', 'RANGE', 1,1);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Цена', 'RANGE', 1,1);;
-- ----------------------------------------------------------------2 OPERATING_principle---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','operating_principle','operatingPrinciple');;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Gladkostvol', 'Прицнип действия', 'CHECKBOX', 2,2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Прицнип действия', 'CHECKBOX', 2,2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Прицнип действия', 'CHECKBOX', 2,2);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp', 'Прицнип действия', 'CHECKBOX', 2,2);;
-- ----------------------------------------------------------------3 CALIBER---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','caliber','value','caliber.value');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Калибр', 'CHECKBOX', 3,3);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Калибр', 'CHECKBOX', 3,3);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Калибр', 'CHECKBOX', 3,3);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Калибр', 'CHECKBOX', 3,3);;
-- ----------------------------------------------------------------4 BRAND---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','brand','short_name','brand.shortName');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Бренд', 'CHECKBOX', 4,4);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Бренд', 'CHECKBOX', 4,4);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop',     'Бренд', 'CHECKBOX', 4,4);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',      'Бренд', 'CHECKBOX', 4,4);;
-- ----------------------------------------------------------------5 CONDITION---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','condition','condition');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Состояние', 'CHECKBOX', 5,5);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Состояние', 'CHECKBOX', 5,5);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop',     'Состояние', 'CHECKBOX', 5,5);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',      'Состояние', 'CHECKBOX', 5,5);;
-- ----------------------------------------------------------------6 CAPACITY---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','capacity','capacity');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Емкость магазина', 'CHECKBOX', 6,6);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Емкость магазина', 'CHECKBOX',  6,6);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Емкость магазина', 'CHECKBOX',      6,6);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Емкость магазина', 'CHECKBOX',      6,6);;
-- ----------------------------------------------------------------7 BARREL_LENGTH---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','barrel_length','barrelLength');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Длина ствола', 'CHECKBOX', 7,7);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Длина ствола', 'CHECKBOX', 7,7);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Длина ствола', 'CHECKBOX', 7,7);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Длина ствола', 'CHECKBOX', 7,7);;
-- ----------------------------------------------------------------8 TOTAL_LENGTH---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','total_length','totalLength');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Общая длина', 'CHECKBOX', 8,8);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Общая длина', 'CHECKBOX',   8,8);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Общая длина', 'CHECKBOX',       8,8);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp', 'Общая длина', 'CHECKBOX',        8,8);;
-- ----------------------------------------------------------------9 BARREL_ORIENTATION---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','barrel_orientation','barrelOrientation');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Расположение стволов', 'CHECKBOX', 9,9);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Расположение стволов', 'CHECKBOX',  9,9);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Расположение стволов', 'CHECKBOX',      9,9);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Расположение стволов', 'CHECKBOX',      9,9);;
-- ----------------------------------------------------------------10 WEIGHT---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','weight','weight');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Вес', 'CHECKBOX', 10,10);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Вес', 'CHECKBOX',   10,10);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Вес', 'CHECKBOX',       10,10);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Вес', 'CHECKBOX',       10,10);;
-- ----------------------------------------------------------------11 COUNTRY---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','country','country');;
INSERT INTO filter_item (menu_item, name, type, key_path_id,rank) VALUES ('Gladkostvol', 'Страна происхождения', 'CHECKBOX', 11,11);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Nareznoe', 'Страна происхождения', 'CHECKBOX',  11,11);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ooop', 'Страна происхождения', 'CHECKBOX',      11,11);;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Shp',  'Страна происхождения', 'CHECKBOX',      11,11);;
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

-- Ammo Filters *****************************************************************************************************************
-- ----------------------------------------------------------------1 PRICE---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ammo', 'Цена', 'RANGE', 1,1);;
-- ----------------------------------------------------------------3 CALIBER---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ammo', 'Калибр', 'CHECKBOX', 3,3);;
-- ----------------------------------------------------------------4 BRAND---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ammo', 'Бренд', 'CHECKBOX', 4,4);;
-- ----------------------------------------------------------------12 CHARGE_TYPE---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','charge_type','chargeType');;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ammo', 'Тип заряда', 'CHECKBOX', 12,12);;
-- ----------------------------------------------------------------13 SLEEVE_MATERIAL---------------------------------------------------------
INSERT INTO key_path (source, target_entity, target_param, value) VALUES ('product','product','sleeve_material','sleeveMaterial');;
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Ammo', 'Материал гильзы', 'CHECKBOX', 13,13);;
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

-- Part Filters *****************************************************************************************************************
-- ----------------------------------------------------------------1 PRICE---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Part', 'Цена', 'RANGE', 1,1);;
-- ----------------------------------------------------------------4 BRAND---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Part', 'Бренд', 'CHECKBOX', 4,4);;
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

-- Other Filters *****************************************************************************************************************
-- ----------------------------------------------------------------1 PRICE---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Other','Цена', 'RANGE', 1,1);;
-- ----------------------------------------------------------------4 BRAND---------------------------------------------------------
INSERT INTO filter_item (menu_item, name, type, key_path_id, rank) VALUES ('Other','Бренд', 'CHECKBOX', 4,4);;
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
