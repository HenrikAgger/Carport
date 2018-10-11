-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Lego
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Lego
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Lego` DEFAULT CHARACTER SET latin1 ;
USE `Lego` ;

-- -----------------------------------------------------
-- Table `Lego`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Lego`.`user` (
  `userId` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 1,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Lego`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Lego`.`order` (
  `orderId` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `height` INT(11) NOT NULL,
  `shipped` INT(11) NOT NULL,
  `user_userId` INT(11) NOT NULL,
  PRIMARY KEY (`orderId`, `user_userId`),
  UNIQUE INDEX `orderId_UNIQUE` (`orderId` ASC),
  INDEX `fk_order_user_idx` (`user_userId` ASC),
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_userId`)
    REFERENCES `Lego`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
