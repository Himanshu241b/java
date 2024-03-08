-- A U.S graduate school has students from Asia, Europe and America. The students' location information are stored in table student as below.


-- | name   | continent |
-- |--------|-----------|
-- | Jack   | America   |
-- | Pascal | Europe    |
-- | Xi     | Asia      |
-- | Jane   | America   |


-- Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be America, Asia and Europe respectively. It is guaranteed that the student number from America is no less than either Asia or Europe.


-- For the sample input, the output is:


-- | America | Asia | Europe |
-- |---------|------|--------|
-- | Jack    | Xi   | Pascal |
-- | Jane    |      |        |


-- Create student table
CREATE TABLE student (
    name VARCHAR(255),
    continent VARCHAR(255)
);

-- Insert sample data into student table
INSERT INTO student (name, continent) VALUES
('Jack', 'America'),
('Pascal', 'Europe'),
('Xi', 'Asia'),
('Jane', 'America');
('max','Europe')

-- Group names in continents columns 
SELECT 
    MAX(CASE WHEN s.continent = 'America' THEN s.name ELSE '' END) AS America,
    MAX(CASE WHEN s.continent = 'Asia' THEN s.name ELSE '' END) AS Asia,
    MAX(CASE WHEN s.continent = 'Europe' THEN s.name ELSE '' END) AS Europe
FROM 
    student s
GROUP BY 
    s.name
ORDER BY 
    America, Asia, Europe;
