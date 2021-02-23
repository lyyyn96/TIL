CREATE TABLE member (
    memid     VARCHAR2(20) NOT NULL,
    memname   VARCHAR2(20) NOT NULL,
    memdate   DATE,
    phone     VARCHAR2(15),
    point     INTEGER
);

ALTER TABLE member ADD CONSTRAINT member_pk PRIMARY KEY ( memid );
