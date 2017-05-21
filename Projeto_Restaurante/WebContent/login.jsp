<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
	
	<!-- Arquivos Javascript -->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
	<style type="text/css">
		
		body{
		background-color: silver;
	}
	</style>
	
	<script>
		function formatar(mascara, documento){
  		var i = documento.value.length;
  		var saida = mascara.substring(0,1);
 		var texto = mascara.substring(i)
  
  		if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
 	 }
  
	}
	</script>
	
</head>

<br><br>
<body class="container">

	<h2>Login</h2>
	<hr/>

	<div class="col-md-4"></div>

	<div class="col-md-4" align="center">

		<form name="formularioLogin" method="post" action="LoginControle?acao=autenticar">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<span class="glyphicon glyphicon-user"></span> Autenticar Usuário
				</div>
				<div class="panel-body">

					<label>Informe seu login:</label> <input type="text" id="login" name="login"
						class="form-control" placeholder="Digite aqui" /> <br /> 
						<label>Informe sua Senha:</label> <input type="password" name="senha"
						class="form-control" placeholder="Digite aqui" />
				</div>
				<div class="panel-footer">

					<input type="submit" value="Autenticar Usuario"
						class="btn btn-success btn-block" />

					<hr />

				</div>
				<br />
				<br />
				<h4>${mensagem}</h4>

				<div class="text-danger">
					<h4>${erro}</h4>
				</div>

			</div>
		</form>
	</div>

</body>
</html>