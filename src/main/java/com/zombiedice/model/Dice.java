package com.zombiedice.model;

import java.util.List;
import java.util.Random;

import com.zombiedice.model.enums.EDiceColor;
import com.zombiedice.model.enums.EDiceFace;

public class Dice {

    private EDiceColor color;
    private List<EDiceFace> faces;


    public Dice(EDiceColor color) {
        this.color = color;
        setFaces();
    }

    private void setFaces() {
        this.faces = this.color == EDiceColor.GREEN 
        ? List.of(EDiceFace.BRAIN, EDiceFace.RUNNING, EDiceFace.BRAIN, EDiceFace.SHOOTING,EDiceFace.BRAIN,EDiceFace.RUNNING)
         : this.color == EDiceColor.YELLOW 
        ? List.of(EDiceFace.BRAIN, EDiceFace.SHOOTING, EDiceFace.BRAIN, EDiceFace.RUNNING,EDiceFace.SHOOTING,EDiceFace.RUNNING) 
        : List.of(EDiceFace.RUNNING, EDiceFace.SHOOTING, EDiceFace.BRAIN, EDiceFace.SHOOTING,EDiceFace.RUNNING,EDiceFace.SHOOTING);;
    }

    public EDiceFace rollDice(){
        int numberOfFaces = this.faces.size();
        Random random = new Random();
        return this.faces.get(random.nextInt(numberOfFaces));
    }    
}
