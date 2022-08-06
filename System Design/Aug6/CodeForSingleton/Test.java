package CodeForSingleton;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton s1 = Singleton.getTheSingleInstance();
		Singleton s2 = Singleton.getTheSingleInstance();
		
		System.out.println(s1 == s2);
	}

}
