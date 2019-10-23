/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import clasificadores.Herramientas.Patron;

/**
 *
 * @author memotets89
 */
public class Pixel extends Patron{
    int x,y;
    
    public Pixel(double[] n, String clase, int x, int y) {
        super(n, clase);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
