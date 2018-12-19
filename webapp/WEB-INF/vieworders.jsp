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
                (customer_id, comment,length, width, height)
                <%
                    for (Order order : orderList) {%>
                <tr>
                    <td> <%= order.getOrder_id()%> </td>
                    <td> <%= order.getCustomer_id()%> </td>
                    <td> <%= order.getDate()%> </td>
                    <td> <%= order.getComment()%> </td>
                    <td> <%= order.getLength()%> </td>
                    <td> <%= order.getWidth()%> </td>
                    <td> <%= order.getHeight()%> </td>                    


                    <%--                    
                                        <td> <%= order.getUserId() %> </td>
                                        <td> <%= order.getLength() %> </td>
                                        <td> <%= order.getWidth() %> </td>
                                        <td> <%= order.getHeight() %> </td>
                    --%>                    
                </tr>

                <% }%>
            </tbody>
        </table>

        <h3>You have <%= orderList.size()%> orders</h3>

    </body>
</html>
