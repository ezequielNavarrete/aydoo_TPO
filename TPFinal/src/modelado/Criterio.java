package modelado;
import modelado.Gasto;


import java.util.List;

import modelado.Componente;

import modelado.UnidadFuncional;


public abstract class Criterio {
	
	

	
	public float obtencionSaldo(Componente componente) {
		return componente.devolverSaldo();
	}
	
	public float calculoDeGastos(List<Gasto> listadoDeGastos) {
		float total=0;
		for(int i=0;i<listadoDeGastos.size();i++){
		      total = total + listadoDeGastos.get(i).getMonto();
		    }
		return total;
	}
	
	public abstract void divisionDeExpensas(List<UnidadFuncional> listadoUnidades, float totalAPagar, float fondosReserva);
	
	
}
