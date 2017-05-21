<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<jsp:useBean class="managdBeans.ManagdBeansPagamento" id="mb"></jsp:useBean>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Pagamento</title>
			
			<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
			<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
			
			<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			
			<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
     		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			
			<script type="text/javascript">
				function formatar(mascara, documento){
  				var i = documento.value.length;
  				var saida = mascara.substring(0,1);
 				var texto = mascara.substring(i);
  
  				if (texto.substring(0,1) != saida){
           			 documento.value += texto.substring(0,1);
 					 }
				}
				
				
			</script>
			
		</head>
	<body class="container"> 
		
		<div class="well well-sm">
			<h2>RESTAURANTE</h2>
		</div>
		
		<div class="col-md-12">
		<div class="row" style=" height: 300px; overflow: auto;">

			<table class="table table-bordered">
				<thead>
					<tr>

						<th style="width: 2cm;">Pedido</th>
						<th style="width: 2cm;">Mesa</th>
						<th>Cardápio</th>
						<th style="width: 4cm;">Quantidade</th>
						<th style="width: 4cm;">Valor Unitário</th>
						<th style="width: 4cm;">Valot Total</th>

					</tr>
				</thead>

				<tfoot>

					<c:forEach items="${mb.listaPagamento}" var="pgt">
						<tr>
							<td>${pgt.idPedido}</td>
							<td>${pgt.mesa.codigoMesa}</td>
							<td>${pgt.cardapioTO.descricao}</td>
							<td>${pgt.cardapioTO.quantidade}</td>
							<td><fmt:formatNumber value="${pgt.cardapioTO.valorUnitario}" type="currency">
								</fmt:formatNumber></td>
							<td><fmt:formatNumber value="${pgt.cardapioTO.quantidade * pgt.cardapioTO.valorUnitario}"
									type="currency">
								</fmt:formatNumber></td>
						</tr>
					</c:forEach>
				</tfoot>

			</table>
		</div>

		<div class="row">

				<form name="formulario" method="post" action="PedidoControle?acao=consPagamento">
					<div class="col-md-3">

					<p align="justify" style="font: italic; font-family: cursive;">
							º Número da mesa</p>
						<input id="codMesa" name="codMesa" class="form-control"
							maxlength="2" placeholder="Número da mesa"
							onkeypress="formatar('##', this)"
							style="border: solid; border-color: blue; width: 150px;"/>
					</div>
					
					<div class="col-md-3">
						<p align="justify" style="font: italic; font-family: cursive;">
						º Consultar pedido</p>
						<button type="submit" class="btn btn-primary">Consultar
							Pedido</button>
					</div>
				</form>

			<div class="col-md-3">
					<p align="justify" style="font: italic; font-family: cursive;">
					º Limpar</p>
					<form name="formularioLimpar" method="post" action="PedidoControle?acao=limpar">
						<button type="submit" class="btn btn-primary">Limpar</button>
					</form>
			</div>
			
			<div class="col-md-3" align="right">
				<p style="font: italic; font-family: cursive;">
					º Valor total</p>
				<input id="valorTotal" name="valorTotal" class="form-control" style="width: 150px;"
					value="R$: ${cardapio.valorTotalPgto}" readonly="readonly" />
			</div>
			
		</div>
		<br>

		<div class="row">
			
			<form name="formDinheiro" method="post" action="PedidoControle?acao=calcularTroco">
				<div class="col-md-3">
					<p align="justify" style="font: italic; font-family: cursive;">
			 		º Informe aqui o valor do Cliente</p>
						<input type="text" id="dinheiro" name="dinheiro"
							class="form-control" placeholder="Valor Cliente"
							style="width: 150px;" />
					
					</div>
					
					<div class="col-md-3">
						<p align="justify" style="font: italic; font-family: cursive;">
			 			º Troco do Cliente</p>
						<input type="text" id="troco" name="troco"
							readonly="readonly" class="form-control"
							value="Troco: ${trocoPagamento.troco}" style="width: 150px;" />
					</div>
					
					<div class="col-md-3">
						<p align="justify" style="font: italic; font-family: cursive;">
			 			º Calcular troco</p>
						<button type="submit" id="calcular" class="btn btn-primary">Calcular</button>
					</div>
				</form>
			
				<!-- Modal Pagamento em Cartão -->
				<div class="col-md-2">
					<div>
						<div class="modal fade" id="modal-cartao">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Pagamento Cartão</h4>
										<p style="font: italic; font-family: cursive;">
											º Informe o numero do Cartão</p>
									</div>
									<div>
										<form name="formCartao" method="post" action="PedidoControle?acao=pagamentoCartao">
											<div class="modal-body">
												<input type="text" id="cartao" name="cartao" maxlength="19" 
													onkeypress="formatar('####-####-####-####', this)"/>
											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-default">Pagar</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						
						<p style="font: italic; font-family: cursive;">
			 			º Pagamento Cartão</p>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#modal-cartao">
							Pagamento Cartão
						</button>
					</div>
				</div>
		</div>
		<br>
		
		<div class="row">
		
				<div class="col-md-3"></div>
				<div class="col-md-3"></div>
				
				<!-- Modal CPF -->
				<div class="col-md-3">
					<div>
						<div class="modal fade" id="modal-cpf">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">CPF</h4>
										<p style="font: italic; font-family: cursive;">
											º Informe o numero do CPF</p>
									</div>
									<div>
										<form name="formCpf" method="post" action="PedidoControle?acao=informarCpf">
											<div class="modal-body">
												<input type="text" id="cpf" name="cpf" maxlength="14" 
												onkeypress="formatar('###.###.###-##', this)"/>
											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-default">Informar</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<button class="btn btn-primary" data-toggle="modal"
							data-target="#modal-cpf">
							Informar CPF
						</button>
					</div>
				</div>
				
				<div class="col-md-3">
					<form name="formPagamentoDinheiro" method="post" action="PedidoControle?acao=pagamentoDinheiro">
						<button type="submit" class="btn btn-primary">Pagamento Dinheiro</button>
					</form>
				</div>
				
		</div>
		<h4>${sucesso}</h4>
		<hr style="border-color: black;" align="center">
		<div class="row">
			<div class="col-nd-12">
				
			</div>
		</div>
	</div>
	
	<h4>${erroMesa}</h4>
	<h4>${mensagem}</h4>
	
			
	</body>
</html>