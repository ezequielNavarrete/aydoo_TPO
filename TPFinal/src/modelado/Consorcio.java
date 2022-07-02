package modelado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelado.UnidadFuncional;
import modelado.Componente;
import modelado.Gasto;
import modelado.GastoRecurrente;
import modelado.Criterio;
import moduloNotificaciones.Notificacion;

public class Consorcio {
	
	private List<UnidadFuncional> listadoUnidades;
	private Componente cuentaBancaria;
	private Criterio criterio;
	private Notificacion notificacion;

	private ArrayList<GastoComun> listadoDeGastos;
	private ArrayList<GastoRecurrente> listadoGastosRecurrentes;
	
	public Consorcio() {
		
	}
	
	public Consorcio(List<UnidadFuncional> listadoUnidades, Componente cuentaBancaria, ArrayList<GastoComun> listadoDeGastos,
			ArrayList<GastoRecurrente> listadoGastosRecurrentes,Criterio criterio, Notificacion notificacion) {
		this.listadoGastosRecurrentes=listadoGastosRecurrentes;
		this.listadoUnidades = listadoUnidades;
		this.cuentaBancaria = cuentaBancaria;
		this.listadoDeGastos = listadoDeGastos;
		this.criterio = criterio;
		this.notificacion = notificacion;
	}
	
	

	public ArrayList<GastoComun> getListadoDeGastos() {
		return this.listadoDeGastos;
	}

	public ArrayList<GastoRecurrente> getListadoGastosRecurrentes() {
		return this.listadoGastosRecurrentes;
	}

	public void setListadoDeGastos(ArrayList<GastoComun> listadoDeGastos) {
		this.listadoDeGastos = listadoDeGastos;
	}



	public void setListadoGastosRecurrentes(ArrayList<GastoRecurrente> listadoGastosRecurrentes) {
		this.listadoGastosRecurrentes = listadoGastosRecurrentes;
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
	
	public void cargarDatosPruebaGastos() {
		
		GastoComun gasto1=new GastoComun(15,"desc","generico");
		GastoComun otro=new GastoComun(27,"prueba","otro");
		ArrayList<GastoComun> averhola=new ArrayList<GastoComun>();
		averhola.add(gasto1);
		averhola.add(otro);
		this.listadoDeGastos=averhola;
		
		//GastoRecurrente(float monto, String descripcion, String tipoExpensa,Date vencimiento,int duracionEnMeses) {
		Date fecha=new Date(123,5,15);
		GastoRecurrente primero=new GastoRecurrente(42,"primero","tipo",fecha,5);
		GastoRecurrente segundo=new GastoRecurrente(630,"segundo","abc",fecha,3);
		ArrayList<GastoRecurrente> listagasrec=new ArrayList<GastoRecurrente>();
		listagasrec.add(primero);
		listagasrec.add(segundo);
		this.listadoGastosRecurrentes=listagasrec;
	}
	
	
}
