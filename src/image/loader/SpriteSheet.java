/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.loader;

/**
 *
 * @author SHEHAN
 */











import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;
    //private int section;
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
        
    }
    
    public BufferedImage crop(int x,int y,int width,int height){
        return sheet.getSubimage(x,y,width,height);
    }
    
    public BufferedImage cutter(int sectionHoriz,int sectionVertics){
        int horiz;
        int vertics;
        int horizEnd; 
        int verticsEnd; 
        
        try{
            horiz = (sectionHoriz - 1) * 50;
            vertics = (sectionVertics - 1) * 100;
            horizEnd = horiz + 50;
            verticsEnd = vertics + 50;
            return SpriteSheet.this.crop(horiz, vertics, horizEnd, verticsEnd);
        } catch(Exception e){
            e.printStackTrace();
        }
         
       return null;
        
    }
}
