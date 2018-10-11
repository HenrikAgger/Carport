/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

/**
 *
 * @author Henrik
 */
public class OrderFacade {
        public static void createOrder(Order order) throws LoginSampleException {
            DBAccess.OrderMapper.createOrder(order);
        }
}
