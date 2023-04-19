<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post a New Product</title>
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

        <div class="p-4">
            <form:form action="/new" method="POST" modelAttribute="newProduct" enctype="multipart/form-data" class="form-group p-3">
                <div class="text-danger">
                    <p><form:errors path="category"/></p>
                    <p><form:errors path="brand"/></p>
                    <p><form:errors path="name"/></p>
                    <p><form:errors path="price"/></p>
                    <p><form:errors path="skin"/></p>
                    <p><form:errors path="concern"/></p>
                    <p><form:errors path="description"/></p>
                    <p><form:errors path="rating"/></p>
                </div>

                <div class="form-row">
                    <form:label path="category">Product Category:</form:label>
                    
                    <form:select path="category" class="form-select" aria-label="Default select example">
                        <form:option value="NONE" label="--- Select ---"></form:option>
                        <form:options items = "${ categoryList }"/>
                    </form:select>
                </div>

                <div class="form-row">
                    <form:label path="brand">Brand:</form:label>
                    <form:input type="text" path="brand" class="form-control"/>
                </div>

                <div class="form-row">
                    <form:label path="name">Name:</form:label>
                    <form:input type="text" path="name" class="form-control"/>
                </div>

                <div class="form-row">
                    <form:label path="price">Price:</form:label>
                    <form:input type="number" step=".01" path="price" pattern="^\d+(?:\.\d{1,2})?$" class="form-control"/>
                </div>
                
                <div class="form-row">
                    <form:label path="category">Target Concerns:</form:label>
                    
                    <form:select path="concern" class="form-select" aria-label="Default select example">
                        <form:option value="NONE" label="--- Select ---"></form:option>
                        <form:options items = "${ concernList }"/>
                    </form:select>
                </div>
                
                <div class="form-row">
                    <form:label path="skinList">What's your skin type:</form:label>
                    
                    <form:select path="skin" class="form-select" aria-label="Default select example">
                        <form:option value="NONE" label="--- Select ---"></form:option>
                        <form:options items = "${ skinList }"/>
                    </form:select>
                </div>

                <div class="form-row">
                    <form:label path="description">Description:</form:label>
                    <form:textarea path="description" class="form-control"/>
                </div>

                <div class="form-row">
                    <form:label path="rating">Rate this product from 1-5:</form:label>
                    <form:input type="number" min="1" max="5" path="rating" class="form-control"/>
                </div>

                <div class="form-row">
                    <form:errors path="submittedBy"/>
                    <form:input type="hidden" path="submittedBy" value="${loggedInUser.id}" class="form-control"/>
                </div>

                <div class="d-flex justify-content-between mt-2">
                    <button class="btn viewButton">Submit</button>  &nbsp
                    <a href="/dashboard/pages/1" class="btn viewButton">Cancel</a>
                </div>

            </form:form> 
        </div>
    </div>
</body>
</html>