package CodeForBuilder;

public abstract class MealBuilder {
	protected Meal meal = new Meal();
	
	public void reset() {
		meal = new Meal();
	}
	
	public abstract void addBurger();
	public abstract void addSweet();
	public abstract void addDrink();
	public abstract void addFries();
	
	public Meal getMeal() {
		// TODO Auto-generated method stub
		return meal;
	}
}
