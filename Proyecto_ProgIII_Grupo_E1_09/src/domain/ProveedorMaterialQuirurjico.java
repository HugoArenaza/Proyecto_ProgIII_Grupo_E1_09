package domain;

public class ProveedorMaterialQuirurjico extends Proveedor {
	private TipoMaterialQuirurjico tipoMaterialQuirurjico;

	public ProveedorMaterialQuirurjico(String correo, int num_contacto, TipoMaterialQuirurjico tipoMaterialQuirurjico) {
		super(correo, num_contacto);
		this.tipoMaterialQuirurjico = tipoMaterialQuirurjico;
	}

	public TipoMaterialQuirurjico getTipoMaterialQuirurjico() {
		return tipoMaterialQuirurjico;
	}

	public void setTipoMaterialQuirurjico(TipoMaterialQuirurjico tipoMaterialQuirurjico) {
		this.tipoMaterialQuirurjico = tipoMaterialQuirurjico;
	}

	@Override
	public String toString() {
		return "ProveedorMaterialQuirurjico [tipoMaterialQuirurjico=" + tipoMaterialQuirurjico + ", getCorreo()="
				+ getCorreo() + ", getNum_contacto()=" + getNum_contacto() + "]";
	}

	
	
	
	
	


}
