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



INSERT INTO `restaurant` VALUES 
(101,'LUXURIOUS','MEDIUM','Restoran alla Lanterna smešten je u najživopisniji ambijent jedne od najstarijih gradskih ulica, Dunavskoj ulici.',_binary '','/images/Restoran alla Lanterna.jpg','ITALIAN','CLASSICAL','Restoran alla Lanterna','EXPENSIVE',_binary '\0',0,_binary '',101),
(102,'RELAXED','SMALL','Italijanski fast food restoran Tratoria Vapene – nesvakidašnje mesto za prave gurmane. Tratorije su u Italiji mesta gde možete ručati, popiti kafu ili piće, ali su mnogo manje i prisnije od klasičnih restorana. ',_binary '\0','/images/Trattoria Vapene.jpg','ITALIAN','POP','Trattoria Vapene','AFFORDABLE',_binary '\0',0,_binary '\0',102),
(103,'MODERN','LARGE','Novorenovirani italijanski restoran u N. Sadu, na Limanu 2. Predivan ambijent u italijanskom stilu i duhu. ',_binary '','/images/Trattoria Offei da Rino.jpg','ITALIAN','POP','Trattoria Offei da Rino','AFFORDABLE',_binary '\0',0,_binary '',103),
('104', 'RELAXED', 'MEDIUM', 'Špajz je mesto u rustičnom ruhu, tople prijateljske atmosfere, podseća na vojvođanske salaše.', true, '/images/Spajz salasa 137.jpg', 'LOCAL', 'FOLK', 'Spajz salasa 137', 'AFFORDABLE', true, false, true, '104'),
('105', 'PEACEFUL', 'MEDIUM', 'Kvalitetna domaća kuhinja i specijaliteti koji rasplamsavaju emociju i sećanje na jela koja su spremale Vaše bake i majke. ', true, '/images/Caffe Restaurant Pianino.jpg', 'LOCAL', 'FOLK', 'Caffe Restaurant Pianino', 'AFFORDABLE', true, false, true, '105'),
('106', 'TRADITIONAL', 'LARGE', 'Viteška ponuda domaće hrane obogaćena je našim DOMAĆIM CAMELOT PIVOM (svetlo, crveno, tamno) iz naše pivare! ', true, '/images/Camelot.jpg', 'LOCAL', 'FOLK', 'Camelot', 'AFFORDABLE', true, false, true, '106'),
('107', 'TRADITIONAL', 'LARGE', 'Ono po čemu se posebno izdvaja ovo prijatno mesto su ćevapi koji među najboljim u gradu. Restoran “Pod orahom” je pravo mesto za gurmane.', true, '/images/Pod Orahom.jpg', 'LOCAL', 'CLASSICAL', 'Pod Orahom', 'EXPENSIVE', true, false, true, '107'),
('108', 'RELAXED', 'MEDIUM', 'Moderan i diskretno dekorisan enterijer će Vas opustiti i obuzeti Vaša čula dok će Vas cene vrlo prijatno iznenaditi.', false, '/images/Kineski restoran 88.jpg', 'CHINESE', 'POP', 'Kineski restoran 88', 'CHEAP', false, false, false, '108'),
('109', 'MODERN', 'MEDIUM', 'U ponudi imamo veliki izbor izvornih kineskih jela, a neka su po prvi put u ponudi u gradu.', true, '/images/Two Chopsticks.jpg', 'CHINESE', 'POP', 'Two Chopsticks', 'EXPENSIVE', false, false, false, '109'),
('110', 'RELAXED', 'SMALL', 'Jos iz studenskog grada,od davne 1984 tu smo za vas i dan danas da uživate u originalnom ukusu index sendviča, i drugim ukusnim ponudama', false, '/images/Index Vanessa.jpg', 'FAST_FOOD', 'POP', 'Index Vanessa', 'CHEAP', false, false, false, '110');
