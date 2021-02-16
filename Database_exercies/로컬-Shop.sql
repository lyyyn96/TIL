select membername, memberaddress from membertbl;
select * from membertbl where membername = '지운이';

create table "my testTBL" (id NUMBER(3));
drop table "my testTBL";

select * from membertbl;

insert into membertbl values('Chr', '최혜린', '경기 성남시 분당구');

insert into membertbl(MEMBERID, MEMBERNAME, MEMBERADDRESS)
values('Kim', '김영숙', '서울 왕십리');

insert into membertbl(MEMBERNAME, MEMBERADDRESS, MEMBERID)
values('이영숙', '서울 구로구', 'Lee');

select * from producttbl;

--커밋 이후에는 롤백이 불가하므로 신중한 커밋이 필요
update producttbl
set amount=100;

update producttbl
set amount=100
where productname = '컴퓨터';

delete from PRODUCTTBL
where productname = '컴퓨터';

delete from PRODUCTTBL;





