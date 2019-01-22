/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import java.sql.Connection;
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
public class CustomerMapper {

    public static void createCustomer(Customer customer) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO Carport.Customer (name, phone, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            customer.setCustomer_id(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Customer login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM Carport.Customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("name");
                int phone = rs.getInt("phone");
                boolean admin = rs.getBoolean("admin");

                Customer customer = new Customer(id, name, phone, email, password, admin);
                customer.setCustomer_id(id);
                return customer;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<Customer> getAllCustomers(int customer_id) throws LoginSampleException {
        List<Customer> list;
        try {
            list = new ArrayList<>();
            Connection con = DBConnector.connection();

            String SQL = "SELECT customer_id, name, phone, email, password, admin "
                    + "FROM Carport.Customer "
                    + "WHERE admin=0 AND password IS NOT NULL "
                    + "ORDER BY customer_id DESC";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("name");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");                
                boolean admin = rs.getBoolean("admin");

                list.add(new Customer(id, name, phone, email, password, admin));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return list;
    }

}
