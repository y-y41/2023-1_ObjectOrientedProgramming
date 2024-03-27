package lab04;

import java.util.Random;

public class City {
	
	private String name;
	private int locationX;
	private int locationY;
	
	public City(String name, int x, int y) {
		this.name = name;
		locationX = x;
		locationY = y;
	}
	
	public City(String name) {
		
		this.name = name;
		
		Random rnd = new Random();
		locationX = rnd.nextInt(360);
		locationY = rnd.nextInt(360);
	}
	
	public String getName(City c) {
		return name;
	}
	
	public int getX(City c) {
		return locationX;
	}
	
	public int getY(City c) {
		return locationY;
	}
	
	public boolean equals(City c) {
		if (this.name.equals(c.name) && this.locationX == c.locationX && this.locationY == c.locationY)
			return true;
		return false;
	}
	
	public String toString() {
		return name + ", " + locationX + ", " + locationY;
	}
	
	public static double distance(City c1, City c2) {
		return Math.sqrt(Math.pow(c1.locationX-c2.locationX, 2) 
				+ Math.pow(c1.locationY-c2.locationY, 2));
	}

}
