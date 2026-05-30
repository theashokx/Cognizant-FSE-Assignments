--1.
SELECT u.full_name, e.title, e.city, e.start_date
FROM Users u
JOIN Registrations r
    ON u.user_id = r.user_id
JOIN Events e
    ON e.event_id = r.event_id
WHERE e.status = 'upcoming'
  AND e.city = u.city
ORDER BY e.start_date;
-- +---------------+-------------------------------+-------------+---------------------+
-- | full_name     | title                         | city        | start_date          |
-- +---------------+-------------------------------+-------------+---------------------+
-- | Alice Johnson | Tech Innovators Meetup        | New York    | 2025-06-10 10:00:00 |
-- | Ethan Hunt    | Frontend Development Bootcamp | Los Angeles | 2025-07-01 10:00:00 |
-- +---------------+-------------------------------+-------------+---------------------+

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--2.
SELECT
    e.title,
    AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f
    ON f.event_id = e.event_id
GROUP BY e.title
HAVING COUNT(*) >= 10
ORDER BY avg_rating DESC
LIMIT 1;

---Empty set (0.672 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--3.
SELECT
    u.user_id,
    u.full_name,
    u.email
FROM Users u
LEFT JOIN Registrations r
    ON u.user_id = r.user_id
    AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.user_id IS NULL;

-- +---------+---------------+---------------------+
-- | user_id | full_name     | email               |
-- +---------+---------------+---------------------+
-- |       1 | Alice Johnson | alice@example.com   |
-- |       2 | Bob Smith     | bob@example.com     |
-- |       3 | Charlie Lee   | charlie@example.com |
-- |       4 | Diana King    | diana@example.com   |
-- |       5 | Ethan Hunt    | ethan@example.com   |
-- +---------+---------------+---------------------+
-- 5 rows in set (0.116 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--4

SELECT
    e.title,
    COUNT(*) AS session_count
FROM Events e
JOIN Sessions s
    ON s.event_id = e.event_id
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.title;

-- +-------------------------------+---------------+
-- | title                         | session_count |
-- +-------------------------------+---------------+
-- | Tech Innovators Meetup        |             2 |
-- | Frontend Development Bootcamp |             1 |
-- +-------------------------------+---------------+
-- 2 rows in set (0.553 sec)
----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--5

SELECT u.city, COUNT(DISTINCT u.user_id)
FROM Users u
JOIN Registrations r
    ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY COUNT(DISTINCT u.user_id) DESC
LIMIT 5;

-- +-------------+---------------------------+
-- | city        | count(distinct u.user_id) |
-- +-------------+---------------------------+
-- | Los Angeles |                         2 |
-- | New York    |                         2 |
-- | Chicago     |                         1 |
-- +-------------+---------------------------+
-- 3 rows in set (0.121 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--6

SELECT
    e.title,
    SUM(CASE WHEN r.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN r.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count
FROM Events e
LEFT JOIN Resources r
    ON e.event_id = r.event_id
GROUP BY e.title;

-- +-------------------------------+-----------+-------------+------------+
-- | title                         | pdf_count | image_count | link_count |
-- +-------------------------------+-----------+-------------+------------+
-- | Tech Innovators Meetup        |         1 |           0 |          0 |
-- | AI & ML Conference            |         0 |           1 |          0 |
-- | Frontend Development Bootcamp |         0 |           0 |          1 |
-- +-------------------------------+-----------+-------------+------------+
-- 3 rows in set (0.279 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--7
SELECT u.full_name, f.comments, e.title
FROM Users u
JOIN Feedback f
    ON f.user_id = u.user_id
JOIN Events e
    ON e.event_id = f.event_id
WHERE f.rating < 3;


--Empty set (0.132 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------    

--8
SELECT
    e.title,
    COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s
    ON s.event_id = e.event_id
WHERE e.status = 'upcoming'
GROUP BY e.title;

-- +-------------------------------+---------------+
-- | title                         | session_count |
-- +-------------------------------+---------------+
-- | Tech Innovators Meetup        |             2 |
-- | Frontend Development Bootcamp |             1 |
-- +-------------------------------+---------------+
-- 2 rows in set (0.046 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------    
--9
SELECT
    u.full_name,
    e.status,
    COUNT(*) AS total_events
FROM Users u
JOIN Events e
    ON e.organizer_id = u.user_id
GROUP BY u.full_name, e.status;

-- +---------------+-----------+--------------+
-- | full_name     | status    | total_events |
-- +---------------+-----------+--------------+
-- | Alice Johnson | upcoming  |            1 |
-- | Charlie Lee   | completed |            1 |
-- | Bob Smith     | upcoming  |            1 |
-- +---------------+-----------+--------------+
-- 3 rows in set (0.081 sec)

----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------

--10
SELECT DISTINCT
    e.title
FROM Events e
JOIN Registrations r
    ON r.event_id = e.event_id
LEFT JOIN Feedback f
    ON f.event_id = e.event_id
WHERE f.feedback_id IS NULL;

-- +-------------------------------+
-- | title                         |
-- +-------------------------------+
-- | Frontend Development Bootcamp |
-- +-------------------------------+
-- 1 row in set (0.113 sec)


-----------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------



