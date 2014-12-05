package map;

import java.util.*;
import lista.*;
/*Implementacion de un MAP con HashMap*/
public class HashMap<K,V> implements MAP<K,V> {
	private Lista<Par<K,V>>[] a;
	private int capacidad;
	
	public HashMap(int capacidad){
		this.capacidad = capacidad;
		a = new Lista[capacidad];
		for(int i=0;i<capacidad;i++){
			a[i] = new ListaEnlazada<Par<K,V>>();
		}
	}
	
	public HashMap(){
		this(50);
	}
	
	private int funcionHash(K clave){
		return Math.abs(clave.hashCode()%capacidad);
	}
	
	public int tamano(){
		int contador = 0;
		for(int i=0;i<capacidad;i++){
			Iterator<Par<K,V>> iterador = a[i].iterator();
			if(!a[i].esVacio()){
				do{
					iterador.next();
					contador++;
				}while(iterador.hasNext());
			}
		}
		return contador;
	}
	
	public V get(K clave){
		for(Par<K,V> it: a[funcionHash(clave)]){
			if(it.getClave().equals(clave)) return it.getElemento();
		}
		return null;
	}
	
	public void insertar(K clave,V valor){
		boolean cambiar=false;
		int pos = funcionHash(clave);
		Lista<Par<K,V>> l = a[pos];
		
		for(Par<K,V> it : l){
			if(it.getClave().equals(clave)){
				it.setElemento(valor);
				cambiar=true;
			}
		}
		
		if(cambiar==false){
			Par<K,V> nuevo = new Par<K,V>(clave,valor);
			l.insertarFinal(nuevo);
		}
	}
	
	public V eliminar(K clave){
		int pos = funcionHash(clave);
		Lista<Par<K,V>> l = a[pos];
		
		for(Par<K,V> it : l){
			if(it.getClave().equals(clave)){
				V valor = it.getElemento();
				l.suprimir(it);
				return valor;
			}
		}
		return null;
	}
	
	public Iterator<K> getClaves(){
		Vector<K> v = new Vector<K>();
		for(int i=0;i<capacidad;i++){
			Lista<Par<K,V>> l = a[i];
			for(Par<K,V> it : l){
				v.add(it.getClave());
			}
		}
		return v.iterator();
	}
	
	public Iterator<V> getValues(){
		Vector<V> v = new Vector<V>();
		for(int i = 0; i<capacidad;i++){
			Lista<Par<K,V>> l = a[i];
			for(Par<K,V> it : l){
				v.add(it.getElemento());
			}
		}
		return v.iterator();
	}
}
