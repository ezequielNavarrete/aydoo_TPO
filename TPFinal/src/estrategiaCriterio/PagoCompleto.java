package estrategiaCriterio;
import java.util.ArrayList;
import java.util.List;


import modelado.Criterio;
import modelado.UnidadFuncional;

public class PagoCompleto extends Criterio{

	public void divisionDeExpensas(List<UnidadFuncional> listadoUnidades, float totalAPagar, float fondosReserva) {
		float por;
		float deu;
		for(int i=0;i<listadoUnidades.size();i++){
			  por=listadoUnidades.get(i).getPorcentaje();
			  deu=listadoUnidades.get(i).getDeuda();
		      listadoUnidades.get(i).setExpensa(por*totalAPagar+deu);
		    }
		
	}

}
