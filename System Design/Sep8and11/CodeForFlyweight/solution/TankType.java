package CodeForFlyweight.solution;

import java.awt.Image;

public class TankType {
	String typeName;
	int power;
	int origHealth;
	Image img;
	
	public TankType(String typeName, int power, int origHealth, Image img) {
		this.typeName = typeName;
		this.power = power;
		this.origHealth = origHealth;
		this.img = img;
	}
}	
