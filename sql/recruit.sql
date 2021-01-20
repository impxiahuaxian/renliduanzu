# Host: localhost  (Version: 5.5.47)
# Date: 2020-05-20 10:12:26
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

CREATE TABLE `admin` (
  `userid` bigint(20) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员信息';

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (19980208,'17812345678','9136f8f230e20ca9afc410d14c826586','管理员','babycoder@163.com');

#
# Structure for table "application"
#

CREATE TABLE `application` (
  `applicationId` int(11) NOT NULL AUTO_INCREMENT,
  `state` int(11) DEFAULT NULL,
  `recentTime` datetime DEFAULT NULL,
  `resumeId` int(11) NOT NULL,
  `positionId` int(11) NOT NULL,
  `hrId` int(11) DEFAULT NULL,
  PRIMARY KEY (`applicationId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

#
# Data for table "application"
#

INSERT INTO `application` VALUES (1,1,NULL,1,1,1),(2,1,NULL,2,5,2),(3,1,NULL,2,11,2),(4,1,NULL,2,15,3),(5,1,NULL,6,11,5),(6,1,NULL,5,3,3),(7,1,NULL,6,18,1),(8,1,NULL,4,5,1),(9,1,NULL,4,13,6),(12,0,'2020-02-26 11:32:47',24,14,NULL),(13,0,'2020-02-26 20:36:09',25,15,NULL),(14,0,'2020-02-26 21:40:03',12,16,NULL),(15,3,'2020-02-26 21:43:50',12,1,1),(16,0,'2020-02-26 22:00:23',12,2,NULL),(17,0,'2020-02-26 22:11:39',12,8,NULL),(18,0,'2020-03-11 15:32:49',12,4,NULL),(19,0,'2020-03-11 15:33:56',12,6,NULL),(20,3,'2020-03-16 13:30:14',12,1,1),(21,0,'2020-03-24 00:58:06',12,5,NULL),(22,3,'2020-03-24 00:59:49',12,10,1),(23,0,'2020-03-24 23:11:31',12,15,NULL),(24,3,'2020-03-25 23:30:47',12,10,1),(25,3,'2020-03-26 15:29:33',12,10,1),(26,3,'2020-03-26 15:47:23',12,10,1),(27,2,'2020-03-27 15:24:05',39,1,1),(28,1,'2020-04-21 20:21:36',12,19,1),(29,0,'2020-04-21 21:45:23',12,1,NULL);

#
# Structure for table "category"
#

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  `description` longtext,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `categoryName_UNIQUE` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'Java','Java开发'),(2,'C++','C++开发'),(3,'PHP','PHP开发'),(4,'.NET','.NET开发'),(5,'Python','Python开发'),(6,'数据挖掘','数据挖掘'),(7,'家政','家政'),(8,'地接导游','地接导游\r\n'),(9,'厨师粤菜','厨师粤菜'),(10,'化妆','化妆师'),(11,'开锁换锁','开锁换锁'),(12,'月嫂','月嫂');

#
# Structure for table "comment"
#

CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '分数',
  `content` longtext COMMENT '评价',
  `releaseTime` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `positionId` int(11) NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#
# Data for table "comment"
#

INSERT INTO `comment` VALUES (1,3,'C++是C语言的继承，它既可以进行C语言的过程化程序设计，又可以进行以抽象数据类型为特点的基于对象的程序设计，还可以进行以继承和多态为特点的面向对象的程序设计','2020-03-25 22:47:42',1,5),(2,2,'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念','2020-03-25 22:47:42',1,17),(3,1,'Python是纯粹的自由软件， 源代码和解释器CPython遵循 GPL(GNU General Public License)协议','2020-03-25 22:47:42',2,11),(4,3,'C++不仅拥有计算机高效运行的实用性特征，同时还致力于提高大规模程序的编程质量与程序设计语言的问题描述能力','2020-03-25 22:47:42',3,18),(5,3,'这是一些关于Java工程师的评论，这个职位需要丰富的阅历的和工作经验','2020-03-25 22:47:42',5,2),(6,2,'又要写测试评论，写点啥呢？布吉岛','2020-03-25 22:47:42',6,8),(7,3,'数据挖掘一般是指从大量的数据中通过算法搜索隐藏于其中信息的过程','2020-03-25 22:47:42',6,14),(8,3,'Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点','2020-03-25 22:47:42',6,17),(9,2,'Python 已经成为最受欢迎的程序设计语言之一','2020-03-25 22:47:42',1,10),(10,3,'<p>.NET是 Microsoft XML Web services 平台</p>','2020-03-25 22:47:42',2,9),(19,3,'IndexRecruit大透明弱弱地评论一句~','2020-03-25 22:37:26',7,13),(21,3,'学习数据挖掘小白应该从哪个方面入手？萌新小白求教~','2020-03-25 11:32:32',24,14),(23,3,'<p><span><u><b>XML Web services 允许应用程序通过 Internet 进行通讯和共享数据，而不管所采用的是哪种操作系统、设备或编程语言</b></u></span></p>','2020-03-25 21:45:42',25,9),(24,3,'<i>阿里今年双十一赚大发了。。。</i>','2020-03-25 21:56:58',25,1),(25,3,'撒爱车','2020-03-25 23:35:56',12,7),(26,3,'啥时擦拭','2020-03-25 23:45:33',12,12),(27,3,'奥术大师','2020-03-25 23:45:45',12,12),(28,2,'cascade','2020-03-25 23:59:31',12,19),(29,3,'时所产生的','2020-04-21 18:25:32',12,21),(30,3,'123123','2020-04-21 18:25:43',12,21);

#
# Structure for table "company"
#

CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) DEFAULT NULL,
  `companyLogo` int(11) DEFAULT NULL,
  `description` longtext,
  `state` int(11) DEFAULT NULL,
  `companyCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "company"
#

INSERT INTO `company` VALUES (0,'个体',0,'个体需求\n',1,'000000'),(1,'阿里巴巴',1,'阿里巴巴网络技术有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人于1999年在浙江杭州创立',1,'AL85685'),(2,'滴滴出行',2,'滴滴出行是涵盖出租车、专车、 快车、顺风车、代驾及 大巴等多项业务在内的一站式出行平台，2015年9月9日由“滴滴打车”更名而来',1,'DD36526'),(3,'搜狐媒体',3,'搜狐公司是中国领先的互联网品牌，是中国最主要的新闻提供商，搜狐的网络资产给众多用户在信息、娱乐以及交流方面提供了广泛的选择',1,'SH74524'),(4,'京东',4,'京东致力于成为一家为社会创造最大价值的公司。经过13年砥砺前行，京东在商业领域一次又一次突破创新，取得了跨越式发展',1,'JD86635'),(5,'网易',5,'网易公司（NASDAQ: NTES）是中国的互联网公司，利用互联网技术，加强人与人之间信息的交流和共享，实现“网聚人的力量”',1,'WY53265'),(6,'爱奇艺',6,'自成立伊始，爱奇艺坚持“悦享品质”的公司理念，以“用户体验”为生命，专注为用户提供清晰、流畅、界面友好的观映体验',1,'AQ86532');

#
# Structure for table "department"
#

CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(50) DEFAULT NULL,
  `description` longtext,
  `companyId` int(11) NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',1),(2,'行政部','负责行政事务和办公事务',1),(3,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',1),(4,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',2),(5,'行政部','负责行政事务和办公事务',2),(6,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',2),(7,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',3),(8,'行政部','负责行政事务和办公事务',3),(9,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',3),(10,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',4),(11,'行政部','负责行政事务和办公事务',4),(12,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',4),(13,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',5),(14,'行政部','负责行政事务和办公事务',5),(15,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',5),(16,'技术部','负责对新产品的设计和开发的控制，编制各类技术文件',6),(17,'行政部','负责行政事务和办公事务',6),(18,'市场部','对销售预测，提出未来市场的分析、发展方向和规划',6),(19,'个人','个人需求',0);

#
# Structure for table "favor"
#

CREATE TABLE `favor` (
  `favorId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `positionId` int(11) NOT NULL,
  PRIMARY KEY (`favorId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Data for table "favor"
#

INSERT INTO `favor` VALUES (1,1,16),(2,1,2),(3,1,8),(4,2,2),(5,2,15),(6,2,3),(7,2,5),(8,3,1),(9,4,6),(10,4,8),(11,4,8),(12,6,10),(13,6,11),(14,6,18),(17,24,2),(18,12,4),(19,12,11),(21,12,5),(22,39,1);

#
# Structure for table "hr"
#

CREATE TABLE `hr` (
  `hrId` int(11) NOT NULL AUTO_INCREMENT,
  `hrMobile` varchar(11) NOT NULL,
  `hrPassword` varchar(500) NOT NULL,
  `hrName` varchar(50) DEFAULT NULL,
  `hrEmail` varchar(50) DEFAULT NULL,
  `description` longtext,
  `departmentId` int(11) DEFAULT '19',
  `hrSex` varchar(255) DEFAULT NULL,
  `hrAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hrId`),
  UNIQUE KEY `mobile_UNIQUE` (`hrMobile`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "hr"
#

INSERT INTO `hr` VALUES (1,'15786586352','4QrcOUm6Wau+VuBX8g+IPg==','董一鸣','dongyiming@163.com',NULL,0,'男','123'),(2,'13685653625','e10adc3949ba59abbe56e057f20f883e','张帆','zhangfan@163.com','行政部HR',5,'男',NULL),(3,'18596475235','e10adc3949ba59abbe56e057f20f883e','李斌','libin@163.com','行政部HR',8,'男',NULL),(4,'16785253625','e10adc3949ba59abbe56e057f20f883e','王语意','wangyuyi@163.com','行政部HR',11,'男',NULL),(5,'17865253625','e10adc3949ba59abbe56e057f20f883e','李星泽','lixingze@163.com','行政部HR',14,'男',NULL),(6,'13958726395','e10adc3949ba59abbe56e057f20f883e','程瑜','chengyu@163.com','行政部HR',17,'男',NULL),(8,'18253800315','123456','牛文良','892863291@qq.com',NULL,0,'男','淄博'),(9,'18253800318','4QrcOUm6Wau+VuBX8g+IPg==','牛文良','15786586352',NULL,0,'男','王企鹅二');

#
# Structure for table "hrapplication"
#

CREATE TABLE `hrapplication` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `positionId` int(11) DEFAULT NULL,
  `hrId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `recentTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "hrapplication"
#

INSERT INTO `hrapplication` VALUES (3,18,1,1,'2020-04-21 17:46:05'),(4,21,1,1,'2020-04-21 17:46:10'),(5,1,1,1,'2020-04-21 17:46:17'),(6,19,1,1,'2020-04-21 17:46:25'),(7,18,1,1,'2020-04-21 17:50:28'),(8,21,1,12,'2020-04-21 17:55:13'),(9,21,1,12,'2020-04-21 17:55:19'),(10,18,1,1,'2020-05-14 23:39:21');

#
# Structure for table "paper"
#

CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `uid` int(11) NOT NULL,
  `data` varchar(30) DEFAULT NULL,
  `hrid` int(11) DEFAULT NULL,
  `resumeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `paper_ibfk_1` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='计划';

#
# Data for table "paper"
#

INSERT INTO `paper` VALUES (3,'33333',1,'2020-03-24 16:31',NULL,NULL),(4,'12',1,'2020-03-24 16:46',NULL,NULL),(6,'12312',1,'2020-03-24 16:51',NULL,NULL),(7,'djisdsi ',1,'2020-03-24 17:18',NULL,NULL),(8,'接口连接路口',1,'2020-03-25 16:23',NULL,NULL),(9,'撒擦擦',1,'2020-03-25 16:47',NULL,NULL),(10,'123123',1,'2020-03-25 16:56',NULL,NULL),(11,'23424',1,'2020-03-25 17:13',NULL,NULL),(12,'123123',1,'2020-03-25 17:19',NULL,NULL),(13,'33435',1,'2020-03-25 17:19',NULL,NULL),(14,'33435',1,'2020-03-25 17:21',NULL,NULL),(15,'2342434324',1,'2020-03-25 17:22',NULL,NULL),(16,'2342434324',1,'2020-03-25 17:24',NULL,NULL),(17,'2342434324',1,'2020-03-25 17:25',NULL,NULL),(18,'qwertyuiop一句情话',1,'2020-03-25 17:37',NULL,NULL),(19,'sdfsf ',1,'2020-03-25 17:38',NULL,NULL),(20,'sdfsf a',1,'2020-03-25 17:38',NULL,NULL),(21,'sdfsf a  ',1,'2020-03-25 17:42',1,1),(22,'123123123123',1,'2020-03-25 21:16',18,6),(23,'奥术大师大',1,'2020-03-25 23:39',10,12),(24,'PLAN',1,'2020-04-21 23:03',19,12);

#
# Structure for table "position"
#

CREATE TABLE `position` (
  `positionId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `requirement` longtext,
  `quantity` int(11) DEFAULT NULL,
  `workCity` varchar(50) DEFAULT NULL,
  `salaryUp` int(11) DEFAULT NULL,
  `salaryDown` int(11) DEFAULT NULL,
  `releaseDate` date DEFAULT NULL,
  `validDate` date DEFAULT NULL,
  `statePub` int(11) DEFAULT NULL,
  `hits` int(11) DEFAULT '0',
  `categoryId` int(11) NOT NULL,
  `departmentId` int(11) DEFAULT '19',
  `hrIdPub` int(11) NOT NULL,
  PRIMARY KEY (`positionId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Data for table "position"
#

INSERT INTO `position` VALUES (1,'Java工程师','熟练使用RPC框架，具备相关的分布式开发经验',3,'北京市',12000,7000,'2017-10-27',NULL,1,153,1,1,1),(2,'Java工程师','接收应届实习生，实习期满应聘上岗接收应届实习生，实习期满应聘上岗收应届实习生，实习期满应聘上岗',5,'上海市',16000,11000,'2017-11-07',NULL,1,122,1,4,2),(3,'Java工程师','有扎实的java基础，熟悉分布式、缓存、异步消息等原理和应用',15,'天津市',13000,10000,'2017-09-30',NULL,1,3,1,7,3),(4,'Java工程师','JAVA WEB方向2年+经验',2,'南京市',16000,12000,'2017-09-25',NULL,1,24,1,10,4),(5,'C++工程师','可接收计算机相关专业应届生，表现优秀者加薪转正',30,'南京市',8000,5000,'2017-10-16',NULL,1,16,2,10,4),(6,'C++工程师','3-5年工作经验，计算机相关专业毕业',1,'上海市',16000,8000,'2017-11-03',NULL,1,6,2,4,2),(7,'PHP工程师','一年以上PHP开发经验 （项目经验丰富的，也可以升级为高级开发工程师）',10,'上海市',11000,8000,'2017-11-10',NULL,1,100,3,4,2),(8,'PHP工程师','熟悉LNMP/WNMP开发环境 , 熟练使用Yaf, Yii, ThinkPHP等一种或多种框架',5,'上海市',12000,7000,'2017-11-01',NULL,1,3,3,4,2),(10,'Python数据分析','熟练使用Linux，可以快速上手编写shell、powershell、cmd等操作系统脚本',2,'北京市',23000,18000,'2017-10-09',NULL,1,48,5,1,1),(12,'Python开发','精通Python，2年或以上Python项目经验',3,'天津市',16000,14000,'2017-07-27',NULL,1,43,5,7,3),(13,'数据挖掘工程师','熟悉 Linux平台上的编程环境，精通Java开发，精通 Python/Shell等脚本语言',12,'天津市',22000,15000,'2017-11-05',NULL,1,8,6,7,3),(15,'数据挖掘工程师','精通Python，熟悉PHP/GO/Java/C++/C等语言中的一种或几种',2,'杭州市',26000,14000,'2017-11-08',NULL,1,26,6,13,5),(16,'Java工程师','熟悉Spring、Freemark、Struts、Hibernate 等开源框架',13,'杭州市',18000,15000,'2017-11-11',NULL,1,5,1,17,6),(17,'Java后端开发','熟练使用Mybatis，SpringMVC，SpringCloud等框架',5,'杭州市',21000,18000,'2017-10-23',NULL,1,4,1,13,5),(18,'C++后端开发','熟练linux系统操作，熟练gcc,gdb,vim, eclipse等开发工具',5,'北京市',12000,9000,'2017-10-28',NULL,1,2,2,1,1),(19,'Java工程师','熟练使用RPC框架，具备相关的分布式开发经验',3,'北京市',12000,7000,'2017-10-27',NULL,1,150,1,1,1),(21,'PHP','无',1,'山东',0,1200,NULL,NULL,1,8,1,19,1);

#
# Structure for table "questions"
#

CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `pid` int(11) NOT NULL,
  `qtype` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questions_ibfk_1` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='条例';

#
# Data for table "questions"
#

INSERT INTO `questions` VALUES (1,'12323',2,2),(2,'3123',2,2),(3,'',2,1),(4,'',2,1),(5,'1233',3,2),(6,'1233',3,2),(7,'2324',3,2),(8,'2324',3,2),(9,'2222',4,2),(10,'2123',5,2),(11,'233',6,2),(12,'qweqwewqewqewqe',7,2),(13,'eeeee',7,2),(14,'99999',8,2),(15,'',10,1),(16,'',10,1),(17,'',10,1),(18,'',10,1),(19,'',10,1),(20,'',10,1),(21,'',10,1),(22,'5y456',21,2),(23,'123213123',22,2),(24,'33333',22,2),(25,'奥术大师大',23,2),(26,'是打发点',24,2),(27,'4524',25,2);

#
# Structure for table "resume"
#

CREATE TABLE `resume` (
  `resumeId` int(11) NOT NULL AUTO_INCREMENT,
  `ability` longtext,
  `internship` longtext,
  `workExperience` longtext,
  `certificate` longtext,
  `jobDesire` longtext,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`resumeId`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "resume"
#

INSERT INTO `resume` VALUES (1,NULL,NULL,NULL,NULL,NULL,1),(2,NULL,NULL,NULL,NULL,NULL,2),(3,NULL,NULL,NULL,NULL,NULL,3),(4,NULL,NULL,NULL,NULL,NULL,4),(5,NULL,NULL,NULL,NULL,NULL,5),(6,NULL,NULL,NULL,NULL,NULL,6),(7,NULL,NULL,NULL,NULL,NULL,7),(8,NULL,NULL,NULL,NULL,NULL,8),(9,NULL,NULL,NULL,NULL,NULL,9),(10,NULL,NULL,NULL,NULL,NULL,10),(11,NULL,NULL,NULL,NULL,NULL,11),(12,'1213','123','123','12+1585305936633','12321',12),(13,NULL,NULL,NULL,NULL,NULL,13),(14,NULL,NULL,NULL,NULL,NULL,14),(17,NULL,NULL,NULL,NULL,NULL,17),(21,NULL,NULL,NULL,NULL,NULL,21),(24,'写点什么。。。','写点什么。。。','写点什么。。。','写点什么。。。','写点什么。。。',24),(25,'专业能力么。。。也就能悄悄代码','还没毕业，也没啥实习经历~','无实际工作经历~','拿过几次奖学金吧','有一份别太累稳定的工作就好。。。',25),(26,NULL,NULL,NULL,NULL,NULL,26),(27,NULL,NULL,NULL,NULL,NULL,27),(28,NULL,NULL,NULL,NULL,NULL,28),(29,NULL,NULL,NULL,NULL,NULL,29),(30,NULL,NULL,NULL,NULL,NULL,30),(31,NULL,NULL,NULL,NULL,NULL,31),(32,NULL,NULL,NULL,NULL,NULL,32),(33,NULL,NULL,NULL,NULL,NULL,33),(34,NULL,NULL,NULL,NULL,NULL,34),(35,NULL,NULL,NULL,NULL,NULL,35),(36,NULL,NULL,NULL,NULL,NULL,36),(37,NULL,NULL,NULL,NULL,NULL,37),(38,NULL,NULL,NULL,NULL,NULL,38),(39,NULL,NULL,NULL,NULL,NULL,39);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) NOT NULL,
  `password` varchar(500) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birthYear` int(11) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `eduDegree` varchar(50) DEFAULT NULL,
  `graduation` varchar(100) DEFAULT NULL,
  `graYear` int(11) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `dirDesire` int(11) DEFAULT NULL COMMENT '技能',
  `hits` int(11) DEFAULT '0',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `user_id_UNIQUE` (`userId`),
  UNIQUE KEY `user_mobile_UNIQUE` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'13754258565','4QrcOUm6Wau+VuBX8g+IPg==','夏高兴',0,NULL,'云淡天高','xiagaoxin@163.com','北京市','北京市','硕士','中南财经政法大学',NULL,NULL,3,32),(2,'16873315255','4QrcOUm6Wau+VuBX8g+IPg==','沈茂德',0,NULL,'冷酷的云','shenmaode@163.com','北京市','北京市','本科','湖南师范大学',NULL,NULL,3,30),(3,'16535356412','4QrcOUm6Wau+VuBX8g+IPg==','杜文瑞',0,NULL,'我心寂寞','duwenrui@163.com','上海市','上海市','本科','东北财经大学',NULL,NULL,1,2),(4,'15785658371','4QrcOUm6Wau+VuBX8g+IPg==','彭友卉',0,NULL,'尘封记忆','pengyouhui@163.com','上海市','上海市','本科','西南大学',NULL,NULL,2,0),(5,'16735259632','4QrcOUm6Wau+VuBX8g+IPg==','崔谷槐',0,NULL,'飘雪无垠','cuiguhuai@163.com','上海市','上海市','本科','苏州大学',NULL,NULL,2,0),(6,'17898763255','4QrcOUm6Wau+VuBX8g+IPg==','魏茂材',0,NULL,'风过无痕','weimaocai@163.com','广东省','广州市','本科','西北大学',NULL,'user',6,0),(7,'17563522636','4QrcOUm6Wau+VuBX8g+IPg==','侯成文',0,1997,'星月相随','huochengwen','湖北省','武汉市','硕士','上海财经大学',2019,'国际金融',3,0),(8,'18936258863','4QrcOUm6Wau+VuBX8g+IPg==','邵夜云',1,NULL,'低调沉默者','shaoyeyun@163.com','北京市','北京市','本科','江苏大学',NULL,NULL,2,0),(9,'13752533625','4QrcOUm6Wau+VuBX8g+IPg==','方彭湃',1,NULL,'梦醒童话','fangpengpai@163.com','天津市','天津市','硕士','西南政法大学',NULL,NULL,4,0),(10,'15763968252','4QrcOUm6Wau+VuBX8g+IPg==','熊新觉',1,NULL,'咖啡的味道','xiongxinjue@163.com','广东省','广州市','本科','重庆医科大学',NULL,NULL,3,0),(11,'13685259986','4QrcOUm6Wau+VuBX8g+IPg==','肖又香',1,NULL,'悬世尘埃','xiaoyouxiang@163.com','浙江省','杭州市','大专','福建师范大学',NULL,NULL,2,0),(12,'15788875236','4QrcOUm6Wau+VuBX8g+IPg==','严经纶',0,NULL,'冰封夕阳','yanjinlun@163.com','浙江省','杭州市','本科','广州中医药大学',NULL,NULL,6,11),(13,'18766635865','4QrcOUm6Wau+VuBX8g+IPg==','邓和豫',1,NULL,'隐水酣龙','dengheyu@163.com','浙江省','杭州市','本科','哈尔滨工程大学',NULL,NULL,1,0),(14,'15623527861','4QrcOUm6Wau+VuBX8g+IPg==','邓雪风',0,NULL,'一顿小皮锤','dengxuefeng@163.com','江苏省','南京市','本科','暨南大学',NULL,NULL,4,0),(17,'15726928003','4QrcOUm6Wau+VuBX8g+IPg==','龟龟',0,NULL,'龟龟','guigui@163.com','广东省','中山市','本科','华东理工大学',NULL,NULL,0,0),(21,'13957336750','4QrcOUm6Wau+VuBX8g+IPg==','木木',0,NULL,'木木','mumu@163.com','湖北省','武汉市','本科','天津科技大学',NULL,NULL,0,0),(24,'17863954768','4QrcOUm6Wau+VuBX8g+IPg==','轩',0,1997,'轩','xuan@163.com','山东省','青岛市','本科','青岛科技大学',2019,'软件工程',2,0),(25,'17812345687','4QrcOUm6Wau+VuBX8g+IPg==','青柠',0,1997,'青柠','babycoder@foxmail.com','浙江省','杭州市','本科','青岛科技大学',2019,'软件',1,0),(39,'18253800315','4QrcOUm6Wau+VuBX8g+IPg==','牛文良',0,2003,'下划线','15786586352','广西壮族自治区',NULL,'大专','王企鹅二',2003,'计算机科学与技术',7,1);

#
# Structure for table "useranswer"
#

CREATE TABLE `useranswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(300) NOT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `useranswer_ibfk_1` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='条例结果';

#
# Data for table "useranswer"
#

INSERT INTO `useranswer` VALUES (1,'dsadasdsadasd',5),(2,'wew',6),(3,'qqqq',7),(4,'weweqe',8),(5,'',22),(6,'从自行车自行车',25);

#
# Structure for table "usercomment"
#

CREATE TABLE `usercomment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `usercontent` longtext,
  `userreleaseTime` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `hrId` int(11) DEFAULT NULL,
  `fenshu` int(11) DEFAULT NULL,
  `positionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "usercomment"
#

INSERT INTO `usercomment` VALUES (1,'啊擦','2020-03-25 22:48:33',1,1,5,NULL),(2,'阿擦擦','2020-03-25 22:59:30',6,1,4,NULL),(3,'发东方电子复制到','2020-03-25 23:19:45',1,1,4,1),(4,'从撒擦擦','2020-03-25 23:21:28',1,1,5,1),(5,'按时财产三','2020-03-25 23:43:25',12,1,5,10),(6,'奥术大师','2020-03-26 16:00:38',12,1,5,10);
