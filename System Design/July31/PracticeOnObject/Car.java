package PracticeOnObject;

public class Car {
	String name;
	int price;
	int speed;
	
	Car(String name, int price, int speed){
		this.name = name;
		this.price = price;
		this.speed = speed;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + ", " + this.price + ", " + this.speed + "]";
	}
}
