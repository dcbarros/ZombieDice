package com.zombiedice;

import java.util.ArrayList;
import java.util.List;

import com.zombiedice.model.Game;
import com.zombiedice.model.Zombie;

public class Main {
    public static void main(String[] args) {
        Zombie z1 = new Zombie("Cleiton");
        Zombie z2 = new Zombie("Craudio");
        Zombie z3 = new Zombie("Lindolfo");
        List<Zombie> zombies = new ArrayList<>();
        zombies.add(z1);
        zombies.add(z2);
        zombies.add(z3);
        Game game = new Game(zombies);
        System.out.println(game.getId());
        
    }
 
}