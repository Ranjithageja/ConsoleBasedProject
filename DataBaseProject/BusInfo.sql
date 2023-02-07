create database BusInfo;
create table BusInfo_Table
(
Starting_point varchar(10) not null,
Ending_point varchar(10) not null,
Driver_Name varchar(20) not null,
Driver_No long not null,
Bus_No varchar(10) ,
Bus_Type varchar(10),
primary key(Bus_No)
);
insert into BusInfo_Table values('chennai','vandavasi','sindhu',1234567890,'tn23','Ac');
insert into BusInfo_Table values('pondy','bangalore','swathi',1245879891,'tn24','non_Ac');
insert into BusInfo_Table values('trichy','pondy','nisha',1256894588,'tn25','Ac');
select*from BusInfo_Table;
show tables;
desc BusInfo_Table;