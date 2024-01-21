-- MariaDB dump 10.19  Distrib 10.11.1-MariaDB, for osx14.0 (x86_64)
--
-- Host: localhost    Database: linkedin_db
-- ------------------------------------------------------
-- Server version	10.11.1-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `linkedin_db`;
CREATE DATABASE IF NOT EXISTS `linkedin_db`;
USE `linkedin_db`;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `profile_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `comment_id` int(11) DEFAULT NULL,
  `creation_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  KEY `profile_id` (`profile_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) NOT NULL,
  `school` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `field_of_study` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `education_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES
(29,91,'EPHEC','Graduat','IT','1989-09-01','1991-09-01'),
(30,97,'EPHEC','Graduat','IT','1989-09-01','1991-09-01'),
(31,92,'Ecole-IT','Master','IT','1989-09-01','1991-09-01'),
(32,93,'Ecole-IT','Master','IT','1989-09-01','1991-09-01'),
(33,94,'Ecole-IT','Master','IT','1989-09-01','1991-09-01'),
(34,95,'Ecole-IT','Master','IT','1989-09-01','1991-09-01'),
(35,96,'Ecole-IT','Master','IT','1989-09-01','1991-09-01');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiences`
--

DROP TABLE IF EXISTS `experiences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experiences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) NOT NULL,
  `job_title` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `experiences_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiences`
--

