CREATE TABLE RESERVATION_USER (
   userID VARCHAR(30) NOT NULL,
   userPassword VARCHAR(64),
   userResidentID VARCHAR(30),
   userName VARCHAR(20),
   userPhone VARCHAR(20),
   userAddress VARCHAR(200),
   userEmail VARCHAR(50),
   userType INT, -- (0: ������, 1: �Ϲ� ȸ��)
   PRIMARY KEY (userID)
) 
----------------------------------------------------------- ���� ����

CREATE TABLE RESERVATION_BBS (
  bbsID INT,
  bbsTitle VARCHAR(50),
  userID VARCHAR(20),
  bbsDate DATETIME,
  bbsContent VARCHAR(2048),
  bbsAvailable INT,
  PRIMARY KEY (bbsID)
)

----------------------------------------------------------- ���� ����

CREATE TABLE RESERVATION_MOVIE (
  movieID INT,
  movieTitle VARCHAR(50),
  movieContent VARCHAR(2048),
  movieGenre VARCHAR(50),
  movieTime INT,
  PRIMARY KEY (movieID)
) 

----------------------------------------------------------- ���� ����


CREATE TABLE RESERVATION_SEAT (
  movieID INT,
  userID VARCHAR(30),
  seatID INT,
  PRIMARY KEY (movieID, seatID)
) 

----------------------------------------------------------- ���� ����

CREATE TABLE RESERVATION_TICKET (
  ticketID INT,
  movieTitle VARCHAR(50),
  userID VARCHAR(30),
  seatID INT,
  ticket_payment VARCHAR(100),
  ticket_time DATETIME,
  PRIMARY KEY (TicketID)
) 