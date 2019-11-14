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
    lista.add(new Patron (new double[]{2.0,3.0,6.0},"1" ));
    lista.add(new Patron (new double[]{6.0,8.0,10.0},"2" ));
    ArrayList<Patron> lista2 = new ArrayList<>();
    lista2.add(new Patron (new double[]{1.9,3.8,5.5},"1" ));
    lista2.add(new Patron (new double[]{6.4,7.2,9.7},"2" ));
    
    CAP test = new CAP();
    test.entrenar(lista);
    test.imprimirLernmatrix();
    test.clasificar(lista2);
    test.imprimirRecuperacion();
        
    }
    
}
