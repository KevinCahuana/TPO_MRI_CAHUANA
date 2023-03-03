package Grafo;



public class Arista implements Comparable<Arista>{
	int peso;
	Arista sig;
	Grafo apunta;
	boolean Visitado;
	int origen;
	
	public int compareTo(Arista aux) {
		if(this.peso < aux.peso) {
			return -1;
		}else if(this.peso > aux.peso) {
			return 1;
		}else {
			return 0;
		}
	}
	
		
	

}
