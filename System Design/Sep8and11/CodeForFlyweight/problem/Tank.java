package CodeForFlyweight.problem;

import java.awt.Image;

public class Tank {
	public int x;
	public int y;
	public int currHealth;
	
	// this space can be shared across types to save memory
	public int power;
	public int orgHealth;
	public Image img;
}
