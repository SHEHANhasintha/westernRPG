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
    private static BufferedImage sheet;
    public static BufferedImage walk,run;
    private static SpriteSheet sheetParts;
    public static void init(){
        try {
            sheet = gfx.loadImage("./res/spritesheet.png");
        } catch (IOException ex) {
            Logger.getLogger(Asserts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sheetParts = new SpriteSheet(sheet);

    }
    
    public static void Loadassert(){
        //walk = sheetParts.cutter(2,1);
        walk = sheetParts.crop(0,0,100,100);
    }
}
