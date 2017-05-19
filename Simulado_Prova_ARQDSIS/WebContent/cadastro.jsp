<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastrar Livros</title>
	</head>
	<body class="container">
		
		<h3>Cadastro de Livros</h3>
		<br><br>
		
		<a href="home.jsp">Home</a>
		<br><br>
		
		<div>
			<form name="formCadastro" method="post" action="LivrosController?acao=cadastrar">
			
				<label>Titulo do Livro</label>
				<input type="text" id="titulo" name="titulo" />
				<br>
		
				<label>Número de paginas</label>
				<input type="text" id="numPaginas" name="numPaginas"/>
				<br>
				
				<label>Autor</label>
				<input type="text" id="autor" name="autor"/>
				<br>
				
				<button type="submit" >Cadastrar</button>
			</form>
		</div>
		
		<h4>${mensagem}</h4>
	</body>
</html>