<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Listado de empleados</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/header.jsp" />

<h2>Modifica a un Empleado</h2>

<table border="1">
    <thead>
    <tr>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Sexo</th>
        <th>Categoría</th>
        <th>Años</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="e" items="${listaEmpleados}">
        <tr>
            <form action="<c:url value='/empleados/modificar'/>" method="post">
                <input type="hidden" name="dni" value="${e.dni}" />
                <td>${e.dni}</td>
                <td>${e.nombre}</td>
                <td>${e.sexo}</td>
                <td>${e.categoria}</td>
                <td>${e.anyos}</td>
                <td><button type="submit">Modificar</button></td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table><br/>

<c:if test="${not empty empleadoSeleccionado}">
    <form action="<c:url value='/empleados/guardar'/>" method="post">
        DNI: <input type="text" name="dni" value="${empleadoSeleccionado.dni}" readonly><br/>
        Nombre: <input type="text" name="nombre" value="${empleadoSeleccionado.nombre}"/><br/>
        Sexo: <input type="text" name="sexo" value="${empleadoSeleccionado.sexo}"/><br/>
        Categoría: <input type="number" name="categoria" value="${empleadoSeleccionado.categoria}"/><br/>
        Años: <input type="number" name="anyos" value="${empleadoSeleccionado.anyos}"/><br/>

        <button type="submit">Guardar</button>
    </form>
</c:if>

<c:if test="${not empty errores}">
    <c:forEach var="e" items="${errores}">
        <p style="color: red">${e}</p>
    </c:forEach>
</c:if>

<button onclick="history.back()">Volver</button>

</body>
</html>
