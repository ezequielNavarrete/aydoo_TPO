package modelado;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import modelado.TipoExpensa;

public abstract class Gasto {
	
	protected String descripcion;
	protected float monto;
	protected TipoExpensa tipoExpensa;
	private Date vencimiento;
	private int duracionEnMeses;
	
	public Gasto(float monto,String descripcion,TipoExpensa tipoExpensa) {
		this.monto=monto;
		this.descripcion=descripcion;
		this.tipoExpensa=tipoExpensa;
	}
	



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public TipoExpensa getTipoExpensa() {
		return tipoExpensa;
	}

	public void setTipoExpensa(TipoExpensa tipoExpensa) {
		this.tipoExpensa = tipoExpensa;
	}
	
	public String aString() {
		return ("Descripcion: " + this.descripcion + ", tipo expensa: " + this.tipoExpensa + ",monto: " + this.monto );
	}
	
}
