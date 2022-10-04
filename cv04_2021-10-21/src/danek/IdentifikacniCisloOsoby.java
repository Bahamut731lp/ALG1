package danek;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;

public class IdentifikacniCisloOsoby {

	static Scanner rd = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Získání vstupu od uživatele
		System.out.print("Zadejte IČO: ");
		int ico = rd.nextInt();
		
		//Převedení celočíselného vstupu na string
		//Hodí se mi to hlavně pro změření délky vstupu (IČO nemůže být delší než 8 znaků)
		//Také pomocí toho přidávat nuly na začátek, pokud je vstup kratší než 8 znaků
		String icoString = Integer.toString(ico);
		int icoLength = icoString.length();
		
		if (icoLength > 8) throw new InputMismatchException("Zadané IČO je delší než 8 číslic");
		
		String[] icoCharArray = String.format("%08d", ico).split("");
		
		//Vytvořím si "pole" (konkrétně stream, ale nwm) od 1 do 7 (první argument je inkluzivní, druhý exkluzivní)
		//Do tohodle pole namapuji číslice ze vstupu s tím, je posloupnost od 1 do 7 použiju jako váhy
		//Nejdřív si je samozřejmě obrátím, protože váhy IČO jdou od 8 do 2.
		//EZ Aritmetika
		//Na konci si celé to "pole" sečtu a vyplivne mi to vážený součet prvních 7 čísel IČO
		int vazenySoucet = IntStream.range(1, 8)
		.map( cislice -> (9 - cislice) * Integer.parseInt(icoCharArray[cislice - 1]))
		.sum();
		
		//Zbytek po celočíselném dělení váženého součtu 11
		//Používá se pro kontrolu platnosti čísla
		int zbytek = vazenySoucet % 11;
		int kontrolniCislice = Integer.parseInt(icoCharArray[icoCharArray.length - 1]); 
		
		boolean jePlatneIco = (11 - zbytek) % 10 == kontrolniCislice;

		System.out.printf("Zadané IČO je %splatné", jePlatneIco ? "" : "ne");
		
		//Bez cyklů bych to (s)prostě rozepsal pro jednotlivé indexy číslic a vynásobil zvlášť
	}
}
