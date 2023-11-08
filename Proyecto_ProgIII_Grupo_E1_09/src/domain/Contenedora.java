package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contenedora {
	
	
	//La clase clinica debe tener un arrayList de medicamentos.
	// Recomendable hacer que un trabajador no tenga una Clinica en el constructor sino solo el valor de su ID, y acceder desde la clase contenedora mediante un metodo que busque el ID
	
	
	
	
	public ArrayList<Clinica> clinicas;
	public Jefe jefe;
	private static List<Dueño> dueños = new ArrayList<>();
	
	
	
	public List<Dueño> getDueños() {
		return dueños;
	}


	public static void aniadirDueño(Dueño d) {
		dueños.add(d);
	}
	
	
	public static Dueño buscarCliente(String dni) {
		boolean dueñoEncontrado = false;
		int pos = 0;
		Dueño d = null;
		while(!dueñoEncontrado && pos<dueños.size()) {
			d = dueños.get(pos);
			if(d.getDni().equals(dni)) {
				dueñoEncontrado = true;
			}else {
				pos++;
			}
		}
		if(dueñoEncontrado) {
			return d;
		}else{
			return null;
		}
	}
	
	
	
	
	
	public Contenedora() {
		
		
	
		
//	Clinica clinicaPrincipal= new Clinica(1, "Calle Olaguibel", 12,MedicamentosAnimales.AMANTADINA,null,null, 12, null, null);
//	
//	this.clinicas.add(clinicaPrincipal);
//	
//	this.jefe = new Jefe("Mario","Ibañez","jefe@jefefurweel.com", "adad", clinicaPrincipal, null, (float) 10000.0, Especialidades.CIRUGIA, "uahsdudhas2", 12, 2  );
	}
	
	
	




	
	

}

//String nombre, String apellidos, String usuario, String contraseña, Clinica clinica, Paciente paciente,
//Float sueldo, Especialidades especialidad, String dni, int num_pacientes, int id_clinica,
//int num_empleados


//(int id, String calle, int cantidadPacientes, MedicamentosAnimales medicamentos, Trabajador trabajador,
//		MiniJefe jefeVeterinario, int numeroTrabajadores, ArrayList<Paciente> pacientes,
//		ArrayList<Proveedor> proveedores)