package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class LinearProbingHandler implements ProbingHandler {
    @Override
    public int getIndex(HashtableOpenAddressing hashtable, int key) {
        return (key + hashtable.getQ()) % hashtable.getSize();
    }
}
