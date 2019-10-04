package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class DoubleProbingHandler implements ProbingHandler {
    @Override
    public int getHash(HashtableOpenAddressing hashtable, int key, int iterator) {
        int doubleHash = doubleHash(hashtable, key);
        return (key + iterator*doubleHash) % hashtable.getSize();
    }

    protected int doubleHash(HashtableOpenAddressing hashtable, int key){
        return 	hashtable.getQ() - (key%hashtable.getQ());
    }
}
