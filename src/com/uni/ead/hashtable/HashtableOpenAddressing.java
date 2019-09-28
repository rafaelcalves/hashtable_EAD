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
        int index = getIndex(key);
        if (isNull(array[index])) return null;
        if (hasKey((Item)array[index],key)){
            toRemove = (Item)array[index];
            array[index] = new DeletedItem();
            return toRemove;
        }

        return collisionDelete(key, index, 0);
    }

    @Override
    public int insert(Item<V> item) {
        int index = getIndex(item.getKey());
        if(isEmpty(array[index])){
            array[index] = item;
            return index;
        }
        return collisionInsert(item, index, 0);
    }

    @Override
    public Item<V> search(int key) {
        int index = getIndex(key);

        if (isNull(array[index])) return null;
        if (hasKey((Item)array[index],key))return (Item) array[index];

        return collisionSearch(key, index, 0);
    }

    @Override
    public void print() {
        for (Object item: array){
            System.out.print(item + " ");
        }
    }

    private Item<V> collisionDelete(int key, int index, int iterator){
        if(iterator >= array.length) return null;

        index = getCollisionIndex(index, iterator);
        if (isNull(array[index])) return null;
        if (hasKey((Item)array[index],key)){
            Item toRemove = (Item)array[index];
            array[index] = new DeletedItem();
            return toRemove;
        }

        return collisionDelete(key, index, iterator + 1);
    }

    private int collisionInsert(Item<V> item, int index, int iterator) {
        if(iterator >= array.length) return -1;
        index = getCollisionIndex(index, iterator);
        if (isEmpty(array[index])) {
            array[index] = item;
            return index;
        }
        return collisionInsert(item, index, iterator + 1);
    }

    private Item<V> collisionSearch(int key, int index, int iterator) {
        if(iterator >= array.length) return null;

        index = getCollisionIndex(index, iterator);
        if (isNull(array[index])) return null;
        if (hasKey((Item)array[index],key))return (Item) array[index];

        return collisionSearch(key, index, iterator + 1);
    }

    private boolean isEmpty(Object item) {
        return isNull(item) || item instanceof DeletedItem;
    }


    private int getCollisionIndex(int index, int j) {
        ProbingStrategy probingStrategy = new ProbingStrategy();
        index = probingStrategy.getIndex(this, index, j);
        return index;
    }

    public int getQ() {
        return q;
    }

    public int getProbing() {
        return probing;
    }
}