
select * from donor;

alter table client_side rename column las_tname to last_name ;

select * from medicalperson;
select book_date+90 from booking where aadharcard=
commit;
desc medicalperson
select * from blood_transaction;
select * from blooddonor;
select * from client_side;
select * from booking;
select * from blood_details;
select * from blood_bank_admin;

--drop table donor_details cascade constraints;


create table donor_details(

first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
aadharcard number(20)  primary key,
phone varchar2(20) not null,
donor_date date not null,
blood_type varchar2(10) not null);


-----------------------
create table  medicalperson (mdpreson_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
email varchar2(100) unique ,
phone varchar2(20) not null,
age number (5) not null,
blood_type varchar2(5));
-------------------------
create table client_side (client_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
email varchar2(100) unique ,
phone varchar2(20) not null,
age number (5) not null,
blood_type varchar2(5));
---------------------------

--------------------------------
/*create table blood_details(blood_group varchar2(50) primary key,
accept_blood varchar2(50) not null ,
received varchar2(50));*/
---------------------------
/*create table blood_transaction (transact_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
mdpreson_id number (11)not null,
date_out date not null, 
quantity int not null,
blood_type varchar2(5) not null,
blood_id number(11) not null,
 foreign key (mdpreson_id) references medicalperson(mdpreson_id),
 foreign key (blood_id) references blooddonor(blood_id));*/
---------------------------
create table  blooddonor (blood_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
donor_id  number (11)not null,
date_donated date not null,
quantity int not null ,
foreign key (donor_id) references donor(donor_id) );

-------------------
select * from donor;
desc donor
insert into donor (first_name,last_name,address,email,phone,age,blood_type,password)values('munis','waran','chennai','munisram6@gmail.com','9894688836',24,'O-','050476ram');
--commit


-------------------------
create table booking (book_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
aadharcard number(20) not null,
 address varchar2(100) not null,
  book_date date not null ,
  blood_type varchar2(10) not null,
  blood_collect_choice varchar2(100) not null,
  foreign key (aadharcard) references donor_details(aadharcard) );
 ----------------------------

 select * from donor_details;
 
 select * from booking;
 desc donor_details
 select * from admin;
 select * from blood_details;
 
--drop table  blood_bank_admin cascade constraints;

create table blood_details (blood_id number(12)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
blood_type varchar2(20) not null ,
aadharcard number(20) not null ,
unit number(10) not null,
price number(11)not null);
 
desc blood_details
select * from blood_details;

select * from blood_stack;
select * from booking;
select book_date+90 from booking where aadharcard=637482870912;


create table blood_stack(stack_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
blood_type varchar2(20)unique ,
quantity number(11) not null,
unit_price number(20) not null);
/
update blood_stack set blood_stack.quantity=100  where blood_stack.blood_type='a-';
/
update blood_stack set quantity=30 where blood_type='bombay';
select * from blood_stack;
--drop table blood_stack cascade constraints;

--select MONTHS_BETWEEN(current_timestamp,'17-09-2021')*30
--from dual;


create table seeker_details(id number(12)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
first_name varchar2(50)not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
phone_number number(20) not null unique,
password varchar2(100) not null,
patient_id number(20) not null ,
hospital_name varchar2(100) not null,
blood_type varchar2(20) not null );


drop table seeker_details cascade constraints;
select * from seeker_details;
desc seeker_details

insert into seeker_details(first_name,last_name,address,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE)values('munis','waran','sdfdfds',01987654321,'sarmila',12345,'goverment','o-');


create table request_details (request_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
hospital_name varchar2(100) not null,
blood_type varchar2(50) not null,
unit number(11) not null,
blood_collector_name varchar2(50) not null,
phone_number number(20) not null,
aadharcard_number number(20) not null  ,
request_date date not null,
status varchar2 (100) default 'pending');

select * from donor_details;
/
--drop  table request_details cascade constraints;

desc request_details
commit;

create table billing (bill_id number(20) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
blood_type varchar2(20) not null,
seeker_id number(20)not null,
quantity number(11) not null,
price number(20) not null,
billing_Date Date default SYSDATE);

--drop table billing cascade constraints;

commit;



desc billing

select * from admin ;






create table admin (admin_id number(12) GENERATED ALWAYS AS IDENTITY START WITH 100 primary key,
email varchar2(50) unique,
password varchar2(50) not null,
wallet number(20)  default 0 not null);


insert into admin (email,password)values('munisram6@gmail.com','050476ram',);

update  admin set wallet=2000 where email='munisram6@gmail.com';
select * from admin;
drop table seeker_details cascade CONSTRAINT ;

select* from blood_stack;
insert into blood_stack v;
select * from blood_stack;
desc blood_stack
select * from admin;
select * from seeker_details;
--desc seeker_details;
select * from donor_details;
select * from request_details where status='pending' order by request_id desc ;
select * from billing;
desc billing;
desc seeker_details
select * from booking;
desc booking;
select * from billing;
desc request_details
---------------------------
/
select * from admin;

desc donor_details;
select * from blood_details;
select * from donor_details;
select * from seeker_details;
commit;

inner join booking on donor_details.adharcard=booking.adharcard
where BLOOD_COLLECT_CHOICE='home';
select * from billing where '1-1-2022'<=billing_date;
select * from blood_details;
select * from booking;
desc blood_stack;
--truncate table booking;
commit;
select * from  blood_stack;
select * from  admin;
desc seeker_details;

select book_date+90 from booking where adharcard=123456789012;

select donor_date from donor_details where adharcard=98378837938;
select * from booking where to_char(book_date,'dd-mm-yyyy')between '27-12-2019' and '27-12-2021';

select QUANTITY from blood_stack where blood_type='o-';
--truncate table seeker_details;
select * from request_details;

select status from  request_details where status='panding' and aadharcard_number=987654328813;

/
select status from  request_details where status='approved' and aadharcard_number=987654328813;
/
--update request_details set status='pending' where aadharcard_number=987654328856;
/
desc seeker_details
update  admin set wallet=10000 where password ='050476ram';
commit;
select * from request_details;
commit;

update   request_details set status='pending' where aadharcard_number=984305047632;


select * from blood_details;
delete  from booking where blood_collect_choice='home';
select * from billing where TO_CHAR(billing_date,'YYYY-MM-DD') between TO_CHAR(SYSDATE,'YYYY-MM-DD') AND '26-12-21';

select  from  billing where billing_date='';
commit;
desc admin;

select * from billing order by bill_id desc;
select * from billing where sysdate <=billing_date order by bill_id desc;