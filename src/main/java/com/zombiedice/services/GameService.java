package com.zombiedice.services;

import java.util.List;

import com.zombiedice.model.Zombie;

public class GameService {

    private TurnService turn;

    public GameService(){
        this.turn = new TurnService();
    }

    public void newGame(List<Zombie> zombies){}

    public void newTurn(Zombie zombie){}

    public void endGame(){}
}
