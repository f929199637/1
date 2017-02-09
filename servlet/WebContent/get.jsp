<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	账号：${user.account }<br>
	昵称：${user.nickName }<br>
	年龄：${user.age }<br>
	性别： ${user.sex }<br>
	头像：<img src="/img/${user.headImage }">
</body>
</html>