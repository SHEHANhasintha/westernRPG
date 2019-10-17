/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
















package dev.entities;

import dev.game.westernRPG;
import image.loader.Asserts;
import java.awt.Graphics;

/**
 *
 * @author SHEHAN
 */
public class Player extends Creatures{
    private westernRPG game;
    public Player(westernRPG game,float x, float y){
        super(x,y,Creatures.DEFAULT_CREATURE_WIDTH,Creatures.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }
    
    public void Input(){
        xMove = 0;
        yMove = 0;
        if (this.game.getKeyManager().up)
            yMove -= speed;
        if (this.game.getKeyManager().down)
            yMove += speed;
        if (this.game.getKeyManager().left)
            xMove -= speed;
        if (this.game.getKeyManager().right)
            xMove += speed;
    }

    
    
    @Override
    public void tick() {

        Input();
        move();
        //x += 1;
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Asserts.walk, (int) x, (int) y, width, height, null);
    }
    
    
    
}













