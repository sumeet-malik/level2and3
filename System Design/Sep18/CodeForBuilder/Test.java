package CodeForBuilder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Director dir = new Director();
		dir.setMealBuilder(new VegLunchBuilder());
		Meal meal = dir.construct();
		System.out.println(meal.burger);
		
		dir.setMealBuilder(new NonVegLunchBuilder());
		meal = dir.construct();
		System.out.println(meal.burger);
	}

}
