/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.loader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;









/**
 *
 * @author SHEHAN
 */
public class Asserts {
    private static BufferedImage img;
    public static BufferedImage walk;
    public static SpriteSheet sheet;
    
    public static void init(){
        try {
            img = gfx.loadImage("./res/spritesheet.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void Loadassert(){
        sheet = new SpriteSheet(img);
        walk = sheet.crop(0,0,200,200);
        
    }
}
