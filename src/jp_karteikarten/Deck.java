package jp_karteikarten;

import java.util.*;

/* 
 * "Deck" verwaltet die Karteikarten
 * Habe zwei Listen erstellt. Eine für noch ausstehnde Karten und 
 * eine für schon richtig beantwortete Karten.
 * */

public class Deck 
{
	private final List<Karteikarte> karten; //Karten die noch abgefragt werden
	private final List<Karteikarte> fertig = new ArrayList<>(); // Karten die ich schon richtig hatte
	
	public Deck(List<Karteikarte> initialKarten) /* Konstruktor. Kopiere die Liste damit ich die ursprünglichen 
	Daten nicht ausversehen ändere- 
	*/
	{
		this.karten = new ArrayList<>(initialKarten); // Kopie anlegen
	}
	
	public void mischen() /* Mischt die Karten zufällig.	
	*/
	{
		Collections.shuffle(karten);
	}
	
	
	public Karteikarte ziehen() /* Gibt die nächste Karte zurück.
	Wenn alle Karten einmal durch sind hole ich die richtigen Karten zurück ins Deck und mische neu
	*/
	{
		if (karten.isEmpty()) // alle Karten die schon korrekt waren, wieder reinpacken
		{
			karten.addAll(fertig);
			fertig.clear();
			mischen(); // neu mischen damit nicht immer dieselbe Reihenfolge
		}
		return karten.remove(0);
	}
	
	
	public void fertigMarkieren(Karteikarte karte, boolean korrekt) // Verarbeitet das Ergebnis der Abfrage
	{
		if (korrekt)
		{
			fertig.add(karte); // bei richtig in "fertig" Liste verschieben
		}
		else
		{
			karten.add(karte); // bei falsch wieder ans Ende von "karten"
		}
	}
	

	

}
