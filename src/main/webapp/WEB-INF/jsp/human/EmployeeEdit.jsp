<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="employee">
<form:hidden path="employeeId"/>
<form:errors></form:errors>


<fieldset class ="form-group">
<form:label path = "employeeId">İşAlan Özdeşliği</form:label>
<form:input path="employeeId" type="text" value="${employeeId}" disabled="true"/>
<form:errors path="employeeId"/>
</fieldset>

<fieldset class ="form-group">
<form:label path = "employeeName">Çalışan Adı</form:label>
<form:input path="employeeName" type="text"  />
<form:errors path="employeeName"/>
</fieldset>

<fieldset class ="form-group">
<form:label path = "montlySalary">Aylık Maaşı</form:label>
<form:input path="montlySalary" type="text"  />
<form:errors path="montlySalary"/>
</fieldset>

<fieldset class ="form-group">
<form:label path = "departmentId">Bölüm</form:label>
<form:select path="departmentId">
<form:option value ="0"> 
*Seçiniz*
</form:option>
<c:forEach items ="${departments.departmentDetailList}" var ="department">
<form:option value="${department.departmentId} ">
${department.departmentName}

</form:option>
</c:forEach>
</form:select>
<form:errors path="departmentId"/>
</fieldset>

<button type="submit">Sakla</button>
<button type="submit">Güncelle</button>

</form:form>
</body>
</html>