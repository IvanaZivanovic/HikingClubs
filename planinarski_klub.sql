-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2020 at 05:44 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `planinarski_klub`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresa`
--

CREATE TABLE `adresa` (
  `id_adresa` int(11) NOT NULL,
  `mesto` varchar(30) NOT NULL,
  `postanski_broj` int(11) NOT NULL,
  `ulica` varchar(30) NOT NULL,
  `broj` varchar(30) NOT NULL,
  `id_klub` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adresa`
--

INSERT INTO `adresa` (`id_adresa`, `mesto`, `postanski_broj`, `ulica`, `broj`, `id_klub`) VALUES
(9, 'Beograd', 11000, 'Sarajevska', '40', 10),
(13, 'Beograd', 11000, 'Mačvanska', '8', 14),
(14, 'Beograd', 11000, 'Ustanicka', '125 C', 15),
(15, 'Beograd', 11000, 'Vjekoslava Kovaca', '11', 16),
(16, 'Beograd', 11000, 'Vojvode Supljikca', '31', 17),
(17, 'Paraćin', 35250, 'Kragujevačka', '4', 18),
(18, 'Novi Sad', 21000, 'Trg galerija', '4', 19),
(19, 'Niš', 18000, 'Bulevar dr. Zorana Đinđića', '19/130', 20),
(23, 'Čačak', 32000, 'Braće Glišić', '6', 24),
(26, 'Zajecar', 19000, 'Save Kovacevica', '37C', 27);

-- --------------------------------------------------------

--
-- Table structure for table `akcija`
--

