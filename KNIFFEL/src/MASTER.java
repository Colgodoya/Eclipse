public class MASTER {
	
	//speichert den Spieler der momentan am Zug ist
	private int momentanerSpieler;
	
	//Erstellt fünf Wuerfelobjekte
	WUERFEL wuerfel1;
	WUERFEL wuerfel2;
	WUERFEL wuerfel3;
	WUERFEL wuerfel4;
	WUERFEL wuerfel5;
	
	public int wurf1;
	public int wurf2;
	public int wurf3;
	public int wurf4;
	public int wurf5;
	
	//Erstellt eine graphische Oberflaeche
	OBERFLAECHE gui;
	
	//Erstellt ein Masterobjekt
	static MASTER master;

	public MASTER(){
	momentanerSpieler = 0;
	wuerfel1 = new WUERFEL();
	wuerfel2 = new WUERFEL();
	wuerfel3 = new WUERFEL();
	wuerfel4 = new WUERFEL();
	wuerfel5 = new WUERFEL();
	gui = new OBERFLAECHE();
	}

	public static void main(String[] args){
		
		master = new MASTER();
		master.gui.fensterNeu();
	}
		
	//sperrt den Wuerfel wenn es bei Oberflaeche geklickt wird in WUERFEL
	public void sperren(WUERFEL x){
		x.sperren();
	}
	//gettermethode fuer Spieler der momentan am Zug ist
	public int gibSpieler(){
		return momentanerSpieler;
	}
	//beendet den Zug
	public void zugBeenden(){
		
	}
	//wuerfelt 5 randomwerte mit den wuerfelobjekten
	public void wuerfeln(){
		wurf1 = wuerfel1.wuerfeln(); 
		wurf2 = wuerfel2.wuerfeln();
		wurf3 = wuerfel3.wuerfeln(); 
		wurf4 = wuerfel4.wuerfeln(); 
		wurf5 = wuerfel5.wuerfeln(); 
		//TEST : gibt generierte werte aus
		System.out.println("Geworfene Augen :");
		System.out.println(wurf1);
		System.out.println(wurf2);
		System.out.println(wurf3);
		System.out.println(wurf4);
		System.out.println(wurf5);
		//testet wuerfelwerte auf Kombis
		ergebnisTesten(wurf1,wurf2,wurf3,wurf4,wurf5);
	}
	//Methode zum testen und speichern von Wuerfelkombis
	private void ergebnisTesten(int wurf1,int wurf2,int wurf3,int wurf4,int wurf5){
		int[] punkte = new int[13];
		int[] wuerfe = {wurf1,wurf2,wurf3,wurf4,wurf5};
		
		//Augensumme gleicher Würfel
		//Counter zaehlt die Anzahl gleicher Zahlen fuer jedes x, x steht fuer die Augen der Wuerfel
		for (int x = 1; x < 7; x++){
			//diese forschleife ruft jeden gewuerfelten wert der reihe nach auf
			for (int i = 0; i < 5; i++){
			if (wuerfe[i] == x){
				punkte[x-1] += x;				
				}
			}
		}
		//Dreierpasch
		for (int x = 1; x < 7; x++){
			//Counter zaehlt die Anzahl gleicher Zahlen fuer jedes x, x steht fuer die Augen der Wuerfel
			int counter = 0;
			//diese forschleife ruft jeden gewuerfelten wert der reihe nach auf
			for (int i = 0; i < 5; i++){
				if (wuerfe[i] == x){
					counter++;
				}
			}
			if (counter >= 3){
				punkte[6] = x*counter;
			}
		}
		//Viererpasch
		for (int x = 1; x < 7; x++){
			//Counter zaehlt die Anzahl gleicher Zahlen fuer jedes x, x steht fuer die Augen der Wuerfel
			int counter = 0;
			//diese forschleife ruft jeden gewuerfelten wert der reihe nach auf
			for (int i = 0; i < 5; i++){
				if (wuerfe[i] == x){
					counter++;
				}
			}
			if (counter >= 4){
				punkte[7] = x*counter;
			}
		}
		//Full House
		int fullhouse = 0;
		int fullhouse2 = 0;
		for (int x = 1; x < 7; x++){
			//Counter zaehlt die Anzahl gleicher Zahlen fuer jedes x, x steht fuer die Augen der Wuerfel
			int counter = 0;
			//diese forschleife ruft jeden gewuerfelten wert der reihe nach auf
			for (int i = 0; i < 5; i++){
				if (wuerfe[i] == x){
					counter++;
				}
			}
			if(counter == 2){
				fullhouse2 = x*2;
			}
			else if (counter == 3){
				fullhouse = x*3;
			}
		}
		if(fullhouse != 0 & fullhouse2 != 0){
			punkte[8] = 25;
		}
	
		//kleine Straße
		//help speichert die Haeufigkeit fuer jede moegliche Augenzahl
		int[] help = new int[10];
		//diese forschleife ruft jeden gewuerfelten wert der reihe nach auf
		for (int x = 0; x < 5; x++){
			//Counter zaehlt die Anzahl gleicher Zahlen fuer jedes i, i steht fuer die Augen der Wuerfel
			for (int i = 1;i < 7; i++){
				if (i == wuerfe[x]){
					help[i-1] += 1;  
				}
			}
		}
		//nachdem die helpliste gefüllt ist, wird ueberprueft ob eine Straße vorhanden ist
		for (int i = 0; i < 6;i++){
			if (help[i] != 0 & help[i+1] != 0 & help[i+2] != 0 & help[i+3] != 0){
				punkte[9] = 30;
			}
		}
		//große Straße
		//analog zu kleine Straße
		help = new int[10];
		for (int x = 0;x < 5;x++){
			for (int i = 1;i < 7;i++){
				if (i == wuerfe[x]){
					help[i-1] += 1;  
				}
			}
		}
		for (int i = 0; i < 6;i++){
			if (help[i] != 0 & help[i+1] != 0 & help[i+2] != 0 & help[i+3] != 0 & help[i+4] != 0){
				punkte[10] = 40;
			}
		}
		//Kniffel
		//wenn jeder wuerfel die gleiche Augenzahl zeigt ist ein Kniffel eingetroffen
		if(wurf1 == wurf2 & wurf2 == wurf3 & wurf3 == wurf4 & wurf4 == wurf5){
			punkte[11] = 50;
		}
		//Chance
		//Chance sind alle geworfenen Augen addiert
		punkte [12] = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
		//TEST: Ausgabe von allen Moeglichkeiten
		System.out.println("+++++++++");
		for (int i = 0;i < 13;i++){
			System.out.println(punkte[i]);
			if (i == 5){
				System.out.println("Pasch ?");
		}
			else if (i == 7){
				System.out.println("Fullhouse ?");
			}
			else if (i == 8){
				System.out.println("Straße ?");
			}
			else if (i == 10){
				System.out.println("Kniffel ?");
			}
			else if (i == 11){
				System.out.println("Chance :");
			}
		}
	}
}

