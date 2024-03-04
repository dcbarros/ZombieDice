package com.zombiedice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zombiedice.model.enums.EDiceColor;

public class Pot {
    
    private static final Integer AMOUNTOFDICES = 13;

    private List<Dice> dices;
    private Integer dicesInPot;

    public Pot() {
        this.dicesInPot = AMOUNTOFDICES;
        this.newPot();
    }

    private void newPot(){
        this.dices = new ArrayList<>(Arrays.asList(
            new Dice(EDiceColor.GREEN),
            new Dice(EDiceColor.YELLOW),
            new Dice(EDiceColor.RED),
            new Dice(EDiceColor.GREEN),
            new Dice(EDiceColor.YELLOW),
            new Dice(EDiceColor.RED),
            new Dice(EDiceColor.GREEN),
            new Dice(EDiceColor.YELLOW),
            new Dice(EDiceColor.RED),
            new Dice(EDiceColor.GREEN),
            new Dice(EDiceColor.YELLOW),
            new Dice(EDiceColor.GREEN),
            new Dice(EDiceColor.GREEN)
        ));
        

    }

    public static Integer getAmountofdices() {
        return AMOUNTOFDICES;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public void setDices(List<Dice> dices) {
        this.dices = dices;
    }

    public Integer getDicesInPot() {
        return dicesInPot;
    }

    public void setDicesInPot(Integer dicesInPot) {
        this.dicesInPot = dicesInPot;
    }

}
