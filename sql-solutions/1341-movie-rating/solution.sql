-- mysql
-- 查找评论电影数量最多的用户名。
-- 如果出现平局，返回字典序较小的用户名
(
    select users.name as results
    from movierating inner join users
    on movierating.user_id = users.user_id
    group by users.name
    order by count(movierating.user_id) desc, users.name
    limit 1
)
union all
(
    select movies.title as results
    from movierating inner join movies
    on movierating.movie_id = movies.movie_id
    where movierating.created_at >= '2020-02-01'
    and movierating.created_at < '2020-03-01'
    group by movies.title
    order by avg(movierating.rating) desc, movies.title
    limit 1
);

-- 查找在 February 2020 平均评分最高 的电影名称。
-- 如果出现平局，返回字典序较小的电影名称