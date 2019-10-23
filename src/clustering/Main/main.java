/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering.Main;

import clasificadores.Herramientas.Patron;
import clustering.AdaptThisImg;
import clustering.CMeans;
import clustering.ImageManager;
import clustering.JFrameImage;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class main {
     public static void main(String[] args) throws IOException {
      Image io = ImageManager.openImage();
        JFrameImage mostrario= new JFrameImage(io);
        ArrayList<Patron> instancias = AdaptThisImg.obtenerImg(io);
        CMeans cm = new CMeans(10);
        cm.entrenar(instancias);
        cm.clasificar(instancias);
        Image nueva = AdaptThisImg.ImagenClustering(cm.getCentroides(),instancias,new Dimension(io.getWidth(null),io.getHeight(null)));
        JFrameImage mostrarad= new JFrameImage(nueva);
     }
     
    
}
