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

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public float getPorcentaje() {
		return porcentaje;
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
}
