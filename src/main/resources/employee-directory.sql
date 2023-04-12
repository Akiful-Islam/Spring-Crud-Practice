CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(0,'Rahu0','Gringo100','rahu100@dotcom.com'),
(1,'Rahu1','Gringo99','rahu99@dotcom.com'),
(2,'Rahu2','Gringo98','rahu98@dotcom.com'),
(3,'Rahu3','Gringo97','rahu97@dotcom.com'),
(4,'Rahu4','Gringo96','rahu96@dotcom.com'),
(5,'Rahu5','Gringo95','rahu95@dotcom.com'),
(6,'Rahu6','Gringo94','rahu94@dotcom.com'),
(7,'Rahu7','Gringo93','rahu93@dotcom.com'),
(8,'Rahu8','Gringo92','rahu92@dotcom.com'),
(9,'Rahu9','Gringo91','rahu91@dotcom.com'),
(10,'Rahu10','Gringo90','rahu90@dotcom.com'),
(11,'Rahu11','Gringo89','rahu89@dotcom.com'),
(12,'Rahu12','Gringo88','rahu88@dotcom.com'),
(13,'Rahu13','Gringo87','rahu87@dotcom.com'),
(14,'Rahu14','Gringo86','rahu86@dotcom.com'),
(15,'Rahu15','Gringo85','rahu85@dotcom.com'),
(16,'Rahu16','Gringo84','rahu84@dotcom.com'),
(17,'Rahu17','Gringo83','rahu83@dotcom.com'),
(18,'Rahu18','Gringo82','rahu82@dotcom.com'),
(19,'Rahu19','Gringo81','rahu81@dotcom.com'),
(20,'Rahu20','Gringo80','rahu80@dotcom.com'),
(21,'Rahu21','Gringo79','rahu79@dotcom.com'),
(22,'Rahu22','Gringo78','rahu78@dotcom.com'),
(23,'Rahu23','Gringo77','rahu77@dotcom.com'),
(24,'Rahu24','Gringo76','rahu76@dotcom.com'),
(25,'Rahu25','Gringo75','rahu75@dotcom.com'),
(26,'Rahu26','Gringo74','rahu74@dotcom.com'),
(27,'Rahu27','Gringo73','rahu73@dotcom.com'),
(28,'Rahu28','Gringo72','rahu72@dotcom.com'),
(29,'Rahu29','Gringo71','rahu71@dotcom.com'),
(30,'Rahu30','Gringo70','rahu70@dotcom.com'),
(31,'Rahu31','Gringo69','rahu69@dotcom.com'),
(32,'Rahu32','Gringo68','rahu68@dotcom.com'),
(33,'Rahu33','Gringo67','rahu67@dotcom.com'),
(34,'Rahu34','Gringo66','rahu66@dotcom.com'),
(35,'Rahu35','Gringo65','rahu65@dotcom.com'),
(36,'Rahu36','Gringo64','rahu64@dotcom.com'),
(37,'Rahu37','Gringo63','rahu63@dotcom.com'),
(38,'Rahu38','Gringo62','rahu62@dotcom.com'),
(39,'Rahu39','Gringo61','rahu61@dotcom.com'),
(40,'Rahu40','Gringo60','rahu60@dotcom.com'),
(41,'Rahu41','Gringo59','rahu59@dotcom.com'),
(42,'Rahu42','Gringo58','rahu58@dotcom.com'),
(43,'Rahu43','Gringo57','rahu57@dotcom.com'),
(44,'Rahu44','Gringo56','rahu56@dotcom.com'),
(45,'Rahu45','Gringo55','rahu55@dotcom.com'),
(46,'Rahu46','Gringo54','rahu54@dotcom.com'),
(47,'Rahu47','Gringo53','rahu53@dotcom.com'),
(48,'Rahu48','Gringo52','rahu52@dotcom.com'),
(49,'Rahu49','Gringo51','rahu51@dotcom.com'),
(50,'Rahu50','Gringo50','rahu50@dotcom.com'),
(51,'Rahu51','Gringo49','rahu49@dotcom.com'),
(52,'Rahu52','Gringo48','rahu48@dotcom.com'),
(53,'Rahu53','Gringo47','rahu47@dotcom.com'),
(54,'Rahu54','Gringo46','rahu46@dotcom.com'),
(55,'Rahu55','Gringo45','rahu45@dotcom.com'),
(56,'Rahu56','Gringo44','rahu44@dotcom.com'),
(57,'Rahu57','Gringo43','rahu43@dotcom.com'),
(58,'Rahu58','Gringo42','rahu42@dotcom.com'),
(59,'Rahu59','Gringo41','rahu41@dotcom.com'),
(60,'Rahu60','Gringo40','rahu40@dotcom.com'),
(61,'Rahu61','Gringo39','rahu39@dotcom.com'),
(62,'Rahu62','Gringo38','rahu38@dotcom.com'),
(63,'Rahu63','Gringo37','rahu37@dotcom.com'),
(64,'Rahu64','Gringo36','rahu36@dotcom.com'),
(65,'Rahu65','Gringo35','rahu35@dotcom.com'),
(66,'Rahu66','Gringo34','rahu34@dotcom.com'),
(67,'Rahu67','Gringo33','rahu33@dotcom.com'),
(68,'Rahu68','Gringo32','rahu32@dotcom.com'),
(69,'Rahu69','Gringo31','rahu31@dotcom.com'),
(70,'Rahu70','Gringo30','rahu30@dotcom.com'),
(71,'Rahu71','Gringo29','rahu29@dotcom.com'),
(72,'Rahu72','Gringo28','rahu28@dotcom.com'),
(73,'Rahu73','Gringo27','rahu27@dotcom.com'),
(74,'Rahu74','Gringo26','rahu26@dotcom.com'),
(75,'Rahu75','Gringo25','rahu25@dotcom.com'),
(76,'Rahu76','Gringo24','rahu24@dotcom.com'),
(77,'Rahu77','Gringo23','rahu23@dotcom.com'),
(78,'Rahu78','Gringo22','rahu22@dotcom.com'),
(79,'Rahu79','Gringo21','rahu21@dotcom.com'),
(80,'Rahu80','Gringo20','rahu20@dotcom.com'),
(81,'Rahu81','Gringo19','rahu19@dotcom.com'),
(82,'Rahu82','Gringo18','rahu18@dotcom.com'),
(83,'Rahu83','Gringo17','rahu17@dotcom.com'),
(84,'Rahu84','Gringo16','rahu16@dotcom.com'),
(85,'Rahu85','Gringo15','rahu15@dotcom.com'),
(86,'Rahu86','Gringo14','rahu14@dotcom.com'),
(87,'Rahu87','Gringo13','rahu13@dotcom.com'),
(88,'Rahu88','Gringo12','rahu12@dotcom.com'),
(89,'Rahu89','Gringo11','rahu11@dotcom.com'),
(90,'Rahu90','Gringo10','rahu10@dotcom.com'),
(91,'Rahu91','Gringo9','rahu9@dotcom.com'),
(92,'Rahu92','Gringo8','rahu8@dotcom.com'),
(93,'Rahu93','Gringo7','rahu7@dotcom.com'),
(94,'Rahu94','Gringo6','rahu6@dotcom.com'),
(95,'Rahu95','Gringo5','rahu5@dotcom.com'),
(96,'Rahu96','Gringo4','rahu4@dotcom.com'),
(97,'Rahu97','Gringo3','rahu3@dotcom.com'),
(98,'Rahu98','Gringo2','rahu2@dotcom.com'),
(99,'Rahu99','Gringo1','rahu1@dotcom.com'),
(100,'Rahu100','Gringo0','rahu0@dotcom.com');

