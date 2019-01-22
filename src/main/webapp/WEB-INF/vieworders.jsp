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
        <title>View orders</title>
    </head>
    
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>   
    
    
    <body>
        <h2>View orders</h2>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Date</th>
                    <th>Comment</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>LineItems</th>
                    <th>Drawing</th>
                </tr>
            </thead>

            <tbody>

                <%List<Order> orderList = (List<Order>) request.getAttribute("orderList");%>

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
                    <td><a href="/FrontController?command=viewLineItems&order_id=<%=order.getOrder_id()%>">View lineItems</a>
                        <td><a href="/FrontController?command=viewDrawing&order_id=<%=order.getOrder_id()%>">View drawing</a> 
                </tr>

                <% }%>
            </tbody>
        </table>

        <h3>You have <%= orderList.size()%> orders</h3>

    </body>
</html>
