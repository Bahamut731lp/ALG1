package cv11.danek;

import java.util.Arrays;

public class MatrixTools {
	public static double[][] soucetMatic(double[][] a, double[][] b) {
		
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		}
		
		
		int pr = a.length;
		int ps = a[0].length;
		
		double[][] c = new double[pr][ps];
		
		for (int i = 0; i < pr; i++) {
			for (int j = 0; j < ps; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return c;
		
	}
	
	public static double[][] soucinMatic(double[][] a, double[][] b) {
		if (a[0].length != b.length) {
			return null;
		}
		
		
		int pr = a.length;
		int ps = b[0].length;
		
		double[][] c = new double[pr][ps];
		
		for (int i = 0; i < pr; i++) {
			for (int j = 0; j < ps; j++) {
				c[i][j] = 0;
				
				for (int k = 0; k <= pr; k++) {
					c[i][j] += a[i][k] * b[k][j]; 
				}
			}
		}
		
		return c;	
	}
	
	public static double[][] normalizovanyTvar(double[][] a) {
		double maximum = Double.NEGATIVE_INFINITY;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				maximum = a[i][j] > maximum ? a[i][j] : maximum;
			}
		}
		
		double[][] normalizovanaMatice = a;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				normalizovanaMatice[i][j] = a[i][j] / Math.abs(maximum);
			}
		}
		
		return normalizovanaMatice;
	}
	
	public static boolean jeSymetricka(double[][] a) {
		if (a.length != a[0].length) return false;
		
		boolean jeSymetricka = true;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != a[j][i]) {
					jeSymetricka = false;
					break;
				}
			}
		}
		
		return jeSymetricka;
	}

	public static boolean jsouSouctyStejne(double[][] a) {
		if (a.length != a[0].length) return false;
		
		double[] souctyRadku = new double[a.length];
		double[] souctySloupcu = new double[a[0].length];
		double soucetHlavniDiagonaly = 0;
		double soucetVedlejsiDiagonaly = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				souctyRadku[i] += a[i][j];
				souctySloupcu[i] += a[j][i];
			}
			
			soucetHlavniDiagonaly += a[i][i];
			soucetVedlejsiDiagonaly += a[a.length - 1 - i][a.length - 1 - i];
		}
		
		boolean jsouSouctyDimenziStejne = Arrays.equals(souctyRadku, souctySloupcu);
		boolean jsouSouctyDiagonalStejne = soucetHlavniDiagonaly == soucetVedlejsiDiagonaly;
		
		return (jsouSouctyDiagonalStejne && jsouSouctyDimenziStejne);
	}
}
