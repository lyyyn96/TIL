select * from employees; --스키마 이름은 생략 가능

show tables;

select department_name, department_id from departments;

/*
열의 순서대로 출력됨
열의 열거는 ,로
*/

select * from employees
where employee_id>=120 and employee_id<130;

select * from employees
where first_name = 'Adam';

select * from employees
where salary>20000 or salary<3000;

select * from employees
where salary>3000 and salary<5000;

--where salary>=3000 and salary<=5000;
select * from employees
where salary between 3000 and 5000;

--first_name이 A로 시작하는 employee
select * from employees
where first_name LIKE 'A%';

--두 번째 first_name이 a인 employee
select * from employees
where first_name LIKE '_a%';

--세 번째 first_name이 a인 employee
select * from employees
where first_name LIKE '__a%';

--firt_name에 a를 포함하는 employee
select * from employees
where first_name LIKE '%a%';

--salary를 기준으로 오름차순
select * from employees
where first_name LIKE '%a%'
order by salary;

--salary를 기준으로 내림차순
select * from employees
where first_name LIKE '%a%'
order by salary desc;

--우선 salary를 기준으로 내림차순 후 employee_id 기준으로 오름차순 
select * from employees
where first_name LIKE '%a%'
order by salary desc, employee_id asc;

--distinct로 hire_date의 중복을 없앰
select distinct hire_date from employees;









