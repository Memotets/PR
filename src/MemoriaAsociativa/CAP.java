/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoriaAsociativa;

import clasificadores.Clasificador;
import clasificadores.Herramientas.Patron;
import clasificadores.Herramientas.PatronRepresentativo;
import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class CAP implements Clasificador {
    private int n; // dimension del patron
    private int p;// numero de clases 
    private double [][] Lernmatrix; //Learnmatrix
    private ArrayList<Patron> instancias;
    private PatronRepresentativo Media;
    private ArrayList<String> clases;
    private ArrayList<double[]> recuperacion;
    

    public void definirParametros(ArrayList <Patron> instancia){
         this.clases = new ArrayList<>();
        // recorrido de todas mis instancias, para buscar las distintas clases y si no se conoce, agregarlo a un arraylist de clases
        instancia.stream().filter((insta) -> (!this.clases.contains(insta.getClase()))).forEachOrdered((classe) -> {
            this.clases.add(classe.getClase());
        });
        //La cantidad de las clases es p
        this.p = this.clases.size();
        
        //La dimension del vector es la dimension del patron
        this.n = instancia.get(0).getVector().length;
        
        //Patrones a modificar
        this.instancias = instancia;
        //genero patron medio
        this.instancias.forEach((insta)->{
            if (this.Media == null) {
                this.Media = new PatronRepresentativo(insta);
                this.Media.setClase("aux");
            }else{
                this.Media.acumular(insta);
            }
        });
        this.Media.actualizar();
        
        System.out.println(this.Media.toString());
        //Lernmatrix inicializada en 0ros
        this.Lernmatrix = new double [p][n];
        
        //Resultados de recuperación inicializados
        this.recuperacion= new ArrayList<>();
    }
    
    private int buscarClaseNumerica(Patron pat){
        int i=0;
            
           for (int x =0; x< p; x++){
               if (pat.getClase().equals(clases.get(x))){
                   i=x;
                   break;
                }
           }
        return i; 
    } 

    
    
    @Override
    public void entrenar(ArrayList<Patron> interfaces) { // Fase de Aprendizaje 
        definirParametros(interfaces);
        
        this.instancias.forEach((pat) -> {
            for (int i =0;i<pat.getVector().length;i++) pat.getVector()[i]-=this.Media.getVector()[i];
            int i = buscarClaseNumerica(pat);
            
           
           for(int j =0; j<n; j++){
               this.Lernmatrix[i][j]+=pat.getVector()[j];
              }
            
        });
    }
    
    public void imprimirLernmatrix(){
        for (double[] fila : Lernmatrix) {
            System.out.print("(");
            for (int j = 0; j < fila.length; j++) {
                System.out.printf(" %.2f   |", fila[j]);
            }
                        System.out.print(")");
            System.out.println();
        }
    }

    @Override
    public void clasificar(Patron aReconocer) { //Fase de recuperación
        double aux[] =new double[p]; 
        for (int i =0; i< p; i++ ){
            for (int j=0; j<n;j++)
                aux [i]+= aReconocer.getVector()[j]*this.Lernmatrix[i][j];
         }
        //Busqueda del valor maximo
        //empezando desde el numero menor
        double mayor=Double.MIN_VALUE;
        for (int i =0; i<p;i++){
            if(mayor < aux[i]){
                mayor = aux[i]; //asignacion de numero mayor
            }
        }
        //con el numero mayor, asignamos los valores 1 y 0 en matriz
         for (int i =0; i<p;i++){
            if(mayor == aux[i])aux[i]=1;
            else aux[i]=0;
            
        }
         //agregamos la matriz
        this.recuperacion.add(aux);
    }

    @Override
    public void clasificar(ArrayList<Patron> interfaces) {
        interfaces.forEach((pat)->{
            clasificar(pat);
        });
    }
    
    public void imprimirRecuperacion(){
        System.out.println();
        int cont =0;
        for (double[] fila : recuperacion) {
            int i = 0;
            cont++;
            System.out.println("Recuperacion del patron: "+ cont);
            while (i<fila.length){
                System.out.printf("  %.2f  |", fila[i]);
                System.out.println();
                System.out.print("------:");
                System.out.println();
                i++;
            }
            System.out.println();
        }
    }
    
    
}

