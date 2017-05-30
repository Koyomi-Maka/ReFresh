
drop table fundreply
drop table funding
drop table investor
drop table business

create table investor
(
 inum number primary key,
 idmail varchar2(30) unique,
 ipass varchar2(20) not null,
 iname varchar2(15) not null,
 iphone varchar2(15),
 ibank varchar2(30) not null,
 ipay varchar2(30) not null
)

create table business
(
 bnum number primary key,
 bname varchar2(30) unique,
 bpass varchar2(20) not null,
 ceoname varchar2(15) not null,
 idbnum number not null,
 btel varchar2(15),
 baddr varchar2(30),
 bacc varchar2(30) not null
)

create table funding
(
 pnum number primary key,
 pname varchar2(30) not null,
 pu varchar2(20) not null,
 state varchar2(15),
 category varchar2(20) not null,
 bname varchar2(30) references business (bname),
 ceoname varchar2(30),
 gmoney number not null,
 cmoney number,
 rate number,
 fcontent varchar2(2000),
 fdate date,
 deadline date
)

create table reply
(
 rnum number primary key,
 pnum number references funding (pnum),
 rname varchar2(15),
 rcontent varchar2(2000),
 rdate date
)

drop sequence inves_seq;
create sequence inves_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
drop sequence busi_seq;
create sequence busi_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
drop sequence fund_seq;
create sequence fund_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
drop sequence reply_seq;
create sequence reply_seq
	start with 1
	increment by 1
	nocycle
	nocache;
