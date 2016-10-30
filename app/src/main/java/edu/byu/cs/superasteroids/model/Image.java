package edu.byu.cs.superasteroids.model;

/**
 * The Image class contains that information pertinent to drawing something on screen.
 * @author Scott Leland Crossen
 */
public class Image {
/*
FIELDS
 */
    /**
     * The path to the image is stored as a string
     */
    private String path=new String();
    /**
     * The width of the image is stored as an integer
     */
    private int image_width=0;
    /**
     * The height of the image is also stored as an integer
     */
    private int image_height=0;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the image class
     * @param path         the path to the image
     * @param image_width  the width of the image
     * @param image_height the height of the image
     */
    public Image(String path, int image_width, int image_height){}
    /**
     * The null constructor for the image class.
     */
    public Image(){}
/*
METHODS
 */
    public void setContentID(int content_id){

    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the image path
     * @return  the image path
     */
    public String getPath() {
        return path;
    }
    /**
     * The getter of the image width
     * @return  the image width
     */
    public int getImage_width() {
        return image_width;
    }
    /**
     * The getter of the image height
     * @return  the image height
     */
    public int getImage_height() {
        return image_height;
    }
}
