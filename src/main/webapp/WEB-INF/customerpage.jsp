<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Customer"%>
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

        <table>
            <td>
                <form name="createOrder" action="FrontController" method="POST">
                    <br>
                    <input type="hidden" name="command" value="createOrder">
                    Comment:<br>
                    <input type="text" name="comment" value="">
                    <br>            
                    Length:<br>
                    <input type="number" name="length" value="780">
                    <br>
                    Width:<br>
                    <input type="number" name="width" value="600">
                    <br>
                    Height:<br>
                    <input type="number" name="height" value="210">
                    <br><br>
                    <input type="submit" value="Create order">
                </form>
            </td>
        </table>
        <form name="ViewOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewOrders" > <br>
            <input type="submit" value="View customer orders">
        </form>
    </body>
</html>
