CREATE TABLE IF NOT EXISTS tblcategory (
  CategoryID int NOT NULL AUTO_INCREMENT,
  CategoryName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (CategoryID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tblproduct (
  ProductID int NOT NULL,
  ProductName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Barcode varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  UnitPrice double DEFAULT NULL,
  SellPrice double DEFAULT NULL,
  CategoryID int DEFAULT NULL,
  Photo longblob,
  QtyInStock int DEFAULT NULL,
  PRIMARY KEY (ProductID),
  KEY FK_TblProduct_TblCategory1 (CategoryID),
  CONSTRAINT FK_TblProduct_TblCategory1 FOREIGN KEY (CategoryID) REFERENCES tblcategory (CategoryID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tblposition (
  PositionID int NOT NULL AUTO_INCREMENT,
  PositionName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (PositionID),
  UNIQUE KEY uniqe_TblPosition (PositionName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tbluser (
  UserID int NOT NULL AUTO_INCREMENT,
  UserName varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  Gender varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  DateOfBirth date DEFAULT NULL,
  Password varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  Description varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  Salary double DEFAULT NULL,
  Phone varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  Active varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PositionID int DEFAULT NULL,
  Photo longblob,
  PRIMARY KEY (UserID),
  KEY FK_TblUser_TblPosition (PositionID),
  CONSTRAINT FK_TblUser_TblPosition FOREIGN KEY (PositionID) REFERENCES tblposition (PositionID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tblorder (
  OrderID int NOT NULL,
  OrderDate datetime(3) NOT NULL,
  UserID varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  TotalAmount double NOT NULL,
  PRIMARY KEY (OrderID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tblorderdetail (
  OrderID int DEFAULT NULL,
  ProductID int DEFAULT NULL,
  Qty int DEFAULT NULL,
  Price double DEFAULT NULL,
  Total double DEFAULT NULL,
  KEY FK_TBLORDER_DETAIL_TBLORDER (OrderID),
  KEY FK_TblOrderDetail_TblProduct (ProductID),
  CONSTRAINT FK_TBLORDER_DETAIL_TBLORDER FOREIGN KEY (OrderID) REFERENCES tblorder (OrderID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_TblOrderDetail_TblProduct FOREIGN KEY (ProductID) REFERENCES tblproduct (ProductID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS tbladdstock (
  ProductID int NOT NULL,
  AddDate datetime(3) NOT NULL,
  ExpireDate datetime(3) NOT NULL,
  Qty int NOT NULL,
  UserID int NOT NULL,
  KEY FK_TblAddStock_TBLPRODUCT (ProductID),
  KEY FK_TblAddStock_TblUser (UserID),
  CONSTRAINT FK_TblAddStock_TBLPRODUCT FOREIGN KEY (ProductID) REFERENCES tblproduct (ProductID) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_TblAddStock_TblUser FOREIGN KEY (UserID) REFERENCES tbluser (UserID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
