package Ejercicios;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaEjercicio2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nota1, nota2, nota3, promedio, condicion;
    private JButton btnCalcular, btnNuevo;
    private JComboBox<String> comboBox;

    public VentanaEjercicio2() {
        setTitle("Promedio");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(30, 55, 80, 25);
        getContentPane().add(lblNota1);

        nota1 = new JTextField();
        nota1.setBounds(120, 55, 100, 25);
        getContentPane().add(nota1);

        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(30, 95, 80, 25);
        getContentPane().add(lblNota2);

        nota2 = new JTextField();
        nota2.setBounds(120, 95, 100, 25);
        getContentPane().add(nota2);

        JLabel lblNota3 = new JLabel("Nota 3:");
        lblNota3.setBounds(30, 135, 80, 25);
        getContentPane().add(lblNota3);

        nota3 = new JTextField();
        nota3.setBounds(120, 135, 100, 25);
        getContentPane().add(nota3);

        btnCalcular = new JButton("CALCULAR");
        btnCalcular.setBounds(300, 61, 109, 30);
        getContentPane().add(btnCalcular);

        JLabel lblTP = new JLabel("TPS");
        lblTP.setBounds(30, 175, 80, 25);
        getContentPane().add(lblTP);

        comboBox = new JComboBox<>(new String[]{"Aprobado", "Desaprobado"});
        comboBox.setBounds(120, 175, 100, 25);
        getContentPane().add(comboBox);

        promedio = new JTextField();
        promedio.setEditable(false);
        promedio.setBounds(120, 275, 100, 25);
        getContentPane().add(promedio);

        condicion = new JTextField();
        condicion.setEditable(false);
        condicion.setBounds(120, 310, 100, 25);
        getContentPane().add(condicion);

        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(30, 240, 250, 100);
        getContentPane().add(lblPromedio);

        JLabel lblCondicion = new JLabel("Condicion:");
        lblCondicion.setBounds(30, 270, 250, 100);
        getContentPane().add(lblCondicion);

        JPanel panelNotas = new JPanel();
        panelNotas.setLayout(null);
        panelNotas.setBounds(20, 25, 250, 200);
        panelNotas.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
        getContentPane().add(panelNotas);

        JPanel panelNotas2 = new JPanel();
        panelNotas2.setLayout(null);
        panelNotas2.setBounds(20, 250, 250, 100);
        panelNotas2.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
        getContentPane().add(panelNotas2);

        btnNuevo = new JButton("NUEVO");
        btnNuevo.setBounds(300, 92, 109, 30);
        getContentPane().add(btnNuevo);

        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setBounds(300, 132, 109, 30);
        getContentPane().add(btnSalir);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularCondicion();
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    private void calcularCondicion() {
        try {
            double n1 = Double.parseDouble(nota1.getText());
            double n2 = Double.parseDouble(nota2.getText());
            double n3 = Double.parseDouble(nota3.getText());
            String estadoTPS = comboBox.getSelectedItem().toString();

            if (n1 < 1 || n1 > 10 || n2 < 1 || n2 > 10 || n3 < 1 || n3 > 10) {
                JOptionPane.showMessageDialog(this, "Las notas deben estar entre 1 y 10", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (n1 >= 8 && n2 >= 8 && n3 >= 8 && estadoTPS.equalsIgnoreCase("Aprobado")) {
                condicion.setText("Promocionado");
            } else if (n1 >= 6 && n2 >= 6 && n3 >= 6 && n1 <= 8 && n2 <= 8 && n3 <= 8
                    && estadoTPS.equalsIgnoreCase("Aprobado")) {
                condicion.setText("Regular");
            } else if (estadoTPS.equalsIgnoreCase("Desaprobado") || n1 < 6 || n2 < 6 || n3 < 6) {
                condicion.setText("Libre");
            }

            double prom = (n1 + n2 + n3) / 3;
            promedio.setText(String.format("%.2f", prom));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese numeros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
        promedio.setText("");
        condicion.setText("");
        comboBox.setSelectedIndex(0);
    }

    public void CambiarVisibilidad(boolean estado) {
        setVisible(true);
    }
}


        
 

