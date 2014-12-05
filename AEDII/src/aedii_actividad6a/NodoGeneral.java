package aedii_actividad6a;

public class NodoGeneral<E> {
	
	private E elemento;
	private NodoGeneral<E> hijo;
	private NodoGeneral<E> hermano;
	
	public NodoGeneral(){
		this.elemento = null;
		this.hijo = null;
		this.hermano = null;
	}
	
	public NodoGeneral(E e,NodoGeneral<E> hi,NodoGeneral<E> he){
		this.elemento = e;
		this.hijo = hi;
		this.hermano = he;
	}
	
	public E getElemento(){
		return elemento;
	}
	
	public void setElemento(E elem){
		this.elemento = elem;
	}
	
	public NodoGeneral<E> getHijo(){
		return hijo;
	}
	
	public void setHijo(NodoGeneral<E> hi){
		this.hijo = hi;
	}
	
	public NodoGeneral<E> getHer(){
		return hermano;
	}
	
	public void setHer(NodoGeneral<E> he){
		this.hermano = he;
	}
	

}
