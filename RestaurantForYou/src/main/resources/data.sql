/* Users */
INSERT INTO `registered_user` VALUES 
(101,'pera@gmail.com','Pera','Preic','$2a$10$xqTQfBYXw.z9j063sO4dgu313CPrDoNSGkCBjJnfa/6M3Jt9Ovq2y','ROLE_REGISTERED','pera'),
(102,'jela@gmail.com','Jelena','Cuk','$2a$10$wn30ra1KW.Rq4iRkH10.huaeCFMqhQQH5iGzrmr1/.NhlKolPgUme','ROLE_ADMIN','jela');



INSERT INTO `location` VALUES
(101,100,100,'27','Dunavska'),
(102,100,100,'4','Fruskogorska'),
(103,100,100,'2','Narodnog Fronta'),
('104', '100', '100', '18', 'Trg Republike'),
('105', '100', '100', '24', 'Bulevar Jase tomica'),
('106', '100', '100', '9', 'Sremska'),
('107', '100', '100', '40', 'Bulevar kralja Petra I '),
('108', '100', '100', '133', 'Bulevar oslobodjenja'),
('109', '100', '100', '27', 'Vase Stajica'),
('110', '100', '100', '5', 'Bulevar Mihajla Pupina');

INSERT INTO `restaurant_features` VALUES
(101,  true, true, true, false, false, true, false, true),
(102,  true, false, true, false, false, true, true, true),
(103,  true, true, true, false, false, true, false, true),
(104,  true, true, true, true, true, true, true, true),
(105,  true, false, false, true, true, true, true, true),
(106,  true, true, true, true, true, true, false, true),
(107,  true, true, true, true, true, true, false, true),
(108,  false, false, false, false, false, true, true, true),
(109,  true, false, true, false, false, true, false, true),
(110,  false, false, false, false, false, false, false, false);



INSERT INTO `restaurant` VALUES 
(101,'LUXURIOUS','MEDIUM','Restoran alla Lanterna smešten je u najživopisniji ambijent jedne od najstarijih gradskih ulica, Dunavskoj ulici.','/images/Restoran alla Lanterna.jpg','ITALIAN','CLASSICAL','Restoran alla Lanterna','EXPENSIVE', 0, 101,101),
(102,'RELAXED','SMALL','Italijanski fast food restoran Tratoria Vapene – nesvakidašnje mesto za prave gurmane. Tratorije su u Italiji mesta gde možete ručati, popiti kafu ili piće, ali su mnogo manje i prisnije od klasičnih restorana. ','/images/Trattoria Vapene.jpg','ITALIAN','POP','Trattoria Vapene','AFFORDABLE', 0, 102, 102),
(103,'ROMANTIC','LARGE','Novorenovirani italijanski restoran u N. Sadu, na Limanu 2. Predivan ambijent u italijanskom stilu i duhu. ','/images/Trattoria Offei da Rino.jpg','ITALIAN','POP','Trattoria Offei da Rino','AFFORDABLE',0, 103,103),
('104', 'RELAXED', 'MEDIUM', 'Špajz je mesto u rustičnom ruhu, tople prijateljske atmosfere, podseća na vojvođanske salaše.', '/images/Spajz salasa 137.jpg', 'LOCAL', 'FOLK', 'Spajz salasa 137', 'AFFORDABLE',0, 104, '104'),
('105', 'RELAXED', 'MEDIUM', 'Kvalitetna domaća kuhinja i specijaliteti koji rasplamsavaju emociju i sećanje na jela koja su spremale Vaše bake i majke. ', '/images/Caffe Restaurant Pianino.jpg', 'LOCAL', 'FOLK', 'Caffe Restaurant Pianino', 'AFFORDABLE',0, 105, '105'),
('106', 'TRADITIONAL', 'LARGE', 'Viteška ponuda domaće hrane obogaćena je našim DOMAĆIM CAMELOT PIVOM (svetlo, crveno, tamno) iz naše pivare! ', '/images/Camelot.jpg', 'LOCAL', 'FOLK', 'Camelot', 'AFFORDABLE',0, 106, '106'),
('107', 'TRADITIONAL', 'LARGE', 'Ono po čemu se posebno izdvaja ovo prijatno mesto su ćevapi koji među najboljim u gradu. Restoran “Pod orahom” je pravo mesto za gurmane.', '/images/Pod Orahom.jpg', 'LOCAL', 'CLASSICAL', 'Pod Orahom', 'EXPENSIVE',0, 107, '107'),
('108', 'RELAXED', 'MEDIUM', 'Moderan i diskretno dekorisan enterijer će Vas opustiti i obuzeti Vaša čula dok će Vas cene vrlo prijatno iznenaditi.', '/images/Kineski restoran 88.jpg', 'CHINESE', 'POP', 'Kineski restoran 88', 'CHEAP',0, 108, '108'),
('109', 'CREATIVE', 'MEDIUM', 'U ponudi imamo veliki izbor izvornih kineskih jela, a neka su po prvi put u ponudi u gradu.', '/images/Two Chopsticks.jpg', 'CHINESE', 'POP', 'Two Chopsticks', 'EXPENSIVE',0, 109, '109'),
('110', 'RELAXED', 'SMALL', 'Jos iz studenskog grada,od davne 1984 tu smo za vas i dan danas da uživate u originalnom ukusu index sendviča, i drugim ukusnim ponudama', '/images/Index Vanessa.jpg', 'FAST_FOOD', 'POP', 'Index Vanessa', 'CHEAP',0, 110, '110');

INSERT INTO `review` VALUES
(101, '2020-07-02 09:03:42.433000', 1, 101, 101),
(102, '2020-07-02 09:03:42.433000', 2, 102, 101),
(103, '2020-07-02 09:03:42.433000', 3, 103, 101),
(104, '2020-07-02 09:03:42.433000', 4, 104, 101),
(105, '2020-07-02 09:03:42.433000', 5, 105, 101),
(106, '2020-07-02 09:03:42.433000', 1, 106, 101),
(107, '2020-07-02 09:03:42.433000', 2, 107, 101),
(108, '2020-07-02 09:03:42.433000', 3, 108, 101),
(109, '2020-07-02 09:03:42.433000', 4, 109, 101),
(110, '2020-07-02 09:03:42.433000', 5, 110, 101);

INSERT INTO `restaurant_restaurant_reviews` VALUES
(101, 101),
(102, 102),
(103, 103),
(104, 104),
(105, 105),
(106,106),
(107,107),
(108,108),
(109,109),
(110,110);

INSERT INTO `registered_user_recommended_restaurants` VALUES
(101, 101),
(101, 102),
(101, 103),
(101, 104),
(101, 105),
(101, 106),
(101, 107),
(101, 108);
