/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores.Herramientas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author memotets89
 */
public class AnalisisResultado {
    public ArrayList<Patron> instancias;
    public   ArrayList<PatronRepresentativo> representativos;
    public int [][] matrizConfucion;
    public int cont;
    
    public AnalisisResultado(ArrayList<Patron> ins){
        this.instancias=ins;
        
        this.representativos = new ArrayList<>();
          for (int i =1; i<instancias.size(); i++) {
            Patron aux = instancias.get(i);
            int pos = this.representativos.indexOf(aux);
            if(pos!=-1){
                this.representativos.get(pos).acumular(aux);
            }else{
                this.representativos.add(new PatronRepresentativo (aux));
            }
        }
        this.representativos.forEach((a) -> {
            a.actualizar();
        });
         
         cont=representativos.size();
         
         this.matrizConfucion= new int[cont][cont];
         
         
    }
//    
//    public double[] porcentajes(){
//        double[] aux= new double[this.cont];
//        for (int i=0; i<cont;i++){
//            for(int j =0; j<cont; j++){
//                if (i==j){
    
//            }else{
//              }
//        }
//        aux/=instancias.size();
//        aux *= 100;
//        return aux;
//    }
    
    public double porcentaje(){
        double aux=0;
        for (int i=0; i<instancias.size();i++){
            if(this.instancias.get(i).getClase().equals(this.instancias.get(i).getResultante())){
                aux++;
            }
        }
        aux/=instancias.size();
        aux *= 100;
        return aux;
    }
    
    public void sacarConfusion(){
        int clas =0;
        int res =0;        
        for (int i=0; i<instancias.size();i++){
            for (int j=0;j<this.cont;j++){
                if(this.representativos.get(j).getClase().equals(this.instancias.get(i).getClase())){
                    clas = j;
                    break;
                }
            }
            for (int j=0;j<this.cont;j++){
                if(this.representativos.get(j).getClase().equals(this.instancias.get(i).getResultante())){
                    res = j;
                     break;
                }
            }
            this.matrizConfucion[clas][res]++;
            }           
        }

    @Override
    public String toString() {
      String aux ="";
        for(int [] vector: this.matrizConfucion){
           aux+="| ";
            for (int num: vector){
               aux += num+" | ";
           }
           aux += "\n";
        }
        return aux;
    }


        
}
    

