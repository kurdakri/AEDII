package aedii_actividad6a;

@SuppressWarnings("serial")
public class ArbolVacioExcepcion extends RuntimeException {

	ArbolVacioExcepcion(){
		super();
	}
	
	ArbolVacioExcepcion(String mensaje){
		super(mensaje);
	}

}
