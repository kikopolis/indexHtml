create table Person (
    agreedToTerms boolean not null,
    id bigint not null,
    name varchar(255),
    token varchar(255),
    primary key (id)
);

create table Sector (
    id bigint not null,
    name varchar(255),
    primary key (id)
);

create table person_sector (
    person_id bigint not null,
    sector_id bigint not null,
    primary key (person_id, sector_id)
);

alter table person_sector
    add constraint FKisrlunjs97xuvxdo3seem80df
    foreign key (sector_id)
    references Sector;

alter table person_sector
    add constraint FK4vifbhcwxpo9jr2rcs0lldipu
    foreign key (person_id)
    references Person;

insert into sector (id, name) values(1, 'Manufacturing');
insert into sector (id, name) values(19, 'Construction materials');
insert into sector (id, name) values(18, 'Electronics and Optics');
insert into sector (id, name) values(6, 'Food and Beverage');
insert into sector (id, name) values(342, 'Bakery & confectionery products');
insert into sector (id, name) values(43, 'Beverages');
insert into sector (id, name) values(42, 'Fish & fish products');
insert into sector (id, name) values(40, 'Meat & meat products');
insert into sector (id, name) values(39, 'Milk & dairy products');
insert into sector (id, name) values(437, 'Other');
insert into sector (id, name) values(378, 'Sweets & snack food');
insert into sector (id, name) values(13, 'Furniture');
insert into sector (id, name) values(389, 'Bathroom/sauna');
insert into sector (id, name) values(385, 'Bedroom');
insert into sector (id, name) values(390, 'Children’s room');
insert into sector (id, name) values(98, 'Kitchen');
insert into sector (id, name) values(101, 'Living room');
insert into sector (id, name) values(392, 'Office');
insert into sector (id, name) values(394, 'Other (Furniture)');
insert into sector (id, name) values(341, 'Outdoor');
insert into sector (id, name) values(99, 'Project furniture');
insert into sector (id, name) values(12, 'Machinery');
insert into sector (id, name) values(94, 'Machinery components');
insert into sector (id, name) values(91, 'Machinery equipment/tools');
insert into sector (id, name) values(224, 'Manufacture of machinery');
insert into sector (id, name) values(97, 'Maritime');
insert into sector (id, name) values(271, 'Aluminium and steel workboats');
insert into sector (id, name) values(269, 'Boat/Yacht building');
insert into sector (id, name) values(230, 'Ship repair and conversion');
insert into sector (id, name) values(93, 'Metal structures');
insert into sector (id, name) values(508, 'Other');
insert into sector (id, name) values(227, 'Repair and maintenance service');
insert into sector (id, name) values(11, 'Metalworking');
insert into sector (id, name) values(67, 'Construction of metal structures');
insert into sector (id, name) values(263, 'Houses and buildings');
insert into sector (id, name) values(267, 'Metal products');
insert into sector (id, name) values(542, 'Metal works');
insert into sector (id, name) values(75, 'CNC-machining');
insert into sector (id, name) values(62, 'Forgings, Fasteners');
insert into sector (id, name) values(69, 'Gas, Plasma, Laser cutting');
insert into sector (id, name) values(66, 'MIG, TIG, Aluminum welding');
insert into sector (id, name) values(9, 'Plastic and Rubber');
insert into sector (id, name) values(54, 'Packaging');
insert into sector (id, name) values(556, 'Plastic goods');
insert into sector (id, name) values(559, 'Plastic processing technology');
insert into sector (id, name) values(55, 'Blowing');
insert into sector (id, name) values(57, 'Moulding');
insert into sector (id, name) values(53, 'Plastics welding and processing');
insert into sector (id, name) values(560, 'Plastic profiles');
insert into sector (id, name) values(5, 'Printing');
insert into sector (id, name) values(148, 'Advertising');
insert into sector (id, name) values(150, 'Book/Periodicals printing');
insert into sector (id, name) values(145, 'Labelling and packaging printing');
insert into sector (id, name) values(7, 'Textile and Clothing');
insert into sector (id, name) values(44, 'Clothing');
insert into sector (id, name) values(45, 'Textile');
insert into sector (id, name) values(8, 'Wood');
insert into sector (id, name) values(337, 'Other (Wood)');
insert into sector (id, name) values(51, 'Wooden building materials');
insert into sector (id, name) values(47, 'Wooden houses');
insert into sector (id, name) values(3, 'Other');
insert into sector (id, name) values(37, 'Creative industries');
insert into sector (id, name) values(29, 'Energy technology');
insert into sector (id, name) values(33, 'Environment');
insert into sector (id, name) values(2, 'Service');
insert into sector (id, name) values(25, 'Business services');
insert into sector (id, name) values(35, 'Engineering');
insert into sector (id, name) values(28, 'Information Technology and Telecommunications');
insert into sector (id, name) values(581, 'Data processing, Web portals, E-marketing');
insert into sector (id, name) values(576, 'Programming, Consultancy');
insert into sector (id, name) values(121, 'Software, Hardware');
insert into sector (id, name) values(122, 'Telecommunications');
insert into sector (id, name) values(22, 'Tourism');
insert into sector (id, name) values(141, 'Translation services');
insert into sector (id, name) values(21, 'Transport and Logistics');
insert into sector (id, name) values(111, 'Air');
insert into sector (id, name) values(114, 'Rail');
insert into sector (id, name) values(112, 'Road');
insert into sector (id, name) values(113, 'Water');
