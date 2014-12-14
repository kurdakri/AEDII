package aedii_actividad8;

import java.util.Iterator;
import java.util.Vector;

import grafo.*;
import java.util.Map;
import java.util.HashMap;

public class Actividad8 {
	
	//Metodo que devuelve un iterador sobre los predecesores del vertice v en el grafo
	//g, teniendo en cuenta que w es predecesor de v si (w,v) pertenece al conjunto de
	//arcos del grafo
	public static<E,T> Iterator<Vertice<E>> predecesores(Grafo<E,T> g,Vertice<E> v){
		Vector<Vertice<E>> predecesores = new Vector<Vertice<E>>();
		Iterator<Arco<E,T>> arcos = g.arcos();
		while(arcos.hasNext()){
			Arco<E,T> a = arcos.next();
			if(a.getDestino().equals(v)) predecesores.add(a.getOrigen());
		}
		return predecesores.iterator();
	}
	
	//Metodo que dado un grafo y un vertice determine si el vertice es sumidero.
	//Un vertice es sumidero si su grado de entrada es n-1 y su grado de salida es 0.
	//n es el numero de vertices del grafo
	
	public static<E,T> boolean sumidero(Grafo<E,T> g,Vertice<E> v){
		Iterator<Vertice<E>> vertices = g.vertices();
		Iterator<Arco<E,T>> arcos = g.arcos();
		int n=0;
		int gin=0;
		int gout=0;
		while(vertices.hasNext()){
			vertices.next();
			n++;
		}
		
		while(arcos.hasNext()){
			Arco<E,T> a = arcos.next();
			if(a.getOrigen().equals(v)) gout++;
			if(a.getDestino().equals(v)) gin++;
		}
		
		if((gin == n-1) && gout == 0) return true;
		else return false;	
		
	}
	
	//Metodo que determina si un grafo es regular
	//Un grafo es regular si todos sus vertices tienen el mismo numero de vertices 
	//adyacentes
	
	public static<E,T> int adyacentes(Grafo<E,T> g, Vertice<E> v){
		int ady=0;
		Iterator<Arco<E,T>> arcos = g.arcos();
		while(arcos.hasNext()){
			Arco<E,T> a = arcos.next();
			if(a.getOrigen().equals(v)) ady++;
		}
		return ady;
	}
	
	public static<E,T> boolean regular(Grafo<E,T> g){
		Iterator<Vertice<E>> vertices = g.vertices();
		Iterator<Vertice<E>> auxiliar = g.vertices();
		
		boolean resultado = true ;
		int numvertices=0;
		while(vertices.hasNext()){
			vertices.next();
			numvertices++;
		}
		
		int[] aux = new int[numvertices];
		int i=0;
		
		while(auxiliar.hasNext()){
			Vertice<E> v = auxiliar.next();
			aux[i] = adyacentes(g,v);
			i++;
		}
		
		
		for(i=0;i<aux.length;i++){
			if(aux[i] != aux[0]){
				resultado = false;
				break;
			}
		}
		
		return resultado;
		
	}
	
	
	//Metodo que dado un grafo dirigido y dos vertices devuelva cierto si existe
	//un camino simple de un vertice a otro
	//Camino simple: todos sus vertices son distintos excepto tal vez primero y ultimo
	
	public static<E,T> boolean caminoSimple(Grafo<E,T> g,Vertice<E> v1,Vertice<E> v2){
		boolean encontrado = false;
		Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
		Iterator<Vertice<E>> vertices = g.adyacentes(v1);
		if(v1.equals(v2)) return true;
		else{
			visitados.add(v1);
			while(vertices.hasNext() && encontrado==false){
				Vertice<E> w = vertices.next();
				if(!visitados.contains(w)){
					encontrado = caminoSimple(g,w,v2);
				}
			}
			return encontrado;
		}
		
	}
	
	//Metodo que dado un grafo dirigido y dos vertices escribe todos los caminos simples
	//de un vertice a otro
	
	 private static <E,T> void escribirCamino(Vector<E> c){
	        for (int i = 0; i < c.size(); i++)
	            System.out.print((c.elementAt(i)) + " ");
	        System.out.println();    
	    }    
	    
