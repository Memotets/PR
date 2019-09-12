/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores.Herramientas;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class Manager {
    private ArrayList<Patron> metodos;
    private ArrayList<PatronRepresentativo> series;
    public Manager(){
        this.metodos= new ArrayList<>();
    }
    public Manager(ArrayList cosa){
        this.metodos=cosa;
             
        this.series = new ArrayList<>();
          for (int i =1; i<metodos.size(); i++) {
            Patron aux = metodos.get(i);
            int pos = this.series.indexOf(aux);
            if(pos!=-1){
                this.series.get(pos).acumular(aux);
            }else{
                this.series.add(new PatronRepresentativo (aux));
            }
        }
        this.series.forEach((a) -> {
            a.actualizar();
        });
    }
    
    
    public void ejecutarPrueba (boolean grafica){
       double[][] DatoA = new double[this.series.size()][this.metodos.size()];
       double[][] DatoB = new double[this.series.size()][this.metodos.size()];
        
            int clas = 0;
            for(int a=0; a<this.metodos.size() ; a++){
                
                for (int j=0;j<this.series.size();j++){
                    if(this.series.get(j).getClase().equals(this.metodos.get(a).getClase())){
                        clas = j;
                        break;
                    }
                }
                
                Patron aux = this.metodos.get(a);
                double vector[]=aux.getVector();

                
                DatoA[clas][a] = vector[0];
                DatoB[clas][a] = vector[1];
                System.out.println(a);
            }
        
       if(grafica){
            Grafica g = new Grafica("DatoA", "DatoB", "Prueba basica");
            for (int x=0; x<this.series.size(); x++){
                g.agregarSerie(DatoA[x], DatoB[x], this.series.get(x).getClase());
            }
                g.creaYmuestraGrafica();
       }
    }
    
}
