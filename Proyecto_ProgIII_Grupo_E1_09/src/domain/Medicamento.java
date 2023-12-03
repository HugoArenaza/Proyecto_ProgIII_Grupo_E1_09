package domain;

public class Medicamento {
	private String nombreMedicamento;
	private int id;
	private double precioMedicamento;
	
	
	public Medicamento(String nombreMedicamento,int id ,double precioMedicamento) {
		super();
		this.nombreMedicamento = nombreMedicamento;
		this.precioMedicamento = precioMedicamento;
		this.id = id;
	}
	
	public Medicamento() {
		super();
		this.nombreMedicamento = "";
		this.id = 0;
		this.precioMedicamento = 0.0;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public double getPrecioMedicamento() {
		return precioMedicamento;
	}

	public void setPrecioMedicamento(double precioMedicamento) {
		this.precioMedicamento = precioMedicamento;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", id=" + id + ", precioMedicamento="
				+ precioMedicamento + "]";
	}

	
	

}
