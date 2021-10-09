package com.wilson.adarsh.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.wilson.adarsh.entities.Player;
import com.wilson.adarsh.graphics.TextRenderer;
import com.wilson.adarsh.managers.Controller;
import com.wilson.adarsh.managers.EnemySpawner;
import com.wilson.adarsh.managers.KeyInput;

public class Game extends Canvas implements Runnable{
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	private Player player;
	private Background background;
	private TextRenderer text;
	
	private KeyInput keyInput;
	private Controller controller;
	private EnemySpawner enemySpawner;
	
	int enemy_count = 1;
	public int enemy_killed = 0;
	
	private int score = 0;

	public Game(){
		Dimension size = new Dimension(WIDTH,HEIGHT); 
		super.setPreferredSize(size);
		frame = new JFrame();
		
		text = new TextRenderer();
		background = new Background(this,0,0);
		player = new Player(this,WIDTH/2 - 25,500);
		
		keyInput = new KeyInput(this);
		controller = new Controller(this);
		enemySpawner = new EnemySpawner(this);
		
		super.addKeyListener(keyInput);
		
		enemySpawner.createEnemies(5);
	}
	
	private void update() {
		background.update();
		player.update();
		controller.update();
		enemySpawner.update();
		checkCollision();
	}	

	private void render() {
		BufferStrategy bs = super.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		background.render(g);
		player.render(g);
		controller.render(g);
		enemySpawner.render(g);
		
		text.render(g, "Score : " + score, WIDTH/2 - 100, 100);
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	
	public synchronized  void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while(running == true){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(updates + " updates, " + frames + " frames");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public KeyInput getKeyInput(){
		return keyInput;
	}

	public Controller getController() {
		return controller;
	}
	
	public int getEnemyCount(){
		return enemy_count;
	}
	
	public EnemySpawner getEnemySpawner(){
		return enemySpawner;
	}
	
	public int getEnemyKilled(){
		return enemy_killed;
	}

	public void setEnemyCount(int i) {
		enemy_count = i;
	}
	
	public void setEnemyKilled(int i){
		enemy_killed = i;
	}
	
	private void checkCollision(){
		for(int i = 0; i < enemySpawner.getEnemies().size(); i++){
			if(controller.getBullet() != null){
				for(int j = 0; j < controller.getBullets().size(); j++){
					if(controller.getBullets().get(j).getBounds() != null)
						if(enemySpawner.getEnemies().get(i).getBounds() != null)
							if(i != enemySpawner.getEnemies().size() - 1)
								if(enemySpawner.getEnemies().get(i).getBounds().intersects(controller.getBullets().get(j).getBounds())){
									score++;
									controller.removeBullet(controller.getBullets().get(j));
									if(enemySpawner.getEnemies().get(i) != null){
										enemySpawner.getEnemies().remove(i);
									}
									enemy_killed++;
									if(enemy_killed == enemy_count){
										enemy_count++;
										enemySpawner.createEnemies(enemy_count);
										enemy_killed = 0;
									}	
								}
				}
			}	
		}
	}
}
