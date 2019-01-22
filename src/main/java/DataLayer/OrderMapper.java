/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.LineItems;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrik
 */
public class OrderMapper {

    public static Order createOrder(Order order) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Carport.Order (customer_id, comment, length, width, height) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomer_id());
            ps.setString(2, order.getComment());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getHeight());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrder_id(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return order;
    }

    public static List<Order> getCustomerOrders(int customer_id) throws LoginSampleException {
        List<Order> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();

            String SQL = "SELECT * "
                    + "FROM Carport.Order o, Carport.Customer c "
                    + "WHERE o.customer_id = c.customer_id AND c.customer_id = ? ORDER BY order_id DESC";

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int c_id = rs.getInt("customer_id");
                Date date = rs.getDate("date");
                String comment = rs.getString("comment");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                list.add(new Order(order_id, c_id, date, comment, length, width, height));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

    public static List<LineItems> getLineItems(int order_id) throws LoginSampleException {
        List<LineItems> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();

            String SQL = "SELECT o.order_id, o.customer_id, o.date, o.comment, o.length, o.width, o.height, l.amount, p.product_id, p.name, p.plength, p.unit, p.description "
                    + "FROM Carport.Order o, Carport.Products p, Carport.LineItems l "
                    + "WHERE o.order_id = ?"; 

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int o_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int amount = rs.getInt("amount");
                String name = rs.getString("name");
                int plength = rs.getInt("plength");
                String unit = rs.getString("unit");
                String description = rs.getString("description");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                list.add(new LineItems(o_id, product_id, amount, name, plength, unit, description, length, width, height)); 
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

    public static List<Order> getAllOrders(int customer_id) throws LoginSampleException {
        List<Order> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();

            String SQL = "SELECT * "
                    + "FROM Carport.Order o, Carport.Customer c "
                    + "WHERE o.customer_id = c.customer_id "
                    + "ORDER BY order_id DESC, c.customer_id";
            
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int c_id = rs.getInt("customer_id");
                Date date = rs.getDate("date");
                String comment = rs.getString("comment");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                list.add(new Order(order_id, c_id, date, comment, length, width, height));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

}
