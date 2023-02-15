package spaceshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class Enemy extends Sprite{
	static Picture enemy;
	public Enemy(SpriteComponent sc) {
		super(sc);
		enemy = new Picture("enemy.png");
		setPicture(enemy);
		setX((int) Math.random()*700+1);
		setY(100);
		setVelX(0);
		setVelY(1);
	}
	
	public void processEvent(SpriteCollisionEvent collision) {
		if(collision.yhi==true) {
			setActive(false);
		}
		if(collision.ylo==true) {
			setActive(false);
		}
	}
	public boolean isGameOver(SpriteCollisionEvent Collision) {
		boolean gameover=false;
		if(Collision.xlo==true)
			gameover=true;
		return gameover;
	}
}
