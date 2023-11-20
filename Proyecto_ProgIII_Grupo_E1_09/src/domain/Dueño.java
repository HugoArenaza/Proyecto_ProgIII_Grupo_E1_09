package domain;

public class Dueño {
	private String NombreDueño;
	private String apellidos;
	private String dni;
	private Clinica clinicaAsociada;
	private String fNac;
	private int numeroTlf;
	private String correo;
	private String contraseña;
	
	
	public String getNombreDueño() {
		return NombreDueño;
	}
	public void setNombreDueño(String NombreDueño) {
		this.NombreDueño = NombreDueño;
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
	public String getfNac() {
		return fNac;
	}
	public void setDireccion(String fNac) {
		this.fNac = fNac;
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
	
	public Dueño(String NombreDueño, String apellidos, String dni, Clinica clinicaAsociada, String fNac, int numeroTlf,
			String correo, String contraseña) {
		super();
		this.NombreDueño = NombreDueño;
		this.apellidos = apellidos;
		this.dni = dni;
		this.clinicaAsociada = clinicaAsociada;
		this.fNac = fNac;
		this.numeroTlf = numeroTlf;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public Dueño() {
		super();
		this.NombreDueño = "Sin NombreDueño";
		this.apellidos = "Sin apellido";
		this.dni = "Sin dni";
		this.clinicaAsociada = null;
		this.fNac = "01-01-1970";
		this.numeroTlf = 000;
		this.correo = "Sin correo";
		this.contraseña = "Sin contraseña";
	}
	
	@Override
	public String toString() {
		return "Dueño [NombreDueño=" + NombreDueño + ", apellidos=" + apellidos + ", dni=" + dni + ", clinicaAsociada="
				+ clinicaAsociada + ", direccion=" + fNac + ", numeroTlf=" + numeroTlf + ", correo=" + correo
				+ ", contraseña=" + contraseña + "]";
	}
	
	

}
