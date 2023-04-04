<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>statistic</title>
    <link href="../static/mySss.css" rel="stylesheet">
    <link href="../static/bootstrap.min.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
<div class="inner-page">
    <h4>Statistic:</h4>
    <h5>Ip: ${gamer.getIp()}</h5>
    <h5>Name: ${gamer.getName()}</h5>
    <h5>Games played: ${ gamer.getNumberOfGamesPlayed()}</h5>
</div>
</body>
</html>
