<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<jsp:useBean class="managdBeans.ManagdBeansCardapio" id="mb"></jsp:useBean>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Cardapio</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />

<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body class="container">

	<div class="well well-sm">
		<h2>RESTAURANTE</h2>
	</div>

	<div class="col-md-12">

		<h3>Consulta de Cardápio</h3>
		<a href="gerenciamento.jsp"> <input type="submit" value="Voltar" />
		</a> Para página Inicial

		<table class="table table-horver">

			<thead>
				<tr>
					<th>Id</th>
					<th>Categoria</th>
					<th>Descrição</th>
					<th>Valor Unitário</th>
					<th>Disponibilidade</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${mb.listagemCardapio}" var="c">

					<tr>
						<td>${c.idCardapio}</td>
						<td>${c.categoria}</td>
						<td>${c.descricao}</td>
						<td>
							<fmt:formatNumber value="${c.valorUnitario}" type="currency"> </fmt:formatNumber>
						</td>	
						<td>${c.disponibilidade}</td>
					</tr>	
				</c:forEach>

			</tbody>
		</table>
		
		<div class="col-md-12">
		<table>
		<tr>
		<td>
		<div class="col-md-8 panel text-left">	
			
			<label>Para excluir um Cardápio digite o id abaixo</label>
			<br>
			<div class="col-md-6">
				<form name="formulario" method="post" action="CardapioServelet?acao=excluir" >
					<input type="text" id="idDelete" name="idDelete" class="form-control"
						value="${cardapio.idCardapio}" />
				
					<br>
					<input type="submit" value="Excluir" class="btn btn-primary"
						onclick="return confirm('Deseja excluir o cliente?');"/>
				</form>
			</div>
		</div>
		
		</td>
		
		<td>
		<div class="col-md-8 panel text-left">	
			
			<label>Para editar um Cardápio digite o id abaixo</label>
			<br>
			<div class="col-md-6">
				<form name="formulario" method="post" action="CardapioServelet?acao=editar" >
					<input type="text" id="idEditar" name="idEditar" class="form-control" 
						value="${cardapio.idCardapio}" />
				
					<br>
					<input type="submit" value="Editar" class="btn btn-primary"/>
				</form>
			</div>
		</div>
		
		</td>
		</tr>
		</table>
		</div>
		<h4>${mensagem}</h4>

	</div>

</body>
</html>

