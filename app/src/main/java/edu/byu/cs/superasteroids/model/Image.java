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
    private String path;
    /**
     * The width of the image is stored as an integer
     */
    private int image_width;
    /**
     * The height of the image is also stored as an integer
     */
    private int image_height;
    private int content_id;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the image class
     * @param _path         the path to the image
     * @param _image_width  the width of the image
     * @param _image_height the height of the image
     */
    public Image(String _path, int _image_width, int _image_height){
        path = _path;
        image_width = _image_width;
        image_height = _image_height;
    }
    /*
    METHODS
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        else if (this == other) {
            return true;
        }
        else if (getClass() != other.getClass()) {
            return false;
        }
        else {
            Image other_image = (Image)other;

            if (!(getPath().equals(other_image.getPath()))) {
                return false;
            }
            else if (getWidth() != other_image.getWidth()) {
                return false;
            }
            else if (getHeight() != other_image.getHeight()) {
                return false;
            }
            else {
                return true;
            }
        }
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    public int getContentID()
{
    return content_id;
}
    public void setContentID(int id)
    {
        content_id = id;
    }
    /**
     * The getter for the image path
     * @return  the image path
     */
    public String getPath() {return path;}
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * The getter of the image width
     * @return  the image width
     */
    public int getWidth() {return image_width;}
    public void setWidth(int image_width) {
        this.image_width = image_width;
    }
    /**
     * The getter of the image height
     * @return  the image height
     */
    public int getHeight() {
        return image_height;
    }
    public void setHeight(int image_height) {
        this.image_height = image_height;
    }
}