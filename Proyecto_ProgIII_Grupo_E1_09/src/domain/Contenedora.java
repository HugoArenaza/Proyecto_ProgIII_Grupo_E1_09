package domain;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

//import javax.swing.ListCellRenderer;

public class Contenedora {
	
	
	//La clase clinica debe tener un arrayList de medicamentos.
	// Recomendable hacer que un trabajador no tenga una Clinica en el constructor sino solo el valor de su ID, y acceder desde la clase contenedora mediante un metodo que busque el ID
	
	
	
	
	public ArrayList<Clinica> clinicas;
	public Jefe jefe;
	private static List<Dueño> dueños = new ArrayList<>();
	private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
	private static ArrayList<Cita> listaCitas = new ArrayList<>();
	
	
	
	public List<Dueño> getDueños() {
		return dueños;
	}


	public static void aniadirDueño(Dueño d) {
		dueños.add(d);
	}
	public ArrayList<Cita> getListaCitas(){
		return listaCitas;
	}
	
	public static void aniadirCita(Cita c) {
		listaCitas.add(c);
	}
	
	public static void eliminarCita(Cita c) {
		listaCitas.remove(c);
	}
	
	public static void imprimirListaCitas() {
		System.out.println(listaCitas);
	}
	public ArrayList<Paciente> getListaPacientes(){
		return listaPacientes;
	}
	public static void aniadirPaciente(Paciente p) {
		listaPacientes.add(p);
	} 
	public static void imprimirListaPacientes() {
		System.out.println(listaPacientes);
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
	
	
	public TipoPaciente TipoPacienteaEnum(String s){
		TipoPaciente t = TipoPaciente.valueOf(s);
		return t;
		
	}
	public void GuardarDueñoRegistrado(Dueño d){
		dueños.add(d);
	}
	
	
	public Contenedora() {
		
		
	
		
//	Clinica clinicaPrincipal= new Clinica(1, "Calle Olaguibel", 12,MedicamentosAnimales.AMANTADINA,null,null, 12, null, null);
//	
//	this.clinicas.add(clinicaPrincipal);
//	
//	this.jefe = new Jefe("Mario","Ibañez","jefe@jefefurweel.com", "adad", clinicaPrincipal, null, (float) 10000.0, Especialidades.CIRUGIA, "uahsdudhas2", 12, 2  );
	}


	public String getMascotasPorTipo() {
		List<Paciente> lP = new ArrayList<>();
		
		for (Paciente p: lP) {
			return p.getTipoPaciente().toString();
		}
		return null;
	}



	
	
	




	
	

}

//String nombre, String apellidos, String usuario, String contraseña, Clinica clinica, Paciente paciente,
//Float sueldo, Especialidades especialidad, String dni, int num_pacientes, int id_clinica,
//int num_empleados


//(int id, String calle, int cantidadPacientes, MedicamentosAnimales medicamentos, Trabajador trabajador,
//		MiniJefe jefeVeterinario, int numeroTrabajadores, ArrayList<Paciente> pacientes,
//		ArrayList<Proveedor> proveedores)