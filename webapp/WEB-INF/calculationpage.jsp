<%-- 
    Document   : calculationpage
    Created on : 04-11-2018, 14:44:52
    Author     : Henrik
--%>

<%@page import="FunctionLayer.OrderLine"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculation</title>
    </head>

    <body>
        <div> 
            <h1> <%=request.getParameter("email")%> View your orders</h1>
            <table>
                <tr>
                    <td>
                        <%
                            List<OrderLine> stykliste = (List<OrderLine>) request.getSession().getAttribute("stykliste");
                            for (int i = 0; i < stykliste.size(); i++){
                                out.println(
                                "OrderLine: <br>" + "2x4: "
                                + stykliste.get(i).getTotal2x4() + "<br>" + "2x2: " 
                                + "2x2: " + stykliste.get(i).getTotal2x2() + "<br>"
                                + "1x2 :" + stykliste.get(i).getTotal1x2()
                                );
                            }
                        %>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
