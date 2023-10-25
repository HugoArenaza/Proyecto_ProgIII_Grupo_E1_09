package domain;

public class Veterinario {
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contraseña;
	private Clinica clinica;
	private Paciente paciente;
	private Float sueldo;
	private Especialidades especailidad;
	
	
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
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Float getSueldo() {
		return sueldo;
	}
	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}
	public Especialidades getEspecailidad() {
		return especailidad;
	}
	public void setEspecailidad(Especialidades especailidad) {
		this.especailidad = especailidad;
	}
	
	public Veterinario(String nombre, String apellidos, String usuario, String contraseña, Clinica clinica,
			Paciente paciente, Float sueldo, Especialidades especailidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.clinica = clinica;
		this.paciente = paciente;
		this.sueldo = sueldo;
		this.especailidad = especailidad;
	}
	
	public Veterinario() {
		super();
		this.nombre = "Sin nombre";
		this.apellidos = "Sin apellidos";
		this.usuario = "Sin nombre de usuario";
		this.contraseña = "Sin contraseña";
		this.clinica = null;
		this.paciente = null;
		this.sueldo = (float) 0.0;
		this.especailidad = null;
	}
	
	@Override
	public String toString() {
		return "Veterinario [nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contraseña="
				+ contraseña + ", clinica=" + clinica + ", paciente=" + paciente + ", sueldo=" + sueldo
				+ ", especailidad=" + especailidad + "]";
	}
	
	
	

}
