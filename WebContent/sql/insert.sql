INSERT INTO RESERVATION_USER VALUES("admin", "1234", "2112191000000", "홍길동", "01000000000", "경기도 시흥시 한국산업기술대", "kpu@naver.com", 0);
INSERT INTO RESERVATION_USER VALUES("배준일", "1234", "9803151000000", "배준일", "01000000000", "인천광역시 계양구 작전동", "bjo@naver.com", 1);
INSERT INTO RESERVATION_USER VALUES("김준태", "1234", "9902241000000", "김준태", "01000000000", "인천광역시 계양구 동양동", "kjt@naver.com", 1);


----------------------------------------------------------- 각각 실행
INSERT INTO RESERVATION_MOVIE VALUES (1, '스파이더맨 노웨이 홈', '짱 재밌다!', '액션', '148');
INSERT INTO RESERVATION_MOVIE VALUES (2, '연애 빠진 로맨스', '달달하다', '멜로', '95');
INSERT INTO RESERVATION_MOVIE VALUES (3, '엔칸토: 마법의 세계', '흥미롭다', '애니메이션', '109');

----------------------------------------------------------- 각각 실행

INSERT INTO RESERVATION_SEAT VALUES (1, '회원', 11);
INSERT INTO RESERVATION_SEAT VALUES (2, '배준일', 22);
INSERT INTO RESERVATION_SEAT VALUES (3, '김준태', 33);

----------------------------------------------------------- 각각 실행

INSERT INTO RESERVATION_TICKET VALUES (1, '스파이더맨 노웨이 홈','김준태', 33,'2021-01-01 00:00:00');
INSERT INTO RESERVATION_TICKET VALUES (2, '연애 빠진 로맨스','배준일', 22,'2021-01-01 00:00:00');