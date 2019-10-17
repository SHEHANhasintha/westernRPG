/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Rpg;

import dev.env.Tile;
import java.awt.Graphics;











/**
 *
 * @author SHEHAN
 */
public class World {
    private int width, height;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);
    }
    
    public void tick(){
    
    }

    public void render(Graphics graphic){
        for (int y=0;y<width;y++){
            for (int x=0; x<height;x++){
                getTile(x,y).render(graphic, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
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
        width = 5;
        height = 5;
        tiles = new int[width][height];
        for (int x=0;x<width;x++){
            for (int y=0; y<height;y++){
                tiles[x][y] = 0;
            }
        }
    }
}







