<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Cardapio</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
	
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<!-- Conteudo da página principal -->
		<div class="col-md-12">
		
			<h3>Atualização de Cardápio</h3>
			<a href="consultaCardapio.jsp"> <input type="submit" value="Voltar"/> </a> Para pagina inicial.
			<hr>
			
			<div class="col-md-4">
			
				<form name="formulario" method="post" action="CardapioServelet?acao=atualizar">
				
					<label> Categoria do Cardápio </label>
					<input type="text" id="id" name="id" class="form-control" 
						value="${cardapio.idCardapio}" readonly="readonly" />
					
					<label> Categoria do Cardápio </label>
					<input type="text" id="categoria" name="categoria" class="form-control" 
						value="${cardapio.categoria}" />
					<br>
					
					<label> Descrição do Cardápio </label>
					<input type="text" id="descricao" name="descricao" class="form-control" 
						value="${cardapio.descricao}" />
					<br>
					
					<label> Preço do Cardápio </label>
					<input type="text" id="preco" name="preco" class="form-control" 
						value="${cardapio.valorUnitario}" />
					<br>
					
					<label> Disponibilidade do Cardápio </label>
					<input type="text" id="disponibilidade" name="disponibilidade" class="form-control"
						value="${cardapio.disponibilidade}" />
					<br>
					
					<input type="submit" value="Atualizar" class="btn btn-success" />	
				</form>
				
				<h4>${mensagem}</h4>
			</div>
		</div>

	</body>
</html>