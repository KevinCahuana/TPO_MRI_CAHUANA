package TPO;
import Grafo.ImplemEstatica;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j, w;
	
		ImplemEstatica grafo = new ImplemEstatica();
		grafo.inicializarGrafo(10);
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		
		grafo.agregarArista(1 , 3 , 1);
		grafo.agregarArista(1 , 2 , 1);
		grafo.agregarArista(2 , 3 , 1);
		grafo.agregarArista(3 , 4 , 1);
		grafo.agregarArista(4 , 2 , 1);
		grafo.agregarArista(4 , 3 , 1);
		grafo.agregarArista(4 , 1 , 1);
		
        System.out.println("Matriz que muestra Vertices y Aristas:");
		
		System.out.println("\t");
		
		grafo.mostrarMatriz();
		
		

		System.out.println("Vertices con sus respectivos padres segun el recorrido de DFS:");
		
		System.out.println("\t");
		
		int[] p = new int[5];
		
		String marca[] = new String[5]; // Creo el vector con marca en Blanco (vertices no visitados)
		for(w=0; w<marca.length; w++) {
			marca[w] = "B";
		}
		
		int[] dfs = DFS(grafo, 1, p, marca);
		
		// Voy leyendo el arreglo de padres de salida y reconstruyendo el Camino de como se visito el Grafo.
		for(j=1; j<dfs.length; j++) {
			System.out.println("Hijo: "+j+" / Padre: "+dfs[j]);
		}
	}
	
	public static int[] DFS(ImplemEstatica grafo, int origen, int[]p, String[] marca) {
		marca[origen] = "G"; 		// Utilizo una marca para ver el estado de cada nodo, donde:
									// G es descubierto, B es no visitado y N visitado.
		
		// Recorro los adyacentes al nodo origen. 
		for (int v: grafo.adyacentes(origen)) 
			if(marca[v] == "B") {
				p[v] = origen;     // P es un arreglo de Padres y nos sirve para dibujar el grafo de salida.
				// El indice nos indica hijo y el elemento que este en ese indice es el padre.
				DFS(grafo, v, p, marca); 				// Llamada recursiva a DFS donde origen ahora es v.
			}
		marca[origen] = "N"; 		// Cambio a visitado.	
		return p;                  		// Retorno el arreglo de padres 
		
	}

}
