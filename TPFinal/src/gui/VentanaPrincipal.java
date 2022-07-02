package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class VentanaPrincipal extends JFrame	{
	
	private JMenuBar barra;
	private JMenu agregar,calcularExpensa,enviarExpensa,trazabilidad;
	private JMenuItem crearGasto, crearGastoRecurrente;
	private JDesktopPane ventanas;
	
	public VentanaPrincipal() {
		configurarVentana();
		configurarMenu();
		manejoEventos();
		this.setVisible(true);
		this.setSize(550, 550);
	}

	private void configurarMenu() {
		barra = new JMenuBar();
		agregar = new JMenu("Crear Gasto");
		enviarExpensa = new JMenu("Enviar Expensa");
		calcularExpensa = new JMenu("Calcular Expensa");
		trazabilidad = new JMenu("Obtener trazabilidad");
		crearGasto = new JMenuItem("Crear Gasto Comun");
		crearGastoRecurrente = new JMenuItem("Crear Gasto Recurrente");
		agregar.add(crearGasto);
		agregar.add(crearGastoRecurrente);
		barra.add(agregar);
		barra.add(enviarExpensa);
		barra.add(calcularExpensa);
		barra.add(trazabilidad);
		this.setJMenuBar(barra);
		
	}

	private void manejoEventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearGasto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CrearGasto aux = new CrearGasto();
				ventanas.add(aux);

			}
		});
		
		crearGastoRecurrente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CrearGastoRecurrente auxGasto = new CrearGastoRecurrente();
				ventanas.add(auxGasto);
				
			}
		});
	}

	private void configurarVentana() {
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setTitle("Sistema de Gestion del Consorcio");
		ventanas = new JDesktopPane();
		this.setContentPane(ventanas);
	}

}
