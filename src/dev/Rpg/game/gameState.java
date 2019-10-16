/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Rpg.game;

import static image.loader.Asserts.walk;
import java.awt.Graphics;









/**
 *
 * @author SHEHAN
 */
public class gameState extends State {
    
    public gameState(){
    
    }

    //int x =0;
    @Override
    public void tick() {
        //x += 1;
    }

    @Override
    public void render(Graphics graphic) {
        
        graphic.drawImage(walk, 0, 100, (int) 100, (int) 100, null);

    }
    
    
   
    
}
