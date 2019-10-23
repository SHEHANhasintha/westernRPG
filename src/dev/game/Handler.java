/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.game;

import dev.Rpg.World;
import dev.Rpg.game.KeyManager;
import image.loader.GameCamara;
















/**
 *
 * @author SHEHAN
 */
public class Handler {
    private westernRPG game;
    private World world;
    
    public Handler (westernRPG game){
        this.game = game;

    }
    
    public westernRPG getGame(){
        return game;
    }
    
    public void setGame(westernRPG game){
        this.game = game;
    }
    
    public World getWorld(){
        return world;
    }
    
    public void setWorld(World world){
        this.world = world;
    }
    
    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public GameCamara getGameCamara(){
        return game.getGameCamara();
    }
    
    
    
}
















