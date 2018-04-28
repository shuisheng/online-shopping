<%--
  Created by IntelliJ IDEA.
  User: liaoshuisheng
  Date: 2018/4/28
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="${css}/bootstrap-glyphicons.css" rel="stylesheet" type="text/css"/>

</head>

<body>

<div class="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${flowExecutionContext}&_eventId_home">Home</a>
            </div>
        </div>
    </nav>

    <div class="content">

        <div class="container">
            <h3>This will be triggered by flow!</h3>
        </div>
    </div>

    <!-- Footer -->
    <%@include file="../../shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.validate.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>
    <script src="${js}/myapp.js"></script>
    <script src="${js}/bootbox.min.js"></script>
</div>
</body>

</html>

