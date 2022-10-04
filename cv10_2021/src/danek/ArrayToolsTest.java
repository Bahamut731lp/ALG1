package cv10.danek;

import java.util.Arrays;

public class ArrayToolsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] pole = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		double[] pole2 = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println(ArrayTools.soucet(pole2));
		System.out.println(ArrayTools.soucet(pole2, 2));
		
		System.out.println(ArrayTools.maximum(pole));
		System.out.println(Arrays.toString(ArrayTools.vyskytMaxima(pole)));
		System.out.println(ArrayTools.prvniVyskytMaxima(pole));
		System.out.println(ArrayTools.posledniVyskytMaxima(pole));
		System.out.println(ArrayTools.pocetVyskytu(pole, pole.length, 5));
		System.out.println(ArrayTools.jeVzestupneUsporadana(pole2, 5));
		System.out.println(ArrayTools.jeStridavaPosloupnost(pole2));
		System.out.println(Arrays.toString(ArrayTools.getReversed(pole)));
		
		System.out.println(Arrays.toString(EratosthenovoSito.najdiPrvocisla(10)));
		System.out.println(Arrays.toString(NahodnaPermutace.vytvorNahodnouPermutaci(5)));
	}
}
