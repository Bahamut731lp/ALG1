package cv09.danek;

import java.util.Arrays;
import java.util.Scanner;

public class VypocetKvadratickéOdchylky {

	static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pocetMereni = rd.nextInt();
		double[] namereneHodnoty = new double[pocetMereni];
		
		for (int i = 0; i < pocetMereni; i++) {
			namereneHodnoty[i] = rd.nextDouble();
		}
		
		double aritmetickyPrumer = 0;
		double maximalniOdchylka = 0;
		double kvadratickaOdchylka = 0;
		
		//Ekvivaletní zápis
		//double aritmetickyPrumer = Arrays.stream(namereneHodnoty).reduce(0, Double::sum) / pocetMereni;
		for (double prvek : namereneHodnoty) {
			aritmetickyPrumer += prvek;
		}
		
		aritmetickyPrumer /= pocetMereni;
		
		//Ekvivalentní zápis
		//double maximalniOdchylka = Arrays.stream(namereneHodnoty).reduce(0, (nejvetsiOdchylka, prvek) -> Math.abs(aritmetickyPrumer - prvek) > nejvetsiOdchylka ? Math.abs(aritmetickyPrumer - prvek) : nejvetsiOdchylka);
		for (double prvek : namereneHodnoty) {
			double odchylka = Math.abs(aritmetickyPrumer - prvek);
			if (odchylka > maximalniOdchylka) maximalniOdchylka = odchylka;
		}
		
		//Ekvivalentní zápis
		//double kvadratickaOdchylka = Arrays.stream(namereneHodnoty).reduce(0, (akumulaceOdchylky, prvek) -> (long) Math.pow((prvek - aritmetickyPrumer), 2)) / pocetMereni;
		for (double prvek : namereneHodnoty) {
			kvadratickaOdchylka = Math.pow((prvek - aritmetickyPrumer), 2);
		}
		
		kvadratickaOdchylka /= 2;
		
		System.out.printf("Počet měření: %s%nAritmetický průměr: %s%nMaximální odchylka: %s%nKvadratická odchylka: %s%n", pocetMereni, aritmetickyPrumer, maximalniOdchylka, kvadratickaOdchylka);
	}

}
