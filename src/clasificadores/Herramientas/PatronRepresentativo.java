/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores.Herramientas;

/**
 *
 * @author memotets89
 */
public class PatronRepresentativo extends Patron{
    
    private int contador;
    
     public PatronRepresentativo(Patron n, String a) {
        super(n.getVector(), a);
        contador=0;
        acumular(n);
    }
        
    public PatronRepresentativo(Patron n) {
        super(n.getVector().length);
        super.setClase( n.getClase());
        contador=0;
        acumular(n);
    }

    public void acumular(Patron n) {
      double aux=0;
        for (int i =0; i<n.getVector().length;i++){
            super.getVector()[i]+= n.getVector()[i];
        }
        this.contador ++;
    }
    
    public void actualizar(){
        for (int i =0; i<super.getVector().length;i++){
            super.getVector()[i]/= this.contador;
        }
        this.contador = 0;
    }

    @Override
    public boolean equals(Object obj) {
        
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String aux= "Valores: {";
        for (double a: this.getVector()){
            aux+= " "+a+",";
        }
        aux += "} ->" + this.getClase();
        return aux;
    }
    
    

    
    
}
