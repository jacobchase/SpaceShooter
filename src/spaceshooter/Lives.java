package spaceshooter;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class Lives extends Sprite{
	static Picture Lives;
public Lives(SpriteComponent sc) {
	super(sc);
	Lives=new Picture("Lives.png");
	setPicture(Lives);
}
public void removeLifeIcon() {
	setX(-300);
	setY(-300);
}
public void addLifeOneIcon() {
	setX(0);
	setY(0);
}
public void addLifeTwoIcon() {
	setX(50);
	setY(0);
}
public void addLifeThreeIcon() {
	setX(100);
	setY(0);
}
}
