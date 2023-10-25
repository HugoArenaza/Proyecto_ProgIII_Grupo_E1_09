package domain;

public class ProveedorMaterialQuirurjico {
	private TipoMaterialQuirurjico tipoMaterialQuirurjico;
	private String correo;
	private int num_contacto;
	
	public TipoMaterialQuirurjico getTipoMaterialQuirurjico() {
		return tipoMaterialQuirurjico;
	}
	public void setTipoMaterialQuirurjico(TipoMaterialQuirurjico tipoMaterialQuirurjico) {
		this.tipoMaterialQuirurjico = tipoMaterialQuirurjico;
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
	public ProveedorMaterialQuirurjico(TipoMaterialQuirurjico tipoMaterialQuirurjico, String correo, int num_contacto) {
		super();
		this.tipoMaterialQuirurjico = tipoMaterialQuirurjico;
		this.correo = correo;
		this.num_contacto = num_contacto;
	}
	
	public ProveedorMaterialQuirurjico() {
		super();
		this.tipoMaterialQuirurjico = null;
		this.correo = "Sin correo";
		this.num_contacto = 0;
	}
	
	

}
