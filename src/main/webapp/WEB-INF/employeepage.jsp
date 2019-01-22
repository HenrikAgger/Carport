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
        <title>Employee home page</title>
    </head>
    <!--
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>  
    -->
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a employee.

        <form name="ViewOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewOrders" > <br>
            <input type="submit" value="View all customer orders">
        </form>

        <form name="ViewAllCustomers" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewAllCustomers" > <br>
            <input type="submit" value="View all customers">
        </form>
    </body>

</html>
