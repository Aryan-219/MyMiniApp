<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SignIn Page</title>
</head>

<body>
    <c:import url="header.jsp">
        <c:param name="color" value="green" />
        <c:param name="logo" value="logo.png" />
    </c:import>
    <h1>Enter the following details</h1>

    <form action="signin.do" method="post">
        
        <label for="eml">Email: </label> <input type="text" name="eml" />
        <label for="pwd">Password: </label> <input type="password" name="pwd" />
        <input type="submit" value="SignIn" />
    </form>
</body>

</html>