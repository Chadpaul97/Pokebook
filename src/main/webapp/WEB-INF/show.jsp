<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1>One Expense</h1>
        <a href="/pokebook">Main Page</a>
		<table  class="table table-dark">
		    <thead>
		        <tr>
		            <th scope="col">ID</th>
		            <th scope="col">Name</th>
		            <th scope="col">Vendor</th>
		            <th scope="col">Amount</th>
		            <th scope="col">Description</th>
		        </tr>
		    </thead>
		    <tbody>
		    
		    	
		    		<tr>
		    			<td> <c:out value="${expense.id}"></c:out></td>
		    			<td> <c:out value="${expense.name}"></c:out></td>
		    			<td> <c:out value="${expense.vendor}"></c:out></td>
		    			<td> <c:out value="${expense.amount}"></c:out></td>
		    			<td> <c:out value="${expense.description}"></c:out></td>
		    		</tr>
		    	
		    	
		         <!-- loop over all the books to show the details as in the wireframe! -->
		    </tbody>
		</table>
    </div> <!-- End of Container -->
</body>
</html>