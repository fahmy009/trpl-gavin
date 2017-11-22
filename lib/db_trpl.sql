-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2017 at 08:37 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_trpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_asam`
--

CREATE TABLE `tb_asam` (
  `id_asam` int(10) NOT NULL,
  `ukuran` varchar(10) NOT NULL,
  `status` text NOT NULL,
  `tindakan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_asam`
--

INSERT INTO `tb_asam` (`id_asam`, `ukuran`, `status`, `tindakan`) VALUES
(1, '9-14', 'Produksi Gagal', 'Proses Produksi Gagal, Lakukan Produksi Ulang'),
(2, '6.5-8', 'Kondisi Normal', 'Tidak Ada Tindakan'),
(3, '5-6.4', 'Kondisi PH Rendah\r\n', 'Lakukan Pemberian Gula, Hingga kadar Gula sebesar 11,892% dan Alkohol 0,056%'),
(4, '0-4', 'Kondisi PH Terlalu Rendah', 'Lakukan Pemberian Gula, Hingga kadar Gula dan Alkohol Normal');

-- --------------------------------------------------------

--
-- Table structure for table `tb_cabang`
--

CREATE TABLE `tb_cabang` (
  `id_cabang` int(20) NOT NULL,
  `nama_cabang` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cabang`
--

INSERT INTO `tb_cabang` (`id_cabang`, `nama_cabang`, `alamat`) VALUES
(1, 'Jember', 'Jl. Ikan Kakap'),
(2, 'Surabaya', 'Jl. Kalimantan'),
(3, 'Jakarta', 'Jl. Perkutut'),
(5, 'Yogyakarta', 'Jl. Gajah Mada no.4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_laporan`
--

CREATE TABLE `tb_laporan` (
  `id_permintaan` int(50) NOT NULL,
  `id_cabang` int(20) NOT NULL,
  `sosro` int(20) DEFAULT NULL,
  `fruittea` int(20) DEFAULT NULL,
  `tebs` int(20) DEFAULT NULL,
  `stee` int(20) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_mesin`
--

CREATE TABLE `tb_mesin` (
  `id_mesin` int(20) NOT NULL,
  `mesin` varchar(20) DEFAULT NULL,
  `volume` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mesin`
--

INSERT INTO `tb_mesin` (`id_mesin`, `mesin`, `volume`) VALUES
(1, 'Sosro', 10000),
(2, 'Fruittea', 10000),
(3, 'Tebs', 10000),
(4, 'S-Tee', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_permintaangudang`
--

CREATE TABLE `tb_permintaangudang` (
  `id_permintaan` int(50) NOT NULL,
  `id_cabang` int(20) NOT NULL,
  `sosro` int(20) DEFAULT NULL,
  `fruittea` int(20) DEFAULT NULL,
  `tebs` int(20) DEFAULT NULL,
  `stee` int(20) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_permintaanlogistik`
--

CREATE TABLE `tb_permintaanlogistik` (
  `id_permintaan` int(50) NOT NULL,
  `id_cabang` int(20) NOT NULL,
  `sosro` int(20) DEFAULT NULL,
  `fruittea` int(20) DEFAULT NULL,
  `tebs` int(20) DEFAULT NULL,
  `stee` int(20) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_stokgudang`
--

CREATE TABLE `tb_stokgudang` (
  `id_permintaan` int(50) NOT NULL,
  `id_cabang` int(20) NOT NULL,
  `sosro` int(20) DEFAULT NULL,
  `fruittea` int(20) DEFAULT NULL,
  `tebs` int(20) DEFAULT NULL,
  `stee` int(20) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_stokgudang`
--

INSERT INTO `tb_stokgudang` (`id_permintaan`, `id_cabang`, `sosro`, `fruittea`, `tebs`, `stee`, `tanggal`) VALUES
(1, 1, 12, 12, 12, 12, '2017-11-09'),
(2, 2, 20, 20, 20, 20, '2017-11-10'),
(3, 3, 12, 12, 12, 12, '2017-11-13');

-- --------------------------------------------------------

--
-- Table structure for table `tb_stokproduksi`
--

CREATE TABLE `tb_stokproduksi` (
  `id_permintaan` int(50) NOT NULL,
  `id_cabang` int(20) NOT NULL,
  `sosro` int(20) DEFAULT NULL,
  `fruittea` int(20) DEFAULT NULL,
  `tebs` int(20) DEFAULT NULL,
  `stee` int(20) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(10) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `nama`, `alamat`, `jenis_kelamin`, `status`, `username`, `password`) VALUES
(1, 'Gavin', 'Jember', 'Laki-laki', 'admin', 'admin', 'admin'),
(2, 'Icha', 'Jember', 'Perempuan', 'produksi', 'produksi', 'produksi'),
(3, 'Vika', 'Banyuwangi', 'Perempuan', 'gudang', 'gudang', 'gudang'),
(4, 'Ayu', 'Situbondo', 'Perempuan', 'logistik', 'logistik', 'logistik'),
(5, 'Haris', 'Madura', 'Pilih Salah Satu', 'Pilih Salah Satu ', 'haris', 'haris'),
(6, 'Muzammil', 'Situbondo', 'Laki-laki', 'Pilih Salah Satu ', 'zammil', 'zammil');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_asam`
--
ALTER TABLE `tb_asam`
  ADD PRIMARY KEY (`id_asam`);

--
-- Indexes for table `tb_cabang`
--
ALTER TABLE `tb_cabang`
  ADD PRIMARY KEY (`id_cabang`);

--
-- Indexes for table `tb_laporan`
--
ALTER TABLE `tb_laporan`
  ADD PRIMARY KEY (`id_permintaan`);

--
-- Indexes for table `tb_mesin`
--
ALTER TABLE `tb_mesin`
  ADD PRIMARY KEY (`id_mesin`);

--
-- Indexes for table `tb_permintaangudang`
--
ALTER TABLE `tb_permintaangudang`
  ADD PRIMARY KEY (`id_permintaan`);

--
-- Indexes for table `tb_permintaanlogistik`
--
ALTER TABLE `tb_permintaanlogistik`
  ADD PRIMARY KEY (`id_permintaan`);

--
-- Indexes for table `tb_stokgudang`
--
ALTER TABLE `tb_stokgudang`
  ADD PRIMARY KEY (`id_permintaan`),
  ADD KEY `id_cabang` (`id_cabang`);

--
-- Indexes for table `tb_stokproduksi`
--
ALTER TABLE `tb_stokproduksi`
  ADD PRIMARY KEY (`id_permintaan`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_asam`
--
ALTER TABLE `tb_asam`
  MODIFY `id_asam` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_cabang`
--
ALTER TABLE `tb_cabang`
  MODIFY `id_cabang` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tb_laporan`
--
ALTER TABLE `tb_laporan`
  MODIFY `id_permintaan` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_mesin`
--
ALTER TABLE `tb_mesin`
  MODIFY `id_mesin` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tb_permintaangudang`
--
ALTER TABLE `tb_permintaangudang`
  MODIFY `id_permintaan` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_permintaanlogistik`
--
ALTER TABLE `tb_permintaanlogistik`
  MODIFY `id_permintaan` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_stokgudang`
--
ALTER TABLE `tb_stokgudang`
  MODIFY `id_permintaan` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_stokproduksi`
--
ALTER TABLE `tb_stokproduksi`
  MODIFY `id_permintaan` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
