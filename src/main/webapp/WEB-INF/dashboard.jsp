<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
	<!-- Bootstrap CSS-->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- My CSS -->
	<link rel="stylesheet" href="/css/style.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<!-- <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="/webjars/popper.js/2.0.2/umd/popper.min.js" ></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->

</head>
<body>
	<div class="flex-container">
		<nav class="navbar navbar-inverse p-3">

			<div class="container-fluid">
				<div class="navbar-header">
					<h3>Skincare Review</h3>
				</div>
				
				<ul class="nav navbar-nav">
					<div class="dropdown">
						<button class="btn optionButton dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
							Hi, <c:out value="${loggedInUser.username}"></c:out>
						</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/new">New Post</a></li>
							<li><a class="dropdown-item" href="/posts">Your Posts</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/logout">Logout</a></li>
						</ul>
					</div>
				</ul>
			</div>
		</nav>

		<div class="header">
			<div class="top">
				<div class="topping">
					<nav class="nav">
						<div class="box">
							<a href="/cleanser"  aria-haspopup="true" aria-expanded="false" class="category">Cleansers</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/eye care"  aria-haspopup="true" aria-expanded="false" class="category">Eye Care</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/lip care" aria-haspopup="true" aria-expanded="false" class="category">Lip Care</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/mask" aria-haspopup="true" aria-expanded="false" class="category">Masks</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/moisturizer" aria-haspopup="true" aria-expanded="false" class="category">Moisturizers</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/serum" aria-haspopup="true" aria-expanded="false" class="category">Serums</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/sunscreen" aria-haspopup="true" aria-expanded="false" class="category">Sunscreen</a>
							<div class="space"></div>
						</div>
						<div class="box">
							<a href="/treatment" aria-haspopup="true" aria-expanded="false" class="category">Treatments</a>
							<div class="space"></div>
						</div>
					</nav>
				</div>
			</div>
		</div>

		<h3 class="d-flex justify-content-center m-4">View All Products</h3>
		
		<div class="row gx-4 p-3">
			<div class="col-2">
				<form action="/search" method="GET">
					<div class="d-flex inline">
						<input type="text" class="form-control" name="keyword" placeholder="Search products...">
							<button type="submit" class="btn btn-search" type="button"> <i class="fa fa-search"></i>
							</button>
						</input>
					</div>
				</form>

				<div class="sidebarheader" style="background-color: transparent;">
					<p class="m-2">Filter by:</p>
					<div class="sidebarheader" style="background-color: transparent; box-sizing: border-box; border-width: 0; border-style: 0; border-color: currentColor;">
						<div class="card">
							<form action="/filters" method="GET">
								<article class="card-group-item">
									<header class="card-header">
										<h6 class="title">
											Price
										</h6>
									</header>
									<div class="filter-content">
										<div class="card-body">
											<label class="form-check">
												<input name="price" class="form-check-input" type="checkbox" value="25"/>
												<span class="form-check-label">
													Under $25
												</span>
											</label>
											<label class="form-check">
												<input name="price" class="form-check-input" type="checkbox" value="50"/>
												<span class="form-check-label">
													Under $50
												</span>
											</label>
											<label class="form-check">
												<input name="price" class="form-check-input" type="checkbox" value="100"/>
												<span class="form-check-label">
													Under $100
												</span>
											</label>
											<label class="form-check">
												<input name="price" class="form-check-input" type="checkbox" value="200"/>
												<span class="form-check-label">
													Under $200
												</span>
											</label>
										</div>
									</div>
								</article>

								<article class="card-group-item">
									<header class="card-header">
										<h6 class="title">
											Skin Type
										</h6>
									</header>
									<div class="filter-content">
										<div class="card-body">
											<label class="form-check">
												<input name="skin" class="form-check-input" type="checkbox" value="dry"/>
												<span class="form-check-label">
													Dry
												</span>
											</label>
											
											<label class="form-check">
												<input name="skin" class="form-check-input" type="checkbox" value="oily"/>
												<span class="form-check-label">
													Oily
												</span>
											</label>
											
											<label class="form-check">
												<input name="skin" class="form-check-input" type="checkbox" value="combination"/>
												<span class="form-check-label">
													Combination
												</span>
											</label>

											<label class="form-check">
												<input name="skin" class="form-check-input" type="checkbox" value="normal"/>
												<span class="form-check-label">
													Normal
												</span>
											</label>

											<label class="form-check">
												<input name="skin" class="form-check-input" type="checkbox" value="sensitive"/>
												<span class="form-check-label">
													Sensitive
												</span>
											</label>
										</div>
									</div>
								</article>

								<article class="card-group-item">
									<header class="card-header">
										<h6 class="title">
											Concern
										</h6>
									</header>
									<div class="filter-content">
										<div class="card-body">
											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Anti-Aging"/>
												<span class="form-check-label">
													Acne
												</span>
											</label>

											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Anti-Aging"/>
												<span class="form-check-label">
													Anti-Aging
												</span>
											</label>
											
											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Dryness"/>
												<span class="form-check-label">
													Dryness
												</span>
											</label>
											
											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Dullness"/>
												<span class="form-check-label">
													Dullness
												</span>
											</label>

											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Hyperpigmentation"/>
												<span class="form-check-label">
													Hyperpigmentation
												</span>
											</label>

											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Pores"/>
												<span class="form-check-label">
													Pores
												</span>
											</label>

											<label class="form-check">
												<input name="concern" class="form-check-input" type="checkbox" value="Wrinkles"/>
												<span class="form-check-label">
													Wrinkles
												</span>
											</label>
										</div>
									</div>
								</article>

								<article class="card-group-item">
									<header class="card-header">
										<h6 class="title">
											Rating
										</h6>
									</header>
									<div class="filter-content">
										<div class="card-body">

											<label class="form-check">
												<input name="rating" class="form-check-input" type="checkbox" value="1"/>
												<span class="form-check-label">
													1 stars
												</span>
											</label>

											<label class="form-check">
												<input name="rating" class="form-check-input" type="checkbox" value="2"/>
												<span class="form-check-label">
													2 stars
												</span>
											</label>
											
											<label class="form-check">
												<input name="rating" class="form-check-input" type="checkbox" value="3"/>
												<span class="form-check-label">
													3 stars
												</span>
											</label>
											
											<label class="form-check">
												<input name="rating" class="form-check-input" type="checkbox" value="4"/>
												<span class="form-check-label">
													4 stars
												</span>
											</label>

											<label class="form-check">
												<input name="rating" class="form-check-input" type="checkbox" value="5"/>
												<span class="form-check-label">
													5 stars
												</span>
											</label>
										</div>
									</div>
								</article>
								<button type="submit" class="btn searchButton">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="col-10">
				<div class="table-responsive">
					<div class="table p-2">
						<table class="col-12" style="line-height: 4">
							<thead>
								<tr>
									<th scope="col">Brand Name:</th>
									<th scope="col">Product Name:</th>
									<th scope="col">Target Concerns:</th>
									<th scope="col">Which skin type is it good for?</th>
									<th scope="col">Price</th>
									<th scope="col">Rating (1-5) </th>
									<th scope="col"></th>
								</tr>
							</thead>
		
							<c:forEach var="product" items="${products.content}">
								<tbody>
									<td>${product.brand}</td>
									<td>${product.name}</a></td>
									<td>${product.concern}</td>
									<td>${product.skin}</td>
									<td>$${product.price}</td>
									<td>${product.rating}</td>
									<td><a href="/view/${product.id}" class="btn viewButton float-end">View</a></td>
								</tbody>
							</c:forEach>
					</table>
				</div>
			</div>
			<c:forEach begin="1" end="${totalPages}" var="index">
        		<a href="/dashboard/pages/${index}">${index}</a>
    		</c:forEach>
			</div>
	</div>
</body>
</html>