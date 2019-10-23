/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Rpg;

import dev.env.Tile;
import dev.game.Handler;
import dev.game.westernRPG;
import dev.utils.util;
import java.awt.Graphics;











/**
 *
 * @author SHEHAN
 */
public class World {
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    private Handler handler;

    public World(Handler handler,String path){
        this.handler = handler;
        loadWorld(path);
    }
    
    public void tick(){
    
    }

    public void render(Graphics graphic){
        int xStart = (int)Math.max(0, handler.getGameCamara().getXOffset() / Tile.TILE_WIDTH);
        int xEnd = (int)Math.min(width, (handler.getGameCamara().getXOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int)Math.max(0, handler.getGameCamara().getYOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int)Math.min(height, (handler.getGameCamara().getYOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
        
        for (int y=yStart;y<yEnd;y++){
            for (int x=xStart; x<xEnd;x++){
                getTile(x,y).render(graphic, (int)(x * Tile.TILE_WIDTH - handler.getGameCamara().getXOffset()) ,
                        (int) (y * Tile.TILE_HEIGHT - handler.getGameCamara().getYOffset()));
            }
        }
        
        
    }
    
    public Tile getTile(int x,int y){
        Tile tile = Tile.tiles[tiles[x][y]];
        if (tile == null)
            return Tile.Dirt1Tile;
        return tile;
    }
    
    public void loadWorld(String path){
        System.out.println(path);
        String file = util.loadFileAsString(path);

        String[] tokens = file.split("\\s+");                 

        width = util.parseInt(tokens[0]);
        height = util.parseInt(tokens[1]);
        spawnX = util.parseInt(tokens[2]);
        spawnY = util.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        for (int y=0;y<height;y++){
            for (int x=0; x<width;x++){
                //System.out.println((x + y * width) + 4);
                tiles[x][y] = util.parseInt(tokens[(x + y * width) + 4]);
            }
        }
        
        for (int b=0;b<tiles.length;b++){
            for (int k=0; k<tiles[b].length;k++){
                System.out.println(tiles[b][k]);
            }
        }
        
        
        
    }
}