	    private static <E,T> void caminos(Grafo<E,T> g, Vertice<E> v, Vertice<E> w, Vector<Vertice<E>> visitados){
	        visitados.add(v);
	        if (v.equals(w))
	            escribirCamino(visitados);
	        else{
	            Iterator<Vertice<E>> adys = g.adyacentes(v);
	            while (adys.hasNext()){
	                Vertice<E> u = adys.next();
	                if (!visitados.contains(u))
	                    caminos(g, u, w, visitados);
	            }
	        }
	        visitados.removeElementAt(visitados.size() - 1);
	    }    
	    
	    public static <E,T> void caminos(Grafo<E,T> g, Vertice<E> v, Vertice<E> w){
	        Vector<Vertice<E>> visitados=new Vector<Vertice<E>>();
	        caminos(g, v, w, visitados);
	        System.out.println();
	    }
	
	    //Metodo que visualice todos los ciclos de un grafo dirigido
	    
	    public static<E,T> void ciclos(Grafo<E,T> g){
	    	Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
	    	Iterator<Vertice<E>> vertices = g.vertices();
	    	while(vertices.hasNext()){
	    		Vertice<E> v = vertices.next();
	    		ciclos(g,v,v,visitados);
	    	}
	    }
	    
	    private static<E,T> void ciclos(Grafo<E,T> g,Vertice<E> v,Vertice<E> w,Vector<Vertice<E>> visitados){
	    	Iterator<Vertice<E>> ady = g.adyacentes(v);
	    	visitados.add(v);
	    	while(ady.hasNext()){
	    		Vertice<E> u = ady.next();
	    		if(u.equals(w)){
	    			escribirCiclo(visitados,w);
	    			
	    		}
	    		if(!visitados.contains(u)) ciclos(g,u,w,visitados);
	    	}
	    	visitados.removeElementAt(visitados.size()-1);
	    	
	    }
	    
	    private static<E,T> void escribirCiclo(Vector<Vertice<E>> c,Vertice<E> w){
	    	for (int i = 0; i < c.size(); i++)
	            System.out.print((c.elementAt(i)) + " ");
	    	System.out.print(w.getEtiqueta());
	    	System.out.println();
	    }
	    
	
	    //Metodo que devuelve true si un grafo es conexo
	    //Conexo:Existe un camino entre cualquier par de nodos
	    
	    public static<E,T> boolean conexo(Grafo<E,T> g){
	    	Iterator<Vertice<E>> vertices1 = g.vertices();
	    	boolean conexo = false;
	    	while(vertices1.hasNext()){
	    		Vertice<E> u = vertices1.next();
		    	Iterator<Vertice<E>> vertices2 = g.vertices();
	    		while(vertices2.hasNext()){
	    			Vertice<E> w = vertices2.next();
	    			conexo = caminoSimple(g,u,w);
	    			if(conexo == false) break;
	    		}
	    	}
	    	return conexo;
	    }
	    
	    //Algoritmo del viajante
	    
	    public static<E extends Comparable<E>> Grafo<E,Integer> viajante(Grafo<E,Integer> g,Vertice<E> v){
	    	Vertice<E> nodoActual = v;
	    	Vector<E> porVisitar = new Vector<E>();
	    	Grafo<E,Integer> solucion = new ListaAdyacencia<E,Integer>();
	    	Iterator<Vertice<E>> vertices = g.vertices();
	    	while(vertices.hasNext()){
	    		Vertice<E> w = vertices.next();
	    		porVisitar.add(w.getEtiqueta());
	    	}
	    	
	    	porVisitar.remove(nodoActual.getEtiqueta());
	    	boolean continuar = true;
	    	while(!porVisitar.isEmpty() && continuar){
	    		Arco<E,Integer> u = minimo(g.arcos(),porVisitar,nodoActual);
	    		if(u != null){
	    		porVisitar.remove(u.getDestino().getEtiqueta());
	    		solucion.insertarArco(u);
	    		nodoActual = u.getDestino();
	    		}else continuar = false;
	    	}
	    	return solucion;
	    }
	    
	    private static<E extends Comparable<E>> Arco<E,Integer> minimo(Iterator<Arco<E,Integer>> arcos,Vector<E> porVisitar,
	    		Vertice<E> nodoActual){
	    	
	    	int distancia_min = 0;
	    	int min = Integer.MAX_VALUE;
	    	Arco<E,Integer> arc_min = null;
	    	while(arcos.hasNext()){
	    		Arco<E,Integer> a = arcos.next();
	    		if(a.getOrigen().equals(nodoActual) && porVisitar.contains(a.getDestino().getEtiqueta())){
	    			distancia_min = a.getEtiqueta();
	    			if(distancia_min < min){
	    				arc_min = a;
	    				min = distancia_min;
	    			}
	    		}
	    	}
	    	return arc_min;
	    	
	    }
	    
