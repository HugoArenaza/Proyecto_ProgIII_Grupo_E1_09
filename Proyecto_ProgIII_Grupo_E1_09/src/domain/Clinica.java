package domain;

import java.util.ArrayList;


public class Clinica {
	
	public final static int num_maximo_pacientes=100;
	
	private String calle;
	private int cantidadPacientes;
	private MedicamentosAnimales medicamentos;
	private Trabajador trabajador;
	private MiniJefe jefeVeterinario;
	private int numeroTrabajadores;
	
	protected ArrayList<Paciente> pacientes;
//	protected ArrayList productos;
	protected ArrayList<Proveedor> proveedores;

	
	
	public Clinica(String calle, int cantidadPacientes, MedicamentosAnimales medicamentos, Trabajador trabajador,
		MiniJefe jefeVeterinario, int numeroTrabajadores, ArrayList<Paciente> pacientes,
		ArrayList<Proveedor> proveedores) {
	super();
	this.calle = calle;
	this.cantidadPacientes = cantidadPacientes;
	this.medicamentos = medicamentos;
	this.trabajador = trabajador;
	this.jefeVeterinario = jefeVeterinario;
	this.numeroTrabajadores = numeroTrabajadores;
	this.pacientes = new ArrayList<Paciente>();
		for (Paciente paciente : pacientes) {
			this.pacientes.add(paciente);
		}
	this.proveedores = new ArrayList<Proveedor>();
		for (Proveedor proveedor : proveedores) {
			this.proveedores.add(proveedor);
		}
	}
	public Clinica() {
		super();
		this.calle = "Sin calle asociada";
		
		this.medicamentos = null;
		this.trabajador = null;
		this.jefeVeterinario = null;

		this.pacientes = new ArrayList<Paciente>();
			for (Paciente paciente : pacientes) {
				this.pacientes.add(paciente);
			}
		this.proveedores = new ArrayList<Proveedor>();
			for (Proveedor proveedor : proveedores) {
				this.proveedores.add(proveedor);
			}
		}
	public Clinica(Clinica c) {
		super();
		this.calle = c.calle;
		this.cantidadPacientes = c.cantidadPacientes;
		this.medicamentos = c.medicamentos;
		this.trabajador = c.trabajador;
		this.jefeVeterinario = c.jefeVeterinario;
		this.numeroTrabajadores = c.numeroTrabajadores;
		this.pacientes = new ArrayList<Paciente>();
			for (Paciente paciente : pacientes) {
				this.pacientes.add(paciente);
			}
		this.proveedores = new ArrayList<Proveedor>();
			for (Proveedor proveedor : proveedores) {
				this.proveedores.add(proveedor);
			}
		}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getCantidadPacientes() {
		return cantidadPacientes;
	}
	public void setCantidadPacientes(int cantidadPacientes) {
		this.cantidadPacientes = cantidadPacientes;
	}
	public MedicamentosAnimales getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(MedicamentosAnimales medicamentos) {
		this.medicamentos = medicamentos;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public MiniJefe getJefeVeterinario() {
		return jefeVeterinario;
	}
	public void setJefeVeterinario(MiniJefe jefeVeterinario) {
		this.jefeVeterinario = jefeVeterinario;
	}
	public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}
	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public static int getNumMaximoPacientes() {
		return num_maximo_pacientes;
	}
	@Override
	public String toString() {
		return "Clinica [calle=" + calle + ", cantidadPacientes=" + cantidadPacientes + ", medicamentos=" + medicamentos
				+ ", trabajador=" + trabajador + ", jefeVeterinario=" + jefeVeterinario + ", numeroTrabajadores="
				+ numeroTrabajadores + ", pacientes=" + pacientes + ", proveedores=" + proveedores + "]";
	}
	
	public void admitirPaciente() { //metodo para agregar pacientes si es posible
		if(cantidadPacientes<num_maximo_pacientes) {
			cantidadPacientes++;
		
		}else {
			
		}
	}
	
	
	
	
	
	

}
