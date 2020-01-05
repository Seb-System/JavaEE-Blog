<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!doctype html>
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
				<li class="nav-item"><a class="nav-link"
					href="listArticles">Liste Articles
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="addArticle">Ajout Article <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Connexion</button>
			</form>
		</div>
	</nav>

	<main role="main">
		<section class="jumbotron text-center">
			<div class="container">
				<div class="row">
					<div class="col-md-11">
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
						<form method="post" class="mt-4">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Author</label> <input type="text"
										class="form-control" name="author" placeholder="Author"
										required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Title of Article</label> <input
										type="text" class="form-control" name="title"
										placeholder="Title" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputAddress">About</label> <input type="text"
									class="form-control" name="about" placeholder="About" required>
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">Content</label>
								<textarea class="form-control" name="content" rows="3"
									placeholder="Contenu" required></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Crée
									l'article</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</main>