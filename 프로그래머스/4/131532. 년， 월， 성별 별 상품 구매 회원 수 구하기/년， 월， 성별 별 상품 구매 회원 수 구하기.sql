-- 코드를 입력하세요
SELECT SUBSTR(sales_date,1, 4) as year,
TO_NUMBER(SUBSTR(sales_date,6,6)) as month,
gender, COUNT(*) as users
FROM user_info u JOIN (SELECT DISTINCT user_id, TO_CHAR(sales_date, 'YYYY-MM') as sales_date FROM online_sale) o
    ON u.user_id = o.user_id
WHERE gender is NOT NULL
GROUP BY sales_date, gender
ORDER BY year ASC, month ASC, gender ASC