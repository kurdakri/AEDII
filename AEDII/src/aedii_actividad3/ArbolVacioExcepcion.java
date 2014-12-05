package aedii_actividad3;

@SuppressWarnings("serial")
public class ArbolVacioExcepcion extends RuntimeException {
	
	public ArbolVacioExcepcion(){
		super();
	}
	
	public ArbolVacioExcepcion(String mensaje){
		super(mensaje);
	}

}
