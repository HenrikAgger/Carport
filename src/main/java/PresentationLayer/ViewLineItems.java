/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LineItems;
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
public class ViewLineItems extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
      
        int order_id = Integer.parseInt(request.getParameter("order_id"));

        List<LineItems> lineItems = LogicFacade.getLineItems(order_id);

        request.setAttribute("lineItems", lineItems);
        return "viewlineitems";
    }
}
