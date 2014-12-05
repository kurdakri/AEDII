package map;

import java.util.*;

public class Prueba {
	
	public static<K extends Comparable<K>,V> void visualizar(MAP<K,V> map,K menor,K mayor){
		Iterator<K> itr = map.getClaves();
		while(itr.hasNext()){
			K clave = itr.next();
			if(clave.compareTo(menor)>=0 && clave.compareTo(mayor)<=0) System.out.println(map.get(clave).toString());
		}
	}
	
	public static void main(String[] args){
		MAP<String,Persona> mapa = new HashMap<String,Persona>(4);
		Persona pepe = new Persona("35454543Y","Pepe",49);
		Persona pepa = new Persona("65677889I","Pepa",20);
		Persona pepin = new Persona("87855432Q","Pepin",4);
		Persona pepote = new Persona("99999999Z","Pepote",90);
		
		mapa.insertar(pepe.getDni(), pepe);
		mapa.insertar(pepa.getDni(), pepa);
		mapa.insertar(pepin.getDni(), pepin);
		mapa.insertar(pepote.getDni(),pepote);
		
		System.out.println("Contenido del mapa\n");
		Iterator<String> itr = mapa.getClaves();
		while(itr.hasNext()){
			String clave = itr.next();
			System.out.println(mapa.get(clave).toString());
		}
		
		System.out.println("\nMetodo visualizar:\n");
		visualizar(mapa,pepe.getDni(),pepin.getDni());
		
		System.out.println("\nEdad de pepe: "+mapa.get(pepe.getDni()).getEdad());
		
		mapa.eliminar(pepote.getDni());
		
		System.out.println("\nSe elimina a pepote del map:\n");
		itr = mapa.getClaves();
		while(itr.hasNext()){
			String clave = itr.next();
			System.out.println(mapa.get(clave).toString());
		}
	}
}
