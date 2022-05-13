-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2022 lúc 08:09 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_thuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `Ma_Khach_hang` varchar(50) NOT NULL,
  `Ten_Khach_hang` varchar(50) NOT NULL,
  `Ngay_sinh` date NOT NULL,
  `Dia_chi` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`Ma_Khach_hang`, `Ten_Khach_hang`, `Ngay_sinh`, `Dia_chi`, `Phone`) VALUES
('001', 'Tạ Nguyên Hiếu', '2000-06-28', 'Bình Thuận ', '0773844758'),
('002', 'Phan Gia Phát', '2000-04-04', '29/3 Lò Siêu P16 Q11 TPHCM', '0773237181'),
('003', 'Nguyễn Tài Thanh Tuấn', '2000-04-05', 'Long Khánh', '0775938531');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `Ma_Nhan_vien` varchar(50) NOT NULL,
  `Ten_Nhan_vien` varchar(50) NOT NULL,
  `Ngay_sinh` date NOT NULL,
  `Dia_chi` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`Ma_Nhan_vien`, `Ten_Nhan_vien`, `Ngay_sinh`, `Dia_chi`, `Phone`) VALUES
('001', 'Trương Phúc Thành', '2000-02-03', 'Hồng Bàng P16 Q11', '0794042204'),
('002', 'Võ Chí Thiện', '2000-10-24', 'Trịnh Thị Miếng Thới Tam Môn Hóc Môn TPHCM', '0773050864');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_muon`
--

CREATE TABLE `phieu_muon` (
  `Ma_Phieu_muon` varchar(50) NOT NULL,
  `Ma_Khach_hang` varchar(50) NOT NULL,
  `Ma_Sach` varchar(50) NOT NULL,
  `Ngay_muon` date NOT NULL,
  `Han_tra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quan_tri`
--

CREATE TABLE `quan_tri` (
  `Ma_Admin` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `quan_tri`
--

INSERT INTO `quan_tri` (`Ma_Admin`, `Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `Ma_Sach` varchar(50) NOT NULL,
  `Ten_Sach` varchar(100) NOT NULL,
  `Ten_Tac_gia` varchar(100) NOT NULL,
  `Nha_xb` varchar(50) NOT NULL,
  `Nha_cc` varchar(50) NOT NULL,
  `Hinh_thuc` varchar(50) NOT NULL,
  `So_luong` int(11) NOT NULL,
  `Gia_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
