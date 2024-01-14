package domain;

import java.util.ArrayList;

public class Trabajador extends Veterinario{
	private int num_pacientes;
	
	
	
	
		public int getNum_pacientes() {
		return num_pacientes;
	}

	public void setNum_pacientes(int num_pacientes) {
		this.num_pacientes = num_pacientes;
	}

	public Trabajador(int Id, String nombre, String apellidos, String usuario, String contraseña, int id_clinica,
			ArrayList<Paciente> pacientes, Float sueldo, Especialidades especialidad, String dni, int num_pacientes) {
		super(Id,nombre, apellidos, usuario, contraseña, id_clinica, pacientes, sueldo, especialidad, dni);
		this.num_pacientes = num_pacientes;
	}

	@Override
	public String toString() {
		return "Trabajador [num_pacientes=" + num_pacientes + ", Dni=" + getDni() + ", Nombre=" + getNombre()
        + ", Apellidos=" + getApellidos() + ", Usuario=" + getUsuario() + ", Contraseña=" + getContraseña()
        + ", Clinica=" + getClinica() + ", Paciente=" + getPaciente() + ", Sueldo=" + getSueldo()
        + ", Especialidad=" + getespecialidad() + "]";
	}

	
	
	
	
	

}
