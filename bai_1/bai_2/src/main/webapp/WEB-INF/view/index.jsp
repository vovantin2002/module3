<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Tra cứu từ điển: " %>
</h1>
<br/>
<form action="/dictionary" method="post">
    nhập từ: <input type="text" name="tu">
    <button type="submit">tra cứu</button>
    ${result}
</form>
</body>
</html>