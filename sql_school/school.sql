-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 26 Lut 2019, 12:14
-- Wersja serwera: 5.6.34-log
-- Wersja PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `school`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `oceny`
--

CREATE TABLE `oceny` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `WARTOSC` float NOT NULL,
  `ID_STUDENT` int(11) NOT NULL,
  `ID_NAUCZYCIEL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `oceny`
--

INSERT INTO `oceny` (`ID`, `WARTOSC`, `ID_STUDENT`, `ID_NAUCZYCIEL`) VALUES
(1, 3, 1, 2),
(2, 3, 1, 2),
(13, 2, 1, 3),
(14, 3, 2, 3),
(15, 4, 1, 2),
(16, 5, 1, 2),
(17, 3, 1, 2),
(18, 2, 3, 3),
(19, 3, 2, 3),
(20, 2, 1, 3),
(21, 2, 1, 2),
(22, 4, 3, 1),
(23, 2, 1, 3),
(24, 3, 2, 3),
(25, 4, 1, 2),
(26, 5, 1, 2),
(27, 3, 1, 2),
(28, 2, 3, 3),
(29, 3, 2, 3),
(30, 2, 1, 3),
(31, 2, 1, 2),
(32, 4, 3, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `students`
--

CREATE TABLE `students` (
  `Id` int(11) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `dob` date NOT NULL,
  `email` text NOT NULL,
  `fee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `students`
--

INSERT INTO `students` (`Id`, `first_name`, `last_name`, `dob`, `email`, `fee`) VALUES
(1, 'michelle', 'ngoc', '2017-01-17', 'mmm@gmail.com', 100),
(2, 'tom', 'jerry', '2015-08-11', 'tom@gmail.com', 200),
(3, 'katie', 'mcdonald', '2016-08-08', 'katie@gmail.com', 300),
(4, 'awais', 'mirza', '2016-10-10', 'awais@gmail.com', 400);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `subject` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `teacher`
--

INSERT INTO `teacher` (`id`, `first_name`, `last_name`, `subject`) VALUES
(1, 'laura', 'john', 'computer science'),
(2, 'robert', 'junio', 'maths'),
(3, 'linda', 'ngoc', 'english');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `oceny`
--
ALTER TABLE `oceny`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `oceny`
--
ALTER TABLE `oceny`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
