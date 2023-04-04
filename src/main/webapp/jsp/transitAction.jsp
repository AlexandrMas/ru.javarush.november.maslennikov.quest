<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>transit action</title>
    <link href="../static/mySss.css" rel="stylesheet">
    <link href="../static/bootstrap.min.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body class="p-3 mb-2 bg-info text-dark">
<h2 class="greetings">${service.getCurrentAction().getHeadString()}</h2>
<br>
<div><h3>${service.getCurrentAction().getMessage()}</h3></div>
<form method="post" action="/transit">
    <fieldset>
        <table>
            <tr>
                <th>
                    <div>
                        <input type="radio" id="choiceYES" name="answer" value="yes"
                               checked>
                        <label class="form-check-label" for="choiceYES">
                            <b>Да</b>
                        </label>
                    </div>
                    <div>
                        <input type="radio" id="choiceNO" name="answer" value="no">
                        <label class="form-check-label" for="choiceNO">
                            <b>Нет</b>
                        </label>
                    </div>
                    <div class="butt">
                        <button type="submit" class="btn btn-primary">Answer</button>
                    </div>
                </th>
                <th>
                    <div>
                        <jsp:include page="statistic.jsp"/>
                    </div>
                </th>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
