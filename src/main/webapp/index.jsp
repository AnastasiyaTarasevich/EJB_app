
<%@ taglib prefix="custom" uri="/WEB-INF/student-tag.tld" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MyEjb Page</title>
</head>
<body>
<form action="index" method="post">
    <label for="collectionSize">Количество студентов:</label>
    <input type="text" id="collectionSize" name="collectionSize" required><br><br>
    <input type="submit"></input>
</form>

</body>
</html>