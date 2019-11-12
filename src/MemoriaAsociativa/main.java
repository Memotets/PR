/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoriaAsociativa;

import clasificadores.Herramientas.Patron;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class main {
    public static void main(String[] args) throws IOException {
    
    ArrayList<Patron> lista = new ArrayList<>();
    lista.add(new Patron (new double[]{1,0,1,0,1},"1" ));
    lista.add(new Patron (new double[]{1,1,0,0,1},"2" ));
    lista.add(new Patron (new double[]{1,0,1,1,0},"3" ));
    lista.add(new Patron (new double[]{0,1,0,1,1},"1" ));
    lista.add(new Patron (new double[]{0,0,1,0,1},"3" ));
    
    Steinbuch test = new Steinbuch();
    test.entrenar(lista);
    test.imprimirLernmatrix();
    test.clasificar(lista);
    test.imprimirRecuperacion();
        
    }
    
}
