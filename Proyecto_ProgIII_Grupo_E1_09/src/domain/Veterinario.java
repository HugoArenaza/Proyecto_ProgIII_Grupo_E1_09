package domain;

import java.util.ArrayList;

public class Veterinario {
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contraseña;
	private String dni;
	private int id_clinica;  					// Cambiar variable a int id_clinica
	private ArrayList<Paciente> pacientes; 		// hacerlo arrayList
	private Float sueldo;
	private Especialidades especialidad;
	
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getClinica() {
		return id_clinica;
	}
	public void setClinica(int clinica) {
		this.id_clinica = clinica;
	}
	public ArrayList<Paciente> getPaciente() {
		return pacientes;
	}
	public void setPaciente(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public Float getSueldo() {
		return sueldo;
	}
	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}
	public Especialidades getespecialidad() {
		return especialidad;
	}
	public void setespecialidad(Especialidades especialidad) {
		this.especialidad = especialidad;
	}
	
	public Veterinario(String nombre, String apellidos, String usuario, String contraseña, int id_clinica,
			ArrayList<Paciente> pacientes, Float sueldo, Especialidades especialidad, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.id_clinica = id_clinica;
		this.pacientes = pacientes;
		this.sueldo = sueldo;
		this.especialidad = especialidad;
		this.dni = dni;
	}
	
	public Veterinario() {
		super();
		this.nombre = "Sin nombre";
		this.apellidos = "Sin apellidos";
		this.usuario = "Sin nombre de usuario";
		this.contraseña = "Sin contraseña";
	
		this.pacientes = null;
		this.sueldo = (float) 0.0;
		this.especialidad = null;
		this.dni = "sin dni";
	}
	
	@Override
	public String toString() {
		return "Veterinario [nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contraseña="
				+ contraseña + ", clinica=" + id_clinica + ", paciente=" + pacientes + ", sueldo=" + sueldo
				+ ", especialidad=" + especialidad + ", dni=" + dni +  "]";
	}
	
}
	
	


