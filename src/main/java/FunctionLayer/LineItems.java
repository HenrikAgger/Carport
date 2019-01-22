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
public class LineItems {

    private int order_id;
    private int product_id;
    private int amount;
    private String name;
    private int plength; 
    private String unit;
    private String description;
    private int width;
    private int length;
    private int height;
    private int postsLength;
    private int postsWidth;
    private int posts;
    private int stropes;
    private int rafter;


    public LineItems(int order_id, int product_id, int amount, String name, int plength, String unit, String description, int length, int width, int height) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
        this.name = name;
        this.plength = plength;
        this.unit = unit;
        this.description = description;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public LineItems(int order_id, int product_id, int amount, String name, int plength, String unit, String description, int width, int length, int postsLength, int postsWidth, int posts, int stropes, int rafter) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
        this.name = name;
        this.plength = plength;
        this.unit = unit;
        this.description = description;
        this.width = width;
        this.length = length;
        this.postsLength = postsLength;
        this.postsWidth = postsWidth;
        this.posts = posts;
        this.stropes = stropes;
        this.rafter = rafter;
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

    public int getPlength() {
        return plength;
    }

    public void setPlength(int plength) {
        this.plength = plength;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPostsLength() {
        return postsLength;
    }

    public void setPostsLength(int postsLength) {
        this.postsLength = postsLength;
    }

    public int getPostsWidth() {
        return postsWidth;
    }

    public void setPostsWidth(int postsWidth) {
        this.postsWidth = postsWidth;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getStropes() {
        return stropes;
    }

    public void setStropes(int stropes) {
        this.stropes = stropes;
    }

    public int getRafter() {
        return rafter;
    }

    public void setRafter(int rafter) {
        this.rafter = rafter;
    }

}
