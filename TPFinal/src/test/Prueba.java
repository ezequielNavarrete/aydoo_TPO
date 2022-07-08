package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import estrategiaCriterio.EstrategiaDeCriterio;
import estrategiaCriterio.PagoCompleto;
import estrategiaCriterio.PagoConFondosDeReserva;
import estrategiaCriterio.PagoYGenerarFuturos;
import modelado.Gasto;
import modelado.GastoComun;
import modelado.GastoRecurrente;
import modelado.Persona;
import modelado.UnidadFuncional;
import modelado.Consorcio;

import modelado.Factura;
import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;
import moduloNotificaciones.estrategias.Estrategia;
import moduloNotificaciones.estrategias.EstrategiaDeNotificacion;
import moduloNotificaciones.estrategias.NotificacionPorEmail;
import moduloNotificaciones.estrategias.NotificacionPorSMS;
import moduloNotificaciones.estrategias.NotificacionPorWhatsApp;
import test.UsuarioNotificacionMock;


import modelado.Criterio;
import modelado.Componente;


public class Prueba {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese accion a realizar : ");
		System.out.println("Salir del sistema = 0 ");
		System.out.println("Cargar gastos de cada mes = 1 ");
		System.out.println("Cargar gastos recurrentes = 2 ");
		System.out.println("Calcular y generar expensas segun criterio = 3 ");
		System.out.println("Enviar expensas a cada interesado = 4 ");
		System.out.println("Obtener pagos mensuales de Unidad Funcional = 5 ");
		System.out.println("Comprobar gastos comunes de cada mes = 6 ");
		System.out.println("Comprobar gastos recurrentes de cada mes = 7 ");
		String str=  sc.nextLine();              //Lee el input de la consola
		Consorcio con=new Consorcio();
		con.cargarDatosPruebaGastos();
		con.cargarDatosPruebaUnidadFuncional();
		List<GastoComun> aver=con.getListadoDeGastos();
		List<GastoRecurrente> recu=con.getListadoGastosRecurrentes();
		List<UnidadFuncional> unif=con.getListadoUnidades();
		EstrategiaDeCriterio pagocompleto=new PagoCompleto();
		EstrategiaDeCriterio pagoconfondosdereserva=new PagoConFondosDeReserva();
		EstrategiaDeCriterio pagoygenerarfuturos=new PagoYGenerarFuturos();
		Componente com1=new Componente();
		com1.setSaldo(100000);
		String descripcion= new String();
		float monto= Float.parseFloat("0.0");
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
					Criterio c1=new Criterio(pagocompleto);

					ArrayList<Gasto> copiaLista = new ArrayList<Gasto>(aver);
					ArrayList<Gasto> copiaListarec = new ArrayList<Gasto>(recu);
					ArrayList<UnidadFuncional> copiaListauni = new ArrayList<UnidadFuncional>(unif);
					float totalapagar;
					float fondoreserva=0;

					System.out.println("Que criterio desea utilizar? (Ingrese 0 para salir)");
					System.out.println("PagoCompleto = 1 ");
					System.out.println("PagoConFondosDeReserva = 2 ");
					System.out.println("PagoYGenerarFuturos = 3 ");
					System.out.println("Consultar Saldo y listado expensas = 4 ");
					String str1=  sc.nextLine();              //Lee el input de la consola

