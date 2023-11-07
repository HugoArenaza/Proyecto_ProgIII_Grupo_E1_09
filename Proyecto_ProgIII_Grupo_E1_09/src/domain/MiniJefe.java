package domain;

import java.util.ArrayList;

public class MiniJefe extends Trabajador {
	private int num_empleados;

	public MiniJefe(String nombre, String apellidos, String usuario, String contraseña, int id_clinica,
			ArrayList<Paciente> pacientes, Float sueldo, Especialidades especialidad, String dni, int num_pacientes,
			int num_empleados) {
		super(nombre, apellidos, usuario, contraseña, id_clinica, pacientes, sueldo, especialidad, dni, num_pacientes);
		this.num_empleados = num_empleados;
	}

	public int getNum_empleados() {
		return num_empleados;
	}

	public void setNum_empleados(int num_empleados) {
		this.num_empleados = num_empleados;
	}

	@Override
	public String toString() {
		return "MiniJefe [num_empleados=" + num_empleados + ", getNum_pacientes()=" + getNum_pacientes()
				+ ", toString()=" + super.toString() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getUsuario()=" + getUsuario() + ", getContraseña()="
				+ getContraseña() + ", getClinica()=" + getClinica() + ", getPaciente()=" + getPaciente()
				+ ", getSueldo()=" + getSueldo() + ", getespecialidad()=" + getespecialidad() + "]";
	}

	
}
