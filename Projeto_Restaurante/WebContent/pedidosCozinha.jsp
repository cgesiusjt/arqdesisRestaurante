<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<jsp:useBean class="managdBeans.ManagdBeansCozinha" id="mb"></jsp:useBean>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido Cozinha</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
	</head>
	<body class="container">
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12">
			<div class="row">
				<table class="table table-bordered" style=" height: 500px; overflow: auto;">
					<thead>
						<tr>
							<th style="width: 4cm;">Pedido</th>
							<th>Cardápio</th>
							<th style="width: 6cm;">Quantidade</th>
						</tr>
					</thead>
					
					<tfoot>
						<c:forEach items="${mb.listaPedidoCozinha}" var="pdido">
						<tr>
 								<td>${pdido.idPedido}</td>
								<td>${pdido.cardapioTO.descricao}</td>
								<td>${pdido.cardapioTO.quantidade}</td>
						</tr>
						</c:forEach>
					</tfoot>
				</table>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<form name="formAvisaGarcom" method="post" action="PedidoControle?acao=avaisaGarcom">
				<div class="col-md-3">
						<input type="text" id="numPedido" name="numPedido" class="form-control"/>
				</div>
				<div class="col-md-3">
					<button type="submit" class="btn btn-primary">Avisar Garçom</button>
				</div>
				</form>
				<div class="col-md-3">
					<form name="formulario" method="post" action="PedidoControle?acao=listarPedidosCozinha">
						<button type="submit" class="btn btn-primary">Consultar Pratos</button>
					</form>
				</div>
			</div>
			<h4>${avisa}</h4>
		</div>
		
		<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>

	</body>
</html>