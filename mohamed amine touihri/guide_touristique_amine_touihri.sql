-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3308
-- Généré le : jeu. 21 oct. 2021 à 18:38
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `guide_touristique`
--

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `id_hotel` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `tel` int(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `page_web` varchar(30) NOT NULL,
  `nombre_etoile` int(11) NOT NULL,
  `etat` varchar(255) NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hotel`
--

INSERT INTO `hotel` (`id_hotel`, `nom`, `adresse`, `tel`, `email`, `page_web`, `nombre_etoile`, `etat`) VALUES
(6, 'GOLF', 'Hammamet', 23446085, 'golf@gmail.com', 'GOLF_page', 5, 'supprime'),
(7, 'eeee', 'Hammamet', 23446085, 'golf@gmail.com', 'GOLF_page', 4, 'active');

-- --------------------------------------------------------

--
-- Structure de la table `offreh`
--

CREATE TABLE `offreh` (
  `id_offreH` int(11) NOT NULL,
  `nom_offre` varchar(255) NOT NULL,
  `prix_offre` float NOT NULL,
  `etat_offre` varchar(255) NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offreh`
--

INSERT INTO `offreh` (`id_offreH`, `nom_offre`, `prix_offre`, `etat_offre`) VALUES
(5, 'piscine_couvert', 40, 'active'),
(6, 'piscine_non_couvert', 30, 'active'),
(7, 'jacuzzi', 50, 'active'),
(8, 'massage', 55, 'supprime');

-- --------------------------------------------------------

--
-- Structure de la table `offre_hotel`
--

CREATE TABLE `offre_hotel` (
  `id` int(11) NOT NULL,
  `id_H` int(11) NOT NULL,
  `id_O` int(11) NOT NULL,
  `etat_offre_hotel` varchar(255) NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre_hotel`
--

INSERT INTO `offre_hotel` (`id`, `id_H`, `id_O`, `etat_offre_hotel`) VALUES
(5, 7, 5, 'active');

-- --------------------------------------------------------

--
-- Structure de la table `paquet`
--

CREATE TABLE `paquet` (
  `id` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prix` int(30) NOT NULL,
  `date_déb` date NOT NULL,
  `date_fin` date NOT NULL,
  `id_resto` int(30) NOT NULL,
  `id_café` int(30) NOT NULL,
  `id_restocafé` int(30) NOT NULL,
  `id_zarch` int(30) NOT NULL,
  `id_ztour` int(30) NOT NULL,
  `id_hotel` int(30) NOT NULL,
  `id_transport` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `prix_nuit`
--

CREATE TABLE `prix_nuit` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  `id_hotel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `restauration`
--

CREATE TABLE `restauration` (
  `id` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `menu` varchar(30) NOT NULL,
  `tel` int(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `page_web` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `transport`
--

CREATE TABLE `transport` (
  `id` int(30) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `cin_passport` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `zone_de_loisir`
--

CREATE TABLE `zone_de_loisir` (
  `id` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `tel` int(30) NOT NULL,
  `prix` int(30) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id_hotel`);

--
-- Index pour la table `offreh`
--
ALTER TABLE `offreh`
  ADD PRIMARY KEY (`id_offreH`);

--
-- Index pour la table `offre_hotel`
--
ALTER TABLE `offre_hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cbo` (`id_H`),
  ADD KEY `cfo` (`id_O`);

--
-- Index pour la table `paquet`
--
ALTER TABLE `paquet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nom` (`nom`);

--
-- Index pour la table `prix_nuit`
--
ALTER TABLE `prix_nuit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `restauration`
--
ALTER TABLE `restauration`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `zone_de_loisir`
--
ALTER TABLE `zone_de_loisir`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id_hotel` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `offreh`
--
ALTER TABLE `offreh`
  MODIFY `id_offreH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `offre_hotel`
--
ALTER TABLE `offre_hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `prix_nuit`
--
ALTER TABLE `prix_nuit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `offre_hotel`
--
ALTER TABLE `offre_hotel`
  ADD CONSTRAINT `cbo` FOREIGN KEY (`id_H`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cfo` FOREIGN KEY (`id_O`) REFERENCES `offreh` (`id_offreh`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
