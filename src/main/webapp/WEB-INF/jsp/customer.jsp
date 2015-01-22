<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head> 
<title>Customers: ${curtime}</title>
</head>

<body>
  <h1>Customers - ${curtime}</h1>
  <hr/>

  <form action="add.do" method="POST">
    <p>Add New Customer <br></p>
    <p>First Name: <input type="text" name="firstName" id="firstName" maxlength="50" size="50"/> <br>
      Last Name: <input type="text" name="lastName" id="lastName" maxlength="50" size="50"/> <br>
      Date of Birth: <input type="text" name="birthDate" id="birthDate" maxlength="10" size="10"/> <br>
      Gender: <input type="radio" name="gender" id="gender" value="M"/> Male
              <input type="radio" name="gender" id="gender" value="F"/> Female <br>
      <input type="submit" name="add" id="add" value="Add"/>
    </p>
  </form>  
  <hr/>
  
  <table border="1">
    <thead>
      <tr>
        <td>Name</td>
        <td>Gender</td>
        <td>Date of Birth</td>
        <td>Action</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="customer" items="${list}">
        <tr>
          <td>${customer.firstName} ${customer.lastName}</td>
          <td>${customer.gender}</td>
          <td>${customer.birthDate}</td> 
          <td>
            <form action="delete.do" method="POST">
              <input type="hidden" name="customerId" id="customerId" value="${customer.id}"/>
              <input type="submit" name="delete" id="delete" value="Delete"/>
            </form>
        </tr>
    </c:forEach>
    </tbody>
  </table>
  <hr/>
  
</body>
</html>