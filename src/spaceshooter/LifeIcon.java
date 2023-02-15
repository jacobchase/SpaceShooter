package spaceshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class LifeIcon extends Sprite{
	static Picture LifeIcon;
public LifeIcon(SpriteComponent sc) {
	super(sc);
	LifeIcon=new Picture("Lives.png");
	setPicture(LifeIcon);
	
}
public void ProcessEvent(SpriteCollisionEvent collision) {
	if(collision.xlo==true) {
		setActive(false);
	}
	if(collision.xhi==true) {
		setActive(false);
	}
	if(collision.ylo==true) {
		setActive(false);
	}
	if(collision.yhi==true) {
		setActive(false);
	}
}
}
