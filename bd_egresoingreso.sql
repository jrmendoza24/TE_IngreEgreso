-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-06-2021 a las 01:52:29
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_egresoingreso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_egresos`
--

CREATE TABLE `cat_egresos` (
  `id_cat_egresos` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cat_egresos`
--

INSERT INTO `cat_egresos` (`id_cat_egresos`, `nombre`, `fecha`) VALUES
(1, 'Alquileres', '2020-04-19'),
(3, 'compras', '2020-12-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_ingre`
--

CREATE TABLE `cat_ingre` (
  `id_cat_ing` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cat_ingre`
--

INSERT INTO `cat_ingre` (`id_cat_ing`, `nombre`, `fecha`) VALUES
(3, 'Pantallas', '2021-04-19'),
(4, 'Mouse', '2021-04-19'),
(5, 'celulares', '2021-04-19'),
(7, 'tarjetas', '2020-04-19'),
(8, 'camaras', '2021-04-19'),
(9, 'Teclados', '2021-04-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `egresos`
--

CREATE TABLE `egresos` (
  `id` int(11) NOT NULL,
  `id_cat_egresos` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `egresos`
--

INSERT INTO `egresos` (`id`, `id_cat_egresos`, `fecha`, `descripcion`, `cantidad`, `precio`) VALUES
(2, 1, '2021-06-24', 'Pago del local', 2, 1200),
(3, 3, '2021-06-18', 'ghjhj', 120, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresos`
--

CREATE TABLE `ingresos` (
  `id` int(11) NOT NULL,
  `id_cat_ing` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ingresos`
--

INSERT INTO `ingresos` (`id`, `id_cat_ing`, `fecha`, `descripcion`, `cantidad`, `precio`) VALUES
(3, 5, '2021-06-23', 'Electronicos', 40, 5),
(4, 3, '2021-06-25', 'Electronicos', 30, 4),
(5, 3, '2021-06-16', 'Venta de pantallas', 20, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_user` int(11) NOT NULL,
  `tipo_usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_user`, `tipo_usuario`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_apellido` varchar(200) NOT NULL,
  `ci` int(11) NOT NULL,
  `celular` int(11) NOT NULL,
  `fecha_nac` date NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_apellido`, `ci`, `celular`, `fecha_nac`, `email`, `password`, `id_user`) VALUES
(1, 'Carlos Mamani Mamani', 9561223, 72056489, '1998-06-01', 'carlos_mm@mail.com', '429f250b63eeb8d7888ea99abc535d2f3a3fb562', 1),
(2, 'Juan Choque Mamani', 9035662, 63052462, '1994-06-10', 'juan_cm@mail.com', '63449747840ee082f7326156bd119240de4c617e', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cat_egresos`
--
ALTER TABLE `cat_egresos`
  ADD PRIMARY KEY (`id_cat_egresos`);

--
-- Indices de la tabla `cat_ingre`
--
ALTER TABLE `cat_ingre`
  ADD PRIMARY KEY (`id_cat_ing`);

--
-- Indices de la tabla `egresos`
--
ALTER TABLE `egresos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cat_egresos` (`id_cat_egresos`);

--
-- Indices de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cat_ing` (`id_cat_ing`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_user`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cat_egresos`
--
ALTER TABLE `cat_egresos`
  MODIFY `id_cat_egresos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cat_ingre`
--
ALTER TABLE `cat_ingre`
  MODIFY `id_cat_ing` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `egresos`
--
ALTER TABLE `egresos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `egresos`
--
ALTER TABLE `egresos`
  ADD CONSTRAINT `egresos_ibfk_1` FOREIGN KEY (`id_cat_egresos`) REFERENCES `cat_egresos` (`id_cat_egresos`);

--
-- Filtros para la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD CONSTRAINT `ingresos_ibfk_1` FOREIGN KEY (`id_cat_ing`) REFERENCES `cat_ingre` (`id_cat_ing`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `tipo_usuario` (`id_user`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
