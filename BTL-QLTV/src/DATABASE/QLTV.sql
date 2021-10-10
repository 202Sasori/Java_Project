CREATE DATABASE QLTV
USE QLTV

CREATE TABLE BANDOC (
	MABD CHAR(4) NOT NULL PRIMARY KEY,
	TENBD NVARCHAR(100),
	SDT CHAR(11),
	DIACHI NVARCHAR(100),
	GIOITINH NVARCHAR(10),
	SACHMUON NVARCHAR(100)
)
INSERT INTO BANDOC(MABD,TENBD,SDT,DIACHI,GIOITINH,SACHMUON)
VALUES('GV03',N'Dương Thúy Nga','0967263712',N'Hà Nội',N'Nữ',N'CSDL'),
	  ('SV03',N'Đào Việt Bảo','0967427737',N'Hà Nội',N'Nam',N'Java'),
	  ('SV01',N'Trần Đức Tiến','0954377378',N'Phú thọ',N'Nam',N'C+'),
	  ('GV01',N'Hoàng Ninh Hải','0854870978',N'Phú thọ',N'Nam',N'Xác suất thống kê'),
	  ('SV04',N'Hoàng Xuân Trọng','0954934720',N'Hà Nội',N'Nam',N'Giải tích'),
	  ('SV05',N'Dương Thị Nga','0972940378',N'Thái Nguyên',N'Nũ',N'Toán rời rạc'),
	  ('SV06',N'Phạm Văn Quang','0954093628',N'Hải Dương',N'Nam',N'Đại số 1'),
	  ('SV07',N'Hà Anh Tuấn','0826487378',N'Thanh Hóa',N'Nam',N'Đại số 2')
CREATE TABLE SACH (
	MASACH CHAR(4) NOT NULL PRIMARY KEY,
	TENSACH NVARCHAR(100),
	GIASACH INT,
	KESO CHAR(4),
	THELOAI NVARCHAR(100),
	NHAXB NVARCHAR(100),
	NAMXB INT
)
INSERT INTO SACH(MASACH,TENSACH,GIASACH,KESO,THELOAI,NHAXB,NAMXB)
VALUES ('LT01',N'Nhập môn cơ sở dữ liệu',40000,'A1',N'Giáo trình',N'Giáo dục',2010),
		('GT12',N'Xác suất thống kê',50000,'A2',N'Giáo trình',N'Giáo dục',2012),
		('TK01',N'Triết học',70000,'A3',N'Tham khảo',N'Văn học',2009),
		('TK02',N'Tư tưởng HCM',60000,'A3',N'Tham khảo',N'Văn học',2010),
		('LT03',N'Nhập môn Java',30000,'A4',N'Tham khảo',N'Khoa học',2008),
		('LT12',N'Nhập môn C+',30000,'A2',N'Tham khảo',N'Khoa học',2017),
		('LT04',N'Thiết kế giao diện người dùng',45000,'A4',N'Tham khảo',N'Khoa học',2018),
		('GT03',N'Giải tích',25000,'A2',N'Giáo trình',N'Khoa học',2008),
		('GT04',N'Đại số 1',35000,'A2',N'Giáo trình',N'Khoa học',2012),
		('GT05',N'Đại số 2',35000,'A2',N'Giáo trình',N'Khoa học',2012),
		('GT02',N'Toán rời rạc',35000,'A1',N'Tham khảo',N'Khoa học',2017)
CREATE TABLE MUONTRA (
	MABD CHAR(4) NOT NULL, 
	MASACH CHAR(4),
	NGAYMUON DATE,
	NGAYTRA DATE,
	SOLUONG INT
	FOREIGN KEY (MASACH) REFERENCES SACH(MASACH),
	FOREIGN KEY (MABD) REFERENCES BANDOC(MABD)
	)
INSERT INTO MUONTRA(MABD,MASACH,NGAYMUON,NGAYTRA,SOLUONG)
VALUES ('GV03','LT01','2020/10/02','2020/10/12',1),
	   ('SV03','LT03','2020/11/19','2020/11/29',1),
	   ('SV01','LT12','2020/08/18','2020/08/28',1),
	   ('GV01','GT12','2020/10/02','2020/10/12',1),
	   ('SV04','GT03','2020/11/09','2020/11/18',1),
	   ('SV05','GT02','2020/10/22','2020/11/01',1),
	   ('SV06','GT04','2020/11/02','2020/11/12',1),
	   ('SV07','GT05','2020/11/12','2020/11/22',1)
