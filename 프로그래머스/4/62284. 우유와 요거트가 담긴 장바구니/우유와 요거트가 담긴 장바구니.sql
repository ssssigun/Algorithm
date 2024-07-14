-- 코드를 입력하세요
SELECT a.cart_id
FROM (SELECT * FROM cart_products WHERE name = 'Milk') a JOIN (SELECT * FROM cart_products WHERE name = 'Yogurt') b
    ON a.cart_id = b.cart_id
ORDER BY a.cart_id ASC