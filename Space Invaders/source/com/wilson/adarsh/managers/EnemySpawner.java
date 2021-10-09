package com.wilson.adarsh.managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.wilson.adarsh.entities.Enemy;
import com.wilson.adarsh.main.Game;

public class EnemySpawner {
	Game game;
	private ArrayList<Enemy> enemies;
	private Enemy tempEnemy;
	
	public EnemySpawner(Game game){
		this.game = game;
		enemies = new ArrayList<Enemy>();
	}
	
	public void createEnemies(int enemy_count){
		for(int i = 0; i < enemy_count; i++){
			enemies.add(new Enemy(game,new Random().nextInt(700),0));
		}
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public void update(){
		for(int i = 0; i < enemies.size(); i++){
			tempEnemy = enemies.get(i);
			tempEnemy.update();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < enemies.size(); i++){
			tempEnemy = enemies.get(i);
			tempEnemy.render(g);
		}
	}
	
	public void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy){
		enemies.remove(enemy);
	}
}