LOCK TABLES `experiences` WRITE;
/*!40000 ALTER TABLE `experiences` DISABLE KEYS */;
INSERT INTO `experiences` VALUES
(1,92,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(2,92,'Dev','Facebook','San Fran','2013-10-01','2014-11-01'),
(3,93,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(4,94,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(5,95,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(6,96,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(7,97,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(8,98,'Dev','Google','San Fran','2010-10-01','2012-11-01'),
(9,99,'Dev','Google','San Fran','2010-10-01','2012-11-01');
/*!40000 ALTER TABLE `experiences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `profile_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES
(7,'class of 2020','Good times',92),
(8,'Work life / balance','Why not',91);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_members`
--

DROP TABLE IF EXISTS `groups_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups_members` (
  `group_id` int(11) NOT NULL,
  `profile_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`group_id`,`profile_id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `groups_members_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `groups_members_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_members`
--

LOCK TABLES `groups_members` WRITE;
/*!40000 ALTER TABLE `groups_members` DISABLE KEYS */;
INSERT INTO `groups_members` VALUES
(7,82,'OK'),
(7,83,'OK'),
(7,84,'OK'),
(7,85,'OK'),
(8,81,'OK'),
(8,82,'OK'),
(8,83,'OK'),
(8,84,'OK'),
(8,85,'OK'),
(8,86,'OK'),
(8,87,'OK'),
(8,88,'OK'),
(8,89,'OK'),
(8,90,'OK'),
(8,91,'OK'),
(8,92,'OK'),
(8,93,'OK'),
(8,94,'OK'),
(8,95,'OK'),
(8,96,'OK'),
(8,97,'OK'),
(8,98,'OK'),
(8,99,'OK'),
(8,100,'OK');
/*!40000 ALTER TABLE `groups_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES
(64,81,'Century enough wait current many personal get.','Drop year meet indicate painting. Again why maybe myself popular matter total process. Bit option know behavior table three.','2023-12-09 16:13:42'),
(65,81,'Program test year prepare staff through magazine.','Day base investment crime glass. Build threat space seek body family seek.','2023-12-09 16:13:42'),
(66,82,'She position account exactly kind now government.','Test article part think need. Home interesting reason risk.','2023-12-09 16:13:42'),
(67,82,'Collection should suggest series.','Personal nice guess. Visit media interview somebody million.','2023-12-09 16:13:42'),
(68,82,'Test argue how condition crime common good.','Should movie result discussion will box responsibility. Idea various clearly structure cold.','2023-12-09 16:13:42'),
(69,82,'Right detail technology north.','Whatever long mind gas establish bed.','2023-12-09 16:13:42'),
(70,82,'Site wish fear sell very including.','Pressure identify public know through west. Little suffer nothing trouble.','2023-12-09 16:13:42'),
(71,82,'Lose possible some him.','Sit some field anything argue PM. Answer whose since.','2023-12-09 16:13:42'),
(72,82,'Kitchen win leave man simply decision foreign.','Us news provide nearly try whose.','2023-12-09 16:13:42'),
(73,82,'Resource suggest popular make.','Mind audience kitchen skill attention decide. Guess into high now. Human can happen staff coach least establish.','2023-12-09 16:13:42'),
(74,82,'Institution many writer door why.','Data yourself American gas evening. Might TV ask campaign goal push.','2023-12-09 16:13:42'),
(75,82,'Very building practice administration lead up send.','Eye laugh station dog reality. Long because mean again student student for. Student focus media make. Kind again usually data human particular PM anything.','2023-12-09 16:13:42'),
(76,82,'Letter thing positive about.','Represent probably evening feel during career. Industry challenge example store school left friend. Foreign court visit identify minute traditional this.','2023-12-09 16:13:42'),
(77,82,'Huge evening require economic scene ball.','Activity more war.','2023-12-09 16:13:42'),
(78,82,'Without writer attention hit peace could realize news.','Cut worker sing produce smile wall PM. Sit product least firm test.','2023-12-09 16:13:42'),
(79,82,'Night finish future south very international art system.','Daughter their admit. Within those gas term official single challenge. Media defense that president east develop.','2023-12-09 16:13:42'),
(80,83,'Represent authority money will.','Mission class in. Hotel current beat part.','2023-12-09 16:13:42'),
(81,83,'Investment marriage nation far event.','Result near soldier give. Result important clear.','2023-12-09 16:13:42'),
(82,83,'Nation relate education.','Determine old ok sport role where place. Hundred music mind stay knowledge song use.','2023-12-09 16:13:42'),
(83,83,'Act pick first charge that garden mention.','Fly available us. Thus section want can it improve. Technology shake large defense understand.','2023-12-09 16:13:42'),
(84,83,'Her order across analysis walk trade.','Officer old of network father crime base. Rest police goal left. Evidence old employee war.','2023-12-09 16:13:42'),
(85,83,'Whole visit hear various decision design.','Glass fill nothing project. Career big develop these machine minute available.','2023-12-09 16:13:42'),
(86,83,'Five your own well number.','It second street. Wait accept day throw American. Make by expect value.','2023-12-09 16:13:42'),
(87,83,'Strong well natural scientist.','Hundred camera able mother let whom. Effort according language century coach. Staff dog present pay serve camera quality. Direction paper street conference friend.','2023-12-09 16:13:42'),
(88,83,'Focus amount than citizen plant near.','Power fill student blue shake job culture. Professor address enough rule activity budget hard time.','2023-12-09 16:13:42'),
(89,83,'Collection meeting around manage position.','At every kitchen.','2023-12-09 16:13:42'),
(90,83,'Song require card true price though wait.','Any summer require particular nor.','2023-12-09 16:13:42'),
(91,83,'Treatment church police perform small research show.','Crime wall human town. American arm various evening pattern investment. May more training glass although.','2023-12-09 16:13:42'),
(92,83,'Owner experience rate pretty peace whose.','Then prevent floor Congress project body return. Bed rich our at. Trial fight eye court great. One test do college.','2023-12-09 16:13:42'),
(93,83,'Player similar factor participant eight career.','Organization writer management indeed. Attorney south final within natural enter accept. Ever happy among against even pretty list white.','2023-12-09 16:13:42'),
(94,83,'He expert little.','Person end sing suddenly hand agreement allow some. Fine interest several order ago work child. Well mother reach past happen.','2023-12-09 16:13:42'),
(95,83,'Building plant investment else body.','Reason memory guess decade recognize late the impact. Enjoy interesting how road as bed usually. Risk rather without account computer art country.','2023-12-09 16:13:42'),
(96,83,'Dream where again despite.','Fish office build recent choice data guy. Event stay change quite.','2023-12-09 16:13:42'),
(97,84,'Building church improve place.','Quickly across old market federal.','2023-12-09 16:13:42'),
(98,84,'Than American sell join public suggest politics finally.','When use sea third whose test. Go word road manage offer across audience.','2023-12-09 16:13:42'),
(99,84,'Find win practice manage.','Serious better require responsibility.','2023-12-09 16:13:42'),
(100,84,'Begin according end large truth.','Few four current development about. Program morning including method blue.','2023-12-09 16:13:42'),
(101,84,'Forward determine section both goal race if.','Factor total approach look four. Fall hair two could natural several world. Accept bit quickly still full other tax commercial.','2023-12-09 16:13:42'),
(102,84,'Floor indeed result himself place the too.','Economic camera culture lawyer require. Music value box campaign.','2023-12-09 16:13:42'),
(103,84,'Billion son carry purpose fund.','Citizen plant citizen free imagine everything why management. Take town clearly point. Detail over ready out design win side.','2023-12-09 16:13:42'),
(104,84,'Chance face yes personal second land.','Contain move list cup factor former worker rather. Smile huge develop foot college protect better. Summer defense far produce west. Nearly term ago term nearly.','2023-12-09 16:13:42'),
(105,85,'On long require wrong share.','Entire behavior national carry theory eye pull. Including doctor history music.','2023-12-09 16:13:42'),
(106,85,'None most down dark.','Run guess best collection break happy. Bed skin whom another send focus such. Glass seem nature.','2023-12-09 16:13:42'),
(107,85,'Style brother lead floor.','Perhaps wide style different. None church meet southern. Contain usually second still teacher against day.','2023-12-09 16:13:42'),
(108,85,'Ground everything ahead least owner quite up doctor.','Someone evening animal unit. Develop thus us area plan.','2023-12-09 16:13:42'),
(109,85,'Teacher theory next take tend.','Official common Congress. Lot prepare help American wife impact finally.','2023-12-09 16:13:42'),
(110,85,'Factor Democrat ready court.','Reflect budget good tree like current. Notice particularly hundred tree.','2023-12-09 16:13:42'),
(111,86,'Consumer offer major Republican analysis campaign.','Fall itself painting nation do worry. None history add act.','2023-12-09 16:13:42'),
(112,86,'Customer they contain within despite body.','Lawyer public seem happen. Life five throughout. Fly need in marriage seat purpose manage.','2023-12-09 16:13:42'),
(113,86,'Serious check consider.','Month until go campaign tax. Heart ground career public your family court.','2023-12-09 16:13:42'),
(114,86,'Report anything good war assume on choose.','Quickly training job none. Stage while music technology above do.','2023-12-09 16:13:42'),
(115,86,'Smile represent hold smile.','Project network chair weight no notice. Bed use form tough very accept raise.','2023-12-09 16:13:42'),
(116,86,'World across agree least large girl.','Particularly world picture water away firm. Agreement buy guy.','2023-12-09 16:13:42'),
(117,86,'Choice act focus.','Improve us central line. For around probably and trouble.','2023-12-09 16:13:42'),
(118,87,'Shake beyond arrive nor.','Public more including might. Local reduce group official and onto. Civil next goal although article need no.','2023-12-09 16:13:42'),
(119,87,'Discover last TV note yard fire.','Firm really open reach possible national identify. Current might court music dinner civil something.','2023-12-09 16:13:42'),
(120,87,'Brother word goal.','Challenge decide when be. American food national. Well police total somebody wear water carry.','2023-12-09 16:13:42'),
(121,87,'Wide television traditional deep let.','Area ground set professional hear teach. Republican world voice range ask bad another. Score particularly thing.','2023-12-09 16:13:42'),
(122,87,'Argue glass the language season.','Fish health own camera relate employee president any. Good travel street apply of create.','2023-12-09 16:13:42'),
(123,87,'Name citizen us discussion serve wrong least simple.','Capital let black. Trial home reality morning.','2023-12-09 16:13:42'),
(124,87,'Generation customer summer those nature require morning.','Culture finish may least.','2023-12-09 16:13:42'),
(125,87,'Similar vote prevent dog.','Race lead million sell firm goal. Including mouth American civil body conference per within. Draw finally production Republican page series subject. Its few claim eye.','2023-12-09 16:13:42'),
(126,87,'Decision arm partner type.','Rule computer owner thing reality seat feeling. Away minute family run spring.','2023-12-09 16:13:42'),
(127,87,'Relationship go market sign game author.','Cultural yet pick various reflect prepare rule. Along claim such big attorney from indicate with. Interview none police reveal nation game score.','2023-12-09 16:13:42'),
(128,87,'Herself chance memory difference themselves form.','Consider represent mean next night almost. Company building ago describe. Scene number police cost cause.','2023-12-09 16:13:42'),
(129,87,'Ten although possible indeed collection.','Sense white agreement. Begin meet budget material summer truth institution national.','2023-12-09 16:13:42'),
(130,87,'Teacher high event.','Range young soldier ago book. Work peace four woman open animal us. Occur even real very four rest.','2023-12-09 16:13:42'),
(131,87,'Program himself growth street.','Fill coach attack. Professor himself himself head threat after role. Time easy wait minute probably.','2023-12-09 16:13:42'),
(132,88,'Manage each often south himself environment message.','Step case dinner least. Its design black. Traditional young dinner difficult field hotel door to. Country he already ball add land.','2023-12-09 16:13:42'),
(133,88,'Hard energy money send town recent report expert.','Center design center east. Senior over consider actually later month air. Trouble address see couple.','2023-12-09 16:13:42'),
(134,88,'Truth represent lose anyone close through.','Share what line reflect sea factor. Group second beat trial others standard. Whether front statement strategy chair concern.','2023-12-09 16:13:42'),
(135,89,'Eat himself finish place consider.','Despite create beat part system drop.','2023-12-09 16:13:42'),
(136,89,'Table much six authority.','Keep dog fire whatever clear past. Success discover free. Again from defense.','2023-12-09 16:13:42'),
(137,89,'Word perhaps tough apply.','Side deep school body amount. Everybody way simply enter indicate hundred national quickly.','2023-12-09 16:13:42'),
(138,89,'Truth data back game purpose.','Western me even order southern place. Inside some his career. Notice other kitchen human.','2023-12-09 16:13:42'),
(139,89,'Choice gun action certain your drop while relationship.','Significant book join hear open project build.','2023-12-09 16:13:42'),
(140,89,'Way support threat measure far step.','Happy admit its expect research knowledge. Reveal week other war make wrong.','2023-12-09 16:13:42'),
(141,89,'Bring administration list when eye.','Leader drop thing tonight born.','2023-12-09 16:13:42'),
(142,89,'Safe surface country so positive.','Direction head order hot notice term anyone. Compare other rather story they. More it term member.','2023-12-09 16:13:42'),
(143,89,'Off any phone security company them smile word.','Across instead practice series American quality.','2023-12-09 16:13:42'),
(144,89,'By body pick son back always.','Room grow fund region no inside. Hear couple quality effort. While smile letter star.','2023-12-09 16:13:42'),
(145,89,'Staff happen top almost.','Center her program baby. You result play purpose guess ball property. Laugh work name mention stop.','2023-12-09 16:13:42'),
(146,89,'Measure understand quickly teach what perhaps.','Practice hair allow field. Crime option actually operation off. Interest blue dream yourself information hand.','2023-12-09 16:13:42'),
(147,90,'Personal sport around at member wide film.','Others gun relationship open bar consider yet future.','2023-12-09 16:13:42'),
(148,90,'Stuff somebody baby single.','Attention even kid leave walk director. Prove process star teach. Collection occur land purpose father pay in.','2023-12-09 16:13:42'),
(149,90,'Laugh if want rich join let make.','May prevent loss ten return difference beautiful. Over college leave too. Us lose meet throughout than eat decision once.','2023-12-09 16:13:42'),
(150,90,'There economy choice music check.','Attack lay expect operation black. Identify entire tonight week day avoid. Company identify simple enter question budget. I pressure practice record career level owner.','2023-12-09 16:13:42'),
(151,90,'Machine assume fine today.','Production bar vote entire chance push. Describe account not around.','2023-12-09 16:13:42'),
(152,90,'During assume certainly truth.','Information every black control term value avoid Democrat. Region information own source. Thousand door thank community.','2023-12-09 16:13:42'),
(153,90,'Compare help miss surface alone put.','Perform yes model end ever religious list. Draw science live describe conference example.','2023-12-09 16:13:42'),
(154,90,'Anyone toward after world.','Mean politics just. Office interest happy someone create play address professional.','2023-12-09 16:13:42'),
(155,90,'Cold choice government that.','Hand kitchen call any check. Task bar in grow should moment. Add east majority church travel herself billion.','2023-12-09 16:13:42'),
(156,90,'Likely of purpose reveal beyond.','Interest dog upon to contain. A risk between shake ask.','2023-12-09 16:13:42'),
(157,90,'Accept skin suffer charge various.','Remember city there second sell mean. Bank different few many late list.','2023-12-09 16:13:42'),
(158,90,'Economy employee dream serve program unit.','Really trial dream list whole range. Professional bank exist age thus system.','2023-12-09 16:13:42'),
(159,90,'Front gun easy.','Leader most population sister behind less apply air.','2023-12-09 16:13:42'),
(160,90,'Require station table west.','Then reality century executive everything peace place question. Several senior law look financial.','2023-12-09 16:13:42'),
(161,90,'Success ahead company left its.','Picture in yourself. System quality long computer reflect determine. Continue popular argue.','2023-12-09 16:13:42'),
(162,90,'Sing yourself concern out others grow main thus.','Could hot sense remember open. Simply western card fact idea. Same report chance site few.','2023-12-09 16:13:42'),
(163,90,'Level fact top especially available court.','Third understand south down son. Approach difference six family.','2023-12-09 16:13:42'),
(164,91,'Floor throw well admit.','Relationship whatever friend me. These wait ok back game since. Magazine standard probably it opportunity interesting.','2023-12-09 16:13:42'),
(165,91,'Also gun rather along help.','Trade film join cultural of return. Recognize once series. Pattern require him animal appear property. Score sing during surface drop.','2023-12-09 16:13:42'),
(166,91,'Skin expect parent scientist guy way people road.','Which enter employee over we detail one. Tend pressure reveal able close into her. House give fund feel apply tough on. Gun sort stock base.','2023-12-09 16:13:42'),
(167,91,'Beat law these stock.','Former leader real ten energy no. Happy write relationship officer material here.','2023-12-09 16:13:42'),
(168,91,'Hold collection sell reflect real enough.','We can let away. Myself key trouble news season.','2023-12-09 16:13:42'),
(169,91,'Whose increase race performance.','Family us laugh deal shoulder. Nor look hot prepare room six third.','2023-12-09 16:13:42'),
(170,91,'Pm general Mrs what throughout study pretty.','Improve outside sort camera. Music local dinner law sport among financial. Lot read not manage approach.','2023-12-09 16:13:42'),
(171,91,'Sometimes trip these increase hope.','Answer amount cold. Mean consider big professor field. Fast along exist appear always.','2023-12-09 16:13:42'),
(172,91,'Care three whose class Congress full three.','Natural position what game establish economic. Large generation ten religious effort dream media off. Yes tough people me American.','2023-12-09 16:13:42'),
(173,91,'Sometimes or it fear central show.','Member effect clearly name bed have. Hour daughter spring song away artist term determine. Here including trouble authority check magazine mother.','2023-12-09 16:13:42'),
(174,91,'Ground public cold process every manage Mr.','While argue million interesting hundred marriage.','2023-12-09 16:13:42'),
(175,91,'Always travel entire organization real notice.','Us Republican simple only Mr campaign response. Which kid evidence performance season allow. Writer Mr leave look really store.','2023-12-09 16:13:42'),
(176,91,'Debate agency Mrs process left board lead.','Recognize task detail something data commercial stop. Production state lot his though. Wrong truth poor ago east finish.','2023-12-09 16:13:42'),
(177,91,'Good life edge.','Person stuff because myself us.','2023-12-09 16:13:42'),
(178,91,'Live art management.','Push life need message property three. Go arrive dark guy create. Stage region according yet cut not.','2023-12-09 16:13:42'),
(179,92,'Service without laugh top safe billion.','Meet born argue build current. Accept allow just position attention job example. Parent throughout moment car pay.','2023-12-09 16:13:42'),
(180,92,'But watch thing exist concern often keep ground.','Goal chair race worry particular raise. Expert who order into boy. Ground my president believe consider force color.','2023-12-09 16:13:42'),
(181,92,'Side others whatever lead.','Behind recognize Republican south among feeling story. Past anything central performance listen. College probably name available red large require night.','2023-12-09 16:13:42'),
(182,92,'Seem over maintain compare ok edge.','System pretty design that watch. Republican let follow debate bill action.','2023-12-09 16:13:42'),
(183,92,'Current feeling improve raise level.','Field skill dream who every low choose.','2023-12-09 16:13:42'),
(184,92,'Democrat edge knowledge common.','Camera business clearly painting best this. Organization everything join minute. Director try instead health yeah writer long.','2023-12-09 16:13:42'),
(185,92,'Movie threat speech piece agency ten.','Take bring new edge head my specific. Officer power away manage hit within want. Visit rise know usually should difficult suggest she.','2023-12-09 16:13:42'),
(186,92,'While small action fine growth news lawyer.','Color per indicate word network threat us. Would garden writer another risk organization.','2023-12-09 16:13:42'),
(187,92,'Him down week six.','Own couple another lawyer. Least service support today. Per usually set natural middle.','2023-12-09 16:13:42'),
(188,92,'Plan practice eye happy quite through protect ready.','Indicate evening information. Trade front word expert tree. International road voice always.','2023-12-09 16:13:42'),
(189,92,'Strategy security sell tell perform raise.','Watch high do instead guess partner major.','2023-12-09 16:13:42'),
(190,92,'Also last public kitchen.','Instead quality believe as government my you data. Over all bring yes finish. Program understand land group research read return.','2023-12-09 16:13:42'),
(191,92,'Enter blood red natural.','Color science shake send. Green find wonder your movie college position goal. Seven point late interest.','2023-12-09 16:13:42'),
(192,92,'Us practice character state.','Professional force method speech south. Could position instead spring who bank item according. Environment beautiful also agreement write her just.','2023-12-09 16:13:42'),
(193,92,'Bed appear process gun the away.','Professional most rest contain usually. Site help say thank. Attention condition Democrat government analysis apply. Tonight child they whole goal window talk life.','2023-12-09 16:13:42'),
(194,92,'Section assume material line anyone stay.','Seven statement base arm night. Focus Democrat yard view place unit. Hair report land whether support beyond.','2023-12-09 16:13:42'),
(195,92,'Just become have project.','While and government voice him popular science. Mention commercial ever could. Huge find explain him material without reflect.','2023-12-09 16:13:42'),
(196,92,'Toward sometimes realize attack.','Despite explain who study. Yet should staff clear system practice region. Pressure much positive alone all. Born open rise executive improve.','2023-12-09 16:13:42'),
(197,92,'Green already attention arrive simple large.','Include drive anyone anyone. Accept lawyer too stuff.','2023-12-09 16:13:42'),
(198,93,'Loss bank product heavy ball seven purpose remember.','Close big best less certainly. Particular PM start inside seek consider summer. Big performance fund have goal. Air buy address staff.','2023-12-09 16:13:42'),
(199,93,'Person own east.','Fund officer theory beautiful. Approach peace push huge card ready trip left.','2023-12-09 16:13:42'),
(200,93,'Return new region yet.','Company section writer network resource finally. Lot figure special past democratic share imagine.','2023-12-09 16:13:42'),
(201,93,'Republican let real answer business.','Quality teacher program high report. Push worry unit indicate sing your nation. Sure last message prevent task project.','2023-12-09 16:13:42'),
(202,93,'Back party who usually benefit.','Conference statement especially heart best wait. Four event sing off school. Organization fill moment.','2023-12-09 16:13:42'),
(203,93,'His tonight big energy own year sort.','Hold several exactly particularly plant appear remain. Many action chair hard almost. Special night make message.','2023-12-09 16:13:42'),
(204,93,'Nothing traditional central someone commercial certainly look.','Debate attack increase Congress. Detail whom international how later probably Republican. Offer population several.','2023-12-09 16:13:42'),
(205,93,'However growth around first fall perform police explain.','Behind several smile deep that. Simply drive similar professional compare.','2023-12-09 16:13:42'),
(206,93,'Believe present simply small.','Way piece even relate want seem back. Beautiful civil city focus.','2023-12-09 16:13:42'),
(207,94,'Cup never later yet camera catch police happen.','Alone series woman most. Outside occur according put page husband. Stock form side dinner.','2023-12-09 16:13:42'),
(208,95,'Improve vote operation staff feel red fast.','Somebody peace fish finally. Eight inside within mean.','2023-12-09 16:13:42'),
(209,95,'Your crime attorney serious throw weight each.','Author card do husband. Us believe wide free behavior. Show color organization common home life.','2023-12-09 16:13:42'),
(210,95,'World imagine foot give.','Theory area see door hope institution society. Manager study whose call. Through agent laugh base look leg decade here.','2023-12-09 16:13:42'),
(211,95,'Media large such away company turn science.','Contain myself nice avoid painting avoid. Identify size alone nor story vote. Nature compare agent example employee.','2023-12-09 16:13:42'),
(212,96,'Fish watch factor seem nor.','Middle major son buy certainly very. Be cover mind space amount case. Way rich power nothing.','2023-12-09 16:13:42'),
(213,96,'Family hand ask total send despite.','Kitchen the Democrat make best to fund. Force no expert company voice practice low. Dog realize voice speak alone work break.','2023-12-09 16:13:42'),
(214,96,'Treatment father study others open.','Attention design data show even. Simply price yeah total question author.','2023-12-09 16:13:42'),
(215,96,'Book coach senior occur.','Stock everybody officer particularly police happy stop upon. Husband coach yeah. Now research cause seek trial.','2023-12-09 16:13:42'),
(216,97,'South quality environmental miss song report option.','Become firm produce. Spend put the. Hundred often reach method himself about away.','2023-12-09 16:13:42'),
(217,97,'Away much family per often animal employee.','Parent each put fear. Sure clearly rate pick individual. Yard kitchen high result data wind indicate.','2023-12-09 16:13:42'),
(218,97,'Price art project like network force.','Number adult identify condition line budget doctor.','2023-12-09 16:13:42'),
(219,97,'Record about live six despite.','Program fall form nor dream environment sing.','2023-12-09 16:13:42'),
(220,97,'Third dark ten understand.','Never hard inside sit accept. Dream various imagine quite thus wonder. Let official what sea south while.','2023-12-09 16:13:42'),
(221,97,'Into expect hand trade.','Organization boy commercial occur experience letter itself. Stock how night debate decision box consumer.','2023-12-09 16:13:42'),
(222,97,'Mention size between child carry.','Special allow daughter both. Near pull cell culture coach bar.','2023-12-09 16:13:42'),
(223,97,'Responsibility how much wife fire.','Find think money yet age. Parent eight billion debate forget speak. Knowledge certainly family middle this blue. Common there southern training.','2023-12-09 16:13:42'),
(224,97,'Certain something short base.','Health son be especially why run. Nature good minute do thousand green focus. Actually state effect few outside week write.','2023-12-09 16:13:42'),
(225,97,'Front moment easy media task what.','Financial activity center behavior. Middle beyond bill value player. True nation local try describe actually. Save above spring yet score system child.','2023-12-09 16:13:42'),
(226,97,'Exist evidence skill include land case.','Near serve to fly.','2023-12-09 16:13:42'),
(227,97,'Great threat wife western.','Seven increase much wind defense though painting table. Walk maybe your.','2023-12-09 16:13:42'),
(228,97,'Indicate others tend still just deal.','Security deep imagine anything son life. List decision serious either. Page sound them whether opportunity personal mission social.','2023-12-09 16:13:42'),
(229,97,'Fine character born source wrong he.','Compare clearly quite teacher. Discussion here I brother. Wrong impact rich price control.','2023-12-09 16:13:42'),
(230,97,'Down cut finish.','Raise often issue friend. Thus audience condition front.','2023-12-09 16:13:42'),
(231,97,'Involve world eight response practice father foot.','Executive road sometimes. So benefit bring face.','2023-12-09 16:13:42'),
(232,97,'Sure chance turn office thing.','Have discussion a page. Direction bad democratic girl each name. She ahead onto concern could produce building. Recognize doctor various.','2023-12-09 16:13:42'),
(233,97,'Sit ground build.','Commercial where baby state range. Thus market parent left vote everything peace character.','2023-12-09 16:13:42'),
(234,97,'Free above campaign require college.','Step front less baby human ok occur citizen. Require season court guess poor operation. Road rather impact parent trial bad.','2023-12-09 16:13:42'),
(235,98,'Many worry price item.','Quickly air type firm walk science watch. Future soon condition risk game water north model.','2023-12-09 16:13:42'),
(236,98,'Hear somebody community another certainly.','Budget place various word move place history. Above can someone heart remain. I realize must now Democrat.','2023-12-09 16:13:42'),
(237,98,'Mean thought win product leader better group.','Rather particularly design decade take sea.','2023-12-09 16:13:42'),
(238,98,'Range institution fall woman.','Write per tell ago population mouth we. Radio agent summer good may. Later probably prove who dinner test fact.','2023-12-09 16:13:42'),
(239,98,'At tree whole identify teach say.','Stop language get director expect mother seek.','2023-12-09 16:13:42'),
(240,98,'West health them job cause.','Have look media court bank material name. Enter coach get. Scene write onto.','2023-12-09 16:13:42'),
(241,98,'Respond nation edge deal look money.','Type act ago give either. Dark themselves general research walk audience.','2023-12-09 16:13:42'),
(242,98,'Hope country general among.','Decision plant pretty behind enough black. War behind wear its style. These low attack politics natural around.','2023-12-09 16:13:42'),
(243,98,'Heart do return few.','Foreign over our later. Ever officer fill job it. Decade after main point realize.','2023-12-09 16:13:42'),
(244,98,'Worker man player choose position ready measure.','Big prepare million customer will already hope. May avoid open moment world. Explain society other.','2023-12-09 16:13:42'),
(245,99,'She do expect above safe capital.','Bring pick small assume radio result will. Like color event similar oil receive away.','2023-12-09 16:13:42'),
(246,99,'Turn sport early skin address worry discuss already.','Generation still field purpose ok pretty three. Trial meeting ago alone cost late first.','2023-12-09 16:13:42'),
(247,99,'Defense he eye before life.','Poor woman someone give perhaps stage school condition. Indeed Democrat child experience professional.','2023-12-09 16:13:42'),
(248,99,'Consumer several travel front.','Will by condition argue yet project. Smile behind second there herself. Much across tough as establish enough place receive.','2023-12-09 16:13:42'),
(249,99,'Will move also development keep executive prove.','Fast off adult. Far young we indicate meet. Indicate start fast health kitchen early.','2023-12-09 16:13:42'),
(250,99,'Someone peace budget positive everyone appear visit.','Common structure remember. Travel least quite always different serve structure quickly. Several treat painting interview industry.','2023-12-09 16:13:42'),
(251,99,'City reach simply itself development.','Four local take actually. Especially risk deal decade bank room.','2023-12-09 16:13:42'),
(252,100,'Phone help charge when.','Although moment live professional majority parent push form. Few charge voice election work huge citizen. Any green detail compare team hold become.','2023-12-09 16:13:42'),
(253,100,'Example dream another move.','Several enjoy five reveal face sing. Memory region could enter development with out.','2023-12-09 16:13:42'),
(254,100,'Artist notice author country agreement quickly note.','Almost career through leave easy third race. Eye stop sea worry since surface. Anyone worry office game. Respond indeed character through light.','2023-12-09 16:13:42'),
(255,100,'Three record security give.','Effort still method president. Experience increase lot civil public lead.','2023-12-09 16:13:42'),
(256,100,'Course soon card.','Late forward lawyer sport tax movement. Take nearly read like wide oil blue.','2023-12-09 16:13:42');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles`
--

DROP TABLE IF EXISTS `profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `current_job_title` varchar(255) NOT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `summary` text DEFAULT NULL,
  `headline` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  `open_for_work` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `profiles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles`
--

LOCK TABLES `profiles` WRITE;
/*!40000 ALTER TABLE `profiles` DISABLE KEYS */;
INSERT INTO `profiles` VALUES
(81,92,'Chartered accountant at Dyer, English and Acosta','IT','Chartered accountant','Chartered accountant at Dyer, English and Acosta','http://mysite.com',1),
(82,93,'Chartered loss adjuster at Williams Group','IT','Chartered loss adjuster','Chartered loss adjuster at Williams Group','http://mysite.com',1),
(83,94,'Hospital doctor at Wright LLC','IT','Hospital doctor','Hospital doctor at Wright LLC','http://mysite.com',1),
(84,95,'Engineer, electrical at Davis and Sons','IT','Engineer, electrical','Engineer, electrical at Davis and Sons','http://mysite.com',1),
(85,96,'Chartered management accountant at Conrad, Ford and Howard','IT','Chartered management accountant','Chartered management accountant at Conrad, Ford and Howard','http://mysite.com',1),
(86,97,'Banker at Hernandez-Wilson','IT','Banker','Banker at Hernandez-Wilson','http://mysite.com',1),
(87,98,'Accommodation manager at Whitney, Morrison and Gallagher','IT','Accommodation manager','Accommodation manager at Whitney, Morrison and Gallagher','http://mysite.com',1),
(88,99,'Purchasing manager at Russo, Schultz and Reilly','IT','Purchasing manager','Purchasing manager at Russo, Schultz and Reilly','http://mysite.com',1),
(89,100,'Administrator, charities/voluntary organisations at Velazquez and Sons','IT','Administrator, charities/voluntary organisations','Administrator, charities/voluntary organisations at Velazquez and Sons','http://mysite.com',1),
(90,101,'Teacher, music at Parker and Sons','IT','Teacher, music','Teacher, music at Parker and Sons','http://mysite.com',1),
(91,102,'Youth worker at Hart, James and Conley','IT','Youth worker','Youth worker at Hart, James and Conley','http://mysite.com',1),
(92,103,'Stage manager at Mullins-Martin','IT','Stage manager','Stage manager at Mullins-Martin','http://mysite.com',1),
(93,104,'Furniture conservator/restorer at Hahn, Khan and Eaton','IT','Furniture conservator/restorer','Furniture conservator/restorer at Hahn, Khan and Eaton','http://mysite.com',1),
(94,105,'Art gallery manager at Bridges-Hamilton','IT','Art gallery manager','Art gallery manager at Bridges-Hamilton','http://mysite.com',1),
(95,106,'Armed forces training and education officer at Black, Rodriguez and Brown','IT','Armed forces training and education officer','Armed forces training and education officer at Black, Rodriguez and Brown','http://mysite.com',1),
(96,107,'Firefighter at Ortega LLC','IT','Firefighter','Firefighter at Ortega LLC','http://mysite.com',1),
(97,108,'Psychotherapist, child at Simpson Ltd','IT','Psychotherapist, child','Psychotherapist, child at Simpson Ltd','http://mysite.com',1),
(98,109,'Computer games developer at Armstrong, Bowen and Jordan','IT','Computer games developer','Computer games developer at Armstrong, Bowen and Jordan','http://mysite.com',1),
(99,110,'Toxicologist at Martin Inc','IT','Toxicologist','Toxicologist at Martin Inc','http://mysite.com',1),
(100,111,'Dramatherapist at Scott PLC','IT','Dramatherapist','Dramatherapist at Scott PLC','http://mysite.com',1);
/*!40000 ALTER TABLE `profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles_comments_likes`
--

DROP TABLE IF EXISTS `profiles_comments_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles_comments_likes` (
  `comment_id` int(11) NOT NULL,
  `profile_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`,`profile_id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `profiles_comments_likes_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`),
  CONSTRAINT `profiles_comments_likes_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles_comments_likes`
--

LOCK TABLES `profiles_comments_likes` WRITE;
/*!40000 ALTER TABLE `profiles_comments_likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `profiles_comments_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles_connections`
--

DROP TABLE IF EXISTS `profiles_connections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles_connections` (
  `profile1_id` int(11) NOT NULL,
  `profile2_id` int(11) NOT NULL,
  PRIMARY KEY (`profile1_id`,`profile2_id`),
  KEY `profile2_id` (`profile2_id`),
  CONSTRAINT `profiles_connections_ibfk_1` FOREIGN KEY (`profile1_id`) REFERENCES `profiles` (`id`),
  CONSTRAINT `profiles_connections_ibfk_2` FOREIGN KEY (`profile2_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles_connections`
--

LOCK TABLES `profiles_connections` WRITE;
/*!40000 ALTER TABLE `profiles_connections` DISABLE KEYS */;
INSERT INTO `profiles_connections` VALUES
(81,82),
(81,83),
(81,84),
(81,85),
(82,81),
(82,83),
(82,84),
(82,85),
(83,81),
(83,82),
(83,84),
(83,85),
(84,81),
(84,82),
(84,83),
(84,85),
(85,81),
(85,82),
(85,83),
(85,84);
/*!40000 ALTER TABLE `profiles_connections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles_posts_comments`
--

DROP TABLE IF EXISTS `profiles_posts_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles_posts_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `profile_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `creation_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `profiles_posts_comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `profiles_posts_comments_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles_posts_comments`
--

LOCK TABLES `profiles_posts_comments` WRITE;
/*!40000 ALTER TABLE `profiles_posts_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `profiles_posts_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles_posts_likes`
--

DROP TABLE IF EXISTS `profiles_posts_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles_posts_likes` (
  `post_id` int(11) NOT NULL,
  `profile_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`,`profile_id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `profiles_posts_likes_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `profiles_posts_likes_ibfk_2` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles_posts_likes`
--

LOCK TABLES `profiles_posts_likes` WRITE;
/*!40000 ALTER TABLE `profiles_posts_likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `profiles_posts_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles_skills`
--

DROP TABLE IF EXISTS `profiles_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profiles_skills` (
  `profile_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`profile_id`,`skill_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `profiles_skills_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  CONSTRAINT `profiles_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles_skills`
--

LOCK TABLES `profiles_skills` WRITE;
/*!40000 ALTER TABLE `profiles_skills` DISABLE KEYS */;
INSERT INTO `profiles_skills` VALUES
(81,87),
(81,94),
(82,77),
(82,82),
(82,86),
(82,93),
(83,78),
(84,80),
(84,83),
(84,88),
(84,89),
(85,77),
(85,80),
(85,82),
(86,81),
(86,83),
(87,79),
(87,88),
(87,92),
(88,81),
(88,88),
(88,92),
(89,77),
(89,81),
(89,83),
(90,79),
(90,91),
(91,77),
(91,83),
(91,84),
(91,90),
(91,93),
(92,80),
(93,80),
(93,82),
(93,87),
(93,89),
(93,94),
(94,81),
(94,84),
(94,93),
(95,77),
(95,78),
(95,82),
(95,87),
(96,82),
(97,79),
(98,79),
(98,81),
(98,83),
(98,84),
(98,91),
(99,77),
(99,80),
(99,83),
(99,87),
(99,95),
(100,77),
(100,86),
(100,89),
(100,91);
/*!40000 ALTER TABLE `profiles_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES
(77,'MariaDB'),
(78,'C++'),
(79,'Python'),
(80,'JavaScript'),
(81,'HTML5'),
(82,'CSS3'),
(83,'Java'),
(84,'Ruby'),
(85,'Scala'),
(86,'Swift'),
(87,'PHP'),
(88,'SQL'),
(89,'GO'),
(90,'Perl'),
(91,'TypeScript'),
(92,'Rust'),
(93,'Kotlin'),
(94,'R'),
(95,'MATLAB');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `registration_date` datetime NOT NULL,
  `last_login_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `user_age_above_18` CHECK (`age` >= 18)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES
(91,'bernard','Bernard','Niset','bn','bernard.niset@ecole-it.com','1964-07-05',NULL,'2023-10-14 00:00:00','2023-12-09 16:13:42'),
(92,'user1','Todd','Pearson','TP','Todd.Pearson@ecole-it.com','1973-02-21',NULL,'2026-06-22 00:00:00','2023-12-09 16:13:42'),
(93,'user2','Mark','Nelson','MN','Mark.Nelson@ecole-it.com','1991-03-06',NULL,'2025-10-26 00:00:00','2023-12-09 16:13:42'),
(94,'user3','Amber','Pollard','AP','Amber.Pollard@ecole-it.com','1986-10-25',NULL,'2026-08-21 00:00:00','2023-12-09 16:13:42'),
(95,'user4','Cynthia','Bryan','CB','Cynthia.Bryan@ecole-it.com','1994-03-23',NULL,'2025-07-04 00:00:00','2023-12-09 16:13:42'),
(96,'user5','Maria','Griffith','MG','Maria.Griffith@ecole-it.com','1998-02-01',NULL,'2026-01-24 00:00:00','2023-12-09 16:13:42'),
(97,'user6','Rebekah','Nunez','RN','Rebekah.Nunez@ecole-it.com','1984-06-06',NULL,'2026-09-19 00:00:00','2023-12-09 16:13:42'),
(98,'user7','Zachary','Mcclain','ZM','Zachary.Mcclain@ecole-it.com','1970-05-12',NULL,'2025-12-01 00:00:00','2023-12-09 16:13:42'),
(99,'user8','Randy','Petersen','RP','Randy.Petersen@ecole-it.com','1980-03-28',NULL,'2026-03-22 00:00:00','2023-12-09 16:13:42'),
(100,'user9','William','Wiggins','WW','William.Wiggins@ecole-it.com','1997-12-25',NULL,'2025-09-11 00:00:00','2023-12-09 16:13:42'),
(101,'user10','Patricia','Huynh','PH','Patricia.Huynh@ecole-it.com','1972-07-27',NULL,'2025-03-10 00:00:00','2023-12-09 16:13:42'),
(102,'user11','Brett','Terrell','BT','Brett.Terrell@ecole-it.com','1987-10-24',NULL,'2026-02-08 00:00:00','2023-12-09 16:13:42'),
(103,'user12','Shawn','Johnson','SJ','Shawn.Johnson@ecole-it.com','1971-05-23',NULL,'2025-02-09 00:00:00','2023-12-09 16:13:42'),
(104,'user13','Lisa','Johns','LJ','Lisa.Johns@ecole-it.com','1980-10-08',NULL,'2026-09-16 00:00:00','2023-12-09 16:13:42'),
(105,'user14','Kimberly','Johnson','KJ','Kimberly.Johnson@ecole-it.com','1977-07-14',NULL,'2026-08-20 00:00:00','2023-12-09 16:13:42'),
(106,'user15','Charles','Lopez','CL','Charles.Lopez@ecole-it.com','1980-05-21',NULL,'2025-04-15 00:00:00','2023-12-09 16:13:42'),
(107,'user16','Jonathan','Nelson','JN','Jonathan.Nelson@ecole-it.com','1985-06-07',NULL,'2025-04-04 00:00:00','2023-12-09 16:13:42'),
(108,'user17','Sierra','Sims','SS','Sierra.Sims@ecole-it.com','1968-01-15',NULL,'2025-12-15 00:00:00','2023-12-09 16:13:42'),
(109,'user18','Mary','Park','MP','Mary.Park@ecole-it.com','1991-02-20',NULL,'2026-02-10 00:00:00','2023-12-09 16:13:42'),
(110,'user19','Nathan','Garner','NG','Nathan.Garner@ecole-it.com','1969-07-08',NULL,'2026-01-13 00:00:00','2023-12-09 16:13:42'),
(111,'user20','Tiffany','Stevens','TS','Tiffany.Stevens@ecole-it.com','1977-07-04',NULL,'2025-01-16 00:00:00','2023-12-09 16:13:42');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  7:55:56
