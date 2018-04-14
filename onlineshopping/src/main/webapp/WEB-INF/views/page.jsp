<%--
  Created by IntelliJ IDEA.
  User: liaoshuisheng
  Date: 2018/3/24
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>


<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${css}/bootstrap-theme.min.css" rel="stylesheet">--%>

    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
    <link href="${css}/jquery.dataTables.css" rel="stylesheet">
    <link href="${css}/bootstrap-glyphicons.min.css" rel="stylesheet" type="text/css"/>

</head>

<body>

<div class="wrapper">

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp" %>

    <div class="content">
        <!-- Page Content -->
        <c:if test="${userClickHome == true}">
            <%@include file="home.jsp" %>
        </c:if>

        <c:if test="${userClickAbout == true}">
            <%@include file="about.jsp" %>
        </c:if>

        <c:if test="${userClickContact == true}">
            <%@include file="contact.jsp" %>
        </c:if>

        <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
            <%@include file="listProducts.jsp" %>
        </c:if>

        <c:if test="${userClickShowProduct == true }">
            <%@include file="singleProduct.jsp" %>
        </c:if>
    </div>

    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>

