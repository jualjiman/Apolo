SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `GYM` ;
CREATE SCHEMA IF NOT EXISTS `GYM` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `GYM` ;

-- -----------------------------------------------------
-- Table `GYM`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Cliente` (
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

CREATE UNIQUE INDEX `idCliente_UNIQUE` ON `GYM`.`Cliente` (`idCliente` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Suscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Suscripcion` (
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
    REFERENCES `GYM`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id_cliente` ON `GYM`.`Suscripcion` (`id_cliente` ASC);

CREATE UNIQUE INDEX `idMensualidad_UNIQUE` ON `GYM`.`Suscripcion` (`idMensualidad` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(95) NOT NULL,
  `precioVenta` DECIMAL(9,2) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `PrecioCompra` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`idProductos`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idProductos_UNIQUE` ON `GYM`.`Productos` (`idProductos` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Empleados` (
  `idEmpleados` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apPat` VARCHAR(45) NOT NULL,
  `apMat` VARCHAR(45) NOT NULL,
  `tipoUsuario` VARCHAR(45) NOT NULL,
  `Contrasenya` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpleados`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idEmpleados_UNIQUE` ON `GYM`.`Empleados` (`idEmpleados` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Alamcen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Alamcen` (
  `id_producto` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  `stock` INT NOT NULL,
  CONSTRAINT `id_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `GYM`.`Productos` (`idProductos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_producto_UNIQUE` ON `GYM`.`Alamcen` (`id_producto` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Ventas` (
  `idVentas` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `Fecha` DATE NOT NULL,
  `total` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`idVentas`),
  CONSTRAINT `id_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `GYM`.`Productos` (`idProductos`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_empleado`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `GYM`.`Empleados` (`idEmpleados`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idVentas_UNIQUE` ON `GYM`.`Ventas` (`idVentas` ASC);

CREATE UNIQUE INDEX `id_producto_UNIQUE` ON `GYM`.`Ventas` (`id_producto` ASC);

CREATE UNIQUE INDEX `idEmpleado_UNIQUE` ON `GYM`.`Ventas` (`id_empleado` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Asistencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Asistencia` (
  `idAsistencia` INT NOT NULL AUTO_INCREMENT,
  `id_Clien` INT NOT NULL,
  `fech` DATETIME NOT NULL,
  PRIMARY KEY (`idAsistencia`),
  CONSTRAINT `id_Clien`
    FOREIGN KEY (`id_Clien`)
    REFERENCES `GYM`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idAsistencia_UNIQUE` ON `GYM`.`Asistencia` (`idAsistencia` ASC);

CREATE INDEX `id_Clien_idx` ON `GYM`.`Asistencia` (`id_Clien` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Progresos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Progresos` (
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
    REFERENCES `GYM`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idProgresos_UNIQUE` ON `GYM`.`Progresos` (`idProgresos` ASC);

CREATE INDEX `idClient_idx` ON `GYM`.`Progresos` (`idClient` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Instructor` (
  `idInstructor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `Ap` VARCHAR(20) NOT NULL,
  `Am` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `activo` VARCHAR(20) NOT NULL,
  `fecha_resgistro` DATETIME NOT NULL,
  PRIMARY KEY (`idInstructor`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idInstructor_UNIQUE` ON `GYM`.`Instructor` (`idInstructor` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`Disipulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`Disipulos` (
  `id_instructor` INT NOT NULL,
  `IdClie` INT NOT NULL,
  CONSTRAINT `id_instructor`
    FOREIGN KEY (`id_instructor`)
    REFERENCES `GYM`.`Instructor` (`idInstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdClie`
    FOREIGN KEY (`IdClie`)
    REFERENCES `GYM`.`Cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id_instructor_idx` ON `GYM`.`Disipulos` (`id_instructor` ASC);

CREATE INDEX `IdClie_idx` ON `GYM`.`Disipulos` (`IdClie` ASC);


-- -----------------------------------------------------
-- Table `GYM`.`PVentas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GYM`.`PVentas` (
  `idPVentas` INT NOT NULL AUTO_INCREMENT,
  `id_venta` INT NOT NULL,
  `Id_prod` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`idPVentas`),
  CONSTRAINT `id_venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `GYM`.`Ventas` (`idVentas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Id_prod`
    FOREIGN KEY (`Id_prod`)
    REFERENCES `GYM`.`Productos` (`idProductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idPVentas_UNIQUE` ON `GYM`.`PVentas` (`idPVentas` ASC);

CREATE INDEX `id_venta_idx` ON `GYM`.`PVentas` (`id_venta` ASC);

CREATE INDEX `Id_prod_idx` ON `GYM`.`PVentas` (`Id_prod` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
