package modelado;
import modelado.Gasto;


import java.util.List;

import modelado.Componente;
import estrategiaCriterio.EstrategiaDeCriterio;
import modelado.UnidadFuncional;


public class Criterio {
	
	private EstrategiaDeCriterio _criterioEstrategia;
	
	public EstrategiaDeCriterio get_estrategia() {
		return _criterioEstrategia;
	}

	public void set_estrategia(EstrategiaDeCriterio _criterioEstrategia) {
		this._criterioEstrategia = _criterioEstrategia;
	}
	
	public Criterio( EstrategiaDeCriterio estrategia)
    {
		
        this._criterioEstrategia = estrategia;
    }
	
	public float obtencionSaldo(Componente componente) {
		return componente.devolverSaldo();
	}
	
	public float calculoDeGastos(List<Gasto> listadoDeGastos,float deuda) {
		float total=0;
		for(int i=0;i<listadoDeGastos.size();i++){
		      total = total + listadoDeGastos.get(i).getMonto();
		    }
		//total=total+deuda;
		return total;
	}
	
	public void divisionDeExpensas(float porcentaje, float totalAPagar) {
		
	}
	
}
