package Ejercicios;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class VentanaEjercicio1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton boton;
	private JTextField txtNombre, txtApellido, txtTelefono, txtFecha;
	private JLabel lblNombre, lblApellido, lblTelefono, lblFecha;
	private JLabel lblResultado;
	private JLabel lblErrorTel;
	
	public VentanaEjercicio1()
	{
		setSize(500,500);
		setLocation(150,150);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Contactos");
		getContentPane().setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 50, 100, 20);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(50, 100, 100, 20);
		getContentPane().add(lblApellido);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(50, 150, 100, 20);
		getContentPane().add(lblTelefono);
		
		lblFecha = new JLabel("Fecha Nac.");
		lblFecha.setBounds(50, 200, 100, 20);
		getContentPane().add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(150, 50, 200, 20);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(150, 100, 200, 20);
		getContentPane().add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(150, 150, 200, 20);
		getContentPane().add(txtTelefono);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(150, 200, 200, 20);
		getContentPane().add(txtFecha);
		
		lblResultado = new JLabel();
	    lblResultado.setBounds(50, 370, 400, 30);
	    lblResultado.setHorizontalAlignment(SwingConstants.LEFT);
	    getContentPane().add(lblResultado);
	     
	    lblErrorTel = new JLabel("Ingrese un teléfono válido");
	    lblErrorTel.setForeground(Color.RED);
	    lblErrorTel.setBounds(150, 175, 250, 20); 
		lblErrorTel.setVisible(false);      
		
		boton = new JButton();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textNom = txtNombre.getText();
				String textApell = txtApellido.getText();
				String textTel = txtTelefono.getText();
				String textFecha = txtFecha.getText();
				boolean lleno = true;
				
				getContentPane().add(lblErrorTel);
				 
				if(textNom.isEmpty()) {
					txtNombre.setBackground(Color.red);
					lleno = false;
				}else {
					txtNombre.setBackground(Color.white);
				}
				
				if(textApell.isEmpty()) {
					txtApellido.setBackground(Color.red);
					lleno=false;
				}else {
					txtApellido.setBackground(Color.white);
				}
				
				if (textTel.isEmpty() || !textTel.matches("\\d+")) {
				    txtTelefono.setBackground(Color.red);
				    lblErrorTel.setVisible(true);    
				    lleno = false;
				} else {
				    txtTelefono.setBackground(Color.white);
				    lblErrorTel.setVisible(false);     
				}
				
				if(textFecha.isEmpty()) {
				    txtFecha.setBackground(Color.red);
				    lleno = false;
				} else {
				    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    sdf.setLenient(false); 
				    try {
				        sdf.parse(textFecha); 
				        txtFecha.setBackground(Color.white); 
				    } catch (ParseException ex) {
				        txtFecha.setBackground(Color.red);   
				        lleno = false;
				    }
				}

				
				if(lleno == true) {
					lblResultado.setText("Los datos ingresados fueron: " + textNom + " " + textApell + " " + textTel + " " + textFecha);
					txtNombre.setText ("");		
					txtApellido.setText("");
					txtTelefono.setText("");
					txtFecha.setText("");
				}

			}
		});
		boton.setText("Mostrar");
		boton.setBounds(300,300, 140,30);
		
		getContentPane().add(boton);

	}
	public void CambiarVisibilidad(boolean estado)
	{
		setVisible(true);
	}
}
