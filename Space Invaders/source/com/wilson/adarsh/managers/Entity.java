package com.wilson.adarsh.managers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.wilson.adarsh.main.Game;

public abstract class Entity {
	protected float x;
	protected float y;
	
	protected int width;
	protected int height;
	
	protected float xVel;
	protected float yVel;
	
	protected BufferedImage image;
	protected Game game;
	
	protected abstract void update();
	protected abstract void render(Graphics g);
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, width, height);
	}

	protected Entity(Game game, BufferedImage image, float x, float y, int width, int height){
		this.game = game;
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		xVel = 0;
		yVel = 0;
	}
}
