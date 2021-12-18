CREATE TABLE RESERVATION_USER (
   userID VARCHAR(30) NOT NULL,
   userPassword VARCHAR(64),
   userResidentID VARCHAR(30),
   userName VARCHAR(20),
   userPhone VARCHAR(20),
   userAddress VARCHAR(200),
   userEmail VARCHAR(50),
   userType INT, -- (0: 관리자, 1: 일반 회원)
   PRIMARY KEY (userID)
) 
----------------------------------------------------------- 각각 실행

CREATE TABLE RESERVATION_BBS (
  bbsID INT,
  bbsTitle VARCHAR(50),
  userID VARCHAR(20),
  bbsDate DATETIME,
  bbsContent VARCHAR(2048),
  bbsAvailable INT,
  PRIMARY KEY (bbsID)
)

----------------------------------------------------------- 각각 실행

CREATE TABLE RESERVATION_MOVIE (
  movieID INT,
  movieTitle VARCHAR(50),
  movieContent VARCHAR(2048),
  movieGenre VARCHAR(50),
  movieTime INT,
  PRIMARY KEY (movieID)
) 

----------------------------------------------------------- 각각 실행


CREATE TABLE RESERVATION_SEAT (
  movieID INT,
  userID VARCHAR(30),
  seatID INT,
  PRIMARY KEY (movieID, seatID)
) 

----------------------------------------------------------- 각각 실행

CREATE TABLE RESERVATION_TICKET (
  ticketID INT,
  movieTitle VARCHAR(50),
  userID VARCHAR(30),
  seatID INT,
  ticket_payment VARCHAR(100),
  ticket_time DATETIME,
  PRIMARY KEY (TicketID)
) 