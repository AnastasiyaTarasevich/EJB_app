<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
  <title>Заполнение студентов</title>
</head>
<body>
<h1>Страница с вводом фамилий и оценок</h1>
<form action="processGrades" method="post" accept-charset="UTF-8">
<%
  int count= (int) request.getAttribute("count");
  for (int i = 1; i <= count; i++) {
  %>
  <label for="name<%= i %>">Имя студента <%= i %>:</label>
  <input type="text" id="name<%= i %>" name="name<%= i %>" /><br/>
  <label for="grades<%= i %>">Оценки (через запятую):</label>
  <input type="text" id="grades<%= i %>" name="grades<%= i %>" /><br/>
  <% } %>
  <button type="submit">Добавить оценки</button>
</form>
</body>
</html>
