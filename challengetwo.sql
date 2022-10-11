drop schema challengetwo;
create schema challengetwo;
use challengetwo;

CREATE TABLE Persons (
	id bigint UNIQUE PRIMARY KEY,
	person_name varchar(225) ,
    address varchar(225) ,
    postCode varchar(225) ,
    age varchar(225) ,
    job varchar(225) ,
    email varchar(225) ,
    phoneNo varchar(225) 
);

CREATE TABLE Accounts (
	id bigint UNIQUE PRIMARY KEY,
	account_type varchar(225) ,
    account_number varchar(225) ,
    account_name varchar(225) ,
    balance varchar(225) ,
    date DATE 
);

