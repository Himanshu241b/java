-- Write a MySQL query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 90 from job history.

-- Sample table: job_history

-- employee_id  start_date  end_date    job_id      department_id
-- -----------  ----------  ----------  ----------  -------------
-- employee_id  start_date  end_date`   job_id      department_id
-- 102          1993-01-13  1998-07-24  IT_PROG     60
-- 101          1989-09-21  1993-10-27  AC_ACCOUNT  110
-- 101          1993-10-28  1997-03-15  AC_MGR      110
-- 201          1996-02-17  1999-12-19  MK_REP      20
-- 114          1998-03-24  1999-12-31  ST_CLERK    50
-- 122          1999-01-01  1999-12-31  ST_CLERK    50
-- 200          1987-09-17  1993-06-17  AD_ASST     90
-- 176          1998-03-24  1998-12-31  SA_REP      80
-- 176          1999-01-01  1999-12-31  SA_MAN      80
-- 200          1994-07-01  1998-12-31  AC_ACCOUNT  90



-- Sample table: jobs

-- +------------+---------------------------------+------------+------------+
-- | JOB_ID     | JOB_TITLE                       | MIN_SALARY | MAX_SALARY |
-- +------------+---------------------------------+------------+------------+
-- | AD_PRES    | President                       |      20000 |      40000 |
-- | AD_VP      | Administration Vice President   |      15000 |      30000 |
-- | AD_ASST    | Administration Assistant        |       3000 |       6000 |
-- | FI_MGR     | Finance Manager                 |       8200 |      16000 |
-- | FI_ACCOUNT | Accountant                      |       4200 |       9000 |
-- | AC_MGR     | Accounting Manager              |       8200 |      16000 |
-- | AC_ACCOUNT | Public Accountant               |       4200 |       9000 |
-- | SA_MAN     | Sales Manager                   |      10000 |      20000 |
-- | SA_REP     | Sales Representative            |       6000 |      12000 |
-- | PU_MAN     | Purchasing Manager              |       8000 |      15000 |
-- | PU_CLERK   | Purchasing Clerk                |       2500 |       5500 |
-- | ST_MAN     | Stock Manager                   |       5500 |       8500 |
-- | ST_CLERK   | Stock Clerk                     |       2000 |       5000 |
-- | SH_CLERK   | Shipping Clerk                  |       2500 |       5500 |
-- | IT_PROG    | Programmer                      |       4000 |      10000 |
-- | MK_MAN     | Marketing Manager               |       9000 |      15000 |
-- | MK_REP     | Marketing Representative        |       4000 |       9000 |
-- | HR_REP     | Human Resources Representative  |       4000 |       9000 |
-- | PR_REP     | Public Relations Representative |       4500 |      10500 |
-- +------------+---------------------------------+------------+------------+



-- Sample Output:

-- employee_id		job_title				Days
-- 200			Administration Assistant		59700
-- 200			Public Accountant			40530

-- Create the job_history table
CREATE TABLE job_history (
    employee_id INT,
    start_date DATE,
    end_date DATE,
    job_id VARCHAR(10),
    department_id INT
);

-- Insert data into the job_history table
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES
(102, '1993-01-13', '1998-07-24', 'IT_PROG', 60),
(101, '1989-09-21', '1993-10-27', 'AC_ACCOUNT', 110),
(101, '1993-10-28', '1997-03-15', 'AC_MGR', 110),
(201, '1996-02-17', '1999-12-19', 'MK_REP', 20),
(114, '1998-03-24', '1999-12-31', 'ST_CLERK', 50),
(122, '1999-01-01', '1999-12-31', 'ST_CLERK', 50),
(200, '1987-09-17', '1993-06-17', 'AD_ASST', 90),
(176, '1998-03-24', '1998-12-31', 'SA_REP', 80),
(176, '1999-01-01', '1999-12-31', 'SA_MAN', 80),
(200, '1994-07-01', '1998-12-31', 'AC_ACCOUNT', 90);

-- Create the jobs table
CREATE TABLE jobs (
    job_id VARCHAR(10),
    job_title VARCHAR(50),
    min_salary INT,
    max_salary INT
);

-- Insert data into the jobs table
INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES
('AD_PRES', 'President', 20000, 40000),
('AD_VP', 'Administration Vice President', 15000, 30000),
('AD_ASST', 'Administration Assistant', 3000, 6000),
('FI_MGR', 'Finance Manager', 8200, 16000),
('FI_ACCOUNT', 'Accountant', 4200, 9000),
('AC_MGR', 'Accounting Manager', 8200, 16000),
('AC_ACCOUNT', 'Public Accountant', 4200, 9000),
('SA_MAN', 'Sales Manager', 10000, 20000),
('SA_REP', 'Sales Representative', 6000, 12000),
('PU_MAN', 'Purchasing Manager', 8000, 15000),
('PU_CLERK', 'Purchasing Clerk', 2500, 5500),
('ST_MAN', 'Stock Manager', 5500, 8500),
('ST_CLERK', 'Stock Clerk', 2000, 5000),
('SH_CLERK', 'Shipping Clerk', 2500, 5500),
('IT_PROG', 'Programmer', 4000, 10000),
('MK_MAN', 'Marketing Manager', 9000, 15000),
('MK_REP', 'Marketing Representative', 4000, 9000),
('HR_REP', 'Human Resources Representative', 4000, 9000),
('PR_REP', 'Public Relations Representative', 4500, 10500);

-- query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 90 from job history.
SELECT jh.employee_id,
j.job_title,
DATEDIFF(jh.end_date, jh.start_date) AS Days
FROM job_history jh 
JOIN jobs j ON jh.job_id = j.job_id
WHERE jh.department_id = 90;