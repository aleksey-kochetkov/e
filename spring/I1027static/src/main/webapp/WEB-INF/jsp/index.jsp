<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Landing Page</title>
</head>

<body>
<h2>Spring Landing Pag</h2>
<p>Click below button to get a simple HTML page</p>

<form:form action="static" method="GET">
  <table>
    <tr>
      <td>
        <input type="submit" value="Get HTML Page"/>
      </td>
    </tr>
    <tr>
      <td>Нажмите чтобы получить нечто простое</td>
    </tr>
  </table>
</form:form>
</body>

</html>