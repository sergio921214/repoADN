create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);
CREATE TABLE `auto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(45) NOT NULL,
  `tipoCombustible` varchar(45) NOT NULL,
  `rentado` tinyint NOT NULL,
  `precioPorDia` double DEFAULT NULL,
  `multiplicadorFinSemana` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `rentarauto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(45) DEFAULT NULL,
  `fechaRenta` date DEFAULT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `precioTotalRenta` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `tarifa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipoCombustible` varchar(45) DEFAULT NULL,
  `porcentaje` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


