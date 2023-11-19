package ventanas;

import java.util.Arrays;
import java.util.List;

//import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import domain.MedicamentosAnimales;

public class ModeloMedicamentos extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> titulos = Arrays.asList("ID","Nombre");
	
	public ModeloMedicamentos() {
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return super.getRowCount();
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
		MedicamentosAnimales medicamento = MedicamentosAnimales.values()[row];
		switch(column) {
		case 0: 
			return medicamento.ordinal();
		case 1:
			return medicamento.name();
		default:
			return null;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		super.setValueAt(aValue, row, column);
	}
	
	
	
	

	
	
	
	

}
