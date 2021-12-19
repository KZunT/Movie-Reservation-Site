<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <%@ include file="./viewFragment/header.jspf" %>
  <body>
    <div class="container-fluid">
      <div class="row d-flex d-md-block flex-nowrap wrapper">
		<%@ include file="./viewFragment/navigation.jspf" %>
        <main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
          <div class="page-header mt-3">
            <h2>티켓 정보 보기</h2>
          </div>
          <p class="lead">티켓 정보를 확인합니다.</p>
          <hr>
          <form class="pt-3" style="max-width:920px;">
            <div class="form-group">
              <label>예약자 명</label>
              <p class="boardTitle">${ ticket.userID }</p>
            </div>
            <div class="form-group">
              <label>영화 제목</label>
              <p class="boardTitle">${ ticket.movieTitle }</p>
            </div>
            <div class="form-group">
              <label>좌석 번호</label>
              <p class="boardTitle">${ ticket.seatID }</p>
            </div>
            <div class="form-group">
              <label>결제 날짜</label>
              <p class="boardTitle">${ ticket.ticket_time }</p>
            </div>
            <a href="./userTicketView.reservation" class="btn btn-primary">예매 목록</a>
          </form>
        </main>
      </div>
    </div>
    <%@ include file="./viewFragment/footer.jspf" %>
    <%@ include file="./viewFragment/modal.jspf" %>
  </body>
</html>
