package aedii_actividad4;

import arbolBusqueda.*;

public class ConjuntoABB<E extends Comparable<E>> implements Conjunto<E> {
	
	private ArbolBusqueda<E> elemento;

	public ConjuntoABB(){
		this.elemento=new ArbolBinarioBusqueda<E>();
	}
	
	public ArbolBusqueda<E> getElemento(){
		return this.elemento;
	}
	
	
	public int cardinal() {
		return contarElem(elemento);
	}
	
	public int contarElem(ArbolBusqueda<E> a){
		if(a.esVacio()) return 0;
		else{
			return 1+contarElem(a.hijoIzq())+contarElem(a.hijoDer());
		}
	}

	public boolean pertenece(E x) {
		return esta(elemento,x);
	}
	
	public boolean esta(ArbolBusqueda<E> a,E e){
		if(a.esVacio()) return false;
		else if(a.raiz().equals(e)) return true;
		else{
			return esta(a.hijoIzq(),e) && esta(a.hijoDer(),e);
		}
	}

	public boolean inserta(E x) {
		if(!esta(elemento,x)){
			elemento.insertar(x);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean elimina(E x) {
		if(esta(elemento,x)){
			elemento.eliminar(x);
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public E elige() throws IllegalArgumentException {
		if(elemento.esVacio()) throw new IllegalArgumentException();
		else return elemento.raiz();
	}

	@Override
	public Conjunto<E> union(Conjunto<E> conj) {
		 Conjunto<E> auxThis= new ConjuntoABB<E>();
		 Conjunto<E> toRet= new ConjuntoABB<E>();
		 
		 //pasar this a toret
		 while(this.cardinal()!=0){
		 auxThis.inserta(this.elige()); //insertamos en auxiliar
		 toRet.inserta(this.elige()); // insertamos en el nuevo
		 this.elimina(this.elige()); // eliminamos de this
		 }
		 //recuperar this
		 while(auxThis.cardinal()!=0){
		 this.inserta(auxThis.elige()); //insertar
		 auxThis.elimina(auxThis.elige());
		 }
		 //pasar conj a toret
		 while(conj.cardinal()!=0){
		 toRet.inserta(conj.elige()); // insertamos en el nuevo
		 auxThis.inserta(conj.elige());
		 conj.elimina(conj.elige());
		 }
		 //recuperar conj
		 while(auxThis.cardinal()!=0){
		 conj.inserta(auxThis.elige()); //insertar
		 auxThis.elimina(auxThis.elige());
		 }
		 
		 return toRet;

	}

	@Override
	public Conjunto<E> interseccion(Conjunto<E> conj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conjunto<E> diferencia(Conjunto<E> conj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
