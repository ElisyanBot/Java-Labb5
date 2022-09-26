package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {
    public static Die[] dicesArray;
    public static boolean gameIsRunning = true;
    static int playerTurn = 0;
    static int numberOfThrows = 3;
    static boolean gotYatzy = true;

    public static void main(String[] args) {
   
        //set Dice Array
        setDiceArray(5);

        //We will continue until the game is over
        while(gameIsRunning == true) {
            System.out.println("Welcome to Yatzi!");
            NextPlayersDiceRoll(numberOfThrows);
        }
    }



//Methods
   static void setDiceArray(int length){
    dicesArray = new Die[length];
    for(int diceIndex = 0; diceIndex < length; diceIndex++) {
        dicesArray[diceIndex] = new Die();
    }
   }

    static void rollAllDices(Die[] dicesArray){
        for ( int i = 0; i < dicesArray.length; i++ ) {
            dicesArray[i].DieRoll();
            //dicesArray[i].value = 5; //Test if yatzi work
            System.out.println(i + ": " + dicesArray[i].getString());
        }
    }

    static void setGotYatzy(boolean bool) {
        gotYatzy = bool;
    }

    static void checkDicesArrForYazty(Die[] dicesArray){
        for (int j = 1; j < 5; j++) {
            if( dicesArray[j].value != dicesArray[j-1].value) {
                //Set gotYatzy to false
                setGotYatzy(false);
            }
        }
    }

    static void setNextTurnNumber( int setCurrnetTurn) {
        //create metod where the where you can setUser input.
        Scanner sc = new Scanner(System.in);

        if(sc.next().equals("y")) {
            playerTurn = setCurrnetTurn;
        } else {
            gameIsRunning = !!!gameIsRunning;
            playerTurn = numberOfThrows + 1; //instead of break statement
        }
    }  

    static void NextPlayersDiceRoll(int numberOfTurns){
          //next user turn
          while( playerTurn < numberOfTurns) {
            System.out.println("Starting turn " + (playerTurn + 1) + " of 3, rolling dice.");
            rollAllDices(dicesArray);
            checkDicesArrForYazty(dicesArray);

            if(gotYatzy == true) {
                System.out.println("You got YATZI! in " + dicesArray[0].value + "'s");
                return;
            } 
            else {
                //Here we check if there is no Yatzy: then we check what turn we are on and asks the player if we want to continue or not
                if(playerTurn != 2) {
                    System.out.println("Want to throw again? (y for yes, anything else for no)");
                    setNextTurnNumber(playerTurn + 1);
                } 
                else {
                    System.out.println("Game over! Want to play again?");
                    setNextTurnNumber(0);
                }
            }
        }
    }

}