/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import clasificadores.Herramientas.PatronRepresentativo;
import clasificadores.Herramientas.Patron;
import clasificadores.Herramientas.AnalisisResultado;
import clasificadores.Herramientas.Herramientas;
import java.util.ArrayList;
/**
 *
 * @author memotets89
 */

public class MinimaDistancia implements Clasificador{

    ArrayList<PatronRepresentativo> representativos;
    AnalisisResultado analisis;
    
    public MinimaDistancia(){
         this.representativos = new ArrayList();
    }
    
    @Override
    public void entrenar(ArrayList<Patron> interfaces) {
        
        this.representativos.add(new PatronRepresentativo(interfaces.get(0)));
    
        for (int i =1; i<interfaces.size(); i++) {
            Patron aux = interfaces.get(i);
            
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
    }

 @Override
    public void clasificar(Patron patron) {
        int iMenor=0;
        double dMenor = Herramientas.calcularDistanciaEuclidiana
        (patron,this.representativos.get(0));
        
        // en proceso iterativo calcular las distancias con respecto a los representativos
        for(int i = 1; i < this.representativos.size();i+=1){
            double dN = Herramientas.calcularDistanciaEuclidiana(patron,this.representativos.get(i));
            if(dN<dMenor){
                dMenor = dN;
                iMenor = i;
            }
        }
        patron.setResultante(
                this.representativos.get(iMenor).getClase());
        
       
}    

    @Override
    public void clasificar(ArrayList<Patron> interfaces) {
        interfaces.forEach((p) -> {
            this.clasificar(p);
        });
        this.analisis = new AnalisisResultado(interfaces);
        this.analisis.sacarConfusion();
        System.out.println(this.analisis.toString());
        System.out.println("porcentaje: "+this.analisis.porcentaje()+"\n");
    }
    
    public double Porcentaje(){
        return this.analisis.porcentaje();
    }
}
