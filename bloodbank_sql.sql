create database bloodbank;
SET SQL_SAFE_UPDATES = 0;

use bloodbank;

create table registration (name varchar(40), mail varchar(40), dob varchar(40), addr varchar(100), bloodType varchar(10), gender varchar(30), passw varchar(30));
select * from registration;

create table drive (loc varchar(30), datee varchar(30));
select * from drive;

create table availability (loc varchar(30), btype varchar(30), noOfPackets varchar(20));

create table demand (location varchar(55), bloodtype varchar(20), packets int);
select * from demand;

create table feedback (mail varchar(20), portal_service varchar(20),stock_availability varchar(20),appointment_availability varchar(20),
rating varchar(20),suggestion varchar(200));
drop table feedback;
select * from feedback;

insert into availability (loc, btype, noOfPackets) values
('Noida','B+','5'),
('Noida','B-','5'),
('Noida','AB+','5'),
('Noida','AB-','5'),
('Noida','O+','5'),
('Noida','O-','5'),
('Noida','A+','5'),
('Noida','A-','5'),
('Delhi','AB+','5'),
('Delhi','AB-','5'),
('Delhi','B+','5'),
('Delhi','B-','5'),
('Delhi','A+','5'),
('Delhi','A-','5'),
('Delhi','O-','5'),
('Delhi','O+','5'),
('Gurugram','AB+','5'),
('Gurugram','AB-','5'),
('Gurugram','B+','5'),
('Gurugram','B-','5'),
('Gurugram','A+','5'),
('Gurugram','A-','5'),
('Gurugram','O+','5'),
('Gurugram','O-','5'),
('Ghaziabad','AB+','5'),
('Ghaziabad','AB-','5'),
('Ghaziabad','A+','5'),
('Ghaziabad','A-','5'),
('Ghaziabad','B+','5'),
('Ghaziabad','B-','5'),
('Ghaziabad','O+','5'),
('Ghaziabad','O-','5');

Select * from availability;
select noOfPackets from availability where loc = 'Noida' and btype = 'B+';
UPDATE availability SET noOfPackets = 6 WHERE loc = 'Noida'  and btype = 'B+';

insert into drive (loc , datee) values ('Noida','Jan 29, 2024');

ALTER TABLE registration
ADD loginType varchar(30);

DELETE FROM drive WHERE datee = 'Jan 27, 2024' and loc = 'Noida';

Update registration set loginType = 'admin' where mail = 'kartik@12345'

delete from registration where name = 'pankaj' and mail = 'pankaj@123'

update registration set name = 'kartik kumar',  dob = '5 april 2024', addr = 'noida',  bloodtype = 'O+',  gender = 'male' where mail = 'kartik@12345'

select * from registration where logintype = 'reciever'