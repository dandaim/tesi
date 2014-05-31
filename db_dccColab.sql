SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `dcc_colab`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`usuario` (
  `id` INT NOT NULL,
  `idFacebook` INT NULL,
  `tipo` ENUM('USUARIO','PROFESSOR','ADMIN') NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`usuarioFacebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`usuarioFacebook` (
  `idFace` INT NOT NULL,
  `nomeFace` VARCHAR(150) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`idFace`, `usuario_id`),
  INDEX `fk_usuarioFacebook_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_usuarioFacebook_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`tema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`tema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  `disciplina_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tema_disciplina_idx` (`disciplina_id` ASC),
  CONSTRAINT `fk_tema_disciplina`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `dcc_colab`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`disciplinaProfessor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`disciplinaProfessor` (
  `disciplina_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`disciplina_id`, `usuario_id`),
  INDEX `fk_disciplina_has_usuario_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_disciplina_has_usuario_disciplina1_idx` (`disciplina_id` ASC),
  CONSTRAINT `fk_disciplina_has_usuario_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `dcc_colab`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`prova`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`prova` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `src` VARCHAR(255) NOT NULL,
  `ano` YEAR NOT NULL,
  `periodo` TINYINT NOT NULL,
  `usuario_id` INT NOT NULL,
  `disciplina_id` INT NOT NULL,
  `professor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_prova_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_prova_disciplinaProfessor1_idx` (`disciplina_id` ASC, `professor_id` ASC),
  CONSTRAINT `fk_prova_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_disciplinaProfessor1`
    FOREIGN KEY (`disciplina_id` , `professor_id`)
    REFERENCES `dcc_colab`.`disciplinaProfessor` (`disciplina_id` , `usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`conteudoProva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`conteudoProva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `src` VARCHAR(255) NOT NULL,
  `prova_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_conteudoProva_prova1_idx` (`prova_id` ASC),
  INDEX `fk_conteudoProva_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_conteudoProva_prova1`
    FOREIGN KEY (`prova_id`)
    REFERENCES `dcc_colab`.`prova` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conteudoProva_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`conteudoTema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`conteudoTema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `src` VARCHAR(255) NOT NULL,
  `tema_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_conteudoTema_tema1_idx` (`tema_id` ASC),
  INDEX `fk_conteudoTema_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_conteudoTema_tema1`
    FOREIGN KEY (`tema_id`)
    REFERENCES `dcc_colab`.`tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conteudoTema_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`provaTema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`provaTema` (
  `tema_id` INT NOT NULL,
  `prova_id` INT NOT NULL,
  PRIMARY KEY (`tema_id`, `prova_id`),
  INDEX `fk_prova_has_tema_tema1_idx` (`tema_id` ASC),
  INDEX `fk_prova_has_tema_prova1_idx` (`prova_id` ASC),
  CONSTRAINT `fk_prova_has_tema_prova1`
    FOREIGN KEY (`prova_id`)
    REFERENCES `dcc_colab`.`prova` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_has_tema_tema1`
    FOREIGN KEY (`tema_id`)
    REFERENCES `dcc_colab`.`tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`avalProva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`avalProva` (
  `usuario_id` INT NOT NULL,
  `prova_id` INT NOT NULL,
  `tipo` ENUM('RATE', 'REPORT') NOT NULL,
  `nota` TINYINT UNSIGNED NULL,
  PRIMARY KEY (`usuario_id`, `prova_id`),
  INDEX `fk_prova_has_usuario_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_prova_has_usuario_prova1_idx` (`prova_id` ASC),
  CONSTRAINT `fk_prova_has_usuario_prova1`
    FOREIGN KEY (`prova_id`)
    REFERENCES `dcc_colab`.`prova` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prova_has_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`avalConteudoProva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`avalConteudoProva` (
  `conteudoProva_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `tipo` ENUM('RATE', 'REPORT') NOT NULL,
  `nota` TINYINT NULL,
  PRIMARY KEY (`conteudoProva_id`, `usuario_id`),
  INDEX `fk_conteudoProva_has_usuario_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_conteudoProva_has_usuario_conteudoProva1_idx` (`conteudoProva_id` ASC),
  CONSTRAINT `fk_conteudoProva_has_usuario_conteudoProva1`
    FOREIGN KEY (`conteudoProva_id`)
    REFERENCES `dcc_colab`.`conteudoProva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conteudoProva_has_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dcc_colab`.`avalConteudoTema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dcc_colab`.`avalConteudoTema` (
  `conteudoTema_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `tipo` ENUM('RATE', 'REPORT') NULL,
  `nota` TINYINT NULL,
  PRIMARY KEY (`conteudoTema_id`, `usuario_id`),
  INDEX `fk_conteudoTema_has_usuario_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_conteudoTema_has_usuario_conteudoTema1_idx` (`conteudoTema_id` ASC),
  CONSTRAINT `fk_conteudoTema_has_usuario_conteudoTema1`
    FOREIGN KEY (`conteudoTema_id`)
    REFERENCES `dcc_colab`.`conteudoTema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conteudoTema_has_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dcc_colab`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
