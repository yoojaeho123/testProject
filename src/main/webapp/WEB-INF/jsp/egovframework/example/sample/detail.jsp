<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="./css/egovframework/board.css" />
</head>
<body>
	<div style="padding-bottom: 100px;">
		<div class="container_in">
			<h2>게시물 상세정보</h2>
		</div>
		<table  class="detailTable">
			<colgroup>
				<col style ="width:20%;">
				<col style ="width:80%;">
			</colgroup>
		<c:forEach var="result" items="${result}" varStatus="status">
			<tbody>
				<tr>
					<th>제목</th>
					<td align="center" class="listtd"><c:out value="${result.title}" />&nbsp;</td>
				</tr>
				<tr>
					<th>내용</th>
					<td align="center" class="listtd"><c:out value="${result.content}" />&nbsp;</td>
				</tr>	
				<tr>
					<th>작성자</th>
					<td align="center" class="listtd"><c:out value="${result.writer}" />&nbsp;</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td align="center" class="listtd"><c:out value="${result.date}" />&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<div style = "float : right;">
			<button type="button" id="re_btn" class="btn_ok"
				onclick="location.href='./reWriteBoard.do?id=${result.id}&pid=${result.pid}&level=${result.level}&count=${result.count}'">답글 작성</button>
			<button type="button" id="update_btn" class="btn_ok"
				onclick="location.href='./updateBoard.do?id=${result.id}'">수정</button>
			<button type="button" id="delete_btn" class="btn_ok"
				onclick="location.href='./delete.do?id=${result.id}'">삭제</button>
			<button type="button" id="back_btn" class="btn_ok"
				onclick="location.href='./board.do'">돌아가기</button>
		</c:forEach>
		</div>
	</div>

	<div>
		<div class="container_in">
			<h2>댓글</h2>
		</div>
		<div>
		<form role="form" method="post">
			<input name="writer" id="writer" class="form-control" style="width: 10%" placeholder="작성자 입력"">
			<input name="content" id="content" class="form-control" style="width: 60%" placeholder="글 내용 입력"">
			<button type="submit" style="float:right" class ="btn_ok">등록 </button>
		</form>
		</div>
		<table class="detailTable">
			<colgroup>
				<col style ="width:20%;">
				<col style ="width:80%;">
			</colgroup>
		<c:forEach var="comment" items="${comment}" varStatus="status">
			<tbody>
				<tr>
					<th>내용</th>
					<td align="center" class="listtd"><c:out value="${comment.content}" />&nbsp;</td>
				</tr>	
				<tr>
					<th>작성자</th>
					<td align="center" class="listtd"><c:out value="${comment.writer}" />&nbsp;</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td align="center" class="listtd"><c:out value="${comment.date}" />&nbsp;</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>
	</div>
</body>
</html>