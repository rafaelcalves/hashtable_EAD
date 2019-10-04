package com.uni.ead.hashtable;

public abstract class AbstractHashtable<V> implements Hashtable<V>{
    protected Object[] array;

    protected AbstractHashtable(int m){
        array = new Object[m];
    }

    protected int getHash(int key){
        return key % this.array.length;
    }

    protected boolean hasKey(Item item, int key) {
        return item.getKey() == key;
    }

    protected Item<V> clearPosition(int hash) {
        Item removed = (Item)array[hash];
        array[hash] = null;
        return removed;
    }

    public int getSize(){
        return array.length;
    }

    @Override
    public int insertPair(int key, V value){
        return insert(new Item(key,value));
    }
}
