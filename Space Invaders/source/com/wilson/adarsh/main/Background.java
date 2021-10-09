package com.wilson.adarsh.main;

import java.awt.Graphics;

import com.wilson.adarsh.graphics.Assets;
import com.wilson.adarsh.managers.Entity;

public class Background extends Entity{

	public Background(Game game, float x, float y) {
		super(game, Assets.background, x, y, Game.WIDTH, Game.HEIGHT);
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, width, height, null);
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}

}
