package lab10;

public class Program {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();

		Animal[] animals = { dog, tiger, turtle };

		Person person = new Person() {
			private int hp = 100;

			public void control(Animal a) {
				if (a instanceof Tiger)
					hp -= 80;
				else if (a instanceof Dog)
					hp -= 10;
				System.out.println("You have overpowered the " + a.getName());
			}

			public void showInfo() {
				System.out.println("Person HP: " + hp);
			}
		};
		showResult(animals, person);
	}

	private static void showResult(Animal[] animals, Person person) {
		for (int i = 0; i < animals.length; i++) {
			System.out.println("Animal: " + animals[i].getName());
			if (animals[i] instanceof Barkable) {
				System.out.println("Animal barked " + ((Barkable) animals[i]).bark());
			}
			person.control(animals[i]);
			person.showInfo();
		}
	}
}