	    //Algoritmo de Prim
	    
	    public static<E extends Comparable<E>> Grafo<E,Integer> prim(Grafo<E,Integer> g,Vertice<E> v){
	    	Vector<E> porVisitar = new Vector<E>();
	    	Vector<E> visitados = new Vector<E>();
	    	Grafo<E,Integer> solucion = new ListaAdyacencia<E,Integer>();
	    	Iterator<Vertice<E>> vertices = g.vertices();
	    	while(vertices.hasNext()){
	    		Vertice<E> w = vertices.next();
	    		porVisitar.add(w.getEtiqueta());
	    	}
	    	porVisitar.remove(v.getEtiqueta());
	    	visitados.add(v.getEtiqueta());
	    	while(!porVisitar.isEmpty()){
	    		Arco<E,Integer> u = minimo(g.arcos(),porVisitar,visitados);
	    		porVisitar.remove(u.getDestino().getEtiqueta());
	    		visitados.add(u.getDestino().getEtiqueta());
	    		solucion.insertarArco(u);
	    	}
	    	return solucion;
	    	
	    }
	    
	    private static<E extends Comparable<E>> Arco<E,Integer> minimo(Iterator<Arco<E,Integer>> arcos,Vector<E> porVisitar,
	    		Vector<E> visitados){
	    	int distancia_min =0;
	    	int min = Integer.MAX_VALUE;
	    	Arco<E,Integer> arc_min = null;
	    	while(arcos.hasNext()){
	    		Arco<E,Integer> a = arcos.next();
	    		if(visitados.contains(a.getOrigen().getEtiqueta()) && porVisitar.contains(a.getDestino().getEtiqueta())){
	    			distancia_min = a.getEtiqueta();
	    			if(distancia_min < min){
	    				arc_min = a;
	    				min = distancia_min;
	    			}
	    		}
	    	}
	    	return arc_min;
	    	
	    }
	
	    //Algoritmo de Dijkstra
	    
	    public static<E> Map<Vertice<E>,Integer> dijkstra(Grafo<E,Integer> g,Vertice<E> v){
	    	Map<Vertice<E>,Integer> distancia = new HashMap<Vertice<E>,Integer>();
	    	Vector<Vertice<E>> porVisitar = new Vector<Vertice<E>>();
	    	Iterator<Vertice<E>> vertices = g.vertices();
	    	while(vertices.hasNext()){
	    		Vertice<E> w = vertices.next();
	    		porVisitar.add(w);
	    		distancia.put(w, Integer.MAX_VALUE);
	    	}
	    	distancia.put(v, 0);
	    	while(!porVisitar.isEmpty()){
	    		Vertice<E> u = minimo(distancia,porVisitar.iterator());
	    		porVisitar.remove(u);
	    		int distmin = distancia.get(u);
	    		if(distmin != Integer.MAX_VALUE){
	    			Iterator<Vertice<E>> adys = g.adyacentes(u);
	    			while(adys.hasNext()){
	    				Vertice<E> verAdy = adys.next();
	    				if(porVisitar.contains(verAdy)){
	    					Iterator<Arco<E,Integer>> arc = g.arcos();
	    					int distminAdy = 0;
	    					while(arc.hasNext()){
	    						Arco<E,Integer> a1 = arc.next();
	    						if(a1.getOrigen().equals(u) && a1.getDestino().equals(verAdy)){
	    							distminAdy = a1.getEtiqueta();
	    						}
	    					}
	    					
	    					if(distmin+distminAdy < distancia.get(verAdy)) distancia.put(verAdy, distmin+distminAdy);
	    				}
	    			}
	    		}
	    	}
    		return distancia;
	    	
	    }
	    
	    private static <E> Vertice<E> minimo (Map<Vertice<E>,Integer> d, Iterator<Vertice<E>> iPorVisitar)
	    {
	        Vertice<E> v, minV = iPorVisitar.next();
	        int c, minD = d.get(minV);
	        
	        while (iPorVisitar.hasNext())
	        {
	            v = iPorVisitar.next();
	            c = d.get(v);
	            if (c < minD)
	            {
	                minV = v;
	                minD = c;
	            }
	        }
	        
	        return minV;
	        
	        
	    }
	    
	    
}
