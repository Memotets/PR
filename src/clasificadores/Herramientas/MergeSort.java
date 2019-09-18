/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores.Herramientas;

/**
 *
 * @author memotets89
 */
public class MergeSort {
    private double[] arreglo;
    private String[] arreglob;
    
    public MergeSort(){
      this.arreglo=null;
    }
   
   
    public void definirDatos(double[] arreglo,String[]arreglob) {
        this.arreglo= arreglo;
        this.arreglob=arreglob;
    }

    @Override
    public String toString() {
        String aux="Mejor porcentaje: | "+this.arreglo[0]+" | "+"\nEn binario: | "+this.arreglob[0]+" | ";

        
        return aux;
    }

    


    public void ordenar() {
           run();
    }
    public void run() {
    //metodo----------------------------------------------------------------------------------
    
        Merge(this.arreglo, this.arreglob,0, this.arreglo.length-1); 
    
     //--------------------------------------------------------------------------------------------
    }
    
    public void Sort(double[] Array, String[] Arrayb,int inicio,int medio,int ultimo){
        // Find sizes of two subarrays to be merged 
        int n1 = medio - inicio + 1; 
        int n2 = ultimo - medio;
        
        /* Create temp arrays */
        double L[] = new double [n1]; 
        double R[] = new double [n2];
        String Lb[] = new String [n1]; 
        String Rb[] = new String [n2];
        
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) L[i] = Array[inicio + i]; 
        for (int j=0; j<n2; ++j) R[j] = Array[medio + 1+ j];
        for (int i=0; i<n1; ++i) Lb[i] = Arrayb[inicio + i]; 
        for (int j=0; j<n2; ++j) Rb[j] = Arrayb[medio + 1+ j];
        
        /* Merge the temp arrays */
        
        // Initial indexes of first and second subarrays 
        int x = 0, y = 0; 
        
        // Initial index of merged subarry array 
        int k = inicio; 
        while (x < n1 && y < n2) 
        { 
            if (L[x] > R[y]) 
            { 
                Array[k] = L[x]; 
                Arrayb[k]=Lb[x];
                x++; 
            } 
            else
            { 
                Array[k] = R[y];
                Arrayb[k]=Rb[y];
                y++; 
            } 
            k++; 
        } 
        
        /* Copy remaining elements of L[] if any */
        while (x < n1) 
        { 
            Array[k] = L[x];
            Arrayb[k]=Lb[x];
            x++; 
            k++; 
        } 
        
        /* Copy remaining elements of R[] if any */
        while (y < n2) 
        { 
            Array[k] = R[y];
            Arrayb[k]=Rb[y];
            y++; 
            k++; 
        } 
    }
    
    public void Merge(double Array[], String Arrayb[],int i, int f){
        if (i < f) 
        { 
            // Find the middle point 
            int m = (i+f)/2; 
            // Merge first and second halves 
            Merge(Array, Arrayb, i, m); 
            Merge(Array, Arrayb,m+1, f); 
            // Merge the sorted halves 
            Sort(Array, Arrayb,i, m, f); 
        } 
    }
}
