/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import static org.jfree.chart.ChartFactory.createScatterPlot;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author Alumno
 */
public class Grafica {
    private JFreeChart grafica;
    
    private XYSeriesCollection series;
    private String ejeX,ejeY,titulo;
    
    public Grafica(String ejeX, String ejeY, String titulo){
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.titulo=titulo;
        this.ejeX=ejeX;
        this.ejeY=ejeY;
        
    }
    
    public void agregarSerie(double[] datos, String id){
        //crear la serie
        XYSeries serie = new XYSeries(id);
            for(int x=0; x< datos.length;x++){
                serie.add(x, datos[x]);
                
            }
            this.series.addSeries(serie);
    }
    
     public void agregarSerie(Double[] datos, String id){
        //crear la serie
        XYSeries serie = new XYSeries(id);
            for(int x=0; x< datos.length;x++){
                serie.add(x, datos[x]);
                
            }
            this.series.addSeries(serie);
    }
      public void agregarSerie(double[] caracteristica1,double[] caracteristica2,  String id){
        //crear la serie
        XYSeries serie = new XYSeries(id);
            for(int x=0; x< caracteristica1.length;x++){
                serie.add(caracteristica1[x], caracteristica2[x]);   
            }
            this.series.addSeries(serie);
    }
    
    public void creaYmuestraGrafica(){
           grafica = createScatterPlot(titulo, ejeX, ejeY, series);
           ChartFrame panel = new ChartFrame(titulo, grafica);
           panel.pack();
           panel.setVisible(true);
    }
}
