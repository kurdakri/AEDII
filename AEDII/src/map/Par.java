package map;

//Clase par


public class Par<K, V> {
	private K clave;
	private V valor;
	
	public Par(K clave,V valor){
		this.clave = clave;
		this.valor = valor;
	}
	
	public K getClave(){
		return this.clave;
	}
	
	public V getElemento(){
		return this.valor;
	}
	
	public void setClave(K clave){
		this.clave = clave;
	}
	
	public void setElemento(V valor){
		this.valor = valor;
	}

}
