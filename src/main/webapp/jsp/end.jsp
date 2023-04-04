<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>end action</title>
    <link href="../static/mySss.css" rel="stylesheet">
    <link href="../static/bootstrap.min.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body class="p-3 mb-2 bg-info text-dark">
<h2 class="greetings">${service.getCurrentAction().getHeadString()}</h2>
<br>
<div><h3>${service.getCurrentAction().getMessage()}</h3></div>
<form method="post" action="/restart">
    <table>
        <tr>
            <th>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Restart</button>
                </div>
            </th>
            <th>
                <jsp:include page="statistic.jsp"/>
            </th>
        </tr>
    </table>
</form>
</body>
</html>
