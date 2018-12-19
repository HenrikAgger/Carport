<%-- 
    Document   : viewallcustomers
    Created on : 13-12-2018, 16:53:22
    Author     : Henrik
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>   

    <body>
        <h2>List of customers</h2>
        <table>
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Customer name</th>
                    <th>Phone</th>
                    <th>E-mail</th>
                    <th>Password</th>
                </tr>
            </thead>

            <tbody>

                <%List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");%>

                <%
                    for (Customer customer : customerList) {%>
                <tr>
                    <td> <%= customer.getCustomer_id()%> </td>
                    <td> <%= customer.getName()%> </td>
                    <td> <%= customer.getPhone()%> </td>
                    <td> <%= customer.getEmail()%> </td>
                    <td> <%= customer.getPassword()%> </td>
                </tr>

                <% }%>
            </tbody>
        </table>

        <h3>You have <%= customerList.size()%> orders</h3>

    </body>
</html>


