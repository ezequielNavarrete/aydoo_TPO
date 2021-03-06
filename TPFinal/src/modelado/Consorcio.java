package modelado;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import estrategiaCriterio.PagoCompleto;
import modelado.UnidadFuncional;
import modelado.Componente;
import modelado.Gasto;
import modelado.GastoRecurrente;
import modelado.Criterio;
import moduloNotificaciones.Notificacion;

public class Consorcio {
	
	private List<UnidadFuncional> listadoUnidades;
	private Componente cuentaBancaria;
	private Administrador administrador;
	private Notificacion notificacion;

	private ArrayList<GastoComun> listadoDeGastos;
	private ArrayList<GastoRecurrente> listadoGastosRecurrentes;
	
	public Consorcio() {
		
	}
	
	public Consorcio(List<UnidadFuncional> listadoUnidades, Componente cuentaBancaria, ArrayList<GastoComun> listadoDeGastos,
			ArrayList<GastoRecurrente> listadoGastosRecurrentes, Notificacion notificacion) {
		this.listadoGastosRecurrentes=listadoGastosRecurrentes;
		this.listadoUnidades = listadoUnidades;
		this.cuentaBancaria = cuentaBancaria;
		this.listadoDeGastos = listadoDeGastos;
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

	public float conocerSaldo(Componente com1) {
		Criterio c1=new PagoCompleto();
		float saldo=c1.obtencionSaldo(com1);
		return saldo;
	}
	
	
	
	public void LiquidarExpensas(Criterio criterio,ArrayList<UnidadFuncional> listadounidades,float fondoreserva,ArrayList<Gasto> listarecurentes,ArrayList<Gasto> listadocomunes) {
		
		float totalgastos=criterio.calculoDeGastos(listarecurentes)+criterio.calculoDeGastos(listadocomunes);
		
		criterio.divisionDeExpensas(listadounidades, totalgastos, fondoreserva);
		
	}
	
	public void crearGasto(float monto,String descripcion,TipoExpensa tipoExpensa) {
		GastoComun nuevoGasto=new GastoComun(monto,descripcion,tipoExpensa);
		ArrayList<GastoComun> listado=getListadoDeGastos();
		listado.add(nuevoGasto);
	}
	
	public void crearGastoRecurrente(float monto,String descripcion,TipoExpensa tipoExpensa,Date vencimiento,int meses) {
		GastoRecurrente nuevoGasto=new GastoRecurrente(monto,descripcion,tipoExpensa,vencimiento,meses);
		ArrayList<GastoRecurrente> listado=getListadoGastosRecurrentes();
		listado.add(nuevoGasto);
	}
	
	public String conocerAdministrador() {
		return administrador.getNombre();
	}
	
	public float conocerDeuda(UnidadFuncional unidadFuncional) {
		return unidadFuncional.getDeuda();
	}
	
	public void enviarNotificacion(Notificacion notificacion) {
		
	}
	
	public void cargarDatosPruebaGastos() {
		
		GastoComun gasto1=new GastoComun(15,"desc",TipoExpensa.Ordinaria);
		GastoComun otro=new GastoComun(26,"prueba",TipoExpensa.Extraordinaria);
		ArrayList<GastoComun> averhola=new ArrayList<GastoComun>();
		averhola.add(gasto1);
		averhola.add(otro);
		this.listadoDeGastos=averhola;
		
		//GastoRecurrente(float monto, String descripcion, String tipoExpensa,Date vencimiento,int duracionEnMeses) {
		Date fecha=new Date(123,5,15);
		GastoRecurrente primero=new GastoRecurrente(42,"primero",TipoExpensa.GastoParticular,fecha,5);
		GastoRecurrente segundo=new GastoRecurrente(630,"segundo",TipoExpensa.FondoDeReserva,fecha,3);
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
		UnidadFuncional uni3=new UnidadFuncional();
		UnidadFuncional uni4=new UnidadFuncional();
		uni1.setId(5);
		uni2.setId(3);
		uni1.setMetrosCuadrados(50);
		uni1.setPorcentaje((float) 0.05);
		uni2.setMetrosCuadrados(70);
		uni2.setPorcentaje((float) 0.07);
		uni1.setExpensa(153);
		uni2.setExpensa(635);
		uni3.setId(12);
		uni4.setId(8);
		uni3.setMetrosCuadrados(66);
		uni3.setPorcentaje((float) 0.06);
		uni4.setMetrosCuadrados(120);
		uni4.setPorcentaje((float) 0.09);
		uni3.setExpensa(790);
		uni4.setExpensa(1035);
		ArrayList<UnidadFuncional> lisuni=new ArrayList<UnidadFuncional>();
		lisuni.add(uni1);
		lisuni.add(uni2);
		lisuni.add(uni3);
		lisuni.add(uni4);
		this.listadoUnidades=lisuni;
		
}

public void confirmarPagoExpensas() {
	
}
	

}
