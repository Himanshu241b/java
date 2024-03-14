-- Write a MySQL query to find the name (first_name, last_name), job, department ID and name of the employees who works in London.

-- Sample table: departments

-- +---------------+----------------------+------------+-------------+
-- | DEPARTMENT_ID | DEPARTMENT_NAME      | MANAGER_ID | LOCATION_ID |
-- +---------------+----------------------+------------+-------------+
-- |            10 | Administration       |        200 |        1700 |
-- |            20 | Marketing            |        201 |        1800 |
-- |            30 | Purchasing           |        114 |        1700 |
-- |            40 | Human Resources      |        203 |        2400 |
-- |            50 | Shipping             |        121 |        1500 |
-- |            60 | IT                   |        103 |        1400 |
-- |            70 | Public Relations     |        204 |        2700 |
-- |            80 | Sales                |        145 |        2500 |
-- |            90 | Executive            |        100 |        1700 |
-- |           100 | Finance              |        108 |        1700 |
-- |           110 | Accounting           |        205 |        1700 |
-- |           120 | Treasury             |          0 |        1700 |
-- |           130 | Corporate Tax        |          0 |        1700 |
-- |           140 | Control And Credit   |          0 |        1700 |
-- |           150 | Shareholder Services |          0 |        1700 |
-- |           160 | Benefits             |          0 |        1700 |
-- |           170 | Manufacturing        |          0 |        1700 |
-- |           180 | Construction         |          0 |        1700 |
-- |           190 | Contracting          |          0 |        1700 |
-- |           200 | Operations           |          0 |        1700 |
-- |           210 | IT Support           |          0 |        1700 |
-- |           220 | NOC                  |          0 |        1700 |
-- |           230 | IT Helpdesk          |          0 |        1700 |
-- |           240 | Government Sales     |          0 |        1700 |
-- |           250 | Retail Sales         |          0 |        1700 |
-- |           260 | Recruiting           |          0 |        1700 |
-- |           270 | Payroll              |          0 |        1700 |
-- +---------------+----------------------+------------+-------------+


-- Sample table: locations

-- location_id  street_address        postal_code  city        state_province  country_id
-- -----------  --------------------  -----------  ----------  --------------  ----------
-- 1000         1297 Via Cola di Rie  989          Roma                        IT
-- 1100         93091 Calle della Te  10934        Venice                      IT
-- 1200         2017 Shinjuku-ku      1689         Tokyo       Tokyo Prefectu  JP
-- 1300         9450 Kamiya-cho       6823         Hiroshima                   JP
-- 1400         2014 Jabberwocky Rd   26192        Southlake   Texas           US
-- 1500         2011 Interiors Blvd   99236        South San   California      US
-- 1600         2007 Zagora St        50090        South Brun  New Jersey      US
-- 1700         2004 Charade Rd       98199        Seattle     Washington      US
-- 1800         147 Spadina Ave       M5V 2L7      Toronto     Ontario         CA
-- 1900         6092 Boxwood St       YSW 9T2      Whitehorse  Yukon           CA
-- 2000         40-5-12 Laogianggen   190518       Beijing                     CN
-- 2100         1298 Vileparle (E)    490231       Bombay      Maharashtra     IN
-- 2200         12-98 Victoria Stree  2901         Sydney      New South Wale  AU
-- 2300         198 Clementi North    540198       Singapore                   SG
-- 2400         8204 Arthur St                     London                      UK
-- 2500         Magdalen Centre, The  OX9 9ZB      Oxford      Oxford          UK
-- 2600         9702 Chester Road     9629850293   Stretford   Manchester      UK
-- 2700         Schwanthalerstr. 703  80925        Munich      Bavaria         DE
-- 2800         Rua Frei Caneca 1360  01307-002    Sao Paulo   Sao Paulo       BR
-- 2900         20 Rue des Corps-Sai  1730         Geneva      Geneve          CH
-- 3000         Murtenstrasse 921     3095         Bern        BE              CH
-- 3100         Pieter Breughelstraa  3029SK       Utrecht     Utrecht         NL
-- 3200         Mariano Escobedo 999  11932        Mexico Cit  Distrito Feder  MX

-- employee Table same as above question......


