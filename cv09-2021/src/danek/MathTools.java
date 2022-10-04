package cv09.danek;

public class MathTools {
	/**
	 * Funkce pro umocnění celého čísla na přirozeného mocnitele
	 * @param a Základ mocniny
	 * @param n Exponent
	 * @note Název by mohl naznačovat, že se zkoumá něco jako NotANumber, to je ovšem neštastná shoda jmen.
	 * @return Umocněný základ
	 */
	public static double aNaN(double a, int n) {
		double vysledek = 1;
		
		for (int i = 0; i < Math.abs(n); i++) {
			vysledek *= a;
		}
		
		return n < 0 ? (1 / vysledek) : vysledek;
	}
	
	/**
	 * Aproximace funkce sinus pomocí Taylorovy řady
	 * @param x Bod, ve kterém se zkoumá funkce sinus
	 * @param eps Přesnost výpočtu
	 * @apiNote Preferovaná přesnost výpočtu "eps" je v exponenciálním tvaru (např. 1E-10)
	 * @return Funkční hodnota funkce sinus v bodě x
	 */
	public static double sin(double x, double eps) {		
		double vysledek = 0;		
		double clenRozvoje = x;
		int i = 1; //Mocnitel
		
		while (Math.abs(clenRozvoje) > eps) {
	
			vysledek += clenRozvoje;
			clenRozvoje *= -(Math.pow(x, 2) / ((i + 1) * (i + 2)));
			i += 2;
			
		}
		
		return vysledek;
	}
	
	/**
	 * Aproximace přirozeného logaritmu pomocí Taylorovy řady
	 * @param x Bod, ve kterém se zkoumá funkční hodnota přirozeného logaritmu 
	 * @param eps Přesnost výpočtu
	 * @apiNote Preferovaná přesnots výpočtu "eps" je v exponenciálním tvaru (např. 1E-10)
	 * @return Funkční hodnota přirozeného logaritmu v bodě x
	 */
	public static double ln(double x, double eps) {
		double vysledek = 0;
		double clenRozvoje = x;
		int i = 1; //Mocnitel
		
		while (Math.abs(clenRozvoje) > eps) {
		
			vysledek += clenRozvoje;
			clenRozvoje *= Math.pow((x - 1), 2) / ((i + 1) * (x + 1));
			i += 2;
			
		}
		
		return (2 * vysledek);
	}
	
	/**
	 * Aproximace druhé odmocniny pomocí Newtonova iteračního vzorce
	 * @param x Číslo na odmocnění
	 * @param eps Přesnost výpočtu
	 * @apiNote Preferovaná přesnots výpočtu "eps" je v exponenciálním tvaru (např. 1E-10)
	 * @return Aproximace druhé odmocniny z čísla x
	 */
	public static double sqrt(double x, double eps) {
		double vysledek = x;
		double predchoziOdhad = 0;
		
		while (true) {
			predchoziOdhad = vysledek;
			vysledek = 0.5 * ((x / vysledek) + vysledek);
			
			if (Math.abs(predchoziOdhad - vysledek) < eps) break;
		}
		
		return vysledek;
	}
	
	/**
	 * Funkce iteračně vypočítá faktoriál
	 * @param n Základ faktoriálu
	 * @return Vypočtený faktoriál
	 */
	public static double factorial(int n) {
		double vysledek = 1;
		
		for (int i = 1; i <= n; i++) {
			vysledek *= i; 
		}
		
		return vysledek;
	}
}
