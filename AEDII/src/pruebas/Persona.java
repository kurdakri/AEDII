package pruebas;

public class Persona {

	private String dni;
	private String nombre;
	private int edad;
	
	public Persona(String dni,String nombre,int edad){
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public void setdni(String dni){
		this.dni = dni;
	}
	
	public void setnombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setedad(int edad){
		this.edad = edad;
	}
	
	public String getdni(){
		return this.dni;
	}
	
	public String getnombre(){
		return this.nombre;
	}
	
	public int getedad(){
		return this.edad;
	}
	
	public String toString(){
		return "Nombre: "+this.nombre+" Edad: "+this.edad+" DNI: "+this.dni;
	}
}
