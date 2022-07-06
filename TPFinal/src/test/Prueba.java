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
import modelado.Consorcio;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese acción a realizar : ");
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
						if(str.equals("4")) {
							
							Persona persona1 = new Persona(null, 41645331);
							listaPersonas.add(persona1);
							Persona persona2 = new Persona(null, 40685263);
							listaPersonas.add(persona2);
							Persona persona3 = new Persona(null, 38605323);
							listaPersonas.add(persona3);
							Persona persona4 = new Persona(null, 42735009);
							listaPersonas.add(persona4);
							Persona persona5 = new Persona(null, 38824726);
							listaPersonas.add(persona5);
							
							int eleccion = 6;
							while (eleccion != 0 ){
								
								for (Persona persona : listaPersonas) {
									System.out.print(" \n");
									System.out.print("-DNI: " + persona.getDNI() + " \n");

								}
								System.out.println("Que persona desea notificar? (Ingrese DNI o 0 para salir)");
								eleccion = sc.nextInt();
								switch (eleccion) {
								
								case 41645331:
									System.out.print("-" + persona1.getDNI() + " NOTIFICADO" + " \n");
									System.out.print(" \n");
									System.out.print("---------");
									//enviar notificacion x medio seleccionado
								break;
								case 40685263:
									System.out.print("-" + persona2.getDNI() + " NOTIFICADO" + " \n");
									System.out.print(" \n");
									System.out.print("---------");
									//enviar notificacion x medio seleccionado
								break;
								case 38605323:
									System.out.print("-" + persona3.getDNI() + " NOTIFICADO" + " \n");
									System.out.print(" \n");
									System.out.print("---------");
									//enviar notificacion x medio seleccionado
								break;
								case 42735009:
									System.out.print("-" + persona4.getDNI() + " NOTIFICADO" + " \n");
									System.out.print(" \n");
									System.out.print("---------");
									//enviar notificacion x medio seleccionado
								break;
								case 38824726:
									System.out.print("-" + persona5.getDNI() + " NOTIFICADO" + " \n");
									System.out.print(" \n");
									System.out.print("---------");
									//enviar notificacion x medio seleccionado
								break;
								}
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
				System.out.println("Ingrese acción a realizar : ");
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

}
