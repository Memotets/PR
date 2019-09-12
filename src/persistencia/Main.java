/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import clasificadores.Herramientas.Manager;
import clasificadores.Herramientas.AnalisisResultado;
import clasificadores.Herramientas.Herramientas;
import clasificadores.Knn;
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
         
         
        Herramientas.leerDatos();
       
//        MinimaDistancia md = new MinimaDistancia();
//        md.entrenar(Herramientas.instancias);
//        md.clasificar(Herramientas.instancias);
//        System.out.println();

        Knn k= new Knn(1);
        k.entrenar(Herramientas.instancias);
        k.clasificar(Herramientas.instancias.get(0));
        
        Manager man = new Manager(Herramientas.instancias);
        man.ejecutarPrueba(true);
        AnalisisResultado AR = new AnalisisResultado(Herramientas.instancias);
        AR.sacarConfusion();
        AR.porcentaje();
        System.out.print(AR.toString());
        System.out.print("");
    }


}
