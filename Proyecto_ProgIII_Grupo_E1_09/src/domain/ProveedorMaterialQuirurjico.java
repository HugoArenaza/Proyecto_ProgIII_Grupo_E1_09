package domain;

public class ProveedorMaterialQuirurjico extends Proveedor {
	private TipoMaterialQuirurjico tipoMaterialQuirurjico;
	
	/*BISTURI,
    TIJERAS_DE_CIRUGIA,
    PINZAS,
    JERINGAS_Y_AGUJAS,
    GUANTES_QUIRURGICOS,
    MASCARILLAS_Y_GAFAS_DE_PROTECCION,
    CAMPO_QUIRURGICO,
    GASAS_Y_COMPRESAS,
    SUTURAS_Y_MATERIAL_DE_LIGADURA,
    TUBOS_ENDOTRAQUEALES,
    CANULAS_DE_TRAQUEOTOMIA,
    ELECTROBISTURI,
    AGUJAS_DE_BIOPSIA,
    PORTAAGUJAS,
    HOJAS_DE_SCALPEL,
    INSTRUMENTAL_DE_CIRUGIA_LAPAROSCOPICA,
    DRENAJES_QUIRURGICOS,
    BOLSAS_DE_ESTERILIZACION,
    CANULAS_INTRAVENOSAS_IV,
    VENDAS_Y_APOSITOS
	 */
	
	
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
