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
<script>

const pageBtnClick = (num) => {
	
	let url;
	url = "./board.do?pageNum=" + num + "&searchType=" + $("#searchType option:selected").val() + "&keyWord="+ $('#keyWord').val();
	location.href = url;
}

</script>
</head>
<body>
	<div class="container_in">
		<h2>게시판</h2>
	</div>
	<form id = "form" role="form" method="get" action = "./board.do" style = "float : right">
		<div id="search">
			 <select name="searchType" id="searchType" class = "form-control" style="width:100px">
				<option value="all" <c:if test="${search.searchType == 'all'}"> selected </c:if>>전체</option>
				<option value="title" <c:if test="${search.searchType == 'title'}"> selected </c:if>>제목</option>
				<option value="writer" <c:if test="${search.searchType == 'writer'}"> selected </c:if>>작성자</option>
			 </select> 
			<input name="keyWord" id="keyWord" class = "form-control" style="width:200px" placeholder="검색어를 입력해주세요" value =${search.keyWord}>
			<button type="submit" class="search_bt">검색</button>
			<button type="button" class="btn_ok" onclick="location.href='./writeBoard.do'">게시물 작성</button>
		</div>
	</form>
	<table class="listTable">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><c:out value="${result.id}"/></td>
				<td align="left" class="listtd"><a href="./detail.do?id=${result.id}" style="float: left;"><c:out value="${result.title}" />&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.writer}" />&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.date}" />&nbsp;</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div style="display: none">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li class="pagination_button"><a class = "btn_prev"
					href="./board.do?pageNum=${pageMaker.startPage -1 }"><span>Prev</span></a></li>
			</c:if>

			<c:forEach var="num" begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }">
				<li class="pagination_button">
				<a href="#" onclick = "pageBtnClick(${num})">${num }</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next }">
				<li class="pagination_button"><a class = "btn_next"
					href="./board.do?pageNum=${pageMaker.endPage + 1 }"><span>Next</span></a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>