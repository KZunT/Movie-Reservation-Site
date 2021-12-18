<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<!-- 헤더 파일 불러오기 -->
  <%@ include file="./viewFragment/header.jspf" %>
   <body>
    <div class="container-fluid">
      <div class="row d-flex d-md-block flex-nowrap wrapper">
		<%@ include file="./viewFragment/navigation.jspf" %>
        <main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
          <div class="page-header mt-3">
            <h2>영화 예매 사이트</h2>
          </div>
          <p class="lead">이곳은 현재 상영중인 영화 티켓을 예매할 수 있는 사이트입니다.</p>
          <hr>
           <!-- 캐러셀을 이용하여 사진 슬라이드 기능 구현하기 -->
          <p class="lead mt-4 mb-3 pt-4 pb-2">현재 상영작</p>
          <div id="carousel" class="carousel slide" style="max-width:550px;" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carousel" data-slide-to="0" class="active"></li>
              <li data-target="#carousel" data-slide-to="1"></li>
              <li data-target="#carousel" data-slide-to="2"></li>
            </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="./img/스파이더맨 노웨이 홈.jpeg" alt="첫 번째 이미지">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="./img/연애 빠진 로맨스.jpeg" alt="두 번째 이미지">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="./img/엔칸토 마법의 세계.jpeg" alt="세 번째 이미지">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carousel" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">이전 사진</span>
          </a>
          <a class="carousel-control-next" href="#carousel" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">다음 사진</span>
          </a>
          </div>
           <!-- 영화 예고편을 동영상 형태로 볼 수 있게 미디어 태그 이용 -->
          <br></br>
          <p class="lead mt-4 mb-3 pt-4 pb-2">스파이더맨 노웨이 홈 예고편</p>
          <iframe width="50%" height="50%" src="https://www.youtube.com/embed/W7edvITC9g4" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
          <br></br>
          <p class="lead mt-4 mb-3 pt-4 pb-2">연애 빠진 로맨스 예고편</p>
          <iframe width="50%" height="50%" src="https://www.youtube.com/embed/03jxMkPJEPQ" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
          <br></br>
          <p class="lead mt-4 mb-3 pt-4 pb-2">엔칸토: 마법의 세계 예고편</p>
          <iframe width="50%" height="50%" src="https://www.youtube.com/embed/DJs_ihmMZfg" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
          
        </main>
      </div>
    </div>
     <!-- footer, modal 파일 불러오기 -->
    <%@ include file="./viewFragment/footer.jspf" %>
    <%@ include file="./viewFragment/modal.jspf" %>
  </body>
</html>
    