package com.wilson.adarsh.main;

import com.wilson.adarsh.managers.Entity;

public class Collision {
	public static boolean isTouching(Entity a, Entity b){
		if(a.getBounds().intersects(b.getBounds())){
			return true;
		}else{
			return false;
		}
	}
}
