
-- 2.Write a MySQL query to find the name (first_name, last name), department ID and name of all the employees.

-- Sample table: employees

-- +-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
-- | EMPLOYEE_ID | FIRST_NAME  | LAST_NAME   | EMAIL    | PHONE_NUMBER       | HIRE_DATE  | JOB_ID     | SALARY   | COMMISSION_PCT | MANAGER_ID | DEPARTMENT_ID |
-- +-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
-- |         100 | Steven      | King        | SKING    | 515.123.4567       | 1987-06-17 | AD_PRES    | 24000.00 |           0.00 |          0 |   		  90 |
-- |         101 | Neena       | Kochhar     | NKOCHHAR | 515.123.4568       | 1987-06-18 | AD_VP      | 17000.00 |           0.00 |        100 |            90 |
-- |         102 | Lex         | De Haan     | LDEHAAN  | 515.123.4569       | 1987-06-19 | AD_VP      | 17000.00 |           0.00 |        100 |            90 |
-- |         103 | Alexander   | Hunold      | AHUNOLD  | 590.423.4567       | 1987-06-20 | IT_PROG    |  9000.00 |           0.00 |        102 |            60 |
-- |         104 | Bruce       | Ernst       | BERNST   | 590.423.4568       | 1987-06-21 | IT_PROG    |  6000.00 |           0.00 |        103 |            60 |
-- |         105 | David       | Austin      | DAUSTIN  | 590.423.4569       | 1987-06-22 | IT_PROG    |  4800.00 |           0.00 |        103 |            60 |
-- |         106 | Valli       | Pataballa   | VPATABAL | 590.423.4560       | 1987-06-23 | IT_PROG    |  4800.00 |           0.00 |        103 |            60 |
-- |         107 | Diana       | Lorentz     | DLORENTZ | 590.423.5567       | 1987-06-24 | IT_PROG    |  4200.00 |           0.00 |        103 |            60 |
-- |         108 | Nancy       | Greenberg   | NGREENBE | 515.124.4569       | 1987-06-25 | FI_MGR     | 12000.00 |           0.00 |        101 |           100 |
-- |         109 | Daniel      | Faviet      | DFAVIET  | 515.124.4169       | 1987-06-26 | FI_ACCOUNT |  9000.00 |           0.00 |        108 |           100 |
-- |         110 | John        | Chen        | JCHEN    | 515.124.4269       | 1987-06-27 | FI_ACCOUNT |  8200.00 |           0.00 |        108 |           100 |
-- |         111 | Ismael      | Sciarra     | ISCIARRA | 515.124.4369       | 1987-06-28 | FI_ACCOUNT |  7700.00 |           0.00 |        108 |           100 |
-- |         112 | Jose Manuel | Urman       | JMURMAN  | 515.124.4469       | 1987-06-29 | FI_ACCOUNT |  7800.00 |           0.00 |        108 |           100 |
-- |         113 | Luis        | Popp        | LPOPP    | 515.124.4567       | 1987-06-30 | FI_ACCOUNT |  6900.00 |           0.00 |        108 |           100 |
-- |         114 | Den         | Raphaely    | DRAPHEAL | 515.127.4561       | 1987-07-01 | PU_MAN     | 11000.00 |           0.00 |        100 |            30 |
-- |         115 | Alexander   | Khoo        | AKHOO    | 515.127.4562       | 1987-07-02 | PU_CLERK   |  3100.00 |           0.00 |        114 |            30 |
-- |         116 | Shelli      | Baida       | SBAIDA   | 515.127.4563       | 1987-07-03 | PU_CLERK   |  2900.00 |           0.00 |        114 |            30 |
-- |         117 | Sigal       | Tobias      | STOBIAS  | 515.127.4564       | 1987-07-04 | PU_CLERK   |  2800.00 |           0.00 |        114 |            30 |
-- |         118 | Guy         | Himuro      | GHIMURO  | 515.127.4565       | 1987-07-05 | PU_CLERK   |  2600.00 |           0.00 |        114 |            30 |
-- |         119 | Karen       | Colmenares  | KCOLMENA | 515.127.4566       | 1987-07-06 | PU_CLERK   |  2500.00 |           0.00 |        114 |            30 |
-- |         120 | Matthew     | Weiss       | MWEISS   | 650.123.1234       | 1987-07-07 | ST_MAN     |  8000.00 |           0.00 |        100 |            50 |
-- |         121 | Adam        | Fripp       | AFRIPP   | 650.123.2234       | 1987-07-08 | ST_MAN     |  8200.00 |           0.00 |        100 |            50 |
-- |         122 | Payam       | Kaufling    | PKAUFLIN | 650.123.3234       | 1987-07-09 | ST_MAN     |  7900.00 |           0.00 |        100 |            50 |
-- |         123 | Shanta      | Vollman     | SVOLLMAN | 650.123.4234       | 1987-07-10 | ST_MAN     |  6500.00 |           0.00 |        100 |            50 |
-- |         124 | Kevin       | Mourgos     | KMOURGOS | 650.123.5234       | 1987-07-11 | ST_MAN     |  5800.00 |           0.00 |        100 |            50 |
-- |         125 | Julia       | Nayer       | JNAYER   | 650.124.1214       | 1987-07-12 | ST_CLERK   |  3200.00 |           0.00 |        120 |            50 |
-- |         126 | Irene       | Mikkilineni | IMIKKILI | 650.124.1224       | 1987-07-13 | ST_CLERK   |  2700.00 |           0.00 |        120 |            50 |
-- |         127 | James       | Landry      | JLANDRY  | 650.124.1334       | 1987-07-14 | ST_CLERK   |  2400.00 |           0.00 |        120 |            50 |
-- |         128 | Steven      | Markle      | SMARKLE  | 650.124.1434       | 1987-07-15 | ST_CLERK   |  2200.00 |           0.00 |        120 |            50 |
-- |         129 | Laura       | Bissot      | LBISSOT  | 650.124.5234       | 1987-07-16 | ST_CLERK   |  3300.00 |           0.00 |        121 |            50 |
-- |         130 | Mozhe       | Atkinson    | MATKINSO | 650.124.6234       | 1987-07-17 | ST_CLERK   |  2800.00 |           0.00 |        121 |            50 |
-- |         131 | James       | Marlow      | JAMRLOW  | 650.124.7234       | 1987-07-18 | ST_CLERK   |  2500.00 |           0.00 |        121 |            50 |
-- |         132 | TJ          | Olson       | TJOLSON  | 650.124.8234       | 1987-07-19 | ST_CLERK   |  2100.00 |           0.00 |        121 |            50 |
-- |         133 | Jason       | Mallin      | JMALLIN  | 650.127.1934       | 1987-07-20 | ST_CLERK   |  3300.00 |           0.00 |        122 |            50 |
-- |         134 | Michael     | Rogers      | MROGERS  | 650.127.1834       | 1987-07-21 | ST_CLERK   |  2900.00 |           0.00 |        122 |            50 |
-- |         135 | Ki          | Gee         | KGEE     | 650.127.1734       | 1987-07-22 | ST_CLERK   |  2400.00 |           0.00 |        122 |            50 |
-- |         136 | Hazel       | Philtanker  | HPHILTAN | 650.127.1634       | 1987-07-23 | ST_CLERK   |  2200.00 |           0.00 |        122 |            50 |
-- |         137 | Renske      | Ladwig      | RLADWIG  | 650.121.1234       | 1987-07-24 | ST_CLERK   |  3600.00 |           0.00 |        123 |            50 |
-- |         138 | Stephen     | Stiles      | SSTILES  | 650.121.2034       | 1987-07-25 | ST_CLERK   |  3200.00 |           0.00 |        123 |            50 |
-- |         139 | John        | Seo         | JSEO     | 650.121.2019       | 1987-07-26 | ST_CLERK   |  2700.00 |           0.00 |        123 |            50 |
-- |         140 | Joshua      | Patel       | JPATEL   | 650.121.1834       | 1987-07-27 | ST_CLERK   |  2500.00 |           0.00 |        123 |            50 |
-- |         141 | Trenna      | Rajs        | TRAJS    | 650.121.8009       | 1987-07-28 | ST_CLERK   |  3500.00 |           0.00 |        124 |            50 |
-- |         142 | Curtis      | Davies      | CDAVIES  | 650.121.2994       | 1987-07-29 | ST_CLERK   |  3100.00 |           0.00 |        124 |            50 |
-- |         143 | Randall     | Matos       | RMATOS   | 650.121.2874       | 1987-07-30 | ST_CLERK   |  2600.00 |           0.00 |        124 |            50 |
-- |         144 | Peter       | Vargas      | PVARGAS  | 650.121.2004       | 1987-07-31 | ST_CLERK   |  2500.00 |           0.00 |        124 |            50 |
-- |         145 | John        | Russell     | JRUSSEL  | 011.44.1344.429268 | 1987-08-01 | SA_MAN     | 14000.00 |           0.40 |        100 |            80 |
-- |         146 | Karen       | Partners    | KPARTNER | 011.44.1344.467268 | 1987-08-02 | SA_MAN     | 13500.00 |           0.30 |        100 |            80 |
-- |         147 | Alberto     | Errazuriz   | AERRAZUR | 011.44.1344.429278 | 1987-08-03 | SA_MAN     | 12000.00 |           0.30 |        100 |            80 |
-- |         148 | Gerald      | Cambrault   | GCAMBRAU | 011.44.1344.619268 | 1987-08-04 | SA_MAN     | 11000.00 |           0.30 |        100 |            80 |
-- |         149 | Eleni       | Zlotkey     | EZLOTKEY | 011.44.1344.429018 | 1987-08-05 | SA_MAN     | 10500.00 |           0.20 |        100 |            80 |
-- |         150 | Peter       | Tucker      | PTUCKER  | 011.44.1344.129268 | 1987-08-06 | SA_REP     | 10000.00 |           0.30 |        145 |            80 |
-- |         151 | David       | Bernstein   | DBERNSTE | 011.44.1344.345268 | 1987-08-07 | SA_REP     |  9500.00 |           0.25 |        145 |            80 |
-- |         152 | Peter       | Hall        | PHALL    | 011.44.1344.478968 | 1987-08-08 | SA_REP     |  9000.00 |           0.25 |        145 |            80 |
-- |         153 | Christopher | Olsen       | COLSEN   | 011.44.1344.498718 | 1987-08-09 | SA_REP     |  8000.00 |           0.20 |        145 |            80 |
-- |         154 | Nanette     | Cambrault   | NCAMBRAU | 011.44.1344.987668 | 1987-08-10 | SA_REP     |  7500.00 |           0.20 |        145 |            80 |
-- |         155 | Oliver      | Tuvault     | OTUVAULT | 011.44.1344.486508 | 1987-08-11 | SA_REP     |  7000.00 |           0.15 |        145 |            80 |
-- |         156 | Janette     | King        | JKING    | 011.44.1345.429268 | 1987-08-12 | SA_REP     | 10000.00 |           0.35 |        146 |            80 |
-- |         157 | Patrick     | Sully       | PSULLY   | 011.44.1345.929268 | 1987-08-13 | SA_REP     |  9500.00 |           0.35 |        146 |            80 |
-- |         158 | Allan       | McEwen      | AMCEWEN  | 011.44.1345.829268 | 1987-08-14 | SA_REP     |  9000.00 |           0.35 |        146 |            80 |
-- |         159 | Lindsey     | Smith       | LSMITH   | 011.44.1345.729268 | 1987-08-15 | SA_REP     |  8000.00 |           0.30 |        146 |            80 |
-- |         160 | Louise      | Doran       | LDORAN   | 011.44.1345.629268 | 1987-08-16 | SA_REP     |  7500.00 |           0.30 |        146 |            80 |
-- |         161 | Sarath      | Sewall      | SSEWALL  | 011.44.1345.529268 | 1987-08-17 | SA_REP     |  7000.00 |           0.25 |        146 |            80 |
-- |         162 | Clara       | Vishney     | CVISHNEY | 011.44.1346.129268 | 1987-08-18 | SA_REP     | 10500.00 |           0.25 |        147 |            80 |
-- |         163 | Danielle    | Greene      | DGREENE  | 011.44.1346.229268 | 1987-08-19 | SA_REP     |  9500.00 |           0.15 |        147 |            80 |
-- |         164 | Mattea      | Marvins     | MMARVINS | 011.44.1346.329268 | 1987-08-20 | SA_REP     |  7200.00 |           0.10 |        147 |            80 |
-- |         165 | David       | Lee         | DLEE     | 011.44.1346.529268 | 1987-08-21 | SA_REP     |  6800.00 |           0.10 |        147 |            80 |
-- |         166 | Sundar      | Ande        | SANDE    | 011.44.1346.629268 | 1987-08-22 | SA_REP     |  6400.00 |           0.10 |        147 |            80 |
-- |         167 | Amit        | Banda       | ABANDA   | 011.44.1346.729268 | 1987-08-23 | SA_REP     |  6200.00 |           0.10 |        147 |            80 |
-- |         168 | Lisa        | Ozer        | LOZER    | 011.44.1343.929268 | 1987-08-24 | SA_REP     | 11500.00 |           0.25 |        148 |            80 |
-- |         169 | Harrison    | Bloom       | HBLOOM   | 011.44.1343.829268 | 1987-08-25 | SA_REP     | 10000.00 |           0.20 |        148 |            80 |
-- |         170 | Tayler      | Fox         | TFOX     | 011.44.1343.729268 | 1987-08-26 | SA_REP     |  9600.00 |           0.20 |        148 |            80 |
-- |         171 | William     | Smith       | WSMITH   | 011.44.1343.629268 | 1987-08-27 | SA_REP     |  7400.00 |           0.15 |        148 |            80 |
-- |         172 | Elizabeth   | Bates       | EBATES   | 011.44.1343.529268 | 1987-08-28 | SA_REP     |  7300.00 |           0.15 |        148 |            80 |
-- |         173 | Sundita     | Kumar       | SKUMAR   | 011.44.1343.329268 | 1987-08-29 | SA_REP     |  6100.00 |           0.10 |        148 |            80 |
-- |         174 | Ellen       | Abel        | EABEL    | 011.44.1644.429267 | 1987-08-30 | SA_REP     | 11000.00 |           0.30 |        149 |            80 |
-- |         175 | Alyssa      | Hutton      | AHUTTON  | 011.44.1644.429266 | 1987-08-31 | SA_REP     |  8800.00 |           0.25 |        149 |            80 |
-- |         176 | Jonathon    | Taylor      | JTAYLOR  | 011.44.1644.429265 | 1987-09-01 | SA_REP     |  8600.00 |           0.20 |        149 |            80 |
-- |         177 | Jack        | Livingston  | JLIVINGS | 011.44.1644.429264 | 1987-09-02 | SA_REP     |  8400.00 |           0.20 |        149 |            80 |
-- |         178 | Kimberely   | Grant       | KGRANT   | 011.44.1644.429263 | 1987-09-03 | SA_REP     |  7000.00 |           0.15 |        149 |             0 |
-- |         179 | Charles     | Johnson     | CJOHNSON | 011.44.1644.429262 | 1987-09-04 | SA_REP     |  6200.00 |           0.10 |        149 |            80 |
-- |         180 | Winston     | Taylor      | WTAYLOR  | 650.507.9876       | 1987-09-05 | SH_CLERK   |  3200.00 |           0.00 |        120 |            50 |
-- |         181 | Jean        | Fleaur      | JFLEAUR  | 650.507.9877       | 1987-09-06 | SH_CLERK   |  3100.00 |           0.00 |        120 |            50 |
-- |         182 | Martha      | Sullivan    | MSULLIVA | 650.507.9878       | 1987-09-07 | SH_CLERK   |  2500.00 |           0.00 |        120 |            50 |
-- |         183 | Girard      | Geoni       | GGEONI   | 650.507.9879       | 1987-09-08 | SH_CLERK   |  2800.00 |           0.00 |        120 |            50 |
-- |         184 | Nandita     | Sarchand    | NSARCHAN | 650.509.1876       | 1987-09-09 | SH_CLERK   |  4200.00 |           0.00 |        121 |            50 |
-- |         185 | Alexis      | Bull        | ABULL    | 650.509.2876       | 1987-09-10 | SH_CLERK   |  4100.00 |           0.00 |        121 |            50 |
-- |         186 | Julia       | Dellinger   | JDELLING | 650.509.3876       | 1987-09-11 | SH_CLERK   |  3400.00 |           0.00 |        121 |            50 |
-- |         187 | Anthony     | Cabrio      | ACABRIO  | 650.509.4876       | 1987-09-12 | SH_CLERK   |  3000.00 |           0.00 |        121 |            50 |
-- |         188 | Kelly       | Chung       | KCHUNG   | 650.505.1876       | 1987-09-13 | SH_CLERK   |  3800.00 |           0.00 |        122 |            50 |
-- |         189 | Jennifer    | Dilly       | JDILLY   | 650.505.2876       | 1987-09-14 | SH_CLERK   |  3600.00 |           0.00 |        122 |            50 |
-- |         190 | Timothy     | Gates       | TGATES   | 650.505.3876       | 1987-09-15 | SH_CLERK   |  2900.00 |           0.00 |        122 |            50 |
-- |         191 | Randall     | Perkins     | RPERKINS | 650.505.4876       | 1987-09-16 | SH_CLERK   |  2500.00 |           0.00 |        122 |            50 |
-- |         192 | Sarah       | Bell        | SBELL    | 650.501.1876       | 1987-09-17 | SH_CLERK   |  4000.00 |           0.00 |        123 |            50 |
-- |         193 | Britney     | Everett     | BEVERETT | 650.501.2876       | 1987-09-18 | SH_CLERK   |  3900.00 |           0.00 |        123 |            50 |
-- |         194 | Samuel      | McCain      | SMCCAIN  | 650.501.3876       | 1987-09-19 | SH_CLERK   |  3200.00 |           0.00 |        123 |            50 |
-- |         195 | Vance       | Jones       | VJONES   | 650.501.4876       | 1987-09-20 | SH_CLERK   |  2800.00 |           0.00 |        123 |            50 |
-- |         196 | Alana       | Walsh       | AWALSH   | 650.507.9811       | 1987-09-21 | SH_CLERK   |  3100.00 |           0.00 |        124 |            50 |
-- |         197 | Kevin       | Feeney      | KFEENEY  | 650.507.9822       | 1987-09-22 | SH_CLERK   |  3000.00 |           0.00 |        124 |            50 |
-- |         198 | Donald      | OConnell    | DOCONNEL | 650.507.9833       | 1987-09-23 | SH_CLERK   |  2600.00 |           0.00 |        124 |            50 |
-- |         199 | Douglas     | Grant       | DGRANT   | 650.507.9844       | 1987-09-24 | SH_CLERK   |  2600.00 |           0.00 |        124 |            50 |
-- |         200 | Jennifer    | Whalen      | JWHALEN  | 515.123.4444       | 1987-09-25 | AD_ASST    |  4400.00 |           0.00 |        101 |            10 |
-- |         201 | Michael     | Hartstein   | MHARTSTE | 515.123.5555       | 1987-09-26 | MK_MAN     | 13000.00 |           0.00 |        100 |            20 |
-- |         202 | Pat         | Fay         | PFAY     | 603.123.6666       | 1987-09-27 | MK_REP     |  6000.00 |           0.00 |        201 |            20 |
-- |         203 | Susan       | Mavris      | SMAVRIS  | 515.123.7777       | 1987-09-28 | HR_REP     |  6500.00 |           0.00 |        101 |            40 |
-- |         204 | Hermann     | Baer        | HBAER    | 515.123.8888       | 1987-09-29 | PR_REP     | 10000.00 |           0.00 |        101 |            70 |
-- |         205 | Shelley     | Higgins     | SHIGGINS | 515.123.8080       | 1987-09-30 | AC_MGR     | 12000.00 |           0.00 |        101 |           110 |
-- |         206 | William     | Gietz       | WGIETZ   | 515.123.8181       | 1987-10-01 | AC_ACCOUNT |  8300.00 |           0.00 |        205 |           110 |
-- +-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+



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

