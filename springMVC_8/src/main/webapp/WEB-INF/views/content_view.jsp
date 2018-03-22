<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content_view</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify"method="post">
			<input type="hidden" name="aId" value="${content_view.aId}">
			<tr>
				<td>번호</td>
				<td>${content_view.aId}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content_view.aHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="aName" value="${content_view.aName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="aTitle" value="${content_view.aTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="aContent">${content_view.aContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit"value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; 
				<a href="delete?aId=${content_view.aId}">삭제</a> &nbsp;&nbsp; <a href="reply_view?aId=${content_view.aId}">답글</a></td>
		</form>
	</table>

</body>
</html>