package lab11;

public class Gangwon extends Hub {
	public static int init_num = 20000;
	public static String init_area = "Gangwon";
	public static double init_price_per_box = 4000;

	public Gangwon(String description) {
		super(++init_num, init_area, description, init_price_per_box);
	}
}
