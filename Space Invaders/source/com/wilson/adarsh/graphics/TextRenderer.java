package com.wilson.adarsh.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextRenderer{
	
	public void render(Graphics g, String a, int x, int y){
		g.setColor(Color.RED);
		Font f = new Font(a,50,50);
		g.setFont(f);
		g.drawString(a, x, y);
	}
}
