<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Çalışlar Listesi</title>
</head>
<body>

İleti :${message} <br/>
Çalışan Özdeşliği : ${employee.employeeId} <br/>
Çalışan Adı : ${employee.employeeName} <br/>
Çalışan Aylık Maaş : ${employee.montlySalary} <br/>

	<a href="<c:url value='/employee/list'/>">İşAlanListesine Git</a>


</body>
</html>