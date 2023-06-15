<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Chuyển đổi tiền tệ" %>
</h1>
<form action="chuyendoitiente" method="post">
    $: <input type="number" name="vnd" placeholder="100000">
    <button type="submit">chuyển đổi</button>
</form>
<br/>
</body>
</html>