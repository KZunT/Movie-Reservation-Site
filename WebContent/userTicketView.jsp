<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <%@ include file="./viewFragment/header.jspf" %>
  <body>
    <div class="container-fluid">
      <div class="row d-flex d-md-block flex-nowrap wrapper">
		<%@ include file="./viewFragment/navigation.jspf" %>
        <main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
          <div class="page-header mt-3">
            <h2>예매 정보</h2>
          </div>
          <p class="lead">회원님의 예매 정보입니다.</p>
          <hr>
          <table class="table table-striped" style="max-width:1080px;">
            <thead>
              <tr>
                <th class="mobile" style="width:120px; text-align:center;">티켓 번호</th>
                <th style="text-align:center;">영화 제목</th>
                <th class="mobile" style="width:120px; text-align:center;">좌석 정보</th>
                <th class="mobile" style="width:150px; text-align:center;">결제 날짜</th>
              </tr>
            </thead>
            <tbody>
         	  <c:forEach items="${ list }" var="ticket">
              <tr>
                <td style="text-align: center;">${ ticket.ticketID }</td>
                <td><a href="./userTicketInfoView.reservation?ticketID=${ ticket.ticketID }" style="color:#000000;">
                <c:choose>
                	<c:when test="${ticket.ticketID == 0}">
                		없는 영화입니다.
                	</c:when>
                	<c:otherwise>
                		${ ticket.movieTitle }
                	</c:otherwise>
                </c:choose>
                </a></td>
                <td style="text-align: center;">${ ticket.seatID }</td>
                <td style="text-align: center;">${ ticket.ticket_time }</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <ul class="pagination">
			<c:choose>
				<c:when test="${pageNumber != 1}">
					<a href="userTicketView.reservation?pageNumber=${ pageNumber - 1 }" class="btn btn-success btn-arrow-left">이전</a>
				</c:when>
				<c:when test="${nextExist == true}">
					<a href="userTicketView.reservation?pageNumber=${ pageNumber + 1 }" class="btn btn-success btn-arrow-right">다음</a>
				</c:when>
			</c:choose>
          </ul>
        </main>
      </div>
    </div>
    <%@ include file="./viewFragment/footer.jspf" %>
    <%@ include file="./viewFragment/modal.jspf" %>
  </body>
</html>
