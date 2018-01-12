SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema apuracao_escola_samba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apuracao_escola_samba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apuracao_escola_samba` DEFAULT CHARACTER SET utf8 ;
USE `apuracao_escola_samba` ;

-- -----------------------------------------------------
-- Table `escola_samba`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `escola_samba` ;

CREATE TABLE IF NOT EXISTS `escola_samba` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NOT NULL,
  `cnpj` CHAR(14) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '		';

CREATE UNIQUE INDEX `cnpj_UNIQUE` ON `escola_samba` (`cnpj` ASC);


-- -----------------------------------------------------
-- Table `quesito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `quesito` ;

CREATE TABLE IF NOT EXISTS `quesito` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `peso` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `nome_UNIQUE` ON `quesito` (`nome` ASC);


-- -----------------------------------------------------
-- Table `jurado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jurado` ;

CREATE TABLE IF NOT EXISTS `jurado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cpf_UNIQUE` ON `jurado` (`cpf` ASC);


-- -----------------------------------------------------
-- Table `nota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nota` ;

CREATE TABLE IF NOT EXISTS `nota` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nota` TINYINT NOT NULL,
  `escola_samba_id` INT NOT NULL,
  `quesito_id` INT NOT NULL,
  `jurado_id` INT NOT NULL,
  PRIMARY KEY (`id`, `escola_samba_id`, `jurado_id`, `quesito_id`),
  CONSTRAINT `fk_nota_escola_samba`
    FOREIGN KEY (`escola_samba_id`)
    REFERENCES `escola_samba` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_quesito1`
    FOREIGN KEY (`quesito_id`)
    REFERENCES `quesito` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_jurado1`
    FOREIGN KEY (`jurado_id`)
    REFERENCES `jurado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_nota_escola_samba_idx` ON `nota` (`escola_samba_id` ASC);

CREATE INDEX `fk_nota_quesito1_idx` ON `nota` (`quesito_id` ASC);

CREATE INDEX `fk_nota_jurado1_idx` ON `nota` (`jurado_id` ASC);

CREATE UNIQUE INDEX `uk_nota` ON `nota` (`escola_samba_id` ASC, `quesito_id` ASC, `jurado_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
