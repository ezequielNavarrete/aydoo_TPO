package modelado;
import modelado.Persona;

import java.util.List;

import modelado.Factura;

public class UnidadFuncional {
	
	private int metrosCuadrados;
	private float porcentaje;
	private float deuda;
	private List<Persona> listadoPropietarios;
	private List<Factura> listadoPagos;
	private List<Persona> ListadoInquilinos;
	
	public UnidadFuncional(int metrosCuadrados, float porcentaje)
    {
		this.metrosCuadrados = metrosCuadrados;
        this.porcentaje = porcentaje ;
        
    }
	
	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	
	public float getDeuda() {
		return deuda;
	}
	
	public float getPorcentaje() {
		return porcentaje;
	}

}
