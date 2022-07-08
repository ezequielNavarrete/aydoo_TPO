package modelado;

import java.util.Date;

public class GastoComun extends Gasto{

	
	public GastoComun(float monto, String descripcion, String tipoExpensa) {
		super(monto, descripcion, tipoExpensa);
	}
	
	

	public String aStringComun() {
		//		return nombre + "( " + legajo + " )";
		return ("Descripcion: " + this.descripcion + ", tipo expensa: " + this.tipoExpensa + ", monto: " + this.monto );
	}

}
