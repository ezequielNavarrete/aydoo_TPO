package modelado;
import java.text.SimpleDateFormat;
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
		
		GastoComun gasto1=new GastoComun(15,"desc","Ordinaria");
		GastoComun otro=new GastoComun(26,"prueba","Extraordinaria");
		ArrayList<GastoComun> averhola=new ArrayList<GastoComun>();
		averhola.add(gasto1);
		averhola.add(otro);
		this.listadoDeGastos=averhola;
		
		//GastoRecurrente(float monto, String descripcion, String tipoExpensa,Date vencimiento,int duracionEnMeses) {
		Date fecha=new Date(123,5,15);
		GastoRecurrente primero=new GastoRecurrente(42,"primero","GastoParticular",fecha,5);
		GastoRecurrente segundo=new GastoRecurrente(630,"segundo","FondoDeReserva",fecha,3);
		ArrayList<GastoRecurrente> listagasrec=new ArrayList<GastoRecurrente>();
		listagasrec.add(primero);
		listagasrec.add(segundo);
		this.listadoGastosRecurrentes=listagasrec;
	}

	public UnidadFuncional getUnidadFuncional(int id) {
		List<UnidadFuncional> lista=this.getListadoUnidades();
		while (!lista.isEmpty()) {
			UnidadFuncional primera=lista.get(0);
			if (primera.getId()==id) {
				return primera;
			}
			lista.remove(0);
		}
		return null;
	}

	public List<UnidadFuncional> getListadoUnidades() {
		return listadoUnidades;
	}

	public void setListadoUnidades(List<UnidadFuncional> listadoUnidades) {
		this.listadoUnidades = listadoUnidades;
	}

	public Componente getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(Componente cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}
	public void getTrazabilidad(UnidadFuncional unidadFuncional, String mes) {
		String month=new String();
		switch(mes){
			case "enero":
				month="Jan";
				break;
			case "febrero":
				month="Feb";
				break;
			case "marzo":
				month="Mar";
				break;
			case "abril":
				month="Apr";
				break;
			case "mayo":
				month="May";
				break;
			case "junio":
				month="Jun";
				break;
			case "julio":
				month="Jul";
				break;
			case "agosto":
				month="Aug";
				break;
			case "septiembre":
				month="Sep";
				break;
			case "octubre":
				month="Oct";
				break;
			case "noviembre":
				month="Nov";
				break;
			case "diciembre":
				month="Dec";
				break;	
		}
		for (Factura factura : unidadFuncional.getListadoPagos()){
			if (factura.getFecha().toString().contains(month)){
				factura.mostrarDatos();
			}
		}
		 
	}

public void cargarDatosPruebaUnidadFuncional() {
		
		UnidadFuncional uni1=new UnidadFuncional();
		UnidadFuncional uni2=new UnidadFuncional();
		uni1.setId(5);
		uni2.setId(3);
		uni1.setMetrosCuadrados(50);
		uni1.setPorcentaje((float) 0.05);
		uni2.setMetrosCuadrados(70);
		uni2.setPorcentaje((float) 0.07);
		uni1.setExpensa(153);
		uni2.setExpensa(635);
		ArrayList<UnidadFuncional> lisuni=new ArrayList<UnidadFuncional>();
		lisuni.add(uni1);
		lisuni.add(uni2);
		this.listadoUnidades=lisuni;
		
}
	

}
