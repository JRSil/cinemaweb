<!DOCTYPE html>
<html lang="pt-BR" xmlns:th="http://thymeleaf.org"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Sistema de ingressos WebCinema</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" integrity="sha256-+N4/V/SbAFiW1MPBCXnfnP9QSN3+Keu+NlB+0ev/YKQ=" crossorigin="anonymous" />

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<a id="skippy" class="sr-only sr-only-focusable" href="#main">
	<div class="container">
		<span class="skiplink-text">Ir para o conteúdo</span>
	</div>
</a>

<div class="container-fluid">
	<div class="row">

		<header id="header" class="header">
			<h1 class="sr-only">Sistema de ingressos WebCinema</h1>

			<div class="main-logo">
				<a class="header-brand align-self-start" href="/" rel="home">
					<img class="img-responsive" src="./assets/images/logo.png" alt="Logomarca: WebCinema" />
				</a><!--/.header-brand -->
			</div>
		</header>

		<section class="menu-principal">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-navigation">
					<span class="sr-only">Menu Principal</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>

			<nav id="menu" class="collapse navbar-collapse navbar-main-navigation" aria-label="Menu principal">
				<ul id="menu-principal" class="nav navbar-nav">
					<li class="menu-item">
						<a href="/cadastrarAtendentes">Cadastrar Atendentes <i class="fa fa-angle-right"></i></a>
					</li>
					<li class="menu-item">
						<a href="/cadastrarFilmes">Cadastrar Filmes <i class="fa fa-angle-right"></i></a>
					</li>
					<li class="menu-item">
						<a href="#">Salas <i class="fa fa-angle-right"></i></a>
					</li>
					<li class="menu-item">
						<a href="#">Sessoes <i class="fa fa-angle-right"></i></a>
					</li>
					<li class="menu-item">
						<a href="#">Ingressos <i class="fa fa-angle-right"></i></a>
					</li>
				</ul>
			</nav>
		</section>

		<main id="main">
			<section id="filmes" class="box-filmes">
				<ul id="list-filmes" class="list-filmes">
					<li th:each="filme : ${filme}" class="item-filmes">
						<h2><span th:text="${filme.nomeFilme}"></span></h2>
						<p><span th:text="${filme.classificacao}"></span></p>
						<p><span th:text="${filme.duracao}"></span></p>
						<p><span th:text="${filme.vigencia}"></span></p>
						<p><span th:text="${filme.categoria}"></span></p>
					</li>
				</ul>
			</section>
		</main>

		<footer id="footer">
			<a href="#top" class="btn-top">
				<i class="fa fa-angle-up"></i> <span>Voltar ao topo</span>
			</a>

			<section class="copyright">
				<div class="col-xs-12">
					<p>© 2019 WebCinema. Todos os direitos reservados.</p>
				</div>
			</section>
		</footer>
	</div>
</div>
</body>
</html>