package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class QuadraticProbingHandler implements ProbingHandler {
    @Override
    public int getIndex(HashtableOpenAddressing hashtable, int key) {
        return (key + hashtable.getQ()^2) % hashtable.getSize();
    }
}
