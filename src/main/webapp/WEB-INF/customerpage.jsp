<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="StyleSheet" type="text/css" href="/newcss.css">
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a customer on our wonderful site. 
    </body>
    <td>
        <form name="createOrder" action="FrontController" method="POST">
            <br>
            <input type="hidden" name="command" value="createOrder">
            Length:<br>
            <input type="number" name="length" value="4">
            <br>
            Width:<br>
            <input type="number" name="width" value="4">
            <br>
            Height:<br>
            <input type="number" name="height" value="1">
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </td>

        <form name="View Orders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewOrders" /> <br>
            <input type="submit" value="View Orders">
        </form>
    
</html>
