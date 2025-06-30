package jp_karteikarten;

import jp_karteikarten.*;
import java.util.*;

/*
 * Konsolen Programm für Karteikarten (in dem Fall Hiragana)
 * Benutze aus Scope gründen fest coodierte Daten anstatt eine CSV Datei
 */

public class Main 
{
	// Hier sind die fest kodierten Daten als Array
	private static final Karteikarte[] KARTEIKARTEN = 
		{
	        new Karteikarte("あ", "a"),
	        new Karteikarte("い", "i"),
	        new Karteikarte("う", "u"),
	        new Karteikarte("え", "e"),
	        new Karteikarte("お", "o"),
	        new Karteikarte("か", "ka"),
	        new Karteikarte("き", "ki"),
	        new Karteikarte("く", "ku"),
	        new Karteikarte("け", "ke"),
	        new Karteikarte("こ", "ko")
		};
	
	public static void main(String[] args)
	{
		List<Karteikarte> karten = new ArrayList<>(Arrays.asList(KARTEIKARTEN)); /* 
		Array wird in Liste umgewandelt damit ich shuffle und remove nutzen kann
		*/
		Deck deck = new Deck (karten); // Deck Objekt erzeugen
		deck.mischen(); // Karten mischen
		
		Scanner scanner = new Scanner(System.in); // Scanner um Nutzereingaben zu lesen
		System.out.println("Hiragana Abfrage. Tippe 'Beenden' zum Beenden \n");
		
		
		while (true) // Endlosschleife für die Abfrage
		{
			Karteikarte karte = deck.ziehen(); // nächste Karte ziehen
			
			System.out.printf("Was ist '%s'?", karte.getHiragana()); // Frage anzeigen
			String input = scanner.nextLine().trim(); // Eingabe lesen und trimmen
			
			if ("Beenden".equalsIgnoreCase(input)) // Abbruch wenn Nutzer "beenden" eingibt unabhäng von Groß-Kleinschreibung
			{
				System.out.println("\nAuf Wiedersehen!");
				break; // Schleife beenden
			}
			
			boolean korrekt = input.equalsIgnoreCase(karte.getRomaji()); // Antwort prüfen
			if (korrekt)
			{
				System.out.println("Richtig\n");
			} 
			else
			{
				System.out.printf("Falsch. Korrekt wäre gewesen: %s%n%n", karte.getRomaji());
			}
			
			deck.fertigMarkieren(karte, korrekt); // Ergebnis an "Deck" übergeben damit die Karte richtig einsortiert wird
		}
		
		scanner.close(); // Scanner schließen und ressourcen freigeben
	}
	
}
