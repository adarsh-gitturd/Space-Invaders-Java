package com.wilson.adarsh.entities;

import java.awt.Graphics;

import com.wilson.adarsh.graphics.Assets;
import com.wilson.adarsh.main.Game;
import com.wilson.adarsh.managers.Entity;

public class Bullet extends Entity {

	public Bullet(Game game, float x, float y) {
		super(game, Assets.bullet, x, y, 10, 20);
	}

	public void update() {
		y -= 10;
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}

	public float getY() {
		return y;
	}

}
