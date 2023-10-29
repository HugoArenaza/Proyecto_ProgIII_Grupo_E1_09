package domain;

public class ProveedorMaquinaria extends Proveedor {
	private TipoMaquinaria tipoMaquinaria;

	public ProveedorMaquinaria(String correo, int num_contacto, TipoMaquinaria tipoMaquinaria) {
		super(correo, num_contacto);
		this.tipoMaquinaria = tipoMaquinaria;
	}

	public TipoMaquinaria getTipoMaquinaria() {
		return tipoMaquinaria;
	}

	public void setTipoMaquinaria(TipoMaquinaria tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}

	@Override
	public String toString() {
		return "ProveedorMaquinaria [tipoMaquinaria=" + tipoMaquinaria + ", getCorreo()=" + getCorreo()
				+ ", getNum_contacto()=" + getNum_contacto() + "]";
	}

	
}
