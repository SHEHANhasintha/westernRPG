/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Rpg.game;

import dev.Rpg.World;
import dev.entities.Player;
import dev.env.Tile;
import dev.game.westernRPG;
import static image.loader.Asserts.walk;
import java.awt.Graphics;









/**
 *
 * @author SHEHAN
 */
public class gameState extends State {
    Player player;
    World world;
    public gameState(westernRPG game){
        super(game);
        player = new Player(game,100,100);
        world = new World("");
    }

    //int x =0;
    @Override
    public void tick() {
        world.tick();
        player.tick();
        
    }

    @Override
    public void render(Graphics graphic) {
        world.render(graphic);
        player.render(graphic);
        //Tile.tiles[0].render(graphic, 0 , 0);
        //graphic.drawImage(walk, 0, 100, (int) 100, (int) 100, null);

    }
    
    
   
    
}
