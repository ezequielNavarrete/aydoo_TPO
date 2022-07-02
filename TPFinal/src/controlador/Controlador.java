package controlador;
import java.util.List;

import modelado.Consorcio;
import modelado.Gasto;
import modelado.UnidadFuncional;

public class Controlador {
	
	private static Controlador instancia;
	
	private Consorcio consorcio;
	private List<Gasto> gastos;
	private List<UnidadFuncional> unidadesFuncionales;
	
	
	public static Controlador getInstancia() {
		if(instancia ==  null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void crearGasto() {
		
	}
	
	public void crearGastoRecurrente() {
		
	}
	
}
