/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering.Main;

import clustering.JFrameImage;
import clustering.imageManager;
import java.awt.Image;
import java.io.IOException;

/**
 *
 * @author memotets89
 */
public class main {
     public static void main(String[] args) throws IOException {
         Image ic = imageManager.openImage();
         JFrameImage jf = new JFrameImage(ic);
     }
     
    
}
