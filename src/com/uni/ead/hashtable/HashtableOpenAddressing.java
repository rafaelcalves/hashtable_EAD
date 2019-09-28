package com.uni.ead.hashtable;

import com.uni.ead.hashtable.probing.strategy.ProbingStrategy;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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

        if (hasKey((Item)array[index],key)){
            toRemove = (Item)array[index];
            array[index] = new DeletedItem();
            return toRemove;
        }

        if (isNull(array[index])) return null;

        for (int j = 0; j < array.length; j++) {
            ProbingStrategy probingStrategy = new ProbingStrategy();
            index = probingStrategy.getIndex(this, index, j);
            if (hasKey((Item)array[index],key)){
                if (hasKey((Item)array[index],key)){
                toRemove = (Item)array[index];
                array[index] = new DeletedItem();
                return toRemove;
            }}
            if (isNull(array[index])) return null;
        }

        return null;
    }

    @Override
    public int insert(Item<V> item) {
        int index = getIndex(item.getKey());

        if(nonEmpty(array[index])) {
            for (int j = 0; j < array.length; j++) {
                ProbingStrategy probingStrategy = new ProbingStrategy();
                index = probingStrategy.getIndex(this, index, j);
                if (isEmpty(array[index])) {
                    array[index] = item;
                    return index;
                }
            }
        }

        array[index] = item;
        return index;
    }

    private boolean nonEmpty(Object item) {
        return nonNull(item) && !(item instanceof DeletedItem);
    }

    private boolean isEmpty(Object item) {
        return isNull(item) || item instanceof DeletedItem;
    }

    @Override
    public Item<V> search(int key) {
        int index = getIndex(key);

        if (hasKey((Item)array[index],key))return (Item) array[index];
        if (isNull(array[index])) return null;

        for (int j = 0; j < array.length; j++) {
            ProbingStrategy probingStrategy = new ProbingStrategy();
            index = probingStrategy.getIndex(this, index, j);
            if (hasKey((Item)array[index],key))return (Item) array[index];
            if (isNull(array[index])) return null;
        }
        return null;
    }

    @Override
    public void print() {
        for (Object item: array){
            System.out.println(item.toString() + " ");
        }
    }

    public int getQ() {
        return q;
    }

    public int getProbing() {
        return probing;
    }
}