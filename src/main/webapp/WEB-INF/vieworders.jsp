<%-- 
    Document   : vieworders
    Created on : 16-10-2018, 08:36:04
    Author     : Henrik
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View order-history</title>
    </head>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>   
        
    <body>
        <h2>List of Orders</h2>
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th> 
                </tr>
            </thead>

            <tbody>

                <%List<Order> orderList = (List<Order>) request.getAttribute("orderList");%>
                
                <%int counter = 0;
                    for (Order order : orderList) {%>
                <tr>
                    <td> <%= order.getUserId() %> </td>
                    <td> <%= order.getLength() %> </td>
                    <td> <%= order.getWidth() %> </td>
                    <td> <%= order.getHeight() %> </td>
                </tr>
                <% counter++; %>
                <% }%>
            </tbody>
        </table>
            
            <h3>You have <%= counter %> orders</h3>
            
    </body>
</html>
