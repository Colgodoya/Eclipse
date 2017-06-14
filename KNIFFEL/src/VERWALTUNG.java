
public class VERWALTUNG {
	
	private int [][] ergebnisse;
	int spielerAnzahl;
	String[] spieler;
	
	public VERWALTUNG(int anzahl){
		//speichert die Spieleranzahl
		spielerAnzahl = anzahl;
		//erstellt Array mit Ergebnissen
		//siehe Tabelle auf Wikipedia
		ergebnisse = new int[17][spielerAnzahl];
		//erstellt Liste mit Spielernamen
		spieler = new String [spielerAnzahl];
		
	}
	//Methode zum Ergebnis speichern
	public void ergebnisSpeichern(int zeile, int ergebnis){
		ergebnisse[zeile][MASTER.master.gibSpieler()] = ergebnis;
		}
	//Methode zum Ergebnis ausgeben
	public int gibErgebnis(int spieler, int ergebnis){
		return ergebnisse[ergebnis][spieler];
	}
}
