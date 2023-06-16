<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Sandwich Condiments" %>
</h1>
<br/>
<form action="caculator" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <br>
    <br>
    <button type="submit" value="add" name="caculator">Addition(+)</button>
    <button type="submit" value="sub" name="caculator">Subtraction(-)</button>
    <button type="submit" value="mul" name="caculator">Multiplication(x)</button>
    <button type="submit" value="div" name="caculator">Division(/)</button>
</form>
<br>
<br>
${result}
</body>
</html>