<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME</title>
    <link rel="stylesheet" href="common.css">
</head>

<body>
    <div class="main_block">
        <!-- <%@ include file="header.jsp"%> -->
        <c:import url="header.jsp">
            <c:param name="color" value="green" />
            <c:param name="logo" value="logo.png" />
        </c:import>

        <!-- <%@ include file="menu.jsp"%> -->
        <div class="main_box" style=" border: 3px solid green; height:300px; margin-top: 65px;">
            <table align="center" style="height: 200px; width: 70%; margin: 15px auto;">
                <tr>
                    <td>
                        <a href="signup.do">SignUp</a>
                    </td>
                <tr>


                </tr>
                <td>
                    <a href="signin.do">SignIn</a>
                </td>
                </tr>


            </table>
        </div>

        <!-- <%@ include file="footer.jsp"%> -->
        

        <c:import url="footer.jsp">
            
        </c:import>
    

    </div>
</body>

</html>