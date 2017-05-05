<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Cardapio</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
	
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
	
</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12">
		
			<h3>Cadastro de Cardápio</h3>
			<a href="gerenciamento.jsp"> <input type="submit" value="Voltar"/> </a> Para pagina inicial.
			<hr>
			
			<div class="col-md-4">
			
				<form name="formulario" method="post" action="CardapioServelet?acao=cadastrar">
				
					<label> Categoria do Cardápio </label>
					<br>
					<select class="combobox" id="comboCategoria" name="comboCategoria">
						<option value="entrada">Entrada</option>
						<option value="principal">Principal</option>
						<option value="sobremesa">Sobremesa</option>
						<option value="bebida">Bebida</option>
					</select>
					<br>
					
					<label> Descrição do Cardápio </label>
					<input type="text" id="descricao" name="descricao" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Preço do Cardápio </label>
					<input type="text" id="preco" name="preco" class="form-control" placeholder="Digite aqui" />
					<br>
					
					<label> Disponibilidade do Cardápio </label>
					<br>				
					<select class="combobox" id="combo" name="combo">
						<option value="disponivel">disponivel</option>
						<option value="indisponivel">indisponivel</option>
					</select>
					<br><br>
					
					<input type="submit" value="Cadastrar" class="btn btn-primary" />	
				</form>
				
				<h4>${mensagem}</h4>
			</div>
		</div>

	</body>
</html>