package FunctionLayer;

import DataLayer.CustomerMapper;
import DataLayer.OrderMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static Customer login(String email, String password) throws LoginSampleException {
        return CustomerMapper.login(email, password);
    }

    public static Customer createCustomer(String name, int phone, String email, String password) throws LoginSampleException {
        Customer customer = new Customer(name, phone, email, password);
        CustomerMapper.createCustomer(customer);
        return customer;
    }

    public static Order createOrder(int customer_id, String comment, int length, int width, int height) throws LoginSampleException {
        Order order = new Order(0, customer_id, null, comment, length, width, height);
        order = OrderMapper.createOrder(order);
        return order;
    }

    public static List<Order> getCustomerOrders(int customer_id) throws LoginSampleException {
        return OrderMapper.getCustomerOrders(customer_id);
    }

    public static Bill getCalculations(Order order) {
        LineItemCalculator calc = new LineItemCalculator(order.getLength(), order.getWidth());

        Bill bill = new Bill();
        bill.setPosts(calc.getCalculatePosts());

        bill.setRafter(calc.getCalculateRafter());
        return bill;
    }
    
    public static List<LineItem> getLineItems(int order_id) throws LoginSampleException {
        return OrderMapper.getLineItems(order_id);
    }
    
    public static int createLineItems(LineItem lineItem) throws LoginSampleException {
        return OrderMapper.createLineItems(lineItem);
    }

    public static List<Order> getAllOrders(int customer_id) throws LoginSampleException {
        return OrderMapper.getAllOrders(customer_id);
    }
    
    public static List<Customer> getAllCustomers(int customer_id) throws LoginSampleException {
        return CustomerMapper.getAllCustomers(customer_id);
    }    
    
}
