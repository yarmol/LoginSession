<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="refresh" content="5;url=loginProcess"/>
<link href ="start.css" rel='stylesheet' type='text/css'>
<title>Redirecting...</title>
</head>
<body>
<jsp:useBean  id = "loginForm"  class = "me.jarad.bean.UserLoginData" scope = "session"/>
<jsp:setProperty name = "loginForm" property = "*"/>
<h2>Checking your data...</h2>
</body>
</html>