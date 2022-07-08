package estrategiaCriterio;

import java.util.List;


import modelado.Criterio;
import modelado.UnidadFuncional;

public interface EstrategiaDeCriterio {
	public void divisionDeExpensas(List<UnidadFuncional> listadoUnidades, float totalAPagar, float fondosReserva);
}
