<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>mesa</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
		
		<!-- Arquivos Javascript -->
		<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		
		<h2>Mesa</h2>
		<hr>
		<div class="col-md-4">
			
		</div>
		
		<div class="col-md-4">
			<form id="formulario" method="post" action="PedidoControle?acao=addMesa">
				
				<div class="panel panel-primary" style="background-color: silver; border: solid; border-color: blue;">
				<div class="panel-body">
					<label style="margin-left: 50px;">Informe o número da mesa</label>
					<input type="text" id="mesa" name="mesa" class="form-control"
						placeholder="Digite aqui"/>
				</div>
				
				<br><br>
				<div align="center" style="padding: 12px;">
					<button type="submit" class="btn btn-primary">Fazer Pedido</button>
				</div>
				</div>
			</form>
			<h4>${erro}</h4>
			<h4>${mensagem}</h4>
			<h4>${sucesso}</h4>
		</div>
	</body>
</html>