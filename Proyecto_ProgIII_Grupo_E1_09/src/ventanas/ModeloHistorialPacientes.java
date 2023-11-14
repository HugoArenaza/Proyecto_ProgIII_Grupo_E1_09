package ventanas;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Paciente;

public class ModeloHistorialPacientes extends DefaultTableModel{
	private List<String> titulos = Arrays.asList("NOMBRE MASCOTA", "MICROCHIP", "TIPO MASCOTA", "ENFERMEDAD", "RESOLUCION DE ENFERMEDAD");
	private List<Paciente> lPacientes;
	
	
	public ModeloHistorialPacientes(List<Paciente> lp) {
		lPacientes = lp;
	}
	

	@Override
	public int getRowCount() {
		if(lPacientes == null) 
			return 0;
		return lPacientes.size();
	}
	
	

	@Override
	public int getColumnCount() {
		return titulos.size();
	}

	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Paciente p = lPacientes.get(row); 
		switch (column) {
			case 0: return p.getNombrePaciente();
			case 1: return p.getMicroChip();
			case 2: return p.getTipoPaciente();
			case 3: return p.getEnfermedad();
	
		default: return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		
		super.setValueAt(aValue, row, column);
	}
	


}
