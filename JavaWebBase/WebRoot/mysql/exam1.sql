/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2017-07-21 14:12:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(22) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('zs', '900');
INSERT INTO `account` VALUES ('li', '1100');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` char(32) NOT NULL,
  `bname` varchar(100) DEFAULT NULL,
  `price` decimal(5,1) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `cid` char(32) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `cid` (`cid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java编程思想（第4版）', '75.6', 'qq986945193', 'book_img/9317290-1_l.jpg', '1');
INSERT INTO `book` VALUES ('2', 'Java核心技术卷1', '68.5', 'qq986945193', 'book_img/20285763-1_l.jpg', '1');
INSERT INTO `book` VALUES ('3', 'Java就业培训教程', '39.9', 'qq986945193', 'book_img/8758723-1_l.jpg', '1');
INSERT INTO `book` VALUES ('4', 'Head First java', '47.5', '（美）塞若', 'book_img/9265169-1_l.jpg', '1');
INSERT INTO `book` VALUES ('5', 'JavaWeb开发详解', '83.3', 'qq986945193', 'book_img/22788412-1_l.jpg', '2');
INSERT INTO `book` VALUES ('6', 'Struts2深入详解', '63.2', 'qq986945193', 'book_img/20385925-1_l.jpg', '2');
INSERT INTO `book` VALUES ('7', '精通Hibernate', '30.0', 'qq986945193', 'book_img/8991366-1_l.jpg', '2');
INSERT INTO `book` VALUES ('8', '精通Spring2.x', '63.2', 'qq986945193', 'book_img/20029394-1_l.jpg', '2');
INSERT INTO `book` VALUES ('9', 'Javascript权威指南', '93.6', '（美）弗兰纳根', 'book_img/22722790-1_l.jpg', '3');

