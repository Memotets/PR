/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores.Herramientas;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author memotets89
 */
public class Herramientas {
    
   public static ArrayList<Patron> instancias;
   
   public static void leerDatos(int eleccion[], String ruta){
         instancias = new ArrayList<>();
         String texto, aux;
         LinkedList<String> lista = new LinkedList();
         
         try {
          
            //abrimos el archivo ruta
            File abre =new File(ruta);
            //Desktop.getDesktop().open(abre);

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    int j=0;
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }
                    
                    double[] vector = new double [obtenerDimension(eleccion)];

                    for (int x = 0; x < eleccion.length; x++) {
                        if(eleccion[x]==1){
                            vector[j] = Double.parseDouble(lista2.get(x));
                            j++;
                        }
                    }
                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();
                }         
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);            
        }
         
    }
    
   public static void leerDatos(int eleccion[]){
         instancias = new ArrayList<>();
         String texto, aux;
         LinkedList<String> lista = new LinkedList();
         try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    int j=0;
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }
                    
                    double[] vector = new double [obtenerDimension(eleccion)];

                    for (int x = 0; x < eleccion.length; x++) {
                        if(eleccion[x]==1){
                            vector[j] = Double.parseDouble(lista2.get(x));
                            j++;
                        }
                    }
                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();
                }         
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);            
        }
         
    }
    
   public static void leerDatos(){
        instancias = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();
        
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    double[] vector = new double[lista2.size() - 1];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Double.parseDouble(lista2.get(x));
                    }

                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();
                }         
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
}    
   
   public static void leerDatos(String ruta){
        instancias = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();
        
        try {
            
            //abrimos el archivo seleccionado
            File abre = new File(ruta);

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    double[] vector = new double[lista2.size() - 1];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Double.parseDouble(lista2.get(x));
                    }

                    clase = lista2.get(lista2.size()-1);
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Patron(vector, clase));
                   // patrones.add();
                    lista2.clear();
                }         
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
}    
   
   public static double calcularDistanciaEuclidiana(Patron a, Patron b){
        double sumadorAux=0;
        for (int i =0; i<a.getVector().length;i++){
            sumadorAux += Math.pow((a.getVector()[i]-b.getVector()[i]),2);
        }
        return Math.sqrt(sumadorAux);
    }

   private static int obtenerDimension(int[] eleccion) {
        int j=0; 
        for (int x = 0; x < eleccion.length; x++) {
            if(eleccion[x]==1){
                j++;
             }
          }
         return j;
    }
    
      
    
    
}
