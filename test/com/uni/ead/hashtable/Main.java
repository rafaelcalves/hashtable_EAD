package com.uni.ead.hashtable;

import com.uni.ead.hashtable.probing.strategy.ProbingStrategy;

public class Main {
    public static void main(String[] args) {
        Hashtable linear = new HashtableOpenAddressing(11,7, ProbingStrategy.LINEAR_PROBING);
        doTest(linear);
        Hashtable quadratic = new HashtableOpenAddressing(11,7, ProbingStrategy.QUADRATIC_PROBING);
        doTest(quadratic);
        Hashtable doubleHash = new HashtableOpenAddressing(11,7, ProbingStrategy.DOUBLE_PROBING);
        doTest(doubleHash);
        Hashtable separateChaining = new HashtableSeparateChaining(11);
        doTest(separateChaining);
    }

    private static void doTest(Hashtable hashtable) {
        System.out.println();
        System.out.println("Starting test");
        int[] numbers = {7,17, 36, 100, 106, 205};
        for (int number: numbers) {
            hashtable.insert(new Item(number, String.valueOf(number)));
            hashtable.print();
            System.out.println();
        }
        System.out.println("Finished insert");

        int keyToDelete = 17;
        System.out.println(hashtable.search(keyToDelete));
        hashtable.print();
        System.out.println();

        hashtable.delete(keyToDelete);
        System.out.println("Deleted key " + keyToDelete);
        hashtable.print();
        System.out.println();

        System.out.println(hashtable.search(keyToDelete));
        System.out.println("Test Finished");
        System.out.println();
    }
}
