-- 코드를 입력하세요
SELECT *
FROM(SELECT TO_CHAR(sales_date, 'YYYY-MM-DD') as sales_date, product_id, user_id, sales_amount
    FROM online_sale
    WHERE TO_CHAR(sales_date,'YYYY-MM') = '2022-03'
    UNION ALL
    SELECT TO_CHAR(sales_date,'YYYY-MM-DD') as sales_date, product_id, NULL, sales_amount
    FROM offline_sale
    WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-03')
ORDER BY sales_date ASC, product_id ASC, user_id ASC;