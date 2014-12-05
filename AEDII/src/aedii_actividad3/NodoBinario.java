package aedii_actividad3;

public class NodoBinario<E> {
	
	private E elemento;
	private NodoBinario<E> izq;
	private NodoBinario<E> der;
	
	public NodoBinario(E elem,NodoBinario<E> hi,NodoBinario<E> hd){
		this.elemento = elem;
		this.izq = hi;
		this.der = hd;
	}
	
	public E getElemento(){
		return elemento;
	}
	
	public NodoBinario<E> getIzq(){
		return izq;
	}
	
	public NodoBinario<E> getDer(){
		return der;
	}
	
	public void setElemento(E elem){
		this.elemento = elem;
	}
	
	public void setIzq(NodoBinario<E> hi){
		this.izq = hi;
	}
	
	public void setDer(NodoBinario<E> hd){
		this.der = hd;
	}
	
}
