package Ejercicios;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class VentanaEjercicio3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JRadioButton windows, mac, linux;
    private ButtonGroup btnSistemaOperativo;
    private JButton btnAceptar;
    private JTextField horas;
    
    public VentanaEjercicio3() {
        setTitle("Selección múltiple");
        setSize(460, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblSistemaOperativo = new JLabel("Elija un sistema operativo");
        lblSistemaOperativo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSistemaOperativo.setBounds(20, 40, 180, 25);
        getContentPane().add(lblSistemaOperativo);

        windows = new JRadioButton("Windows");
        windows.setBounds(201, 41, 93, 25);
        getContentPane().add(windows);
 
        mac = new JRadioButton("Mac");
        mac.setBounds(296, 41, 60, 25);
        getContentPane().add(mac);

        linux = new JRadioButton("Linux");
        linux.setBounds(358, 41, 70, 25);
        getContentPane().add(linux);

        btnSistemaOperativo = new ButtonGroup();
        btnSistemaOperativo.add(windows);
        btnSistemaOperativo.add(mac);
        btnSistemaOperativo.add(linux);
        
        JLabel lblEspecialidad = new JLabel("Elije una especialidad");
        lblEspecialidad.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEspecialidad.setBounds(20, 125, 137, 31);
        getContentPane().add(lblEspecialidad);
        
        JCheckBox chckbxProgramacion = new JCheckBox("Programación");
        chckbxProgramacion.setFont(new Font("Arial", Font.BOLD, 14));
        chckbxProgramacion.setBounds(225, 101, 137, 23);
        getContentPane().add(chckbxProgramacion);
        
        JCheckBox chckbxAdministracion = new JCheckBox("Administración");
        chckbxAdministracion.setFont(new Font("Arial", Font.BOLD, 14));
        chckbxAdministracion.setBounds(225, 127, 137, 23);
        getContentPane().add(chckbxAdministracion);
        
        JCheckBox chckbxDisGrafico = new JCheckBox("Diseño Gráfico");
        chckbxDisGrafico.setFont(new Font("Arial", Font.BOLD, 14));
        chckbxDisGrafico.setBounds(225, 156, 153, 23);
        getContentPane().add(chckbxDisGrafico);
        
        
        btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBounds(300, 250, 109, 30);
        getContentPane().add(btnAceptar);
        
        JLabel lblHoras = new JLabel("Cantidad de horas en el computador:");
        lblHoras.setFont(new Font("Arial", Font.PLAIN, 14));
        lblHoras.setBounds(20, 200, 250, 31);
        getContentPane().add(lblHoras);
        
        horas = new JTextField();
        horas.setBounds(275, 200, 150, 25);
        getContentPane().add(horas);
        
        JPanel panelSistema = new JPanel();
        panelSistema.setLayout(null);
        panelSistema.setBounds(10, 30, 420, 50);
        panelSistema.setBorder(BorderFactory.createLineBorder(getForeground()));
        getContentPane().add(panelSistema);
        
        JPanel panelEspecialidad = new JPanel();
        panelEspecialidad.setLayout(null);
        panelEspecialidad.setBounds(10, 90, 420, 100);
        panelEspecialidad.setBorder(BorderFactory.createLineBorder(getForeground()));
        getContentPane().add(panelEspecialidad);
        
        btnAceptar.addActionListener(e -> {
            String sistema = "";
            if (windows.isSelected()) sistema = "Windows";
            else if (mac.isSelected()) sistema = "Mac";
            else if (linux.isSelected()) sistema = "Linux";
 
            String especialidades = "";
            if (chckbxProgramacion.isSelected()) especialidades += "Programación ";
            if (chckbxAdministracion.isSelected()) especialidades += "Administración ";
            if (chckbxDisGrafico.isSelected()) especialidades += "Diseño Gráfico ";

            String horasTexto = horas.getText();

            if (sistema.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un sistema operativo.");
                return;
            }

            if (horasTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad de horas.");
                return;
            }

            String mensaje = sistema +" - " + (especialidades.isEmpty() ? "Ninguna" : especialidades) +
                    " - " + horasTexto;

            JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        });
        
        
        

    }
   

    public void CambiarVisibilidad(boolean estado) {
        setVisible(estado);
    }
}

