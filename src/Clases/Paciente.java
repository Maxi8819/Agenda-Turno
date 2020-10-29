package Clases;

public class Paciente {
		
	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	
	
	
	
	public Paciente(int dni) {
		super();
		this.dni = dni;
	}




	public Paciente(int dni, String nombre, String apellido, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}




	public int dameDni() {
		return this.dni;
	}




	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre= " + nombre + ", apellido= " + apellido + ", telefono= " + telefono
				+ "]";
	}
	
	
}
