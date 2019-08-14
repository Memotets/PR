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
public class MinimaDistancia implements ClasificadorSupervisado{

    @Override
    public void entrenar(ArrayList<Patron> interfaces) {
        ArrayList<PatronRepresentativo> representativos = new ArrayList();
        representativos.add(new PatronRepresentativo(interfaces.get(0)));
    }

    @Override
    public Patron clasificar(Patron aReconocer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
