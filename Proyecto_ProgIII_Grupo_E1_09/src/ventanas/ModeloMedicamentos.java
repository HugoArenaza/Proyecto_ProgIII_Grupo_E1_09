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
	private List<MedicamentosAnimales> lMedicamentos;
	private List<String> titulos = Arrays.asList("ID","Nombre");
	
	
	public ModeloMedicamentos(List<MedicamentosAnimales> lMedicamentos) {
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
		if(column == 0) {
			return lMedicamentos.get(row);
		}
		return null;
	}
	
	
	
	
	

	
	
	
	

}
