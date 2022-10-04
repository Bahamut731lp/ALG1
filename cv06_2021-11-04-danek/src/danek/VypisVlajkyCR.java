package danek;

import java.util.Scanner;

public class VypisVlajkyCR {
	
	static Scanner rd = new Scanner(System.in);
		
	public static void main(String[] args) {
		System.out.print("Zadejte počet počet řádků (výšku) vlajky: ");
		int pocetRadku = rd.nextInt();
		
		System.out.print("Zadejte počet počet sloupců (délku) vlajky: ");
		int pocetSloupcu = rd.nextInt();
		
		int polovina = (pocetRadku / 2) + pocetRadku % 2;
		int trgCounter = 0;
		
		String modra = "*";
		String cervena = "o";
		String bila = "-";

		for (int radek = 0; radek < pocetRadku; radek++) {
			
			String barvaPoloviny = radek >= polovina ? cervena : bila;			
			trgCounter = (
				radek >= (polovina) ? (
					(radek == polovina && pocetRadku % 2 == 0) ? trgCounter : trgCounter - 1
				) : trgCounter + 1
			);
			
			for (int sloupec = 0; sloupec < pocetSloupcu; sloupec++) {				 
				String symbol = sloupec < trgCounter ? modra : barvaPoloviny; 
				System.out.printf(" %s ", symbol);
			}
			
			System.out.println();
		}
	}
}
