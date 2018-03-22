<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reply_view</title>
</head>
<body>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="reply" method="post">
			<input type="hidden" name="aId" value="${reply_view.aId}">
			<input type="hidden" name="aGroup" value="${reply_view.aGroup}">
			<input type="hidden" name="aStep" value="${reply_view.aStep}">
			<input type="hidden" name="aIndent" value="${reply_view.aIndent}">
			<tr>
				<td>번호</td>
				<td>${reply_view.aId}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${reply_view.aHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="aName" value="${reply_view.aName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="aTitle" value="${reply_view.aTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="aContent">${reply_view.aContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="답글"> <a href="list">목록</a></td>
			</tr>		
		</form>
	</table>

</body>
</html>