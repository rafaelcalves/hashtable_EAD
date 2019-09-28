package com.uni.ead.hashtable.probing.strategy;

import com.uni.ead.hashtable.HashtableOpenAddressing;
import com.uni.ead.hashtable.probing.handlers.DefaultProbingHandler;
import com.uni.ead.hashtable.probing.handlers.DoubleProbingHandler;
import com.uni.ead.hashtable.probing.handlers.LinearProbingHandler;
import com.uni.ead.hashtable.probing.handlers.QuadraticProbingHandler;
import com.uni.ead.hashtable.probing.handlers.base.ProbingHandler;

public class ProbingStrategy {
    public static final int LINEAR_PROBING = 0;
    public static final int QUADRATIC_PROBING = 1;
    public static final int DOUBLE_PROBING = 2;

    public int getIndex(HashtableOpenAddressing hashtable, int key, int iterator){
        ProbingHandler probingHandler = null;

        switch (hashtable.getProbing()){
            case LINEAR_PROBING:
                probingHandler = new LinearProbingHandler();
                break;
            case QUADRATIC_PROBING:
                probingHandler = new QuadraticProbingHandler();
                break;
            case DOUBLE_PROBING:
                probingHandler = new DoubleProbingHandler();
                break;
            default:
                probingHandler = new DefaultProbingHandler();
                break;
        }

        return probingHandler.getIndex(hashtable, key, iterator);

    }
}
