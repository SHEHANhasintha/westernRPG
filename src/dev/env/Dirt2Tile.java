/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.env;

import image.loader.Asserts;
import java.awt.image.BufferedImage;

/**
 *
 * @author SHEHAN
 */
public class Dirt2Tile extends Tile{
    
    public Dirt2Tile(int id){
        super(Asserts.dirt2,id);
        
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
    
}