-- Sample Output:

-- first_name	last_name	job_id	department_id	department_name
-- Susan		Mavris		HR_REP	40		Human Resources

use TestDb;

-- create departments table
CREATE TABLE departments (
    DEPARTMENT_ID INT,
    DEPARTMENT_NAME VARCHAR(100),
    MANAGER_ID INT,
    LOCATION_ID INT
);

-- create locations table
CREATE TABLE locations (
    LOCATION_ID INT,
    STREET_ADDRESS VARCHAR(255),
    POSTAL_CODE VARCHAR(20),
    CITY VARCHAR(100),
    STATE_PROVINCE VARCHAR(100),
    COUNTRY_ID CHAR(2)
);

-- create employees table
CREATE TABLE employees (
    EMPLOYEE_ID INT,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    JOB_ID VARCHAR(10),
    DEPARTMENT_ID INT
);

-- Insert data into the departments table
INSERT INTO departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES
    (10, 'Administration', 200, 1700),
    (20, 'Marketing', 201, 1800),
    (30, 'Purchasing', 114, 1700),
    (40, 'Human Resources', 203, 2400),
    (50, 'Shipping', 121, 1500),
    (60, 'IT', 103, 1400),
    (70, 'Public Relations', 204, 2700),
    (80, 'Sales', 145, 2500),
    (90, 'Executive', 100, 1700),
    (100, 'Finance', 108, 1700),
    (110, 'Accounting', 205, 1700),
    (120, 'Treasury', 0, 1700),
    (130, 'Corporate Tax', 0, 1700),
    (140, 'Control And Credit', 0, 1700),
    (150, 'Shareholder Services', 0, 1700),
    (160, 'Benefits', 0, 1700),
    (170, 'Manufacturing', 0, 1700),
    (180, 'Construction', 0, 1700),
    (190, 'Contracting', 0, 1700),
    (200, 'Operations', 0, 1700),
    (210, 'IT Support', 0, 1700),
    (220, 'NOC', 0, 1700),
    (230, 'IT Helpdesk', 0, 1700),
    (240, 'Government Sales', 0, 1700),
    (250, 'Retail Sales', 0, 1700),
    (260, 'Recruiting', 0, 1700),
    (270, 'Payroll', 0, 1700);

