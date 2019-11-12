/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoriaAsociativa;

import clasificadores.Clasificador;
import clasificadores.Herramientas.Patron;
import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class Steinbuch implements Clasificador {
    private int n; // dimension del patron
    private int p;// numero de clases 
    private int [][] Lernmatrix; //Learnmatrix
    private ArrayList<String> clases;
    private ArrayList<int[]> recuperacion;
    

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
        
        //Lernmatrix inicializada en 0ros
        this.Lernmatrix = new int [p][n];
        
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
        
        interfaces.forEach((pat) -> {
            int i = buscarClaseNumerica(pat);
           
           for(int j =0; j<n; j++){
               if (pat.getVector()[j]==1) this.Lernmatrix[i][j]++;
               else this.Lernmatrix[i][j]--;
           }
            
        });
    }
    
    public void imprimirLernmatrix(){
        for (int[] fila : Lernmatrix) {
            for (int j = 0; j < fila.length; j++) {
                System.out.printf("  %2d  |", fila[j]);
            }
            System.out.println();
            for (int j = 0; j < fila.length; j++) {
                System.out.print("------:");
            }
            System.out.println();
        }
    }

    @Override
    public void clasificar(Patron aReconocer) { //Fase de recuperación
        int aux[] =new int[p]; 
        for (int i =0; i< p; i++ ){
            for (int j=0; j<n;j++)
                aux [i]+= aReconocer.getVector()[j]*this.Lernmatrix[i][j];
         }
        //Busqueda del valor maximo
        //empezando desde el numero menor
        int mayor=Integer.MIN_VALUE;
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
        for (int[] fila : recuperacion) {
            int i = 0;
            cont++;
            System.out.println("Recuperacion del patron: "+ cont);
            while (i<fila.length){
                System.out.printf("  %2d  |", fila[i]);
                System.out.println();
                System.out.print("------:");
                System.out.println();
                i++;
            }
            System.out.println();
        }
    }
    
    
}
