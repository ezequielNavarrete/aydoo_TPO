package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelado.Gasto;
import modelado.GastoRecurrente;
import modelado.Consorcio;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese acción a realizar : ");
		System.out.println("Cargar gastos de cada mes = 1 ");
		System.out.println("Cargar gastos recurrentes = 2 ");
		System.out.println("Calcular y generar expensas segun criterio = 3 ");
		System.out.println("Enviar expensas a cada interesado = 4 ");
		System.out.println("Obtener pagos mensuales de Unidad Funcional = 5");
		String str=  sc.nextLine();              //reads string
		if(str.equals("1")) {
			/*
			List<Gasto> gastos = null;
			for(Gasto gasto: gastos) {
				//...
			}
			*/
			
			System.out.println("cargar gasto  comun elegido");
			System.out.println("Seleccione descripcion del gasto: ");
			String descripcion=sc.nextLine();
			System.out.println("Seleccione monto del gasto: ");
			float monto=Float.parseFloat(sc.nextLine());
			System.out.println("Seleccione el tipo de expensa del gasto: ");
			String tipoExpensa=sc.nextLine();
			Gasto gasto=new Gasto(monto,descripcion,tipoExpensa);  
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
				System.out.println("Creacion exitosa");
				
			}
			else {
				if(str.equals("3")) {
					
				}
				else {
					if(str.equals("4")) {
						
					}
					else {
						if(str.equals("5")) {
							
						}
						else {
							System.out.println("Error: eliga un comando valido");
						}
					}
				}
			}
		}
		System.out.print("You have entered: "+str);             
	}

}
