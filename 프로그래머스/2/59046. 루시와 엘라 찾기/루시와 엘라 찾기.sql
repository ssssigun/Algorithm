-- 코드를 입력하세요
SELECT animal_id, name, sex_upon_intake
FROM animal_ins
WHERE name = 'Lucy' OR name = 'Ella' OR name = 'Pickle' OR name = 'Rogan' OR name = 'Sabrina' OR name = 'Mitty'
ORDER BY animal_id ASC