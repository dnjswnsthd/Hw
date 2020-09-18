<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<style>
#wrap {
	width: 530px;
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
	<div id="wrap">
		<br> <b><font size="6" color="grey">상품을 등록해 주세요</font></b>
		<form method="post" action="./ProductSave.jsp">
			<table>
				<tr>
					<td id="title">상 품 명 :</td>
					<td><input type="text" name="name" maxlength="20">
				</tr>

				<tr>
					<td id="title">상품 가격</td>
					<td><input type="text" name="price" maxlength="15"></td>
				</tr>

				<tr>
					<td id="title">상품 설명</td>
					<td><input type="text" name="explain" maxlength="40">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="저장"></td>
					<td><input type="button" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>