package CodeForBuilder;

public class NonVegLunchBuilder extends MealBuilder {

	@Override
	public void addBurger() {
		// TODO Auto-generated method stub
		meal.burger = "Chicken Burger";
	}

	@Override
	public void addSweet() {
		// TODO Auto-generated method stub
		meal.sweet = "Gulab Jamun";
	}

	@Override
	public void addDrink() {
		// TODO Auto-generated method stub
		meal.drink = "McFlurry";
	}

	@Override
	public void addFries() {
		// TODO Auto-generated method stub
		meal.fries = "King";
	}
	
}
