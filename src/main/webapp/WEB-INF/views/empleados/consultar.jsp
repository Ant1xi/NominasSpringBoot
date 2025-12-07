<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

<h2>Consultar salario</h2>

<form action="<c:url value='/empleados/consultar'/>" method="post">
    DNI: <input type="text" name="dni" value="${empleado.dni}"/><br/>
    SALARIO: <input type="text" readonly value="${sueldo}"/>

    <button type="submit">Consultar</button>
</form>

<c:if test="${not empty error}">
    <div style="color: red;">
            ${error}
    </div>
</c:if>

<button onclick="history.back()">Volver</button>

</body>
</html>
