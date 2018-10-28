<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Student Information</h2>
<form:form method="POST" action="addStudent">
  <table>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="age">Age</form:label></td>
      <td><form:input path="age"/></td>
    </tr>
    <tr>
      <td><form:label path="code">code</form:label></td>
      <td><form:input path="code"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Подтвердить"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>