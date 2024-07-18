-- 코드를 입력하세요
SELECT category, SUM(SALES) as total_sales
FROM book a JOIN book_sales b ON a.book_id = b.book_id
WHERE TO_CHAR(sales_date, 'YYYY-MM') = '2022-01'
GROUP BY category
ORDER BY category ASC