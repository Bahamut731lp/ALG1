package danek;

import java.util.Scanner;

public class TestPrvocisla {

	static Scanner rd = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Zadejte přirozené číslo ke kontrole prvočíselnosti: ");
		int vstup = rd.nextInt();
		
		boolean jePrvocislo = isPrime(vstup);
		
		System.out.printf("Číslo %s %s prvočíslo.", vstup, jePrvocislo ? "je" : "není");
	}
	
	public static boolean isPrime(int number) {	
		if (number <= 1) return false;
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) return false;
		}
		
		return true;
	}
}
