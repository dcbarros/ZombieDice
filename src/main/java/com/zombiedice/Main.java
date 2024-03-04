package com.zombiedice;

import com.zombiedice.services.TurnService;

public class Main {
    public static void main(String[] args) {
        TurnService teste = new TurnService();
        teste.startNewFase();
        System.out.print("Dices: ");
        for (int i = 0; i < teste.getRollDiceFaces().size(); i++) {
            System.out.printf("%s [%s]| ", teste.getOldHandDices().get(i).getColor(), teste.getRollDiceFaces().get(i));
        }
        System.out.printf("\nYour Pontuation in this turn:\nBrains: %d\nDamages: %d\nAmount: %d\n",
                            teste.getKills(), teste.getDamage(), teste.getAmoutDicesInPot());
        System.out.println("-------------------------------------------------------");
        teste.startNewFase();
        System.out.print("Dices: ");
        for (int i = 0; i < teste.getRollDiceFaces().size(); i++) {
            System.out.printf("%s [%s]| ", teste.getOldHandDices().get(i).getColor(), teste.getRollDiceFaces().get(i));
        }
        System.out.printf("\nYour Pontuation in this turn:\nBrains: %d\nDamages: %d\nAmount: %d\n",
                            teste.getKills(), teste.getDamage(), teste.getAmoutDicesInPot());
        System.out.println("-------------------------------------------------------");
        
    }
 
}