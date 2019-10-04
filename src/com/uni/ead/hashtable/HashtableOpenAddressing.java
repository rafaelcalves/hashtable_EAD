package com.uni.ead.hashtable;

import com.uni.ead.hashtable.probing.strategy.ProbingStrategy;

import static java.util.Objects.isNull;

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
        Item toRemove;
        int hash = getHash(key);
        if (isNull(array[hash])) return null;
        if (hasKey((Item)array[hash],key)){
            toRemove = (Item)array[hash];
            array[hash] = new DeletedItem();
            return toRemove;
        }

        return collisionDelete(key, hash, 0);
    }

    @Override
    public int insert(Item<V> item) {
        int hash = getHash(item.getKey());
        if(isEmpty(array[hash])){
            array[hash] = item;
            return hash;
        }
        return collisionInsert(item, hash, 0);
    }

    @Override
    public Item<V> search(int key) {
        int hash = getHash(key);

        if (isNull(array[hash])) return null;
        if (hasKey((Item)array[hash],key))return (Item) array[hash];

        return collisionSearch(key, hash, 0);
    }

    @Override
    public void print() {
        for (Object item: array){
            System.out.print(item + " ");
        }
    }

    private Item<V> collisionDelete(int key, int hash, int iterator){
        if(iterator >= array.length) return null;

        int collisionHash = getCollisionHash(hash, iterator);
        if (isNull(array[collisionHash])) return null;
        if (hasKey((Item)array[collisionHash],key)){
            Item toRemove = (Item)array[collisionHash];
            array[collisionHash] = new DeletedItem();
            return toRemove;
        }

        return collisionDelete(key, hash, iterator + 1);
    }

    private int collisionInsert(Item<V> item, int hash, int iterator) {
        if(iterator >= array.length) return -1;
        int collisionHash = getCollisionHash(hash, iterator);
        if (isEmpty(array[collisionHash])) {
            array[collisionHash] = item;
            return collisionHash;
        }
        return collisionInsert(item, hash, iterator + 1);
    }

    private Item<V> collisionSearch(int key, int hash, int iterator) {
        if(iterator >= array.length) return null;

        int collisionHash = getCollisionHash(hash, iterator);
        if (isNull(array[collisionHash])) return null;
        if (hasKey((Item)array[collisionHash],key))return (Item) array[collisionHash];

        return collisionSearch(key, hash, iterator + 1);
    }

    private boolean isEmpty(Object item) {
        return isNull(item) || item instanceof DeletedItem;
    }


    private int getCollisionHash(int hash, int j) {
        ProbingStrategy probingStrategy = new ProbingStrategy();
        hash = probingStrategy.getHash(this, hash, j);
        return hash;
    }

    public int getQ() {
        return q;
    }

    public int getProbing() {
        return probing;
    }
}