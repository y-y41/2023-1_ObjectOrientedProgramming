package lab03;

public class StaffManager {
	public static void main(String[] args) {
		
		Staff jw = new Staff("James Wright", 29, "Accounting", 365, 15);
		Staff pc = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
		Staff as = new Staff("Amy Smith", 27);
		
		System.out.print(jw.toString());
		System.out.print(pc.toString());
		System.out.print(as.toString());
		
		System.out.println("---");
		
		System.out.println("Same Career?");
		if (pc.sameCareer(as)) {
			System.out.printf("%s and %s, Same.\n", pc.getName(), as.getName());
		}
		else {
			System.out.printf("%s and %s, Not exactly same.\n", pc.getName(), as.getName());
		}
		System.out.println("...A Few years later...");
		as.setCareer("R&D", 1095);
		if (pc.sameCareer(as)) {
			System.out.printf("%s and %s, Same.\n", pc.getName(), as.getName());
		}
		else {
			System.out.printf("%s and %s, Not exactly same.\n", pc.getName(), as.getName());
		}
		
		System.out.println("---");
		
		jw.vacation(10);
		as.vacation(20);
		as.vacation(1);
	}
}
