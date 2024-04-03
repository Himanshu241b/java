create database if not exists march_15;
use march_15;

select d.department_id, d.department_name, d.manager_id, e.first_name
from
	departments d left join employees e
    on
		d.manager_id = e.manager_id
        group by manager_id;
