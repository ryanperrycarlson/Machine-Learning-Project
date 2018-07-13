package engine;



public class Camera {
	
	public int x,y;
	private AI p;
	private Main g;
	public Camera(Main game) {
g = game;
		p = game.player;
		x = 0;
		y= 0;
		
	}
	public void update() {
	
		

			p = g.player;

		x = p.getX() - 200;;
		y = p.getY() - 350  ;
	}
}
