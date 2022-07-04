package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelado.Gasto;
import modelado.GastoComun;
import modelado.GastoRecurrente;
import modelado.Persona;
import modelado.UnidadFuncional;
import modelado.Consorcio;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese acci�n a realizar : ");
		System.out.println("Salir del sistema = 0 ");
		System.out.println("Cargar gastos de cada mes = 1 ");
		System.out.println("Cargar gastos recurrentes = 2 ");
		System.out.println("Calcular y generar expensas segun criterio = 3 ");
		System.out.println("Enviar expensas a cada interesado = 4 ");
		System.out.println("Obtener pagos mensuales de Unidad Funcional = 5 ");
		System.out.println("Comprobar gastos comunes de cada mes = 6 ");
		System.out.println("Comprobar gastos recurrentes de cada mes = 7 ");
		String str=  sc.nextLine();              //Lee el input de la consola
		Consorcio consorcio=new Consorcio();
		consorcio.cargarDatosPruebaGastos();
		List<GastoComun> aver=consorcio.getListadoDeGastos();
		List<GastoRecurrente> recu=consorcio.getListadoGastosRecurrentes();
		String descripcion=new String();
		float monto=Float.parseFloat("0");
		String tipoExpensa=new String();
		while (!str.equals("0")) {
			switch(str){
				case "1":
					System.out.println("cargar gasto  comun elegido");
					System.out.println("Seleccione descripcion del gasto: ");
					descripcion=sc.nextLine();
					System.out.println("Seleccione monto del gasto: ");
					monto=Float.parseFloat(sc.nextLine());
					System.out.println("Seleccione el tipo de expensa del gasto: ");
					tipoExpensa=sc.nextLine();
					GastoComun gasto=new GastoComun(monto,descripcion,tipoExpensa);
					aver.add(gasto);
					System.out.println("Creacion exitosa");
					break;
				case "2":
					System.out.println("cargar gasto  comun elegido");
					System.out.println("Seleccione descripcion del gasto: ");
				    descripcion=sc.nextLine();
					System.out.println("Seleccione monto del gasto: ");
					monto=Float.parseFloat(sc.nextLine());
					System.out.println("Seleccione el tipo de expensa del gasto: ");
					tipoExpensa=sc.nextLine();
					System.out.println("Seleccione el vencimiento del gasto: ");
					String vencimiento=sc.nextLine();
					System.out.println("Seleccione la duracion en meses del gasto: ");
					int duracion=Integer.parseInt(sc.nextLine());
					Date venc=new SimpleDateFormat("dd/MM/yyyy").parse(vencimiento);
					GastoRecurrente gastorec=new GastoRecurrente(monto,descripcion,tipoExpensa,venc,duracion);
					recu.add(gastorec);
					System.out.println("Creacion exitosa");
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					List <UnidadFuncional> ufs = new ArrayList<UnidadFuncional>(getUnidadesFuncionales(consorcio));
					consorcio.generarExpensas(ufs.get(0));
					break;
				case "6":
					ArrayList<GastoComun> copiaLista = new ArrayList<GastoComun>(aver);
					while (!copiaLista.isEmpty()){
						GastoComun primero=copiaLista.get(0);
						String mensaje=primero.aStringComun();
						System.out.println(mensaje);
						copiaLista.remove(0);
					}
					break;
				case "7":
					ArrayList<GastoRecurrente> copiarecu=new ArrayList<GastoRecurrente>(recu);
					while(!copiarecu.isEmpty()) {
						GastoRecurrente pri=copiarecu.get(0);
						String mensa=pri.aStringRecurrente();
						System.out.println(mensa);
						copiarecu.remove(0);
					}
					break;
				default:
					System.out.println("Ingrese un comando valido");
			}
			System.out.println("Desea continuar ? Pulse 0 para salir / escriba otra cosa para continuar");
			str=  sc.nextLine();
			if(!str.equals("0")) {
				System.out.println("Ingrese acci�n a realizar : ");
				System.out.println("Cargar gastos de cada mes = 1 ");
				System.out.println("Cargar gastos recurrentes = 2 ");
				System.out.println("Calcular y generar expensas segun criterio = 3 ");
				System.out.println("Enviar expensas a cada interesado = 4 ");
				System.out.println("Obtener pagos mensuales de Unidad Funcional = 5 ");
				System.out.println("Comprobar gastos comunes de cada mes = 6 ");
				System.out.println("Comprobar gastos recurrentes de cada mes = 7 ");
				str=  sc.nextLine();
			}
		}
		      
	}
private static List<UnidadFuncional> getUnidadesFuncionales(Consorcio consorcio){
        List<UnidadFuncional> unidadesFunc = new ArrayList<UnidadFuncional>();
		List<Persona> propietarios =new ArrayList<Persona>();
		List<Persona> inquilinos =new ArrayList<Persona>();
        Persona propietario = new Persona();
		Persona inquilino=new Persona();
        UnidadFuncional uf = new UnidadFuncional();

		propietario.setNombre("Ezequiel Navarrete");
        propietario.setDNI(40793701);
		propietario.setEsInquilino(false);

		propietario.setNombre("Facundo Campos");
        propietario.setDNI(40793702);
		propietario.setEsInquilino(true);

		propietarios.add(propietario);
		inquilinos.add(inquilino);
		uf.setListadoPropietarios(propietarios);
		uf.setListadoInquilinos(inquilinos);
		uf.setMetrosCuadrados(50);
		uf.setPorcentaje((float) 0.05);
        unidadesFunc.add(uf);

        propietario = new Persona();
		inquilino =new Persona();
		propietario.setNombre("Mateo Rios");
        propietario.setDNI(40793703);
		propietario.setEsInquilino(false);

		propietario.setNombre("Roberto Salvo");
        propietario.setDNI(40793704);
		propietario.setEsInquilino(true);
		propietarios =new ArrayList<Persona>();
		inquilinos =new ArrayList<Persona>();
		propietarios.add(propietario);
		inquilinos.add(inquilino);
		uf.setListadoPropietarios(propietarios);
		uf.setListadoInquilinos(inquilinos);
		uf.setMetrosCuadrados(50);
		uf.setPorcentaje((float) 0.06);
        unidadesFunc.add(uf);

        return unidadesFunc;
    }
}
