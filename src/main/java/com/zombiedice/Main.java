package com.zombiedice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.zombiedice.model.Zombie;
import com.zombiedice.model.enums.EDiceFace;
import com.zombiedice.services.Dice;
import com.zombiedice.services.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        Zombie z1 = new Zombie("Claiton");
        Zombie z2 = new Zombie("Craudiu");
        List<Zombie> zombies = new ArrayList<>();
        zombies.add(z1);
        zombies.add(z2);
        gameService.newGame(zombies);

        // System.out.printf("""
        // -------------------------    
        // Game Info
        // -------------------------
        // Id: %d
        // Playes: %d
        // -------------------------
        // """,gameService.getCurrentGame().getId(), gameService.getCurrentGame().getZombies().size());
        
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while(!gameService.getCurrentGame().getFinishGame()){
            cleanScreen();
            Zombie actualPlayer = gameService.getCurrentGame().getZombies().get(index);
            gameService.turns(actualPlayer);
            
            System.out.printf("""
            Zombie Name: %s Punctuation: %d
            Dices in Pot: %d
            """, actualPlayer.getName(), actualPlayer.getBrains(), gameService.getTurn().getAmoutDicesInPot());
            System.out.print("Dices Color: ");
            printDices(gameService.getTurn().getOldHandDices());
            System.out.print("Dices Faces: ");
            printFaces(gameService.getTurn().getRollDiceFaces());
            System.out.printf("""
            BrainsDices: %d
            ShootingDices: %d
            """, gameService.getTurn().getKills(), gameService.getTurn().getDamage());
            if(gameService.getTurn().getDamage() >= 3){
                cleanScreen();
                youDead(actualPlayer.getName());
                sc.nextLine();

                gameService.getTurn().setIsActive(false);
                gameService.turns(actualPlayer);
                index = (index + 1)%gameService.getCurrentGame().getZombies().size();
                continue;
            }
            System.out.println("\nContinue? Y - Yes or N - No");
            String choice = sc.nextLine();
            if(choice.equals("N")){
                gameService.getTurn().setIsActive(false);
                gameService.turns(actualPlayer);
                index = (index + 1)%gameService.getCurrentGame().getZombies().size();
            }
        }

    }

    public static void printDices(List<Dice> dices){
        for (Dice dice : dices) {
            System.out.printf("%s, ", dice.getColor());
        }
        System.out.println();
    }
    public static void printFaces(List<EDiceFace> dices){
        for (EDiceFace e : dices) {
            System.out.printf("%s, ",e);
        }
        System.out.println();
    }
    public static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void youDead(String name){
        
        System.out.println(" -------------------- ");
        System.out.println("|        ****        |");
        System.out.println("|        ****        |");
        System.out.println("| ****************** |");
        System.out.println("| ****************** |");
        System.out.println("|        ****        |");
        System.out.println("|        ****        |");
        System.out.println("|        ****        |");
        System.out.println("|        ****        |");
        System.out.println("|        ****        |");
        System.out.println(" -------------------- ");
        System.out.printf("%s: YOU DEAD!      ",name);
    }
}
 
