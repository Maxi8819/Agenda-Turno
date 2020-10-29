package Clases;

public class Turno {
		
	private Paciente paciente;
	private boolean precencia = false;

	
	public Turno() {
		
	}
	
	public Turno(Paciente paciente) {
		this.paciente = paciente;
		
	}
	public int dameDniPaciente() {
		
		return this.paciente.dameDni();
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public boolean isPrecencia() {
		return precencia;
	}
	public void setPrecencia(boolean precencia) {
		this.precencia = precencia;
	}
	@Override
	public String toString() {
		return "Turno [" + paciente + ", precencia=" + precencia + "]";
	}
	
	
	
	
}
	