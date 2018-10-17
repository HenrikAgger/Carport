package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder( int userId, int length, int width, int height) throws LoginSampleException {
        Order order = new Order(userId, length, width, height);
        OrderMapper.createOrder(order);
        return order;
    }

    public static List<Order> getOrdersCustomer(int userId)throws LoginSampleException{
        return OrderMapper.getOrdersFromUser(userId);
    }
    
    
/*    
    public static Order getOrdersFromUser(User user) throws LoginSampleException {
        
        List<Order> viewOrders = OrderMapper.getOrdersFromUser(list);
        //return OrderMapper.getOrdersFromUser(list);
    }
*/
    
    
    
    
}
