-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport` DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci ;
USE `carport` ;

-- -----------------------------------------------------
-- Table `carport`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`Customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_danish_ci;


-- -----------------------------------------------------
-- Table `carport`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`Order` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` VARCHAR(45) NOT NULL,
  `Customer_customer_id` INT(11) NOT NULL,
  PRIMARY KEY (`order_id`, `Customer_customer_id`),
  INDEX `order_id_idx` (`order_id` ASC),
  INDEX `fk_Order_Customer_idx` (`Customer_customer_id` ASC),
  CONSTRAINT `fk_Order_Customer`
    FOREIGN KEY (`Customer_customer_id`)
    REFERENCES `carport`.`Customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_danish_ci;


-- -----------------------------------------------------
-- Table `carport`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`Products` (
  `product_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `length` INT(11) NOT NULL,
  `unit` INT(11) NOT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_danish_ci;


-- -----------------------------------------------------
-- Table `carport`.`LineItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carport`.`LineItems` (
  `order_id` INT(11) NOT NULL,
  `amout` INT(11) NOT NULL,
  `Order_order_id` INT(11) NOT NULL,
  `Order_Customer_customer_id` INT(11) NOT NULL,
  `Products_product_id` INT NOT NULL,
  PRIMARY KEY (`order_id`, `Order_order_id`, `Order_Customer_customer_id`, `Products_product_id`),
  INDEX `fk_LineItems_Order1_idx` (`Order_order_id` ASC, `Order_Customer_customer_id` ASC),
  INDEX `fk_LineItems_Products1_idx` (`Products_product_id` ASC),
  CONSTRAINT `fk_LineItems_Order1`
    FOREIGN KEY (`Order_order_id` , `Order_Customer_customer_id`)
    REFERENCES `carport`.`Order` (`order_id` , `Customer_customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LineItems_Products1`
    FOREIGN KEY (`Products_product_id`)
    REFERENCES `carport`.`Products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_danish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
