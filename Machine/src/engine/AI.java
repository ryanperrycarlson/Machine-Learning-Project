package engine;

import java.awt.Color;
import java.awt.Graphics;

public class AI extends GameObject {

	public int direction;

	public AI() {

		x = 400;
		y = 300;
	}

	public void spawn()
	{
		//sets the ai to the point to where the 2 is in the map array

		x = Track.spawnTile.x;
		y = Track.spawnTile.y;

	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 30);

	}

	// runs ever tick. AI LOGIC
	public void update()
	{
		

		// keep code
		Main.track.playerIsOnTrack(this);
		//
		super.update();

	}

}
