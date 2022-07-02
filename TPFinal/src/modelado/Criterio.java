package modelado;
import modelado.Gasto;

import java.util.List;

import modelado.Componente;
import estrategiaCriterio.EstrategiaDeCriterio;


public class Criterio {
	
	private EstrategiaDeCriterio criterioEstrategia;
	
	
	public float obtencionSaldo(Componente componente) {
		return 0;
	}
	
	public float calculoDeGastos(List<Gasto> listadoDeGastos,float deuda) {
		return 0;
	}
	
	public void divisionDeExpensas(float porcentaje, float totalAPagar) {
		
	}
	
}
