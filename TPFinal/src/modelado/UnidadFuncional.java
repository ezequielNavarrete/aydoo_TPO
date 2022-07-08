package modelado;
import modelado.Persona;

import java.util.List;

import modelado.Factura;

public class UnidadFuncional {
	
	private int id;
	private int metrosCuadrados;
	private float porcentaje;
	private float deuda;
	private float expensa;
	private List<Persona> listadoPropietarios;
	private List<Factura> listadoPagos;
	private List<Persona> ListadoInquilinos;
	
	public UnidadFuncional() {
		
	}
	
	public UnidadFuncional(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	
	public float getDeuda() {
		return deuda;
	}
	
	public void setExpensa(float expensa) {
		this.expensa = expensa;
	}
	
	public float getExpensa() {
		return expensa;
	}
	
	public float getPorcentaje() {
		return porcentaje;
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}


	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<Persona> getListadoPropietarios() {
		return listadoPropietarios;
	}

	public void setListadoPropietarios(List<Persona> listadoPropietarios) {
		this.listadoPropietarios = listadoPropietarios;
	}

	public List<Factura> getListadoPagos() {
		return listadoPagos;
	}

	public void setListadoPagos(List<Factura> listadoPagos) {
		this.listadoPagos = listadoPagos;
	}

	public List<Persona> getListadoInquilinos() {
		return ListadoInquilinos;
	}

	public void setListadoInquilinos(List<Persona> listadoInquilinos) {
		ListadoInquilinos = listadoInquilinos;
	}
	
	public String aStringUnidadesOtro() {
		return ("Id : " + this.id + " Metros: " + this.metrosCuadrados  );
	}
	
	public String aStringUnidades() {
		
		return ("Id : " + this.id + " Metros: " + this.metrosCuadrados + ",Expensas: " + this.expensa );
	}
}
