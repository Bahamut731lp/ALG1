package cv10.danek;

import java.util.Random;

public class NahodnaPermutace {
	public static int[] vytvorNahodnouPermutaci(int n) {
		
		Random rand = new Random();
		int[] poleCisel = new int[n];
		
		for (int i = 0; i < n; i++) {
			poleCisel[i] = i;
		}
		
		for (int i = n - 1; i > 0; i--) {
			int novyIndex = rand.nextInt(i + 1);
			int docasnaPromenna = poleCisel[i];
			poleCisel[i] = poleCisel[novyIndex];
			poleCisel[novyIndex] = docasnaPromenna;
		}
		
		return poleCisel;
	}
}
