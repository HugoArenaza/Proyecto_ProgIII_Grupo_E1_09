package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cita {
	
	private Date fecha_cita;
	private String lugar;
	private String hora;
	private int num_cita;
	
	
	public Cita(Date diaCita, String lugar, String hora, int num_cita) {
		super();
		this.fecha_cita = diaCita;
		this.lugar = lugar;
		this.hora = hora;
		this.num_cita = num_cita;
	}
	
	public Cita() {
		super();
		this.fecha_cita = null;
		this.lugar = "";
		this.hora = null;
		this.num_cita = 0;
	}

	public Date getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	

	public int getNum_cita() {
		return num_cita;
	}

	public void setNum_cita(int num_cita) {
		this.num_cita = num_cita;
	}
	DateFormat sdfDia = new SimpleDateFormat("dd-MM-YYYY");

	@Override
	public String toString() {
		return "Su cita sera el "+ sdfDia.format(fecha_cita)+" a las "+ hora+" en la "+ lugar+" y su numero de cita es el "+ num_cita;
	}
	
}
