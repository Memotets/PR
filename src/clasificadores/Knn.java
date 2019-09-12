/* ______________________________________________________________________
 *                                                          Entrenamiento
 *Recibe conjunto de patrones
 *Conoce las clases involucradas
 * ______________________________________________________________________
 *
 *______________________________________________________________________________
 *                                                           Clasificador
 *Recibe el patron/muestra a clasificar 
 *Calcula las distancias entre el patron anterior con respecto a la instancia de entrenamieto
 *ordenarlas
 *Verificar la clase que cumple primero con el numero k de vecinos más cercanos
 *______________________________________________________________________________ 
*/
package clasificadores;

import clasificadores.Herramientas.AnalisisResultado;
import clasificadores.Herramientas.Herramientas;
import clasificadores.Herramientas.Patron;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author memotets89
 */
public class Knn implements ClasificadorSupervisado{
    
    ArrayList<String> clases;
    int k;
    ArrayList<Patron> Instancias;
    AnalisisResultado mc;        
    
    public Knn(int i){
        this.k=i;
        this.clases = new ArrayList();
        this.mc = null;
    }
    
    @Override
    public void entrenar(ArrayList<Patron> interfaces) {
        this.Instancias= interfaces;
        interfaces.stream().filter((p) -> (!this.clases.contains(p.getClase()))).forEachOrdered((p) -> {
            this.clases.add(p.getClase());
        });
        
    }

    @Override
    public void clasificar(Patron aReconocer) {
        this.Instancias.sort(
                (a, b) -> new Double(Herramientas.calcularDistanciaEuclidiana(a, aReconocer))
                .compareTo(Herramientas.calcularDistanciaEuclidiana(b,aReconocer))); 
    }

    @Override
    public void clasificar(ArrayList<Patron> interfaces) {
        interfaces.forEach((n) -> {
            clasificar(n);
        });
    }
    
}
