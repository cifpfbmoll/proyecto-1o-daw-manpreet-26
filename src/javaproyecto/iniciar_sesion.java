/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author luban
 */
public class iniciar_sesion extends JFrame implements ActionListener {

    
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    //this is for how login page will work
    iniciar_sesion() {
        super("Página de inicio de sesión");
        setLayout(new BorderLayout());
        t2 = new JPasswordField(5);
        t1 = new JTextField(5);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\im2.jpg")));

        b1 = new JButton("Inicia");
        b2 = new JButton("Cancel");

        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1, p2, p3, p4;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        add(l, BorderLayout.WEST);

        p2.add(new JLabel("Usuario  "));
        p2.add(t1);
        p2.add(new JLabel("Contraseña "));
        p2.add(t2);
        add(p2, BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);

        add(p4, BorderLayout.SOUTH);

        setSize(400, 250);
        setLocation(600, 400);
        setVisible(true);

    }

    //this method is to run query and create pop message
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            conecion_bbdd c1 = new conecion_bbdd();
            String u = t1.getText();
            String v = t2.getText();

            String q = "select * from iniciar_sesion where usuario='" + u + "' and contraseña='" + v + "'";

            ResultSet rs = c1.s.executeQuery(q); 
            if (rs.next()) {
                new proyecto().setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalido usuario y contraseña");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new iniciar_sesion() {};
    }
}
