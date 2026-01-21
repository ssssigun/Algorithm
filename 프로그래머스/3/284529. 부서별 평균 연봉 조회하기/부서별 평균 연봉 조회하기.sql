-- 부서별 평균 연봉
-- join하고 부서끼리 group by, 연봉 내림차순
SELECT d.dept_id, d.dept_name_en, ROUND(AVG(e.sal), 0) as "AVG_SAL"
FROM hr_department d JOIN hr_employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_id
ORDER BY avg_sal DESC;