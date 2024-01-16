package ventanas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Compra;
import domain.Paciente;

public class ModeloHistorialCompras extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> titulos = Arrays.asList("NOMBRE DEL MEDICAMENTO","ID" ,"PRECIO", "FECHA DE COMPRA", "MASCOTA ASOCIADA");
	private List<Compra> lCompras;
	
	
	public ModeloHistorialCompras(List<Compra> lc) {
		lCompras = new ArrayList<>(lc); 
	}
	

	@Override
	public int getRowCount() {
		if(lCompras == null) 
			return 0;
		return lCompras.size();
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
		Compra c = lCompras.get(row); 
		switch (column) {
			case 0: return c.getNombreMedicamento();
			case 1: return c.getId();
			case 2: return c.getPrecio();
			case 3: return c.getFechaDeCompra();
			case 4: return c.getPaciente();
	
		default: return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		
		super.setValueAt(aValue, row, column);
	}
	


}
