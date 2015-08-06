<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div id="headerleft">
		<h1><a href="#">"${companyName}"</a></h1></div>
		<div id="menulinks">
		<c:forEach var = "headerDescriptor" items = "${headerDescriptors}"> 
				<a href="{$headerDescriptor.key}"><c:out value="{$headerDescriptor.value.getDescription}"></c:out>     </a>
		</c:forEach>
	</div>
