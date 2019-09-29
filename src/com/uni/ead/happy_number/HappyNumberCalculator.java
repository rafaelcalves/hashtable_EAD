package com.uni.ead.happy_number;

import com.uni.ead.hashtable.Hashtable;
import com.uni.ead.hashtable.HashtableSeparateChaining;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

/*
Solução basead na url: https://leetcode.com/problems/happy-number/
*/

public class HappyNumberCalculator {
    public boolean isHappy(int number){
        Hashtable<Integer> log = new HashtableSeparateChaining(10);
        return iterateHappiness(number, log);
    }

    protected boolean iterateHappiness(int number, Hashtable log){
        List<Integer> digits = getDigits(number);
        int squaresResult = sumSquares(digits);
        if(squaresResult == 1) return true;
        if(isNull(log.search(squaresResult))) {
            log.insertPair(number, squaresResult);
            return iterateHappiness(squaresResult, log);
        }
        return false;
    }

    protected List<Integer> getDigits(int number){
        int iterator = number;
        List<Integer> digits = new ArrayList();
        while (iterator > 0) {
            digits.add(iterator % 10);
            iterator = iterator / 10;
        }
        return digits;
    }
    protected int sumSquares(List<Integer> digits){
        int squaresSum = 0;
        for (int digit:digits) {
            squaresSum += digit;
        }
        return squaresSum;
    }
}
