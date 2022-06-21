package gui;

import data.Queue;
import data.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeCursos extends JFrame {

    private JPanel contentPane;
    private String[] nombreCursos;


    public ListaDeCursos(String nombreModulo, String descripcionModulo,
                         DoubleList<Course> courses, String[] nombreCursos) {
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

        JLabel lblNewLabel = new JLabel("Cursos " + nombreModulo);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(lblNewLabel);

        JList<String> listaDeCursos = new JList<String> (nombreCursos);
        listaDeCursos.setVisibleRowCount(15);
        JScrollPane desplazamiento = new JScrollPane(listaDeCursos);

        JPanel panelLista = new JPanel();
        contentPane.add(panelLista, BorderLayout.CENTER);

        panelLista.add(desplazamiento);

        /*mostrar los grupos de la materia seleccionada*/
        listaDeCursos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               int index = listaDeCursos.getSelectedIndex();
               ListaDeGrupos g = new ListaDeGrupos(courses, nombreCursoSeleccionado(courses, index),
                       seleccionDeGrupos(courses, index), nombreModulo, descripcionModulo);
               g.setVisible(true);
               close();
            }
        });

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton_volver = new JButton("volver");
        btnNewButton_volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modulo m = new Modulo(nombreModulo, descripcionModulo, courses);
                m.setVisible(true);
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

        String[] grupos = new String[100];
        Group grupo;
        String grupoInfo  = "";
        Node aux = courses.getHead();
        for(int i=0; i < index; i++){
            aux = aux.getNext();
        }
        // este es el curso seleccionado de la lista
        Course  curso = (Course) aux.getData();
        // obtenemos su lista de grupos
        Queue listaDeGrupos = curso.getGroups();

        //recorremos la lista de  grupos para obtener la info de cada grupo
        for(int i=0; i < listaDeGrupos.getSize(); i++){

            if(!listaDeGrupos.isEmpty()){
                grupo = (Group) listaDeGrupos.dequeue();
                grupoInfo = grupoInfo + (String) grupo.getNumber() + " " +
                            (String) grupo.getTeacher() + " " + grupo.getDate().getTime();
                grupos[i] = grupoInfo;
                grupoInfo = " ";
            }

        }
        return grupos;
    }

    public String nombreCursoSeleccionado(DoubleList<Course> courses, int index){
        Node aux = courses.getHead();
        for(int i=0; i < index; i++){
            aux = aux.getNext();
        }
        // este es el curso seleccionado de la lista
        Course  curso = (Course) aux.getData();
        return  curso.getCourseName();
    }

}

