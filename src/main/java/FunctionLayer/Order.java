/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.sql.Date;

/**
 *
 * @author Henrik
 */
public class Order {

    private int order_id;
    private int customer_id;
    private Date date;
    private String comment;
    private int length;
    private int width;
    private int height;

    
    public Order(int order_id, int length, int height){
        this.order_id = order_id;
        this.length = length;
        this.height = height;
    }

    
//    public Order(int length, int width) {
//        this.length = length;
//        this.width = width;
//    }
    
    public Order(int order_id, int customer_id, Date date, String comment, int length, int width, int height) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.comment = comment;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
