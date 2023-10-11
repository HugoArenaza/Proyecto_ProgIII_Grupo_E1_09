package domain;

public class Paciente {
	protected static int contador=1;
	
	private int id;
	private String nombreDueño;
	private String dni;
	private int microChip;
	private int telefono;
	private String enfermedad;
	private String direccion;
	private Veterinario veterinario;
	private TipoPaciente tipoPaciente;
	
	public Paciente(int id, String nombreDueño, String dni, int microChip, int telefono, String enfermedad,
			String direccion, Veterinario veterinario) {
		super();
		this.id = contador;
		contador++;
		this.nombreDueño = nombreDueño;
		this.dni = dni;
		this.microChip = microChip;	
		this.telefono = telefono;
		this.enfermedad = enfermedad;
		this.direccion = direccion;
		this.veterinario = veterinario;
	}
	public Paciente() {
		super();
		this.id = contador;
		contador++;
		this.nombreDueño = "Desconocido";
		this.dni = "Desconocido";
		this.enfermedad = "Desconocida";
		this.direccion = "Desconocida";
		this.veterinario = null;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Paciente.contador = contador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreDueño() {
		return nombreDueño;
	}
	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getMicroChip() {
		return microChip;
	}
	public void setMicroChip(int microChip) {
		this.microChip = microChip;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombreDueño=" + nombreDueño + ", dni=" + dni + ", microChip=" + microChip
				+ ", telefono=" + telefono + ", enfermedad=" + enfermedad + ", direccion=" + direccion
				+ ", veterinario=" + veterinario + "]";
	}
	
	
	
	
	
	
	
	

}
