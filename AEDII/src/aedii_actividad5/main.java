package aedii_actividad5;

import arbolGeneral.*;

public class main {
	
	/*
	 *Ejercicio 1: Numero de nodos
	 */
	
	public static<E> int numNodos(ArbolGeneral<E> a){
		if(a.esVacio()) return 0;
		else{
			int cont=1;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while(!hijo.esVacio()){
				cont++;
				hijo=hijo.hermanoDer();
				numNodos(hijo);
			}
			return cont;
		}
	}
	
	/*
	 * Ejercicio 2: Numero de hojas
	 */
	
	public static<E> int numHojas(ArbolGeneral<E> a){
		if(a.esVacio()) return 0;
		else{
			int cont=0;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while(!hijo.esVacio()){
				if(hijo.hijoMasIzq().esVacio()){
					cont++;
					numHojas(hijo);
				}
				hijo=hijo.hermanoDer();
			}
			return cont;
		}
	}
	
	/*
	 * Ejercicio 3
	 */
	
	public static<E> boolean cuadArbol(ArbolGeneral<E> a){
		if(a.esVacio()) return true;
		else{
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			if(hijo.esVacio()) return true;
			else{
				int cont=0;
				while(!hijo.esVacio()){
					cont++;
					hijo = hijo.hermanoDer();
					cuadArbol(hijo);
				}
				if(cont==4) return true;
				else return false;
			}
		}
	}
	
	/*
	 * Ejercio 4
	 */
	
	public static<E> void verNivel(ArbolGeneral<E> a,int nivel){
		if(a.esVacio()) System.out.println("Arbol vacio");
		else if(nivel==0) System.out.println(a.raiz()+"");
		else{
			ArbolGeneral<E> hijo= a.hijoMasIzq();
			while(!hijo.esVacio()){
				verNivel(hijo,nivel-1);
				hijo=hijo.hermanoDer();
			}
		}
	}
	
	/*
	 * Ejercicio 5
	 */
	
	public static<E> int grado(ArbolGeneral<E> a){
		if(a.esVacio()) return 0;
		else if(a.hijoMasIzq().esVacio()) return 0;
		else{
			int cont=0;
			int max=0;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while(!hijo.esVacio()){
				cont++;
				hijo=hijo.hermanoDer();
			}
			if(cont>max) max=cont;
			ArbolGeneral<E> aux = a.hijoMasIzq();
			while(!aux.esVacio()){
				grado(aux);
				aux=aux.hermanoDer();
			}
			return max;
		}
	}
	
	/*
	 * Ejercicio 7
	 */
	
	public static<E> void anchura(ArbolGeneral<E> a){
		if(!a.esVacio()){
			System.out.println(a.raiz()+" ");
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			ArbolGeneral<E> aux = a.hijoMasIzq();
			do{
				while(!hijo.esVacio()){
					System.out.println(hijo.raiz()+" ");
					hijo=hijo.hermanoDer();
				}
				hijo=aux.hijoMasIzq();
			}while(!hijo.esVacio());
		}
	}
	
	/*
	 * Ejercicio 8
	 */
	
	public static<E> boolean identicos(ArbolGeneral<E> a,ArbolGeneral<E> b){
		if(a.esVacio() && b.esVacio()) return true;
		else if((a.esVacio() && (!b.esVacio())) || ((!a.esVacio()) && b.esVacio())) return false;
		else{
			if(!a.raiz().equals(b.raiz())) return false;
			else{
				ArbolGeneral<E> ha = a.hijoMasIzq();
				ArbolGeneral<E> hb = b.hijoMasIzq();
				while(!ha.esVacio() && !hb.esVacio()){
					if(!identicos(ha,hb)) return false;
					ha=ha.hermanoDer();
					hb=hb.hermanoDer();
				}
				return ha.esVacio() && hb.esVacio();
			}
		}
	}
	
	/*
	 * Ejercicio 9
	 */
	
	public static<E> int altura(ArbolGeneral<E> a){
		if(a.esVacio()) return 0;
		else{
			int alt = 0;
			int altmax = 0;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while(!hijo.esVacio()){
				alt=altura(hijo);
				if(alt>altmax) altmax=alt;
				hijo = hijo.hermanoDer();
			}
			return altmax+1;
		}
	}
	
	
	public static void main(String[] args){
		ArbolGeneral<Integer> hijoIzq = new EnlazadoArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> hijoCentro = new EnlazadoArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> hijoDer = new EnlazadoArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> hijoMasDer = new EnlazadoArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> arbol = new EnlazadoArbolGeneral<Integer>(10,hijoIzq,hijoCentro,hijoDer,hijoMasDer);
		System.out.println("numNodos: "+numNodos(arbol));
		System.out.println("numHojas: "+numHojas(arbol));
		System.out.println("cuadArbol: "+cuadArbol(arbol));
		verNivel(arbol,1);
		System.out.println("grado: "+grado(arbol));
		System.out.println("recorrido: ");
		anchura(arbol);
		System.out.println("altura: "+altura(arbol));
	}
}
