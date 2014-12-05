package aedii_actividad3;

public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{
	
	private NodoBinario<E> nodoRaiz;
	
	public EnlazadoArbolBinario(){
		this.nodoRaiz = null;
	}
	
	public EnlazadoArbolBinario(NodoBinario<E> raiz){
		this.nodoRaiz = raiz;
	}
	
	public EnlazadoArbolBinario(E elemRaiz,ArbolBinario<E> hi,ArbolBinario<E> hd){
		this.nodoRaiz = new NodoBinario<E>(elemRaiz,((EnlazadoArbolBinario<E>)hi).nodoRaiz,
				((EnlazadoArbolBinario<E>)hd).nodoRaiz);
	}

	@Override
	public boolean esVacio() {
		if(nodoRaiz == null) return true;
		else return false;
	}

	@Override
	public E raiz() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("Raiz:ArbolVacio");
		else return nodoRaiz.getElemento();
	}

	@Override
	public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("HijoIzq:Arbol vacio");
		else return new EnlazadoArbolBinario<E>(nodoRaiz.getIzq());
	}

	@Override
	public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("HijoDer:Arbol vacio");
		else return new EnlazadoArbolBinario<E>(nodoRaiz.getDer());
	}

	@Override
	public boolean esta(E elemento) {
		if(esVacio()) return false;
		else return esta(elemento,nodoRaiz);
	}
	
	public boolean esta(E elemento,NodoBinario<E> nodo){
		if(nodo == null) return false;
		else if(nodo.getElemento().equals(elemento)) return true;
		else{
			boolean aux = esta(elemento,nodo.getIzq());
			if(aux == true) return true;
			else return esta(elemento,nodo.getDer());
		}
	}

	@Override
	public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion();
		else nodoRaiz.setElemento(elemRaiz);
		
	}

	@Override
	public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion,
			NullPointerException {
		if(esVacio()) throw new ArbolVacioExcepcion();
		else if(hi == null) throw new NullPointerException();
		else nodoRaiz.setIzq(((EnlazadoArbolBinario<E>)hi).nodoRaiz);
		
	}

	@Override
	public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion,
			NullPointerException {
		if(esVacio()) throw new ArbolVacioExcepcion();
		else if(hd == null) throw new NullPointerException();
		else nodoRaiz.setDer(((EnlazadoArbolBinario<E>)hd).nodoRaiz);
		
	}

	@Override
	public void suprimir() {
		nodoRaiz = null;
		
	}
	

}
