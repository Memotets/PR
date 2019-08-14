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
public interface ClasificardorSupervisado {

    /**
     *
     * @param interfaces aqui estaran todas las 
     *  muestras con sus patrones elegidos.
     */
    public void entrenar(ArrayList<Patron> interfaces);

    /**
     *
     * @param aReconocer Es el patron que se desconoce
     *  
     * @return Reconocimiento encontrado.
     */
    public Patron clasificar(Patron aReconocer);
}
