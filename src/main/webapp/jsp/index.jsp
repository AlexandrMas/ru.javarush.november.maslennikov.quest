<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>start page</title>
    <link href="../static/mySss.css" rel="stylesheet">
    <link href="../static/bootstrap.min.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body class="p-3 mb-2 bg-info text-dark">
<h1 class="greetings">Добро пожаловать!!!</h1>
<h3> Ты детектив, приехал в небольшой городок по распределению после академии.</h3>
<h3>Силовые структуры этого города уже давно не могут поймать банду,</h3>
<h3>специализирующуюся на кражах кошачьего корма из магазинов.</h3>
<h3>Ты заходишь в новый участок и знакомишься с коллегами.</h3>
<div>
    <table>
        <tr>
            <th>
                <img src="../static/img/meet1.jpeg" width="460" height="300" alt="">
            </th>
            <th>
                <form method="post" action="/start">
                    <div class="place">
                        <span>
                             <label> <b>Представиться:</b></label>
                        </span>
                        <c:if test="${blank}">
                            <div id="alert" role="alert">
                                <strong>Имя должно содержать только буквы</strong>
                            </div>
                        </c:if>
                        <c:if test="${gamer == null}">
                            <div>
                                <input name="gamerName" type="text" class="form-control" value="">
                            </div>
                        </c:if>
                        <c:if test="${gamer!= null}">
                            <div class="col-sm-10">
                                <input name="gamerName" type="text" class="form-control" value="${gamer.getName()}">
                            </div>
                        </c:if>
                        <br>
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Start</button>
                        </div>
                    </div>
                </form>
            </th>
        </tr>
    </table>
</div>
</body>
<link href="../static/mySss.css" rel="stylesheet">
</html>
