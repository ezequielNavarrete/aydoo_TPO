package modelado;

import java.util.Enumeration;
import java.util.List;

import modelado.TipoExpensa;

public class Gasto {
	
	private String descripcion;
	private float monto;
	private String tipoExpensa;
	
	public Gasto(float monto,String descripcion,String tipoExpensa) {
		this.monto=monto;
		this.descripcion=descripcion;
		this.tipoExpensa=tipoExpensa;
	}
	/*
	public List<Gasto> getAllGastos(){	
		Enumeration<Gasto> gastostodos=Gasto.get;
	}
	*/
	
}
