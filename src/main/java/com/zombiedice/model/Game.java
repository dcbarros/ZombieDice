package com.zombiedice.model;

import java.time.LocalDateTime;
import java.util.List;

import com.zombiedice.utils.IdUtils;

public class Game {

    private final static Integer IDLENGTH = 7;

    private Long id;
    private Boolean finishGame;
    private List<Zombie> zombies;
    private Zombie zombieWinner;
    private LocalDateTime startGame;
    private LocalDateTime endGame;

    public Game(List<Zombie> zombies) {
        this.zombies = zombies;
        this.zombieWinner = new Zombie();
        this.finishGame = false;
        this.startGame = LocalDateTime.now();
        this.endGame = LocalDateTime.now();
        this.setId();
    }

    public Boolean getFinishGame() {
        return finishGame;
    }

    public void setFinishGame(Boolean finishGame) {
        this.finishGame = finishGame;
    }

    public Long getId() {
        return id;
    }

    private void setId() {
        this.id = IdUtils.idGenerate(IDLENGTH);   
    }

    public List<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(List<Zombie> zombies) {
        this.zombies = zombies;
    }

    public Zombie getZombieWinner() {
        return zombieWinner;
    }

    public void setZombieWinner(Zombie zombieWinner) {
        this.zombieWinner = zombieWinner;
    }

    public LocalDateTime getStartGame() {
        return startGame;
    }

    public void setStartGame(LocalDateTime startGame) {
        this.startGame = startGame;
    }

    public LocalDateTime getEndGame() {
        return endGame;
    }

    public void setEndGame(LocalDateTime endGame) {
        this.endGame = endGame;
    }

}
