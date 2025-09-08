package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Control implements ActionListener{
    private GeneradorDatos generador;
    private GUI gui;
    private Ordenamiento ordenador;
    private Candidato[] candidatos;

    public Control(){
        this.generador = new GeneradorDatos();
        this.gui = new GUI();
        this.ordenador = new Ordenamiento();
        gui.getOrdenarButton().addActionListener(this);
    }
    
    public static double percentile(double[] sortedData, double p) {
        int n = sortedData.length;
        double rank = (p / 100.0) * (n - 1);
        int low = (int) Math.floor(rank);
        int high = (int) Math.ceil(rank);
        return sortedData[low] + (rank - low) * (sortedData[high] - sortedData[low]);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.gui.getOrdenarButton()){
            int n = Integer.parseInt(this.gui.getValorN().getText());
            int m = Integer.parseInt(this.gui.getValorM().getText());
            int k =  Integer.parseInt(this.gui.getValorK().getText());

            if(this.gui.getDistribucion().getSelectedItem().equals("Casi ordenada")){
                this.candidatos = this.generador.generar(n, m, "Casi ordenada");
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    this.gui.getCandidatos().add(label);
                }
            }
            else if(this.gui.getDistribucion().getSelectedItem().equals("Orden inverso")){
                this.candidatos = this.generador.generar(n, m, "inversa");
            }
            else if(this.gui.getDistribucion().getSelectedItem().equals("Aleatoria uniforme")){
                this.candidatos = this.generador.generar(n, m, "uniforme");
            }

            if (this.gui.getVarEleccion().getSelectedItem().equals("Distancia en marchas")){
                long mediaTiempo = 0;
                double mediaComparaciones = 0;
                double mediaIntercambios = 0;
                double[]tiempos = new double[k];
                double[]comparaciones = new double[k];
                double[]intercambios = new double[k];

                for(int i=0; i<k; i++){
                    ordenador.setTiempo(0);
                    ordenador.setComparaciones(0);
                    ordenador.setIntercambios(0);
                    ordenador.bubbleSort(this.candidatos);
                    tiempos[i] = ordenador.getTiempo();
                    comparaciones[i] = ordenador.getComparaciones();
                    intercambios[i] = ordenador.getIntercambios(); 
                    mediaComparaciones += ordenador.getComparaciones();
                    mediaIntercambios += ordenador.getIntercambios();
                    mediaTiempo += ordenador.getTiempo();
                }
                Arrays.sort(tiempos);
                Arrays.sort(comparaciones);
                Arrays.sort(intercambios);
                double ricTiempo = percentile(tiempos, 75) - percentile(tiempos, 25);
                double ricComparaciones = percentile(comparaciones, 75) - percentile(comparaciones, 25);
                System.out.println(percentile(comparaciones, 75));
                System.out.println(percentile(comparaciones, 25));
                double ricIntercambios = percentile(intercambios, 75) - percentile(intercambios, 25);
                mediaTiempo = mediaTiempo/k;
                mediaComparaciones = mediaComparaciones/k;
                mediaIntercambios = mediaIntercambios/k;
                JPanel panel = this.gui.getScrollPanel();
                panel.removeAll();
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    panel.add(label);
                }
                panel.revalidate();
                panel.repaint();
                this.gui.getComparaciones().setText("Media de comparaciones:"+mediaComparaciones);
                this.gui.getIntercambios().setText("Media de intercambios"+mediaIntercambios);
                this.gui.getTiempo().setText("Media de tiempo:"+mediaTiempo);
                this.gui.getRicComparaciones().setText("RIC comparaciones:"+ricComparaciones);
                this.gui.getRicIntercambios().setText("RIC intercambios"+ricIntercambios);
                this.gui.getRicTiempo().setText("RIC tiempo"+ricTiempo);
                Candidato c = candidatos[0];
                this.gui.getGanador().setText("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
            }
            else if(this.gui.getVarEleccion().getSelectedItem().equals("Clases perdidas")) {
                long mediaTiempo = 0;
                double mediaComparaciones = 0;
                double mediaIntercambios = 0;
                double[]tiempos = new double[k];
                double[]comparaciones = new double[k];
                double[]intercambios = new double[k];

                for(int i=0; i<k; i++){
                    ordenador.setTiempo(0);
                    ordenador.setComparaciones(0);
                    ordenador.setIntercambios(0);
                    ordenador.insetionSort(candidatos);
                    tiempos[i] = ordenador.getTiempo();
                    comparaciones[i] = ordenador.getComparaciones();
                    intercambios[i] = ordenador.getIntercambios(); 
                    mediaComparaciones += ordenador.getComparaciones();
                    mediaIntercambios += ordenador.getIntercambios();
                    mediaTiempo += ordenador.getTiempo();
                }
                Arrays.sort(tiempos);
                Arrays.sort(comparaciones);
                Arrays.sort(intercambios);
                double ricTiempo = percentile(tiempos, 75) - percentile(tiempos, 25);
                double ricComparaciones = percentile(comparaciones, 75) - percentile(comparaciones, 25);
                double ricIntercambios = percentile(intercambios, 75) - percentile(intercambios, 25);
                mediaTiempo = mediaTiempo/k;
                mediaComparaciones = mediaComparaciones/k;
                mediaIntercambios = mediaIntercambios/k;
                JPanel panel = this.gui.getScrollPanel();
                panel.removeAll();
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    panel.add(label);
                }
                panel.revalidate();
                panel.repaint();
                this.gui.getComparaciones().setText("Media de comparaciones:"+mediaComparaciones);
                this.gui.getIntercambios().setText("Media de intercambios"+mediaIntercambios);
                this.gui.getTiempo().setText("Media de tiempo:"+mediaTiempo);
                this.gui.getRicComparaciones().setText("RIC comparaciones:"+ricComparaciones);
                this.gui.getRicIntercambios().setText("RIC intercambios"+ricIntercambios);
                this.gui.getRicTiempo().setText("RIC tiempo"+ricTiempo);
                Candidato c = candidatos[0];
                this.gui.getGanador().setText("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
            }
            else if(this.gui.getVarEleccion().getSelectedItem().equals("Valor prebendas")){
                long mediaTiempo = 0;
                double mediaComparaciones = 0;
                double mediaIntercambios = 0;
                double[]tiempos = new double[k];
                double[]comparaciones = new double[k];
                double[]intercambios = new double[k];

                for(int i=0; i<k; i++){
                    ordenador.setTiempo(0);
                    ordenador.setComparaciones(0);
                    ordenador.setIntercambios(0);
                    this.candidatos=ordenador.mergeSort(this.candidatos);
                    tiempos[i] = ordenador.getTiempo();
                    comparaciones[i] = ordenador.getComparaciones();
                    intercambios[i] = ordenador.getIntercambios(); 
                    mediaComparaciones += ordenador.getComparaciones();
                    mediaIntercambios += ordenador.getIntercambios();
                    mediaTiempo += ordenador.getTiempo();
                }
                Arrays.sort(tiempos);
                Arrays.sort(comparaciones);
                Arrays.sort(intercambios);
                double ricTiempo = percentile(tiempos, 75) - percentile(tiempos, 25);
                double ricComparaciones = percentile(comparaciones, 75) - percentile(comparaciones, 25);
                double ricIntercambios = percentile(intercambios, 75) - percentile(intercambios, 25);
                mediaTiempo = mediaTiempo/k;
                mediaComparaciones = mediaComparaciones/k;
                mediaIntercambios = mediaIntercambios/k;
                JPanel panel = this.gui.getScrollPanel();
                panel.removeAll();
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    panel.add(label);
                }
                panel.revalidate();
                panel.repaint();
                this.gui.getComparaciones().setText("Media de comparaciones:"+mediaComparaciones);
                this.gui.getIntercambios().setText("Media de intercambios"+mediaIntercambios);
                this.gui.getTiempo().setText("Media de tiempo:"+mediaTiempo);
                this.gui.getRicComparaciones().setText("RIC comparaciones:"+ricComparaciones);
                this.gui.getRicIntercambios().setText("RIC intercambios"+ricIntercambios);
                this.gui.getRicTiempo().setText("RIC tiempo"+ricTiempo);
                Candidato c = candidatos[0];
                this.gui.getGanador().setText("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());

            }
            else if(this.gui.getVarEleccion().getSelectedItem().equals("Numero de sobornos")){
                long mediaTiempo = 0;
                double mediaComparaciones = 0;
                double mediaIntercambios = 0;
                double[]tiempos = new double[k];
                double[]comparaciones = new double[k];
                double[]intercambios = new double[k];

                for(int i=0; i<k; i++){
                    ordenador.setTiempo(0);
                    ordenador.setComparaciones(0);
                    ordenador.setIntercambios(0);
                    this.candidatos=ordenador.seleccionSort(this.candidatos);
                    tiempos[i] = ordenador.getTiempo();
                    comparaciones[i] = ordenador.getComparaciones();
                    intercambios[i] = ordenador.getIntercambios(); 
                    mediaComparaciones += ordenador.getComparaciones();
                    mediaIntercambios += ordenador.getIntercambios();
                    mediaTiempo += ordenador.getTiempo();
                }
                Arrays.sort(tiempos);
                Arrays.sort(comparaciones);
                Arrays.sort(intercambios);
                double ricTiempo = percentile(tiempos, 75) - percentile(tiempos, 25);
                double ricComparaciones = percentile(comparaciones, 75) - percentile(comparaciones, 25);
                double ricIntercambios = percentile(intercambios, 75) - percentile(intercambios, 25);
                mediaTiempo = mediaTiempo/k;
                mediaComparaciones = mediaComparaciones/k;
                mediaIntercambios = mediaIntercambios/k;
                JPanel panel = this.gui.getScrollPanel();
                panel.removeAll();
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    panel.add(label);
                }
                panel.revalidate();
                panel.repaint();
                this.gui.getComparaciones().setText("Media de comparaciones:"+mediaComparaciones);
                this.gui.getIntercambios().setText("Media de intercambios"+mediaIntercambios);
                this.gui.getTiempo().setText("Media de tiempo:"+mediaTiempo);
                this.gui.getRicComparaciones().setText("RIC comparaciones:"+ricComparaciones);
                this.gui.getRicIntercambios().setText("RIC intercambios"+ricIntercambios);
                this.gui.getRicTiempo().setText("RIC tiempo"+ricTiempo);
                Candidato c = candidatos[0];
                this.gui.getGanador().setText("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());

            }
            else if(this.gui.getVarEleccion().getSelectedItem().equals("Corrupcion")){
                long mediaTiempo = 0;
                double mediaComparaciones = 0;
                double mediaIntercambios = 0;
                double[]tiempos = new double[k];
                double[]comparaciones = new double[k];
                double[]intercambios = new double[k];

                for(int i=0; i<k; i++){
                    ordenador.setTiempo(0);
                    ordenador.setComparaciones(0);
                    ordenador.setIntercambios(0);
                    ordenador.quickSort(this.candidatos, 0, this.candidatos.length-1);
                    tiempos[i] = ordenador.getTiempo();
                    comparaciones[i] = ordenador.getComparaciones();
                    intercambios[i] = ordenador.getIntercambios(); 
                    mediaComparaciones += ordenador.getComparaciones();
                    mediaIntercambios += ordenador.getIntercambios();
                    mediaTiempo += ordenador.getTiempo();
                }
                Arrays.sort(tiempos);
                Arrays.sort(comparaciones);
                Arrays.sort(intercambios);
                double ricTiempo = percentile(tiempos, 75) - percentile(tiempos, 25);
                double ricComparaciones = percentile(comparaciones, 75) - percentile(comparaciones, 25);
                double ricIntercambios = percentile(intercambios, 75) - percentile(intercambios, 25);
                mediaTiempo = mediaTiempo/k;
                mediaComparaciones = mediaComparaciones/k;
                mediaIntercambios = mediaIntercambios/k;
                JPanel panel = this.gui.getScrollPanel();
                panel.removeAll();
                for(Candidato c : this.candidatos){
                    JLabel label = new JLabel("id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
                    panel.add(label);
                }
                panel.revalidate();
                panel.repaint();
                this.gui.getComparaciones().setText("Media de comparaciones:"+mediaComparaciones);
                this.gui.getIntercambios().setText("Media de intercambios"+mediaIntercambios);
                this.gui.getTiempo().setText("Media de tiempo:"+mediaTiempo);
                this.gui.getRicComparaciones().setText("RIC comparaciones:"+ricComparaciones);
                this.gui.getRicIntercambios().setText("RIC intercambios"+ricIntercambios);
                this.gui.getRicTiempo().setText("RIC tiempo"+ricTiempo);
                Candidato c = candidatos[0];
                this.gui.getGanador().setText("El ganador es: "+"id:"+c.getId()+","+" distancia en marchas:"+c.getDistanciaMarchas()+","+" clases perdidas:"+c.getClasesPerdidas()+","+" valor prebendas:"+c.getValorPrebendas()+","+" numero de sobornos:"+c.getNumSobornos()+","+" corrupcion:"+c.getValorCorrupcion());
            }


        }
    }
}
