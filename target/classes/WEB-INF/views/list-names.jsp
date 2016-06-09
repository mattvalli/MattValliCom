<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Names</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Names</h2>  
    <table>
        <tr>
        	<td>ID</td>
        	<td>PREFIX</td>
            <td>NAME</td>
            <td>POSTFIX</td>
            <td>EDIT</td>
            <td>DELETE</td>
        </tr>
        <c:forEach items="${names}" var="name">
            <tr>
            <td>${name.id}</td>
            <td>${name.prefix }</td>
            <td>${name.getNamesAsString() }</td>
            <td>${name.getPostfix()}</td>
            <td><a href="<c:url value='/name/edit/${name.id}' />">edit</a></td>
            <td><a href="<c:url value='/name/delete/${name.id}' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/name/new' />">Add New Name</a>
</body>
</html>