<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:useBean class="managdBeans.ManagdBeansLivros" id="mb"></jsp:useBean>
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>lista livros</title>
		
		
	</head>
	<body class="container">
		
		<h3>Listar Livros</h3>
		<br><br>
		
		<a href="home.jsp">Home</a>
		<br><br>
		
		<div class="table" align="justify" style="width: 100%;">
			<table>
				
				<thead>
					<tr>
						<th>Titulo do Livro</th>
						<th>Número de Páginas</th>
						<th>Autor</th>
						<th>ID</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${mb.listaLivros}" var="lvrs">
						<tr>
						<td align="center">${lvrs.descricao}</td>
						<td align="center">${lvrs.numPaginas}</td>
						<td align="center">${lvrs.autor}</td>
						<td align="center">${lvrs.idLivro}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>