<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="java.util.List, me.jarad.ruta.domain.*,java.util.Iterator,java.util.TreeSet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RUTA 0.1</title>
<LINK REL=StyleSheet HREF="style.css" TYPE="text/css" MEDIA=screen>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="js/dhtmlxCalendar_v44_std/codebase/dhtmlxcalendar.css"/>
<script src="js/dhtmlxCalendar_v44_std/codebase/dhtmlxcalendar.js"></script>
	<style>
		#calendar_input {
			border: 1px solid #909090;
			font-family: Tahoma;
			font-size: 12px;
		}
		#calendar_icon {
			vertical-align: middle;
			cursor: pointer;
		}
	</style>
	<script>
		dhtmlXCalendarObject.prototype.langData["ru"] = {
			dateformat: '%d.%m.%Y',
			monthesFNames: ["Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"],
			monthesSNames: ["Янв","Фев","Мар","Апр","Май","Июн","Июл","Авг","Сен","Окт","Ноя","Дек"],
			daysFNames: ["Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"],
			daysSNames: ["Вс","Пн","Вт","Ср","Чт","Пт","Сб"],
			weekstart: 1,
			weekname: "н"
		}
		var myCalendar;
		
		
		function doOnLoad() {
			myCalendar = new dhtmlXCalendarObject(["date_from","date_to"]);
			myCalendar.loadUserLanguage('ru');
			//myCalendar.setDate("2015-08-10");
			myCalendar.hideTime();
			// init values
			var t = new Date();
			//byId("date_from").value = "2013-03-05";
			//byId("date_to").value = "2013-03-15";
		}
		
		function setSens(id, k) {
			// update range
			if (k == "min") {
				myCalendar.setSensitiveRange(byId(id).value, null);
			} else {
				myCalendar.setSensitiveRange(null, byId(id).value);
			}
		}
		function byId(id) {
			return document.getElementById(id);
		}
	</script>
</head>

<body onload="doOnLoad();">

	<!--header-->
	
	<%@ include file = "/jspf/header.jspf" %>
	
	<div class = "windows_areas">
		
		
         
		 Период:
		 
		 <!-- <input type="text" placeholder="YYYYMMDD"> <input type="text" placeholder="YYYYMMDD"> -->
		 <p>
		 <div style="position:relative;height:50px;">
		 <%@ include file = "/jspf/datepicker.jspf" %>
		 <input class = "btn" type = submit name = "ok_period" value = "OK">
		 <input class = "btn" type = submit name = "new" value = "+">
		 </div>
		 </p>
		 
         <!--  <input class = "btn" type = submit name = "edit" value = "!"> -->
     	 <br>
     	 
     	 <%@ include file = "/jspf/table.jspf" %>
		  
		
		<br>
	</div>
</div>

</body>

</html>