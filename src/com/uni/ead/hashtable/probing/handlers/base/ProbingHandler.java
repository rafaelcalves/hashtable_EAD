package com.uni.ead.hashtable.probing.handlers.base;

import com.uni.ead.hashtable.HashtableOpenAddressing;

public interface ProbingHandler {
    int getIndex(HashtableOpenAddressing hashtable, int key);
}
