package com.wilson.adarsh.managers;

import java.awt.Graphics;
import java.util.ArrayList;

import com.wilson.adarsh.entities.Bullet;
import com.wilson.adarsh.main.Game;

public class Controller {
	private Bullet tempBullet;
	Game game;
	
	private ArrayList<Bullet> bullets;
	
	public Controller(Game game){
		this.game = game;
		bullets = new ArrayList<Bullet>();
	}
	
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	public void update(){
		for(int i = 0; i < bullets.size(); i++){
			tempBullet = bullets.get(i);
			if(tempBullet.getY() < 0){
				removeBullet(tempBullet);
			}
			tempBullet.update();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < bullets.size(); i++){
			tempBullet = bullets.get(i);
			tempBullet.render(g);
		}
	}
	
	public Bullet getBullet(){
		return tempBullet;
	}
	
	public void addBullet(Bullet bullet){
		bullets.add(bullet);
	}
	
	public void removeBullet(Bullet bullet){
		bullets.remove(bullet);
	}
}
