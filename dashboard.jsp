<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME</title>
</head>
<body>
    <c:import url="header.jsp">
        <c:param name="color" value="green" />
        <c:param name="logo" value="logo.png" />
</c:import>
    <!-- <%@ include file="header.jsp"%> -->
    
    <%@ include file="menu.jsp"%>
    
    <h1>Dashboard</h1>

    <%@ include file="footer.jsp"%>
</body>
</html>