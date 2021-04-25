

CREATE TABLE MOVIES (
    id int PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    runtime INT,
    genre VARCHAR(255),
    imdb_score DECIMAL(3, 1),
    rating VARCHAR(255)
);

INSERT INTO MOVIES
    VALUES
        (null, "Howard the Duck", 110, "Sci-Fi", 4.6, "PG"),
        (null, "Lavalantula", 83, "Horror", 4.7, "TV-14"),
        (null, "StarshipTroopers", 129, "Sci-Fi", 7.2, "PG-13"),
        (null, "Waltz With Bashir", 90, "Documentary", 8.0, "R"),
        (null, "Spaceballs", 96, "Comedy", 7.1, "PG"),
        (null, "Monsers Inc.", 92, "Animation", 8.1, "G"),
        (null, "Honey I Shrunk The Kids", 90, "Comedy", 7.5, "PG"),
        (null, "The Sound of Music", 180, "Drama", 8.9, "PG-13"),
        (null, "Gran Torino", 95, "Drama", 9.1, "R")
;

SELECT * FROM MOVIES WHERE genre = "Sci-Fi";

SELECT * FROM MOVIES WHERE imdb_score >= 6.5;

SELECT * FROM MOVIES WHERE rating IN ("G", "PG") AND runtime < 100;

SELECT
    AVG(RUNTIME) AS AVG_RUNTIME,
    genre
FROM MOVIES
WHERE imdb_score < 7.5
GROUP BY genre;


UPDATE MOVIES
SET rating = "R"
WHERE title = "StarshipTroopers";

SELECT
    id,
    rating
FROM MOVIES
WHERE genre IN ("Horror", "Documentary");

SELECT
    rating,
    AVG(imdb_score) AS Average_Score,
    MAX(imdb_score) AS Max_Score,
    MIN(imdb_score) AS Min_Score
FROM MOVIES
GROUP BY rating
HAVING COUNT(*) > 1;

DELETE FROM MOVIES WHERE rating = "R";