					totalapagar=c1.calculoDeGastos(copiaListarec)+c1.calculoDeGastos(copiaLista);
						switch (str1){
							case "1":
								System.out.println("Total de Gastos:");
								System.out.println(totalapagar);
								c1.divisionDeExpensas(copiaListauni, totalapagar,fondoreserva);
								System.out.println("Expensas por unidad funcional generadas correctamente");
								break;
							case "2":
								c1.set_estrategia(pagoconfondosdereserva);
								System.out.println("Cuanto fondos de reserva desea utilizar?");
								fondoreserva=sc.nextFloat();
								c1.divisionDeExpensas(copiaListauni, totalapagar,fondoreserva);
								com1.setSaldo(com1.devolverSaldo()-fondoreserva);
								System.out.println("Expensas por unidad funcional generadas correctamente");
								break;
							case "3":
								c1.set_estrategia(pagoygenerarfuturos);
								System.out.println("Cuanto fondos de reserva desea generar?");
								fondoreserva=sc.nextFloat();
								c1.divisionDeExpensas(copiaListauni, totalapagar,fondoreserva);
								com1.setSaldo(com1.devolverSaldo()+fondoreserva);
								System.out.println("Expensas por unidad funcional generadas correctamente");
								break;
							case "4":
								totalapagar=c1.obtencionSaldo(com1);
								System.out.println("Saldo en Cuenta Bancaria y listado expensas");
								System.out.println(totalapagar);
								while(!copiaListauni.isEmpty()) {
									UnidadFuncional pri=copiaListauni.get(0);
									String mensa=pri.aStringUnidades();
									System.out.println(mensa);
									copiaListauni.remove(0);
								}
								break;
						}
					break;
				case "4":
					Notificador notificador = new Notificador();
						EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS();
						EstrategiaDeNotificacion notificadorWhatsApp = new NotificacionPorWhatsApp();
						EstrategiaDeNotificacion notificadorEmail = new NotificacionPorEmail();
						for (UsuarioNotificacionMock usuarioMock : usuariosMock()) {
							Notificacion notificacion = new Notificacion();
							notificacion.setDni(usuarioMock.getDni());
							notificacion.setNombre(usuarioMock.getNombre());
							notificacion.setMensaje(usuarioMock.getMensaje());
							switch (usuarioMock.getEstrategiaElegida()) {
							case SMS:
								notificador.setEstrategia(notificadorSMS);
								break;
							case WHATSAPP:
								notificador.setEstrategia(notificadorWhatsApp);
								break;
							case EMAIL:
								notificador.setEstrategia(notificadorEmail);
								break;
							}
							notificador.enviar(notificacion);
						}
					break;
				case "5":
					con.setListadoUnidades(getUnidadesFuncionales(con));
					ArrayList<UnidadFuncional> copiaListauniii = new ArrayList<UnidadFuncional>(con.getListadoUnidades());
					while(!copiaListauniii.isEmpty()) {
						UnidadFuncional pri=copiaListauniii.get(0);
						String mensa=pri.aStringUnidadesOtro();
						System.out.println(mensa);
						copiaListauniii.remove(0);
					}
					System.out.println("Seleccione el id de la unidad funcional");
					String idprueba=sc.nextLine();
					System.out.println("Seleccione mes para ver la trazabilidad de expensas");
					String mes=sc.nextLine();
					con.getTrazabilidad(con.getUnidadFuncional(Integer.parseInt(idprueba)),mes);
					break;
				case "6":
					ArrayList<GastoComun> copiaListaComun = new ArrayList<GastoComun>(aver);
					while (!copiaListaComun.isEmpty()){
						GastoComun primero=copiaListaComun.get(0);
						String mensaje=primero.aStringComun();
						System.out.println(mensaje);
						copiaListaComun.remove(0);
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
				System.out.println("Ingrese accion a realizar : ");
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

	private static List<UsuarioNotificacionMock> usuariosMock() {
		List<UsuarioNotificacionMock> usuariosMock = new ArrayList<UsuarioNotificacionMock>();

		UsuarioNotificacionMock 
		usuarioMock = new UsuarioNotificacionMock(42726600, "Pedro", "Su factura...", Estrategia.EMAIL);
		usuariosMock.add(usuarioMock);

		usuarioMock = new UsuarioNotificacionMock(43625899, "Lucas", "Su factura...", Estrategia.WHATSAPP);
		usuariosMock.add(usuarioMock);

		usuarioMock = new UsuarioNotificacionMock(39827390, "Carolina", "Su factura...", Estrategia.SMS);
		usuariosMock.add(usuarioMock);
		
		usuarioMock = new UsuarioNotificacionMock(40236891, "Marcos", "Su factura...", Estrategia.EMAIL);
		usuariosMock.add(usuarioMock);

		return usuariosMock;
	}

	private static List<UnidadFuncional> getUnidadesFuncionales(Consorcio consorcio) throws ParseException{
        List<UnidadFuncional> unidadesFunc = new ArrayList<UnidadFuncional>();
        UnidadFuncional uf = new UnidadFuncional(3);
        UnidadFuncional segun=new UnidadFuncional(5);
		uf.setMetrosCuadrados(50);
		uf.setPorcentaje((float) 0.05);
		segun.setMetrosCuadrados(32);
		segun.setPorcentaje((float) 0.05);
		List<Factura> facturas= new ArrayList<Factura>();
		List<Factura>otrasFacturas=new  ArrayList<Factura>();
		Factura factura1 =new Factura(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022"), (float)10000, 10000, 0, true);
		Factura factura2 =new Factura(new SimpleDateFormat("dd/MM/yyyy").parse("05/07/2022"), (float)12000, 10000, 2000, true);
		Factura factura3 =new Factura(new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2022"), (float)4000, 4000, 0, true);
		facturas.add(factura1);facturas.add(factura2);facturas.add(factura3);
		uf.setListadoPagos(facturas);
		
		
		
		unidadesFunc.add(uf);
		Factura facturapri=new  Factura(new SimpleDateFormat("dd/MM/yyyy").parse("24/06/2022"), (float)10000, 10000, 0, true);
		otrasFacturas.add(facturapri);
		segun.setListadoPagos(otrasFacturas);
		unidadesFunc.add(segun);

		
        return unidadesFunc;
    }
}
