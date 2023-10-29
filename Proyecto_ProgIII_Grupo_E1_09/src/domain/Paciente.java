package domain;

public class Paciente extends Dueño{
	protected static int contador=1;
	
	private int id;
	private String NombrePaciente;
	private int microChip;
	private String enfermedad;
	private Veterinario veterinario;
	private TipoPaciente tipoPaciente;
	public Paciente(String NombreDueño, String apellidos, String dni, Clinica clinicaAsociada, String direccion,
			int numeroTlf, String correo, String contraseña, int id, String nombrePaciente, int microChip,
			String enfermedad, Veterinario veterinario, TipoPaciente tipoPaciente) {
		super(NombreDueño, apellidos, dni, clinicaAsociada, direccion, numeroTlf, correo, contraseña);
		this.id = contador;
		contador++;
		NombrePaciente = nombrePaciente;
		this.microChip = microChip;
		this.enfermedad = enfermedad;
		this.veterinario = veterinario;
		this.tipoPaciente = tipoPaciente;
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
	public String getNombrePaciente() {
		return NombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		NombrePaciente = nombrePaciente;
	}
	public int getMicroChip() {
		return microChip;
	}
	public void setMicroChip(int microChip) {
		this.microChip = microChip;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", NombrePaciente=" + NombrePaciente + ", microChip=" + microChip
				+ ", enfermedad=" + enfermedad + ", veterinario=" + veterinario + ", tipoPaciente=" + tipoPaciente
				+ ", getNombreDueño()=" + getNombreDueño() + ", getApellidos()=" + getApellidos() + ", getDni()="
				+ getDni() + ", getClinicaAsociada()=" + getClinicaAsociada() + ", getDireccion()=" + getDireccion()
				+ ", getNumeroTlf()=" + getNumeroTlf() + ", getCorreo()=" + getCorreo() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
