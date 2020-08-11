/* Users */
INSERT INTO `registered_user` VALUES 
(101,'pera@gmail.com','Pera','Peric','$2a$10$xqTQfBYXw.z9j063sO4dgu313CPrDoNSGkCBjJnfa/6M3Jt9Ovq2y','ROLE_REGISTERED','pera'),
(102,'mira@gmail.com','Mira','Miric','$2a$10$AP2M4xArne7qi6UugtCMAOCV6Xa/I6IZXp8Vb7b/ubqKtEJ51NfpW','ROLE_REGISTERED','mira'),
(103,'djura@gmail.com','Djura','Djuric','$2a$10$FW8Hq4IasHIqzu5T9pS0fuJ5cwHXeTuxlm5hrWarQk/sinrFJ38Ma','ROLE_REGISTERED','djura'),

(104,'jela@gmail.com','Jelena','Cuk','$2a$10$wn30ra1KW.Rq4iRkH10.huaeCFMqhQQH5iGzrmr1/.NhlKolPgUme','ROLE_ADMIN','jela');


/*# id, alcohol, capacity, live_music, outdoor_seating, parking, price, program_for_childern, reservations, tv, wifi*/
INSERT INTO `restaurant_features` VALUES
(102,  true, 'MEDIUM', true, true, true, 'AFFORDABLE', false, true, true, true), /*Riddle Bar*/
(103,  true, 'MEDIUM', false, true, false,  'AFFORDABLE', false, true, true, true), /*Donji Grad*/
(104,  true, 'LARGE', true, true, true,  'AFFORDABLE', false, true, false, true), /*SkyLounge Belgrade*/
(105,  true, 'MEDIUM', false, true, false, 'AFFORDABLE', false, true, true, true), /*Casa Nova*/
(106,  true, 'LARGE', false, true, false,'AFFORDABLE',  false, false, false, true), /*Toro Latin Gastrobar*/
(107,  true, 'LARGE', true, true, true,  'CHEAP',  true, false, true, true), /*Gradska*/
(108,  true, 'MEDIUM', true, false, true, 'EXPENSIVE',  false, true, false, true), /*Salon 5*/
(109,  true, 'SMALL', false, false, false,'CHEAP',  false, true, true, true), /*Trattoria Pepe*/
(110,  true, 'LARGE', false, false, false, 'AFFORDABLE',  false, true, true, true), /*Ambar*/
(111,  true, 'LARGE', true, true, true,  'AFFORDABLE',  true, true, false, true), /*Zavicaj Restaurant*/
(112,  true, 'SMALL', false, true, false, 'CHEAP',  true, true, true, true), /*Red Bread*/
(113,  true, 'MEDIUM', false, true, true, 'AFFORDABLE',  true, true, false, true), /*Homa Restaurant*/
(114,  true, 'LARGE', true, true, false, 'EXPENSIVE',  false, true, false, true), /*Voulez-Vous Cafe Restaurant*/
(115,  true, 'SMALL', false, false, false, 'CHEAP',  false, true, true, true), /*Bistro Grad Hometown Food*/
(116,  true, 'LARGE', true, false, true,  'EXPENSIVE',  true, true, false, true), /*Salon 1905*/
(117,  true, 'LARGE', true, true,  true,'EXPENSIVE',  true, true, false, true), /*Frans*/
(118,  true, 'LARGE', false, true, true, 'CHEAP', true, true, true, true), /*Treminal Gastrobar*/
(119,  true, 'LARGE', true, true,  true, 'AFFORDABLE',  true, true, false, true), /*Faro*/
(120,  true, 'MEDIUM', false, true, true,  'EXPENSIVE',  true, true, true, true), /*New Reset*/
(121,  true, 'MEDIUM', true, true , true,'AFFORDABLE',  true, true, false, true); /*Magaza Gastropub*/


INSERT INTO `restaurant_features_ambience` VALUES
(102, 'CHEERFUL'),
(102, 'CREATIVE'),
(103, 'RELAXED'),
(104, 'ROMANTIC'),
(104, 'LUXURIOUS'),
(104, 'CREATIVE'),
(104, 'CHEERFUL'),
(105, 'CREATIVE'),
(105, 'RELAXED'),
(105, 'ROMANTIC'),
(106, 'RELAXED'),
(107,  'TRADITIONAL'),
(107, 'CHEERFUL'),
(108, 'CREATIVE'),
(108, 'ROMANTIC'),
(109, 'ROMANTIC'),
(109, 'RELAXED'),
(110, 'RELAXED'),
(110, 'CREATIVE'),
(111,  'TRADITIONAL'),
(111, 'CHEERFUL'),
(112, 'RELAXED'),
(113, 'ROMANTIC'),
(113, 'RELAXED'),
(114, 'CHEERFUL'),
(114, 'ROMANTIC'),
(115, 'RELAXED'),
(116, 'ROMANTIC'),
(116, 'LUXURIOUS'),
(117, 'RELAXED'),
(117, 'ROMANTIC'),
(117, 'LUXURIOUS'),
(117, 'CHEERFUL'),
(118, 'RELAXED'),
(118, 'CREATIVE'),
(119, 'LUXURIOUS'),
(119, 'ROMANTIC'),
(120, 'RELAXED'),
(120, 'TRADITIONAL'),
(121, 'CREATIVE'),
(121, 'CHEERFUL');

