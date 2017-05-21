<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<jsp:useBean class="managdBeans.ManagdBeansCardapio" id="mb"></jsp:useBean>
	<jsp:useBean  class="managdBeans.ManagdBeansTabelaPedido" id="mbd" ></jsp:useBean>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
	
<html>    
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
		
		<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>

	</head>
	<body class="container">
	
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12 ">	
		
		<div class="row">
			<div class="col-md-7" style=" height: 400px; overflow: auto;">
				<div class="col-md-3">
					<input type="text" id="pedido" name="pedido" value="Pedido: ${numPedido.idPedido}" 
						class="form-control" readonly="readonly"/>
				</div>
				<br>
			
				<table class="table table-bordered">
					
					<thead>
						<tr>
							<th>Código</th>
							<th>Categoria</th>
							<th>Descrição</th>
							<th>Quantidade</th>
							<th>Valor Unitário</th>
							<th>Valor Total</th>
						</tr>
					</thead>
			
					<tbody>
						
						<c:forEach items="${mbd.listaTabelaPedido}" var="cardp" >
							<tr>
								<td>${cardp.idCardapio}</td>
								<td>${cardp.categoria}</td>
								<td>${cardp.descricao}</td>
								<td>${cardp.quantidade}</td>
								<td>
									<fmt:formatNumber value="${cardp.valorUnitario}" type="currency"> </fmt:formatNumber>
								</td>
								<td>
								<fmt:formatNumber value="${cardp.quantidade * cardp.valorUnitario}" type="currency"> </fmt:formatNumber>
							</td>
							<tr/>
						</c:forEach>

					</tbody>
				
				</table>
				
				</div>
						
			<div class="col-md-5" style=" height: 400px; overflow: auto;">
				<div class="col-md-6">
					<input id="cardDisponiveis" name="cardDisponiveis" class="form-control"
						value="Cadápios disponiveis" readonly="readonly"/>
				</div>
				<table class="table table-bordered ">

					<thead>
						<tr>
							<th>Código</th>
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
								<td><fmt:formatNumber value="${c.valorUnitario}"
										type="currency">
									</fmt:formatNumber></td>
								<td>${c.disponibilidade}</td>
							<tr />

						</c:forEach>

					</tbody>
				</table>
			</div>
							
	</div>
	
	<hr style="border-color: black;">
		<div class="row">

			<div class="col-md-7">
				<div class="col-md-6">
					<form name="formularioFchPedido" method="post"
						action="PedidoControle?acao=fecharPedido">
						<button type="submit" class="btn btn-primary">Fechar Pedido</button>
					</form>
				</div>

				<div class="col-md-3"></div>

				<div class="col-md-3" align="center">
					<label>Valor Total</label> 
					<input type="text" id="valorTotal" name="valorTotal" class="form-control"
						value="R$: ${cardapio.valorTotal}" readonly="readonly">

				</div>
			</div>

			<div class="col-md-5">
				<div class="row">
				<form name="formularioadd" method="post" action="PedidoControle?acao=adicionar">

					<div class="col-md-4" align="center">
						<label>Codigo</label> <input type="text" id="codigo" name="codigo"
							class="form-control" placeholder="Digite aqui" />
					</div>

					<div class="col-md-4" align="center">
						<label>Quantidade</label> <input type="text" id="quantidade"
							name="quantidade" class="form-control" placeholder="Digite aqui" />
					</div>
					<div class="col-md-4" align="center">
						<label>Adicionar</label> <br>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok"></span>
						</button>
					</div>
					
				</form>
				</div>
				
				<hr>
				<div class="row">
					<h4>${avisa}</h4>
					<p align="justify" style="font: italic; font-family: cursive;">
					 º Para remover insere o código abaixo e clique em remover</p>
					<form name="formulariorem" method="post" action="PedidoControle?acao=remover">
						<div class="col-md-4" align="center">
							<label>Código</label> <input type="text" id="codigoRemover"
								name="codigoRemover" class="form-control"
								placeholder="Digite aqui" value="${cardapio.idCardapio}" />
						</div>
						
						<div class="col-md-4"></div>
						<div class="col-md-4" align="center">
							<label>Remover</label> <br>
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="row">
			
		</div>
	</div>
	<h4>${mensagem}</h4>
	</body>
	
	
	
	
</html>