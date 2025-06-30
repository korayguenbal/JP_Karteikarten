package jp_karteikarten;

public class Karteikarte	 /* Klasse für eine einzelne Karteikarte. 
Jede Karteikarte hat jeweils ein Hiragana zeichen und eine Umschrift in das Lateinische Alphabet (Romaji)
*/

{
	private final String hiragana;
	private final String romaji; 
	
	public Karteikarte(String hiragana, String romaji) /* 
	Konstruktor. Hier übergebe ich beide Werte direkt 
	damit das Objekt danach unveränderlich bleibt. Alternative wäre nachträgliche Setter zu nutzen.	
	*/
	{
		this.hiragana = hiragana; // Hiragana speichern
		this.romaji = romaji; // Romaji speichern
	}
	
	public String getHiragana() /* 
	Getter für das Hiragana.Ich verwende Getter statt public Felder
	um später leichter Kontrolle über die Daten zu behalten.	
	*/
	{
		return hiragana;
	}
	
	public String getRomaji() /*
	Getter für Romaji (Umschrift)
	*/
	{
		return romaji;
	}

}
