select * from membertbl;

select * from producttbl;

select sysdate from dual; --현재 날짜
select to_char(sysdate, 'yyyy/mm/dd hh:mm:ss') "현재 날짜"
from dual;

select to_date('20201231235959', 'yyyymmddhh24miss') "날짜 형식"
from dual;

create table test (idNum NUMBER(5));
insert into test (idNum) values(1);
select * from test;

insert into test (idNum) values('1'); --가능
insert into test (idNum) values("1"); --에러
insert into test (idNum) values('10'); --가능
insert into test (idNum) values('10a'); --에러
insert into test (idNum) values(20);

drop table test;

drop table buytbl CASCADE CONSTRAINTS;
drop table usertbl CASCADE CONSTRAINTS;

create table usertbl --회원 테이블
(userID CHAR(8), --사용자 아이디(PK). PK는 default가 not null
 userName NVARCHAR2(10) NOT NULL, --이름
 birthYear NUMBER(4) NOT NULL, --출생년도
 addr NCHAR(2) NOT NULL, --지역(경기, 서울, 경남, 식으로 2글자만 입력)
 mobile1 CHAR(3) NULL, --휴대폰의 국번(010, 011, 016, 017, 018, 019 등)
 mobile2 CHAR(8) NULL, --휴대폰의 나머지 전화번호(하이픈 제외)
 height NUMBER(3) NULL, --키
 mDate DATE NULL, --회원 가입일
 constraint PK_usertbl_userID PRIMARY KEY(userID)
);

create table buytbl --회원 구매 테이블
(idNum NUMBER(8) PRIMARY KEY, --순번(PK)
 userID CHAR(8) NOT NULL, --아이디(FK)
 prodName NCHAR(6) NOT NULL, --물품명
 groupName NCHAR(4) NULL, --분류
 price NUMBER(8) NULL, --단가
 amount NUMBER(3) NOT NULL, --수량
 CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
 REFERENCES usertbl(userID)
);

create sequence idSEQ;

insert into usertbl values('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8');
insert into usertbl values('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4');
insert into usertbl values('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');

select * from usertbl;

insert into buytbl values(idSEQ.NEXTVAL, 'KBS', '운동화', NULL, 30, 2);
insert into buytbl values(idSEQ.NEXTVAL, 'KBS', '노트북', '전자', 1000, 1);
--참조하는 테이블의 PK인 userID인 JYP가 없으므로 에러
insert into buytbl values(idSEQ.NEXTVAL, 'JYP', '모니터', '전자', 200, 1);
--idSEQ.NEXTVAL은 4가 됨
insert into buytbl values(idSEQ.NEXTVAL, 'LSG', '모니터', '전자', 200, 1);

select * from buytbl;

--대문자로 쳐야 결과 나옴
select * from user_constraints --키 정보가 등록된 테이블
where owner = 'SHOP'
and table_name = 'USERTBL'
and constraint_type='P'; --P는 기본 키, R은 외래 키, C는 NOT NULL 또는 CHECK

drop table usertbl CASCADE constraints;

create table usertbl --회원 테이블
(userID CHAR(8) NOT NULL, --사용자 아이디(PK). PK는 default가 not null
 userName NVARCHAR2(10) NOT NULL, --이름
 birthYear NUMBER(4) NOT NULL, --출생년도
 addr NCHAR(2) NOT NULL, --지역(경기, 서울, 경남, 식으로 2글자만 입력)
 mobile1 CHAR(3) NULL, --휴대폰의 국번(010, 011, 016, 017, 018, 019 등)
 mobile2 CHAR(8) NULL, --휴대폰의 나머지 전화번호(하이픈 제외)
 height NUMBER(3) NULL, --키
 mDate DATE NULL --회원 가입일
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

select * from user_constraints --키 정보가 등록된 테이블
where owner = 'SHOP'
and table_name = 'PRODTBL'
and constraint_type='P'; --P는 기본 키, R은 외래 키, C는 NOT NULL 또는 CHECK

select * from user_constraints --키 정보가 등록된 테이블
where owner = 'SHOP'
and table_name = 'BUYTBL'
and constraint_type='R'; --P는 기본 키, R은 외래 키, C는 NOT NULL 또는 CHECK

create table buytbl --회원 구매 테이블
(idNum NUMBER(8) NOT NULL PRIMARY KEY, --순번(PK)
 userID CHAR(8) NOT NULL, --아이디(FK)
 prodName NCHAR(6) NOT NULL, --물품명
 groupName NCHAR(4) NULL, --분류
 price NUMBER(8) NULL, --단가
 amount NUMBER(3) NOT NULL --수량
);

alter table buytbl
add CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
REFERENCES usertbl(userID);

alter table buytbl
add CONSTRAINT FK_usertbl_buytbl FOREIGN KEY(userID)
REFERENCES usertbl(userID)
on delete cascade;

create table usertbl --회원 테이블
(userID CHAR(8) NOT NULL PRIMARY KEY, --사용자 아이디(PK). PK는 default가 not null
 userName NVARCHAR2(10) NOT NULL, --이름
 birthYear NUMBER(4) DEFAULT -1 NOT NULL, --출생년도
 addr NCHAR(2) DEFAULT '서울' NOT NULL, --지역(경기, 서울, 경남, 식으로 2글자만 입력)
 mobile1 CHAR(3) NULL, --휴대폰의 국번(010, 011, 016, 017, 018, 019 등)
 mobile2 CHAR(8) NULL, --휴대폰의 나머지 전화번호(하이픈 제외)
 height NUMBER(3) DEFAULT 170 NULL, --키
 mDate DATE NULL --회원 가입일
);

insert into usertbl values('LSG', '이승기', default, default, '011', '11111111', default, '2008-8-8');
insert into usertbl(userID, userName) values('KAH','김아영');
insert into usertbl(userID, userName, birthYEAR) values('HGD', '홍길동', 1980);
select * from usertbl;

insert into usertbl values('KBS', '김범수', 1979, '경남', '011', null, 173, '2012-4-4');
insert into usertbl values('KKH', '김경호', 1971, '전남', '011', '', 177, '2007-7-7');
insert into usertbl values('KKH2', '김경호2', 1971, '전남', '011', ' ', 177, '2007-7-7');

