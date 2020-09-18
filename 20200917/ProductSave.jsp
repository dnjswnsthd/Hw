<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Save</title>
<style>
#wrap {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
	border: 3px solid grey
}

td {
	border: 1px solid grey
}

#title {
	background-color: grey
}
</style>
</head>
<body>
<% 
	// 한글 깨짐을 방지하기 위한 인코딩 처리
	request.setCharacterEncoding("utf-8"); 
   	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	String explain = request.getParameter("explain");
%>

	<div id="wrap">
		<br> <b><font size="5" color="gray">상품 정보를 확인하세요</font></b> <br>
		<br>
		<table>
			<tr>
				<td id="title">상 품 명</td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td id="title">비밀번호</td>
				<td><%=price %></td>
			</tr>
			<tr>
				<td id="title">이름</td>
				<td><%=explain %></td>
			</tr>
		</table>

		<br> <input type="button" value="확인">
	</div>
</body>
</html>