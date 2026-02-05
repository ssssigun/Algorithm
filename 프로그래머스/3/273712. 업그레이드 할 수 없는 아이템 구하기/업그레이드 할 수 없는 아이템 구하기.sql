-- 코드를 작성해주세요
SELECT item_id, item_name, rarity
FROM item_info
WHERE item_id NOT IN (SELECT IFNULL(parent_item_id,-1) FROM item_tree)
ORDER BY item_id DESC;