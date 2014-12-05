package pruebas;

import java.util.Iterator;

public class launcher {

	public static<K extends Comparable<K>,V> void visualizarRango(MAP<K,V> map,K menor,K mayor){
		Iterator<K> claves = map.getClaves();
		while(claves.hasNext()){
			K clave = claves.next();
			if(clave.compareTo(menor)>=0 && clave.compareTo(mayor)<=0){
				System.out.println(map.get(clave).toString());
			}
		}
	}
	
	public static<K,V> void visualizarMapa(MAP<K,V> map){
		Iterator<K> claves = map.getClaves();
		while(claves.hasNext()){
			K clave = claves.next();
			System.out.println(map.get(clave).toString());
		}
	}
	
	
	
	public static void main(String[] args){
		Persona mario = new Persona("76723676T","Mario",27);
		Persona pedro = new Persona("76733445Y","Pedro",43);
		Persona pepe = new Persona("46733445Y","Pedro",43);
		Persona pepa = new Persona("96733445Y","Pedro",43);
		Persona fernando = new Persona("16733445Y","Pedro",43);
		
		MAP<String,Persona> mapa = new HashMap(5);
		
		mapa.insertar(mario.getdni(),mario);
		mapa.insertar(pedro.getdni(),pedro);
		mapa.insertar(pepe.getdni(),pepe);
		mapa.insertar(pepa.getdni(),pepa);
		mapa.insertar(fernando.getdni(),fernando);
		
		System.out.println("Contenido del mapa:\n");
		visualizarMapa(mapa);
		
		System.out.println("\nMetodo visualizar:\n");
		visualizarRango(mapa,"50000000A","80000000Z");
		
	}
}
