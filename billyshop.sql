-- drop database `billyshop`;

CREATE DATABASE  IF NOT EXISTS `billyshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `billyshop`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: wck
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `brand`
--



--
-- Dumping data for table `brand`
--



--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `proid` int NOT NULL,
  `userid` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`proid`,`userid`),
  KEY `FKt6jitgcn53wujrlwnnp1tb840` (`userid`),
  CONSTRAINT `FKfd8cq8925lj84l39uek1s9kce` FOREIGN KEY (`proid`) REFERENCES `product` (`proId`),
  CONSTRAINT `FKt6jitgcn53wujrlwnnp1tb840` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (10,10006,2),(32,10000,2),(32,10007,1),(922,10006,2);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cateId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `logo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`cateId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (cateId, name, logo) VALUES 
(1, 'Trà Sữa', 'https://example.com/trasssua.jpg'),
(2, 'Sinh Tố', 'https://example.com/sinhto.jpg'),
(3, 'Nước Ép Trái Cây', 'https://example.com/nuoceptraicay.jpg'),
(4, 'Trà Trái Cây', 'https://example.com/tratraicay.jpg'),
(5, 'Cà Phê', 'https://example.com/caphe.jpg'),
(6, 'Trà Xanh', 'https://example.com/traxanh.jpg'),
(7, 'Nước Ép Rau Củ', 'https://example.com/nuocepraucu.jpg'),
(8, 'Sữa Chua Uống', 'https://example.com/suachuauong.jpg'),
(9, 'Nước Ngọt', 'https://example.com/nuocngot.jpg'),
(10, 'Sinh Tố Bơ', 'https://example.com/sinhtobo.jpg'),
(11, 'Smoothie', 'https://example.com/smoothie.jpg'),
(12, 'Trà Đào', 'https://example.com/tradao.jpg'),
(13, 'Trà Sữa Thái Xanh', 'https://example.com/trasssuthaixanh.jpg'),
(14, 'Sữa Đậu Nành', 'https://example.com/suadaunanh.jpg'),
(15, 'Sữa Tươi', 'https://example.com/suatuoi.jpg'),
(16, 'Trà Sữa Trân Châu', 'https://example.com/trassstranchau.jpg'),
(17, 'Trà Matcha', 'https://example.com/tramatcha.jpg'),
(18, 'Nước Khoáng', 'https://example.com/nuockhoang.jpg'),
(19, 'Trà Chanh', 'https://example.com/trachanh.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `shipping_method` varchar(255) DEFAULT NULL,
  `order_status` tinyint(1) DEFAULT '0',
  `order_total` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `order_chk_1` CHECK ((`order_total` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `order_id` int NOT NULL,
  `pro_id` int NOT NULL,
  `discount` float NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_id`,`pro_id`),
  KEY `FKt1alidop4w9a5evgouqj02vgd` (`pro_id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKt1alidop4w9a5evgouqj02vgd` FOREIGN KEY (`pro_id`) REFERENCES `product` (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (37,10,33,2),(37,32,11,1),(38,10,33,2),(38,32,11,1),(39,10,33,2),(39,32,11,1),(52,1607,65,2),(52,4585,70,1),(52,4938,61,1),(52,6447,61,1),(53,4938,61,1),(54,1607,65,3),(54,2797,50,2),(54,4585,70,2),(54,6447,61,1),(55,1607,65,3),(55,4585,70,2),(55,6447,61,1),(56,1607,65,1),(56,4332,64,1),(56,4585,70,1),(56,4938,61,1),(57,1383,62,100),(57,4332,64,9),(57,4585,70,2),(58,4332,64,90),(58,4585,70,95),(59,10,33,2),(59,32,11,1),(60,1605,50,158),(60,2797,50,158),(60,3968,55,154),(60,4128,58,152),(60,4504,62,100),(61,1383,65,85),(61,4332,60,96),(61,4504,62,102),(61,4585,70,78),(62,1383,65,20),(62,1605,50,30),(62,4585,70,70),(63,1605,50,10);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT 'standard',
  `shipping_method` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKdxew8n76x1bnoxjas0qxrlbq6` (`userid`),
  CONSTRAINT `FKdxew8n76x1bnoxjas0qxrlbq6` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (37,'VND','10/12/2023 19:46:18','COD','standard',0,499000,10000),(38,'VND','10/12/2023 19:49:20','VNPAY','standard',1,469000,10000),(39,'USD','10/12/2023 19:49:56','Paypal','standard',1,19.22,10000),(40,'USD','10/01/2023 19:49:56','VNPAY','standard',1,19.22,1),(41,'USD','10/02/2023 19:49:56','VNPAY','standard',1,50,1),(42,'USD','10/03/2023 19:49:56','Paypal','standard',1,19.22,1),(43,'USD','10/04/2023 19:49:56','Paypal','standard',1,19.22,1),(44,'USD','10/05/2023 19:49:56','Paypal','standard',1,30,1),(45,'USD','10/06/2023 19:49:56','Paypal','standard',1,19.22,1),(46,'USD','10/07/2023 19:49:56','Paypal','standard',1,10,1),(47,'USD','10/08/2023 19:49:56','Paypal','standard',1,19.22,1),(48,'VND','10/09/2023 19:49:56','VNPAY','standard',1,469000,1),(49,'VND','10/10/2023 19:49:56','VNPAY','standard',1,469000,1),(50,'VND','10/10/2023 19:49:56','COD','standard',1,469000,1),(51,'VND','10/11/2023 19:49:56','COD','standard',1,469000,1),(52,'VND','11/12/2023 09:48:54','COD',NULL,0,373000,10000),(53,'VND','11/12/2023 09:52:17','COD',NULL,0,140000,10000),(54,'VND','11/12/2023 10:56:56','COD',NULL,1,528000,10000),(55,'VND','11/12/2023 11:00:09','COD',NULL,1,352000,10000),(56,'VND','11/12/2023 16:45:11','COD',NULL,1,289000,10012),(57,'VND','12/12/2023 14:47:22','COD',NULL,0,8222000,10000),(58,'USD','12/12/2023 14:50:30','Paypal',NULL,0,325.8,10000),(59,'VND','12/12/2023 18:07:29','COD',NULL,0,264500,10000),(60,'VND','12/12/2023 22:31:51','COD',NULL,0,34752000,10000),(61,'VND','12/12/2023 22:38:54','COD',NULL,0,20050000,10000),(62,'VND','12/12/2023 23:10:42','COD',NULL,0,3610000,10000),(63,'VND','12/12/2023 23:11:03','COD',NULL,1,150000,10000);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `proId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `description` text,
  `stock` int DEFAULT '1000',
  `sale` int DEFAULT '0',
  `price` float NOT NULL,
  `image_link` varchar(1000) DEFAULT NULL,
  `cateId` int DEFAULT NULL,
  PRIMARY KEY (`proId`),
  KEY `cateId` (`cateId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cateId`) REFERENCES `category` (`cateId`),
  CONSTRAINT `product_chk_1` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=6501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`name`, `description`, `sale`, `price`, `image_link`, `cateId`) VALUES
('Trà Sữa Truyền Thống', 'Trà sữa pha chế theo công thức truyền thống.', 0, 35000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__TRA_TACH_VAI.jpg', 1),
('Trà Xanh Nhài', 'Trà xanh thơm mùi nhài dịu dàng.', 0, 40000, 'https://phache.com.vn/upload/gallery/cach-lam-tra-thanh-dao-highland-1-.png', 1),
('Trà Sữa Trân Châu Đen', 'Trà sữa với trân châu đen dai ngon.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__TSV.jpg', 1),
('Trà Sữa Ô Long', 'Trà ô long pha chế cùng sữa thơm ngon.', 0, 40000, 'https://phache.com.vn/upload/gallery/cach-lam-tra-thanh-dao-highland-1-.png', 1),
('Matcha Latte', 'Matcha hòa quyện cùng sữa béo.', 0, 47500, 'https://phache.com.vn/upload/gallery/cach-lam-tra-thanh-dao-highland-1-.png', 1),
('Trà Chanh Mật Ong', 'Trà chanh tươi mát kết hợp cùng mật ong ngọt lịm.', 0, 37500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__TSV.jpg', 2),
('Trà Thái Sữa', 'Trà Thái ngọt dịu và béo ngậy.', 0, 42500, 'https://phache.com.vn/upload/gallery/cach-lam-tra-thanh-dao-highland-1-.png', 2),
('Trà Bí Đao', 'Trà bí đao thanh mát, giải nhiệt.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__TSV.jpg', 2),
('Trà Sữa Khoai Môn', 'Trà sữa hương vị khoai môn thơm ngon.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__FREEZE_TRA_XANH.jpg', 2),
('Trà Trái Cây', 'Sự kết hợp tươi mát của nhiều loại trái cây.', 0, 39000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__CARAMEL_FREEZE_PHINDI.jpg', 1),
('Trà Sữa Dâu', 'Trà sữa vị dâu ngọt ngào.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Tea_Berry.jpg', 1),
('Trà Xanh Việt Quất', 'Trà xanh pha trộn hương vị việt quất.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 1),
('Trà Sữa Socola', 'Trà sữa vị socola béo ngậy.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Tea_Berry.jpg', 1),
('Trà Sữa Cà Phê', 'Trà sữa kết hợp vị cà phê đặc trưng.', 0, 47500, 'https://free.vector6.com/wp-content/uploads/2021/05/PNG-0000001805-png-do-uong-highland-coffee.png', 1),
('Trà Sữa Hoa Hồng', 'Trà sữa với hương hoa hồng tinh tế.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__CARAMEL_FREEZE_PHINDI.jpg', 2),
('Trà Sữa Dừa', 'Trà sữa vị dừa béo thơm.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Tea_Berry.jpg', 2),
('Trà Sữa Hạnh Nhân', 'Trà sữa vị hạnh nhân ngọt lịm.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__CARAMEL_FREEZE_PHINDI.jpg', 2),
('Trà Sữa Hạt Dẻ', 'Trà sữa vị hạt dẻ thơm ngon.', 0, 47500, 'https://free.vector6.com/wp-content/uploads/2021/05/PNG-0000001805-png-do-uong-highland-coffee.png', 2),
('Trà Sữa Caramel', 'Trà sữa vị caramel ngọt ngào.', 0, 45000, 'https://free.vector6.com/wp-content/uploads/2021/05/PNG-0000001805-png-do-uong-highland-coffee.png', 1),
('Trà Sữa Gừng', 'Trà sữa có vị gừng cay nồng.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpgg', 1),
('Trà Sữa Vanilla', 'Trà sữa vị vanilla cổ điển.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 1),
('Trà Xanh Đào', 'Trà xanh vị đào ngọt mát.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 2),
('Trà Xanh Bạc Hà', 'Trà xanh kết hợp bạc hà tươi mát.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 2),
('Trà Đen Chanh', 'Trà đen vị chanh tươi ngon.', 0, 42500, 'https://free.vector6.com/wp-content/uploads/2021/05/PNG-0000001805-png-do-uong-highland-coffee.png', 2),
('Trà Sữa Xoài', 'Trà sữa vị xoài nhiệt đới.', 0, 47500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg', 2),
('Trà Chanh Dây', 'Trà với vị chanh dây đậm đà.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 1),
('Trà Xanh Dứa', 'Trà xanh vị dứa ngọt ngào.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 1),
('Trà Dưa Hấu', 'Trà vị dưa hấu mát lành.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg', 1),
('Trà Đen Vải', 'Trà đen với vị vải ngọt lịm.', 0, 47500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 1),
('Trà Sữa Dưa Gang', 'Trà sữa vị dưa gang thơm mát.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 2),
('Trà Xanh Táo', 'Trà xanh kết hợp vị táo giòn ngọt.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2024/Phindi_Cassia/thumbs/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg', 2),
('Trà Bưởi', 'Trà vị bưởi chua ngọt.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg', 2),
('Trà Sữa Đu Đủ', 'Trà sữa vị đu đủ nhiệt đới.', 0, 47500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg', 2),
('Trà Hoa Anh Đào', 'Trà hương hoa anh đào dịu nhẹ.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg', 1),
('Trà Sữa Sakura', 'Trà sữa hương sakura đặc biệt.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 1),
('Trà Sữa Đậu Đỏ', 'Trà sữa vị đậu đỏ ngọt thơm.', 0, 42500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 1),
('Trà Ô Long Đào Trắng', 'Trà ô long vị đào trắng ngọt ngào.', 0, 47500, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 1),
('Trà Sữa Hoa Tầm Xuân', 'Trà sữa hương hoa tầm xuân tinh tế.', 0, 40000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 2),
('Trà Mãng Cầu Xiêm', 'Trà vị mãng cầu xiêm độc đáo.', 0, 45000, 'https://www.highlandscoffee.com.vn/vnt_upload/product/11_2023/thumbs/270_crop_3P_COMBO_Freeze_Berry.jpg', 2),
('Trà Sữa Bơ', 'Trà sữa vị bơ béo ngậy.', 0, 47500, 'https://free.vector6.com/wp-content/uploads/2021/05/PNG-0000001805-png-do-uong-highland-coffee.png', 2);

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `promotionId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `discount_rate` int DEFAULT NULL,
  `is_active` int DEFAULT NULL,
  PRIMARY KEY (`promotionId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'g50','giảm 50%',50,1);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `ratingId` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `display` int NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ratingId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES 
    (1, 'Vân Anh', 'Trà sữa rất ngon, không quá ngọt, vị trà đậm đà!', 'Facebook', 5, 1, NULL),
    (2, 'Phương Thảo', 'Sản phẩm trà sữa này rất đáng thử! Vị ngon và hợp khẩu vị.', 'Facebook', 4, 1, NULL),
    (3, 'Khánh Linh', 'Mình đã uống trà sữa này nhiều lần và mỗi lần đều hài lòng. Vị ngọt vừa phải, topping phong phú, cực kỳ ấn tượng!', 'Instagram', 5, 1, NULL);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN'),(11,'USER'),(12,'ADMIN'),(13,'USER'),(14,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_session`
--

DROP TABLE IF EXISTS `shopping_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_session` (
  `proid` int NOT NULL,
  `userid` int NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`proid`,`userid`),
  KEY `FKbqd5knnsebb1g5ihf0ql77gm6` (`userid`),
  CONSTRAINT `FKa00d1atl066vtir09r2t1b555` FOREIGN KEY (`proid`) REFERENCES `product` (`proId`),
  CONSTRAINT `FKbqd5knnsebb1g5ihf0ql77gm6` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_session`
--

LOCK TABLES `shopping_session` WRITE;
/*!40000 ALTER TABLE `shopping_session` DISABLE KEYS */;
INSERT INTO `shopping_session` VALUES (10,10007,'2023-12-11'),(32,10000,'2023-12-12'),(375,10000,'2023-12-12'),(922,10000,'2023-12-13'),(1383,10000,'2023-12-12'),(1395,10000,'2023-12-12'),(1560,10000,'2023-12-12'),(1605,10000,'2023-12-12'),(1607,10000,'2023-12-11'),(1739,10000,'2023-12-13'),(2239,10000,'2023-12-13'),(2675,10000,'2023-12-13'),(2797,10000,'2023-12-12'),(3583,10000,'2023-12-13'),(3839,10000,'2023-12-13'),(3857,10000,'2023-12-13'),(3950,10000,'2023-12-13'),(3968,10000,'2023-12-11'),(4040,10000,'2023-12-13'),(4332,10000,'2023-12-11'),(4504,10000,'2023-12-12'),(4585,10007,'2023-12-11'),(4938,10007,'2023-12-11'),(6447,10000,'2023-12-12');
/*!40000 ALTER TABLE `shopping_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT '0',
  `active` bit(8) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `is_enabled` bit(8) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`),
  CONSTRAINT `user_chk_1` CHECK ((`email` like _utf8mb4'%_@%_.%_'))
) ENGINE=InnoDB AUTO_INCREMENT=10015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'123','Test','test@gmail.com','09876543210','Kí túc xá khu B , Đông Hòa , Dĩ An , Bình Dương',0,_binary '',NULL,NULL,NULL,NULL,NULL),(10000,NULL,'Đặng Tiến Phát','luciferxhnh@gmail.com','0933758487','Kí túc xá khu B , Đông Hiệp , Dĩ An , Bình Dương',0,_binary '\0','$2a$10$pblZsujvYAhHN56bXbeLt.g.lmHgg/g7Pj2ehLJEjokK8S6DPHbJK',NULL,NULL,NULL,_binary ''),(10004,NULL,'test','test1@gmail.com','12345678','Address 1 - edited',0,_binary '\0','$2a$10$QPaTqx9IF7b.9cNYaF5TlOrvFIRMHqGIHSqKt9mENyM.yOsoDvBC6',NULL,NULL,NULL,NULL),(10006,NULL,'test2','test2@gmail.com','1234567810','Address 1 - edited',0,_binary '\0','$2a$10$EuPtlxW8ddqsRNuZYT6g7OsOH9ZJPW/OQh4vVGwbRfk8zJ5ScL4ge',NULL,NULL,NULL,NULL),(10007,NULL,'admin','admin@gmail.com','123','Address 1 - edited',0,_binary '\0','$2a$10$bAt4Q07wnqc73CSRm6ilpu5p1n9uEoxCvnIiqKnS3FHik4nyosfX.',NULL,NULL,NULL,NULL),(10008,NULL,'test','test4@gmail.com','12321421432','Kí túc xá khu B, Đông Hòa, Dĩ An, Bình Dương',0,_binary '\0','$2a$10$h3Nt5nFO/Wv.qNMPt3Se6.FdAUyQXocIVzIbeQgMKJt/aKFuzfakO',NULL,NULL,NULL,NULL),(10009,NULL,'test5','test5@gmail.com','421423432','Address 1 ',0,_binary '\0','$2a$10$vA4x6A.qn9cbllXFKzYEIOfK9uRpDPc1aV9T68KhQAr.1zSq.DNVu',NULL,NULL,NULL,NULL),(10011,NULL,'Nguyen Thien Nhan','nhanthien@gmail.com','0328980403','Đồng Nai',0,_binary '\0','$2a$10$RnhEmwddcJpTV58jXumd3uFPMxdUDA9nIsGIkRwyj3rrxJS0oaZLG',NULL,NULL,NULL,NULL),(10012,NULL,'Nguyễn Văn A','nva@gmail.com','09873547342','address nva',0,_binary '\0','$2a$10$4TNV4Dr7R6P3YNO.1lmi3eKVk8bBU9/FTK24n7uXhL.ZBhCALqv7a',NULL,NULL,NULL,NULL),(10013,NULL,'Đặng Tiến Phát','bontyphat@gmail.com','0987875743','Address 1',0,NULL,'$2a$10$/T7j5M1uW16fBb2cv4phXu.rDxvtWrGK0SDDZ..tPgoN3j6QX4VG.',NULL,NULL,'324596',_binary ''),(10014,NULL,'vnshadow26','vnshadow26@gmail.com','0987867757','Address 1 ',0,NULL,'$2a$10$I9qBMaVavoaDJvKf9v2eRe/ulLq/k20AmYSCxEhFqdQsYdkj5WUGy',NULL,NULL,'764150',_binary '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj53n5vhpbsurvdnj9y1x4p0id` (`role_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKj53n5vhpbsurvdnj9y1x4p0id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (10004,1),(10006,1),(10008,1),(10009,1),(10012,1),(10013,1),(10014,1),(10000,2),(10007,2),(10011,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13  7:52:40
