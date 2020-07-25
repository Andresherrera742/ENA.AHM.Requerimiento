-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema requerimientos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema requerimientos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `requerimientos` DEFAULT CHARACTER SET utf8 ;
USE `requerimientos` ;

-- -----------------------------------------------------
-- Table `requerimientos`.`arearesolutora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`arearesolutora` (
  `areaResolutoraId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcionArea` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`areaResolutoraId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `requerimientos`.`gerencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`gerencia` (
  `gerenciaId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcionGerencia` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`gerenciaId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `requerimientos`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`departamento` (
  `departamentoId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descripcionDepartamento` VARCHAR(45) NOT NULL COMMENT '',
  `gerenciaId` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`departamentoId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `requerimientos`.`resolutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`resolutor` (
  `resolutorId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombreResolutor` VARCHAR(45) NOT NULL COMMENT '',
  `areaResolutorId` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`resolutorId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `requerimientos`.`requerimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`requerimiento` (
  `requerimientoId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `gerenciaId` INT(11) NOT NULL COMMENT '',
  `departamentoId` INT(11) NOT NULL COMMENT '',
  `areaResolutoraId` INT(11) NOT NULL COMMENT '',
  `resolutorId` INT(11) NOT NULL COMMENT '',
  `fechaIngreso` DATETIME NOT NULL COMMENT '',
  `requerimiento` VARCHAR(150) NOT NULL COMMENT '',
  `estado` VARCHAR(45) NOT NULL COMMENT '',
  `fechaCierre` DATETIME NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`requerimientoId`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `requerimientos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `requerimientos`.`usuario` (
  `usuarioid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `usuario` VARCHAR(45) NOT NULL COMMENT '',
  `contraseña` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`usuarioid`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
