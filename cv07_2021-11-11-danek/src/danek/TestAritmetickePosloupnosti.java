package danek;

import java.util.Scanner;

public class TestAritmetickePosloupnosti {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Zadávej čísla (ukonči nulou nebo záporným číslem): ");
		
		float x;
		float lastX = Float.POSITIVE_INFINITY; //Reference na hodnotu v posloupnosti před aktuální hodnotou (a_{-1})
		float delta = Float.POSITIVE_INFINITY; //Krok aritmetické posloupnosti
		boolean isArithmetic = true; //Bool, jestli je posloupnost aritmetická. Předpokládá se, že ano.
		
		while ((x = sc.nextFloat()) > 0) {
			
			float diff = Math.abs(lastX - x);
			
			if (Float.isInfinite(lastX)) lastX = x;
			if (Float.isInfinite(delta)) delta = diff;
			
			isArithmetic = diff == delta;
			lastX = x;	
		}
		
		System.out.printf("Zadaná posloupnost %s aritmetická.", isArithmetic ? "je" : "není");
	}
}
