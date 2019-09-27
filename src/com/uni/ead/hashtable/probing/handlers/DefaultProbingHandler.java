package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class DefaultProbingHandler implements ProbingHandler {
    @Override
    public int getIndex(HashtableOpenAddressing hashtable, int key) throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }
}
