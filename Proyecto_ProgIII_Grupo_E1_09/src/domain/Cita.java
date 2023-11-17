package domain;

import java.text.SimpleDateFormat;

public class Cita {
	
	private SimpleDateFormat fecha_cita;

	public Cita(SimpleDateFormat fecha_cita) {
		super();
		this.fecha_cita = fecha_cita;
	}

	public Cita() {
		super();
	}
	
	public SimpleDateFormat getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(SimpleDateFormat fecha_cita) {
		this.fecha_cita = fecha_cita;
	}
	
	@Override
	public String toString() {
		return "Cita [fecha_cita=" + fecha_cita + "]";
	}
}
