<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>  

    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a employee.
    </body>


    <td>
        <form name="createOrder" action="FrontController" method="POST">
            <br>
            <input type="hidden" name="command" value="createOrder">
            Comment:<br>
            <input type="text" name="comment" value="">
            <br>            
            Length:<br>
            <input type="number" name="length" value="100">
            <br>
            Width:<br>
            <input type="number" name="width" value="100">
            <br>
            Height:<br>
            <input type="number" name="height" value="100">
            <br><br>
            <input type="submit" value="Create order">
        </form>
    </td>

    <body>
        <div>
            <form name="ViewOrders" action="FrontController" method="POST">
                <input type="hidden" name="command" value="viewOrders" > <br>
                <input type="submit" value="View all customer orders">
            </form>

            <form name="ViewAllCustomers" action="FrontController" method="POST">
                <input type="hidden" name="command" value="viewAllCustomers" > <br>
                <input type="submit" value="View all customers">
            </form>
        </div>
    </body>

</html>
