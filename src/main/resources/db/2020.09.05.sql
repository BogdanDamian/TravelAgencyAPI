CREATE DATABASE  IF NOT EXISTS `travel_agency` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `travel_agency`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: travel_agency
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country_id` int NOT NULL,
  `code` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `is_destination` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `COUNTRY_CITY_FK_idx` (`country_id`),
  CONSTRAINT `COUNTRY_CITY_FK` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,232,'LND','London',1),(2,183,'BUC','Bucuresti',1),(3,183,'PNT','Piatra Neamt',1),(4,183,'CTA','Constanta',1),(5,232,'BRMUK','Birmingham',1),(6,233,'BRMUS','Birmingham',1),(7,183,'GL','Galati',0),(8,233,'NYC','New York City',1),(9,233,'LA','Los Angeles',1),(10,233,'SFC','San Francisco',1),(11,233,'NJ001','New Jersey',1),(12,233,'BSTN','Boston',1),(13,233,'CH001','Chicago',1),(14,233,'HST01','Houston',1),(15,205,'MDR01','Madrid',1),(16,205,'BRC01','Barcelona',1),(17,205,'S0705','Sevilla',1),(18,205,'VAL01','Valencia',1),(19,183,'BRLNN','Braila',0),(20,183,'FCSVN','Focsani',0),(21,183,'TECGL','Tecuci',0),(22,183,'SLTL','Sulina',1),(23,183,'BCRO','Bacau',0),(24,108,'RMIT','Rome',1),(25,108,'MLNIT','Milan',1),(26,108,'NPLIT','Naples',1),(27,108,'JUVIT','Turin',1),(28,108,'FRZIT','Florence',1),(29,82,'BRLDE','Berlin',1),(30,82,'HMBG','Hamburg',1),(31,82,'BAY33','Munich',1),(32,82,'BVB','Dortmund',1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `telephone` varchar(20) DEFAULT 'null',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Voncila Ion','null'),(2,'Teodoro Emil','0040 747 123 456'),(3,'Soimu Andreea-Valeria','0040 752 252 223'),(4,'Popescu Nicu','null'),(5,'Popescu-Ionescu George-Adrian','003 945 556 233'),(6,'Ofrim Dragos','null'),(7,'Jack Numb-Encore','0040 744 000 001');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(3) NOT NULL,
  `name` varchar(45) NOT NULL,
  `need_visa` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (2,'AF','Afghanistan',1),(3,'AL','Albania',0),(4,'DZ','Algeria',1),(5,'DS','American Samoa',1),(6,'AD','Andorra',0),(7,'AO','Angola',1),(8,'AI','Anguilla',1),(9,'AQ','Antarctica',1),(10,'AG','Antigua and Barbuda',1),(11,'AR','Argentina',0),(12,'AM','Armenia',1),(13,'AW','Aruba',1),(14,'AU','Australia',1),(15,'AT','Austria',0),(16,'AZ','Azerbaijan',1),(17,'BS','Bahamas',1),(18,'BH','Bahrain',1),(19,'BD','Bangladesh',1),(20,'BB','Barbados',1),(21,'BY','Belarus',1),(22,'BE','Belgium',0),(23,'BZ','Belize',1),(24,'BJ','Benin',1),(25,'BM','Bermuda',1),(26,'BT','Bhutan',1),(27,'BO','Bolivia',1),(28,'BA','Bosnia and Herzegovina',1),(29,'BW','Botswana',1),(30,'BV','Bouvet Island',1),(31,'BR','Brazil',1),(32,'IO','British Indian Ocean Territory',1),(33,'BN','Brunei Darussalam',1),(34,'BG','Bulgaria',0),(35,'BF','Burkina Faso',1),(36,'BI','Burundi',1),(37,'KH','Cambodia',1),(38,'CM','Cameroon',1),(39,'CA','Canada',1),(40,'CV','Cape Verde',1),(41,'KY','Cayman Islands',1),(42,'CF','Central African Republic',1),(43,'TD','Chad',1),(44,'CL','Chile',1),(45,'CN','China',1),(46,'CX','Christmas Island',1),(47,'CC','Cocos (Keeling) Islands',1),(48,'CO','Colombia',1),(49,'KM','Comoros',1),(50,'CD','Democratic Republic of the Congo',1),(51,'CG','Republic of Congo',1),(52,'CK','Cook Islands',1),(53,'CR','Costa Rica',1),(54,'HR','Croatia (Hrvatska)',0),(55,'CU','Cuba',1),(56,'CY','Cyprus',0),(57,'CZ','Czech Republic',0),(58,'DK','Denmark',0),(59,'DJ','Djibouti',1),(60,'DM','Dominica',1),(61,'DO','Dominican Republic',1),(62,'TP','East Timor',1),(63,'EC','Ecuador',1),(64,'EG','Egypt',0),(65,'SV','El Salvador',1),(66,'GQ','Equatorial Guinea',1),(67,'ER','Eritrea',1),(68,'EE','Estonia',0),(69,'ET','Ethiopia',1),(70,'FK','Falkland Islands (Malvinas)',1),(71,'FO','Faroe Islands',0),(72,'FJ','Fiji',1),(73,'FI','Finland',0),(74,'FR','France',0),(75,'FX','France, Metropolitan',0),(76,'GF','French Guiana',0),(77,'PF','French Polynesia',0),(78,'TF','French Southern Territories',0),(79,'GA','Gabon',0),(80,'GM','Gambia',1),(81,'GE','Georgia',1),(82,'DE','Germany',0),(83,'GH','Ghana',0),(84,'GI','Gibraltar',1),(85,'GK','Guernsey',1),(86,'GR','Greece',0),(87,'GL','Greenland',1),(88,'GD','Grenada',1),(89,'GP','Guadeloupe',1),(90,'GU','Guam',1),(91,'GT','Guatemala',1),(92,'GN','Guinea',1),(93,'GW','Guinea-Bissau',1),(94,'GY','Guyana',1),(95,'HT','Haiti',1),(96,'HM','Heard and Mc Donald Islands',1),(97,'HN','Honduras',1),(98,'HK','Hong Kong',1),(99,'HU','Hungary',0),(100,'IS','Iceland',0),(101,'IN','India',1),(102,'IM','Isle of Man',1),(103,'ID','Indonesia',1),(104,'IR','Iran (Islamic Republic of)',1),(105,'IQ','Iraq',1),(106,'IE','Ireland',1),(107,'IL','Israel',0),(108,'IT','Italy',0),(109,'CI','Ivory Coast',1),(110,'JE','Jersey',1),(111,'JM','Jamaica',1),(112,'JP','Japan',0),(113,'JO','Jordan',1),(114,'KZ','Kazakhstan',1),(115,'KE','Kenya',1),(116,'KI','Kiribati',1),(117,'KP','Korea, Democratic People\'s Republic of',1),(118,'KR','Korea, Republic of',0),(119,'XK','Kosovo',1),(120,'KW','Kuwait',1),(121,'KG','Kyrgyzstan',1),(122,'LA','Lao People\'s Democratic Republic',1),(123,'LV','Latvia',0),(124,'LB','Lebanon',1),(125,'LS','Lesotho',1),(126,'LR','Liberia',1),(127,'LY','Libyan Arab Jamahiriya',1),(128,'LI','Liechtenstein',0),(129,'LT','Lithuania',0),(130,'LU','Luxembourg',0),(131,'MO','Macau',1),(132,'MK','North Macedonia',0),(133,'MG','Madagascar',0),(134,'MW','Malawi',1),(135,'MY','Malaysia',1),(136,'MV','Maldives',1),(137,'ML','Mali',1),(138,'MT','Malta',0),(139,'MH','Marshall Islands',1),(140,'MQ','Martinique',1),(141,'MR','Mauritania',1),(142,'MU','Mauritius',1),(143,'TY','Mayotte',1),(144,'MX','Mexico',0),(145,'FM','Micronesia, Federated States of',1),(146,'MD','Moldova, Republic of',0),(147,'MC','Monaco',0),(148,'MN','Mongolia',1),(149,'ME','Montenegro',0),(150,'MS','Montserrat',0),(151,'MA','Morocco',0),(152,'MZ','Mozambique',1),(153,'MM','Myanmar',1),(154,'NA','Namibia',1),(155,'NR','Nauru',1),(156,'NP','Nepal',1),(157,'NL','Netherlands',0),(158,'AN','Netherlands Antilles',1),(159,'NC','New Caledonia',1),(160,'NZ','New Zealand',1),(161,'NI','Nicaragua',0),(162,'NE','Niger',0),(163,'NG','Nigeria',1),(164,'NU','Niue',1),(165,'NF','Norfolk Island',1),(166,'MP','Northern Mariana Islands',1),(167,'NO','Norway',0),(168,'OM','Oman',0),(169,'PK','Pakistan',1),(170,'PW','Palau',1),(171,'PS','Palestine',1),(172,'PA','Panama',1),(173,'PG','Papua New Guinea',1),(174,'PY','Paraguay',1),(175,'PE','Peru',0),(176,'PH','Philippines',1),(177,'PN','Pitcairn',0),(178,'PL','Poland',0),(179,'PT','Portugal',0),(180,'PR','Puerto Rico',0),(181,'QA','Qatar',1),(182,'RE','Reunion',1),(183,'RO','Romania',0),(184,'RU','Russian Federation',1),(185,'RW','Rwanda',1),(186,'KN','Saint Kitts and Nevis',1),(187,'LC','Saint Lucia',1),(188,'VC','Saint Vincent and the Grenadines',1),(189,'WS','Samoa',1),(190,'SM','San Marino',1),(191,'ST','Sao Tome and Principe',1),(192,'SA','Saudi Arabia',1),(193,'SN','Senegal',1),(194,'RS','Serbia',0),(195,'SC','Seychelles',1),(196,'SL','Sierra Leone',1),(197,'SG','Singapore',1),(198,'SK','Slovakia',0),(199,'SI','Slovenia',0),(200,'SB','Solomon Islands',1),(201,'SO','Somalia',1),(202,'ZA','South Africa',1),(203,'GS','South Georgia South Sandwich Islands',1),(204,'SS','South Sudan',1),(205,'ES','Spain',0),(206,'LK','Sri Lanka',1),(207,'SH','St. Helena',1),(208,'PM','St. Pierre and Miquelon',1),(209,'SD','Sudan',1),(210,'SR','Suriname',1),(211,'SJ','Svalbard and Jan Mayen Islands',1),(212,'SZ','Swaziland',1),(213,'SE','Sweden',0),(214,'CH','Switzerland',0),(215,'SY','Syrian Arab Republic',1),(216,'TW','Taiwan',1),(217,'TJ','Tajikistan',1),(218,'TZ','Tanzania, United Republic of',1),(219,'TH','Thailand',1),(220,'TG','Togo',1),(221,'TK','Tokelau',0),(222,'TO','Tonga',0),(223,'TT','Trinidad and Tobago',1),(224,'TN','Tunisia',0),(225,'TR','Turkey',0),(226,'TM','Turkmenistan',1),(227,'TC','Turks and Caicos Islands',1),(228,'TV','Tuvalu',1),(229,'UG','Uganda',1),(230,'UA','Ukraine',0),(231,'AE','United Arab Emirates',0),(232,'GB','United Kingdom',1),(233,'US','United States',1),(234,'UM','United States minor outlying islands',1),(235,'UY','Uruguay',1),(236,'UZ','Uzbekistan',1),(237,'VU','Vanuatu',1),(238,'VA','Vatican City State',0),(239,'VE','Venezuela',1),(240,'VN','Vietnam',1),(241,'VG','Virgin Islands (British)',1),(242,'VI','Virgin Islands (U.S.)',1),(243,'WF','Wallis and Futuna Islands',1),(244,'EH','Western Sahara',1),(245,'YE','Yemen',1),(246,'ZM','Zambia',0),(247,'ZW','Zimbabwe',1);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `standard` mediumint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CITY_HOTEL_FK_idx` (`city_id`),
  CONSTRAINT `CITY_HOTEL_FK` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (4,1,'City of London Hotel',4,'With a convenient city centre location close to Tower Bridge and the iconic Tower of London, Leonardo Royal Hotel London City is perfect for leisure and business guests wanting to make the most of the UK’s world-renowned capital. Its central location means it easy to reach from all over the country, making it a great place to lay your head after a long drive or train ride.'),(5,1,'Ibis',3,'Ibis (or Ibis Red; stylised as ibis) is a brand of economy hotels owned by Accor. Created in 1974, Ibis became Accor\'s economy megabrand in 2011 with the launch of Ibis Styles and Ibis Budget. As of December 2019, there were 1,218 hotels under the Ibis brand (excluding Styles and Budget hotels), with 155,678 rooms in total across 67 countries.'),(6,2,'Ibis',3,'Ibis (or Ibis Red; stylised as ibis) is a brand of economy hotels owned by Accor. Created in 1974, Ibis became Accor\'s economy megabrand in 2011 with the launch of Ibis Styles and Ibis Budget. As of December 2019, there were 1,218 hotels under the Ibis brand (excluding Styles and Budget hotels), with 155,678 rooms in total across 67 countries.'),(7,4,'Ibis',3,'Ibis (or Ibis Red; stylised as ibis) is a brand of economy hotels owned by Accor. Created in 1974, Ibis became Accor\'s economy megabrand in 2011 with the launch of Ibis Styles and Ibis Budget. As of December 2019, there were 1,218 hotels under the Ibis brand (excluding Styles and Budget hotels), with 155,678 rooms in total across 67 countries.'),(8,6,'Ibis',3,'Ibis (or Ibis Red; stylised as ibis) is a brand of economy hotels owned by Accor. Created in 1974, Ibis became Accor\'s economy megabrand in 2011 with the launch of Ibis Styles and Ibis Budget. As of December 2019, there were 1,218 hotels under the Ibis brand (excluding Styles and Budget hotels), with 155,678 rooms in total across 67 countries.'),(9,15,'Opera',4,NULL),(10,15,'Ibis',3,'Ibis (or Ibis Red; stylised as ibis) is a brand of economy hotels owned by Accor. Created in 1974, Ibis became Accor\'s economy megabrand in 2011 with the launch of Ibis Styles and Ibis Budget. As of December 2019, there were 1,218 hotels under the Ibis brand (excluding Styles and Budget hotels), with 155,678 rooms in total across 67 countries.'),(11,15,'Hyatt Centric Gran Via Madrid',5,'Located in the centre of Gran Via, you have the entire city within your reach. Museums, shops, attractions, our expert team are able to help create a personal and memorable trip.'),(12,28,'Watter Fall',4,NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_room_price`
--

DROP TABLE IF EXISTS `hotel_room_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_room_price` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `price` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `HOTEL_HOTEL_ROOM_PRICE_FK_idx` (`hotel_id`),
  KEY `ROOM_HOTEL_ROOM_PRICE_FK_idx` (`room_id`),
  CONSTRAINT `HOTEL_HOTEL_ROOM_PRICE_FK` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ROOM_HOTEL_ROOM_PRICE_FK` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_room_price`
--

LOCK TABLES `hotel_room_price` WRITE;
/*!40000 ALTER TABLE `hotel_room_price` DISABLE KEYS */;
INSERT INTO `hotel_room_price` VALUES (1,4,1,150.00),(2,4,2,175.00),(3,4,3,223.00),(4,5,1,110.00),(5,5,2,120.00),(6,5,3,140.00),(7,6,1,110.00),(8,6,2,120.00),(9,6,3,140.00),(10,7,1,110.00),(11,7,2,120.00),(12,7,3,140.00),(13,8,1,125.00),(14,8,2,150.00),(15,8,3,199.99),(16,9,1,200.00),(17,9,2,211.25),(18,9,3,275.05),(19,10,1,199.99),(20,10,2,205.55),(21,10,3,225.10),(22,11,1,300.00),(23,11,2,350.00),(24,11,3,425.00),(25,12,1,180.50),(26,12,2,205.50),(27,12,3,245.99);
/*!40000 ALTER TABLE `hotel_room_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `road`
--

DROP TABLE IF EXISTS `road`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `road` (
  `id` int NOT NULL AUTO_INCREMENT,
  `from_city_id` int NOT NULL,
  `to_city_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CITY_FROM_FK_idx` (`from_city_id`),
  KEY `CITY_TO_FK_idx` (`to_city_id`),
  CONSTRAINT `CITY_FROM_FK` FOREIGN KEY (`from_city_id`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `CITY_TO_FK` FOREIGN KEY (`to_city_id`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `road`
--

LOCK TABLES `road` WRITE;
/*!40000 ALTER TABLE `road` DISABLE KEYS */;
INSERT INTO `road` VALUES (1,7,2,20.00),(2,7,1,200.00);
/*!40000 ALTER TABLE `road` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `single_beds` int NOT NULL DEFAULT '0',
  `double_beds` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'Standard',0,1),(2,'Twin',1,0),(3,'Suite',1,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `road_id` int NOT NULL,
  `hotel_room_price_id` int NOT NULL,
  `persons` int NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CLIENT_TRIP_FK_idx` (`client_id`),
  KEY `ROAD_TRIP_FK_idx` (`road_id`),
  KEY `HOTEL_ROOM_PRICE_TRIP_FK_idx` (`hotel_room_price_id`),
  CONSTRAINT `CLIENT_TRIP_FK` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `HOTEL_ROOM_PRICE_TRIP_FK` FOREIGN KEY (`hotel_room_price_id`) REFERENCES `hotel_room_price` (`id`),
  CONSTRAINT `ROAD_TRIP_FK` FOREIGN KEY (`road_id`) REFERENCES `road` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,2,2,3,3,'2020-09-10','2020-09-15',1715.00);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-05 17:15:19
