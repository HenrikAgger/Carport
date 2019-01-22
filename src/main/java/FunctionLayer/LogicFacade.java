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

    public static List<LineItems> getLineItems(int order_id) throws LoginSampleException {
        List<LineItems> lineitems = OrderMapper.getLineItems(order_id);
        int length, width, height;
        int roofLength, roofWidth;
        int plengthPost, plengthRafter, plengthStrop;
        int postsLength, postsWidth, posts;
        int stropes;
        int rowsStropes;
        int rafter;
        int amount;

        for (int i = 0; i < lineitems.size(); i++) {
            length = lineitems.get(i).getLength() - 100 - 30;
            width = lineitems.get(i).getWidth() - 45 - 45;
            height = lineitems.get(i).getHeight();
            roofLength = lineitems.get(i).getLength();
            roofWidth = lineitems.get(i).getWidth();
            plengthPost = lineitems.get(0).getPlength(); // product length 
            plengthRafter = lineitems.get(1).getPlength(); 
            plengthStrop = lineitems.get(2).getPlength(); 

            // amount of posts
            if ((length % plengthPost) != 0) { // length between posts concerning carport length
                postsLength = (length / plengthPost) + 1;
            } else {
                postsLength = (length / plengthPost);
            }

            if ((width % plengthRafter) != 0) { // length between posts concerning carport width
                postsWidth = (width / plengthRafter) + 1;
                if (postsWidth == 1) {
                    postsWidth = 2;
                }
            } else {
                postsWidth = (width / plengthRafter);
                if (postsWidth == 1) {
                    postsWidth = 2;
                }
            }

            posts = postsLength * postsWidth;

            // amount of rafters
            if ((roofLength % 55) != 0) {
                rafter = ((roofLength / 55) + 1);
                if (rafter == 1) {
                    rafter = 2;
                }
            } else {
                rafter = (roofLength / 55);
                if (rafter == 1) {
                    rafter = 2;
                }
            }

//            if ((width % plengthRafter) != 0) {
//                rafterTotal = rafter * (roofWidth / 600) + 1; 
//            } else {
//                rafterTotal = rafter * (roofWidth / 600);
//            }

            // amount of stropes 
            if (((roofLength * 2) % 600) != 0) {
                stropes = ((roofLength * 2) / 600) + 1; 
                if (stropes == 1) {
                    stropes = 2;
                }
            } else {
                stropes = ((roofLength * 2) / 600);
                if (stropes == 1) {
                    stropes = 2;
                }
            }

            // rows of stropes
            if ((width % 600) != 0){
                rowsStropes = (width / 600) + 1;
            } else {
                rowsStropes = (width / 600);
                if (rowsStropes == 1){
                    rowsStropes = 2;
                }
            }
            
            lineitems.get(0).setAmount(posts);
            lineitems.get(1).setAmount(rafter); // rafterTotal
            lineitems.get(2).setAmount(stropes);

            lineitems.get(i).setLength(roofLength);
            lineitems.get(i).setWidth(roofWidth);
            lineitems.get(i).setPostsLength(postsLength);
            lineitems.get(i).setPostsWidth(postsWidth);
            lineitems.get(i).setPosts(posts);
            lineitems.get(i).setStropes(stropes);
            lineitems.get(i).setRafter(rafter);

        }
        return lineitems;
    }

//    public static int createLineItems(LineItems lineItems) throws LoginSampleException {
//        return OrderMapper.createLineItems(lineItems);
//    }

    public static List<Order> getAllOrders(int customer_id) throws LoginSampleException {
        return OrderMapper.getAllOrders(customer_id);
    }

    public static List<Customer> getAllCustomers(int customer_id) throws LoginSampleException {
        return CustomerMapper.getAllCustomers(customer_id);
    }

//    public static Products createProducts(Products products) throws LoginSampleException { // tilrettes
//        return OrderMapper.createProducts(products);
//    }    
}
