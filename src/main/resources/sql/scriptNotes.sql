/*
Выбрать продукты которые подходят под определенную цену и находятся в магазинах 1 и 2
Цена 400
Магазины 1 и 2
3 Mp 153
7 Makarov pistol
8 Sks
 */

 USE gunmarket;

SELECT p.product_Id, p.name, p.price FROM product AS p /*Выбор кого и откуда*/
WHERE p.price = 400 AND type_id =1 /*Добавление простых параметров*/
AND p.product_Id IN (SELECT p.product_Id FROM shop AS s
JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
JOIN product AS p ON p.product_Id = sp.product_id
WHERE s.shop_Id = 2 OR s.shop_Id = 3);

/*

 */
