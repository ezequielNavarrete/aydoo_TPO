package modelado;

import java.util.Date;

public class Componente {
	
	private int CBU;
	private String Alias;
	private Date fecha;
	private int tokenSeguridad;
	protected float saldo;
	
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float devolverSaldo() {
		return saldo;
	}
	
	
}
