package gui;

import data.Course;
import data.DoubleList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeGrupos extends JFrame {

    private JPanel contentPane;
    private String[] nombreCursos;


    public ListaDeGrupos(DoubleList<Course> courses, String nombreCurso, String[] grupos,
                         String nombreModulo, String descripcionModulo) {
        this.nombreCursos = nombreCursos;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 488);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo (null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(34, 139, 34));
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Grupos de la materia " + nombreCurso);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(lblNewLabel);

        JList<String> listaDeGrupos = new JList<String> (grupos);
        listaDeGrupos.setVisibleRowCount(10);
        JScrollPane desplazamiento = new JScrollPane(listaDeGrupos);

        JPanel panelLista = new JPanel();
        contentPane.add(panelLista, BorderLayout.CENTER);

        panelLista.add(desplazamiento);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton_volver = new JButton("volver");
        btnNewButton_volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modulo m = new Modulo(nombreModulo, descripcionModulo,
                        courses);
                String[] nombreCursos = m.seleccionDeCursos(courses);
                ListaDeCursos c = new ListaDeCursos(nombreModulo, descripcionModulo,
                        courses, nombreCursos);
                c.setVisible(true);
                close();
            }
        });
        panel_1.add(btnNewButton_volver);

    }

    public void close() {
        this.dispose();
    }

}

