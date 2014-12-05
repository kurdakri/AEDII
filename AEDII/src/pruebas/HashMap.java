package pruebas;

import java.util.Iterator;
import java.util.Vector;

import lista.*;

public class HashMap<K, V> implements MAP<K,V> {
	
	private Lista<Par<K,V>>[] arrayList;
	private int capacidad;
	
	public HashMap(int capacidad){
		this.capacidad = capacidad;
		arrayList = new Lista[capacidad];
		for(int i=0;i<capacidad;i++){
			arrayList[i] = new ListaEnlazada<Par<K,V>>();
		}
	}
	
	public HashMap(){
		this(50);
	}
	
	public int funcionHash(K clave){
		return Math.abs(clave.hashCode() % capacidad);
	}


	public int tamano() {
		int cont = 0;
		for(int i=0;i<capacidad;i++){
			Iterator<Par<K,V>> iterador = arrayList[i].iterator();
			if(!arrayList[i].esVacio()){
				do{
				iterador.next();
				cont++;
				}while(iterador.hasNext());
			}
		}
		return cont;
	}

	public V get(K clave) {
		for(Par<K,V> it : arrayList[funcionHash(clave)]){
			if(it.getClave().equals(clave)) return it.getValor();
		}
		return null;
	}


	public void insertar(K clave, V valor) {
		boolean modify = false;
		Lista<Par<K,V>> l = arrayList[funcionHash(clave)];
		for(Par<K,V> it : l){
			if(it.getClave().equals(clave)){
				modify = true;
				it.setValor(valor);
			}
		}
		
		if(modify == false){
			Par<K,V> nuevo = new Par<K,V>(clave,valor);
			l.insertarFinal(nuevo);
		}
		
	}

	public V eliminar(K clave) {
		Lista<Par<K,V>> l = arrayList[funcionHash(clave)];
		for(Par<K,V> it : l){
			if(it.getClave().equals(clave)){
				V aux = it.getValor();
				l.suprimir(it);
				return aux;
			}
		}
		return null;
	}


	public Iterator<K> getClaves() {
		Vector<K> v = new Vector<K>();
		for(int i=0;i<capacidad;i++){
			Lista<Par<K,V>> l = arrayList[i];
			for(Par<K,V> it : l){
				v.add(it.getClave());
			}
		}
		return v.iterator();
	}


	public Iterator<V> getValores() {
		Vector<V> v = new Vector<V>();
		for(int i=0;i<capacidad;i++){
			Lista<Par<K,V>> l = arrayList[i];
			for(Par<K,V> it : l){
				v.add(it.getValor());
			}
		}
		return v.iterator();
	}
	
}
