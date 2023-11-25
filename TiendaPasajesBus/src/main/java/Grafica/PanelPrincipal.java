package Grafica;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    public PanelPrincipal() {
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setBounds(205,85,1500,850);

        JPanel panelLogoBus = new JPanel();
        panelLogoBus.setLayout(null);
        panelLogoBus.setBackground(Color.GREEN);
        panelLogoBus.setBounds(150,30,1200,170); // 500 500
        LineBorder borde = new LineBorder(Color.BLACK, 2, true);
        panelLogoBus.setBorder(borde);

        /*JLabel textoLogo = new JLabel("TREMENDO MARICON");
        textoLogo.setFont(new Font("Arial Black", Font.BOLD, 30));
        textoLogo.setForeground(Color.BLUE);
        textoLogo.setBounds(50,40,1000,80);

        panelLogoBus.add(textoLogo);*/
        this.add(panelLogoBus);







    }
}
