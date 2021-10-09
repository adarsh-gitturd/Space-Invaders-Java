package com.wilson.adarsh.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.wilson.adarsh.entities.Bullet;
import com.wilson.adarsh.main.Game;

public class KeyInput implements KeyListener{
	private Game game;
	
	public KeyInput(Game game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			game.getPlayer().setXVel(-6);
		}
		if(code == KeyEvent.VK_RIGHT){
			game.getPlayer().setXVel(6);
		}
		if(code == KeyEvent.VK_UP){
			game.getPlayer().setYVel(-6);
		}
		if(code == KeyEvent.VK_DOWN){
			game.getPlayer().setYVel(6);
		}
		if(code == KeyEvent.VK_SPACE){
			Bullet bullet = new Bullet(game, game.getPlayer().getX() + 19, game.getPlayer().getY() - 13);
			game.getController().addBullet(bullet);
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			game.getPlayer().setXVel(0);
		}
		if(code == KeyEvent.VK_RIGHT){
			game.getPlayer().setXVel(0);
		}
		if(code == KeyEvent.VK_UP){
			game.getPlayer().setYVel(0);
		}
		if(code == KeyEvent.VK_DOWN){
			game.getPlayer().setYVel(0);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}


}
