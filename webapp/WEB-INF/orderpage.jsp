<%-- 
    Document   : OrderPage
    Created on : 20-11-2018, 09:34:09
    Author     : Henrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OrderPage</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> <br> Make a new order!</h1>
        <table>
            <tr>
                <td>Order:
                    <form name="OrderPage" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="OrderPage">
                        <input type="hidden" name="command" value="<%=request.getParameter("email")%>">
                        <br>       
                        <input type="text" name="width" value="">
                        <br>
                        <input type="submit" value="Finalize order!">       
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
