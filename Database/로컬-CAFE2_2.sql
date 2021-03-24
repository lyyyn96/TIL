create table orders(
order_group_no number(10),
orderdate date,
ordermethod varchar2(20),
product_name varchar2(50),
quantity number(10)
);

CREATE SEQUENCE order_group_no_seq START WITH 1 INCREMENT BY 1;

insert into orders(orderdate, ordermethod, product_name, quantity, order_group_no) 
values(SYSDATE, 'web' , '�Ƹ޸�ī��', 1, order_group_no_seq.nextval);

select * from orders;