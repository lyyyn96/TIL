select membername, memberaddress from membertbl;
select * from membertbl where membername = '������';

create table "my testTBL" (id NUMBER(3));
drop table "my testTBL";

select * from membertbl;

insert into membertbl values('Chr', '������', '��� ������ �д籸');

insert into membertbl(MEMBERID, MEMBERNAME, MEMBERADDRESS)
values('Kim', '�迵��', '���� �սʸ�');

insert into membertbl(MEMBERNAME, MEMBERADDRESS, MEMBERID)
values('�̿���', '���� ���α�', 'Lee');

select * from producttbl;

--Ŀ�� ���Ŀ��� �ѹ��� �Ұ��ϹǷ� ������ Ŀ���� �ʿ�
update producttbl
set amount=100;

update producttbl
set amount=100
where productname = '��ǻ��';

delete from PRODUCTTBL
where productname = '��ǻ��';

delete from PRODUCTTBL;





