package Clases;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Agenda nuevaAgenda = new Agenda(10);

		nuevaAgenda.registrarTurno(34343569, "Daniel", "Ramirez", "1566863610");
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.registrarTurno(34343569, "Pepe", "Ducplicado", "0000000"); //dni duplicado
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.registrarTurno(54648233, "Isabella Abigail", "Ramirez", "20742497");
		nuevaAgenda.registrarTurno(33774789, "Maria Fernada", "Altamirano", "1566826700");
		nuevaAgenda.registrarTurno(341111, "Juan", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(343456, "Juan2", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(343435644, "Juan3", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(343435635, "Juan5", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(343435623, "Juan6", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(343435611, "Juan7", "Prueba", "0000000");
		nuevaAgenda.registrarTurno(34343562, "Juan8", "Prueba", "0000000");
		System.out.println("-----------------------------------------------------------------------------------------");	
		nuevaAgenda.registrarTurno(134343562, "Juan9", "Completo", "0000000"); //capacidad superada
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.darPresente(54648233); //  presente Isabella
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.listarTurnos();
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.anularTurno(343435635); //anulo juan5
		System.out.println("-----------------------------------------------------------------------------------------");
		nuevaAgenda.listarTurnos();
		System.out.println("---------------------Pacientes ausentes--------------------------------------------------------------------");
		nuevaAgenda.listarAusentes();
	}

}
