/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import clasificadores.Herramientas.Herramientas;
import clasificadores.Herramientas.MergeSort;
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
    public static void main(String[] args) throws IOException {
        int numBits = 13;
        String dato = "";
        for (int i = 0; i < numBits; i++) {
            dato += 1;
        }
        int x = Integer.parseInt(dato, 2);

        double[][] Porcentajes = new double[2][x];
        String[][] binario = new String[2][x];

        for (int i = 1; i <= x; i++) {
            int[] matriz = new int[numBits];
            String aux = Integer.toBinaryString(i);

            binario[0][i - 1] = aux;
            binario[1][i - 1] = aux;

            for (int j = 0; j < aux.length(); j++) {
                matriz[numBits - aux.length() + j] = Integer.parseInt(Character.toString(aux.charAt(j)));
            }

            for (int j = 0; j < numBits; j++) {
                System.out.print(matriz[j]);
            }
            System.out.print("\n");

            Herramientas.leerDatos(matriz, "/home/memotets89/Escritorio/Work/Tareas/Semestre5/Reconocimiento de patrones/Wine/wine.csv");

            MinimaDistancia md = new MinimaDistancia();
            md.entrenar(Herramientas.instancias);
            md.clasificar(Herramientas.instancias);
            Porcentajes[0][i - 1] = md.Porcentaje();

            Knn k = new Knn(3);
            k.entrenar(Herramientas.instancias);
            k.clasificar(Herramientas.instancias);
            Porcentajes[1][i - 1] = k.Porcentaje();
        }
        
        MergeSort mD = new MergeSort();
        mD.definirDatos(Porcentajes[0], binario[0]);
        MergeSort K = new MergeSort();
        K.definirDatos(Porcentajes[1], binario[1]);

        mD.run();
        K.run();
        
        System.out.println("En minima distancia...");
        System.out.println(mD.toString());
        System.out.println("\nEn Knn con k=3...");
        System.out.println(K.toString());

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
