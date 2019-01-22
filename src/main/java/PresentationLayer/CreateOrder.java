/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LineItems;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henrik
 */
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        
        int id = customer.getCustomer_id();

        Order order = LogicFacade.createOrder(id, comment, length, width, height);

        request.setAttribute("order", order);
        return "createorder";
    }
}
