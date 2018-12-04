/*
Выбрать продукты которые подходят под определенную цену и находятся в магазинах 1 и 2
Цена 400
Магазины 1 и 2
3 Mp 153
7 Makarov pistol
8 Sks
 */

SELECT *
FROM product AS p WHERE type_id = 1
                    AND p.product_Id IN
                        (SELECT p.product_Id FROM shop AS s
                                                   JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
                                                   JOIN product AS p ON p.product_Id = sp.product_id
                         WHERE s.shop_Id = 2 OR s.shop_Id = 3)
                    AND p.product_Id IN
                        (SELECT p.product_Id FROM product AS p
                         WHERE price > 350);

/*
Наиболее вероятная ситуация, это отказ от типов запросов, и внесение в запрос
равновесных участков по каждому параметру. Исключением будет являеться первый
параметр который должен добавляться по особенному правилу.
 */

/*

 */
