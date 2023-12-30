package domain;

import java.util.Date;

public class Compra {
	private String nombreMedicamento;
	private int id;
	private Double precio;
	private Date fechaDeCompra;
	private Paciente paciente;
	
	
	public Compra(String nombreMedicamento, Double precio, int id, Date fechaDeCompra, Paciente paciente) {
		super();
		this.nombreMedicamento = nombreMedicamento;
		this.precio = precio;
		this.id = id;
		this.fechaDeCompra = fechaDeCompra;
		this.paciente = paciente;
	}
	
	public Compra() {
		super();
		this.nombreMedicamento = "";
		this.precio = 0.0;
		this.id = 0;
		this.fechaDeCompra = new Date();
		this.paciente = null;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Compra [nombreMedicamento=" + nombreMedicamento + ", id=" + id + ", precio=" + precio
				+ ", fechaDeCompra=" + fechaDeCompra + ", paciente=" + paciente + "]";
	}

	
	
	
	

}
