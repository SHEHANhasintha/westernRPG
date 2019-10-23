/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.loader;

import dev.entities.Entities;
import dev.game.westernRPG;
import javax.swing.text.html.parser.Entity;










/**
 *
 * @author SHEHAN
 */
public class GameCamara {
    private westernRPG game;
    private float xOffset, yOffset;
    
    public GameCamara(westernRPG game,float xOffset,float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
    }
    
    public void move(float xAmt,float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }
    
    public float getXOffset(){
        return xOffset;
    }
    
    public void setXOffset(float xOffset){
        this.xOffset = xOffset;
    }
    
    public float getYOffset(){
        return yOffset;
    }

    public void setYOffset(float yOffset){
        this.yOffset = yOffset;
    }
    
    public void centerOnEntity(Entities e){
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }
    
}













