package domain;

import java.util.ArrayList;

public class Jefe extends MiniJefe {

	public Jefe(int Id, String nombre, String apellidos, String usuario, String contraseña, int id_clinica,
			ArrayList<Paciente> pacientes, Float sueldo, Especialidades especialidad, String dni, int num_pacientes,
			int num_empleados) {
		super(Id, nombre, apellidos, usuario, contraseña, id_clinica, pacientes, sueldo, especialidad, dni, num_pacientes,
				num_empleados);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String toString() {
		return "Jefe [getNum_empleados()=" + getNum_empleados() + ", toString()=" + super.toString()
        + ", getNum_pacientes()=" + getNum_pacientes() + ", getDni()=" + getDni() + ", getNombre()="
        + getNombre() + ", getApellidos()=" + getApellidos() + ", getUsuario()=" + getUsuario()
        + ", getContraseña()=" + getContraseña() + ", getClinica()=" + getClinica() + ", getPaciente()="
        + getPaciente() + ", getSueldo()=" + getSueldo() + ", getespecialidad()=" + getespecialidad() + "]";
	}
	
	
	


	
	

}
