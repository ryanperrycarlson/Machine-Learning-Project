package engine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Track {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private final int xs = 400, ys = 300;
	public static Tile spawnTile;
	private final int TRACKLENGTH = 7;
	private Random gen = new Random();
	private int currentX,currentY;

	public Track(){
	    int trackCount = 0;
	    //generate it like this
	    while(trackCount<TRACKLENGTH){
	        tiles.add(new Tile(currentX,currentY,gen.nextInt(2)));
	        currentX++;
        }
    }
	//0 = void, 1 == tile, 2= spawn tile

	private static boolean f;

	public void createTile(int x, int y,int value)
	{
		
		
		Tile t =new Tile(x, y, value);
		//need spawn system again but it should be here

        ///////PLACEHOLDER///////////
        if(value == 2)
        spawnTile = t;
	}

	public void render(Graphics g)
	{

		for (Tile t : tiles) {
			t.render(g);
		}
	}

	public boolean playerIsOnTrack(AI i)
	{
	    //calculate based off of if player is BELOW track
		for (Tile t : tiles) {
			if (t.getX()==i.getX() &&t.getY()<i.getY()){
                System.out.println("on track");
                return true;
			}

		}
		System.out.println("off track");

		return false;

	}

}
