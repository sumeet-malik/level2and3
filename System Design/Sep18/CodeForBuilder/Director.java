package CodeForBuilder;

public class Director {
	private MealBuilder builder;
	
	public void setMealBuilder(MealBuilder builder) {
		this.builder = builder;
	}
	
	public Meal construct() {
		builder.reset();
		builder.addBurger();
		builder.addDrink();
		builder.addFries();
		builder.addSweet();
		return builder.getMeal();
	}
}
