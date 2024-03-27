package lab04;

public class CityTest {
	public static void main(String[] args) {
		
		City c1 = new City("Seoul", 23, 45);
		City c2 = new City("Paris", 123, 41);
		City c3 = new City("Racoon City");
		City c4 = new City("Mega City");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		System.out.println("Seoul-Paris : "+City.distance(c1, c2));
		System.out.println("Seoul-Racoon City : "+City.distance(c1, c3));
		System.out.println("Paris-Mega City : "+City.distance(c2, c4));
	}
}
