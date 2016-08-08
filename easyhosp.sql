-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-08-2016 a las 20:29:55
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casa`
--

CREATE TABLE `casa` (
  `id` int(11) NOT NULL,
  `lugar` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `chicos` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `permitidoFumar` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `habitacionCompartida` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `mascota` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `contacto` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `casa`
--

INSERT INTO `casa` (`id`, `lugar`, `chicos`, `permitidoFumar`, `habitacionCompartida`, `mascota`, `contacto`) VALUES
(1, '3', 'No', 'No', 'No', 'No', 'nahuelz@hotmail.com'),
(2, '1', 'Si', 'No', 'No', 'Si', 'Franp@hotmail.com'),
(4, '2', 'Si', 'Si', 'Si', 'Si', 'LisandroR@hotmail.com'),
(5, '2', 'Si', 'Si', 'Si', 'Si', 'JuanCR@hotmail.com'),
(6, '1', 'Si', 'Si', 'Si', 'Si', 'MauroA@hotmail.com'),
(7, '1', 'Si', 'Si', 'Si', 'Si', 'RenzoA@hotmail.com'),
(8, '1', 'Si', 'Si', 'Si', 'Si', 'Pablop@hotmail.com'),
(9, '1', 'Si', 'Si', 'Si', 'Si', 'prueba@hotmail.com'),
(13, '1', 'Si', 'Si', 'Si', 'Si', 'JuanP@hotmail.com'),
(14, '1', 'Si', 'Si', 'Si', 'Si', 'prueba2@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorito`
--

CREATE TABLE `favorito` (
  `id` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idPersonaFav` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `favorito`
--

INSERT INTO `favorito` (`id`, `idPersona`, `idPersonaFav`) VALUES
(1, 40, 28),
(2, 40, 28),
(3, 40, 28),
(19, 28, 31),
(20, 28, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `isAdmin` int(1) NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `casa` int(11) DEFAULT NULL,
  `provincia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ciudad` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `disponible` int(1) NOT NULL,
  `telefono` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dni` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombre`, `apellido`, `email`, `isAdmin`, `password`, `casa`, `provincia`, `ciudad`, `disponible`, `telefono`, `dni`, `sexo`) VALUES
(28, 'Nahuel', 'Zanelli', 'nahuelz@hotmail.com', 1, '123456', 1, 'Buenos Aires', 'Olavarria', 1, '', '', 'M'),
(31, 'Francisco', 'Pucheu', 'Franp@hotmail.com', 0, '123456', 2, 'Chaco', 'Gran Resistencia', 1, '', '', ''),
(35, 'Lisandro', 'Rodriguez', 'LisandroR@hotmail.com', 0, '123456', 4, 'Chubut', 'Puerto Madryn', 1, '', '', ''),
(36, 'Juan Cruz', 'Recaldes', 'JuanCR@hotmail.com', 0, '123456', 5, 'Santa Fe', 'Santa Fe', 1, '', '', ''),
(37, 'Mauro', 'Albarracin', 'MauroA@hotmail.com', 0, '123456', 6, 'Cordoba', 'Cordoba', 1, '', '', ''),
(38, 'Renzo', 'Amoroso', 'RenzoA@hotmail.com', 0, '123456', 7, 'Nequen', 'Neuquen', 1, '', '', ''),
(39, 'Pablo', 'Perez', 'Pablop@hotmail.com', 0, '123456', 8, 'Buenos Aires', 'Azul', 1, '', '', ''),
(40, 'Prueba', 'Prueba', 'prueba@hotmail.com', 0, '123456', 9, 'Buenos Aires', 'La plata', 1, '', '', ''),
(41, 'Juan', 'Perez', 'JuanP@hotmail.com', 0, '123456', 13, 'Buenos Aires', 'Buenos Aires', 1, NULL, NULL, 'M'),
(42, 'Prueba2', 'Prueba2', 'prueba2@hotmail.com', 0, '123456', 14, 'Buenos Aires', 'prueba2', 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id` int(11) NOT NULL,
  `desde` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `hasta` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `estado` int(1) NOT NULL,
  `idDueño` int(10) NOT NULL,
  `comentario` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idSolicitador` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id`, `desde`, `hasta`, `estado`, `idDueño`, `comentario`, `idSolicitador`) VALUES
(1, '2016-08-12', '2016-08-19', 0, 28, '', 28);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `casa`
--
ALTER TABLE `casa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `favorito`
--
ALTER TABLE `favorito`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `casa`
--
ALTER TABLE `casa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `favorito`
--
ALTER TABLE `favorito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
