/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public interface ClasificadorSupervisado {

    /**
     *
     * @param interfaces aqui estaran todas las 
     *  muestras con sus patrones elegidos.
     */
    public void entrenar(ArrayList<Patron> interfaces);
    public void clasificar(Patron aReconocer);
    public void clasificar(ArrayList<Patron> interfaces);
}