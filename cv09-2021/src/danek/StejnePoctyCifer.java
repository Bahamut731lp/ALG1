package cv09.danek;

import java.util.Arrays;
import java.util.Scanner;

public class StejnePoctyCifer {

	static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Zadávej dvojice reálných čísel: ");
		
		long x, y;
		
		while ((x = rd.nextLong()) > 0) {
			y = rd.nextLong();
			
			if (y <= 0) {
				System.out.println("Druhá hodnota musí být nekladná");
				continue;
			}
			
			boolean rovnajiSe = porovnaniPole(poctyCifer(x), poctyCifer(y));
			System.out.printf("Čísla %s a %s %smají stejný počet cifer%n", x, y, rovnajiSe ? "" : "ne");			
		}
	}

	/**
	 * Vrátí pole s počty cifer v čísle.
	 * @apiNote Indexování je od 0, tedy první položka je 0, druhá 1, třetí 2 atd...
	 * @param n Číslo, ve kterém se spočítají výskyty cifer
	 * @return Pole výskytů jednotlivých cifer
	 */
	public static long[] poctyCifer(long n) {
		long[] pocetCifer = new long[10];
		
		int pocetCislic = (int)(Math.log10((double) n) + 1);
		
		for (int i = 0; i < pocetCislic; i++) {
			int cislice = (int)((n / Math.pow(10, i))) % 10;
			
			pocetCifer[cislice] += 1;
		}

		return pocetCifer;
	}
	
	public static boolean porovnaniPole(long[] a, long[] b) {
		for (int i = 0; i < 10; i++) {
			if (a[i] != b[i]) return false;	
		}
		
		return true;
	}
	

}
