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
    private static BufferedImage imgCharacter;
    private static BufferedImage imgEnviroment;
    public static BufferedImage walk;
    public static BufferedImage dirt1;
    public static BufferedImage dirt2;
    public static BufferedImage dirt3;
    public static BufferedImage dirt4;
    public static BufferedImage skeletonHead1;
    private static SpriteSheet sheet1;
    private static SpriteSheet sheet2;
    
    public static void init(){
        try {
            imgCharacter = gfx.loadImage("./res/spritesheet.png");
            imgEnviroment = gfx.loadImage("./res/spritesheetEnviroment.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void Loadassert(){
        sheet1 = new SpriteSheet(imgCharacter);
        sheet2 = new SpriteSheet(imgEnviroment);
        walk = sheet1.crop(0,0,200,200);
        dirt1 = sheet2.crop(270,0,130,130);
        dirt2 = sheet2.crop(0,270,130,130);
        dirt3 = sheet2.crop(130,270,130,130);
        dirt4 = sheet2.crop(130 * 3,130,130,130);
        skeletonHead1 = sheet2.crop(205,0,200,200);
    }
}
