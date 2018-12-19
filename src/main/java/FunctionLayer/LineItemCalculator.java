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
public class LineItemCalculator {
    private int length; 
    private int width; 

    public LineItemCalculator(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getCalculatePosts() {
        int postCountLength = length - 120;
        int postCountWidth = width - 35 - 35;

        int noOfPosts = 0;
        int rowPostsCount = 2;
        int numOfRows = 2;

        if (length > 300) {
            rowPostsCount = (postCountLength / 300) + 1;
        }

        if (width > 600) {
            numOfRows = (postCountWidth / 300) + 1;
        }
        noOfPosts = rowPostsCount * numOfRows;

        return noOfPosts;
    }

    public int getCalculateRafter() {
        int postCountWidth = width - 35 - 35;
        int noOfRafter = 2;

        if (width > 600) {
            noOfRafter = (postCountWidth / 300) + 1;
        }

        return noOfRafter;
    }
}
