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
public class ViewDrawing extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        int order_id = Integer.parseInt(request.getParameter("order_id"));

        List<LineItems> lineItems = LogicFacade.getLineItems(order_id);
        
        int kanvasLength = 800;
        int kanvasHeight = 450;
        int sides = 45;
        int roofLength = lineItems.get(0).getLength(); 
        int roofHeight = lineItems.get(0).getWidth();
        int frontLength = 100;
        int backLength = 30;
        int posts = lineItems.get(0).getPosts();
        int stropes = lineItems.get(0).getRafter();
        int rafter = lineItems.get(0).getRafter();
        int length = (lineItems.get(0).getLength()-100-30);       
        int height = (lineItems.get(0).getWidth()-45-45);

        if (roofLength < kanvasLength || roofHeight < kanvasHeight){
            kanvasLength = roofLength + 300;
            kanvasHeight = roofHeight + 180;
        }
        
        request.setAttribute("frontLength", frontLength);
        request.setAttribute("backLength", backLength);
        request.setAttribute("sides", sides);
        request.setAttribute("kanvasLength", kanvasLength);
        request.setAttribute("kanvasHeight", kanvasHeight);
        request.setAttribute("roofLength", roofLength);
        request.setAttribute("roofHeight", roofHeight);
        request.setAttribute("posts", posts);
        request.setAttribute("stropes", stropes);
        request.setAttribute("rafter", rafter);
        request.setAttribute("length", length);
        request.setAttribute("height", height);
        request.setAttribute("lineItems", lineItems);

        return "viewdrawing";
    }
}
