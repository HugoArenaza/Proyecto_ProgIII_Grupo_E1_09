package ventanas;

import java.util.Arrays;
import java.util.List;

//import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import domain.Medicamento;




public class ModeloMedicamentosVentanaDueño extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Medicamento> lMedicamentos;
	private List<String> titulos = Arrays.asList("Nombre Medicamento", "ID","Precio");
	
	
	public ModeloMedicamentosVentanaDueño(List<Medicamento> lMedicamentos) {
		this.lMedicamentos = lMedicamentos;
	}
	
	
	@Override
	public int getRowCount() {
		if(lMedicamentos == null) {
			return 0;
		}return lMedicamentos.size();
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
		return false;
	}
	

	@Override
	public Object getValueAt(int row, int column) {
		Medicamento m = lMedicamentos.get(row);
		switch (column) {
		case 0: return m.getNombreMedicamento();
		case 1: return m.getId();
		case 2: return m.getPrecioMedicamento();
		default: return null;
		}
		
		
		
	}
	
	
	
	public void setValueAt(Object aValue, int row, int column) {
		
		super.setValueAt(aValue, row, column);
	}
	
	
	

	
	
	
	

}
