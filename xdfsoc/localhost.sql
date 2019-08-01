-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2019 �?08 �?01 �?10:43
-- 服务器版本: 5.5.53
-- PHP 版本: 5.6.27

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `logistics`
--
CREATE DATABASE `logistics` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `logistics`;

-- --------------------------------------------------------

--
-- 表的结构 `billrelease`
--

CREATE TABLE IF NOT EXISTS `billrelease` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accept_station` varchar(50) DEFAULT NULL,
  `bill_code` varchar(50) DEFAULT NULL,
  `bill_type` varchar(50) DEFAULT NULL,
  `receive_bill_person` varchar(50) DEFAULT NULL,
  `receive_bill_time` date DEFAULT NULL,
  `release_person` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `callbackinfo`
--

CREATE TABLE IF NOT EXISTS `callbackinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` varchar(50) DEFAULT NULL,
  `bill_type` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `dial_no` varchar(50) DEFAULT NULL,
  `finally_dial_time` date DEFAULT NULL,
  `goods_bill_id` varchar(50) DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `success` bit(1) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `write_time` date DEFAULT NULL,
  `writer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `cargoerror`
--

CREATE TABLE IF NOT EXISTS `cargoerror` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer` varchar(50) DEFAULT NULL,
  `goods_bill_code` varchar(50) DEFAULT NULL,
  `goods_name` varchar(50) DEFAULT NULL,
  `goods_revert_bill_code` varchar(50) DEFAULT NULL,
  `goods_value` double DEFAULT NULL,
  `mistake_type` varchar(50) DEFAULT NULL,
  `piece_amount` int(11) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `cargoreceipt`
--

CREATE TABLE IF NOT EXISTS `cargoreceipt` (
  `goods_revert_bill_code` varchar(50) NOT NULL,
  `accept_station` varchar(50) DEFAULT NULL,
  `all_carriage` double NOT NULL,
  `arrive_time` date DEFAULT NULL,
  `back_bill_state` varchar(50) DEFAULT NULL,
  `carriage_banlance_mode` varchar(50) DEFAULT NULL,
  `carriage_mode` varchar(50) DEFAULT NULL,
  `carry_goods_bill_deposit` double NOT NULL,
  `carry_goods_insurance` double NOT NULL,
  `deal_goods_station` varchar(50) DEFAULT NULL,
  `dispatch_service_fee` double NOT NULL,
  `driver_id` varchar(50) DEFAULT NULL,
  `if_balance` varchar(50) DEFAULT NULL,
  `insurance` double NOT NULL,
  `linkman_phone` varchar(50) DEFAULT NULL,
  `load_station` varchar(50) DEFAULT NULL,
  `receive_goods_detail_addr` varchar(50) DEFAULT NULL,
  `receive_goods_linkman` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `sign_time` date DEFAULT NULL,
  `start_advance` double NOT NULL,
  `start_carry_time` date DEFAULT NULL,
  PRIMARY KEY (`goods_revert_bill_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `cargoreceiptdetail`
--

