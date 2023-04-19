<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="flex-container">
        <div class="registerbackground overflow-hidden">
            <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0">
                <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                    Welcome to<br />
                    <span style="color: hsl(334, 100%, 1%)">Skincare Review!</span>
                </h1>
                <p class="mb-4 opacity-70" style="color: hsl(0, 0%, 100%)">
                    A place where you can post honest reviews for all things skincare.
                </p>
                </div>
        
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
    
                <div class="registercard">
                    <div class="card-body px-4 py-5 px-md-5">
                        <form:form action="/login" method="POST" modelAttribute="newLogin">
                            <div class="text-danger">
                                <p><form:errors path="email"/></p>
                                <p><form:errors path="password"/></p>
                            </div>
            
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                            <form:input path="email" type="email" id="form3Example3" class="form-control" />
                            <form:label path="email" class="form-label" for="form3Example3">Email address</form:label>
                            </div>
            
                            <!-- Password input -->
                            <div class="form-outline mb-4">
                            <form:input path="password" type="password" id="form3Example4" class="form-control" />
                            <form:label path="password" class="form-label" for="form3Example4">Password</form:label>
                            </div>
    
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block mb-4">
                            Login!
                            </button>
                        </form:form>
                        <p>Dont have an account? <a href="/register">Sign up</a></p>
                    </div>
                </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</body>
</html>