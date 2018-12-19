/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Henrik
 */
public class Customer {

    private int customer_id;
    private String name;
    private int phone;
    private String email;
    private String password;
    private boolean admin;

    public Customer(String name, int phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Customer(int customer_id, String name, int phone, String email, String password, boolean admin) {
        this.customer_id = customer_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public boolean isAdmin() {
        return admin;
    }
}
