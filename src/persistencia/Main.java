/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import clasificadores.Herramientas.Herramientas;
import clasificadores.Knn;
import clasificadores.MinimaDistancia;

import java.io.IOException;

/**
 *
 * @author memotets89
 */
public class Main {
    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException{
        int numBits=13;
        
        String dato="";
        for (int i =0; i<numBits;i++){
            dato+= 1;
        }
        
        int x = Integer.parseInt(dato, 2);
       
        for (int i=1; i<=x;i++){
            int [] matriz = new int[numBits];
            String aux= Integer.toBinaryString(i);
            
            for(int j=0;j<aux.length();j++){ 
                matriz[dato.length()-aux.length()+j] = Integer.parseInt(Character.toString(aux.charAt(j)));  
            }

               
            for(int j = 0; j<dato.length();j++ ){
                System.out.print(matriz[j]);
            }
          System.out.print("\n");
          
          Herramientas.leerDatos(matriz,"/home/memotets89/Escritorio/Work/Tareas/Semestre5/Reconocimiento de patrones/Wine/wine.csv");
          MinimaDistancia md = new MinimaDistancia();
          md.entrenar(Herramientas.instancias);
          md.clasificar(Herramientas.instancias);

          Knn k= new Knn(3);
          k.entrenar(Herramientas.instancias);
          k.clasificar(Herramientas.instancias);
            
        }
//         
//        Herramientas.leerDatos();
//
//        MinimaDistancia md = new MinimaDistancia();
//        md.entrenar(Herramientas.instancias);
//        md.clasificar(Herramientas.instancias);
//
//        Knn k= new Knn(2);
//        k.entrenar(Herramientas.instancias);
//        k.clasificar(Herramientas.instancias);

        
//        Manager man = new Manager(Herramientas.instancias);
//        man.ejecutarPruebaInstancias(true);
//        man.ejecutarPruebaRepresentativos(true);
    }


}
