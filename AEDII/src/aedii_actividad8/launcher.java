package aedii_actividad8;

import grafo.*;
import java.util.Iterator;
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
	}
}
