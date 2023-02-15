package spaceshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.SpriteCollisionEvent;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
public class Spaceship extends Sprite{

	public int positionX;
	public int positionY;
	BufferedImage bi;
	static Picture rocket;
	public Spaceship (SpriteComponent sc) {
		super(sc);
		rocket = new Picture("player.png");
		setPicture(rocket);
        Dimension d = sc.getSize();
        setVelX(0);
        setVelY(0);
	}
	@Override
	public void processEvent(SpriteCollisionEvent collision) {
		SpriteComponent sc = getSpriteComponent();
		 if (collision.xlo == true)
		 {
		 setX(0);
		 setVelX(0);
		 }
		 if (collision.xhi == true)
		 {
		 setVelX(0);
		 setX(sc.getSize().width-getWidth());
		 }
		 if(collision.ylo==true) {
			 setVelY(0);
		 }
		 if(collision.yhi==true) {
			 setVelY(0);
		 }
	}
}