-- Insert data into the locations table
INSERT INTO locations (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)
VALUES
    (1000, '1297 Via Cola di Rie', '989', 'Roma', NULL, 'IT'),
    (1100, '93091 Calle della Te', '10934', 'Venice', NULL, 'IT'),
    (1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),
    (1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
    (1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
    (1500, '2011 Interiors Blvd', '99236', 'South San', 'California', 'US'),
    (1600, '2007 Zagora St', '50090', 'South Brun', 'New Jersey', 'US'),
    (1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
    (1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
    (1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA'),
    (2000, '40-5-12 Laogianggen', '190518', 'Beijing', NULL, 'CN'),
    (2100, '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN'),
    (2200, '12-98 Victoria Stree', '2901', 'Sydney', 'New South Wales', 'AU'),
    (2300, '198 Clementi North', '540198', 'Singapore', NULL, 'SG'),
    (2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
    (2500, 'Magdalen Centre, The', 'OX9 9ZB', 'Oxford', NULL, 'UK'),
    (2600, '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK'),
    (2700, 'Schwanthalerstr. 703', '80925', 'Munich', 'Bavaria', 'DE'),
    (2800, 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR'),
    (2900, '20 Rue des Corps-Sai', '1730', 'Geneva', 'Geneve', 'CH'),
    (3000, 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH'),
    (3100, 'Pieter Breughelstraa', '3029SK', 'Utrecht', 'Utrecht', 'NL'),
    (3200, 'Mariano Escobedo 999', '11932', 'Mexico City', 'Distrito Federal', 'MX');

-- Insert data into the employees table
INSERT INTO employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID)
VALUES
    (100, 'Steven', 'King', 'AD_PRES', 90),
    (101, 'Neena', 'Kochhar', 'AD_VP', 90),
    (102, 'Lex', 'De Haan', 'AD_VP', 90),
    (103, 'Alexander', 'Hunold', 'IT_PROG', 60),
    (104, 'Bruce', 'Ernst', 'IT_PROG', 60),
    (105, 'David', 'Austin', 'IT_PROG', 60),
    (106, 'Valli', 'Pataballa', 'IT_PROG', 60),
    (107, 'Diana', 'Lorentz', 'IT_PROG', 60),
    (108, 'Nancy', 'Greenberg', 'FI_MGR', 100),
    (109, 'Daniel', 'Faviet', 'FI_ACCOUNT', 100),
    (110, 'John', 'Chen', 'FI_ACCOUNT', 100),
    (111, 'Ismael', 'Sciarra', 'FI_ACCOUNT', 100),
    (112, 'Jose Manuel', 'Urman', 'FI_ACCOUNT', 100),
    (113, 'Luis', 'Popp', 'FI_ACCOUNT', 100),
    (114, 'Den', 'Raphaely', 'PU_MAN', 30),
    (115, 'Alexander', 'Khoo', 'PU_CLERK', 30),
    (116, 'Shelli', 'Baida', 'PU_CLERK', 30),
    (117, 'Sigal', 'Tobias', 'PU_CLERK', 30),
    (118, 'Guy', 'Himuro', 'PU_CLERK', 30),
    (119, 'Karen', 'Colmenares', 'PU_CLERK', 30),
    (120, 'Matthew', 'Weiss', 'ST_MAN', 50),
    (121, 'Adam', 'Fripp', 'ST_MAN', 50),
    (122, 'Payam', 'Kaufling', 'ST_MAN', 50),
    (123, 'Shanta', 'Vollman', 'ST_MAN', 50),
    (124, 'Kevin', 'Mourgos', 'ST_MAN', 50),
    (125, 'Julia', 'Nayer', 'ST_CLERK', 50),
    (126, 'Irene', 'Mikkilineni', 'ST_CLERK', 50),
    (127, 'James', 'Landry', 'ST_CLERK', 50),
    (128, 'Steven', 'Markle', 'ST_CLERK', 50),
    (129, 'Laura', 'Bissot', 'ST_CLERK', 50),
    (130, 'Mozhe', 'Atkinson', 'ST_CLERK', 50),
    (131, 'James', 'Marlow', 'ST_CLERK', 50),
    (132, 'TJ', 'Olson', 'ST_CLERK', 50),
    (133, 'Jason', 'Mallin', 'ST_CLERK', 50),
    (134, 'Michael', 'Rogers', 'ST_CLERK', 50),
    (135, 'Ki', 'Gee', 'ST_CLERK', 50),
    (136, 'Hazel', 'Philtanker', 'ST_CLERK', 50),
    (137, 'Renske', 'Ladwig', 'ST_CLERK', 50),
    (138, 'Stephen', 'Stiles', 'ST_CLERK', 50),
    (139, 'John', 'Seo', 'ST_CLERK', 50),
    (140, 'Joshua', 'Patel', 'ST_CLERK', 50),
    (141, 'Trenna', 'Rajs', 'ST_CLERK', 50),
    (142, 'Curtis', 'Davies', 'ST_CLERK', 50),
    (143, 'Randall', 'Matos', 'ST_CLERK', 50),
    (144, 'Peter', 'Vargas', 'ST_CLERK', 50),
    (145, 'John', 'Russell', 'SA_MAN', 80),
    (146, 'Karen', 'Partners', 'SA_MAN', 80),
    (147, 'Alberto', 'Errazuriz', 'SA_MAN', 80),
    (148, 'Gerald', 'Cambrault', 'SA_MAN', 80),
    (149, 'Eleni', 'Zlotkey', 'SA_MAN', 80),
    (150, 'Peter', 'Tucker', 'SA_REP', 80),
    (151, 'David', 'Bernstein', 'SA_REP', 80),
    (152, 'Peter', 'Hall', 'SA_REP', 80),
    (153, 'Christopher', 'Olsen', 'SA_REP', 80),
    (154, 'Nanette', 'Cambrault', 'SA_REP', 80),
    (155, 'Oliver', 'Tuvault', 'SA_REP', 80),
    (156, 'Janette', 'King', 'SA_REP', 80),
    (157, 'Patrick', 'Sully', 'SA_REP', 80),
    (158, 'Allan', 'McEwen', 'SA_REP', 80),
    (159, 'Lindsey', 'Smith', 'SA_REP', 80),
    (160, 'Louise', 'Doran', 'SA_REP', 80),
    (161, 'Sarath', 'Sewall', 'SA_REP', 80),
    (162, 'Clara', 'Vishney', 'SA_REP', 80),
    (163, 'Danielle', 'Greene', 'SA_REP', 80),
    (164, 'Mattea', 'Marvins', 'SA_REP', 80),
    (165, 'David', 'Lee', 'SA_REP', 80),
    (166, 'Sundar', 'Ande', 'SA_REP', 80),
    (167, 'Amit', 'Banda', 'SA_REP', 80),
    (168, 'Lisa', 'Ozer', 'SA_REP', 80),
    (169, 'Harrison', 'Bloom', 'SA_REP', 80),
    (170, 'Tayler', 'Fox', 'SA_REP', 80),
    (171, 'William', 'Smith', 'SA_REP', 80),
    (172, 'Elizabeth', 'Bates', 'SA_REP', 80),
    (173, 'Sundita', 'Kumar', 'SA_REP', 80),
    (174, 'Ellen', 'Abel', 'SA_REP', 80),
    (175, 'Alyssa', 'Hutton', 'SA_REP', 80),
    (176, 'Jonathon', 'Taylor', 'SA_REP', 80),
    (177, 'Jack', 'Livingston', 'SA_REP', 80),
    (178, 'Kimberely', 'Grant', 'SA_REP', 80),
    (179, 'Charles', 'Johnson', 'SA_REP', 80),
    (180, 'Winston', 'Taylor', 'SH_CLERK', 150),
    (181, 'Jean', 'Fleaur', 'SH_CLERK', 150),
    (182, 'Martha', 'Sullivan', 'SH_CLERK', 150),
    (183, 'Girard', 'Geoni', 'SH_CLERK', 150),
    (184, 'Nandita', 'Sarchand', 'SH_CLERK', 150),
    (185, 'Alexis', 'Bull', 'SH_CLERK', 150),
    (186, 'Julia', 'Dellinger', 'SH_CLERK', 150),
    (187, 'Anthony', 'Cabrio', 'SH_CLERK', 150),
    (188, 'Kelly', 'Chung', 'SH_CLERK', 150),
    (189, 'Jennifer', 'Dilly', 'SH_CLERK', 150),
    (190, 'Timothy', 'Gates', 'SH_CLERK', 150),
    (191, 'Randall', 'Perkins', 'SH_CLERK', 150),
    (192, 'Sarah', 'Bell', 'SH_CLERK', 150),
    (193, 'Britney', 'Everett', 'SH_CLERK', 150),
    (194, 'Samuel', 'McCain', 'SH_CLERK', 150),
    (195, 'Vance', 'Jones', 'SH_CLERK', 150),
    (196, 'Alana', 'Walsh', 'SH_CLERK', 150),
    (197, 'Kevin', 'Feeney', 'SH_CLERK', 150),
    (198, 'Donald', 'OConnell', 'SH_CLERK', 150),
    (199, 'Douglas', 'Grant', 'SH_CLERK', 150),
    (200, 'Jennifer', 'Whalen', 'AD_ASST', 10),
    (201, 'Michael', 'Hartstein', 'MK_MAN', 20),
    (202, 'Pat', 'Fay', 'MK_REP', 20),
    (203, 'Susan', 'Mavris', 'HR_REP', 40),
    (204, 'Hermann', 'Baer', 'PR_REP', 70),
    (205, 'Shelley', 'Higgins', 'AC_MGR', 110),
    (206, 'William', 'Gietz', 'AC_ACCOUNT', 110);
    
-- query to find the name (first_name, last_name), job, department ID and name of the employees who works in London.

SELECT 
    e.FIRST_NAME,
    e.LAST_NAME,
    e.JOB_ID,
    e.DEPARTMENT_ID,
    d.DEPARTMENT_NAME
FROM
    employees e
        JOIN
    departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
        JOIN
    locations l ON l.LOCATION_ID = d.LOCATION_ID
WHERE
    l.CITY = 'London';


