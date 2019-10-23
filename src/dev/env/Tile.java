/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.env;

import java.awt.Graphics;
import java.awt.image.BufferedImage;









/**
 *
 * @author SHEHAN
 */
public class Tile {
    
    //STATIC STUFF
    public static Tile[] tiles = new Tile[256];
    public static Tile Dirt1Tile = new Dirt1Tile(0); 
    public static Tile Dirt2Tile = new Dirt2Tile(1); 
    public static Tile Dirt3Tile = new Dirt3Tile(2); 
    public static Tile Dirt4Tile = new Dirt4Tile(3); 
    public static Tile skeletonHead = new SkeletonHead(4); 
    
    
    //CLASS
    
    public  static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture,int id){
        this.id = id;
        this.texture = texture;
        
        tiles[id] = this;
    }
    
    public void render(Graphics graphic, int x, int y){
        graphic.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
    }
    
    public void tick(){
        
    }
    
    public int getId(){
        return id;
    }
    
    public boolean isSolid(){
        return false;
    }
}

















