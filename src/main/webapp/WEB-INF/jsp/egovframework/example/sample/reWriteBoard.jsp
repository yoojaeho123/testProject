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
	<div class="container_in">
		<h2>답글  작성</h2>
	</div>
	<form role="form" method="post">
		<table  class="detailTable">
			<colgroup>
				<col style ="width:20%;">
				<col style ="width:80%;">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td align="center" class="listtd">
					<input name="title" id="title" class="form-control" style="width: 40%" placeholder="글 제목 입력">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td align="center" class="listtd">
					<input name="content" id="content" class="form-control" style="width: 90%" placeholder="글 내용 입력"">
					</td>
				</tr>	
				<tr>
					<th>작성자</th>
					<td align="center" class="listtd">
					<input name="writer" id="writer" class="form-control" style="width: 40%" placeholder="작성자 입력">
					</td>
				</tr>
			</tbody>
		</table>
		<div style="float : right">
			<button type="submit" class ="btn_ok">등록 </button>
			<button type="button" class ="btn_ok" onclick="location.href='./board.do'">돌아가기</button>
		</div>
	</form>
</body>
</html>