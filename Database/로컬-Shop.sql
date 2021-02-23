select * from membertbl;

select * from producttbl;

select sysdate from dual; --���� ��¥
select to_char(sysdate, 'yyyy/mm/dd hh:mm:ss') "���� ��¥"
from dual;

select to_date('20201231235959', 'yyyymmddhh24miss') "��¥ ����"
from dual;

create table test (idNum NUMBER(5));
insert into test (idNum) values(1);
select * from test;

insert into test (idNum) values('1'); --����
insert into test (idNum) values("1"); --����
insert into test (idNum) values('10'); --����
insert into test (idNum) values('10a'); --����
insert into test (idNum) values(20);

drop table test;

drop table buytbl CASCADE CONSTRAINTS;
drop table usertbl CASCADE CONSTRAINTS;

create table usertbl --ȸ�� ���̺�
(userID CHAR(8), --����� ���̵�(PK). PK�� default�� not null
 userName NVARCHAR2(10) NOT NULL, --�̸�
 birthYear NUMBER(4) NOT NULL, --����⵵
 addr NCHAR(2) NOT NULL, --����(���, ����, �泲, ������ 2���ڸ� �Է�)
 mobile1 CHAR(3) NULL, --�޴����� ����(010, 011, 016, 017, 018, 019 ��)
 mobile2 CHAR(8) NULL, --�޴����� ������ ��ȭ��ȣ(������ ����)
 height NUMBER(3) NULL, --Ű
 mDate DATE NULL, --ȸ�� ������
 constraint PK_usertbl_userID PRIMARY KEY(userID)
);

create table buytbl --ȸ�� ���� ���̺�
(idNum NUMBER(8) PRIMARY KEY, --����(PK)
 userID CHAR(8) NOT NULL, --���̵�(FK)
 prodName NCHAR(6) NOT NULL, --��ǰ��
 groupName NCHAR(4) NULL, --�з�
 price NUMBER(8) NULL, --�ܰ�
 amount NUMBER(3) NOT NULL, --����
 CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
 REFERENCES usertbl(userID)
);

create sequence idSEQ;

insert into usertbl values('LSG', '�̽±�', 1987, '����', '011', '11111111', 182, '2008-8-8');
insert into usertbl values('KBS', '�����', 1979, '�泲', '011', '22222222', 173, '2012-4-4');
insert into usertbl values('KKH', '���ȣ', 1971, '����', '019', '33333333', 177, '2007-7-7');

select * from usertbl;

insert into buytbl values(idSEQ.NEXTVAL, 'KBS', '�ȭ', NULL, 30, 2);
insert into buytbl values(idSEQ.NEXTVAL, 'KBS', '��Ʈ��', '����', 1000, 1);
--�����ϴ� ���̺��� PK�� userID�� JYP�� �����Ƿ� ����
insert into buytbl values(idSEQ.NEXTVAL, 'JYP', '�����', '����', 200, 1);
--idSEQ.NEXTVAL�� 4�� ��
insert into buytbl values(idSEQ.NEXTVAL, 'LSG', '�����', '����', 200, 1);

select * from buytbl;

--�빮�ڷ� �ľ� ��� ����
select * from user_constraints --Ű ������ ��ϵ� ���̺�
where owner = 'SHOP'
and table_name = 'USERTBL'
and constraint_type='P'; --P�� �⺻ Ű, R�� �ܷ� Ű, C�� NOT NULL �Ǵ� CHECK

drop table usertbl CASCADE constraints;

create table usertbl --ȸ�� ���̺�
(userID CHAR(8) NOT NULL, --����� ���̵�(PK). PK�� default�� not null
 userName NVARCHAR2(10) NOT NULL, --�̸�
 birthYear NUMBER(4) NOT NULL, --����⵵
 addr NCHAR(2) NOT NULL, --����(���, ����, �泲, ������ 2���ڸ� �Է�)
 mobile1 CHAR(3) NULL, --�޴����� ����(010, 011, 016, 017, 018, 019 ��)
 mobile2 CHAR(8) NULL, --�޴����� ������ ��ȭ��ȣ(������ ����)
 height NUMBER(3) NULL, --Ű
 mDate DATE NULL --ȸ�� ������
);

alter table usertbl
add constraint pk_usertbl_userID
primary key(userID);

create table prodtbl
(prodCode CHAR(3) NOT NULL,
 prodID CHAR(4) NOT NULL,
 prodDate DATE NOT NULL,
 prodCur CHAR(10) NULL
);

alter table prodtbl
add constraint pk_prodtbl_proCode_prodID
PRIMARY KEY(prodCode, prodID);

select * from user_constraints --Ű ������ ��ϵ� ���̺�
where owner = 'SHOP'
and table_name = 'PRODTBL'
and constraint_type='P'; --P�� �⺻ Ű, R�� �ܷ� Ű, C�� NOT NULL �Ǵ� CHECK

select * from user_constraints --Ű ������ ��ϵ� ���̺�
where owner = 'SHOP'
and table_name = 'BUYTBL'
and constraint_type='R'; --P�� �⺻ Ű, R�� �ܷ� Ű, C�� NOT NULL �Ǵ� CHECK

create table buytbl --ȸ�� ���� ���̺�
(idNum NUMBER(8) NOT NULL PRIMARY KEY, --����(PK)
 userID CHAR(8) NOT NULL, --���̵�(FK)
 prodName NCHAR(6) NOT NULL, --��ǰ��
 groupName NCHAR(4) NULL, --�з�
 price NUMBER(8) NULL, --�ܰ�
 amount NUMBER(3) NOT NULL --����
);

alter table buytbl
add CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
REFERENCES usertbl(userID);

alter table buytbl
add CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
REFERENCES usertbl(userID)
on delete cascade;

create table usertbl --ȸ�� ���̺�
(userID CHAR(8) NOT NULL PRIMARY KEY, --����� ���̵�(PK). PK�� default�� not null
 userName NVARCHAR2(10) NOT NULL, --�̸�
 birthYear NUMBER(4) DEFAULT -1 NOT NULL, --����⵵
 addr NCHAR(2) DEFAULT '����' NOT NULL, --����(���, ����, �泲, ������ 2���ڸ� �Է�)
 mobile1 CHAR(3) NULL, --�޴����� ����(010, 011, 016, 017, 018, 019 ��)
 mobile2 CHAR(8) NULL, --�޴����� ������ ��ȭ��ȣ(������ ����)
 height NUMBER(3) DEFAULT 170 NULL, --Ű
 mDate DATE NULL --ȸ�� ������
);

insert into usertbl values('LSG', '�̽±�', default, default, '011', '11111111', default, '2008-8-8');
insert into usertbl(userID, userName) values('KAH','��ƿ�');
insert into usertbl(userID, userName, birthYEAR) values('HGD', 'ȫ�浿', 1980);
select * from usertbl;

insert into usertbl values('KBS', '�����', 1979, '�泲', '011', null, 173, '2012-4-4');
insert into usertbl values('KKH', '���ȣ', 1971, '����', '011', '', 177, '2007-7-7');
insert into usertbl values('KKH2', '���ȣ2', 1971, '����', '011', ' ', 177, '2007-7-7');

