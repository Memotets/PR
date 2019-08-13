/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

/**
 *
 * @author memotets89
 */
class Patron {
    private double vector[];
    private String clase;
    private String resultante;
    public Patron(int n){
        this.clase= "Desconocido";
        this.resultante="";
        this.vector=new double[n];
    }
    public Patron(int n, String clase){
        this.clase= clase;
        this.vector=new double[n];
        this.resultante="";

    }
    
    public Patron (Patron aux){
        this.clase = aux.getClase();
        this.vector = aux.getVector();
        this.resultante="";

    } 
    
    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getResultante() {
        return resultante;
    }

    public void setResultante(String resultante) {
        this.resultante = resultante;
    }
    

}
