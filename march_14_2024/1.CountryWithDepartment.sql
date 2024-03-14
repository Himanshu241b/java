-- Write a MySQL query to find the addresses (location_id, street_address, city, state_province, country_name) of all the departments.

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


-- Sample table: countries

-- country_id  country_name  region_id
-- ----------  ------------  ----------
-- country_id  country_name  region_id
-- AR          Argentina     2
-- AU          Australia     3
-- BE          Belgium       1
-- BR          Brazil        2
-- CA          Canada        2
-- CH          Switzerland   1
-- CN          China         3
-- DE          Germany       1
-- DK          Denmark       1
-- EG          Egypt         4
-- FR          France        1
-- HK          HongKong      3
-- IL          Israel        4
-- IN          India         3
-- IT          Italy         1
-- JP          Japan         3
-- KW          Kuwait        4
-- MX          Mexico        2
-- NG          Nigeria       4
-- NL          Netherlands   1
-- SG          Singapore     3
-- UK          United Kingd  1
-- US          United State  2
-- ZM          Zambia        4
-- ZW          Zimbabwe      4


-- Sample Output:

-- location_id		street_address			city				state_province			country_name
-- 1000			1297 Via Cola di Rie		Roma								Italy
-- 1100			93091 Calle della Testa		Venice								Italy
-- 1200			2017 Shinjuku-ku		Tokyo				Tokyo Prefecture		Japan
-- 1300			9450 Kamiya-cho			Hiroshima							Japan
-- 1400			2014 Jabberwocky Rd		Southlake			Texas				United States of America
-- 1500			2011 Interiors Blvd		South San Francisco		California			United States of America
-- 1600			2007 Zagora St			South Brunswick			New Jersey			United States of America
-- 1700			2004 Charade Rd			Seattle				Washington			United States of America
-- 1800			147 Spadina Ave			Toronto				Ontario				Canada
-- 1900			6092 Boxwood St			Whitehorse			Yukon				Canada
-- 2000			40-5-12 Laogianggen		Beijing								China
-- 2100			1298 Vileparle (E)		Bombay				Maharashtra			India
-- 2200			12-98 Victoria Street		Sydney				New South Wales			Australia
-- 2300			198 Clementi North		Singapore							Singapore
-- 2400			8204 Arthur St			London								United Kingdom
-- 2600			9702 Chester Road		Stretford			Manchester			United Kingdom
-- 2700			Schwanthalerstr. 7031		Munich				Bavaria				Germany
-- 2800			Rua Frei Caneca 1360		Sao Paulo			Sao Paulo			Brazil
-- 2900			20 Rue des Corps-Saints		Geneva				Geneve				Switzerland
-- 3000			Murtenstrasse 921		Bern				BE				Switzerland
-- 3100			Pieter Breughelstraat 837	Utrecht				Utrecht				Netherlands

USE TestDb;

-- Create countries table
CREATE TABLE countries (
    country_id VARCHAR(2) PRIMARY KEY,
    country_name VARCHAR(50),
    region_id INT
);

-- Insert data into countries table
INSERT INTO countries (country_id, country_name, region_id) VALUES
('AR', 'Argentina', 2),
('AU', 'Australia', 3),
('BE', 'Belgium', 1),
('BR', 'Brazil', 2),
('CA', 'Canada', 2),
('CH', 'Switzerland', 1),
('CN', 'China', 3),
('DE', 'Germany', 1),
('DK', 'Denmark', 1),
('EG', 'Egypt', 4),
('FR', 'France', 1),
('HK', 'Hong Kong', 3),
('IL', 'Israel', 4),
('IN', 'India', 3),
('IT', 'Italy', 1),
('JP', 'Japan', 3),
('KW', 'Kuwait', 4),
('MX', 'Mexico', 2),
('NG', 'Nigeria', 4),
('NL', 'Netherlands', 1),
('SG', 'Singapore', 3),
('UK', 'United Kingdom', 1),
('US', 'United States of America', 2),
('ZM', 'Zambia', 4),
('ZW', 'Zimbabwe', 4);

-- Create locations table
CREATE TABLE locations (
    location_id INT PRIMARY KEY,
    street_address VARCHAR(100),
    postal_code VARCHAR(20),
    city VARCHAR(50),
    state_province VARCHAR(50),
    country_id VARCHAR(2),
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

-- Insert data into locations table
INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id) VALUES
(1000, '1297 Via Cola di Rie', '989', 'Roma', NULL, 'IT'),
(1100, '93091 Calle della Te', '10934', 'Venice', NULL, 'IT'),
(1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),
(1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
(1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
(1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US'),
(1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
(1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
(1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA'),
(2000, '40-5-12 Laogianggen', '190518', 'Beijing', NULL, 'CN'),
(2100, '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN'),
(2200, '12-98 Victoria Stree', '2901', 'Sydney', 'New South Wales', 'AU'),
(2300, '198 Clementi North', '540198', 'Singapore', NULL, 'SG'),
(2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
(2500, 'Magdalen Centre, The', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK'),
(2600, '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK'),
(2700, 'Schwanthalerstr. 703', '80925', 'Munich', 'Bavaria', 'DE'),
(2800, 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR'),
(2900, '20 Rue des Corps-Sai', '1730', 'Geneva', 'Geneve', 'CH'),
(3000, 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH'),
(3100, 'Pieter Breughelstraa', '3029SK', 'Utrecht', 'Utrecht', 'NL'),
(3200, 'Mariano Escobedo 999', '11932', 'Mexico City', 'Distrito Federal', 'MX');

-- query to find the addresses (location_id, street_address, city, state_province, country_name) of all the departments.
SELECT 
    l.location_id,
    l.street_address,
    l.city,
    l.state_province,
    c.country_name
FROM
    locations l
        JOIN
    countries c ON l.country_id = c.country_id
ORDER BY l.location_id;