-- Sample Output:

-- first_name	last_name	department_id	department_name
-- Steven		King		90		Executive
-- Neena		Kochhar		90		Executive
-- Lex		De Haan		90		Executive
-- Alexander	Hunold		60		IT
-- Bruce		Ernst		60		IT
-- David		Austin		60		IT
-- Valli		Pataballa	60		IT
-- Diana		Lorentz		60		IT
-- Nancy		Greenberg	100		Finance
-- Daniel		Faviet		100		Finance
-- John		Chen		100		Finance
-- Ismael		Sciarra		100		Finance
-- Jose 		Manuel	Urman	100		Finance
-- Luis		Popp		100		Finance
-- Den		Raphaely	30		Purchasing
-- Alexander	Khoo		30		Purchasing
-- Shelli		Baida		30		Purchasing
-- Sigal		Tobias		30		Purchasing
-- Guy		Himuro		30		Purchasing
-- Karen		Colmenares	30		Purchasing
-- Matthew		Weiss		50		Shipping
-- Adam		Fripp		50		Shipping
-- Payam		Kaufling	50		Shipping
-- Shanta		Vollman		50		Shipping
-- Kevin		Mourgos		50		Shipping
-- Julia		Nayer		50		Shipping
-- Irene		Mikkilineni	50		Shipping
-- James		Landry		50		Shipping
-- Steven		Markle		50		Shipping
-- Laura		Bissot		50		Shipping
-- Mozhe		Atkinson	50		Shipping
-- James		Marlow		50		Shipping
-- TJ		Olson		50		Shipping
-- Jason		Mallin		50		Shipping
-- Michael		Rogers		50		Shipping
-- Ki		Gee		50		Shipping
-- Hazel		Philtanker	50		Shipping
-- Renske		Ladwig		50		Shipping
-- Stephen		Stiles		50		Shipping
-- John		Seo		50		Shipping
-- Joshua		Patel		50		Shipping
-- Trenna		Rajs		50		Shipping
-- Curtis		Davies		50		Shipping
-- Randall		Matos		50		Shipping
-- Peter		Vargas		50		Shipping
-- John		Russell		80		Sales
-- Karen		Partners	80		Sales
-- Alberto		Errazuriz	80		Sales
-- Gerald		Cambrault	80		Sales
-- Eleni		Zlotkey		80		Sales
-- Peter		Tucker		80		Sales
-- David		Bernstein	80		Sales
-- Peter		Hall		80		Sales
-- Christopher	Olsen		80		Sales
-- Nanette		Cambrault	80		Sales
-- Oliver		Tuvault		80		Sales
-- Janette		King		80		Sales
-- Patrick		Sully		80		Sales
-- Allan		McEwen		80		Sales
-- Lindsey		Smith		80		Sales
-- Louise		Doran		80		Sales
-- Sarath		Sewall		80		Sales
-- Clara		Vishney		80		Sales
-- Danielle	Greene		80		Sales
-- Mattea		Marvins		80		Sales
-- David		Lee		80		Sales
-- Sundar		Ande		80		Sales
-- Amit		Banda		80		Sales
-- Lisa		Ozer		80		Sales
-- Harrison	Bloom		80		Sales
-- Tayler		Fox		80		Sales
-- William		Smith		80		Sales
-- Elizabeth	Bates		80		Sales
-- Sundita		Kumar		80		Sales
-- Ellen		Abel		80		Sales
-- Alyssa		Hutton		80		Sales
-- Jonathon	Taylor		80		Sales
-- Jack		Livingston	80		Sales
-- Charles		Johnson		80		Sales
-- Winston		Taylor		50		Shipping
-- Jean		Fleaur		50		Shipping
-- Martha		Sullivan	50		Shipping
-- Girard		Geoni		50		Shipping
-- Nandita		Sarchand	50		Shipping
-- Alexis		Bull		50		Shipping
-- Julia		Dellinger	50		Shipping
-- Anthony		Cabrio		50		Shipping
-- Kelly		Chung		50		Shipping
-- Jennifer	Dilly		50		Shipping
-- Timothy		Gates		50		Shipping
-- Randall		Perkins		50		Shipping
-- Sarah		Bell		50		Shipping
-- Britney		Everett		50		Shipping
-- Samuel		McCain		50		Shipping
-- Vance		Jones		50		Shipping
-- Alana		Walsh		50		Shipping
-- Kevin		Feeney		50		Shipping
-- Donald		OConnell	50		Shipping
-- Douglas		Grant		50		Shipping
-- Jennifer	Whalen		10		Administration
-- Michael		Hartstein	20		Marketing
-- Pat		Fay		20		Marketing
-- Susan		Mavris		40		Human Resources
-- Hermann		Baer		70		Public Relations
-- Shelley		Higgins		110		Accounting
-- William		Gietz		110		Accounting

