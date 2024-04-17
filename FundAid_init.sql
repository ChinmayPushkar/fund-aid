create database fundaid;
use fundaid;
 
CREATE TABLE LISTING (ListingID int NOT NULL AUTO_INCREMENT PRIMARY KEY, ListingName varchar(100), Description varchar(300), AmountRequired float, AmountReceived float DEFAULT 0,
 isApproved BOOLEAN DEFAULT 0, isActive BOOLEAN DEFAULT 0, AccountDetails varchar(50), StartDate DATE, EndDate DATE NOT NULL);

create table Admin (Admin_ID varchar(20) primary key, Password varchar(30));
insert into admin values ("Admin1","adpass1");
insert into admin values ("Admin2","adpass2");
insert into admin values ("Admin3","adpass3");
insert into admin values ("Admin4","adpass4");
insert into admin values ("Admin5","adpass5");
insert into admin values ("Admin6","adpass6");
insert into admin values ("Admin7","adpass7");
insert into admin values ("Admin8","adpass8");
insert into admin values ("Chinmay","adpass");

create table user (Email varchar(100) primary key, Name varchar(50), Password varchar(20));

create table Creates(Email varchar(100), ListingID int primary key,foreign key (Email) references user(Email), foreign key (ListingID) references listing(LIstingID) ON DELETE CASCADE);

create table Donation(TransactionID int AUTO_INCREMENT PRIMARY KEY, Amount float)AUTO_INCREMENT = 100;

create table Donates(Email varchar(100) , TransactionID int AUTO_INCREMENT primary key, foreign key (Email) references user(Email), 
foreign key (TransactionID)references donation(TransactionID))AUTO_INCREMENT = 100;

create table Receives (ListingID int , TransactionID int AUTO_INCREMENT primary key, foreign key (ListingID) references Listing(ListingID) ON DELETE CASCADE,
 foreign key (TransactionID)references donation(TransactionID))AUTO_INCREMENT = 100;


create table Category (CategoryName varchar(100) primary key,Description varchar(400), TotalListings int default 0, TotalAmount float default 0);
insert into category (CategoryName, Description) values ("Health & Medical Supplies", "Donations for Health & Medical Supplies");
insert into category (CategoryName, Description) values ("Food & Nutrition", "Donations for Food & Nutrition");
insert into category (CategoryName, Description) values ("Shelter & Housing", "Donations for Shelter & Housing");
insert into category (CategoryName, Description) values ("Marriage", "Donations for Marriage");
insert into category (CategoryName, Description) values ("Animal Welfare", "Donations for Animal Welfare");
insert into category (CategoryName, Description) values ("Disaster Relief", "Donations for Disaster Relief");
insert into category (CategoryName, Description) values ("Arts & Culture", "Donations for Arts & Culture");
insert into category (CategoryName, Description) values ("Technology & Innovation", "Donations for Technology & Innovation");
insert into category (CategoryName, Description) values ("Enviromental Conservation", "Enviromental Conservation");

create table OfType (ListingID int primary key, CategoryName varchar(100), foreign key (CategoryName) references category(CategoryName),
foreign key (ListingID) references listing(ListingID) ON DELETE CASCADE);


create table Managedby (Admin_ID varchar(20) primary key, CategoryName varchar(100), foreign key (Admin_ID) references Admin(Admin_ID),
foreign key (CategoryName) references category(CategoryName));

insert into ManagedBy values ("Admin1","Health & Medical Supplies");
insert into ManagedBy values ("Admin2","Food & Nutrition");
insert into ManagedBy values ("Admin3","Shelter & Housing");
insert into ManagedBy values ("Admin4","Marriage");
insert into ManagedBy values ("Admin5","Animal Welfare");
insert into ManagedBy values ("Admin6","Disaster Relief");
insert into ManagedBy values ("Admin7","Arts & Culture");
insert into ManagedBy values ("Admin8","Technology & Innovation");
insert into ManagedBy values ("Chinmay","Enviromental Conservation");

create table Approvedby (Admin_ID varchar(20), ListingID int primary key, foreign key (Admin_ID) references Admin(Admin_ID),
foreign key (ListingID) references listing(ListingID) ON DELETE CASCADE);

