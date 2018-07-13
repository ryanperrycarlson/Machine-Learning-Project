package engine;

import java.awt.Rectangle;

public class GameObject {
	protected Rectangle r;
	protected int x,y;

	
	public GameObject() {
		r=  new Rectangle(0,0,30,30);
	}
	
	public void update() {
		
		r.setRect(x,y,30,30);
	}
	
	public boolean collidesWith(GameObject g) {
		return g.r.intersects(r);
		
	}
}
