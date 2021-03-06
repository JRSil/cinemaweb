<!DOCTYPE html>
<html lang="pt-BR">
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
                        <a href="#">Atendentes <i class="fa fa-angle-right"></i></a>
                    </li>
                    <li class="menu-item">
                        <a href="#">Filmes <i class="fa fa-angle-right"></i></a>
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
            <div class="container">
                <div class="row">

                    <section id="atendente_cadastro" class="atendente-cadastro">
                        <form class="form form-atendente" id="form-atendente"
                              action="" method="post" tabindex="-1">
                            <div class="form-group">
                                <label for="nome_atendente">Nome</label>
                                <input type="text" name="nome" class="form-control" id="nome_atendente" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="cpf">CPF</label>
                                <input type="text" name="CPF" class="form-control" id="cpf" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="data_nasc">Data de Nascimento</label>
                                <input type="date" name="data_nasc" class="form-control" id="data_nasc" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="email">E-Mail</label>
                                <input type="email" name="email" class="form-control" id="email" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="user">Usuario</label>
                                <input type="text" name="user" class="form-control" id="user" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha</label>
                                <input type="text" name="senha" class="form-control" id="senha" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="tipo">Tipo</label>
                                <select id="tipo" name="tipo" class="form-control">
                                    <option value="Junior">Junior</option>
                                    <option value="Pleno">Pleno</option>
                                    <option value="Senior" selected>Senior</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </section>

                </div>
            </div>
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