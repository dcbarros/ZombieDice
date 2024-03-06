package com.zombiedice.services;

import java.util.List;
import java.util.Random;

import com.zombiedice.model.Game;
import com.zombiedice.model.Zombie;

public class GameService {

    private TurnService turn;
    private Game currentGame;

    public GameService(){
        this.turn = new TurnService();
    }

    public void newGame(List<Zombie> zombies){
        this.currentGame = new Game(zombies);
    }

    public void turns(Zombie zombie){
        if(this.currentGame != null){
            if(currentGame.getZombies() == null || currentGame.getZombies().isEmpty()) 
            throw new RuntimeException("Jogadores não inseridos no jogo");
            
            if(this.containInPlayersList(zombie) 
            && !currentGame.getFinishGame() 
            && this.turn.getIsActive() 
            && this.turn.getDamage() < 3){  

                this.turn.startNewFase();
                this.finishGame(zombie);
                
            } else {
                // Substituir por exeções
                if(!this.containInPlayersList(zombie)){
                    throw new RuntimeException("Jogadores não existe no banco de jogadores");
                }else{
                    if(turn.getDamage() < 3){
                        zombie.setBrains(zombie.getBrains() + turn.getKills());
                    }
                    this.turn = new TurnService();
                }
            }
        }else{
            throw new RuntimeException("O jogo não pode ser iniciado");
        }
    }

    public void endGame(){
        
    }

    private boolean containInPlayersList(Zombie zombie){
        for (Zombie player : currentGame.getZombies()) {
            if(zombie.getName().equalsIgnoreCase(player.getName())){
                return true;
            }
        }
        return false;
    }

    private void finishGame(Zombie zombie){
        this.currentGame.setFinishGame(zombie.getBrains() >= 13);
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public TurnService getTurn() {
        return turn;
    }
}
