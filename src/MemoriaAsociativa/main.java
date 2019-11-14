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
    lista.add(new Patron (new double[]{2.1,3.8},"1" ));
    lista.add(new Patron (new double[]{6.3,3.8},"2" ));

    
    CAP test = new CAP();
    test.entrenar(lista);
    test.imprimirLernmatrix();
    test.clasificar(lista);
    test.imprimirRecuperacion();
        
    }
    
}
