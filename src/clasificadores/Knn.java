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
        this.clases = new ArrayList<>();
        this.mc = null;
    }
    
    @Override
    public void entrenar(ArrayList<Patron> interfaces) {
               this.Instancias = (ArrayList<Patron>) interfaces.clone();
        // generamos un arraylist de las clases involucradas
        Instancias.stream().filter((p) -> (!this.clases.contains(p.getClase()))).forEachOrdered((p) -> {
            this.clases.add(p.getClase());
        });

    }

    @Override
    public void clasificar(Patron aReconocer) {
        this.Instancias.sort(
                (a, b) -> new Double(Herramientas.calcularDistanciaEuclidiana(a, aReconocer))
                .compareTo(Herramientas.calcularDistanciaEuclidiana(b,aReconocer))); 
        
        int contador[] = new int[this.clases.size()];
        // clasificar en base al numero de vecinos
        for(Patron aux: this.Instancias){
            int i = this.clases.indexOf(aux.getClase());
            contador[i]++;
            if(contador[i]==this.k){
                // clasificar
                aReconocer.setResultante(this.clases.get(i));
                break;
            }
        }
    }

    @Override
    public void clasificar(ArrayList<Patron> interfaces) {
        interfaces.forEach((Patron n) -> {
            clasificar(n);
        System.out.print("");    
        });
       this.mc = new AnalisisResultado(this.Instancias);
       this.mc.porcentaje();
       this.mc.sacarConfusion();
       System.out.println(this.mc.toString());
       System.out.println("porcentaje: "+this.mc.porcentaje()+"\n");    
    }
    
    public double Porcentaje(){
        return this.mc.porcentaje();
    }

}
