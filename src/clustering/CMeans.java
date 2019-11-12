package clustering;
import clasificadores.Clasificador;
import clasificadores.Herramientas.Herramientas;
import clasificadores.Herramientas.Patron;
import clasificadores.Herramientas.PatronRepresentativo;
import java.util.ArrayList;
import java.util.Random;



public class CMeans implements Clasificador{
    private int c;
    private PatronRepresentativo[] centroides;
    
    public CMeans(int c) {
        if(c>150) this.c=150;
        else this.c = c;
        this.centroides= new PatronRepresentativo[c];
    }
    public void entrenar(ArrayList<Patron> interfaces, int pos[]){
        for(int x=0; x<pos.length;x++){
            this.centroides[x]= new PatronRepresentativo(interfaces.get(pos[x]));
            this.centroides[x].setClase(""+x);
        }
    }
    @Override
    public void entrenar(ArrayList<Patron> interfaces) {
        Random ran = new Random();
        int pos = ran.nextInt(interfaces.size());
        this.centroides[0] = new PatronRepresentativo(interfaces.get(pos));
        this.centroides[0].setClase(""+0);
        int x=1;
        
        while(x <  this.c){
            pos = ran.nextInt(interfaces.size());
            if (!Exist(interfaces.get(pos))){
                this.centroides[x]= new PatronRepresentativo(interfaces.get(pos));
                this.centroides[x].setClase(""+x);
                x++;
            }
        }
    }

    @Override
    public void clasificar(Patron aReconocer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
       PatronRepresentativo[] nuevos; 

       do{           
           clasificacion(patrones);
           //recalculo centroides
           nuevos = reAjustarCentroides(patrones);
        
       }while(diferenciaCentroides(nuevos));
    }

    private boolean Exist(Patron get) {
        for (Patron centroide : this.centroides) {
            if (centroide == null){break;}
            if (centroide.equals(get)){return true;}
        }
        return false;
    }

    private void clasificacion(ArrayList<Patron> patrones) {
        patrones.forEach((e) -> {
            double distC = Herramientas.calcularDistanciaEuclidiana(e, this.centroides[0]);
            e.setClase(this.centroides[0].getClase());
            for (int i=1; i<this.c;i++){
                double nDistancia = Herramientas.calcularDistanciaEuclidiana(e, this.centroides[i]);
                if(distC>nDistancia){
                    distC=nDistancia;
                    e.setClase(this.centroides[i].getClase());
                    
                }
            }
        });
    }

    private PatronRepresentativo[] reAjustarCentroides(ArrayList<Patron> patrones) {
       PatronRepresentativo[] aux= new PatronRepresentativo[this.centroides.length];
       patrones.forEach((Patron wop) -> {
           int i = Integer.parseInt(wop.getClase());
           if(aux[i]==null){
               aux[i]= new PatronRepresentativo(wop);
               aux[i].setClase(""+i);
           }else{
               aux[i].acumular(wop);
           }
       });
       
       for(PatronRepresentativo act: aux){
            act.actualizar();
        }
       return aux;
    }

    private boolean diferenciaCentroides(PatronRepresentativo[] nuevos) { 
        for(int x=0; x<nuevos.length;x++){
            if(!nuevos[x].equals(this.centroides[x])){
                this.centroides=nuevos.clone();
                return true;
            }
        }
        return false;
    }

    public PatronRepresentativo[] getCentroides() {
        return centroides;
    }
    
}
