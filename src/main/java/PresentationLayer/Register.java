package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            Customer customer = LogicFacade.createCustomer(name, phone, email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            return "customerpage";
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }
}
