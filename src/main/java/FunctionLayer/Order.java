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
public class Order {
    
    private int id;
    private int userId;
    private int length;
    private int width;
    private int height;
    private boolean shipped;

    // When the user creates order.
    public Order(int userId, int length, int width, int height) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }
     
    // When reading order from database.
    public Order(int id, int userId, int length, int width, int height, boolean shipped) {
        this.id = id;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shipped = shipped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }    
}
