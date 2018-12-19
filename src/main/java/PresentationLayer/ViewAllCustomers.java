/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henrik
 */
public class ViewAllCustomers extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Customer> customerList;

        customerList = LogicFacade.getAllCustomers(customer.getCustomer_id());

        request.setAttribute("customerList", customerList);

        return "viewallcustomers";
    }   
}
