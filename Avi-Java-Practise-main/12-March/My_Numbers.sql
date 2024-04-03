use march_12;

-- Create the my_numbers table
CREATE TABLE my_numbers (
    num INT
);

-- Insert values into the my_numbers table
INSERT INTO my_numbers (num) VALUES
(8),
(8),
(3),
(3),
(1),
(4),
(5),
(6);



SELECT MAX(num) AS num
FROM (
    SELECT num
    FROM my_numbers
    GROUP BY num
    HAVING COUNT(num) = 1
) AS unique_numbers;

    
    
    
    
    
    
    
    
    
    
    
