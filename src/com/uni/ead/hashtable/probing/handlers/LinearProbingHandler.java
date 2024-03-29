package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class LinearProbingHandler implements ProbingHandler {

    @Override
    public int getHash(HashtableOpenAddressing hashtable, int key, int iterator) {
        return (key + iterator) % hashtable.getSize();
    }
}
