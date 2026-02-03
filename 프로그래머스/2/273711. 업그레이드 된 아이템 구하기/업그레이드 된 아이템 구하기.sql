-- 코드를 작성해주세요
SELECT i.item_id, i.item_name, i.rarity
FROM item_tree t JOIN item_info i
ON t.item_id = i.item_id
WHERE parent_item_id IN (SELECT item_id
                         FROM item_info
                         WHERE rarity = 'RARE')
ORDER BY item_id DESC;