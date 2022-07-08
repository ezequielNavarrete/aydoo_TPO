package estrategiaCriterio;
import java.util.List;


import estrategiaCriterio.EstrategiaDeCriterio;
import modelado.Componente;
import modelado.Criterio;
import modelado.UnidadFuncional;

public class PagoYGenerarFuturos implements EstrategiaDeCriterio {

	public void divisionDeExpensas(List<UnidadFuncional> listadoUnidades, float totalAPagar, float fondosReserva) {
	
		totalAPagar=totalAPagar+fondosReserva;
		float por;
		float deu;
		for(int i=0;i<listadoUnidades.size();i++){
			  por=listadoUnidades.get(i).getPorcentaje();
			  deu=listadoUnidades.get(i).getDeuda();
		      listadoUnidades.get(i).setExpensa(por*totalAPagar+deu);
		    }
	}

}
