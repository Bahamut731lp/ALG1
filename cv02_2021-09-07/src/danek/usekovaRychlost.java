/**
 * 
 */
package danek;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Scanner;
import java.util.Date;

/**
 * @author Kevin Daněk
 *
 */
public class usekovaRychlost {
	
	public static Scanner reader = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float maximalniRychlost = readPositiveValue("Zadejte maximální rychlost v km/h: ");
		float vzdalenost = readPositiveValue("Zadejte vzdálenost úseku (v metrech): ");
		
		Date zacatek = readTimeValues("Zadejte čas startu: ");
		Date konec = readTimeValues("Zadejte čas průjezdu cílem: ");
		
		//Pozor, jakmile se jde přes den, je to v tahu
		long sekundy = (konec.getTime() - zacatek.getTime()) / 1000;
		
		System.out.println(sekundy);
		float prumernaRychlost = vzdalenost / sekundy;
		float prekroceni = prumernaRychlost - maximalniRychlost;
				
		System.out.println();
		System.out.printf("Průměrná rychlost vozidla byla %s km/h %n", prumernaRychlost);
		System.out.printf("Vozidlo %s %n", prekroceni > 0 ? ("PŘEKROČILO maximální rychlost o " + prekroceni + " km/h") : "NEPŘEKROČILO maximální rychlost");
	}
	
	/**
	 * Funkce načte float ze Scanner bufferu a ověří, jestli je nezáporná
	 * @param message Zpráva pro uživatele
	 * @throws IllegalArgumentException Pokud je zpráva pro uživatele dlouhá 0 znaků
	 * @throws IOException Pokud zadaná hodnota byla menší nebo rovna 0
	 * @return
	 */
	public static float readPositiveValue(String message) {
		//Kontrola parametru :)
		if (message.length() == 0) throw new IllegalArgumentException("Nebyla zadaná žádná zpráva pro uživatele");
		System.out.print(message);
		
		float input;

		try {
			input = reader.nextFloat();
			
			if (input <= 0) throw new IOException("Zadaná hodnota byla menší nebo rovna 0");
			
			return input;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			
			input = 0;
			return input;
		}
	}
	
	/**
	 * Přečte časový údaj z konzole a podrobí ho testům správnosti
	 * @param message Zpráva uživateli, co má napsat
	 * @throws IllegalArgumentException Pokud parametr "message" nebyl zadán (nebo je prázdný)
	 * @throws IOException Pokud zadaná hodnota od uživatele neodpovovídá formátu hh:mm:ss
	 * @throws DateTimeException Pokud je čas větší než 23:59:59
	 * @return Date
	 */
	public static Date readTimeValues(String message) {
		//Kontrola parametrů:)
		if (message.length() == 0) throw new IllegalArgumentException("Nebyla zadaná žádná zpráva pro uživatele");
		System.out.print(message);
		
		String input;
		int[] result = new int[3];
		int[] limits = {24, 60, 60};
		String[] units = {"hodiny", "minuty", "sekundy"};
		
		try {
			input = reader.next().trim(); 
			
			if (!input.matches("\\d{2}:\\d{2}:\\d{2}")) throw new IOException("Zadaná hodnota neodpovídá formátu hh:mm:ss");
			String[] timeStrings = input.split(":");
			
			for (int i = 0; i < timeStrings.length; i++) {
				result[i] = Integer.parseInt(timeStrings[i]);
				if (result[i] >= limits[i]) throw new DateTimeException("V čase " + input + " jsou " + units[i] + " mimo povolený rozsah");
			}
			
			return new SimpleDateFormat("HH:mm:ss").parse(input);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			
			return new Date(); //Čistě jenom aby compiler/IDE nekřičel/o
		}
	}

}
