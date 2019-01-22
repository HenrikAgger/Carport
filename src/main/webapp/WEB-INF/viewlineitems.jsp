<%-- 
    Document   : viewlineitems
    Created on : 16-10-2018, 08:36:04
    Author     : Henrik
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LineItems"%>

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
        <h1>Order ID <%=request.getParameter("order_id")%> </h1>
        <table>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Product lenght</th>
                    <th>Amount</th>
                    <th>Unit</th>
                    <th>Name</th>
                    <th>Product ID</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>

                </tr>
            </thead>
            <tbody>

                <%List<LineItems> lineItems = (List<LineItems>) request.getAttribute("lineItems");%>

                <%
                    for (int i = 0; i < 3; i++) {%>
                <tr>
                    <td> <%= lineItems.get(i).getDescription()%></td>
                    <td> <%= lineItems.get(i).getPlength()%></td>
                    <td> <%= lineItems.get(i).getAmount()%></td> 
                    <td> <%= lineItems.get(i).getUnit()%></td>
                    <td> <%= lineItems.get(i).getName()%></td>
                    <td> <%= lineItems.get(i).getProduct_id()%></td>
                    <td> <%= lineItems.get(i).getLength()%></td>
                    <td> <%= lineItems.get(i).getWidth()%></td>
                    <td> <%= lineItems.get(i).getHeight()%></td>
                    
                </tr>
                <% }%>
            </tbody>

        </table>
    </body>
    
    <p>Return to login-page <strong><a href="index.jsp">link to indexside</a></p>

</html>
