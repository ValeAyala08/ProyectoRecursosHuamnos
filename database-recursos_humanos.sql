CREATE DATABASE recursos_humanos;

USE recursos_humanos;

CREATE TABLE `recursos_humanos`.`funcionarios` (
    `id_funcionario` INT(15) NOT NULL AUTO_INCREMENT ,
    `tipo_id` VARCHAR(25) NOT NULL ,
    `numero_id` INT(15) NOT NULL ,
    `primer_nombre` VARCHAR(25) NOT NULL ,
    `segundo_nombre` VARCHAR(25) NULL ,
    `primer_apellido` VARCHAR(25) NOT NULL ,
    `segundo_apellido` VARCHAR(25) NOT NULL ,
    `sexo` VARCHAR(10) NOT NULL ,
    `edad` INT NOT NULL ,
    `telefono` VARCHAR(15) NOT NULL ,
    `direccion` VARCHAR(65) NOT NULL ,
    `estado_civil` VARCHAR(15) NOT NULL ,
    PRIMARY KEY (`id_funcionario`)
);

CREATE TABLE `recursos_humanos`.`grupo_familiar` (
    `id_familiar` INT(15) NOT NULL AUTO_INCREMENT ,
    `tipo_id` VARCHAR(25) NOT NULL ,
    `numero_id` INT(15) NOT NULL ,
    `primer_nombre` VARCHAR(25) NOT NULL ,
    `segundo_nombre` VARCHAR(25) NULL ,
    `primer_apellido` VARCHAR(25) NOT NULL ,
    `segundo_apellido` VARCHAR(25) NOT NULL ,
    `sexo` VARCHAR(10) NOT NULL ,
    `edad` INT(11) NOT NULL ,
    `parentesco` VARCHAR(25) NOT NULL ,
    PRIMARY KEY (`id_familiar`)
);

CREATE TABLE `recursos_humanos`.`perfil_academico` (
    `id_academico` INT(15) NOT NULL AUTO_INCREMENT ,
    `nombre_inst` VARCHAR(100) NOT NULL ,
    `nivel_academico` VARCHAR(20) NOT NULL ,
    `titulacion` VARCHAR(60) NOT NULL ,
    PRIMARY KEY (`id_academico`)
);


//Tablas intermediarias

CREATE TABLE `recursos_humanos`.`funcionario_perfilacademico` (
    `id_func_pa` INT(15) NOT NULL AUTO_INCREMENT ,
    `id_func` INT(15) NOT NULL ,
    `id_pa` INT(15) NOT NULL ,
    PRIMARY KEY (`id_func_pa`));

ALTER TABLE `funcionario_perfilacademico` ADD CONSTRAINT `fk_id_func` FOREIGN KEY (`id_func`)
REFERENCES `funcionarios`(`id_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `funcionario_perfilacademico` ADD CONSTRAINT `fk_id_pa` FOREIGN KEY (`id_pa`)
REFERENCES `perfil_academico`(`id_academico`) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE `recursos_humanos`.`funcionario_grupofamiliar` (
    `id_func_familia` INT(15) NOT NULL AUTO_INCREMENT ,
    `id_func` INT(15) NOT NULL ,
    `id_familiar` INT(15) NOT NULL ,
    PRIMARY KEY (`id_func_familia`));

ALTER TABLE `funcionario_grupofamiliar` ADD CONSTRAINT `fk_idfunc` FOREIGN KEY (`id_func`)
REFERENCES `funcionarios`(`id_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `funcionario_grupofamiliar` ADD CONSTRAINT `fk_idfamiliar` FOREIGN KEY (`id_familiar`)
REFERENCES `grupo_familiar`(`id_familiar`) ON DELETE CASCADE ON UPDATE CASCADE;


//Poblacion datos

INSERT INTO `funcionarios` (`id_funcionario`, `tipo_id`, `numero_id`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`,
    `sexo`, `fecha_nacimiento`, `telefono`, `direccion`, `estado_civil`)
    VALUES ('1', 'Cédula', '1001110011', 'Nombre1', N/A, 'Apellido1', 'Apellido2', 'Masculino', '25', '1110001100', 'Direccion1', 'Civil1');

INSERT INTO `funcionarios` (`tipo_id`, `numero_id`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`,
    `sexo`, `fecha_nacimiento`, `telefono`, `direccion`, `estado_civil`)
    VALUES ('Cédula', '2002220022', 'Nombre2', N/A, 'Apellido1', 'Apellido2', 'Femenino', '25', '2220002200', 'Direccion2', 'Civil2');
