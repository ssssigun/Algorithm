-- 코드를 입력하세요
SELECT b.author_id, c.author_name, b.category, SUM(a.sales) as total_sales
FROM (SELECT b.book_id, SUM(sales * b.price) as sales FROM book b JOIN book_sales s ON b.book_id = s.book_id
    WHERE TO_CHAR(s.sales_date, 'YYYY-MM') = '2022-01'
    GROUP BY b.book_id) a JOIN book b ON a.book_id = b.book_id JOIN author c ON b.author_id = c.author_id
GROUP BY b.category, c.author_name, b.author_id
ORDER BY b.author_id ASC, category DESC