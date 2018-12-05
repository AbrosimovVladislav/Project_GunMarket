/*
Выбрать продукты которые подходят под определенную цену и находятся в магазинах 1 и 2
Цена 400
Магазины 1 и 2
3 Mp 153
7 Makarov pistol
8 Sks
 */

SELECT * FROM product AS p WHERE type_id = 1
AND p.product_Id IN
  (SELECT p.product_Id FROM shop AS s
JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
JOIN product AS p ON p.product_Id = sp.product_id
WHERE s.shop_Id = 2 OR s.shop_Id = 3)
AND p.product_Id IN
  (SELECT p.product_Id FROM product AS p
WHERE price > 350);




select product2_.product_Id as product_1_0_,
       product2_.name as name2_0_,
       product2_.price as price3_0_,
       product2_.type_Id as type_Id4_0_
from shop shop0_
       inner join shop_product products1_
         on shop0_.shop_Id=products1_.shop_Id
       inner join product product2_
         on products1_.product_Id=product2_.product_Id
where shop0_.name='Levsha' and shop0_.name='OrDvor';



select product2_.product_Id as prodId
from shop as s
            inner join shop_product products1_
         on s.shop_Id=products1_.shop_Id
            inner join product product2_
         on products1_.product_Id=product2_.product_Id
where s.name='Levsha';

SELECT p.product_Id FROM shop AS s
JOIN shop_product AS sp ON s.shop_Id = sp.shop_Id
JOIN product AS p ON p.product_Id = sp.product_id
WHERE s.name = 'Levha';

/*
1	1
1	3
1	4
1	5
1	7
1	9


 */

/*
Наиболее вероятная ситуация, это отказ от типов запросов, и внесение в запрос
равновесных участков по каждому параметру. Исключением будет являеться первый
параметр который должен добавляться по особенному правилу.
 */

/*

 */
