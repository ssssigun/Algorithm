-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
FROM patient p JOIN appointment a ON p.pt_no = a.pt_no
    JOIN doctor d ON a.mddr_id = d.dr_id
WHERE TO_CHAR(a.apnt_ymd, 'YYYY-MM-DD') = '2022-04-13' 
    AND a.apnt_cncl_yn = 'N'
    AND a.mcdp_cd = 'CS'
ORDER BY a.apnt_ymd ASC