<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.miranda.cursos.model.Curso"%>
<%
List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
String titulo = (String) request.getAttribute("titulo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo %></title>
</head>
<body>
	<h1><%=titulo %></h1>

	<div>
		<form method="post" action="<%=request.getContextPath()%>/buscar">
			<input type="text" name="busqueda">
			<input type="submit" value="Buscar">
		</form>
	</div>
	<br>

	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Instructor</th>
			<th>Duracion</th>


		</tr>
		<%
		for (Curso c : cursos) {
		%>
		<tr>

			<td><%=c.getId()%></td>
			<td><%=c.getNombre()%></td>
			<td><%=c.getDescripcion()%></td>
			<td><%=c.getInstructor()%></td>
			<td><%=c.getDuracion()%></td>


		</tr>
		<%
		}
		%>
	</table>
</body>
</html>