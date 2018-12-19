/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.LineItem;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Bill;
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
            String SQL = "SELECT * FROM Carport.Order o, Carport.Customer c "
                    + "WHERE o.order_id = c.customer_id AND c.customer_id = ?;";
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

    public static List<LineItem> getLineItems(int order_id) throws LoginSampleException {
        List<LineItem> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT o.order_id, p.product_id, l.amount, p.name, p.length, p.unit, p.description "
                    + "FROM Carport.LineItems l "
                    + "INNER JOIN Carport.Order o ON l.order_id = o.order_id "
                    + "INNER JOIN Carport.Products p ON l.product_id = p.product_id "
                    + "WHERE o.order_id = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int o_id = rs.getInt("order_id");
                int product_id = rs.getInt("product_id");
                int amount = rs.getInt("amount");
                String name = rs.getString("name");
                int length = rs.getInt("length");
                String unit = rs.getString("unit");
                String description = rs.getString("description");
                list.add(new LineItem(o_id, product_id, amount, name, length, unit, description));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

    public static List<Bill> getCalculations(Order order) throws LoginSampleException {
        List<Bill> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT o.length, o.width FROM Carport.Order o, Carport.Products p "
                    + "WHERE o.order_id = ? AND o.order_id = p.product_id";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, order.getOrder_id());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

    public static int createLineItems(LineItem lineItem) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Carport.LineItems (order_id, product_id, amount) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lineItem.getOrder_id());
            ps.setInt(2, lineItem.getProduct_id());
            ps.setInt(3, lineItem.getAmount());

            int res = ps.executeUpdate();
            return res;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public static List<Order> getAllOrders(int customer_id) throws LoginSampleException {
        List<Order> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();

            String SQL = "SELECT * FROM Carport.Order o, Carport.Customer c "
                    + "WHERE o.order_id = c.customer_id";
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
