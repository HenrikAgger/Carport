<%-- 
    Document   : viewlineitems
    Created on : 16-10-2018, 08:36:04
    Author     : Henrik
--%>

<%@page import="FunctionLayer.Products"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LineItem"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>

    <body>
        <h2>List of lineitems</h2>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Product ID</th>
                    <th>Amount</th>

                </tr>
            </thead>
            <tbody>

                <%List<LineItem> lineItem = (List<LineItem>) request.getAttribute("lineItem");%>

                <%
                    for (LineItem item : lineItem) {%>
                <tr>
                    <td> <%= item.getOrder_id()%></td>
                    <td> <%= item.getProduct_id()%></td>
                    <td> <%= item.getAmount()%></td>


                </tr>
                <% }%>
            </tbody>
            <h3>You have <%= lineItem.size()%> lineitems</h3>

        </table>
    </body>

    <p>Return to login-page <strong><a href="index.jsp">link to indexside</a></p>

</html>