use TestDb;

-- Create employees table
CREATE TABLE employees (
    EMPLOYEE_ID INT,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    EMAIL VARCHAR(50),
    PHONE_NUMBER VARCHAR(20),
    HIRE_DATE DATE,
    JOB_ID VARCHAR(10),
    SALARY DECIMAL(10, 2),
    COMMISSION_PCT DECIMAL(4, 2),
    MANAGER_ID INT,
    DEPARTMENT_ID INT
);

-- Create departments table
CREATE TABLE departments (
    DEPARTMENT_ID INT,
    DEPARTMENT_NAME VARCHAR(50),
    MANAGER_ID INT,
    LOCATION_ID INT
);

-- Insert data into employees table
INSERT INTO employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)
VALUES 
(100, 'Steven', 'King', 'SKING', '515.123.4567', '1987-06-17', 'AD_PRES', 24000.00, 0.00, 0, 90),
(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1987-06-18', 'AD_VP', 17000.00, 0.00, 100, 90),
(102, 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '1987-06-19', 'AD_VP', 17000.00, 0.00, 100, 90),
(103, 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1987-06-20', 'IT_PROG', 9000.00, 0.00, 102, 60),
(104, 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1987-06-21', 'IT_PROG', 6000.00, 0.00, 103, 60),
(105, 'David', 'Austin', 'DAUSTIN', '590.423.4569', '1987-06-22', 'IT_PROG', 4800.00, 0.00, 103, 60),
(106, 'Valli', 'Pataballa', 'VPATABAL', '590.423.4560', '1987-06-23', 'IT_PROG', 4800.00, 0.00, 103, 60),
(107, 'Diana', 'Lorentz', 'DLORENTZ', '590.423.5567', '1987-06-24', 'IT_PROG', 4200.00, 0.00, 103, 60),
(108, 'Nancy', 'Greenberg', 'NGREENBE', '515.124.4569', '1987-06-25', 'FI_MGR', 12008.00, 0.00, 101, 100),
(109, 'Daniel', 'Faviet', 'DFAVIET', '515.124.4169', '1987-06-26', 'FI_ACCOUNT', 9000.00, 0.00, 108, 100),
(110, 'John', 'Chen', 'JCHEN', '515.124.4269', '1987-06-27', 'FI_ACCOUNT', 8200.00, 0.00, 108, 100),
(111, 'Ismael', 'Sciarra', 'ISCIARRA', '515.124.4369', '1987-06-28', 'FI_ACCOUNT', 7700.00, 0.00, 108, 100),
(112, 'Jose Manuel', 'Urman', 'JMURMAN', '515.124.4469', '1987-06-29', 'FI_ACCOUNT', 7800.00, 0.00, 108, 100),
(113, 'Luis', 'Popp', 'LPOPP', '515.124.4567', '1987-06-30', 'FI_ACCOUNT', 6900.00, 0.00, 108, 100),
(114, 'Den', 'Raphaely', 'DRAPHEAL', '515.127.4561', '1987-07-01', 'PU_MAN', 11000.00, 0.00, 100, 30),
(115, 'Alexander', 'Khoo', 'AKHOO', '515.127.4562', '1987-07-02', 'PU_CLERK', 3100.00, 0.00, 114, 30),
(116, 'Shelli', 'Baida', 'SBAIDA', '515.127.4563', '1987-07-03', 'PU_CLERK', 2900.00, 0.00, 114, 30),
(117, 'Sigal', 'Tobias', 'STOBIAS', '515.127.4564', '1987-07-04', 'PU_CLERK', 2800.00, 0.00, 114, 30),
(118, 'Guy', 'Himuro', 'GHIMURO', '515.127.4565', '1987-07-05', 'PU_CLERK', 2600.00, 0.00, 114, 30),
(119, 'Karen', 'Colmenares', 'KCOLMENA', '515.127.4566', '1987-07-06', 'PU_CLERK', 2500.00, 0.00, 114, 30),
(120, 'Matthew', 'Weiss', 'MWEISS', '650.123.1234', '1987-07-07', 'ST_MAN', 8000.00, 0.00, 100, 50),
(121, 'Adam', 'Fripp', 'AFRIPP', '650.123.2234', '1987-07-08', 'ST_MAN', 8200.00, 0.00, 100, 50),
(122, 'Payam', 'Kaufling', 'PKAUFLIN', '650.123.3234', '1987-07-09', 'ST_MAN', 7900.00, 0.00, 100, 50),
(123, 'Shanta', 'Vollman', 'SVOLLMAN', '650.123.4234', '1987-07-10', 'ST_MAN', 6500.00, 0.00, 100, 50),
(124, 'Kevin', 'Mourgos', 'KMOURGOS', '650.123.5234', '1987-07-11', 'ST_MAN', 5800.00, 0.00, 100, 50),
(125, 'Julia', 'Nayer', 'JNAYER', '650.124.1214', '1987-07-12', 'ST_CLERK', 3200.00, 0.00, 120, 50),
(126, 'Irene', 'Mikkilineni', 'IMIKKILI', '650.124.1224', '1987-07-13', 'ST_CLERK', 2700.00, 0.00, 120, 50),
(127, 'James', 'Landry', 'JLANDRY', '650.124.1334', '1987-07-14', 'ST_CLERK', 2400.00, 0.00, 120, 50),
(128, 'Steven', 'Markle', 'SMARKLE', '650.124.1434', '1987-07-15', 'ST_CLERK', 2200.00, 0.00, 120, 50),
(129, 'Laura', 'Bissot', 'LBISSOT', '650.124.5234', '1987-07-16', 'ST_CLERK', 3300.00, 0.00, 121, 50),
(130, 'Mozhe', 'Atkinson', 'MATKINSO', '650.124.6234', '1987-07-17', 'ST_CLERK', 2800.00, 0.00, 121, 50),
(131, 'James', 'Marlow', 'JAMRLOW', '650.124.7234', '1987-07-18', 'ST_CLERK', 2500.00, 0.00, 121, 50),
(132, 'TJ', 'Olson', 'TJOLSON', '650.124.8234', '1987-07-19', 'ST_CLERK', 2100.00, 0.00, 121, 50),
(133, 'Jason', 'Mallin', 'JMALLIN', '650.127.1934', '1987-07-20', 'ST_CLERK', 3300.00, 0.00, 122, 50),
(134, 'Michael', 'Rogers', 'MROGERS', '650.127.1834', '1987-07-21', 'ST_CLERK', 2900.00, 0.00, 122, 50),
(135, 'Ki', 'Gee', 'KGEE', '650.127.1734', '1987-07-22', 'ST_CLERK', 2400.00, 0.00, 122, 50),
(136, 'Hazel', 'Philtanker', 'HPHILTAN', '650.127.1634', '1987-07-23', 'ST_CLERK', 2200.00, 0.00, 122, 50),
(137, 'Renske', 'Ladwig', 'RLADWIG', '650.121.1234', '1987-07-24', 'ST_CLERK', 3600.00, 0.00, 123, 50),
(138, 'Stephen', 'Stiles', 'SSTILES', '650.121.2034', '1987-07-25', 'ST_CLERK', 3200.00, 0.00, 123, 50),
(139, 'John', 'Seo', 'JSEO', '650.121.2019', '1987-07-26', 'ST_CLERK', 2700.00, 0.00, 123, 50),
(140, 'Joshua', 'Patel', 'JPATEL', '650.121.1834', '1987-07-27', 'ST_CLERK', 2500.00, 0.00, 123, 50),
(141, 'Trenna', 'Rajs', 'TRAJS', '650.121.8009', '1987-07-28', 'ST_CLERK', 3500.00, 0.00, 124, 50),
(142, 'Curtis', 'Davies', 'CDAVIES', '650.121.2994', '1987-07-29', 'ST_CLERK', 3100.00, 0.00, 124, 50),
(143, 'Randall', 'Matos', 'RMATOS', '650.121.2874', '1987-07-30', 'ST_CLERK', 2600.00, 0.00, 124, 50),
(144, 'Peter', 'Vargas', 'PVARGAS', '650.121.2004', '1987-07-31', 'ST_CLERK', 2500.00, 0.00, 124, 50),
(145, 'John', 'Russell', 'JRUSSEL', '011.44.1344.429268', '1987-08-01', 'SA_MAN', 14000.00, 0.40, 100, 80),
(146, 'Karen', 'Partners', 'KPARTNER', '011.44.1344.467268', '1987-08-02', 'SA_MAN', 13500.00, 0.30, 100, 80),
(147, 'Alberto', 'Errazuriz', 'AERRAZUR', '011.44.1344.429278', '1987-08-03', 'SA_MAN', 12000.00, 0.30, 100, 80),
(148, 'Gerald', 'Cambrault', 'GCAMBRAU', '011.44.1344.619268', '1987-08-04', 'SA_MAN', 11000.00, 0.30, 100, 80),
(149, 'Eleni', 'Zlotkey', 'EZLOTKEY', '011.44.1344.429018', '1987-08-05', 'SA_MAN', 10500.00, 0.20, 100, 80),
(150, 'Peter', 'Tucker', 'PTUCKER', '011.44.1344.129268', '1987-08-06', 'SA_REP', 10000.00, 0.30, 145, 80),
(151, 'David', 'Bernstein', 'DBERNSTE', '011.44.1344.345268', '1987-08-07', 'SA_REP', 9500.00, 0.25, 145, 80),
(152, 'Peter', 'Hall', 'PHALL', '011.44.1344.478968', '1987-08-08', 'SA_REP', 9000.00, 0.25, 145, 80),
(153, 'Christopher', 'Olsen', 'COLSEN', '011.44.1344.498718', '1987-08-09', 'SA_REP', 8000.00, 0.20, 145, 80),
(154, 'Nanette', 'Cambrault', 'NCAMBRAU', '011.44.1344.987668', '1987-08-10', 'SA_REP', 7500.00, 0.20, 145, 80),
(155, 'Oliver', 'Tuvault', 'OTUVAULT', '011.44.1344.486508', '1987-08-11', 'SA_REP', 7000.00, 0.15, 145, 80),
(156, 'Janette', 'King', 'JKING', '011.44.1345.429268', '1987-08-12', 'SA_REP', 10000.00, 0.35, 146, 80),
(157, 'Patrick', 'Sully', 'PSULLY', '011.44.1345.929268', '1987-08-13', 'SA_REP', 9500.00, 0.35, 146, 80),
(158, 'Allan', 'McEwen', 'AMCEWEN', '011.44.1345.829268', '1987-08-14', 'SA_REP', 9000.00, 0.35, 146, 80),
(159, 'Lindsey', 'Smith', 'LSMITH', '011.44.1345.729268', '1987-08-15', 'SA_REP', 8000.00, 0.30, 146, 80),
(160, 'Louise', 'Doran', 'LDORAN', '011.44.1345.629268', '1987-08-16', 'SA_REP', 7500.00, 0.30, 146, 80),
(161, 'Sarath', 'Sewall', 'SSEWALL', '011.44.1345.529268', '1987-08-17', 'SA_REP', 7000.00, 0.25, 146, 80),
(162, 'Clara', 'Vishney', 'CVISHNEY', '011.44.1346.129268', '1987-08-18', 'SA_REP', 10500.00, 0.25, 147, 80),
(163, 'Danielle', 'Greene', 'DGREENE', '011.44.1346.229268', '1987-08-19', 'SA_REP', 9500.00, 0.15, 147, 80),
(164, 'Mattea', 'Marvins', 'MMARVINS', '011.44.1346.329268', '1987-08-20', 'SA_REP', 7200.00, 0.10, 147, 80),
(165, 'David', 'Lee', 'DLEE', '011.44.1346.529268', '1987-08-21', 'SA_REP', 6800.00, 0.10, 147, 80),
(166, 'Sundar', 'Ande', 'SANDE', '011.44.1346.629268', '1987-08-22', 'SA_REP', 6400.00, 0.10, 147, 80),
(167, 'Amit', 'Banda', 'ABANDA', '011.44.1346.729268', '1987-08-23', 'SA_REP', 6200.00, 0.10, 147, 80),
(168, 'Lisa', 'Ozer', 'LOZER', '011.44.1343.929268', '1987-08-24', 'SA_REP', 11500.00, 0.25, 148, 80),
(169, 'Harrison', 'Bloom', 'HBLOOM', '011.44.1343.829268', '1987-08-25', 'SA_REP', 10000.00, 0.20, 148, 80);

-- Insert data into departments table
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
(110, 'Accounting', 205, 1700);

-- query to find the name (first_name, last name), department ID and name of all the employees.

SELECT 
    e.FIRST_NAME,
    e.LAST_NAME,
    e.DEPARTMENT_ID,
    d.DEPARTMENT_NAME
FROM 
    employees e
JOIN 
    departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

