<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Alta de empleado</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

<c:if test="${not empty error}">
    <div style="color: red;">
            ${error}
    </div>
</c:if>

<form action="<c:url value='/empleados/crear'/>" method="post">
    DNI: <input type="text" name="dni" value="${empleado.dni}"/><br/>
    Nombre: <input type="text" name="nombre" value="${empleado.nombre}"/><br/>
    Sexo: <input type="text" name="sexo" value="${empleado.sexo}"/><br/>
    Categoría: <input type="number" name="categoria" value="${empleado.categoria}"/><br/>
    Años: <input type="number" name="anyos" value="${empleado.anyos}"/><br/>

    <button type="submit">Guardar</button>
</form>

<button onclick="history.back()">Volver</button>

</body>
</html>
