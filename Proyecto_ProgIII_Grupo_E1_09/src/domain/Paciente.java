package domain;

public class Paciente {
	
	
	private int id;
	private String NombrePaciente;
	private int microChip;
	private String enfermedad;
	private int Id_veterinario;
	private TipoPaciente tipoPaciente;
	private Dueño dueño;
	public Paciente(int id, String nombrePaciente, int microChip, String enfermedad, int Id_veterinario,
			TipoPaciente tipoPaciente, Dueño dueño) {
		super();
		this.id = id;
		NombrePaciente = nombrePaciente;
		this.microChip = microChip;
		this.enfermedad = enfermedad;
		this.Id_veterinario = Id_veterinario;
		this.tipoPaciente = tipoPaciente;
		this.dueño = dueño;
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
	public int getId_Veterinario() {
		return Id_veterinario;
	}
	public void setId_Veterinario(int Id_veterinario) {
		this.Id_veterinario = Id_veterinario;
	}
	public TipoPaciente getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(TipoPaciente tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	public Dueño getDueño() {
		return dueño;
	}
	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", NombrePaciente=" + NombrePaciente + ", microChip=" + microChip
				+ ", enfermedad=" + enfermedad + ", Id_veterinario=" + Id_veterinario + ", tipoPaciente=" + tipoPaciente
				+ ", dueño=" + dueño + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
