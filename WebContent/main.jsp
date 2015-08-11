<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>RUTA 0.1</title>
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<meta charset="utf-8">
</head>

<body>

<div id="page">
	<%@include file="/jspf/header.jspf" %>
	
	<div id="mainarea"></div>
	
	<div id="contentarea" class = "windows_areas" style="width:auto">
		<h2>"${mainHeader}"</h2>
		<form action = "/main">
		<!--header button data -->
        <input id = "rButton" type = submit name = "new" value = "createNew"><br>
        
        <!--table data-->
        <table class = "rTable">
        	<c:forEach var="coloumnData" items = "${coloumns}">
        		<tr>
        			<c:forEach var="rowData" items = "${rows}">
        			
        				<td><c:out value="coloumnData.name"></c:out></td>
        				
        	        	
        			</c:forEach>
        		</tr>
        	</c:forEach>
        
        
        
        
        </table>
		</form>
        <br>
        
	</div>

</div>

</body>

</html>