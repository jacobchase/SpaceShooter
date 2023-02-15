package spaceshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class Coins extends Sprite{
	static Picture coin;
public Coins(SpriteComponent sc) {
	super(sc);
	coin = new Picture("coins.png");
	setPicture(coin);
}
public void ProcessEvent(SpriteCollisionEvent collision) {
	if(collision.yhi==true) {
		setActive(false);
	}
	if(collision.ylo==true) {
		setActive(false);
	}
}
}

