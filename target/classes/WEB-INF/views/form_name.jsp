<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Name Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Name Form</h2>
    
    <div id="messages">
    	<div class="success">${ success }</div>
    	<div class="failure">${ failure }</div>
    </div>
  
    <form:form method="POST" modelAttribute="name">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="prefix">Prefix: </label> </td>
                <td><form:input path="prefix" id="prefix"/></td>
                <td><form:errors path="prefix" cssClass="error"/></td>
            </tr>
            
            <tr><td colspan="2">Names</td></tr>
            	<c:choose>
            	
            		<%-- If the size of the collection is less than 2 (two names or less) 		--%>
            		
            		<c:when test="${ fn:length(name.names) < 2 }">
            			<%-- 	We require the minimum names to be 2 (first and last names)
            					We force a second name on the Name 								--%>
     					<!-- First Name -->
		                 <tr>
		            		<td><label for="${ name.names[0] }">First Name: </label></td>
		               		<td><form:input path="names[0]" id="names_0"/></td>
		                	<td><form:errors path="names[0]" cssClass="error"/></td>
		                 </tr>
		                 
		                 <!-- Last Name -->
		                 <tr>
		            		<td><label for="${ name.names[1] }">Last Name: </label></td>
		               		<td><form:input path="names[1]" id="names_1"/></td>
		                	<td><form:errors path="names[1]]" cssClass="error"/></td>
		                 </tr>
            		</c:when>
            		
            	
	            	<c:otherwise>
			           	<c:forEach items="${name.names}" var="currentName" varStatus="loop">
			           		<tr>
			            		<td><label for="${ name.names[loop.index] }">name[${loop.index}]: </label></td>
			               		<td><form:input path="names[${loop.index}]" id="names_${loop.index}"/></td>
			                	<td><form:errors path="names[${loop.index}]" cssClass="error"/></td>
			                 </tr>
			            </c:forEach>
	            	</c:otherwise>
	            	
            	</c:choose>
           
     
            <tr>
                <td><label for="postfix">Postfix: </label> </td>
                <td><form:input path="postfix" id="postfix"/></td>
                <td><form:errors path="postfix" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/name/list' />">List of All Names</a>
</body>
</html>