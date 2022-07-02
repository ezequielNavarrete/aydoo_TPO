package modelado;
import modelado.Persona;

import java.util.List;

import modelado.Factura;

public class UnidadFuncional {
	
	private int metrosCuadrados;
	private float porcentaje;
	private List<Persona> listadoPropietarios;
	private List<Factura> listadoPagos;
	private List<Persona> ListadoInquilinos;
	
	public float getDeuda() {
		return 0;
	}

}
