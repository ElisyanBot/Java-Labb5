package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        YatziMain.setDiceArray(5);

        for(Die die: YatziMain.dicesArray) {
            die.value = 6;
        }

        YatziMain.checkDicesArrForYazty(YatziMain.dicesArray);

        assertEquals(true, YatziMain.gotYatzy);
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        YatziMain.setDiceArray(5);
        
        for(Die die: YatziMain.dicesArray) {
            die.value = 6;
        }
        YatziMain.dicesArray[4].value = 1;
        
        YatziMain.checkDicesArrForYazty(YatziMain.dicesArray);

        assertEquals(false, YatziMain.gotYatzy);

    }
}