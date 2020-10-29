package Clases;

import java.util.ArrayList;

public class Agenda {

	private  int total_turno;

	private ArrayList<Turno> turnos;

	public Agenda(int total_turno) {
		this.total_turno= total_turno;
		turnosDiariosDisponibles(this.total_turno);
	}

	private void turnosDiariosDisponibles(int TOTAL_TURNOS) {
		this.turnos = new ArrayList<Turno>();
		for (int i = 0; i < total_turno; i++) {
			Paciente p = new Paciente(0);
			Turno t = new Turno(p);
			turnos.add(t);

		}

	}



	/*
	 * Método privado buscarTurno(): Devuelve, si existe, un turno de la lista de
	 * turnos dado un DNI del paciente recibido por parámetro. De lo contrario
	 * retorna null.
	 * 
	 */

	private Turno buscarTurno(int dni) {
		Turno t;
		Turno tEncontado = null;
		int indx = 0;
		boolean bandera = false;

		while (indx < turnos.size() || !bandera) {
			t = turnos.get(indx);
			if (t.dameDniPaciente()==dni) {
				tEncontado = t;
				bandera=true;
			}
			bandera = (tEncontado == null) ? true : bandera;
			indx++;
		}
		return tEncontado;
	}

	/*
	 * Método público registrarTurno(): Dado todos los datos de un paciente, crea un
	 * Turno para el mismo y lo agrega a la agenda de turnos. Además, retornará como
	 * resultado la confirmación del registro. Tener en cuenta que si se cumple
	 * alguno de los siguientes casos, el turno no se agregará a la lista,
	 * retornando el respectivo estado con un enumerado que refleje estas
	 * posibilidades: ○ El médico no tiene más turnos. ○ El paciente (dni) ya tenía
	 * previamente un turno asignado en la lista. En caso de que no se cumpla alguna
	 * de estas dos condiciones devolver un valor que signifique Turno Confirmado.
	 */

	public void registrarTurno(int dni, String nombre, String apellido, String telefono) {

		Turno t = buscarTurno(dni);
		int i = 0;
		boolean registrado = false;

		if (hayDisponibilidad()) {
			if (t == null) {
				while (!registrado) {
					t = turnos.get(i);
					if (t.dameDniPaciente() == 0) {
						Paciente p = new Paciente(dni, nombre, apellido, telefono);
						t.setPaciente(p);
						registrado = true;
					}
					i++;
				}
				if (registrado) {
					System.out.println("turnno asignado correctamente al paciente " + t.getPaciente().toString());
				}

			} else {
				System.out.println("El paciente: " + t.getPaciente().toString() + " cuenta con un turno registrado");
			}
		} else {
			System.out.println("sin disponibilidad");
		}
	}

	private boolean hayDisponibilidad() {
		boolean dispo = false;
		int i = 0;
		Turno t;

		while (!dispo&&i<total_turno) {
			t = turnos.get(i);
			if (t.dameDniPaciente() == 0) {
				dispo = true;
			} 
				i++;


		}
		return dispo;
	}

	/*
	 * Método público listarTurnos(): Mostrará por pantalla la cantidad de turnos
	 * asignados hasta el momento y los datos de cada turno. (Incluye visualizar los
	 * datos de los pacientes.)
	 * 
	 */

	public void listarTurnos() {
		for (Turno t : turnos) {
			if (t != null) {
				System.out.println(t.toString());
			}

		}
	}

	/*
	 * Método público darPresente(): Dado un dni recibido por parámetro, si existe
	 * un turno de algún paciente en la lista con ese dni lo marca como presente.
	 * Retorna un booleano indicando si pudo o no realizar la acción.
	 * 
	 */

	public boolean darPresente(int dni) {
		boolean presente= false;
		Turno t = buscarTurno(dni);
		if (t != null) {
			t.setPrecencia(true);
			presente = true;
			System.out.println("Asistencia del "+t.getPaciente().toString()+ " confirmada");
		}
		
		return presente;

	}

	/*
	 * Método público anularTurno(): Dado un dni recibido por parámetro, quita el
	 * turno de la lista si encuentra al paciente. Retorna un booleano indicando si
	 * pudo o no realizar la acción.
	 * 
	 */
	
	
	public boolean anularTurno(int dni) {
		boolean anulado;
		Turno t = buscarTurno( dni);
		if (t != null) {
			turnos.remove(t);
			System.out.println("El turno para el " + t.getPaciente().toString() +" se encuentra anulado correctamente");
		}
		anulado = (t != null)?true:false;
		return anulado;
	}
	
	
	/*
	 * Método público obtenerAusentes(): Retorna un ArrayList de elementos Paciente,
	 * con aquellos/as pacientes que no se presentaron para los turnos que
	 * solicitaron
	 */
	
	private ArrayList<Paciente> obtenerAusentes() {
		ArrayList<Paciente> pts = new ArrayList<Paciente>();
		for (Turno t : turnos) {
			if (t.isPrecencia() == false) {
				Paciente p = t.getPaciente();
				if (p != null) {
					pts.add(p);
				}
			}
		}
		return pts;
	}
	
	public void listarAusentes() {
		ArrayList<Paciente> p = obtenerAusentes();
		for (Paciente pts : p) {
			System.out.println(pts.toString());
		}
		
	}
	
	
}
