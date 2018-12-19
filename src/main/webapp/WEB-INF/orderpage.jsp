<%-- 
    Document   : orderpage
    Created on : 12-10-2018, 14:08:12
    Author     : Henrik
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newcss.css">
        <title>Order</title>
    </head>

    <body>
        <div>
            <% Order order = (Order) request.getAttribute("order");%>
            <h1>Order ID: <%=order.getOrder_id()%> </h1>

            <table>
                <tr>
                    <td colspan="2">Selected dimensions</td>
                </tr>
                <tr>
                    <th>Length</th> <br>
                <th><%=order.getLength()%> </th> 
                </tr>
                <tr>
                    <th>Width</th> <br>
                <th><%=order.getWidth()%>  </th> 
                </tr>
                <tr>
                    <th>Height</th> <br>
                <th><%=order.getHeight()%> </th> 
                </tr>
            </table>
        </div>
    </body>

    <p>Return to login-page <strong><a href="index.jsp">link to indexside</a></p>

    <p>View orders </p>
    <form name="View Orders" action="FrontController" method="POST">
        <input type="hidden" name="command" value="viewOrders" /> <br>
        <input type="submit" value="Order history">
    </form>

</html>
