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
            <h2>글쓰기</h2>
          </div>
          <p class="lead">게시글을 작성합니다.</p>
          <hr>
          <form action="boardWriteAction.reservation" method="POST" class="pt-3" style="max-width:920px;">
            <div class="form-group">
              <label>제목</label>
              <input name="bbsTitle" type="text" class="form-control" placeholder="제목을 입력하세요.">
            </div>
            <div class="form-group">
              <label>내용</label>
              <textarea name="bbsContent" class="form-control" style="height:320px" placeholder="내용을 입력하세요."></textarea>
            </div>
            <button type="submit" class="btn btn-primary">글쓰기</button>
          </form>
        </main>
      </div>
    </div>
    <%@ include file="./viewFragment/footer.jspf" %>
    <%@ include file="./viewFragment/modal.jspf" %>
  </body>
</html>
