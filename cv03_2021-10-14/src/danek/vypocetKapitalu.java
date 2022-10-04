package danek;

import java.util.Scanner;

public class vypocetKapitalu {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Počáteční kapitál: ");
		float K = reader.nextFloat();
		
		System.out.print("Úrok: ");
		float U = reader.nextFloat();

		System.out.print("Zúročení za rok: ");
		float M = reader.nextFloat();
		
		System.out.print("Počet let: ");
		float N = reader.nextFloat();
		
		System.out.printf("Ze vstupního kapitálu %s při úroku %s bude zhodnocen za %s roky na hodnotu %s", K, U, N, calculate(K, U, M, N));
	}
	
	/**
	 * Funkce vypočte výslednou hodnotu kapitálu
	 * @param InitCapital Počáteční kapitál
	 * @param Interest	Úrok (v desetinném tvaru - např. 0.2 je 20%)
	 * @param IncrementPerYear Kolikrát za rok se kapitál zúročí
	 * @param Years Jak dlouho se má kapitál úročit
	 * @return Zúročený kapitál
	 */
	public static double calculate(float InitCapital, float Interest, float IncrementPerYear, float Years) {
		return InitCapital * Math.pow(1 + (Interest/IncrementPerYear), Years * IncrementPerYear);
	}
		
}
