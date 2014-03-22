SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `gym` ;
CREATE SCHEMA IF NOT EXISTS `gym` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gym` ;

-- -----------------------------------------------------
-- Table `gym`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `gym`.`Cliente` (
  `nombre` VARCHAR(45) NOT NULL,
  `ApPat` VARCHAR(45) NOT NULL,
  `apMat` VARCHAR(45) NOT NULL,
  `foto` VARCHAR(85) NULL,
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `telefono` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `activo` VARCHAR(20) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idCliente_UNIQUE` ON `gym`.`Cliente` (`idCliente` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Suscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Suscripcion` ;

CREATE TABLE IF NOT EXISTS `gym`.`Suscripcion` (
  `idMensualidad` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `costo` DECIMAL(9,2) NOT NULL,
  `fecha_inscrip` DATETIME NOT NULL,
  `fecha_expira` DATETIME NOT NULL,
  `TipoSuscrip` VARCHAR(20) NOT NULL,
  `diasRes` INT NOT NULL,
  PRIMARY KEY (`idMensualidad`),
  CONSTRAINT `id_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `gym`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id_cliente` ON `gym`.`Suscripcion` (`id_cliente` ASC);

CREATE UNIQUE INDEX `idMensualidad_UNIQUE` ON `gym`.`Suscripcion` (`idMensualidad` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Productos` ;

CREATE TABLE IF NOT EXISTS `gym`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(95) NOT NULL,
  `precioVenta` DECIMAL(9,2) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `PrecioCompra` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`idProductos`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idProductos_UNIQUE` ON `gym`.`Productos` (`idProductos` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Empleados` ;

CREATE TABLE IF NOT EXISTS `gym`.`Empleados` (
  `idEmpleados` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apPat` VARCHAR(45) NOT NULL,
  `apMat` VARCHAR(45) NOT NULL,
  `tipoUsuario` VARCHAR(45) NOT NULL,
  `Contrasenya` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpleados`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idEmpleados_UNIQUE` ON `gym`.`Empleados` (`idEmpleados` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Alamcen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Alamcen` ;

CREATE TABLE IF NOT EXISTS `gym`.`Alamcen` (
  `id_producto` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  `stock` INT NOT NULL,
  CONSTRAINT `id_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `gym`.`Productos` (`idProductos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_producto_UNIQUE` ON `gym`.`Alamcen` (`id_producto` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Ventas` ;

CREATE TABLE IF NOT EXISTS `gym`.`Ventas` (
  `idVentas` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `id_prod` INT NOT NULL,
  `Fecha` DATE NOT NULL,
  `total` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`idVentas`),
  CONSTRAINT `id_prod`
    FOREIGN KEY (`id_prod`)
    REFERENCES `gym`.`Productos` (`idProductos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_empleado`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `gym`.`Empleados` (`idEmpleados`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idVentas_UNIQUE` ON `gym`.`Ventas` (`idVentas` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Asistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Asistencia` ;

CREATE TABLE IF NOT EXISTS `gym`.`Asistencia` (
  `idAsistencia` INT NOT NULL AUTO_INCREMENT,
  `id_Clien` INT NOT NULL,
  `fech` DATETIME NOT NULL,
  PRIMARY KEY (`idAsistencia`),
  CONSTRAINT `id_Clien`
    FOREIGN KEY (`id_Clien`)
    REFERENCES `gym`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idAsistencia_UNIQUE` ON `gym`.`Asistencia` (`idAsistencia` ASC);

CREATE INDEX `id_Clien_idx` ON `gym`.`Asistencia` (`id_Clien` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Progresos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Progresos` ;

CREATE TABLE IF NOT EXISTS `gym`.`Progresos` (
  `idProgresos` INT NOT NULL AUTO_INCREMENT,
  `idClient` INT NOT NULL,
  `Peso` VARCHAR(10) NOT NULL,
  `BisepIzqRe` VARCHAR(10) NOT NULL,
  `BisepDerRe` VARCHAR(10) NOT NULL,
  `BisepIzqTen` VARCHAR(10) NOT NULL,
  `BisepDerTen` VARCHAR(10) NOT NULL,
  `cintura` VARCHAR(10) NOT NULL,
  `gluteos` VARCHAR(10) NOT NULL,
  `pecho` VARCHAR(10) NOT NULL,
  `hombro` VARCHAR(10) NOT NULL,
  `pantorrillaIzq` VARCHAR(10) NOT NULL,
  `pantorrillaDer` VARCHAR(10) NOT NULL,
  `piernaIzq` VARCHAR(10) NOT NULL,
  `piernaDer` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idProgresos`),
  CONSTRAINT `idClient`
    FOREIGN KEY (`idClient`)
    REFERENCES `gym`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idProgresos_UNIQUE` ON `gym`.`Progresos` (`idProgresos` ASC);

CREATE INDEX `idClient_idx` ON `gym`.`Progresos` (`idClient` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Instructor` ;

CREATE TABLE IF NOT EXISTS `gym`.`Instructor` (
  `idInstructor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Ap` VARCHAR(20) NOT NULL,
  `Am` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `activo` VARCHAR(20) NOT NULL,
  `fecha_resgistro` DATETIME NOT NULL,
  PRIMARY KEY (`idInstructor`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idInstructor_UNIQUE` ON `gym`.`Instructor` (`idInstructor` ASC);


-- -----------------------------------------------------
-- Table `gym`.`Disipulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`Disipulos` ;

CREATE TABLE IF NOT EXISTS `gym`.`Disipulos` (
  `id_instructor` INT NOT NULL,
  `IdClie` INT NOT NULL,
  CONSTRAINT `id_instructor`
    FOREIGN KEY (`id_instructor`)
    REFERENCES `gym`.`Instructor` (`idInstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdClie`
    FOREIGN KEY (`IdClie`)
    REFERENCES `gym`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id_instructor_idx` ON `gym`.`Disipulos` (`id_instructor` ASC);

CREATE INDEX `IdClie_idx` ON `gym`.`Disipulos` (`IdClie` ASC);


-- -----------------------------------------------------
-- Table `gym`.`PVentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`.`PVentas` ;

CREATE TABLE IF NOT EXISTS `gym`.`PVentas` (
  `idPVentas` INT NOT NULL AUTO_INCREMENT,
  `id_venta` INT NOT NULL,
  `IDproduc` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`idPVentas`),
  CONSTRAINT `id_venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `gym`.`Ventas` (`idVentas`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `IDproduc`
    FOREIGN KEY (`IDproduc`)
    REFERENCES `gym`.`Productos` (`idProductos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idPVentas_UNIQUE` ON `gym`.`PVentas` (`idPVentas` ASC);

CREATE INDEX `id_venta_idx` ON `gym`.`PVentas` (`id_venta` ASC);

CREATE INDEX `Id_prod_idx` ON `gym`.`PVentas` (`IDproduc` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
