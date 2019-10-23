/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import clasificadores.Herramientas.Patron;
import clasificadores.Herramientas.PatronRepresentativo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class AdaptThisImg {
    
    public static ArrayList<Patron> obtenerImg(Image io){
      ArrayList<Patron> aux = new ArrayList<>();
        BufferedImage bi = ImageManager.toBufferedImage(io);
        for(int x=0; x< bi.getWidth();x++){
            for(int y=0; y <bi.getHeight();y++){
                Color color = new Color(bi.getRGB(x, y));
                Pixel pp = new Pixel(new double[]{color.getRed(),color.getGreen(),color.getBlue()} ,"", x, y);
                aux.add(pp);
            }
        }
        return aux;
    }
    
    public static Image ImagenClustering(PatronRepresentativo[] ar,ArrayList<Patron> ap, Dimension dim){
         BufferedImage io=new BufferedImage((int)dim.getWidth(),(int)dim.getHeight(),BufferedImage.TYPE_INT_RGB);
        for(Patron aux: ap) {
            Pixel pxp = (Pixel)aux;
            String cla = pxp.getClase();
            double vec[] = new double[]{0,100,0};
             for (PatronRepresentativo wop : ar) {
                 if (cla.equals(wop.getClase())) {
                     vec = wop.getVector();
                     System.out.println("entre");
                     break;
                 }
             }
            io.setRGB(pxp.getX(),pxp.getY(), new Color((int)vec[0],(int) vec[1],(int) vec[2]).getRGB());
        }
        return ImageManager.toImage(io);
    }
    
}
