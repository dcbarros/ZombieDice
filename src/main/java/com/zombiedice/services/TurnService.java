package com.zombiedice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.zombiedice.model.enums.EDiceFace;

public class TurnService {

    private Boolean isActive;
    private List<Dice> handDices;
    private List<Dice> oldHandDices;
    private List<EDiceFace> rollDiceFaces;
    private Pot pot;

    private Integer kills;
    private Integer damage;

    public TurnService(){
        this.isActive = true;
        this.pot = new Pot();
        this.handDices = new ArrayList<>();
        this.oldHandDices = new ArrayList<>();
        this.rollDiceFaces = new ArrayList<>();
        this.kills = 0;
        this.damage = 0;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Dice> getHandDices() {
        return handDices;
    }

    public void setHandDices(List<Dice> handDices) {
        this.handDices = handDices;
    }

    public List<EDiceFace> getRollDiceFaces() {
        return rollDiceFaces;
    }

    public void setRollDiceFaces(List<EDiceFace> rollDiceFaces) {
        this.rollDiceFaces = rollDiceFaces;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public List<Dice> getOldHandDices() {
        return oldHandDices;
    }

    public void setOldHandDices(List<Dice> oldHandDices) {
        this.oldHandDices = oldHandDices;
    }

    public void startNewFase(){
        this.rollDiceFaces = new ArrayList<>();
        if((this.handDices.size() + this.pot.getDicesInPot()) > 3 && this.damage < 3){
            this.choiceDices();
            Iterator<Dice> iterator = this.handDices.iterator();
            while(iterator.hasNext()){
                Dice dice = iterator.next();
                EDiceFace face = this.rollDice(dice);
                this.rollDiceFaces.add(face);
                if(face != EDiceFace.RUNNING){
                    if(face == EDiceFace.BRAIN){
                        iterator.remove();
                        this.kills++;
                    }
                    else{
                        iterator.remove();
                        this.damage++;
                    }
                }
            }
        }else{
            this.isActive = false;
        }

    }

    private void choiceDices(){
        int amountOfDices = 3 - this.handDices.size();

        Random random = new Random();
        for (int i = 0; i < amountOfDices; i++) {
            int choice = random.nextInt(this.pot.getDicesInPot());
            this.handDices.add(this.pot.getDices().get(choice));
            this.pot.getDices().remove(choice);
            this.pot.setDicesInPot(this.pot.getDices().size());
        }

        this.oldHandDices = new ArrayList<>(this.handDices);

    }

    private EDiceFace rollDice(Dice dice){
        return dice.rollDice();
    }

    public Integer getAmoutDicesInPot(){
        return this.pot.getDices().size();
    }

}
