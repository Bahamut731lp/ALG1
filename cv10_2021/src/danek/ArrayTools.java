package cv10.danek;

import java.util.ArrayList;

public class ArrayTools {
	/**
	 * Sečte pole reálných čísel
	 * @param pole Pole reálných čísel
	 * @return Součet hodnot
	 */
	public static double soucet(double[] pole) {
		double soucet = 0;
		
		for (double prvek : pole) {
			soucet += prvek;
		}
		
		return soucet;
	}
	
	/**
	 * 
	 * @see ArrayTools#soucet
	 * @param pole Pole reálných čísel
	 * @param limit Počet prvků, které má pole sečíst
	 * @return
	 */
	public static double soucet(double[] pole, int limit) {
		double soucet = 0;
		
		for (int i = 0; i < Math.min(limit, pole.length -1); i++) {
			soucet += pole[i];
		}
		
		return soucet;
	}
	
	/**
	 * Zjistí maximum celočíselného pole
	 * @param pole Pole celých čísel
	 * @return Maximum
	 */
	public static int maximum(int[] pole) {
		int max = pole[0];
		
		for (int i : pole) {
			if (max < i) max = i;
		}
		
		return max;
	}
	
	/**
	 * Zjistí, na jakých pozicích se nachází maximum pole
	 * @param pole Pole celých čísel
	 * @return Pole indexů pozic s výskytem maxima ve výchozím poli
	 */
	public static int[] vyskytMaxima(int[] pole) {
		//Vzhledem k tomu, že nevím, kolik maximálních hodnot tam můžu najít, používám datovou strukturu s dynamickou velikostí
		ArrayList<Integer> vyskyty = new ArrayList<Integer>();
		int poleMax = maximum(pole);
		
		for (int i = 0; i < pole.length; i++) {
			if (pole[i] == poleMax) vyskyty.add(i);
		}
		
		//Převedení na pole primitiv
		int[] poleVyskytu = new int[vyskyty.size()];
		
		for (int i = 0; i < poleVyskytu.length; i++) {
			poleVyskytu[i] = vyskyty.get(i);
		}
		
		//Vrácení pole s indexy výskytů maxima
		return pole;
	}
	
	/**
	 * @see ArrayTools#vyskytMaxima
	 * @param pole Pole celých čísel
	 * @return Pozice prvního výskytu maxima
	 */
	public static int prvniVyskytMaxima(int[] pole) {
		int[] vyskyty = vyskytMaxima(pole);
		
		return vyskyty[0];
	}

	/**
	 * @see ArrayTools#vyskytMaxima
	 * @param pole Pole celých čísel
	 * @return Pozice posledního výskytu maxima
	 */
	public static int posledniVyskytMaxima(int[] pole) {
		int[] vyskyty = vyskytMaxima(pole);
		
		return vyskyty[vyskyty.length - 1];
	}
	
	/**
	 * Zjistí počet výskytů čísla ve výchozím poli
	 * @param pole Pole celých čísel
	 * @param limit Číslo určující pozici, do které bude probíhat kontrola výskytu
	 * @param cislo Hledané číslo
	 * @return Počet výskytů
	 */
	public static int pocetVyskytu(int[] pole, int limit, int cislo) {
		int vyskyt = 0;
		
		for (int i = 0; i < Math.min(limit, pole.length -1); i++) {
			if (pole[i] == cislo) vyskyt++;
		}
		
		return vyskyt;
	}
	
	
	public static boolean jeVzestupneUsporadana(double[] pole, int limit) {
		boolean jeUsporadana = true;
		
		for (int i = 0; i < Math.min(limit, pole.length - 1); i++) {
			
			double prvek = pole[i];
			double dalsiPrvek = (i + 1 >= pole.length) ? pole[i + 1] : pole[i] + 1;
			
			if ( prvek > dalsiPrvek ) {
				jeUsporadana = false;
				break;
			}
		}
		
		return jeUsporadana;
	}
	
	public static boolean jeStridavaPosloupnost(double[] pole) {
		boolean jeStridava = true;
		boolean znamenko = true; //true => +, false => -
		
		for (int i = 0; i < pole.length; i++) {
			//Pokud je prvek 0, automaticky je porušeno pravidlo o střídání znamének
			if (pole[i] == 0) {
				jeStridava = false;
				break;
			}
			
			boolean znamenkoPrvku = pole[i] > 0;
			
			//Nastavení počátečního znaménka podle prvního prvku	
			if (i == 0) {
				znamenko = znamenkoPrvku;
				continue;
			}
			
			jeStridava = jeStridava && (znamenko != znamenkoPrvku);
		}
		
		return jeStridava;
	}
	
	public static void reverse(int[] pole) {
		for (int i = 0; i < pole.length / 2; i++) {
			int temp = pole[pole.length - 1 - i];
			pole[pole.length - 1 - i] = pole[i];
			pole[i] = temp;
		}
	}
	
	public static int[] getReversed(int[] pole) {
		int[] novePole = pole;

		reverse(novePole);		
		return novePole;
	}
}
