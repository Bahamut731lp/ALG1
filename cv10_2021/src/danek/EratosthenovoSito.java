package cv10.danek;

import java.util.Arrays;

public class EratosthenovoSito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean[] najdiPrvocisla(int k) {
		boolean[] cisla = new boolean[k];
		Arrays.fill(cisla, Boolean.TRUE);
		
		for (int i = 2; i < cisla.length; i++) {
			boolean cislo = cisla[i];
			
			if (!cislo) continue;
			
			for (int j = 2 * 1; j < k; j += i) {
				cisla[j] = false;
			}
		}
		
		return cisla;
	}

}
