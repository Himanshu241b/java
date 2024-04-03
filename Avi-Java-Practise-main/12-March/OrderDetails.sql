use march_12;
-- Create the OrdersDetails table
CREATE TABLE OrdersDetails (
    order_id INT,
    product_id INT,
    quantity INT,
    PRIMARY KEY (order_id, product_id)
);

-- Insert values into the OrdersDetails table
INSERT INTO OrdersDetails (order_id, product_id, quantity) VALUES
(1, 1, 12),
(1, 2, 10),
(1, 3, 15),
(2, 1, 8),
(2, 4, 4),
(2, 5, 6),
(3, 3, 5),
(3, 4, 18),
(4, 5, 2),
(4, 6, 8),
(5, 7, 9),
(5, 8, 9),
(3, 9, 20),
(2, 9, 4);


-- with helper as (SELECT order_id, max(quantity) as max_quantity, avg(quantity) as avg_quantity from OrdersDetails group by order_id)
-- select order_id from helper
-- where max(max_quantity) > (select max(avg_quantity) from OrdersDetails where order_id = helper.order_id);
-- ;

WITH OrderSummary AS (
    SELECT
        order_id,
        MAX(quantity) AS max_quantity,
        AVG(quantity * 1.0) AS avg_quantity
    FROM
        OrdersDetails
    GROUP BY
        order_id
)

SELECT
    order_id
FROM
    OrderSummary o1
WHERE
    (SELECT MAX(max_quantity) FROM OrderSummary o2 WHERE o1.order_id = o2.order_id) > 
    (SELECT AVG(quantity * 1.0) FROM OrdersDetails WHERE order_id = o1.order_id);




