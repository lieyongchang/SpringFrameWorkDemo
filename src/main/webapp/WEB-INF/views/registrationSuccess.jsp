<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
</head>
<body>
   <h1>${message}</h1>
   <hr />

   <table>
      <tr>
         <td>First Name : ${user.firstName}</td>
      </tr>
      <tr>
         <td>Last Name : ${user.lastName}</td>
      </tr>
      <tr>
         <td>Username ${user.username}</td>
      </tr>
      <tr>
         <td>Email : ${user.email}</td>
      </tr>
   </table>
</body>
</html>