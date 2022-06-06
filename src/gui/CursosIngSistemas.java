package gui;

import data.Course;
import data.DoubleList;
import data.Node;
import data.Queue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursosIngSistemas extends JFrame {

    private JPanel contentPane;
    private String[] nombreCursos;


    public CursosIngSistemas(DoubleList<Course> courses, String[] nombreCursos) {
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

        JLabel lblNewLabel = new JLabel("Cursos Ingenieria de Sistemas y Computacion");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(lblNewLabel);

        JList<String> listaDeCursos = new JList<String> (nombreCursos);
        listaDeCursos.setVisibleRowCount(15);
        JScrollPane desplazamiento = new JScrollPane(listaDeCursos);

        JPanel panelLista = new JPanel();
        contentPane.add(panelLista, BorderLayout.CENTER);

        panelLista.add(desplazamiento);

        listaDeCursos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               int index = listaDeCursos.getSelectedIndex();
               GruposIngSistemas g = new GruposIngSistemas(courses, seleccionDeGrupos(courses, index));
               g.setVisible(true);
               close();
            }
        });

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton_volver = new JButton("salir");
        btnNewButton_volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        panel_1.add(btnNewButton_volver);

    }

    public void close() {
        this.dispose();
    }

    /*dado un curso de la lista seleccionado, se muestran sus grupos*/
    public String[] seleccionDeGrupos(DoubleList<Course> courses, int index){

        String[] grupos = new String[30];
        Node aux = courses.getHead();
        for(int i=0; i < index; i++){
            aux = aux.getNext();
        }
        Course  curso = (Course) aux.getData();
        Queue listaDeGrupos = curso.getGroups();
        for(int i=0; i < listaDeGrupos.getSize(); i++){
            grupos[i] = (String) listaDeGrupos.dequeue();
        }
        return grupos;
    }

}