-- ----------------------------
-- Table structure for `demo_tb_customer`
-- ----------------------------
DROP TABLE IF EXISTS `demo_tb_customer`;
CREATE TABLE `demo_tb_customer` (
  `cid` varchar(40) NOT NULL DEFAULT '0',
  `cname` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `description` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_tb_customer
-- ----------------------------
INSERT INTO `demo_tb_customer` VALUES ('01552F32367D46B8BF75E5C5A5579C82', 'heli84', '2014-11-10', '女', '84', '方法', 'descrip84');
INSERT INTO `demo_tb_customer` VALUES ('0171B755E0AA439DAA1B503711203F30', 'heli22', '2017-07-12', '女', '飞飞飞', '111', 'descrip22111');
INSERT INTO `demo_tb_customer` VALUES ('0429ED6DA9064CB589E5B73844B2DC0C', 'heli28', '2014-11-10', '女', '28', null, 'descrip28');
INSERT INTO `demo_tb_customer` VALUES ('0569A014539E4637A0B6250C5161C57B', 'heli30', '2014-11-10', '女', '30', null, 'descrip30');
INSERT INTO `demo_tb_customer` VALUES ('057F46938B414C3996D76D77B2F48B11', 'heli12', '2014-11-10', '女', '12', null, 'descrip12');
INSERT INTO `demo_tb_customer` VALUES ('06BE8391A3B44EAC80EC17F596FF04BF', '飞飞飞', '2017-07-04', '男', '飞', '  飞', '飞飞飞');
INSERT INTO `demo_tb_customer` VALUES ('0B98D48C6A6F41978ED35526366CF504', 'heli38', '2014-11-10', '女', '38', null, 'descrip38');
INSERT INTO `demo_tb_customer` VALUES ('0C7E041EA39F4649AADA9C8F1DE52610', 'fff', '2017-07-11', '男', 'fff', 'ff', 'ff');
INSERT INTO `demo_tb_customer` VALUES ('0D277739C42F426F871314A7A3EE6E30', 'heli87', '2014-11-10', '女', '87', null, 'descrip87');
INSERT INTO `demo_tb_customer` VALUES ('111805F77CB04E70A169AAD577E44DC1', 'heli71', '2014-11-10', '女', '71', null, 'descrip71');
INSERT INTO `demo_tb_customer` VALUES ('11A3BF13313A47ED9CDAA281F84DBEBE', 'heli53', '2014-11-10', '女', '53', null, 'descrip53');
INSERT INTO `demo_tb_customer` VALUES ('1535001989CD44218712B47D7B17D669', 'heli52', '2014-11-10', '女', '52', null, 'descrip52');
INSERT INTO `demo_tb_customer` VALUES ('169C729650AC4C1B8D964025D95677F4', 'heli21', '2014-11-10', '女', '21', null, 'descrip21');
INSERT INTO `demo_tb_customer` VALUES ('182F5707F8D049EA97375A794A2CB5BC', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('1A07455C748A4F718CC83B3133DCBB5B', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('1A0F440134B4482F886911591DBABED5', 'heli3', '2014-11-10', '女', '3', null, 'descrip3');
INSERT INTO `demo_tb_customer` VALUES ('1A89D95AB7AC46A2B0B67EDA6C7DC8D2', '123456', '2017-07-11', '女', '151214531451', '986945193@qq.com', 'f');
INSERT INTO `demo_tb_customer` VALUES ('1C7D8CDD8D2D4F34A41ABAF769C9EF36', 'heli92', '2014-11-10', '女', '92', null, 'descrip92');
INSERT INTO `demo_tb_customer` VALUES ('1E35E0C69CBE44DE9D80BB18A88C3677', 'heli79', '2014-11-10', '女', '79', null, 'descrip79');
INSERT INTO `demo_tb_customer` VALUES ('1F83DDFA67BB49AEAAF100C5C2911718', 'heli78', '2014-11-10', '女', '78', null, 'descrip78');
INSERT INTO `demo_tb_customer` VALUES ('2329155122A542C38A2D0DD09F9D1949', 'heli93', '2014-11-10', '女', '93', null, 'descrip93');
INSERT INTO `demo_tb_customer` VALUES ('23E4D82D783A420E8710FE5ECEEC4850', 'heli41', '2014-11-10', '女', '41', null, 'descrip41');
INSERT INTO `demo_tb_customer` VALUES ('25863013E22B45D0A7D4BD70D9B514C4', 'heli10', '2014-11-10', '女', '10', null, 'descrip10');
INSERT INTO `demo_tb_customer` VALUES ('282E4B03EC4445FF811A1D3548EC54AB', 'heli44', '2014-11-10', '女', '44', null, 'descrip44');
INSERT INTO `demo_tb_customer` VALUES ('283A7D394C76425EBB5794B4F808013C', 'heli85', '2014-11-10', '女', '85', null, 'descrip85');
INSERT INTO `demo_tb_customer` VALUES ('2AAED492735E4126AEB3D0D3263A67FF', 'heli37', '2014-11-10', '女', '37', null, 'descrip37');
INSERT INTO `demo_tb_customer` VALUES ('328B6ACF6B824DC88A7CD9C9075A8848', 'heli68', '2014-11-10', '女', '68', null, 'descrip68');
INSERT INTO `demo_tb_customer` VALUES ('32C8448885A446E1933C35F18D95F8B2', 'heli15', '2014-11-10', '女', '15', null, 'descrip15');
INSERT INTO `demo_tb_customer` VALUES ('36EEBC945D064B408F1C4B287B09C817', 'heli27', '2014-11-10', '女', '27', null, 'descrip27');
INSERT INTO `demo_tb_customer` VALUES ('38FA09057DB9412B8A6A20C1072F4038', 'heli56', '2014-11-10', '女', '56', null, 'descrip56');
INSERT INTO `demo_tb_customer` VALUES ('3E3449792BCB4C47BB9EB594C73BB776', 'heli83', '2014-11-10', '女', '83', null, 'descrip83');
INSERT INTO `demo_tb_customer` VALUES ('3EF046F3289644FAA46495E555D141E6', 'heli70', '2014-11-10', '女', '70', null, 'descrip70');
INSERT INTO `demo_tb_customer` VALUES ('40FF81CD838948EFB58062B9C82D0EF6', 'heli58', '2014-11-10', '女', '58', null, 'descrip58');
INSERT INTO `demo_tb_customer` VALUES ('433BA67FE4C2421194453BB56EC1D5BE', 'heli62', '2014-11-10', '女', '62', null, 'descrip62');
INSERT INTO `demo_tb_customer` VALUES ('452E9BEA7B654D6B8FB06284AD78808C', 'heli75', '2014-11-10', '女', '75', null, 'descrip75');
INSERT INTO `demo_tb_customer` VALUES ('472B84B397C24B2696D3851AE2C6B6C2', 'heli47', '2014-11-10', '女', '47', null, 'descrip47');
INSERT INTO `demo_tb_customer` VALUES ('47837B64846B4277A2EE3BC71BF6D016', 'heli26', '2014-11-10', '女', '26', null, 'descrip26');
INSERT INTO `demo_tb_customer` VALUES ('4CA4DE6613554049904B57843CD614F1', 'heli98', '2014-11-10', '女', '98', null, 'descrip98');
INSERT INTO `demo_tb_customer` VALUES ('53D9F060737343818506A4362B07344F', 'heli89', '2014-11-10', '女', '89', null, 'descrip89');
INSERT INTO `demo_tb_customer` VALUES ('545E1B32D6974D4AAC65B4FC9466CFFD', 'heli1', '2014-11-10', '女', '1', null, 'descrip1');
INSERT INTO `demo_tb_customer` VALUES ('57BC40533D5643AAAAEE3F96D0371938', 'fff', '2017-07-19', '男', 'fff', 'admin', '方法');
INSERT INTO `demo_tb_customer` VALUES ('585613C351F8462BA5BE296A6FC40F6E', 'heli88', '2014-11-10', '女', '88', null, 'descrip88');
INSERT INTO `demo_tb_customer` VALUES ('5AACD37B84824C2782B2C54413E186AD', 'heli6', '2014-11-10', '女', '6', null, 'descrip6');
INSERT INTO `demo_tb_customer` VALUES ('5D3D08FBEDE644D991CC003D701E3708', 'heli4', '2014-11-10', '女', '4', null, 'descrip4');
INSERT INTO `demo_tb_customer` VALUES ('5E670D301EE5419ABE558FAD99D468C1', 'heli19', '2014-11-10', '女', '19', null, 'descrip19');
INSERT INTO `demo_tb_customer` VALUES ('62A971147DF942C5B2F74FEAB37D1D21', 'heli17', '2014-11-10', '女', '17', null, 'descrip17');
INSERT INTO `demo_tb_customer` VALUES ('642A94F818C14364A3D0CCBD0FC92677', 'heli39', '2014-11-10', '女', '39', null, 'descrip39');
INSERT INTO `demo_tb_customer` VALUES ('64EF05F3F88E4A67A5D29E8708A19F7B', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('651FE01D78A948EDACB029BC61081CE2', 'heli74', '2014-11-10', '女', '74', null, 'descrip74');
INSERT INTO `demo_tb_customer` VALUES ('6538184E1F3D45288712C8369A5499A9', 'heli9', '2014-11-10', '女', '9', null, 'descrip9');
INSERT INTO `demo_tb_customer` VALUES ('6753C8C0B0194094AE194D351E3A091E', 'heli81', '2014-11-10', '女', '81', null, 'descrip81');
INSERT INTO `demo_tb_customer` VALUES ('67E9D69CD4304EAE98E81F9DD4EE3660', 'heli29', '2014-11-10', '女', '29', null, 'descrip29');
INSERT INTO `demo_tb_customer` VALUES ('6A5068D7621D41808222463390E492AC', 'heli50', '2014-11-10', '女', '50', null, 'descrip50');
INSERT INTO `demo_tb_customer` VALUES ('71DA67838FBF4D689AE85D372B7E3A0A', 'heli11', '2014-11-10', '女', '11', null, 'descrip11');
INSERT INTO `demo_tb_customer` VALUES ('72730D06ED474164BDEF141DDBF05A1B', 'heli7', '2014-11-10', '女', '7', null, 'descrip7');
INSERT INTO `demo_tb_customer` VALUES ('767CEF33449C44ECBEA2FAD3008C93CE', 'heli80', '2014-11-10', '女', '80', null, 'descrip80');
INSERT INTO `demo_tb_customer` VALUES ('76F5138FDBB14B14B33F08D914A6402D', 'heli23', '2014-11-10', '女', '23', null, 'descrip23');
INSERT INTO `demo_tb_customer` VALUES ('7AB0644F16B340E4A1B13F3EBD305F33', 'heli40', '2014-11-10', '女', '40', null, 'descrip40');
INSERT INTO `demo_tb_customer` VALUES ('7AEB2E27B31C4329881E780324871398', 'heli20', '2014-11-10', '女', '20', null, 'descrip20');
INSERT INTO `demo_tb_customer` VALUES ('7BF90EA2352A451083E880BE9FA6BF77', '123456', '2017-07-19', '女', 'fff', '986945193@qq.com', 'f ');
INSERT INTO `demo_tb_customer` VALUES ('7D30EF58674F48C88FF2AE67CD9C5E70', 'heli8', '2014-11-10', '女', '8', null, 'descrip8');
INSERT INTO `demo_tb_customer` VALUES ('7D35C71C48B341C39BE0E1377590378C', 'heli97', '2014-11-10', '女', '97', null, 'descrip97');
INSERT INTO `demo_tb_customer` VALUES ('80AF633958FA428F80000261D4C25987', 'heli57', '2014-11-10', '女', '57', null, 'descrip57');
INSERT INTO `demo_tb_customer` VALUES ('867EA1B899BA4DDD8007D96BC6CCD0BA', 'heli91', '2014-11-10', '女', '91', null, 'descrip91');
INSERT INTO `demo_tb_customer` VALUES ('8AA2666D2A29423F96B51928C43BE60F', 'heli67', '2014-11-10', '女', '67', null, 'descrip67');
INSERT INTO `demo_tb_customer` VALUES ('8CFC88E0907F4671B36D9EB73535092B', 'heli86', '2014-11-10', '女', '86', null, 'descrip86');
INSERT INTO `demo_tb_customer` VALUES ('8E4A3746493549A994D0B57ECE68A596', 'heli73', '2014-11-10', '女', '73', null, 'descrip73');
INSERT INTO `demo_tb_customer` VALUES ('927E2FC488524682B98BEED857000510', '123456', '2017-07-17', '男', '151214531451', 'pjv88851@uzrip.com', '12');
INSERT INTO `demo_tb_customer` VALUES ('97BB19AD5E35413CBCE400FD7EFE4BE7', 'heli76', '2014-11-10', '女', '76', null, 'descrip76');
INSERT INTO `demo_tb_customer` VALUES ('984AE5441E7448AD83586A580D318F97', 'heli54', '2014-11-10', '女', '54', null, 'descrip54');
INSERT INTO `demo_tb_customer` VALUES ('9CCDB4AF9C414506B7424640F72CA492', 'heli48', '2014-11-10', '女', '48', null, 'descrip48');
INSERT INTO `demo_tb_customer` VALUES ('9E2C8ECB667D4757862A6E2D54BB1C28', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('A05978A8A51D423FAD99D09FCAD67339', 'heli65', '2014-11-10', '女', '65', null, 'descrip65');
INSERT INTO `demo_tb_customer` VALUES ('A214CD44D6224C9A9A317A8502E30906', 'heli33', '2014-11-10', '女', '33', null, 'descrip33');
INSERT INTO `demo_tb_customer` VALUES ('A316CCD31FC041549635553266CF1697', 'heli82', '2014-11-10', '女', '82', null, 'descrip82');
INSERT INTO `demo_tb_customer` VALUES ('A469D151115443C3A731D38BD8E5206E', 'heli66', '2014-11-10', '女', '66', null, 'descrip66');
INSERT INTO `demo_tb_customer` VALUES ('A508956ABC174BFFB6ABA664798D484B', 'heli99', '2014-11-10', '女', '99', null, 'descrip99');
INSERT INTO `demo_tb_customer` VALUES ('A978BA101AC642F8AA1A627589DD174C', 'heli64', '2014-11-10', '女', '64', null, 'descrip64');
INSERT INTO `demo_tb_customer` VALUES ('AA0F5A29F49D4256AE6E37019D7C7A52', 'heli49', '2014-11-10', '女', '49', null, 'descrip49');
INSERT INTO `demo_tb_customer` VALUES ('AD8B1E44613F47ED875568DDA573E790', 'heli13', '2014-11-10', '女', '13', null, 'descrip13');
INSERT INTO `demo_tb_customer` VALUES ('AF430DBC255A4B95984E636F23A53EA9', 'heli25', '2014-11-10', '女', '25', null, 'descrip25');
INSERT INTO `demo_tb_customer` VALUES ('B0C58C904D79451499BF79E14868F143', 'heli96', '2014-11-10', '女', '96', null, 'descrip96');
INSERT INTO `demo_tb_customer` VALUES ('B32546DA4B534106B09ABEE62DEC44FC', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('B5DAB0CDCBAA4B2A967B4E51DE2EB388', 'heli63', '2014-11-10', '女', '63', null, 'descrip63');
INSERT INTO `demo_tb_customer` VALUES ('BA9CB1926101429E94D2E589327A3562', 'heli5', '2014-11-10', '女', '5', null, 'descrip5');
INSERT INTO `demo_tb_customer` VALUES ('BC15AABDB14E4C0E84986A4AE12EC1A2', 'heli90', '2014-11-10', '女', '90', null, 'descrip90');
INSERT INTO `demo_tb_customer` VALUES ('BD190344097E4532B39B64AF4C707933', 'heli16', '2014-11-10', '女', '16', null, 'descrip16');
INSERT INTO `demo_tb_customer` VALUES ('BD2712E28024400EB912D4A3B2052195', 'heli18', '2014-11-10', '女', '18', null, 'descrip18');
INSERT INTO `demo_tb_customer` VALUES ('BE98864B499145AF8CB0F5C494C70CC1', 'heli36', '2014-11-10', '女', '36', null, 'descrip36');
INSERT INTO `demo_tb_customer` VALUES ('BF8C25BD86F44D1B8D10753F080D46E8', 'heli24', '2014-11-10', '女', '24', null, 'descrip24');
INSERT INTO `demo_tb_customer` VALUES ('C01C97AB54554C049BCDA31D15B42FF2', 'heli31', '2014-11-10', '女', '31', null, 'descrip31');
INSERT INTO `demo_tb_customer` VALUES ('C72FDA01A48D4B12A4910918B76A6FAA', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('C8BDDB4D0B0A43509ACB99AA68B720B1', 'heli34', '2014-11-10', '女', '34', null, 'descrip34');
INSERT INTO `demo_tb_customer` VALUES ('CB15532E4B774D1299D8C46B822CD162', 'heli51', '2014-11-10', '女', '51', null, 'descrip51');
INSERT INTO `demo_tb_customer` VALUES ('CBE140CCA92B4FB98CF9311FF0A4A274', 'heli95', '2014-11-10', '女', '95', null, 'descrip95');
INSERT INTO `demo_tb_customer` VALUES ('D1C8E043D4574D61BB881A277C5CFD05', 'heli72', '2014-11-10', '女', '72', null, 'descrip72');
INSERT INTO `demo_tb_customer` VALUES ('D5A92ECA1B944BD1A6C8206CB9D6D1A7', 'fff', '2017-07-18', '男', 'ffffff', 'fffff', 'ffffff');
INSERT INTO `demo_tb_customer` VALUES ('DC5107A0AE2B45399D776CDB1DA12E0C', null, null, null, null, null, null);
INSERT INTO `demo_tb_customer` VALUES ('DE0882DF34CB4482BEFE170141FB2D90', '123456', '2017-07-04', '女', 'fff', '986945193@qq.com', '');
INSERT INTO `demo_tb_customer` VALUES ('E3D9357033954C7CBBB02CDD46C7A9F8', 'heli42', '2014-11-10', '女', '42', null, 'descrip42');
INSERT INTO `demo_tb_customer` VALUES ('E4219156EA18479592C16CE4F59D49D0', 'heli43', '2014-11-10', '女', '43', null, 'descrip43');
INSERT INTO `demo_tb_customer` VALUES ('E6C8B05211D044C6AE2CFA226FD9C854', 'heli77', '2014-11-10', '女', '77', null, 'descrip77');
INSERT INTO `demo_tb_customer` VALUES ('E7BBAB564A694EBD8C64D0C076C71B58', 'heli14', '2014-11-10', '女', '14', null, 'descrip14');
INSERT INTO `demo_tb_customer` VALUES ('E7C5C0C9702B4741AD9ED4C78D2187BF', 'heli45', '2014-11-10', '女', '45', null, 'descrip45');
INSERT INTO `demo_tb_customer` VALUES ('EB1C2D4BD0BA4B7BAC4866AE5111FF95', 'heli61', '2014-11-10', '女', '61', null, 'descrip61');
INSERT INTO `demo_tb_customer` VALUES ('EF50922306244EA8BC9CEB5A19EE0F78', 'heli0', '2014-11-10', '女', '0', null, 'descrip0');
INSERT INTO `demo_tb_customer` VALUES ('EFB80FB717964B278F8BA73F4CB43AA8', 'heli35', '2014-11-10', '女', '35', null, 'descrip35');
INSERT INTO `demo_tb_customer` VALUES ('F3B1B3F804EE4B78BA84D071FE3CEAC9', 'heli55', '2014-11-10', '女', '55', null, 'descrip55');
INSERT INTO `demo_tb_customer` VALUES ('F59BEE8CED7642BFAA9452F1B7A25ECC', 'heli59', '2014-11-10', '女', '59', null, 'descrip59');
INSERT INTO `demo_tb_customer` VALUES ('F6D79F9F868E4E5787F70B9A44C63125', 'heli32', '2014-11-10', '女', '32', null, 'descrip32');
INSERT INTO `demo_tb_customer` VALUES ('F8EE6166EEF44C6AB08095676AB0612D', 'heli60', '2014-11-10', '女', '60', null, 'descrip60');
INSERT INTO `demo_tb_customer` VALUES ('F91CFA571FBB4153A4D1AFFB57345717', 'heli46', '2014-11-10', '女', '46', null, 'descrip46');
INSERT INTO `demo_tb_customer` VALUES ('FB568AEA126E482B8008E12D527E9614', 'heli2', '2014-11-10', '女', '2', null, 'descrip2');
INSERT INTO `demo_tb_customer` VALUES ('FC59AB6712C64A5B86C458DAFB1B42A3', 'heli69', '2014-11-10', '女', '69', null, 'descrip69');
INSERT INTO `demo_tb_customer` VALUES ('FF6357AA996D4B81972E8A0884F4DE84', 'heli94', '2014-11-10', '女', '94', null, 'descrip94');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', '教研部', '北京');
INSERT INTO `dept` VALUES ('20', '学工部', '上海');
INSERT INTO `dept` VALUES ('30', '销售部', '广州');
INSERT INTO `dept` VALUES ('40', '财务部', '武汉');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `COMM` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_emp` (`mgr`),
  CONSTRAINT `fk_emp` FOREIGN KEY (`mgr`) REFERENCES `emp` (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1001', '甘宁', '文员', '1013', '2000-12-17', '8000.00', null, '20');
INSERT INTO `emp` VALUES ('1002', '黛绮丝', '销售员', '1006', '2001-02-20', '16000.00', '3000.00', '30');
INSERT INTO `emp` VALUES ('1003', '殷天正', '销售员', '1006', '2001-02-22', '12500.00', '5000.00', '30');
INSERT INTO `emp` VALUES ('1004', '刘备', '经理', '1009', '2001-04-02', '29750.00', null, '20');
INSERT INTO `emp` VALUES ('1005', '谢逊', '销售员', '1006', '2001-09-28', '12500.00', '14000.00', '30');
INSERT INTO `emp` VALUES ('1006', '关羽', '经理', '1009', '2001-05-01', '28500.00', null, '30');
INSERT INTO `emp` VALUES ('1007', '张飞', '经理', '1009', '2001-09-01', '24500.00', null, '10');
INSERT INTO `emp` VALUES ('1008', '诸葛亮', '分析师', '1004', '2007-04-19', '30000.00', null, '20');
INSERT INTO `emp` VALUES ('1009', '曾阿牛', '董事长', null, '2001-11-17', '50000.00', null, '10');
INSERT INTO `emp` VALUES ('1010', '韦一笑', '销售员', '1006', '2001-09-08', '15000.00', '0.00', '30');
INSERT INTO `emp` VALUES ('1011', '周泰', '文员', '1008', '2007-05-23', '11000.00', null, '20');
INSERT INTO `emp` VALUES ('1012', '程普', '文员', '1006', '2001-12-03', '9500.00', null, '30');
INSERT INTO `emp` VALUES ('1013', '庞统', '分析师', '1004', '2001-12-03', '30000.00', null, '20');
INSERT INTO `emp` VALUES ('1014', '黄盖', '文员', '1007', '2002-01-23', '13000.00', null, '10');

-- ----------------------------
-- Table structure for `exam_user`
-- ----------------------------
DROP TABLE IF EXISTS `exam_user`;
CREATE TABLE `exam_user` (
  `uid` int(11) NOT NULL DEFAULT '0',
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_user
-- ----------------------------
INSERT INTO `exam_user` VALUES ('0', '22', '3233');
INSERT INTO `exam_user` VALUES ('1', '111', '11111');

-- ----------------------------
-- Table structure for `salgrade`
-- ----------------------------
DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `grade` int(11) NOT NULL,
  `losal` int(11) DEFAULT NULL,
  `hisal` int(11) DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salgrade
-- ----------------------------
INSERT INTO `salgrade` VALUES ('1', '7000', '12000');
INSERT INTO `salgrade` VALUES ('2', '12010', '14000');
INSERT INTO `salgrade` VALUES ('3', '14010', '20000');
INSERT INTO `salgrade` VALUES ('4', '20010', '30000');
INSERT INTO `salgrade` VALUES ('5', '30010', '99990');

-- ----------------------------
-- Table structure for `stu`
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `sid` int(11) NOT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gander` varchar(10) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `tuition` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', '王永', '23', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('2', '张雷', '25', '男', '辽宁', '2500');
INSERT INTO `stu` VALUES ('3', '李强', '22', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('4', '宋永合', '25', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('5', '叙美丽', '23', '女', '北京', '1000');
INSERT INTO `stu` VALUES ('6', '陈宁', '22', '女', '山东', '2500');
INSERT INTO `stu` VALUES ('7', '王丽', '21', '女', '北京', '1600');
INSERT INTO `stu` VALUES ('8', '李永', '23', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('9', '张玲', '23', '女', '广州', '2500');
INSERT INTO `stu` VALUES ('10', '啊历', '18', '男', '山西', '3500');
INSERT INTO `stu` VALUES ('11', '王刚', '23', '男', '湖北', '4500');
INSERT INTO `stu` VALUES ('12', '陈永', '24', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('13', '李雷', '24', '男', '辽宁', '2500');
INSERT INTO `stu` VALUES ('14', '李沿', '22', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('15', '王小明', '25', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('16', '王小丽', '23', '女', '北京', '1000');
INSERT INTO `stu` VALUES ('17', '唐宁', '22', '女', '山东', '2500');
INSERT INTO `stu` VALUES ('18', '唐丽', '21', '女', '北京', '1600');
INSERT INTO `stu` VALUES ('19', '啊永', '23', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('20', '唐玲', '23', '女', '广州', '2500');
INSERT INTO `stu` VALUES ('21', '叙刚', '18', '男', '山西', '3500');
INSERT INTO `stu` VALUES ('22', '王累', '23', '男', '湖北', '4500');
INSERT INTO `stu` VALUES ('23', '赵安', '23', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('24', '关雷', '25', '男', '辽宁', '2500');
INSERT INTO `stu` VALUES ('25', '李字', '22', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('26', '叙安国', '25', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('27', '陈浩难', '23', '女', '北京', '1000');
INSERT INTO `stu` VALUES ('28', '陈明', '22', '女', '山东', '2500');
INSERT INTO `stu` VALUES ('29', '孙丽', '21', '女', '北京', '1600');
INSERT INTO `stu` VALUES ('30', '李治国', '23', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('31', '张娜', '23', '女', '广州', '2500');
INSERT INTO `stu` VALUES ('32', '安强', '18', '男', '山西', '3500');
INSERT INTO `stu` VALUES ('33', '王欢', '23', '男', '湖北', '4500');
INSERT INTO `stu` VALUES ('34', '周天乐', '23', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('35', '关雷', '25', '男', '辽宁', '2500');
INSERT INTO `stu` VALUES ('36', '吴强', '22', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('37', '吴合国', '25', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('38', '正小和', '23', '女', '北京', '1000');
INSERT INTO `stu` VALUES ('39', '吴丽', '22', '女', '山东', '2500');
INSERT INTO `stu` VALUES ('40', '冯含', '21', '女', '北京', '1600');
INSERT INTO `stu` VALUES ('41', '陈冬', '23', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('42', '关玲', '23', '女', '广州', '2500');
INSERT INTO `stu` VALUES ('43', '包利', '18', '男', '山西', '3500');
INSERT INTO `stu` VALUES ('44', '威刚', '23', '男', '湖北', '4500');
INSERT INTO `stu` VALUES ('45', '李永', '23', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('46', '张关雷', '25', '男', '辽宁', '2500');
INSERT INTO `stu` VALUES ('47', '送小强', '22', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('48', '关动林', '25', '男', '北京', '1500');
INSERT INTO `stu` VALUES ('49', '苏小哑', '23', '女', '北京', '1000');
INSERT INTO `stu` VALUES ('50', '赵宁', '22', '女', '山东', '2500');
INSERT INTO `stu` VALUES ('51', '陈丽', '21', '女', '北京', '1600');
INSERT INTO `stu` VALUES ('52', '钱小刚', '23', '男', '北京', '3500');
INSERT INTO `stu` VALUES ('53', '艾林', '23', '女', '广州', '2500');
INSERT INTO `stu` VALUES ('54', '郭林', '18', '男', '山西', '3500');
INSERT INTO `stu` VALUES ('55', '周制强', '23', '男', '湖北', '4500');

-- ----------------------------
-- Table structure for `tb_mvc_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_mvc_user`;
CREATE TABLE `tb_mvc_user` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mvc_user
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_student`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `student_id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', 'petter');
INSERT INTO `tb_student` VALUES ('2', 'marrry');

-- ----------------------------
-- Table structure for `tb_stu_result`
-- ----------------------------
DROP TABLE IF EXISTS `tb_stu_result`;
CREATE TABLE `tb_stu_result` (
  `student_id` int(11) DEFAULT NULL,
  `subject` varchar(20) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  KEY `fk_tb_stu_result_student_Id` (`student_id`),
  CONSTRAINT `fk_tb_stu_result_student_Id` FOREIGN KEY (`student_id`) REFERENCES `tb_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stu_result
-- ----------------------------
INSERT INTO `tb_stu_result` VALUES ('2', 'chinese', '96');
INSERT INTO `tb_stu_result` VALUES ('1', 'english', '99');
INSERT INTO `tb_stu_result` VALUES ('1', 'chinese', '98');
INSERT INTO `tb_stu_result` VALUES ('2', 'english', '97');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('zhangsan', '1234');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `fk_province` (`pid`),
  CONSTRAINT `fk_province` FOREIGN KEY (`pid`) REFERENCES `t_province` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=438 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', '东城区', '1');
INSERT INTO `t_city` VALUES ('2', '西城区', '1');
INSERT INTO `t_city` VALUES ('3', '崇文区', '1');
INSERT INTO `t_city` VALUES ('4', '宣武区', '1');
INSERT INTO `t_city` VALUES ('5', '朝阳区', '1');
INSERT INTO `t_city` VALUES ('6', '丰台区', '1');
INSERT INTO `t_city` VALUES ('7', '石景山区', '1');
INSERT INTO `t_city` VALUES ('8', '海淀区', '1');
INSERT INTO `t_city` VALUES ('9', '门头沟区', '1');
INSERT INTO `t_city` VALUES ('10', '房山区', '1');
INSERT INTO `t_city` VALUES ('11', '通州区', '1');
INSERT INTO `t_city` VALUES ('12', '顺义区', '1');
INSERT INTO `t_city` VALUES ('13', '昌平区', '1');
INSERT INTO `t_city` VALUES ('14', '大兴区', '1');
INSERT INTO `t_city` VALUES ('15', '怀柔区', '1');
INSERT INTO `t_city` VALUES ('16', '平谷区', '1');
INSERT INTO `t_city` VALUES ('17', '密云县', '1');
INSERT INTO `t_city` VALUES ('18', '延庆县', '1');
INSERT INTO `t_city` VALUES ('19', '和平区', '2');
INSERT INTO `t_city` VALUES ('20', '河东区', '2');
INSERT INTO `t_city` VALUES ('21', '河西区', '2');
INSERT INTO `t_city` VALUES ('22', '南开区', '2');
INSERT INTO `t_city` VALUES ('23', '河北区', '2');
INSERT INTO `t_city` VALUES ('24', '红桥区', '2');
INSERT INTO `t_city` VALUES ('25', '塘沽区', '2');
INSERT INTO `t_city` VALUES ('26', '汉沽区', '2');
INSERT INTO `t_city` VALUES ('27', '大港区', '2');
INSERT INTO `t_city` VALUES ('28', '东丽区', '2');
INSERT INTO `t_city` VALUES ('29', '西青区', '2');
INSERT INTO `t_city` VALUES ('30', '津南区', '2');
INSERT INTO `t_city` VALUES ('31', '北辰区', '2');
INSERT INTO `t_city` VALUES ('32', '武清区', '2');
INSERT INTO `t_city` VALUES ('33', '宝坻区', '2');
INSERT INTO `t_city` VALUES ('34', '宁河县', '2');
INSERT INTO `t_city` VALUES ('35', '静海县', '2');
INSERT INTO `t_city` VALUES ('36', '蓟县', '2');
INSERT INTO `t_city` VALUES ('37', '石家庄', '3');
INSERT INTO `t_city` VALUES ('38', '唐山', '3');
INSERT INTO `t_city` VALUES ('39', '秦皇岛', '3');
INSERT INTO `t_city` VALUES ('40', '邯郸', '3');
INSERT INTO `t_city` VALUES ('41', '邢台', '3');
INSERT INTO `t_city` VALUES ('42', '保定', '3');
INSERT INTO `t_city` VALUES ('43', '张家口', '3');
INSERT INTO `t_city` VALUES ('44', '承德', '3');
INSERT INTO `t_city` VALUES ('45', '沧州', '3');
INSERT INTO `t_city` VALUES ('46', '廊坊', '3');
INSERT INTO `t_city` VALUES ('47', '衡水', '3');
INSERT INTO `t_city` VALUES ('48', '太原', '4');
INSERT INTO `t_city` VALUES ('49', '大同', '4');
INSERT INTO `t_city` VALUES ('50', '阳泉', '4');
INSERT INTO `t_city` VALUES ('51', '长治', '4');
INSERT INTO `t_city` VALUES ('52', '晋城', '4');
INSERT INTO `t_city` VALUES ('53', '朔州', '4');
INSERT INTO `t_city` VALUES ('54', '晋中', '4');
INSERT INTO `t_city` VALUES ('55', '运城', '4');
INSERT INTO `t_city` VALUES ('56', '忻州', '4');
INSERT INTO `t_city` VALUES ('57', '临汾', '4');
INSERT INTO `t_city` VALUES ('58', '吕梁', '4');
INSERT INTO `t_city` VALUES ('59', '呼和浩特', '5');
INSERT INTO `t_city` VALUES ('60', '包头', '5');
INSERT INTO `t_city` VALUES ('61', '乌海', '5');
INSERT INTO `t_city` VALUES ('62', '赤峰', '5');
INSERT INTO `t_city` VALUES ('63', '通辽', '5');
INSERT INTO `t_city` VALUES ('64', '鄂尔多斯', '5');
INSERT INTO `t_city` VALUES ('65', '呼伦贝尔', '5');
INSERT INTO `t_city` VALUES ('66', '巴彦淖尔', '5');
INSERT INTO `t_city` VALUES ('67', '乌兰察布', '5');
INSERT INTO `t_city` VALUES ('68', '兴安盟', '5');
INSERT INTO `t_city` VALUES ('69', '锡林郭勒盟', '5');
INSERT INTO `t_city` VALUES ('70', '阿拉善盟', '5');
INSERT INTO `t_city` VALUES ('71', '沈阳', '6');
INSERT INTO `t_city` VALUES ('72', '大连', '6');
INSERT INTO `t_city` VALUES ('73', '鞍山', '6');
INSERT INTO `t_city` VALUES ('74', '抚顺', '6');
INSERT INTO `t_city` VALUES ('75', '本溪', '6');
INSERT INTO `t_city` VALUES ('76', '丹东', '6');
INSERT INTO `t_city` VALUES ('77', '锦州', '6');
INSERT INTO `t_city` VALUES ('78', '营口', '6');
INSERT INTO `t_city` VALUES ('79', '阜新', '6');
INSERT INTO `t_city` VALUES ('80', '辽阳', '6');
INSERT INTO `t_city` VALUES ('81', '盘锦', '6');
INSERT INTO `t_city` VALUES ('82', '铁岭', '6');
INSERT INTO `t_city` VALUES ('83', '朝阳', '6');
INSERT INTO `t_city` VALUES ('84', '葫芦岛', '6');
INSERT INTO `t_city` VALUES ('85', '长春', '7');
INSERT INTO `t_city` VALUES ('86', '吉林', '7');
INSERT INTO `t_city` VALUES ('87', '四平', '7');
INSERT INTO `t_city` VALUES ('88', '辽源', '7');
INSERT INTO `t_city` VALUES ('89', '通化', '7');
INSERT INTO `t_city` VALUES ('90', '白山', '7');
INSERT INTO `t_city` VALUES ('91', '松原', '7');
INSERT INTO `t_city` VALUES ('92', '白城', '7');
INSERT INTO `t_city` VALUES ('93', '延边', '7');
INSERT INTO `t_city` VALUES ('94', '哈尔滨', '8');
INSERT INTO `t_city` VALUES ('95', '齐齐哈尔', '8');
INSERT INTO `t_city` VALUES ('96', '鸡西', '8');
INSERT INTO `t_city` VALUES ('97', '鹤岗', '8');
INSERT INTO `t_city` VALUES ('98', '双鸭山', '8');
INSERT INTO `t_city` VALUES ('99', '大庆', '8');
INSERT INTO `t_city` VALUES ('100', '伊春', '8');
INSERT INTO `t_city` VALUES ('101', '佳木斯', '8');
INSERT INTO `t_city` VALUES ('102', '七台河', '8');
INSERT INTO `t_city` VALUES ('103', '牡丹江', '8');
INSERT INTO `t_city` VALUES ('104', '黑河', '8');
INSERT INTO `t_city` VALUES ('105', '绥化', '8');
INSERT INTO `t_city` VALUES ('106', '大兴安岭', '8');
INSERT INTO `t_city` VALUES ('107', '黄浦区', '9');
INSERT INTO `t_city` VALUES ('108', '卢湾区', '9');
INSERT INTO `t_city` VALUES ('109', '徐汇区', '9');
INSERT INTO `t_city` VALUES ('110', '长宁区', '9');
INSERT INTO `t_city` VALUES ('111', '静安区', '9');
INSERT INTO `t_city` VALUES ('112', '普陀区', '9');
INSERT INTO `t_city` VALUES ('113', '闸北区', '9');
INSERT INTO `t_city` VALUES ('114', '虹口区', '9');
INSERT INTO `t_city` VALUES ('115', '杨浦区', '9');
INSERT INTO `t_city` VALUES ('116', '闵行区', '9');
INSERT INTO `t_city` VALUES ('117', '宝山区', '9');
INSERT INTO `t_city` VALUES ('118', '嘉定区', '9');
INSERT INTO `t_city` VALUES ('119', '浦东新区', '9');
INSERT INTO `t_city` VALUES ('120', '金山区', '9');
INSERT INTO `t_city` VALUES ('121', '松江区', '9');
INSERT INTO `t_city` VALUES ('122', '青浦区', '9');
INSERT INTO `t_city` VALUES ('123', '南汇区', '9');
INSERT INTO `t_city` VALUES ('124', '奉贤区', '9');
INSERT INTO `t_city` VALUES ('125', '崇明县', '9');
INSERT INTO `t_city` VALUES ('126', '南京', '10');
INSERT INTO `t_city` VALUES ('127', '无锡', '10');
INSERT INTO `t_city` VALUES ('128', '徐州', '10');
INSERT INTO `t_city` VALUES ('129', '常州', '10');
INSERT INTO `t_city` VALUES ('130', '苏州', '10');
INSERT INTO `t_city` VALUES ('131', '南通', '10');
INSERT INTO `t_city` VALUES ('132', '连云港', '10');
INSERT INTO `t_city` VALUES ('133', '淮安', '10');
INSERT INTO `t_city` VALUES ('134', '盐城', '10');
INSERT INTO `t_city` VALUES ('135', '扬州', '10');
INSERT INTO `t_city` VALUES ('136', '镇江', '10');
INSERT INTO `t_city` VALUES ('137', '泰州', '10');
INSERT INTO `t_city` VALUES ('138', '宿迁', '10');
INSERT INTO `t_city` VALUES ('139', '杭州', '11');
INSERT INTO `t_city` VALUES ('140', '宁波', '11');
INSERT INTO `t_city` VALUES ('141', '温州', '11');
INSERT INTO `t_city` VALUES ('142', '嘉兴', '11');
INSERT INTO `t_city` VALUES ('143', '湖州', '11');
INSERT INTO `t_city` VALUES ('144', '绍兴', '11');
INSERT INTO `t_city` VALUES ('145', '金华', '11');
INSERT INTO `t_city` VALUES ('146', '衢州', '11');
INSERT INTO `t_city` VALUES ('147', '舟山', '11');
INSERT INTO `t_city` VALUES ('148', '台州', '11');
INSERT INTO `t_city` VALUES ('149', '丽水', '11');
INSERT INTO `t_city` VALUES ('150', '合肥', '12');
INSERT INTO `t_city` VALUES ('151', '芜湖', '12');
INSERT INTO `t_city` VALUES ('152', '蚌埠', '12');
INSERT INTO `t_city` VALUES ('153', '淮南', '12');
INSERT INTO `t_city` VALUES ('154', '马鞍山', '12');
INSERT INTO `t_city` VALUES ('155', '淮北', '12');
INSERT INTO `t_city` VALUES ('156', '铜陵', '12');
INSERT INTO `t_city` VALUES ('157', '安庆', '12');
INSERT INTO `t_city` VALUES ('158', '黄山', '12');
INSERT INTO `t_city` VALUES ('159', '滁州', '12');
INSERT INTO `t_city` VALUES ('160', '阜阳', '12');
INSERT INTO `t_city` VALUES ('161', '宿州', '12');
INSERT INTO `t_city` VALUES ('162', '巢湖', '12');
INSERT INTO `t_city` VALUES ('163', '六安', '12');
INSERT INTO `t_city` VALUES ('164', '亳州', '12');
INSERT INTO `t_city` VALUES ('165', '池州', '12');
INSERT INTO `t_city` VALUES ('166', '宣城', '12');
INSERT INTO `t_city` VALUES ('167', '福州', '13');
INSERT INTO `t_city` VALUES ('168', '厦门', '13');
INSERT INTO `t_city` VALUES ('169', '莆田', '13');
INSERT INTO `t_city` VALUES ('170', '三明', '13');
INSERT INTO `t_city` VALUES ('171', '泉州', '13');
INSERT INTO `t_city` VALUES ('172', '漳州', '13');
INSERT INTO `t_city` VALUES ('173', '南平', '13');
INSERT INTO `t_city` VALUES ('174', '龙岩', '13');
INSERT INTO `t_city` VALUES ('175', '宁德', '13');
INSERT INTO `t_city` VALUES ('176', '南昌', '14');
INSERT INTO `t_city` VALUES ('177', '景德镇', '14');
INSERT INTO `t_city` VALUES ('178', '萍乡', '14');
INSERT INTO `t_city` VALUES ('179', '九江', '14');
INSERT INTO `t_city` VALUES ('180', '新余', '14');
INSERT INTO `t_city` VALUES ('181', '鹰潭', '14');
INSERT INTO `t_city` VALUES ('182', '赣州', '14');
INSERT INTO `t_city` VALUES ('183', '吉安', '14');
INSERT INTO `t_city` VALUES ('184', '宜春', '14');
INSERT INTO `t_city` VALUES ('185', '抚州', '14');
INSERT INTO `t_city` VALUES ('186', '上饶', '14');
INSERT INTO `t_city` VALUES ('187', '济南', '15');
INSERT INTO `t_city` VALUES ('188', '青岛', '15');
INSERT INTO `t_city` VALUES ('189', '淄博', '15');
INSERT INTO `t_city` VALUES ('190', '枣庄', '15');
INSERT INTO `t_city` VALUES ('191', '东营', '15');
INSERT INTO `t_city` VALUES ('192', '烟台', '15');
INSERT INTO `t_city` VALUES ('193', '潍坊', '15');
INSERT INTO `t_city` VALUES ('194', '济宁', '15');
INSERT INTO `t_city` VALUES ('195', '泰安', '15');
INSERT INTO `t_city` VALUES ('196', '威海', '15');
INSERT INTO `t_city` VALUES ('197', '日照', '15');
INSERT INTO `t_city` VALUES ('198', '莱芜', '15');
INSERT INTO `t_city` VALUES ('199', '临沂', '15');
INSERT INTO `t_city` VALUES ('200', '德州', '15');
INSERT INTO `t_city` VALUES ('201', '聊城', '15');
INSERT INTO `t_city` VALUES ('202', '滨州', '15');
INSERT INTO `t_city` VALUES ('203', '荷泽', '15');
INSERT INTO `t_city` VALUES ('204', '郑州', '16');
INSERT INTO `t_city` VALUES ('205', '开封', '16');
INSERT INTO `t_city` VALUES ('206', '洛阳', '16');
INSERT INTO `t_city` VALUES ('207', '平顶山', '16');
INSERT INTO `t_city` VALUES ('208', '安阳', '16');
INSERT INTO `t_city` VALUES ('209', '鹤壁', '16');
INSERT INTO `t_city` VALUES ('210', '新乡', '16');
INSERT INTO `t_city` VALUES ('211', '焦作', '16');
INSERT INTO `t_city` VALUES ('212', '濮阳', '16');
INSERT INTO `t_city` VALUES ('213', '许昌', '16');
INSERT INTO `t_city` VALUES ('214', '漯河', '16');
INSERT INTO `t_city` VALUES ('215', '三门峡', '16');
INSERT INTO `t_city` VALUES ('216', '南阳', '16');
INSERT INTO `t_city` VALUES ('217', '商丘', '16');
INSERT INTO `t_city` VALUES ('218', '信阳', '16');
INSERT INTO `t_city` VALUES ('219', '周口', '16');
INSERT INTO `t_city` VALUES ('220', '驻马店', '16');
INSERT INTO `t_city` VALUES ('221', '武汉', '17');
INSERT INTO `t_city` VALUES ('222', '黄石', '17');
INSERT INTO `t_city` VALUES ('223', '十堰', '17');
INSERT INTO `t_city` VALUES ('224', '宜昌', '17');
INSERT INTO `t_city` VALUES ('225', '襄樊', '17');
INSERT INTO `t_city` VALUES ('226', '鄂州', '17');
INSERT INTO `t_city` VALUES ('227', '荆门', '17');
INSERT INTO `t_city` VALUES ('228', '孝感', '17');
INSERT INTO `t_city` VALUES ('229', '荆州', '17');
INSERT INTO `t_city` VALUES ('230', '黄冈', '17');
INSERT INTO `t_city` VALUES ('231', '咸宁', '17');
INSERT INTO `t_city` VALUES ('232', '随州', '17');
INSERT INTO `t_city` VALUES ('233', '恩施', '17');
INSERT INTO `t_city` VALUES ('234', '神农架', '17');
INSERT INTO `t_city` VALUES ('235', '长沙', '18');
INSERT INTO `t_city` VALUES ('236', '株洲', '18');
INSERT INTO `t_city` VALUES ('237', '湘潭', '18');
INSERT INTO `t_city` VALUES ('238', '衡阳', '18');
INSERT INTO `t_city` VALUES ('239', '邵阳', '18');
INSERT INTO `t_city` VALUES ('240', '岳阳', '18');
INSERT INTO `t_city` VALUES ('241', '常德', '18');
INSERT INTO `t_city` VALUES ('242', '张家界', '18');
INSERT INTO `t_city` VALUES ('243', '益阳', '18');
INSERT INTO `t_city` VALUES ('244', '郴州', '18');
INSERT INTO `t_city` VALUES ('245', '永州', '18');
INSERT INTO `t_city` VALUES ('246', '怀化', '18');
INSERT INTO `t_city` VALUES ('247', '娄底', '18');
INSERT INTO `t_city` VALUES ('248', '湘西', '18');
INSERT INTO `t_city` VALUES ('249', '广州', '19');
INSERT INTO `t_city` VALUES ('250', '韶关', '19');
INSERT INTO `t_city` VALUES ('251', '深圳', '19');
INSERT INTO `t_city` VALUES ('252', '珠海', '19');
INSERT INTO `t_city` VALUES ('253', '汕头', '19');
INSERT INTO `t_city` VALUES ('254', '佛山', '19');
INSERT INTO `t_city` VALUES ('255', '江门', '19');
INSERT INTO `t_city` VALUES ('256', '湛江', '19');
INSERT INTO `t_city` VALUES ('257', '茂名', '19');
INSERT INTO `t_city` VALUES ('258', '肇庆', '19');
INSERT INTO `t_city` VALUES ('259', '惠州', '19');
INSERT INTO `t_city` VALUES ('260', '梅州', '19');
INSERT INTO `t_city` VALUES ('261', '汕尾', '19');
INSERT INTO `t_city` VALUES ('262', '河源', '19');
INSERT INTO `t_city` VALUES ('263', '阳江', '19');
INSERT INTO `t_city` VALUES ('264', '清远', '19');
INSERT INTO `t_city` VALUES ('265', '东莞', '19');
INSERT INTO `t_city` VALUES ('266', '中山', '19');
INSERT INTO `t_city` VALUES ('267', '潮州', '19');
INSERT INTO `t_city` VALUES ('268', '揭阳', '19');
INSERT INTO `t_city` VALUES ('269', '云浮', '19');
INSERT INTO `t_city` VALUES ('270', '南宁', '20');
INSERT INTO `t_city` VALUES ('271', '柳州', '20');
INSERT INTO `t_city` VALUES ('272', '桂林', '20');
INSERT INTO `t_city` VALUES ('273', '梧州', '20');
INSERT INTO `t_city` VALUES ('274', '北海', '20');
INSERT INTO `t_city` VALUES ('275', '防城港', '20');
INSERT INTO `t_city` VALUES ('276', '钦州', '20');
INSERT INTO `t_city` VALUES ('277', '贵港', '20');
INSERT INTO `t_city` VALUES ('278', '玉林', '20');
INSERT INTO `t_city` VALUES ('279', '百色', '20');
INSERT INTO `t_city` VALUES ('280', '贺州', '20');
INSERT INTO `t_city` VALUES ('281', '河池', '20');
INSERT INTO `t_city` VALUES ('282', '来宾', '20');
INSERT INTO `t_city` VALUES ('283', '崇左', '20');
INSERT INTO `t_city` VALUES ('284', '海口', '21');
INSERT INTO `t_city` VALUES ('285', '三亚', '21');
INSERT INTO `t_city` VALUES ('286', '重庆', '22');
INSERT INTO `t_city` VALUES ('287', '万州区', '22');
INSERT INTO `t_city` VALUES ('288', '涪陵区', '22');
INSERT INTO `t_city` VALUES ('289', '渝中区', '22');
INSERT INTO `t_city` VALUES ('290', '大渡口区', '22');
INSERT INTO `t_city` VALUES ('291', '江北区', '22');
INSERT INTO `t_city` VALUES ('292', '沙坪坝区', '22');
INSERT INTO `t_city` VALUES ('293', '九龙坡区', '22');
INSERT INTO `t_city` VALUES ('294', '南岸区', '22');
INSERT INTO `t_city` VALUES ('295', '北碚区', '22');
INSERT INTO `t_city` VALUES ('296', '万盛区', '22');
INSERT INTO `t_city` VALUES ('297', '双桥区', '22');
INSERT INTO `t_city` VALUES ('298', '渝北区', '22');
INSERT INTO `t_city` VALUES ('299', '巴南区', '22');
INSERT INTO `t_city` VALUES ('300', '黔江区', '22');
INSERT INTO `t_city` VALUES ('301', '长寿区', '22');
INSERT INTO `t_city` VALUES ('302', '綦江县', '22');
INSERT INTO `t_city` VALUES ('303', '潼南县', '22');
INSERT INTO `t_city` VALUES ('304', '铜梁县', '22');
INSERT INTO `t_city` VALUES ('305', '大足县', '22');
INSERT INTO `t_city` VALUES ('306', '荣昌县', '22');
INSERT INTO `t_city` VALUES ('307', '璧山县', '22');
INSERT INTO `t_city` VALUES ('308', '梁平县', '22');
INSERT INTO `t_city` VALUES ('309', '城口县', '22');
INSERT INTO `t_city` VALUES ('310', '丰都县', '22');
INSERT INTO `t_city` VALUES ('311', '垫江县', '22');
INSERT INTO `t_city` VALUES ('312', '武隆县', '22');
INSERT INTO `t_city` VALUES ('313', '忠县', '22');
INSERT INTO `t_city` VALUES ('314', '开县', '22');
INSERT INTO `t_city` VALUES ('315', '云阳县', '22');
INSERT INTO `t_city` VALUES ('316', '奉节县', '22');
INSERT INTO `t_city` VALUES ('317', '巫山县', '22');
INSERT INTO `t_city` VALUES ('318', '巫溪县', '22');
INSERT INTO `t_city` VALUES ('319', '石柱土家族自治县', '22');
INSERT INTO `t_city` VALUES ('320', '秀山土家族苗族自治县', '22');
INSERT INTO `t_city` VALUES ('321', '酉阳土家族苗族自治县', '22');
INSERT INTO `t_city` VALUES ('322', '彭水苗族土家族自治县', '22');
INSERT INTO `t_city` VALUES ('323', '江津', '22');
INSERT INTO `t_city` VALUES ('324', '合川', '22');
INSERT INTO `t_city` VALUES ('325', '永川', '22');
INSERT INTO `t_city` VALUES ('326', '南川', '22');
INSERT INTO `t_city` VALUES ('327', '成都', '23');
INSERT INTO `t_city` VALUES ('328', '自贡', '23');
INSERT INTO `t_city` VALUES ('329', '攀枝花', '23');
INSERT INTO `t_city` VALUES ('330', '泸州', '23');
INSERT INTO `t_city` VALUES ('331', '德阳', '23');
INSERT INTO `t_city` VALUES ('332', '绵阳', '23');
INSERT INTO `t_city` VALUES ('333', '广元', '23');
INSERT INTO `t_city` VALUES ('334', '遂宁', '23');
INSERT INTO `t_city` VALUES ('335', '内江', '23');
INSERT INTO `t_city` VALUES ('336', '乐山', '23');
INSERT INTO `t_city` VALUES ('337', '南充', '23');
INSERT INTO `t_city` VALUES ('338', '眉山', '23');
INSERT INTO `t_city` VALUES ('339', '宜宾', '23');
INSERT INTO `t_city` VALUES ('340', '广安', '23');
INSERT INTO `t_city` VALUES ('341', '达州', '23');
INSERT INTO `t_city` VALUES ('342', '雅安', '23');
INSERT INTO `t_city` VALUES ('343', '巴中', '23');
INSERT INTO `t_city` VALUES ('344', '资阳', '23');
INSERT INTO `t_city` VALUES ('345', '阿坝', '23');
INSERT INTO `t_city` VALUES ('346', '甘孜', '23');
INSERT INTO `t_city` VALUES ('347', '凉山', '23');
INSERT INTO `t_city` VALUES ('348', '贵阳', '24');
INSERT INTO `t_city` VALUES ('349', '六盘水', '24');
INSERT INTO `t_city` VALUES ('350', '遵义', '24');
INSERT INTO `t_city` VALUES ('351', '安顺', '24');
INSERT INTO `t_city` VALUES ('352', '铜仁', '24');
INSERT INTO `t_city` VALUES ('353', '黔西南', '24');
INSERT INTO `t_city` VALUES ('354', '毕节', '24');
INSERT INTO `t_city` VALUES ('355', '黔东南', '24');
INSERT INTO `t_city` VALUES ('356', '黔南', '24');
INSERT INTO `t_city` VALUES ('357', '昆明', '25');
INSERT INTO `t_city` VALUES ('358', '曲靖', '25');
INSERT INTO `t_city` VALUES ('359', '玉溪', '25');
INSERT INTO `t_city` VALUES ('360', '保山', '25');
INSERT INTO `t_city` VALUES ('361', '昭通', '25');
INSERT INTO `t_city` VALUES ('362', '丽江', '25');
INSERT INTO `t_city` VALUES ('363', '思茅', '25');
INSERT INTO `t_city` VALUES ('364', '临沧', '25');
INSERT INTO `t_city` VALUES ('365', '楚雄', '25');
INSERT INTO `t_city` VALUES ('366', '红河', '25');
INSERT INTO `t_city` VALUES ('367', '文山', '25');
INSERT INTO `t_city` VALUES ('368', '西双版纳', '25');
INSERT INTO `t_city` VALUES ('369', '大理', '25');
INSERT INTO `t_city` VALUES ('370', '德宏', '25');
INSERT INTO `t_city` VALUES ('371', '怒江', '25');
INSERT INTO `t_city` VALUES ('372', '迪庆', '25');
INSERT INTO `t_city` VALUES ('373', '拉萨', '26');
INSERT INTO `t_city` VALUES ('374', '昌都', '26');
INSERT INTO `t_city` VALUES ('375', '山南', '26');
INSERT INTO `t_city` VALUES ('376', '日喀则', '26');
INSERT INTO `t_city` VALUES ('377', '那曲', '26');
INSERT INTO `t_city` VALUES ('378', '阿里', '26');
INSERT INTO `t_city` VALUES ('379', '林芝', '26');
INSERT INTO `t_city` VALUES ('380', '西安', '27');
INSERT INTO `t_city` VALUES ('381', '铜川', '27');
INSERT INTO `t_city` VALUES ('382', '宝鸡', '27');
INSERT INTO `t_city` VALUES ('383', '咸阳', '27');
INSERT INTO `t_city` VALUES ('384', '渭南', '27');
INSERT INTO `t_city` VALUES ('385', '延安', '27');
INSERT INTO `t_city` VALUES ('386', '汉中', '27');
INSERT INTO `t_city` VALUES ('387', '榆林', '27');
INSERT INTO `t_city` VALUES ('388', '安康', '27');
INSERT INTO `t_city` VALUES ('389', '商洛', '27');
INSERT INTO `t_city` VALUES ('390', '兰州', '28');
INSERT INTO `t_city` VALUES ('391', '嘉峪关', '28');
INSERT INTO `t_city` VALUES ('392', '金昌', '28');
INSERT INTO `t_city` VALUES ('393', '白银', '28');
INSERT INTO `t_city` VALUES ('394', '天水', '28');
INSERT INTO `t_city` VALUES ('395', '武威', '28');
INSERT INTO `t_city` VALUES ('396', '张掖', '28');
INSERT INTO `t_city` VALUES ('397', '平凉', '28');
INSERT INTO `t_city` VALUES ('398', '酒泉', '28');
INSERT INTO `t_city` VALUES ('399', '庆阳', '28');
INSERT INTO `t_city` VALUES ('400', '定西', '28');
INSERT INTO `t_city` VALUES ('401', '陇南', '28');
INSERT INTO `t_city` VALUES ('402', '临夏', '28');
INSERT INTO `t_city` VALUES ('403', '甘南', '28');
INSERT INTO `t_city` VALUES ('404', '西宁', '29');
INSERT INTO `t_city` VALUES ('405', '海东', '29');
INSERT INTO `t_city` VALUES ('406', '海北', '29');
INSERT INTO `t_city` VALUES ('407', '黄南', '29');
INSERT INTO `t_city` VALUES ('408', '海南', '29');
INSERT INTO `t_city` VALUES ('409', '果洛', '29');
INSERT INTO `t_city` VALUES ('410', '玉树', '29');
INSERT INTO `t_city` VALUES ('411', '海西', '29');
INSERT INTO `t_city` VALUES ('412', '银川', '30');
INSERT INTO `t_city` VALUES ('413', '石嘴山', '30');
INSERT INTO `t_city` VALUES ('414', '吴忠', '30');
INSERT INTO `t_city` VALUES ('415', '固原', '30');
INSERT INTO `t_city` VALUES ('416', '中卫', '30');
INSERT INTO `t_city` VALUES ('417', '乌鲁木齐', '31');
INSERT INTO `t_city` VALUES ('418', '克拉玛依', '31');
INSERT INTO `t_city` VALUES ('419', '吐鲁番', '31');
INSERT INTO `t_city` VALUES ('420', '哈密', '31');
INSERT INTO `t_city` VALUES ('421', '昌吉', '31');
INSERT INTO `t_city` VALUES ('422', '博尔塔拉', '31');
INSERT INTO `t_city` VALUES ('423', '巴音郭楞', '31');
INSERT INTO `t_city` VALUES ('424', '阿克苏', '31');
INSERT INTO `t_city` VALUES ('425', '克孜勒苏', '31');
INSERT INTO `t_city` VALUES ('426', '喀什', '31');
INSERT INTO `t_city` VALUES ('427', '和田', '31');
INSERT INTO `t_city` VALUES ('428', '伊犁', '31');
INSERT INTO `t_city` VALUES ('429', '塔城', '31');
INSERT INTO `t_city` VALUES ('430', '阿勒泰', '31');
INSERT INTO `t_city` VALUES ('431', '石河子', '31');
INSERT INTO `t_city` VALUES ('432', '阿拉尔', '31');
INSERT INTO `t_city` VALUES ('433', '图木舒克', '31');
INSERT INTO `t_city` VALUES ('434', '五家渠', '31');
INSERT INTO `t_city` VALUES ('435', '香港', '32');
INSERT INTO `t_city` VALUES ('436', '澳门', '33');
INSERT INTO `t_city` VALUES ('437', '台湾', '34');

-- ----------------------------
-- Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('1', '北京');
INSERT INTO `t_province` VALUES ('2', '天津');
INSERT INTO `t_province` VALUES ('3', '河北');
INSERT INTO `t_province` VALUES ('4', '山西');
INSERT INTO `t_province` VALUES ('5', '内蒙古');
INSERT INTO `t_province` VALUES ('6', '辽宁');
INSERT INTO `t_province` VALUES ('7', '吉林');
INSERT INTO `t_province` VALUES ('8', '黑龙江');
INSERT INTO `t_province` VALUES ('9', '上海');
INSERT INTO `t_province` VALUES ('10', '江苏');
INSERT INTO `t_province` VALUES ('11', '浙江');
INSERT INTO `t_province` VALUES ('12', '安徽');
INSERT INTO `t_province` VALUES ('13', '福建');
INSERT INTO `t_province` VALUES ('14', '江西');
INSERT INTO `t_province` VALUES ('15', '山东');
INSERT INTO `t_province` VALUES ('16', '河南');
INSERT INTO `t_province` VALUES ('17', '湖北');
INSERT INTO `t_province` VALUES ('18', '湖南');
INSERT INTO `t_province` VALUES ('19', '广东');
INSERT INTO `t_province` VALUES ('20', '广西');
INSERT INTO `t_province` VALUES ('21', '海南');
INSERT INTO `t_province` VALUES ('22', '重庆');
INSERT INTO `t_province` VALUES ('23', '四川');
INSERT INTO `t_province` VALUES ('24', '贵州');
INSERT INTO `t_province` VALUES ('25', '云南');
INSERT INTO `t_province` VALUES ('26', '西藏');
INSERT INTO `t_province` VALUES ('27', '陕西');
INSERT INTO `t_province` VALUES ('28', '甘肃');
INSERT INTO `t_province` VALUES ('29', '青海');
INSERT INTO `t_province` VALUES ('30', '宁夏');
INSERT INTO `t_province` VALUES ('31', '新疆');
INSERT INTO `t_province` VALUES ('32', '香港');
INSERT INTO `t_province` VALUES ('33', '澳门');
INSERT INTO `t_province` VALUES ('34', '台湾');
