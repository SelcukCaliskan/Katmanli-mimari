<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Çalışanlar Listesi</title>
</head>
<body>




<form:form method="post" modelAttribute="employees">
<form:label path ="departmentId">Bölüm</form:label>
<form:select path ="departmentId">
<form:option value ="0"> 
*Tümü*
</form:option>
<c:forEach items ="${departments.departmentDetailList}" var ="department">
<form:option value="${department.departmentId} ">
${department.departmentName}
</form:option>
</c:forEach>
</form:select>
<button type="submit" name="filter">Süz</button>

 <br/>
 <br/>
	<table border="1">

		<c:forEach var="employee" items="${employees.employeeDetailList}">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.montlySalary}</td>
				<td>${employee.departmentId}</td>
				<td>${employee.departmentName}</td>
				
				
	<td><a href="<c:url value='/employee/edit/${employee.employeeId}' />">Güncelle</a></td>
	<td><a href="<c:url value='/employee/delete/${employee.employeeId}' />">İşAlan Sil</a></td>
			</tr>



		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/employee/edit'/>">Ekle</a>
	
	</form:form>
	
</body>
</html>