package CodeForBuilder;

public class VegLunchBuilder extends MealBuilder {
	private Meal meal = new Meal();
	
	public void reset() {
		meal = new Meal();
	}
	@Override
	public void addBurger() {
		// TODO Auto-generated method stub
		meal.burger = "Cheese Veg Burger";
	}

	@Override
	public void addSweet() {
		// TODO Auto-generated method stub
		meal.sweet = "Vanilla Icecream";
	}

	@Override
	public void addDrink() {
		// TODO Auto-generated method stub
		meal.drink = "Diet Coke";
	}

	@Override
	public void addFries() {
		// TODO Auto-generated method stub
		meal.fries = "small";
	}

	
	
}
