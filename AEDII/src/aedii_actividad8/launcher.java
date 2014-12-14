package aedii_actividad8;

import grafo.*;
import java.util.Iterator;
import java.util.Map;
public class launcher {
	public static void main(String[] args){
		Grafo<String,Integer> g = new ListaAdyacencia<String,Integer>();
		Vertice<String> v1 = new Vertice<String>("Coruña");
		Vertice<String> v2 = new Vertice<String>("Lugo");
		Vertice<String> v3 = new Vertice<String>("Ourense");
		Vertice<String> v4 = new Vertice<String>("Pontevedra");
		
		g.insertarArco(new Arco<String,Integer>(v2,v1,10));
	    g.insertarArco(new Arco<String, Integer>(v1, v3, 20));
	    g.insertarArco(new Arco<String, Integer>(v2, v4, 115));
	    g.insertarArco(new Arco<String, Integer>(v3, v4, 100));
	    g.insertarArco(new Arco<String, Integer>(v2, v3, 100));
	    g.insertarArco(new Arco<String, Integer>(v4, v2, 120));
	    g.insertarArco(new Arco<String, Integer>(v4, v3, 120));
	    
	    //Mostramos vertices del grafo
	    System.out.println("Mostrando vertices:\n");
	    Iterator<Vertice<String>> vertices = g.vertices();
	    while(vertices.hasNext()){
	    	System.out.println(vertices.next()+" ");
	    }
	    
	    //Mostramos arcos del grafo
	    System.out.println("\nMostrando arcos:\n");
	    Iterator<Arco<String,Integer>> arcos = g.arcos();
	    while(arcos.hasNext()){
	    	System.out.println(arcos.next()+" ");
	    }
	    
	    //Prueba para la actividad 1
	    System.out.println("\nMostrando predecesores de "+v3);
	    Iterator<Vertice<String>> predecesores = Actividad8.predecesores(g, v3);
	    while(predecesores.hasNext()){
	    	System.out.println(predecesores.next()+" ");
	    }
	    
	    //Prueba para la actividad 2
	    System.out.println("\n¿Es"+v3+" sumidero?\nRespuesta: "+Actividad8.sumidero(g, v3));
	    
	    //Prueba para la actividad 3
	    System.out.println("\nVertices adyacentes de"+v1+": "+Actividad8.adyacentes(g,v1));
	    System.out.println("\nVertices adyacentes de"+v2+": "+Actividad8.adyacentes(g,v2));
	    System.out.println("\nVertices adyacentes de"+v3+": "+Actividad8.adyacentes(g,v3));
	    System.out.println("\nVertices adyacentes de"+v4+": "+Actividad8.adyacentes(g,v4));
	    System.out.println("\n¿Es el grafo regular?:\n Respuesta: "+Actividad8.regular(g));
	    
	    //Prueba para la actividad 4
	    
	    System.out.println("\n¿Hay camino de coruña a lugo?\n Respuesta: "+Actividad8.caminoSimple(g, v1, v2));
	    
	    //Prueba actividad 5
	    
	    System.out.println("\nMostrando caminos entre coruña y lugo\n");
	    Actividad8.caminos(g, v1, v2);
	    
	    //Prueba actividad 6
	    System.out.println("\nMostrando ciclos\n");
	    Actividad8.ciclos(g);
	    
	    //Prueba grafo conexo
	    
	    System.out.println("\n¿Es el grafo conexo?\nRespuesta: "+Actividad8.conexo(g));
	    
	    //ALGORITMOS VORACES
	    
        Grafo <Integer, Integer> g1 = new ListaAdyacencia<Integer,Integer>();
        
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(1),new Vertice<Integer>(2),3));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(1),new Vertice<Integer>(6),5));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(2),new Vertice<Integer>(3),7));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(2),new Vertice<Integer>(6),10));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(6),new Vertice<Integer>(3),8));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(6),new Vertice<Integer>(4),2));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(3),new Vertice<Integer>(4),5));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(3),new Vertice<Integer>(5),1));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(4),new Vertice<Integer>(5),6)); 
        // Arcos en ambos sentidos para el problema del viajante
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(2),new Vertice<Integer>(1),3));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(6),new Vertice<Integer>(1),5));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(3),new Vertice<Integer>(2),7));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(6),new Vertice<Integer>(2),10));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(3),new Vertice<Integer>(6),8));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(4),new Vertice<Integer>(6),2));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(4),new Vertice<Integer>(3),5));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(5),new Vertice<Integer>(3),1));
        g1.insertarArco(new Arco<Integer,Integer>(new Vertice<Integer>(5),new Vertice<Integer>(4),6)); 
        
        Iterator<Arco<Integer,Integer>> arc = g1.arcos();
        
        System.out.println("\nGRAFO ALGORITMOS VORACES");
        while(arc.hasNext()){
        	Arco<Integer,Integer> a1 = arc.next();
        	System.out.println("\n Vertice origen: "+a1.getOrigen().getEtiqueta()+"\nVertice destino: "
        			+a1.getDestino().getEtiqueta()+"\nDistancia: "+a1.getEtiqueta());
        }
        
        //Prueba Algoritmo del viajante
        
        System.out.println("\nProbando algoritmo del viajante:");
        int distancia=0;
        Vertice<Integer> origen = new Vertice<Integer>(1);
        Grafo<Integer,Integer> gviajante = Actividad8.viajante(g1,origen);
        System.out.println("\nCamino mas corto desde 1 :");
        Iterator<Arco<Integer,Integer>> arcviajante = gviajante.arcos();
        while(arcviajante.hasNext()){
        	Arco<Integer,Integer> a2 = arcviajante.next();
        	System.out.println("\nVertice origen: "+a2.getOrigen().getEtiqueta()+"\nVertice destino: "
        			+a2.getDestino().getEtiqueta()+"\nDistancia: "+a2.getEtiqueta());
        	distancia=distancia+a2.getEtiqueta();
        }
        System.out.println("\nDistanciaTotal: "+distancia);
        
        //Prueba Algoritmo de Prim
        System.out.println("\nProbando algoritmo de Prim:");
        int distanciaPrim=0;
        Vertice<Integer> origenPrim = new Vertice<Integer>(1);
        Grafo<Integer,Integer> gPrim = Actividad8.prim(g1,origenPrim);
        System.out.println("\nGrafo Prim solucion con origen en 1 :");
        Iterator<Arco<Integer,Integer>> arcPrim = gPrim.arcos();
        while(arcPrim.hasNext()){
        	Arco<Integer,Integer> a3 = arcPrim.next();
        	System.out.println("\nVertice origen: "+a3.getOrigen().getEtiqueta()+"\nVertice destino: "
        			+a3.getDestino().getEtiqueta()+"\nDistancia: "+a3.getEtiqueta());
        	distanciaPrim=distanciaPrim+a3.getEtiqueta();
        }
        System.out.println("\nDistanciaTotal:"+distanciaPrim);
        
        //Prueba Algoritmo de Dijkstra
        System.out.println("\nProbando algoritmo de Dijkstra");
        Vertice<Integer> origenDijkstra = new Vertice<Integer>(1);
        Map<Vertice<Integer>,Integer> mapa = Actividad8.dijkstra(g1, origenDijkstra);
        Iterator<Vertice<Integer>> claves = mapa.keySet().iterator();
        while(claves.hasNext()){
        	Vertice<Integer> vc = claves.next();
        	Integer c = vc.getEtiqueta();
        	System.out.println("\nVertice: "+c.toString()+"\nvalor: "+mapa.get(vc));
        }
        
        
        
	}
}
