package domain;

public class Clinica {
	private String calle;
	private int num_max_clientes;
	private MedicamentosAnimales medicamentos;
	private Trabajador trabajador;
	private MiniJefe jefeVeterinario;
	private int numeroTrabajadores;
	
	
	public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}
	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNum_max_clientes() {
		return num_max_clientes;
	}
	public void setNum_max_clientes(int num_max_clientes) {
		this.num_max_clientes = num_max_clientes;
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
	
	public Clinica(String calle, int num_max_clientes, MedicamentosAnimales medicamentos, Trabajador trabajador,
			MiniJefe jefeVeterinario, int numeroTrabajadores) {
		super();
		this.calle = calle;
		this.num_max_clientes = num_max_clientes;
		this.medicamentos = medicamentos;
		this.trabajador = trabajador;
		this.jefeVeterinario = jefeVeterinario;
		this.numeroTrabajadores = numeroTrabajadores;
	}
	
	public Clinica() {
		super();
		this.calle = "Sin calle";
		this.num_max_clientes = 0;
		this.medicamentos = null;
		this.trabajador = null;
		this.jefeVeterinario = null;
		this.numeroTrabajadores = 0;
	}
	
	@Override
	public String toString() {
		return "Clinica [calle=" + calle + ", num_max_clientes=" + num_max_clientes + ", medicamentos=" + medicamentos
				+ ", trabajador=" + trabajador + ", jefeVeterinario=" + jefeVeterinario + ", numeroTrabajadores=" + numeroTrabajadores + "]";
	}
	

}
