package com.uni.ead.hashtable.probing.handlers;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class DoubleProbingHandler implements ProbingHandler {
    @Override
    public int getIndex(HashtableOpenAddressing hashtable, int key) {
        int doubleHash = doubleHash(hashtable, key);
        return (key + hashtable.getQ()* doubleHash) % hashtable.getSize();
    }

    public int doubleHash(HashtableOpenAddressing hashtable, int key){
        return 	hashtable.getQ() - (key%hashtable.getQ());
    }
}
