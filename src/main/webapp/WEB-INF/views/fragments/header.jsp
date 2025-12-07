<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
  <h1>Gestor de Nóminas</h1>
  <nav>
    <ul>
      <li>
        <a href="<c:url value='/empleados/lista'/>">
          <button type="button">Ver empleados</button>
        </a>
      </li>
      <li>
        <a href="<c:url value='/empleados/crear'/>">
          <button type="button">Alta Empleado</button>
        </a>
      </li>
      <li><a href="<c:url value="/empleados/consultar"/>">

        <button>Consultar salario</button>
      </a></li>
      <li>
        <a href="<c:url value='/empleados/modificar'/>">
          <button type="button">Modificar Empleado</button>
        </a>
      </li>
    </ul>
  </nav>
</header>
