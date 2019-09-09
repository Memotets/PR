/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Grafica.Manager;
import clasificadores.Herramientas;
import clasificadores.MinimaDistancia;

import java.io.IOException;

/**
 *
 * @author memotets89
 */
public class Main {
    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException{
         
        int[] arreglo= {1,0,1,0};
         
        Herramientas.leerDatos(arreglo);
       
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println();
        
        Manager man = new Manager(Herramientas.instancias);
        man.ejecutarPrueba(true);
        
    }


}
