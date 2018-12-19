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
public class LineItem {

    private int order_id;
    private int product_id;
    private int amount;
    private String name;
    private int length;
    private String unit;
    private String description;

    public LineItem(int order_id, int product_id, int amount, String name, int length, String unit, String description) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.description = description;
    }

    public LineItem( int order_id, int product_id, String name) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.name = name;
    }    
    
    public LineItem( int order_id, int product_id, int amount) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
