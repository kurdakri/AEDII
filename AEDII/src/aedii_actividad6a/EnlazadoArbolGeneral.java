package aedii_actividad6a;

public class EnlazadoArbolGeneral<E> implements ArbolGeneral<E> {
	
	private NodoGeneral<E> nodoRaiz;
	
	public EnlazadoArbolGeneral(){
		this.nodoRaiz = null;
	}
	
	public EnlazadoArbolGeneral(NodoGeneral<E> raiz){
		nodoRaiz = raiz;
	}
	
	public EnlazadoArbolGeneral(E elemRaiz,ArbolGeneral<E> ... hijos) throws NullPointerException{
		if(hijos == null) throw new NullPointerException();
		else if(hijos.length == 0) nodoRaiz = new NodoGeneral<E>(elemRaiz,null,null);
		else{
			for(int i=0; i<hijos.length-1;i++){
				((EnlazadoArbolGeneral<E>)hijos[i]).nodoRaiz.setHer(((EnlazadoArbolGeneral<E>)hijos[i+1]).nodoRaiz);
			}
			nodoRaiz = new NodoGeneral<E>(elemRaiz,((EnlazadoArbolGeneral<E>)hijos[0]).nodoRaiz,null);
			
		}
	}
	
	
	@Override
	public boolean esVacio() {
		if(nodoRaiz == null) return true;
		else return false;
	}

	@Override
	public E raiz() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("Raiz:Arbol vacio");
		else return nodoRaiz.getElemento();
	}

	@Override
	public ArbolGeneral<E> hijoMasIzq() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("HijoMasIzq: Arbol vacio");
		else{
			return new EnlazadoArbolGeneral<E>(nodoRaiz.getHijo());
		}
	}

	@Override
	public ArbolGeneral<E> hermanoDer() throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion("Hermano: Arbol vacio");
		else{
			return new EnlazadoArbolGeneral<E>(nodoRaiz.getHer());
		}
	}

	@Override
	public boolean esta(E elemento) {
		return esta(elemento,nodoRaiz);
	}
	
	public boolean esta(E elemento,NodoGeneral<E> raiz){
		if(raiz == null) return false;
		else if(raiz.getElemento().equals(elemento)) return true;
		else{
			NodoGeneral<E> hijo = raiz.getHijo();
			while(hijo != null){
				if(esta(elemento,hijo)) return true;
				else hijo=hijo.getHer();
			}
			return false;
		}
	}

	@Override
	public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
		if(esVacio()) throw new ArbolVacioExcepcion();
		else nodoRaiz.setElemento(elemRaiz);
		
	}

	@Override
	public void setHijo(ArbolGeneral<E> hijo) throws ArbolVacioExcepcion,
			NullPointerException {
		if(esVacio()) throw new ArbolVacioExcepcion();
		else if(hijo == null) throw new NullPointerException();
		else if(hijoMasIzq().esVacio()) nodoRaiz.setHijo(((EnlazadoArbolGeneral<E>)hijo).nodoRaiz);
		else{
			NodoGeneral<E> aux  = nodoRaiz.getHijo();
			while(aux.getHer() != null) aux = aux.getHer();
			aux.setHer(((EnlazadoArbolGeneral<E>)hijo).nodoRaiz);
		}
	}

	@Override
	public void suprimir() {
		this.nodoRaiz = null;
		
	}

}
