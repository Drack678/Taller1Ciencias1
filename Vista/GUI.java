package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField valorN, valorM, valorK;
    private JComboBox<String> varEleccion, distribucion;
    private JLabel comparaciones, intercambios, tiempo, ganador;
    private JLabel ricComparaciones, ricIntercambios, ricTiempo;
    private JButton ordenarButton;
    private JScrollPane candidatos;

    public GUI() {
        setTitle("Eleccion con metodos de ordenamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Pantalla completa al iniciar
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Panel superior con campos y combos
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        valorN = new JTextField();
        valorM = new JTextField();
        valorK = new JTextField();
        varEleccion = new JComboBox<>(new String[]{
                "Distancia en marchas",
                "Clases perdidas",
                "Valor prebendas",
                "Numero de sobornos",
                "Corrupcion"
        });
        distribucion = new JComboBox<>(new String[]{
                "Orden inverso",
                "Casi ordenada",
                "Aleatoria uniforme"
        });

        topPanel.add(new JLabel("Valor N:")); topPanel.add(valorN);
        topPanel.add(new JLabel("Valor M:")); topPanel.add(valorM);
        topPanel.add(new JLabel("Valor K:")); topPanel.add(valorK);
        topPanel.add(new JLabel("Variable de eleccion:")); topPanel.add(varEleccion);
        topPanel.add(new JLabel("Distribucion de la lista a ordenar:")); topPanel.add(distribucion);

        add(topPanel, BorderLayout.NORTH);

        // Panel central con scroll vertical
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        candidatos = new JScrollPane(scrollPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Lista de candidatos"));
        centerPanel.add(candidatos, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));

        // Subpanel para los 3 labels de resultados en la misma línea
        JPanel labelsPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        comparaciones = new JLabel("Comparaciones:", SwingConstants.CENTER);
        intercambios = new JLabel("Intercambios:", SwingConstants.CENTER);
        tiempo = new JLabel("Tiempo:", SwingConstants.CENTER);

        labelsPanel.add(comparaciones);
        labelsPanel.add(intercambios);
        labelsPanel.add(tiempo);

        bottomPanel.add(labelsPanel, BorderLayout.NORTH);

        // Subpanel para los 3 labels de RIC debajo
        JPanel ricPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        ricComparaciones = new JLabel("RIC Comparaciones:", SwingConstants.CENTER);
        ricIntercambios = new JLabel("RIC Intercambios:", SwingConstants.CENTER);
        ricTiempo = new JLabel("RIC Tiempo:", SwingConstants.CENTER);

        ricPanel.add(ricComparaciones);
        ricPanel.add(ricIntercambios);
        ricPanel.add(ricTiempo);

        bottomPanel.add(ricPanel, BorderLayout.CENTER);

        // Label ganador debajo de los labels de RIC
        ganador = new JLabel("Ganador:", SwingConstants.CENTER);
        bottomPanel.add(ganador, BorderLayout.SOUTH);

        // Botón centrado
        ordenarButton = new JButton("Ordenar");
        ordenarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparaciones.setText("Comparaciones: " + valorN.getText());
                intercambios.setText("Intercambios: " + valorM.getText());
                tiempo.setText("Tiempo: " + valorK.getText());
                ganador.setText("Ganador: Candidato " + valorN.getText()); // Ejemplo
                // Ejemplo de actualización de RIC
                ricComparaciones.setText("RIC Comparaciones: " + valorN.getText());
                ricIntercambios.setText("RIC Intercambios: " + valorM.getText());
                ricTiempo.setText("RIC Tiempo: " + valorK.getText());
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(ordenarButton);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Getters y setters para los campos y labels
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

    public JLabel getGanador() { return ganador; }
    public void setGanadorText(String text) { ganador.setText(text); }

    public JLabel getRicComparaciones() { return ricComparaciones; }
    public void setRicComparacionesText(String text) { ricComparaciones.setText(text); }

    public JLabel getRicIntercambios() { return ricIntercambios; }
    public void setRicIntercambiosText(String text) { ricIntercambios.setText(text); }

    public JLabel getRicTiempo() { return ricTiempo; }
    public void setRicTiempoText(String text) { ricTiempo.setText(text); }

    public JScrollPane getCandidatos() { return candidatos; }
    public void setCandidatos(JScrollPane candidatos) { this.candidatos = candidatos; }

    public JButton getOrdenarButton() { return ordenarButton; }

    public static void main(String[] args) {
        new GUI();
    }
}






