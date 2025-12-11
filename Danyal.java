
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Danyal extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l, l1;

    Danyal() {

        // Main Page
        setTitle("Danyal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.pink);
        setSize(1000, 600);
        setLayout(null);

        b1 = new JButton("Login");
        b2 = new JButton("Register");
        l = new JLabel("ShriNik");
        l1 = new JLabel("OR");

        l.setBounds(100, 50, 250, 50);
        l.setFont(new Font("Algerian", Font.ITALIC, 40));
        l.setLocation(380, 52);

        l1.setBounds(100, 50, 250, 50);
        l1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        l1.setLocation(433, 200);

        b1.setBounds(100, 200, 130, 50);
        b2.setBounds(100, 300, 130, 50);

        b1.setLocation(280, 200);
        b2.setLocation(500, 200);

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(b1);
        add(b2);
        add(l);
        add(l1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            JOptionPane.showMessageDialog(this, "Login Clicked");
        }
        if (e.getSource() == b2) {
            JOptionPane.showMessageDialog(this, "Register Clicked");
        }
    }

    public static void main(String[] args) {
        new Danyal();
    }
}
