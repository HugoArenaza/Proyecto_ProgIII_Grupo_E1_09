package domain;

public class Proveedor {
	private String correo;
	private int num_contacto;
	
	
	public Proveedor(String correo, int num_contacto) {
		super();
		this.correo = correo;
		this.num_contacto = num_contacto;
	}

	public Proveedor() {
		super();
		this.correo = "Sin correo asociado";
		
	}
	public Proveedor(Proveedor objProveedor) {
		super();
		this.correo =objProveedor.correo;
		this.num_contacto = objProveedor.num_contacto;
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


	@Override
	public String toString() {
		return correo  + ", " +num_contacto ;
	}
	

}
