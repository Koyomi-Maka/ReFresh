
drop table fundreply
drop table funding
drop table investor
drop table business

create table investor
(
 inum number primary key,
 iname varchar2(15) not null,
 idmail varchar2(30) unique,
 ipass varchar2(20) not null,
 iphone varchar2(15),
 ipay varchar2(30) not null
 ibank varchar2(30) not null
)

create table business
(
 bnum number primary key,
 bname varchar2(30) unique,
 bpass varchar2(20) not null,
 ceoname varchar2(15) not null,
 btel varchar2(15),
 baddr varchar2(30),
 idbnum number not null,
 bacc varchar2(30) not null
 bbank varchar2(30) not null
)

create table funding
(
 pnum number primary key,
 pname varchar2(30) not null,
 pu varchar2(20) not null,
 category varchar2(20) not null,
 bname varchar2(30) references business (bname),
 ceoname varchar2(30),
 fdate date,
 deadline date,
 fcontent varchar2(2000),
 gmoney number not null,
 cmoney number,
 state varchar2(15)
)

create table fundreply
(
 rnum number primary key,
 pnum number references funding (pnum),
 rname varchar2(15),
 rcontent varchar2(2000),
 rdate date
)
