package modelado;

import modelado.Administrador;
import java.util.Date;

public class Factura {
	
	private Date fecha;
	private float total;
	private int valorOrdinario;
	private int valorExtraordinario;
	private boolean pagado;
	private Administrador administrador;
	
	public void realizarPago() {
		
	}

	public Factura(Date fecha, float total, int valorOrdinario, int valorExtraordinario, boolean pagado) {
		this.fecha = fecha;
		this.total = total;
		this.valorOrdinario = valorOrdinario;
		this.valorExtraordinario = valorExtraordinario;
		this.pagado = pagado;
	}	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getValorOrdinario() {
		return valorOrdinario;
	}

	public void setValorOrdinario(int valorOrdinario) {
		this.valorOrdinario = valorOrdinario;
	}

	public int getValorExtraordinario() {
		return valorExtraordinario;
	}

	public void setValorExtraordinario(int valorExtraordinario) {
		this.valorExtraordinario = valorExtraordinario;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public void mostrarDatos(){
		System.out.println("fecha: "+this.fecha+",total: "+this.total+",valor ord: "+this.valorOrdinario+",valor extraord:"+this.valorExtraordinario+",pagado:"+this.pagado);
	}
}