INSERT INTO `restaurant_features_music` VALUES
(102, 'POP'),
(102, 'JAZZ'),
(102, 'ROCK'),
(103, 'POP'),
(103, 'FOLK'),
(104, 'POP'),
(104, 'JAZZ'),
(105, 'POP'),
(105, 'JAZZ'),
(106, 'POP'),
(107,  'FOLK'),
(107, 'TAMBURITZA'),
(108, 'CLASSICAL'),
(109, 'CLASSICAL'),
(109, 'POP'),
(110, 'POP'),
(111, 'FOLK'),
(111, 'TAMBURITZA'),
(112, 'POP'),
(112, 'ROCK'),
(113, 'POP'),
(113, 'JAZZ'),
(113, 'ROCK'),
(114, 'POP'),
(114, 'JAZZ'),
(114, 'ROCK'),
(115, 'JAZZ'),
(115, 'ROCK'),
(116, 'CLASSICAL'),
(116, 'JAZZ'),
(117, 'CLASSICAL'),
(117, 'POP'),
(117, 'TAMBURITZA'),
(118, 'JAZZ'),
(118, 'ROCK'),
(119, 'POP'),
(120,  'FOLK'),
(120, 'TAMBURITZA'),
(121, 'POP'),
(121, 'JAZZ'),
(121, 'ROCK');

INSERT INTO `restaurant`  VALUES
(102, null ,2, false, false, '','Riddle Bar' ,'','','', null, null, 102, null),
(103, null ,3, false, false, '', 'Donji Grad' ,'','','', null, null, 103, null),
(104, null ,4, false, false, '','SkyLounge Belgrade' ,'','','', null, null, 104, null),
(105, null ,5, false, false, '','Casa Nova' ,'','','', null, null, 105, null),
(106, '2020-08-02' ,2.5, false, false, '','Toro Latin Gastrobar' ,'','','', null, null, 106, null),
(107, '2020-08-02' ,2, false, false, '','Gradska' ,'','','', null, null, 107, null),
(108, null ,3, false, false, '','Salon 5' ,'','','', null, null, 108, null),
(109, null ,4, false, false, '','Trattoria Pepe' ,'','','', null, null, 109, null),
(110, null ,5, false, false, '','Ambar' ,'','','', null, null, 110, null),
(111, null ,0, false, false, '','Zavicaj Restaurant' ,'','','', null, null, 111, null),
(112, null ,0, false, false, '','Red Bread' ,'','','', null, null, 112, null),
(113, null ,0, false, false, '','Homa Restaurant' ,'','','', null, null, 113, null),
(114, null ,0, false, false, '','Voulez-Vous Cafe Restaurant' ,'','','', null, null, 114, null),
(115, null ,0, false, false, '','Bistro Grad Hometown Food' ,'','','', null, null, 115, null),
(116, null ,0, false, false, '','Salon 1905' ,'','','', null, null, 116, null),
(117, null ,0, false, false, '','Frans' ,'','','', null, null, 117, null),
(118, null ,0, false, false, '','Terminal GastroBar' ,'','','', null, null, 118, null),
(119, null ,0, false, false, '','Faro' ,'','','', null, null, 119, null),
(120, null ,0, false, false, '','New Reset' ,'','','', null, null, 120, null),
(121, null ,0, false, false, '','Magaza Gastropub' ,'','','', null, null, 121, null);



INSERT INTO `review` VALUES
(102, '2020-08-02 09:03:42.433000', 2, 102, 101),
(107, '2020-08-02 09:03:42.433000', 2, 107, 101),
(115, '2020-08-02 09:03:42.433000', 2, 106, 101),
(112, '2020-08-02 09:03:42.433000', 1, 106, 103),
(113, '2020-08-02 09:03:42.433000', 1, 102, 103),
(114, '2020-08-02 09:03:42.433000', 1, 107, 103),

(103, '2020-08-02 09:03:42.433000', 3, 103, 101),
(104, '2020-08-02 09:03:42.433000', 4, 104, 101),
(105, '2020-08-02 09:03:42.433000', 5, 105, 101),
(108, '2020-08-02 09:03:42.433000', 3, 108, 101),
(109, '2020-08-02 09:03:42.433000', 4, 109, 101),
(110, '2020-08-02 09:03:42.433000', 5, 110, 101),
(111, '2020-08-02 09:03:42.433000', 4, 106, 102);

INSERT INTO `restaurant_restaurant_reviews` VALUES
(102, 102),
(103, 103),
(104, 104),
(105, 105),
(106, 115),
(107, 107),
(108, 108),
(109, 109),
(110, 110),
(106, 111),
(106, 112),
(102, 113),
(107, 114);

INSERT INTO `registered_user_recommended_restaurants` VALUES
(101, 102),
(101, 103),
(101, 104),
(101, 105),
(101, 107),
(101, 108),
(101, 109),
(101, 106),
(101, 110),
(103, 106),
(103, 103),
(103, 104),
(103, 102),
(103, 107),
(103, 108),
(102, 106);

INSERT INTO `api_account` VALUES
(101, 140, '2020-07-28', 'tripadvisor1.p.rapidapi.com' , '7709d01938msh9d9f3cac732d6afp1a9ad8jsn1810f0a4f623', false)