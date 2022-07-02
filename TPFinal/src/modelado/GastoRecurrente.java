package modelado;

import java.util.Date;

public class GastoRecurrente extends Gasto{
	
	
	public GastoRecurrente(float monto, String descripcion, String tipoExpensa,Date vencimiento,int duracionEnMeses) {
		super(monto, descripcion, tipoExpensa);
	}
	
	private Date vencimiento;
	private int duracionEnMeses;

}
