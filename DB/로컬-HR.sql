select * from employees; --��Ű�� �̸��� ���� ����

show tables;

select department_name, department_id from departments;

/*
���� ������� ��µ�
���� ���Ŵ� ,��
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

--first_name�� A�� �����ϴ� employee
select * from employees
where first_name LIKE 'A%';

--�� ��° first_name�� a�� employee
select * from employees
where first_name LIKE '_a%';

--�� ��° first_name�� a�� employee
select * from employees
where first_name LIKE '__a%';

--firt_name�� a�� �����ϴ� employee
select * from employees
where first_name LIKE '%a%';

--salary�� �������� ��������
select * from employees
where first_name LIKE '%a%'
order by salary;

--salary�� �������� ��������
select * from employees
where first_name LIKE '%a%'
order by salary desc;

--�켱 salary�� �������� �������� �� employee_id �������� �������� 
select * from employees
where first_name LIKE '%a%'
order by salary desc, employee_id asc;

--distinct�� hire_date�� �ߺ��� ����
select distinct hire_date from employees;









