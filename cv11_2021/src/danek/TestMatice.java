package cv11.danek;

import java.util.Scanner;

public class TestMatice {
	static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		double[][] a = nactiMatici();	
		
		vypisMatici("Matice A", a);
		
		double[][] normalA = MatrixTools.normalizovanyTvar(a);
		vypisMatici("Normalizovaný tvar matice A", normalA);
		
		boolean jeMaticeSymetricka = MatrixTools.jeSymetricka(a);
		System.out.printf("Matice %s symetrická.\n", jeMaticeSymetricka ? "je" : "není");
		
		boolean jsouSouctyStejne = MatrixTools.jsouSouctyStejne(a);
		System.out.printf("Matice %smá stejné součty.\n", jsouSouctyStejne ? "" : "ne");
	}
	
	private static double[][] nactiMatici() {
		System.out.println("Zadej velikost matice");
		
		int pr = rd.nextInt();
		int ps = rd.nextInt();
		
		double[][] a = new double[pr][ps];
		System.out.println("Zadej prvky matice po radcich");
		
		for (int i = 0; i < pr; i++) {
			for (int j = 0; j < ps; j++) {
				a[i][j] = rd.nextDouble();
			}
		}
		
		return a;
	}
	
	private static void vypisMatici(String label, double[][] matice) {
		System.out.println(label);
		
		for (int i = 0; i < matice.length; i++) {
			for (int j = 0; j < matice[i].length; j++) {
				System.out.printf("%s ", matice[i][j]);
			}
			System.out.println();
		}
	}

}
