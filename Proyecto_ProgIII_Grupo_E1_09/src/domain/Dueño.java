package domain;

public class Dueño {
	private String nombre;
	private String apellidos;
	private String dni;
	private Clinica clinicaAsociada;
	private String direccion;
	private int numeroTlf;
	private String correo;
	private String contraseña;
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
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Clinica getClinicaAsociada() {
		return clinicaAsociada;
	}
	public void setClinicaAsociada(Clinica clinicaAsociada) {
		this.clinicaAsociada = clinicaAsociada;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumeroTlf() {
		return numeroTlf;
	}
	public void setNumeroTlf(int numeroTlf) {
		this.numeroTlf = numeroTlf;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Dueño(String nombre, String apellidos, String dni, Clinica clinicaAsociada, String direccion, int numeroTlf,
			String correo, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.clinicaAsociada = clinicaAsociada;
		this.direccion = direccion;
		this.numeroTlf = numeroTlf;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public Dueño() {
		super();
		this.nombre = "Sin nombre";
		this.apellidos = "Sin apellido";
		this.dni = "Sin dni";
		this.clinicaAsociada = null;
		this.direccion = "Sin Direccion";
		this.numeroTlf = 000;
		this.correo = "Sin correo";
		this.contraseña = "Sin contraseña";
	}
	
	@Override
	public String toString() {
		return "Dueño [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", clinicaAsociada="
				+ clinicaAsociada + ", direccion=" + direccion + ", numeroTlf=" + numeroTlf + ", correo=" + correo
				+ ", contraseña=" + contraseña + "]";
	}
	
	

}
