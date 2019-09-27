package com.uni.ead.hashtable;

public class HashtableOpenAddressing<V> extends AbstractHashtable<V> {

    protected int q;
    protected int probing;

    public HashtableOpenAddressing(int m, int q, int probing){
        super(m);
        this.q = q;
        this.probing = probing;
    }

    @Override
    public Item<V> delete(int key) {
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        return 0;
    }

    @Override
    public Item<V> search(int key) {
        return null;
    }

    @Override
    public void print() {

    }

    public int getQ() {
        return q;
    }

    public int getProbing() {
        return probing;
    }
}