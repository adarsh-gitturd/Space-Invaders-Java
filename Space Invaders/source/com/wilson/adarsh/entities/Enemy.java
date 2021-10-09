package com.wilson.adarsh.entities;

import java.awt.Graphics;

import com.wilson.adarsh.graphics.Assets;
import com.wilson.adarsh.main.Game;
import com.wilson.adarsh.managers.Entity;

public class Enemy extends Entity{
	
	public Enemy(Game game,float x, float y) {
		super(game, Assets.enemy, x, y, 50, 50);
	}

	public void update() {
		y += game.getEnemyCount() * 0.3;
		if(y > Game.HEIGHT){
			 y = 0;
		}
//		if(game.getController().getBullet() != null){
//			if(game.getController().getBullet().getBounds().intersects(getBounds())){
//				game.getController().removeBullet(game.getController().getBullet());
//				game.getEnemySpawner().removeEnemy(this);
//				game.setEnemyKilled(game.getEnemyKilled() + 1);
//				if(game.getEnemyKilled() == game.getEnemyCount()){
//					game.setEnemyCount(game.getEnemyCount() + 1);
//					game.getEnemySpawner().createEnemy(game.getEnemyCount());
//					game.setEnemyKilled(0);
//				}	
//			}			
//		}
	}
	
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, width, height, null);
	}

}
