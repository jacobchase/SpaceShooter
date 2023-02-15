package spaceshooter;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Laser extends Sprite{
    public Laser(SpriteComponent sc) {
    	super(sc);
    	setPicture(setImage(Color.blue, 10));
    }
    
    public static Picture setImage(Color c, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(c);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }
    @Override
    public void processEvent(SpriteCollisionEvent collision) {
    	if(collision.yhi==true) {
    		setActive(false);
    	}
    	if(collision.ylo==true) {
    		setActive(false);
    	}
    	setActive(false);
    }
    }
