package homework;

import java.util.Scanner;

public class SImpleConversions {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a radius: ");
		double radius = s.nextDouble();
		
		double circ = 2 * Math.PI * radius;
		
		System.out.println("The circumfrance is " + circ);
		System.out.print("Enter an integer: ");
		int x = s.nextInt();
		
		if(x%2 == 0){
			System.out.println(x + " is even.");
		}
		else {
				System.out.println(x + " is odd.");
		}
		
		
		s.close();
	}

}
