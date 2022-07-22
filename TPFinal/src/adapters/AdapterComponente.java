package adapters;

import java.util.Date;

import adapters.IAdapterComponente;

public class AdapterComponente implements IAdapterComponente {

	private float saldo;
	public float devolverSaldo(Date fecha, int tokenSeguridad) {
		return this.saldo;
	}

}