CREATE TABLE `akcija` (
  `id_akcija` int(11) NOT NULL,
  `destinacija` varchar(50) NOT NULL,
  `datum` date NOT NULL,
  `tip_akcije` varchar(100) NOT NULL,
  `cena` int(11) NOT NULL,
  `link` varchar(200) NOT NULL,
  `id_klub` int(11) NOT NULL,
  `id_vodic` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akcija`
--

INSERT INTO `akcija` (`id_akcija`, `destinacija`, `datum`, `tip_akcije`, `cena`, `link`, `id_klub`, `id_vodic`) VALUES
(3, 'Rudnik', '2020-06-27', 'planinarenje', 1500, 'http://www.klubdzepoviprirode.com/pesacenja/rudnik/', 10, 2),
(5, 'Zlatibor', '2020-06-13', 'protest', 500, '', 15, 4),
(14, 'Željin', '2020-06-20', 'planinarenje', 2000, 'https://www.pk-radnicki.rs/destinacija/zeljin-1785-m/', 17, 7),
(15, 'Kablar', '2020-06-25', 'planianrenje', 1600, 'http://serbianoutdoor.com/dogadjaj/ok-klisura/', 15, 4),
(16, 'Šar Planina', '2020-06-27', 'planianrenje', 3000, 'http://www.javorakpn.com/', 18, 10),
(18, 'Stara Planina', '2020-06-18', 'idemo na midzor', 3000, '', 20, 12);

-- --------------------------------------------------------

--
-- Table structure for table `klub`
--

CREATE TABLE `klub` (
  `id_klub` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `pib_broj` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klub`
--

INSERT INTO `klub` (`id_klub`, `naziv`, `pib_broj`) VALUES
(10, 'Klub Dzepovi Prirode', '12348231'),
(14, 'PSK Pobeda', '87548123'),
(15, 'Klub Aktivnih Uzivalaca Prirode', '28066783'),
(16, 'PSK Balkan', '164218201'),
(17, 'PK Radnički', '1548914'),
(18, 'PK Javorak', '126465'),
(19, 'Fruska Gora PD', '48435143'),
(20, 'Preslap PD', '15481'),
(24, 'Kablar PD', '15647828'),
(27, 'Dragan Radosavljevic OPSD', '4568231');

-- --------------------------------------------------------

--
-- Table structure for table `kontakt`
--

CREATE TABLE `kontakt` (
  `id_kontakt` int(11) NOT NULL,
  `broj_telefona` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `web_sajt` varchar(50) NOT NULL,
  `id_klub` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kontakt`
--

INSERT INTO `kontakt` (`id_kontakt`, `broj_telefona`, `email`, `web_sajt`, `id_klub`) VALUES
(3, '064/350 56 52 ', 'klub.dzepoviprirode@gmail.com', 'www.klubdzepoviprirode.com', 10),
(7, '011/ 2455-781', 'kontakt@pdpobeda.rs  ', 'www.pdpobeda.rs', 14),
(8, '/', 'office@serbianoutdoor.com', 'www.serbianoutdoor.com', 15),
(9, '064 18 24 440', 'pkbalkan.srbija@gmail.com', 'www.pkbalkan.org', 16),
(10, '+381 69 2109830', 'info@pk-radnicki.rs', 'www.pk-radnicki.rs', 17),
(11, '0641733906', 'javorakpn@gmail.com', 'www.javorakpn.com', 18),
(12, '+38160 033 07 71', 'pdfruskagora@gmail.com', 'http://planinari.wixsite.com/fruska-gora', 19),
(13, '+38162 205 977', 'pdpreslap@gmail.com', 'www.preslap.rs', 20),
(17, '064/8526048', 'pdkablarcacak@gmail.com', 'http://www.pdkablar.com', 24),
(19, '063457-536', 'draganradosavljevic.za@gmail.com', 'www.opsddraganradosavljevic.rs', 27);

-- --------------------------------------------------------

--
-- Table structure for table `planinar`
--

CREATE TABLE `planinar` (
  `id_planinar` int(11) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `godiste` int(11) NOT NULL,
  `broj_clanske_karte` varchar(30) NOT NULL,
  `clanarina` date NOT NULL,
  `broj_telefona` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_klub` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `planinar`
--

INSERT INTO `planinar` (`id_planinar`, `ime`, `prezime`, `godiste`, `broj_clanske_karte`, `clanarina`, `broj_telefona`, `email`, `id_klub`) VALUES
(1, 'Vukasin', 'Nemanjic', 1988, '277', '2020-06-24', '063/333-333', 'vukasin@gmail.com', 10),
(2, 'Ognjen', 'Nikolic', 1970, '999', '2020-06-14', '060/000000', 'ognjen@yahoo.com', 16),
(4, 'Ivana', 'Božić', 1994, '28/09', '2021-06-11', '069787878', 'ivana@gmail.com', 27);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id_rezervacija` int(11) NOT NULL,
  `id_planinar` int(11) NOT NULL,
  `id_akcija` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id_rezervacija`, `id_planinar`, `id_akcija`) VALUES
(2, 1, 3),
(4, 4, 14),
(6, 1, 3),
(10, 1, 5),
(11, 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `naziv`) VALUES
(1, 'admin'),
(2, 'korisnik');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `email`, `ime`, `prezime`, `status`) VALUES
(1, 'ivana', 'ivana', 'dgb.ivana@gmail.com', 'Ivana', 'Zivanovic', 0),
(2, 'korisnik', 'korisnik', 'korisnik@gmail.com', 'Neko', 'Nekic', 0),
(4, 'pera', '123', 'nekimejl@gmail.com', 'Pera', 'Peric', 0),
(5, 'marko', 'marko', 'marko@gmail.com', 'Marko', 'Markovic', 0),
(8, 'aca', 'aca', 'aca@gmail.com', 'Aca', 'Acic', 0),
(10, 'jovana', 'jovana', 'blabla@mejl.com', 'Jovana', 'Jovanovic', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id_user`, `id_role`) VALUES
(1, 1),
(2, 2),
(4, 2),
(5, 2),
(8, 2),
(10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `vodic`
--

CREATE TABLE `vodic` (
  `id_vodic` int(11) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `godiste` int(11) NOT NULL,
  `broj_licence` varchar(30) NOT NULL,
  `broj_telefona` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_klub` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vodic`
--

INSERT INTO `vodic` (`id_vodic`, `ime`, `prezime`, `godiste`, `broj_licence`, `broj_telefona`, `email`, `id_klub`) VALUES
(1, 'Zorka', 'Jovanovic', 1965, 'MB172', '060/123456', 'zorka@gmail.com', 14),
(2, 'Branislav', 'Makljenovic', 1962, 'MB350', '064 3505652', 'klub.dzepoviprirode@gmail.com', 10),
(3, 'Marko', 'Nikolić', 1985, 'MB555', '063/123456', 'marko@gmail.com', 16),
(4, 'Petar', 'Petrovic', 1980, 'MB999', '069987654', 'petar@gmail.com', 15),
(7, 'Jovana', 'Jovanovic', 1975, 'MB666', '062/456123', 'jovana@gmail.com', 17),
(8, 'Nikola', 'Veljkovic', 1977, 'MB777', '061999999', 'nikola@gmail.com', 27),
(9, 'Bojan', 'Ostojic', 1970, 'MB707', '066/111222', 'bojan@gmail.com', 14),
(10, 'Petar', 'Petrović', 1966, 'MB1000', '066/111111', 'petar@gmail.com', 18),
(11, 'Milica', 'Simic', 1990, 'MB6325', '063/222222', 'milica@gmail.com', 19),
(12, 'Stanislav', 'Milosavljevic', 1989, 'MB1212', '064/444444', 'stanislav@gmail.com', 20),
(14, 'Vojin', 'Dragicevic', 1983, 'MB19835', '062/333333', 'vojin@gmail.com', 24);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresa`
--
ALTER TABLE `adresa`
  ADD PRIMARY KEY (`id_adresa`),
  ADD UNIQUE KEY `id_klub` (`id_klub`);

--
-- Indexes for table `akcija`
--
ALTER TABLE `akcija`
  ADD PRIMARY KEY (`id_akcija`),
  ADD KEY `id_vodic` (`id_vodic`),
  ADD KEY `id_klub` (`id_klub`);

--
-- Indexes for table `klub`
--
ALTER TABLE `klub`
  ADD PRIMARY KEY (`id_klub`);

--
-- Indexes for table `kontakt`
--
ALTER TABLE `kontakt`
  ADD PRIMARY KEY (`id_kontakt`),
  ADD UNIQUE KEY `id_klub` (`id_klub`);

--
-- Indexes for table `planinar`
--
ALTER TABLE `planinar`
  ADD PRIMARY KEY (`id_planinar`),
  ADD KEY `id_klub` (`id_klub`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id_rezervacija`),
  ADD KEY `id_akcija` (`id_akcija`),
  ADD KEY `id_planinar` (`id_planinar`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `vodic`
--
ALTER TABLE `vodic`
  ADD PRIMARY KEY (`id_vodic`),
  ADD KEY `id_klub` (`id_klub`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresa`
--
ALTER TABLE `adresa`
  MODIFY `id_adresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `akcija`
--
ALTER TABLE `akcija`
  MODIFY `id_akcija` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `klub`
--
ALTER TABLE `klub`
  MODIFY `id_klub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `kontakt`
--
ALTER TABLE `kontakt`
  MODIFY `id_kontakt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `planinar`
--
ALTER TABLE `planinar`
  MODIFY `id_planinar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id_rezervacija` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `vodic`
--
ALTER TABLE `vodic`
  MODIFY `id_vodic` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresa`
--
ALTER TABLE `adresa`
  ADD CONSTRAINT `adresa_ibfk_1` FOREIGN KEY (`id_klub`) REFERENCES `klub` (`id_klub`);

--
-- Constraints for table `akcija`
--
ALTER TABLE `akcija`
  ADD CONSTRAINT `akcija_ibfk_1` FOREIGN KEY (`id_vodic`) REFERENCES `vodic` (`id_vodic`),
  ADD CONSTRAINT `akcija_ibfk_2` FOREIGN KEY (`id_klub`) REFERENCES `klub` (`id_klub`);

--
-- Constraints for table `kontakt`
--
ALTER TABLE `kontakt`
  ADD CONSTRAINT `kontakt_ibfk_1` FOREIGN KEY (`id_klub`) REFERENCES `klub` (`id_klub`);

--
-- Constraints for table `planinar`
--
ALTER TABLE `planinar`
  ADD CONSTRAINT `planinar_ibfk_2` FOREIGN KEY (`id_klub`) REFERENCES `klub` (`id_klub`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`id_akcija`) REFERENCES `akcija` (`id_akcija`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`id_planinar`) REFERENCES `planinar` (`id_planinar`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `vodic`
--
ALTER TABLE `vodic`
  ADD CONSTRAINT `vodic_ibfk_1` FOREIGN KEY (`id_klub`) REFERENCES `klub` (`id_klub`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
