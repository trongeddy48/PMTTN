drop database TTN

create database ^TTN
go

use TTN

--Ba�ng C�U HO�I

CREATE TABLE [Cauhoi]
(
 [ma_CH] Int NOT NULL,
 [loai] Bit NULL,
 [nd_CH] Nvarchar(200) NULL,
 [img_CH] Varchar(200) NULL,
 [aud_CH] Varchar(200) NULL,
 [TL_1] Nvarchar(200) NULL,
 [TL_2] Nvarchar(200) NULL,
 [TL_3] Nvarchar(200) NULL,
 [TL_4] Nvarchar(200) NULL,
 [DA] Nvarchar(200) NULL,
 [dokho] Int NULL
)
go

-- Th�m kho�a va�o ba�ng C�U HO�I

ALTER TABLE [Cauhoi] ADD CONSTRAINT [PK_Cauhoi] PRIMARY KEY ([ma_CH])
go

-- Ba�ng B�� ���

CREATE TABLE [Bode]
(
 [ma_Bode] Char(7) NOT NULL,
 [ten_Bode] Varchar(40) NULL,
 [ma_CH] Int NULL,
 [ma_MH] Varchar(10) NULL,
 [ma_KT] Char(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng B�� ���

CREATE INDEX [IX_Relationship1] ON [Bode] ([ma_CH])
go

CREATE INDEX [IX_Relationship4] ON [Bode] ([ma_MH])
go

CREATE INDEX [IX_Relationship26] ON [Bode] ([ma_KT])
go

-- Th�m kho�a cho ba�ng B�� ���

ALTER TABLE [Bode] ADD CONSTRAINT [PK_Bode] PRIMARY KEY ([ma_Bode])
go

-- Ba�ng MA� ���

CREATE TABLE [Made]
(
 [ma_De] Char(3) NOT NULL,
 [ten_Made] Char(3) NULL,
 [ma_CHde] Int NULL,
 [ma_Bode] Char(7) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng MA� ���

CREATE INDEX [IX_Relationship3] ON [Made] ([ma_Bode])
go

-- Th�m kho�a cho ba�ng MA� ���

ALTER TABLE [Made] ADD CONSTRAINT [PK_Made] PRIMARY KEY ([ma_De])
go

-- Ba�ng M�N HO�C

CREATE TABLE [Monhoc]
(
 [ma_MH] Varchar(10) NOT NULL,
 [ten_MH] Nvarchar(40) NULL
)
go

-- Th�m kho�a cho ba�ng M�N HO�C

ALTER TABLE [Monhoc] ADD CONSTRAINT [PK_Monhoc] PRIMARY KEY ([ma_MH])
go

-- Ba�ng KY� THI

CREATE TABLE [Kythi]
(
 [ma_KT] Char(10) NOT NULL,
 [ten_KT] Nvarchar(50) NULL,
 [ngaythi] Datetime NULL,
 [tg_Lambai] Int NULL,
 [tg_Batdau] Time NULL,
 [tg_Ketthuc] Time NULL,
 [sl_CH] Int NULL,
 [ma_MH] Varchar(10) NULL,
 [ma_GV] Char(10) NULL,
 [ma_HS] Char(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng KY� THI

CREATE INDEX [IX_Relationship5] ON [Kythi] ([ma_MH])
go

CREATE INDEX [IX_Relationship6] ON [Kythi] ([ma_GV])
go

CREATE INDEX [IX_Relationship8] ON [Kythi] ([ma_HS])
go

-- Th�m kho�a cho ba�ng KY� THI

ALTER TABLE [Kythi] ADD CONSTRAINT [PK_Kythi] PRIMARY KEY ([ma_KT])
go

-- Ba�ng K��T QUA�

CREATE TABLE [Ketqua]
(
 [ma_KQ] Char(10) NOT NULL,
 [ngaythi] Datetime NULL,
 [diem] Float NULL,
 [xeploai] Bit NULL,
 [ma_KT] Char(10) NULL,
 [ma_HS] Char(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng K��T QUA�

CREATE INDEX [IX_Relationship7] ON [Ketqua] ([ma_KT])
go

CREATE INDEX [IX_Relationship27] ON [Ketqua] ([ma_HS])
go

-- Th�m kho�a cho ba�ng K��T QUA�

ALTER TABLE [Ketqua] ADD CONSTRAINT [PK_Ketqua] PRIMARY KEY ([ma_KQ])
go

-- Ba�ng BA�I THI

CREATE TABLE [Baithi]
(
 [ma_Baithi] Char(10) NOT NULL,
 [ma_CH] Int NULL,
 [DA] Nvarchar(200) NULL,
 [ma_KQ] Char(10) NOT NULL
)
go

-- Th�m kho�a cho ba�ng BA�I THI

ALTER TABLE [Baithi] ADD CONSTRAINT [PK_Baithi] PRIMARY KEY ([ma_Baithi],[ma_KQ])
go

-- Ba�ng KH��I

CREATE TABLE [Khoi]
(
 [ma_Khoi] Varchar(10) NOT NULL,
 [ten_Khoi] Varchar(5) NULL
)
go

-- Th�m kho�a cho ba�ng KH��I

ALTER TABLE [Khoi] ADD CONSTRAINT [PK_Khoi] PRIMARY KEY ([ma_Khoi])
go

-- Ba�ng L��P

CREATE TABLE [Lop]
(
 [ma_Lop] Varchar(10) NOT NULL,
 [ten_Lop] Varchar(5) NULL,
 [ma_Khoi] Varchar(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng L��P

CREATE INDEX [IX_Relationship9] ON [Lop] ([ma_Khoi])
go

-- Th�m kho�a cho ba�ng L��P

ALTER TABLE [Lop] ADD CONSTRAINT [PK_Lop] PRIMARY KEY ([ma_Lop])
go

-- Ba�ng HO�C SINH 

CREATE TABLE [Hocsinh]
(
 [ma_HS] Char(10) NOT NULL,
 [ten_HS] Nvarchar(50) NULL,
 [ngaysinh] Date NULL,
 [img_HS] Image NULL,
 [ma_Lop] Varchar(10) NULL,
 [username] Char(10) NULL,
 [ma_GV] Char(10) NULL,
 [ma_Ad] Char(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng HO�C SINH

CREATE INDEX [IX_Relationship10] ON [Hocsinh] ([ma_Lop])
go

CREATE INDEX [IX_Relationship19] ON [Hocsinh] ([username],[ma_GV],[ma_Ad])
go

-- Th�m kho�a cho ba�ng HO�C SINH

ALTER TABLE [Hocsinh] ADD CONSTRAINT [PK_Hocsinh] PRIMARY KEY ([ma_HS])
go

-- Ba�ng TA�I KHOA�N

CREATE TABLE [Taikhoan]
(
 [username] Char(10) NOT NULL,
 [passwords] Char(20) NULL,
 [trangthai] Bit NULL,
 [ma_GV] Char(10) NOT NULL,
 [ma_Ad] Char(10) NOT NULL
)
go

-- Th�m kho�a cho ba�ng TA�I KHOA�N

ALTER TABLE [Taikhoan] ADD CONSTRAINT [PK_Taikhoan] PRIMARY KEY ([username],[ma_GV],[ma_Ad])
go

-- Ba�ng QUY��N

CREATE TABLE [Quyen]
(
 [ma_Quyen] Bit NOT NULL,
 [ten_Quyen] Char(10) NULL,
 [username] Char(10) NULL,
 [ma_GV] Char(10) NULL,
 [ma_Ad] Char(10) NULL
)
go

-- Ta�o chi� mu�c INDEX cho ba�ng QUY��N

CREATE INDEX [IX_Relationship28] ON [Quyen] ([username],[ma_GV],[ma_Ad])
go

-- Th�m kho�a cho ba�ng QUY��N

ALTER TABLE [Quyen] ADD CONSTRAINT [PK_Quyen] PRIMARY KEY ([ma_Quyen])
go

-- Ba�ng GIA�O VI�N

CREATE TABLE [Giaovien]
(
 [ma_GV] Char(10) NOT NULL,
 [ten_GV] Nvarchar(50) NULL,
 [ngaysinh] Date NULL,
 [img_GV] Varchar(200) NULL
)
go

-- Th�m kho�a cho ba�ng GIA�O VI�N

ALTER TABLE [Giaovien] ADD CONSTRAINT [PK_Giaovien] PRIMARY KEY ([ma_GV])
go

-- Ba�ng ADMIN

CREATE TABLE [Admin]
(
 [ma_Ad] Char(10) NOT NULL,
 [ten_Ad] Nvarchar(50) NULL,
 [ngaysinh] Datetime NULL,
 [img_Ad] Varchar(200) NULL
)
go

-- Th�m kho�a cho ba�ng ADMIN

ALTER TABLE [Admin] ADD CONSTRAINT [PK_Admin] PRIMARY KEY ([ma_Ad])
go

-- Ta�o ca�c kho�a ngoa�i --------------------------------------------------------------- 


ALTER TABLE [Bode] ADD CONSTRAINT [Bode_CH] FOREIGN KEY ([ma_CH]) REFERENCES [Cauhoi] ([ma_CH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Made] ADD CONSTRAINT [MH_Made] FOREIGN KEY ([ma_Bode]) REFERENCES [Bode] ([ma_Bode]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Bode] ADD CONSTRAINT [NH_Bode] FOREIGN KEY ([ma_MH]) REFERENCES [Monhoc] ([ma_MH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [MH_KT] FOREIGN KEY ([ma_MH]) REFERENCES [Monhoc] ([ma_MH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [GV_KT] FOREIGN KEY ([ma_GV]) REFERENCES [Giaovien] ([ma_GV]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Ketqua] ADD CONSTRAINT [KQ_KT] FOREIGN KEY ([ma_KT]) REFERENCES [Kythi] ([ma_KT]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [KT_HS] FOREIGN KEY ([ma_HS]) REFERENCES [Hocsinh] ([ma_HS]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Lop] ADD CONSTRAINT [Khoi_Lop] FOREIGN KEY ([ma_Khoi]) REFERENCES [Khoi] ([ma_Khoi]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Hocsinh] ADD CONSTRAINT [HS_Lop] FOREIGN KEY ([ma_Lop]) REFERENCES [Lop] ([ma_Lop]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Baithi] ADD CONSTRAINT [KQ_TL] FOREIGN KEY ([ma_KQ]) REFERENCES [Ketqua] ([ma_KQ]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Hocsinh] ADD CONSTRAINT [HS_TK] FOREIGN KEY ([username], [ma_GV], [ma_Ad]) REFERENCES [Taikhoan] ([username], [ma_GV], [ma_Ad]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Taikhoan] ADD CONSTRAINT [GV_TK] FOREIGN KEY ([ma_GV]) REFERENCES [Giaovien] ([ma_GV]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Taikhoan] ADD CONSTRAINT [AD_TK] FOREIGN KEY ([ma_Ad]) REFERENCES [Admin] ([ma_Ad]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Bode] ADD CONSTRAINT [Bode_KT] FOREIGN KEY ([ma_KT]) REFERENCES [Kythi] ([ma_KT]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Ketqua] ADD CONSTRAINT [KQ_HS] FOREIGN KEY ([ma_HS]) REFERENCES [Hocsinh] ([ma_HS]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Quyen] ADD CONSTRAINT [TK_Quyen] FOREIGN KEY ([username], [ma_GV], [ma_Ad]) REFERENCES [Taikhoan] ([username], [ma_GV], [ma_Ad]) ON UPDATE NO ACTION ON DELETE NO ACTION
go




