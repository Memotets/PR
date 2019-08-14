/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

/**
 *
 * @author memotets89
 */
public class Herramientas {
    public static double calcularDistanciaEuclidiana(Patron a, Patron b){
        double sumadorAux=0;
        for (int i =0; i<a.getVector().length;i++){
            sumadorAux += Math.pow((a.getVector()[i]-a.getVector()[i]),2);
        }
        return Math.sqrt(sumadorAux);
    }
    
}
