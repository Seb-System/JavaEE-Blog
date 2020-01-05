<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">
<title>Blog · JavaEE</title>

<link rel="canonical"
	href="https://getbootstrap.comhttps://getbootstrap.com/docs/4.4/examples/jumbotron/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/safari-pinned-tab.svg"
	color="#563d7c">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon.ico">
<meta name="msapplication-config"
	content="https://getbootstrap.com/docs/4.4/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<link href="jumbotron.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">YNOV</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="./">Accueil
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="listArticles">Liste Articles <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="addArticle">Ajout
						Article <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<main role="main">

		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">Listes des dsqs</h1>
				<p class="lead text-muted">Voici la liste des tous les articles
					qui on été crée !</p>
				<p>
					<a href="index" class="btn btn-primary my-2">Accueil</a> <a
						href="addArticle" class="btn btn-secondary my-2">Crée un
						article</a>
				</p>
			</div>
			<%
				String status = (String) request.getAttribute("status");
				if (status != null) {
			%>
			<div class="alert alert-success" role="alert">
				<%
					out.println(status);
				%>
			</div>
			<%
				}
			%>
		</section>

		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
					<c:forEach items="${ articles }" var="article">
						<div class="col-md-4">
							<div class="card mb-4 box-shadow">
								<img class="card-img-top"
									data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
									alt="Card image cap">
								<div class="card-body">
									<h5>${ article.title }</h5>
									<p class="card-text"></p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<form action="listArticles" method="post">
												<input type="hidden" name="id" value="${ article.id }" /> <input
													type="submit" class="btn btn-sm btn-outline-info"
													name="button" value="Voir" /> 
													<a class="btn btn-sm btn-outline-warning" href="editArticle?id=${ article.id }" name="button">Editer</a> 
													<input type="submit"
													class="btn btn-sm btn-outline-danger" name="button"
													value="Supprimer" />
											</form>
										</div>
										<small class="text-muted">${ article.date }</small>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>

	</main>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
	<script
		src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://getbootstrap.com/docs/4.0/assets/js/vendor/holder.min.js"></script>
</body>
</html>
