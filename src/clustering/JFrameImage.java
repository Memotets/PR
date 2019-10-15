/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author memotets89
 */
public class JFrameImage extends JFrame{
    public JFrameImage (Image imagenOrigen){
        JLabel label = new JLabel (new ImageIcon (imagenOrigen));
        this.add(label);
        this.setSize(imagenOrigen.getWidth(this),imagenOrigen.getHeight(this));
        
        this.setVisible(true);
    }
}
