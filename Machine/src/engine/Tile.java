package engine;
import java.awt.Color;
import java.awt.Graphics;
public class Tile extends GameObject {
	
	public static int x, y, value;

	public Tile(int x,int y, int value) {
		this.x =x;
		this.y =y;
		this.value = value;
	}
	public int getX(){
	    return x;
    }
    public int getY(){
	    return y;
    }
    public int getValue(){
	    return value;
    }
	public void render(Graphics g) {
	g.setColor(Color.GREEN);
	super.update();
	g.fillRect(x,y,30,30);
	
}
}
