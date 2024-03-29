package Grafica;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase que extiende un JPanel, la cual representa los datos del cliente al comprar un pasaje
 * @author Vicente Ramirez
 * @author Ricardo Charris
 */
public class PanelDatosComprador extends JPanel {
    private JTextField nombreUsuario;
    private JTextField rutUsuario;
    private JButton btnConfirmarReserva;
    /**
     * Inicializa el panel con los JTextField, en los cuales el usuario podra rellenar con sus datos u un JButton
     * para confirmar la reserva de los asientos
     */
    public PanelDatosComprador(){
        nombreUsuario = new JTextField();
        nombreUsuario.setBackground(Color.WHITE);
        nombreUsuario.setFont(new Font("Arial",Font.ITALIC,50));
        nombreUsuario.setBounds(450,160,800,100);

        rutUsuario = new JTextField();
        nombreUsuario.setBackground(Color.WHITE);
        rutUsuario.setFont(new Font("Arial",Font.ITALIC,50));
        rutUsuario.setBounds(450,310,800,100);

        btnConfirmarReserva = new JButton("Reservar");
        btnConfirmarReserva.setFont(new Font("Arial",Font.BOLD,30));
        btnConfirmarReserva.setBounds(750,500,200,100);
        btnConfirmarReserva.setFocusPainted(false);
        btnConfirmarReserva.setBorder(new BevelBorder(BevelBorder.RAISED));

        this.add(nombreUsuario);
        this.add(rutUsuario);
        this.add(btnConfirmarReserva);

        this.setBackground(Color.BLACK);
        this.setLayout(null);
    }
    public void addActionBtnReserva(ActionListener action){
        btnConfirmarReserva.addActionListener(action);
    }
    /**
     * Metodo que dibuja las instrucciones de cada texto y el titulo del panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.orange);
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.drawString("Ingrese los datos del comprador",170,100);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Ingrese el nombre completo",160,200);
        g.drawString("del comprador: ",210,240);
        g.drawString("Ingrese el Rut",210,350);
        g.drawString("del comprador:",210,390);
    }
    public JTextField getNombreUsuario(){
        return nombreUsuario;
    }
    public JTextField getRutUsuario(){
        return rutUsuario;
    }
}
