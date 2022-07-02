package modelado;
import java.util.List;

import modelado.UnidadFuncional;
import modelado.Componente;
import modelado.Gasto;
import modelado.Criterio;
import moduloNotificaciones.Notificacion;

public class Consorcio {
	
	private List<UnidadFuncional> listadoUnidades;
	private Componente cuentaBancaria;
	private List<Gasto> listadoDeGastos;
	private Criterio criterio;
	private Notificacion notificacion;
	
	
	
	public Consorcio(List<UnidadFuncional> listadoUnidades, Componente cuentaBancaria, List<Gasto> listadoDeGastos,
			Criterio criterio, Notificacion notificacion) {
		this.listadoUnidades = listadoUnidades;
		this.cuentaBancaria = cuentaBancaria;
		this.listadoDeGastos = listadoDeGastos;
		this.criterio = criterio;
		this.notificacion = notificacion;
	}

	public float conocerSaldo() {
		return 0;
	}
	
	public void cargarGastosRecurrentes() {
		
	}
	
	public void cargarGastosComunes() {
		
	}
	
	public void confirmarPagoExpensas() {
		
	}
	
	public float generarPagoUnidadFuncional(Criterio criterio) {
		return  0;
	}
	
	public String conocerAdministrador() {
		return null;
	}
	
	public float conocerDeuda(UnidadFuncional unidadFuncional) {
		return 0;
	}
	
	public float conocerPagos(UnidadFuncional unidadFuncional) {
		return 0;
	}
	
	public void generarExpensas(UnidadFuncional unidadFuncional) {
		
	}
	
	public void enviarNotificacion(Notificacion notificacion) {
		
	}
	
}
