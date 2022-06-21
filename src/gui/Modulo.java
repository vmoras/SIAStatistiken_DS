package gui;

import data.Course;
import data.DoubleList;
import data.Node;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modulo extends JFrame {

    private JPanel contentPane;


    public Modulo(String nombreModulo, String descripcionModulo, DoubleList<Course> courses) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1149, 606);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo (null);

        JButton btnNewButton_Volver = new JButton("volver");
        btnNewButton_Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrincipalWindow p = new PrincipalWindow(courses);
                p.setVisible(true);
                close();
            }
        });
        btnNewButton_Volver.setBounds(960, 510, 89, 23);
        contentPane.add(btnNewButton_Volver);

        JButton btnNewButton_Cursos = new JButton("Cursos");
        btnNewButton_Cursos.setFont(new Font("Segoe UI Light", Font.BOLD, 22));
        btnNewButton_Cursos.setBounds(527, 453, 129, 32);
        contentPane.add(btnNewButton_Cursos);
        btnNewButton_Cursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ListaDeCursos c = new ListaDeCursos(nombreModulo, descripcionModulo, courses, seleccionDeCursos(courses));
                c.setVisible(true);
                close();
            }
        });

        JTextArea descripcion = new JTextArea();
        descripcion.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
        descripcion.setBackground(new Color(34, 139, 34));
        /*se agrega la descripcion del modulo*/
        descripcion.setText(descripcionModulo);

        descripcion.setBounds(81, 98, 976, 282);
        contentPane.add(descripcion);

        JLabel lblNewLabel_7_5_1 = new JLabel("Informaci\u00F3n de cursos");
        lblNewLabel_7_5_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_7_5_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
        lblNewLabel_7_5_1.setBackground(new Color(0, 0, 0));
        lblNewLabel_7_5_1.setBounds(179, 451, 325, 44);
        contentPane.add(lblNewLabel_7_5_1);


        JLabel cursos = new JLabel("");
        cursos.setBackground(new Color(255, 140, 0));
        cursos.setIcon(new ImageIcon(Modulo.class.getResource("/images/fonfo.jpg")));
        cursos.setBounds(0, 74, 1201, 493);
        contentPane.add(cursos);

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

        /*se agrega el nombre del modulo*/
        JLabel lblNewLabel = new JLabel(nombreModulo);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        logoYnombre.add(lblNewLabel);


        JPanel menu = new JPanel();
        menu.setBounds(1029, 0, 104, 74);
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

        JLabel lblNewLabel_2 = new JLabel("C\u00F3digo SNIES: 16941, C\u00F3digo SIA: 2545, Cr\u00E9ditos totales: 172, Metodolog\u00EDa: Presencial, Jornada: Diurna");
        lblNewLabel_2.setBounds(212, 179, 46, 14);
        contentPane.add(lblNewLabel_2);
    }

    public void close() {
        this.dispose();
    }

    /*hacer que solo se seleccionen los cursos de la carrera seleccionada
    * haciendo que la funcion reciba como parametro el nombre de la carrera*/
    public String[] seleccionDeCursos(DoubleList<Course> courses){
        /*arreglo para guardar los nombres de los cursos
        * 300 porque se estan capturando alrededor de +/-250 en el proceso de web scraping */
        String[] nombreCursos = new String[300];
        Node aux = courses.getHead();
        for(int i=0; i < courses.getSize(); i++){
            Course  curso = (Course) aux.getData();
            nombreCursos[i] = curso.getCourseName();
            aux = aux.getNext();
        }

        return nombreCursos;
    }
}
