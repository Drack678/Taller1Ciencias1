package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField valorN, valorM, valorK;
    private JComboBox<String> varEleccion, distribucion;
    private JLabel comparaciones, intercambios, tiempo;
    private JButton ordenarButton;

    public GUI() {
        setTitle("Eleccion con metodos de ordenamiento");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Centrar ventana al iniciar
        setLocationRelativeTo(null);

        // Panel superior con campos y combos
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        valorN = new JTextField();
        valorM = new JTextField();
        valorK = new JTextField();
        varEleccion = new JComboBox<>(new String[]{"Distancia en marchas", "Clases perdidas", "Valor prebendas","Numero de sobornos","Corrupcion"});
        distribucion = new JComboBox<>(new String[]{"Orden inverso", "Casi ordenada", "Aleatoria uniforme"});

        topPanel.add(new JLabel("Valor N:")); topPanel.add(valorN);
        topPanel.add(new JLabel("Valor M:")); topPanel.add(valorM);
        topPanel.add(new JLabel("Valor k:")); topPanel.add(valorK);
        topPanel.add(new JLabel("Variable de eleccion:")); topPanel.add(varEleccion);
        topPanel.add(new JLabel("Distribucion de la lista a ordenar:")); topPanel.add(distribucion);

        add(topPanel, BorderLayout.NORTH);

        // Panel central con scroll vertical
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(scrollPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Lista de candidatos"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));

        // Subpanel para los 3 labels en una misma línea
        JPanel labelsPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        comparaciones = new JLabel("Comparaciones:", SwingConstants.CENTER);
        intercambios = new JLabel("Intercambios:", SwingConstants.CENTER);
        tiempo = new JLabel("Tiempo:", SwingConstants.CENTER);

        labelsPanel.add(comparaciones);
        labelsPanel.add(intercambios);
        labelsPanel.add(tiempo);

        bottomPanel.add(labelsPanel, BorderLayout.NORTH);

        // Botón centrado
        ordenarButton = new JButton("Ordenar");
        ordenarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Listener para actualizar labels
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparaciones.setText("Comparaciones: " + valorN.getText());
                intercambios.setText("Intercambios: " + valorM.getText());
                tiempo.setText("Tiempo: " + valorK.getText());
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(ordenarButton);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getValorN() { return valorN; }
    public void setValorN(String text) { valorN.setText(text); }

    public JTextField getValorM() { return valorM; }
    public void setValorM(String text) { valorM.setText(text); }

    public JTextField getValorK() { return valorK; }
    public void setValorK(String text) { valorK.setText(text); }

    public JComboBox<String> getVarEleccion() { return varEleccion; }
    public void setVarEleccion(String value) { varEleccion.setSelectedItem(value); }

    public JComboBox<String> getDistribucion() { return distribucion; }
    public void setDistribucion(String value) { distribucion.setSelectedItem(value); }

    public JLabel getComparaciones() { return comparaciones; }
    public void setComparacionesText(String text) { comparaciones.setText(text); }

    public JLabel getIntercambios() { return intercambios; }
    public void setIntercambiosText(String text) { intercambios.setText(text); }

    public JLabel getTiempo() { return tiempo; }
    public void setTiempoText(String text) { tiempo.setText(text); }

    public JButton getOrdenarButton() { return ordenarButton; }

    public static void main(String[] args) {
        new GUI();
    }
}




