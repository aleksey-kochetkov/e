<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Spring MVC Form Handling</title>
  <style>
    .test {
      outline-style: groove;
    }
  </style>
</head>

<body>
<h2>Student Information</h2>
<form:form method="POST" action="result">
  <table>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name" class="test"/></td>
    </tr>
    <tr>
      <td><form:label path="age">Age</form:label></td>
      <td><form:input path="age" disabled="true"/></td>
    </tr>
    <tr>
      <td>
        <form:label path="name">Country</form:label>
      </td>
      <td>
        <form:select path="country.code">
          <form:option value="NONE" label="—" disabled="true"/>
          <form:options items="${countries}"/>
        </form:select>
      </td>
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