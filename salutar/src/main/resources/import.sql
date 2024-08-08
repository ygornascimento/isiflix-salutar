CREATE SCHEMA IF NOT EXISTS `db_salutar` ;
USE `db_salutar` ;

CREATE TABLE IF NOT EXISTS `db_salutar`.`tbl_fichapaciente` (
  `id_ficha` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `data_nasc` DATETIME NULL,
  `sexo` VARCHAR(1) NULL,
  `cep` VARCHAR(10) NULL,
  `endereco` VARCHAR(100) NULL,
  `numero_complemento` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NULL,
  `ocupacao` VARCHAR(45) NULL,
  `diagnostico_clinico` TEXT NULL,
  `queixa_principal` TEXT NULL,
  `hmp_hma` TEXT NULL,
  `medicacoes` TEXT NULL,
  `exames_complementares` TEXT NULL,
  `exame_fisico` TEXT NULL,
  `conduta_clinica` TEXT NULL,
  `diagnostico` TEXT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  `link_foto` VARCHAR(255) NULL,
  PRIMARY KEY (`id_ficha`),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE)
  
  
 CREATE TABLE IF NOT EXISTS `db_salutar`.`tbl_midia` (
  `num_seq` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL,
  `link_midia` VARCHAR(255) NULL,
  `id_ficha` INT NOT NULL,
  PRIMARY KEY (`num_seq`),
  INDEX `fk_tbl_midia_tbl_fichapaciente_idx` (`id_ficha` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_midia_tbl_fichapaciente`
    FOREIGN KEY (`id_ficha`)
    REFERENCES `db_salutar`.`tbl_fichapaciente` (`id_ficha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    
 CREATE TABLE IF NOT EXISTS `db_salutar`.`tbl_usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome_usuario` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id_usuario`))

insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (10, 'Professor Isidro', '1978-10-04', 'M', 'abc');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (20, 'Evandro Lopes', '1990-01-01', 'M', 'abd');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (30, 'Maristela', '1991-01-01', 'F', 'abe');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (40, 'Guto Silva', '1978-10-04', 'M', 'abf');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (50, 'Paulo Rabelo', '1977-10-01', 'M', 'abg');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (60, 'Jeferson Pedro', '1978-10-04', 'M', 'abh');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (70, 'Floriano Noguti', '1978-10-04', 'M', 'abi');
insert into tbl_fichapaciente (id_ficha, nome, data_nasc, sexo, uuid) values (80, 'Vinicius Brandao', '1978-10-04', 'M', 'abj');


