package edu.byu.cs.superasteroids.model;

/**
 * This is the background image of the game
 * @author Scott Leland Crossen
 */
public class Space extends PositionedObject{
    /**
     * The constructor of the background image.
     */
    Space(){
        super(new Image(), null);
    }
    @Override
    public void draw(){}
}
