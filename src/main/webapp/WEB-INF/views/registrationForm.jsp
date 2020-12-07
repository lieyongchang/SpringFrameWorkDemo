<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
</head>
<body>
   <h1>User Registration Form</h1>
   <hr />

   <form:form action="saveUser" method="post" modelAttribute="user">
      <table>
         <tr>
            <td>First Name</td>
            <td><form:input path="firstName" /></td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td><form:input path="lastName" /></td>
         </tr>
         <tr>
            <td>Username</td>
            <td><form:input path="username" /></td>
         </tr>
         <tr>
            <td>Password</td>
            <td><form:password path="password" /></td>
         </tr>
         <tr>
            <td>Email</td>
            <td><form:input path="email" /></td>
         </tr>
         <tr>
            <td></td>
            <td><form:button>Submit</form:button></td>
         </tr>
      </table>
   </form:form>

</body>
</html>