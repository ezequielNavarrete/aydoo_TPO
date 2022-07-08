package modelado;

import java.util.Date;

public class GastoRecurrente extends Gasto{
	
	private Date vencimiento;
	private int duracionEnMeses;

	
	public GastoRecurrente(float monto, String descripcion, String tipoExpensa,Date vencimiento,int duracionEnMeses) {
		super(monto, descripcion, tipoExpensa);
		this.vencimiento=vencimiento;
		this.duracionEnMeses=duracionEnMeses;
	}
	
	

	public String aStringRecurrente() {
		//		return nombre + "( " + legajo + " )";
		return ("Descripcion: " + this.descripcion + ", tipo expensa: " + this.tipoExpensa + ", monto: " + this.monto + ", vencimiento: " 
				+ "( " + this.vencimiento + " ) " + ", Duracion: "  +   "( " + this.duracionEnMeses + " ) " );
	}

}
