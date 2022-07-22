package modelado;

import java.util.Date;
import adapters.AdapterComponente;

public class Componente {
	
	private int CBU;
	private String Alias;
	private Date fecha;
	private int tokenSeguridad;
	protected float saldo;
	
	private AdapterComponente adapter;
	
	
	//Para hacer las pruebas
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float devolverSaldo() {
		return this.saldo;
	}
	
	
}
