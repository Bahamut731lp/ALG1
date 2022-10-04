package danek;

import java.util.Scanner;

public class PocetVyskytuMaxima {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Zadavej cisla, ukonci 0 nebo zaporny ");
		
		float x; 
		float max = Float.NEGATIVE_INFINITY;
		int maxCounter = 0;
		
		while ((x = sc.nextFloat()) > 0) {
			
			if (x == max) maxCounter++;
			
			if (x > max) {
				max = x;
				maxCounter = 1;
			};
			
			
			
		}
		
		System.out.printf("Zadaná posloupnost má maximum v bodě %s a vyskytuje se celkem %skrát", max, maxCounter);
	}
}
