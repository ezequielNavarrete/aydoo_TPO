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
import moduloNotificaciones.Notificacion;
import moduloNotificaciones.Notificador;
import moduloNotificaciones.estrategias.Estrategia;
import moduloNotificaciones.estrategias.EstrategiaDeNotificacion;
import moduloNotificaciones.estrategias.NotificacionPorEmail;
import moduloNotificaciones.estrategias.NotificacionPorSMS;
import moduloNotificaciones.estrategias.NotificacionPorWhatsApp;
import modelado.Consorcio;
import test.UsuarioNotificacionMock;


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
		Consorcio hola=new Consorcio();
		hola.cargarDatosPruebaGastos();
		ArrayList <Persona> listaPersonas = new ArrayList<>();
		List<GastoComun> aver=hola.getListadoDeGastos();
		List<GastoRecurrente> recu=hola.getListadoGastosRecurrentes();
		while (!str.equals("0")) {
			if(str.equals("1")) {
				System.out.println("cargar gasto  comun elegido");
				System.out.println("Seleccione descripcion del gasto: ");
				String descripcion=sc.nextLine();
				System.out.println("Seleccione monto del gasto: ");
				float monto=Float.parseFloat(sc.nextLine());
				System.out.println("Seleccione el tipo de expensa del gasto: ");
				String tipoExpensa=sc.nextLine();
				GastoComun gasto=new GastoComun(monto,descripcion,tipoExpensa);
				aver.add(gasto);
				System.out.println("Creacion exitosa");
			}
			else {
				if(str.equals("2")) {
					System.out.println("cargar gasto  comun elegido");
					System.out.println("Seleccione descripcion del gasto: ");
					String descripcion=sc.nextLine();
					System.out.println("Seleccione monto del gasto: ");
					float monto=Float.parseFloat(sc.nextLine());
					System.out.println("Seleccione el tipo de expensa del gasto: ");
					String tipoExpensa=sc.nextLine();
					System.out.println("Seleccione el vencimiento del gasto: ");
					String vencimiento=sc.nextLine();
					System.out.println("Seleccione la duracion en meses del gasto: ");
					int duracion=Integer.parseInt(sc.nextLine());
					Date venc=new SimpleDateFormat("dd/MM/yyyy").parse(vencimiento);
					GastoRecurrente gastorec=new GastoRecurrente(monto,descripcion,tipoExpensa,venc,duracion);
					recu.add(gastorec);
					System.out.println("Creacion exitosa");
					
				}
				else {
					if(str.equals("3")) {
						
					}
					else {
						if (str.equals("4")) {

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

						}
						else {
							if(str.equals("5")) {
								
							}
							else {
								if(str.equals("6")) {
									ArrayList<GastoComun> copiaLista = new ArrayList<GastoComun>(aver);
									while (!copiaLista.isEmpty()){
										GastoComun primero=copiaLista.get(0);
										String mensaje=primero.aStringComun();
										System.out.println(mensaje);
										copiaLista.remove(0);
									}								
									}
								else {
									if(str.equals("7")) {
										ArrayList<GastoRecurrente> copiarecu=new ArrayList<GastoRecurrente>(recu);
										while(!copiarecu.isEmpty()) {
											GastoRecurrente pri=copiarecu.get(0);
											String mensa=pri.aStringRecurrente();
											System.out.println(mensa);
											copiarecu.remove(0);
										}
									}
									else {
										System.out.println("Ingrese un comando valido");
								}
								}
							}
						}
					}
				}
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

}
