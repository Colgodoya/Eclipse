import java.util.Random; 

public class WUERFEL {
	boolean gesperrt;
	Random random;
	//speichert zuletzt generiertes Ergebnis
	int momErgebnis;
	
	public WUERFEL(){
		
		gesperrt = false;
		random = new Random();
		momErgebnis = 0;
	}
	public int wuerfeln(){
		//Test ob der Wuerfel eine neue Zufallszahl generieren soll
		if (gesperrt == false){
			//generiert zufaelliges neues Ergebnis
			momErgebnis = random.nextInt(6) + 1;
		}
		//gibt momentanes Ergebnis als return aus
		return momErgebnis;
	}
	//Methode zum aendern vom Sperrzustand
	public void sperren(){
		
		if (gesperrt == false){
			gesperrt = true;
		}
		else{
			gesperrt = false;
		}
	}
}



