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

	<!--header-->
	<header>
		<div class="img"> <img src = "images/logo.png" id="logo" width = "78" height = "78" padding="5"; class="leftimg"/></div>			
        <div class="container row">
          <h1 class="col span_12">Господар.Маршруты</h1>
	      <nav class="col span_12">
                <ul>
                    <!--<li><a href="/ledger" target = "/ml">Журнал</a></li>
                    <li><a href="/reference" target="_blank">Справочники</a></li>
                    <li><a href="/user" target="_blank">Пользователь</a></li>
                    <li><a href="/settings">Настройки</a></li>
					<li><a href="/exit">Выход</a></li> -->
					
					<c:forEach var = "headerDescriptor" items = "${headerDescriptors}"> 
							<li><a href="{$headerDescriptor.key}">
							<c:out value="{$headerDescriptor.value.getDescription}"></c:out></a></li>
					</c:forEach>
					
                </ul>
            </nav>
        </div> 
		
		</tr>
		</table>
	</header>
	
	<div class = "windows_areas">
		<h2>Журнал</h2>
         
		 Период:
		 
		 <input type="text" placeholder="YYYYMMDD"> <input type="text" placeholder="YYYYMMDD"> 
		 Выводить
         <select class ="list" >
		 <option>10</option>
		 <option>20</option> 
		 </select>
		 <input class = "btn" type = submit name = "ok_period" value = "OK">
		 <br>
 		 <input class = "btn" type = submit name = "new" value = "+">
         <input class = "btn" type = submit name = "edit" value = "!">

     	 <br>
         <div class="datagrid"><table>
		 <thead>
		 <tr><th>header 1</th><th>header 2</th><th>header 3</th><th>header 4</th></tr></thead>
		 <tfoot>
			<tr>
				<td colspan="4">
					<div id="paging">
						<ul>
							<li><a href="#"><<</a></li>
							<li><a href="#" class="active">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">>></a></li></ul></div></tr>
		</tfoot>
		<tbody>
		<tr><td><a href="/getDoc?&ref=dsdasdaqweqwe"> 1-1 </td><td>data</td><td>data</td><td>data</td></tr>
		<tr><td>data</td><td>data</td><td>data</td><td>data</td></tr>
		<tr><td>data</td><td>data</td><td>data</td><td>data</td></tr>
		<tr><td>data</td><td>data</td><td>data</td><td>data</td></tr>
		<tr><td>data</td><td>data</td><td>data</td><td>data</td></tr>
		</tbody>
		</table>
		</div>
		<br>
	</div>
</div>

</body>

</html>