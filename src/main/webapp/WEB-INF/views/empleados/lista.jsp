<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listado de empleados</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

<h2>Listado de empleados</h2>

<table border="1">
    <thead>
    <tr>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Sexo</th>
        <th>Categoría</th>
        <th>Años</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="e" items="${listaEmpleados}">
        <tr>
            <td>${e.dni}</td>
            <td>${e.nombre}</td>
            <td>${e.sexo}</td>
            <td>${e.categoria}</td>
            <td>${e.anyos}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<button onclick="history.back()">Volver</button>

</body>
</html>
