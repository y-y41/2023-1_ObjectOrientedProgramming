package lab02;

import java.util.Scanner;

public class Lab02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		String[] arr1 = input.split(" ");
		
		System.out.println("Name Length(Korean) : "+(arr1.length-1));
		
				
		System.out.println(arr1[0].substring(0,1).toUpperCase()
				+ "." + arr1[1].substring(0,1).toUpperCase()
				+ "." + arr1[2].substring(0,1).toUpperCase()
				+ arr1[2].substring(1,arr1[2].length()-1) + " submitted "
				+ arr1[3].substring(0,1).toUpperCase()
				+ arr1[3].substring(1,arr1[3].indexOf(".")) + ".pdf");
	}

}
