package aedii_actividad2;

import arbolBinario.*;

/*
 * ESPECIFICACION DEL ARBOL BINARIO
 * ArbolBinario():constructor vacio
 * ArbolBinario(E,ArbolBinario<E>hi,ArbolBinario<E>hd)
 * Metodos:
 * boolean esVacio()
 * E raiz()
 * ArbolBinario<E> hijoIzq()
 * ArbolBinario<E> hijoDer()
 * boolean esta(E elemento)
 * void setRaiz(E elemRaiz)
 * void setHijoIzq(ArbolBinario<E> hi)
 * void setHijoDer(ArbolBinario<E> hd)
 * void suprimir()
 * CLASE que implementa la interfaz
 * EnlazadoArbolBinario<E> implements ArbolBinario<E>
 */
public class main {
	
	/*
	 * Ejercicio 1:Metodo que cuente el numero de nodos de un arbol binario
	 */
	public static <E> int numNodos(ArbolBinario<E> a){
		if(a.esVacio()) return 0;
		else
		return 1+numNodos(a.hijoIzq())+numNodos(a.hijoDer());
	}
	
	/*
	 * Ejercicio 2:Metodo que devuelva el numero de hojas de un arbol binario
	 */
	
	public static <E> int numHojas(ArbolBinario<E> a){
		if(a.esVacio()) return 0;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio()) return 1+numHojas(a.hijoIzq())+numHojas(a.hijoDer());
		else return numHojas(a.hijoIzq())+numHojas(a.hijoDer());
	}
	
	/*
	 * Ejercicio 3:Metodo que copia un arbol binario
	 */
	
	public static <E> ArbolBinario<E> copia(ArbolBinario<E> a){
		if(a.esVacio()) return new EnlazadoArbolBinario<E>();
		else return new EnlazadoArbolBinario<E>(a.raiz(),copia(a.hijoIzq()),copia(a.hijoDer()));
	}
	
	/*
	 * Ejercicio 4:Metodo que comprueba si dos arboles son parecidos
	 */
	public static<E> boolean parecidos(ArbolBinario<E> a,ArbolBinario<E> b){
		if(a.esVacio() && b.esVacio()) return true;
		else if((a.esVacio() && !b.esVacio()) || (!a.esVacio() && b.esVacio())) return false;
		else{
			ArbolBinario<E> aux = new EnlazadoArbolBinario<E>(a.raiz(),a.hijoDer(),a.hijoIzq());
			return iguales(aux,b);
		}
	}
	
	public static <E> boolean iguales(ArbolBinario<E> a,ArbolBinario<E> b){
		if(a.esVacio() && b.esVacio()) return true;
		else if((a.esVacio() && !b.esVacio()) || (!a.esVacio() && b.esVacio())) return false;
		else{
			if(a.raiz() == b.raiz()) return true && iguales(a.hijoIzq(),b.hijoIzq()) && iguales(a.hijoDer(),b.hijoDer());
			else return false;
		}
	}
	
	/*
	 * Ejercicio 5:Metodo contar nodos de un nivel n de un arbol binario
	 */
	
	public static<E> int numNodosNivel(ArbolBinario<E> a,int nivel){
		if(a.esVacio()) return 0;
		else{
			if(nivel == 0) return 1;
			else return numNodosNivel(a.hijoIzq(),nivel -1) + numNodosNivel(a.hijoDer(),nivel-1);
		}
	}
	
	/*
	 * Ejercicio 6:Altura del arbol binario
	 */
	
	public static<E> int altura(ArbolBinario<E> a){
		if(a.esVacio()) return 0;
		else{
			if(altura(a.hijoIzq())>altura(a.hijoDer())) return 1+altura(a.hijoIzq());
			else return 1+altura(a.hijoDer());
		}
	}
	
	/*
	 * Ejercicio 7:Metodo podar
	 */
	
	public static<E> ArbolBinario<E> podar(ArbolBinario<E> a){
		if(a.esVacio()) return new EnlazadoArbolBinario<E>();
		else{
			if(a.hijoIzq().esVacio() || a.hijoDer().esVacio()){
				return new EnlazadoArbolBinario<E>(a.raiz(),new EnlazadoArbolBinario<E>(),new EnlazadoArbolBinario<E>());
			}else{
				return new EnlazadoArbolBinario<E>(a.raiz(),podar(a.hijoIzq()),podar(a.hijoDer()));
			}
		}
	}
	
	/*
	 * Ejercicio 8:Palabras de un arbol Binario
	 */
	
	public static<E> void palabras(ArbolBinario<E> a,String palabra){
		if(a.esVacio()) System.out.println("Arbol vacio");
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio()){
			System.out.println("Palabra:"+palabra+a.raiz());
		}else{
			palabras(a.hijoIzq(),palabra+a.raiz());
			palabras(a.hijoDer(),palabra+a.raiz());
		}
			
	}
	
	/*
	 * Ejercicio 9:Arbol es zurdo
	 */
		public static <E> boolean zurdo (ArbolBinario<E> a){
		if (a.esVacio()) return true;
		else if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
				return true;
				else if(zurdo(a.hijoDer()) && zurdo(a.hijoIzq())){
						int hi= numNodos(a.hijoIzq());
						int hd= numNodos(a.hijoDer());
						if(hi>hd)
							return true;
						else{
							return false;
						}
				}
				else{
					return false;
				}
		
		
	}
		
	/*
	 * Ejercicio 10:Padre de un elemento
	 */
		
		public static<E> E padre(ArbolBinario<E> a,E elem){
			if(a.esVacio()) return null;
			else if(a.raiz().equals(elem)) return null;
			else{
				if((!a.hijoIzq().esVacio()) && a.hijoIzq().raiz().equals(elem)) return a.raiz();
				if((!a.hijoDer().esVacio()) && a.hijoDer().raiz().equals(elem)) return a.raiz();
				else{
					E aux= padre(a.hijoIzq(),elem);
					if(aux == null){
						return padre(a.hijoDer(),elem);
					}else{
						return aux;
					}
				}
				
			}
		}
	
	public static void main(String[] args){
		ArbolBinario<Integer> vacio= new EnlazadoArbolBinario();
		ArbolBinario<Integer> hi = new EnlazadoArbolBinario(3,vacio,vacio);
		ArbolBinario<Integer> hd = new EnlazadoArbolBinario(7,vacio,vacio);
		ArbolBinario<Integer> arbol=new EnlazadoArbolBinario(5,hi,hd);
		ArbolBinario<Integer> arbol2=new EnlazadoArbolBinario(5,hd,hi);
		String palabra="";
		System.out.println("NumNodos:"+numNodos(arbol));
		System.out.println("NumHojas"+numHojas(arbol));
		System.out.println("Iguales:"+iguales(arbol,arbol2));
		System.out.println("Parecidos:"+parecidos(arbol,arbol2));
		System.out.println("Nodos en el nivel 1:"+numNodosNivel(arbol,1));
		System.out.println("Altura del arbol:"+altura(arbol));
		palabras(arbol,palabra);
		System.out.println(zurdo(arbol));
		System.out.println(padre(arbol,7));
	}
}
