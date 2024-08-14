-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-08-2024 a las 05:45:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `celsia_test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` varchar(20) NOT NULL,
  `nombres` varchar(80) NOT NULL,
  `apellidos` varchar(80) NOT NULL,
  `tipoIdentificacion` varchar(2) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `numeroCelular` varchar(20) NOT NULL,
  `correoElectronico` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombres`, `apellidos`, `tipoIdentificacion`, `fechaNacimiento`, `numeroCelular`, `correoElectronico`) VALUES
('1223435', 'Jorge', 'Boca', 'CC', '2002-12-12', '3003456788', 'trest@'),
('1234', 'jorge', 'bocanegra', 'cc', '2024-08-13', '3000', '4000'),
('12345', 'test', 'test', 'ce', '1956-08-23', '30054678', 'jorge@test'),
('94514717', 'Jorge', 'Bocanegra', 'ce', '2024-08-06', '3105185672', 'test@internet.com'),
('94514718', 'Jorge', 'Bocanegra', 'ce', '2024-04-06', '3105185672', 'test@internet.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id` varchar(20) NOT NULL,
  `servicio` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `ultimaFacturacion` date NOT NULL,
  `ultimoPago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id`, `servicio`, `fechaInicio`, `ultimaFacturacion`, `ultimoPago`) VALUES
('94514717', 4, '2024-08-01', '2024-08-11', 120000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_documentos`
--

CREATE TABLE `tipos_documentos` (
  `id` int(11) NOT NULL,
  `tipos` varchar(20) NOT NULL,
  `siglas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipos_documentos`
--

INSERT INTO `tipos_documentos` (`id`, `tipos`, `siglas`) VALUES
(1, 'CEDULA ', 'CC'),
(2, 'TARJETA IDENTIDAD', 'TI'),
(1, 'CEDULA ', 'CC'),
(2, 'TARJETA IDENTIDAD', 'TI'),
(3, 'CEDULA EXTRANJERIA', 'CE'),
(4, 'REGISTRO CIVIL', 'RC'),
(3, 'CEDULA EXTRANJERIA', 'CE'),
(4, 'REGISTRO CIVIL', 'RC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_servicios`
--

CREATE TABLE `tipos_servicios` (
  `id` int(11) NOT NULL,
  `servicios` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipos_servicios`
--

INSERT INTO `tipos_servicios` (`id`, `servicios`) VALUES
(1, 'Internet 200 MB'),
(2, 'Internet 400 MB'),
(3, 'Internet 600 MB'),
(4, 'Directv Go'),
(5, 'Paramount+'),
(6, 'Win+');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `servicio` (`servicio`);

--
-- Indices de la tabla `tipos_servicios`
--
ALTER TABLE `tipos_servicios`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`id`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `servicios_ibfk_2` FOREIGN KEY (`servicio`) REFERENCES `tipos_servicios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
