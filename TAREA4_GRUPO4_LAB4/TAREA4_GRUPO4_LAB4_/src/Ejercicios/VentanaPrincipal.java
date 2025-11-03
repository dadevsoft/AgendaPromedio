package Ejercicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton Ejercicio1;
    private JButton Ejercicio2;
    private JButton Ejercicio3;
    private JLabel lblGrupo;

    public VentanaPrincipal() {
        setSize(300, 250);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblGrupo = new JLabel("GRUPO NRO: 4");
        lblGrupo.setBounds(50, 5, 150, 20);
        getContentPane().add(lblGrupo);

        Ejercicio1 = new JButton();
        Ejercicio1.setText("Ejercicio 1");
        Ejercicio1.setBounds(90, 40, 120, 30);
        Ejercicio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaEjercicio1().CambiarVisibilidad(true);
            }
        });
        getContentPane().add(Ejercicio1);

        Ejercicio2 = new JButton();
        Ejercicio2.setText("Ejercicio 2");
        Ejercicio2.setBounds(90, 90, 120, 30);
        Ejercicio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaEjercicio2().CambiarVisibilidad(true);
            }
        });
        getContentPane().add(Ejercicio2);

        Ejercicio3 = new JButton();
        Ejercicio3.setText("Ejercicio 3");
        Ejercicio3.setBounds(90, 140, 120, 30);
        Ejercicio3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaEjercicio3().CambiarVisibilidad(true);
            }
        });
        getContentPane().add(Ejercicio3);
    }

    public void CambiarVisibilidad(boolean estado) {
        setVisible(estado);
    }
}