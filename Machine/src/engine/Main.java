package engine;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{
	AI player;
	private static String verson= "VER: 0.0";
	Camera c;
	public static Track track = new Track(); 
	public static void main(String[] args)
	{
		new Main();

	}

	
	public static void setVerson(String g) {

		verson = g;
		
	}
	public static int score = 34;

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.blue);
		g.fillRect(0, 0, 800, 600);
	
		g.setColor(Color.WHITE);
		g.drawString(verson, 20, 20);

		
		
		g.translate(-c.x, -c.y);
		track.render(g);


		player.render(g);
		g.translate(c.x, c.y);

		
		bs.show();

		g.dispose();

	}

	public Main() {
		JFrame frame = new JFrame("Machine Learning");
		player = new AI();
		player.spawn();
		frame.setSize(800, 600);

		frame.add(this);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		c = new Camera(this); 
	Thread t = new Thread(this);

		t.start();

	}

	public void run()
	{
		double target = 60.0;
		double nsPerTick = 1000000000.0 / target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double unprocessed = 0.0;
		int fps = 0;
		int tps = 0;

		render();
		while (true) {

			render();
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;

			if (unprocessed >= 1.0) {
				tick();
				unprocessed--;
				tps++;

			}

			fps++;

			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
				fps = 0;
				tps = 0;
			}

		}

	}

	public void tick()
	{

		c.update();
		player.update();
	}
	
	

}
