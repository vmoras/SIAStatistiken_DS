package gui;

import data.Course;
import data.DoubleList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalWindow extends JFrame {

    private JPanel contentPane;


    public PrincipalWindow(DoubleList<Course> courses) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1215, 727);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo (null);


        JLabel lblNewLabel_7_5_1_1 = new JLabel("Civil");
        lblNewLabel_7_5_1_1.setForeground(Color.WHITE);
        lblNewLabel_7_5_1_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_5_1_1.setBackground(Color.WHITE);
        lblNewLabel_7_5_1_1.setBounds(893, 503, 91, 44);
        contentPane.add(lblNewLabel_7_5_1_1);

        JLabel lblNewLabel_7_5_1 = new JLabel("Mec\u00E1nica");
        lblNewLabel_7_5_1.setForeground(Color.WHITE);
        lblNewLabel_7_5_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_5_1.setBackground(Color.WHITE);
        lblNewLabel_7_5_1.setBounds(540, 503, 144, 44);
        contentPane.add(lblNewLabel_7_5_1);

        JLabel lblNewLabel_7_5 = new JLabel("Mecatr\u00F3nica");
        lblNewLabel_7_5.setForeground(Color.WHITE);
        lblNewLabel_7_5.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_5.setBackground(Color.WHITE);
        lblNewLabel_7_5.setBounds(172, 503, 188, 44);
        contentPane.add(lblNewLabel_7_5);

        JLabel lblNewLabel_7_4 = new JLabel("Qu\u00EDmica");
        lblNewLabel_7_4.setForeground(Color.WHITE);
        lblNewLabel_7_4.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_4.setBackground(Color.WHITE);
        lblNewLabel_7_4.setBounds(526, 85, 175, 44);
        contentPane.add(lblNewLabel_7_4);

        JLabel lblNewLabel_7_3_1 = new JLabel("Agr\u00EDcola");
        lblNewLabel_7_3_1.setForeground(Color.WHITE);
        lblNewLabel_7_3_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_3_1.setBackground(Color.WHITE);
        lblNewLabel_7_3_1.setBounds(550, 289, 134, 44);
        contentPane.add(lblNewLabel_7_3_1);

        JLabel lblNewLabel_7 = new JLabel("Sistemas y computaci\u00F3n");
        lblNewLabel_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_7.setBackground(new Color(255, 255, 255));
        lblNewLabel_7.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7.setBounds(80, 85, 332, 44);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_7_3 = new JLabel("El\u00E9ctrica");
        lblNewLabel_7_3.setForeground(Color.WHITE);
        lblNewLabel_7_3.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_3.setBackground(Color.WHITE);
        lblNewLabel_7_3.setBounds(172, 289, 134, 44);
        contentPane.add(lblNewLabel_7_3);

        /*crear evento al seleccionar el modulo*/
        JLabel lblNewLabel_7_2 = new JLabel("Industrial");
        lblNewLabel_7_2.setForeground(Color.WHITE);
        lblNewLabel_7_2.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_2.setBackground(Color.WHITE);
        lblNewLabel_7_2.setBounds(876, 85, 155, 44);
        contentPane.add(lblNewLabel_7_2);
        /*crear evento al seleccionar el modulo*/

        JLabel lblNewLabel_7_1 = new JLabel("Electr\u00F3nica");
        lblNewLabel_7_1.setForeground(Color.WHITE);
        lblNewLabel_7_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
        lblNewLabel_7_1.setBackground(Color.WHITE);
        lblNewLabel_7_1.setBounds(863, 289, 168, 44);
        contentPane.add(lblNewLabel_7_1);
        /*crear evento al seleccionar el modulo*/

        JButton mecanica = new JButton("");
        mecanica.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1GEO2.png")));
        mecanica.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1GEO2.png")));
        mecanica.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1GEO.png")));
        mecanica.setFocusPainted(false);
        mecanica.setContentAreaFilled(false);
        mecanica.setBorderPainted(false);
        mecanica.setBounds(496, 547, 216, 122);
        contentPane.add(mecanica);
        mecanica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        JButton agricola = new JButton("");
        agricola.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/agricultura2.jpg")));
        agricola.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/agricultura3.jpg")));
        agricola.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/agricultura3.jpg")));
        agricola.setFocusPainted(false);
        agricola.setContentAreaFilled(false);
        agricola.setBorderPainted(false);
        agricola.setBounds(496, 332, 216, 122);
        contentPane.add(agricola);
        agricola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        JButton quimica = new JButton("");
        quimica.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1BIO2.png")));
        quimica.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1BIO2.png")));
        quimica.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1BIO.png")));
        quimica.setFocusPainted(false);
        quimica.setDefaultCapable(false);
        quimica.setContentAreaFilled(false);
        quimica.setBorderPainted(false);
        quimica.setBounds(496, 129, 216, 122);
        contentPane.add(quimica);
        quimica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        JButton mecatronica = new JButton("");
        mecatronica.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/mecatronica.jpg")));
        mecatronica.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/mecatronica3.jpg")));
        mecatronica.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/mecatronica3.jpg")));
        mecatronica.setFocusPainted(false);
        mecatronica.setDefaultCapable(false);
        mecatronica.setContentAreaFilled(false);
        mecatronica.setBorderPainted(false);
        mecatronica.setBounds(144, 547, 216, 122);
        contentPane.add(mecatronica);
        mecatronica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        JButton civil = new JButton("");
        civil.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1ART.png")));
        civil.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1ART2.png")));
        civil.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/1ART2.png")));
        civil.setFocusPainted(false);
        civil.setDefaultCapable(false);
        civil.setContentAreaFilled(false);
        civil.setBorderPainted(false);
        civil.setBounds(827, 547, 216, 122);
        contentPane.add(civil);
        civil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        JButton sistemas = new JButton("");
        sistemas.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/sistemas3.jpg")));
        sistemas.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/sistemas3.jpg")));
        sistemas.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/sistemas2.jpg")));
        sistemas.setFocusPainted(false);
        sistemas.setDefaultCapable(false);
        sistemas.setContentAreaFilled(false);
        sistemas.setBorderPainted(false);
        sistemas.setBounds(144, 129, 216, 122);
        contentPane.add(sistemas);
        /*crear evento al seleccionar el modulo sistemas*/
        sistemas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modulo_IngSistemas s = new Modulo_IngSistemas(courses);
                s.setVisible(true);
                close();
            }
        });


        JButton industrial = new JButton("");

        industrial.setFocusPainted(false);
        industrial.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/industrial3.jpg")));
        industrial.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/industrial3.jpg")));
        industrial.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/industrial2.jpg")));
        industrial.setDefaultCapable(false);
        industrial.setBorderPainted(false);
        industrial.setContentAreaFilled(false);
        industrial.setBounds(827, 129, 216, 122);
        contentPane.add(industrial);
        industrial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton electrica = new JButton("");

        electrica.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electrica3.jpg")));
        electrica.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electrica3.jpg")));
        electrica.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electrica2.jpg")));
        electrica.setBorderPainted(false);
        electrica.setFocusPainted(false);
        electrica.setContentAreaFilled(false);
        electrica.setBounds(144, 332, 216, 122);
        contentPane.add(electrica);
        electrica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        JButton electronica = new JButton("");

        electronica.setRolloverSelectedIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electronica3.jpg")));
        electronica.setRolloverIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electronica3.jpg")));
        electronica.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/electronica2.jpg")));
        electronica.setFocusPainted(false);
        electronica.setContentAreaFilled(false);
        electronica.setBorderPainted(false);
        electronica.setBounds(827, 332, 216, 122);
        contentPane.add(electronica);
        electronica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/fonfo.jpg")));
        lblNewLabel_3.setBounds(0, 74, 1201, 614);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(0, 0, 46, 14);
        contentPane.add(lblNewLabel_4);

        JPanel panel = new JPanel();
        panel.setForeground(Color.BLACK);
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBackground(new Color(0, 51, 0));
        panel.setBounds(0, 0, 1031, 74);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(1, 3, 0, 0));

        JPanel logoYnombre = new JPanel();
        logoYnombre.setForeground(Color.WHITE);
        panel.add(logoYnombre);
        logoYnombre.setLayout(new GridLayout(1, 3, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setIcon(new ImageIcon(PrincipalWindow.class.getResource("/images/logo.jpg")));
        logoYnombre.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("SIA Statistiken");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        logoYnombre.add(lblNewLabel);


        JPanel menu = new JPanel();
        menu.setBounds(1029, 0, 172, 74);
        contentPane.add(menu);
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        menu.add(menuBar);

        JMenu mnNewMenu = new JMenu("Options");
        mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 22));
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Statistics");
        mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
        mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);
    }

    public void close() {
        this.dispose();
    }
}
