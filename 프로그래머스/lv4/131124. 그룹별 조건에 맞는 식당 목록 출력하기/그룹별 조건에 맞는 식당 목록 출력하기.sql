-- 코드를 입력하세요
SELECT MEMBER_PROFILE.MEMBER_NAME, 
REST_REVIEW.REVIEW_TEXT AS REVIEW_TEXT, 
DATE_FORMAT(REST_REVIEW.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE 
JOIN REST_REVIEW ON MEMBER_PROFILE.MEMBER_ID =  REST_REVIEW.MEMBER_ID 
WHERE REST_REVIEW.MEMBER_ID = ( -- 가장 많은 사람
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(MEMBER_ID) DESC
    LIMIT 1
    )
ORDER BY REVIEW_DATE, REVIEW_TEXT;