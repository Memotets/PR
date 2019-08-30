/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
        
        Herramientas.leerDatos( new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0});
        
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println();
        
    }


}
