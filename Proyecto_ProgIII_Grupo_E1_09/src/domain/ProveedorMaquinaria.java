package domain;

public class ProveedorMaquinaria {
	private TipoMaquinaria tipoMaquinaria;
	private String correo;
	private int num_contacto;
	
	public TipoMaquinaria getTipoMaquinaria() {
		return tipoMaquinaria;
	}
	public void setTipoMaquinaria(TipoMaquinaria tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getNum_contacto() {
		return num_contacto;
	}
	public void setNum_contacto(int num_contacto) {
		this.num_contacto = num_contacto;
	}
	public ProveedorMaquinaria(TipoMaquinaria tipoMaquinaria, String correo, int num_contacto) {
		super();
		this.tipoMaquinaria = tipoMaquinaria;
		this.correo = correo;
		this.num_contacto = num_contacto;
	}
	
	public ProveedorMaquinaria() {
		super();
		this.tipoMaquinaria = null;
		this.correo = "Sin correo";
		this.num_contacto = 0;
	}
	@Override
	public String toString() {
		return "ProveedorMaquinaria [tipoMaquinaria=" + tipoMaquinaria + ", correo=" + correo + ", num_contacto="
				+ num_contacto + "]";
	}
	
	
	

}
