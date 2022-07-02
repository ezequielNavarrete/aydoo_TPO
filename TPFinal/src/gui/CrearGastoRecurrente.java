package gui;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.Controlador;


public class CrearGastoRecurrente extends JInternalFrame{

	private JLabel lblDescripcion, lblMonto, lblTipoExpensa,lblTipoExpensa2,lblVencimiento,lblDuracion;
	private JTextField txtDescripcion, txtMonto,txtVencimiento,txtDuracion;
	private JButton btnBorrar, btnCrear;
	private JRadioButton jrbOrdinaria, jrbExtraordinaria, jrbGastoParticular, jrbFondoDeReserva;
	
	public CrearGastoRecurrente() {
		configurar();
		eventos();
		this.setTitle("Agregar Gasto Recurrente");
		this.setSize(300, 200);
		this.setVisible(true);
	}

	private void eventos() {
		btnBorrar.addActionListener(new ManejoBotones());
		btnCrear.addActionListener(new ManejoBotones());
		
	}

	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(8,2));
		lblDescripcion = new JLabel("Descripcion");
		lblMonto = new JLabel("Monto");
		lblVencimiento = new JLabel("Vencimiento");
		lblDuracion = new JLabel("Duracion en meses");
		lblTipoExpensa = new JLabel("Seleccione el tipo");
		lblTipoExpensa2 = new JLabel("de expensa");
		
		txtDescripcion = new JTextField();
		txtMonto = new JTextField();
		txtVencimiento = new JTextField();
		txtDuracion = new JTextField();

		
		jrbOrdinaria = new JRadioButton("Ordinaria");
		jrbExtraordinaria = new JRadioButton("Extraordinaria");
		jrbGastoParticular = new JRadioButton("Gasto Particular");
		jrbFondoDeReserva = new JRadioButton("Fondo de Reserva");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbOrdinaria);
		bg.add(jrbExtraordinaria);
		bg.add(jrbGastoParticular);
		bg.add(jrbFondoDeReserva);
		
		btnBorrar = new JButton("Borrar");
		btnCrear = new JButton("Guardar");
		
		c.add(lblDescripcion);
		c.add(txtDescripcion);
		c.add(lblMonto);
		c.add(txtMonto);
		
		c.add(lblVencimiento);
		c.add(txtVencimiento);
		c.add(lblDuracion);
		c.add(txtDuracion);
		
		c.add(lblTipoExpensa);
		c.add(lblTipoExpensa2);
		c.add(jrbOrdinaria);
		c.add(jrbExtraordinaria);
		c.add(jrbGastoParticular);
		c.add(jrbFondoDeReserva);
		c.add(btnBorrar);
		c.add(btnCrear);
	}
	
	class ManejoBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnBorrar)) {
				txtDescripcion.setText("");
				txtMonto.setText("");
				txtVencimiento.setText("");
				txtDuracion.setText("");
				jrbOrdinaria.setSelected(false);
				jrbExtraordinaria.setSelected(false);
				jrbGastoParticular.setSelected(false);
				jrbFondoDeReserva.setSelected(false);
			}
			
		}

	}
	
	
	
}