CREATE TABLE IF NOT EXISTS `cargoreceiptdetail` (
  `goods_revert_bill_id` varchar(50) NOT NULL,
  `goods_bill_detail_id` varchar(255) DEFAULT NULL,
  `goods_value` double NOT NULL,
  `piece_amount` int(11) NOT NULL,
  `price_mode` varchar(50) NOT NULL,
  `price_standard` varchar(50) NOT NULL,
  `volume` double NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`goods_revert_bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `cityexpand`
--

CREATE TABLE IF NOT EXISTS `cityexpand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `range_city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `compensationinfo`
--

CREATE TABLE IF NOT EXISTS `compensationinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amends` double NOT NULL,
  `amends_time` date DEFAULT NULL,
  `bad_destroy_goods` double NOT NULL,
  `customer` varchar(50) DEFAULT NULL,
  `receive_station_id` int(11) NOT NULL,
  `receive_station_name` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `complaintinfo`
--

CREATE TABLE IF NOT EXISTS `complaintinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appeal_content` varchar(50) DEFAULT NULL,
  `appeal_date` varchar(50) DEFAULT NULL,
  `call_back_date` varchar(50) DEFAULT NULL,
  `customer` varchar(50) DEFAULT NULL,
  `deal_date` varchar(50) DEFAULT NULL,
  `deal_person` varchar(50) DEFAULT NULL,
  `deal_result` varchar(50) DEFAULT NULL,
  `goods_bill_code` varchar(50) DEFAULT NULL,
  `if_callback` bit(1) DEFAULT NULL,
  `if_handle` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `customeramount`
--

CREATE TABLE IF NOT EXISTS `customeramount` (
  `send_goods_customer` varchar(50) NOT NULL,
  `carriage_total` double NOT NULL,
  `insurance_total` double NOT NULL,
  `piece_amount_total` int(11) NOT NULL,
  PRIMARY KEY (`send_goods_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `customerbillclear`
--

CREATE TABLE IF NOT EXISTS `customerbillclear` (
  `goods_bill_code` varchar(50) NOT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `balance_time` date DEFAULT NULL,
  `balance_type` varchar(50) DEFAULT NULL,
  `bill_money` double DEFAULT NULL,
  `carriage_reduce_fund` double DEFAULT NULL,
  `carry_goods_fee` double DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `money_receivable` double DEFAULT NULL,
  `pay_kickback` double DEFAULT NULL,
  `prepay_money` double DEFAULT NULL,
  `received_money` double DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `customerinfo`
--

CREATE TABLE IF NOT EXISTS `customerinfo` (
  `customer_code` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `customer` varchar(50) DEFAULT NULL,
  `customer_type` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `enterprise_property` varchar(50) DEFAULT NULL,
  `enterprise_size` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `linkman_mobile` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `post_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `customerreceiptinfo`
--

CREATE TABLE IF NOT EXISTS `customerreceiptinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carry_bill_event_id` int(11) NOT NULL,
  `check_goods_record` varchar(50) DEFAULT NULL,
  `customer` varchar(50) DEFAULT NULL,
  `goods_bill_code` varchar(50) DEFAULT NULL,
  `receive_goods_date` date DEFAULT NULL,
  `receive_goods_person` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `driveramount`
--

CREATE TABLE IF NOT EXISTS `driveramount` (
  `driver_code` varchar(50) NOT NULL,
  `add_carriage_total` double NOT NULL,
  `carry_fee_total` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`driver_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `driverclear`
--

CREATE TABLE IF NOT EXISTS `driverclear` (
  `back_bill_code` varchar(50) NOT NULL,
  `add_carriage` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `balance_time` date DEFAULT NULL,
  `balance_type` varchar(50) DEFAULT NULL,
  `bind_insurance` double DEFAULT NULL,
  `carry_fee` double DEFAULT NULL,
  `dispatch_service_fee` double DEFAULT NULL,
  `driver_code` varchar(50) DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `need_payment` double DEFAULT NULL,
  `payed_money` double DEFAULT NULL,
  `prepay_money` double DEFAULT NULL,
  PRIMARY KEY (`back_bill_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `driverinfo`
--

CREATE TABLE IF NOT EXISTS `driverinfo` (
  `id` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `allow_carry_volume` double DEFAULT NULL,
  `allow_carry_weight` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `biz_licence` varchar(50) DEFAULT NULL,
  `car_dept` varchar(50) DEFAULT NULL,
  `car_dept_tel` varchar(50) DEFAULT NULL,
  `car_frame_no` varchar(50) DEFAULT NULL,
  `car_length` varchar(50) DEFAULT NULL,
  `car_no` varchar(50) DEFAULT NULL,
  `car_type` varchar(50) DEFAULT NULL,
  `car_width` varchar(50) DEFAULT NULL,
  `company_car` bit(1) NOT NULL,
  `drive_licence` varchar(50) DEFAULT NULL,
  `driver_name` varchar(50) DEFAULT NULL,
  `engine_no` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `goods_height` varchar(50) DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `insurance_card` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `run_licence` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_code` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `employee_name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `employeeuser`
--

CREATE TABLE IF NOT EXISTS `employeeuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `employeewage`
--

CREATE TABLE IF NOT EXISTS `employeewage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `allowance` double NOT NULL,
  `basic_wage` double NOT NULL,
  `date` date DEFAULT NULL,
  `employee` varchar(50) DEFAULT NULL,
  `employee_code` varchar(50) NOT NULL,
  `station_wage` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `extraclear`
--

CREATE TABLE IF NOT EXISTS `extraclear` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance_date` date DEFAULT NULL,
  `balance_money` double DEFAULT NULL,
  `balance_type` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `subject_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `extraincome`
--

CREATE TABLE IF NOT EXISTS `extraincome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `income_month` varchar(255) DEFAULT NULL,
  `money` double NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `financefee`
--

CREATE TABLE IF NOT EXISTS `financefee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee` double NOT NULL,
  `payout_month` varchar(255) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `function_`
--

CREATE TABLE IF NOT EXISTS `function_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_function` varchar(50) DEFAULT NULL,
  `page_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `functionwithgroup`
--

CREATE TABLE IF NOT EXISTS `functionwithgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `function_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `goodsbill`
--

CREATE TABLE IF NOT EXISTS `goodsbill` (
  `goods_bill_code` varchar(50) NOT NULL,
  `accept_procedure_rate` varchar(50) DEFAULT NULL,
  `accept_station` varchar(100) DEFAULT NULL,
  `carriage` double DEFAULT NULL,
  `carry_goods_fee` double DEFAULT NULL,
  `employee_code` varchar(50) DEFAULT NULL,
  `fact_deal_date` date DEFAULT NULL,
  `fetch_goods_mode` varchar(50) DEFAULT NULL,
  `help_accept_payment` double DEFAULT NULL,
  `if_audit` bit(1) DEFAULT NULL,
  `if_settle_accounts` bit(1) DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `money_of_change_pay` double DEFAULT NULL,
  `pay_kickback` double DEFAULT NULL,
  `pay_mode` varchar(50) DEFAULT NULL,
  `predelivery_date` date DEFAULT NULL,
  `receive_goods_addr` varchar(50) DEFAULT NULL,
  `receive_goods_customer` varchar(50) DEFAULT NULL,
  `receive_goods_customer_addr` varchar(50) DEFAULT NULL,
  `receive_goods_customer_code` varchar(50) DEFAULT NULL,
  `receive_goods_customer_tel` varchar(50) DEFAULT NULL,
  `reduce_fund` double DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `send_goods_addr` varchar(50) DEFAULT NULL,
  `send_goods_customer` varchar(50) DEFAULT NULL,
  `send_goods_customer_addr` varchar(50) DEFAULT NULL,
  `send_goods_customer_no` varchar(50) DEFAULT NULL,
  `send_goods_customer_tel` varchar(50) DEFAULT NULL,
  `send_goods_date` date DEFAULT NULL,
  `transfer_fee` double DEFAULT NULL,
  `transfer_station` varchar(50) DEFAULT NULL,
  `validity` bit(1) DEFAULT NULL,
  `write_bill_person` varchar(50) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `goodsreceiptinfo`
--

CREATE TABLE IF NOT EXISTS `goodsreceiptinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_goods_record` varchar(50) DEFAULT NULL,
  `driver_name` varchar(50) DEFAULT NULL,
  `goods_revert_code` varchar(50) DEFAULT NULL,
  `rceive_goods_date` date DEFAULT NULL,
  `receive_goods_person` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `incomemonthlytemp`
--

CREATE TABLE IF NOT EXISTS `incomemonthlytemp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biz_fee` double NOT NULL,
  `biz_income` double NOT NULL,
  `car_carriage` double NOT NULL,
  `carriage_money` double NOT NULL,
  `convey_wage` double NOT NULL,
  `finance_fee` double NOT NULL,
  `house_rent` double NOT NULL,
  `income` double NOT NULL,
  `insurance_money` double NOT NULL,
  `manage_fee` double NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  `office_fee` double NOT NULL,
  `other` double NOT NULL,
  `payout` double NOT NULL,
  `phone_fee` double NOT NULL,
  `profit` double NOT NULL,
  `unbiz_income` double NOT NULL,
  `wage` double NOT NULL,
  `water_elec_fee` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `incomemonthlytemp`
--

INSERT INTO `incomemonthlytemp` (`id`, `biz_fee`, `biz_income`, `car_carriage`, `carriage_money`, `convey_wage`, `finance_fee`, `house_rent`, `income`, `insurance_money`, `manage_fee`, `month`, `office_fee`, `other`, `payout`, `phone_fee`, `profit`, `unbiz_income`, `wage`, `water_elec_fee`) VALUES
(1, 500, 0, 500, 0, 0, 0, 0, 0, 0, 0, '2019-07', 0, 0, 500, 0, -500, 0, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `lineoverall`
--

CREATE TABLE IF NOT EXISTS `lineoverall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `all_carriage_total` double NOT NULL,
  `deal_goods_station` varchar(50) DEFAULT NULL,
  `insurance_total` double NOT NULL,
  `load_station` varchar(50) DEFAULT NULL,
  `times` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `managefee`
--

CREATE TABLE IF NOT EXISTS `managefee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_rent` double NOT NULL,
  `office_fee` double NOT NULL,
  `other_payout` double NOT NULL,
  `payout_month` varchar(255) DEFAULT NULL,
  `phone_fee` double NOT NULL,
  `water_elec_fee` double NOT NULL,
  `write_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `proxyfeeclear`
--

CREATE TABLE IF NOT EXISTS `proxyfeeclear` (
  `goods_bill_code` varchar(50) NOT NULL,
  `account_receivable` double DEFAULT NULL,
  `balance_date` date DEFAULT NULL,
  `commision_rate` float DEFAULT NULL,
  `commision_receivable` double DEFAULT NULL,
  `customer_code` varchar(50) DEFAULT NULL,
  `fact_receive_fund` double DEFAULT NULL,
  `goods_pay_change` double DEFAULT NULL,
  `received_commision` double DEFAULT NULL,
  PRIMARY KEY (`goods_bill_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `routeinfo`
--

CREATE TABLE IF NOT EXISTS `routeinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distance` double NOT NULL,
  `end_station` int(11) DEFAULT NULL,
  `fetch_time` double NOT NULL,
  `pass_station` varchar(100) DEFAULT NULL,
  `start_station` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `sentlist`
--

CREATE TABLE IF NOT EXISTS `sentlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `back_cost` double NOT NULL,
  `car_card_no` varchar(50) DEFAULT NULL,
  `cash_pay` double NOT NULL,
  `driver_name` varchar(50) DEFAULT NULL,
  `goods_code` varchar(50) DEFAULT NULL,
  `goods_name` varchar(50) DEFAULT NULL,
  `goods_revert_bill_code` varchar(50) DEFAULT NULL,
  `help_accept_fund` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `pickup_pay` double NOT NULL,
  `piece_amount` int(11) NOT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `send_goods_customer` varchar(50) DEFAULT NULL,
  `send_goods_customer_tel` varchar(50) DEFAULT NULL,
  `transfer_destination` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `transfercominfo`
--

CREATE TABLE IF NOT EXISTS `transfercominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `detail_address` varchar(200) DEFAULT NULL,
  `link_phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `transferinfo`
--

CREATE TABLE IF NOT EXISTS `transferinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `after_transfer_bill` varchar(50) DEFAULT NULL,
  `check_time` date DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `goods_bill_code` varchar(50) DEFAULT NULL,
  `transfer_addr` varchar(50) DEFAULT NULL,
  `transfer_check` varchar(50) DEFAULT NULL,
  `transfer_company` varchar(50) DEFAULT NULL,
  `transfer_fee` double DEFAULT NULL,
  `transfer_station` varchar(50) DEFAULT NULL,
  `transfer_station_tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `login_id` varchar(50) NOT NULL,
  `if_online` bit(1) DEFAULT b'0',
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `usergroup`
--

CREATE TABLE IF NOT EXISTS `usergroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `usergroup`
--

INSERT INTO `usergroup` (`id`, `description`, `group_name`) VALUES
(1, 'test', 'test');

-- --------------------------------------------------------

--
-- 表的结构 `userwithgroup`
--

CREATE TABLE IF NOT EXISTS `userwithgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `vultype`
--

CREATE TABLE IF NOT EXISTS `vultype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vul_name` varchar(200) DEFAULT NULL,
  `vul_desc` varchar(20000) DEFAULT NULL,
  `vul_res` mediumtext,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `vultype`
--

INSERT INTO `vultype` (`id`, `vul_name`, `vul_desc`, `vul_res`) VALUES
(1, 'XSS', '存储型XSS', '过滤转义'),
(4, 'SQL注入', 'SQL注入', 'SQL注入'),
(5, '代码执行', '代码执行', '代码执行'),
(7, 'test', 'test', 'teste'),
(8, 'test', 'test', 'test'),
(9, 'test', 'test', 'test'),
(10, 'test', 'test', 'test');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
