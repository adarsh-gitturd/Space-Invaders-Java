package com.wilson.adarsh.entities;

import java.awt.Graphics;

import com.wilson.adarsh.graphics.Assets;
import com.wilson.adarsh.main.Game;
import com.wilson.adarsh.managers.Entity;

public class Player extends Entity{
	
	public Player(Game game, float x, float y) {
		super(game,Assets.player, x, y, 50, 50);
	}

	public void update() {
		x += xVel;
		y += yVel;
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
	
	public void setXVel(float xVel){
		this.xVel = xVel;
	}
	
	public void setYVel(float yVel){
		this.yVel = yVel;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
}
