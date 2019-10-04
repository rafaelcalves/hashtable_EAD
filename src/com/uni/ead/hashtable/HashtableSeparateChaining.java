package com.uni.ead.hashtable;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class HashtableSeparateChaining<V> extends AbstractHashtable<V> {

    public HashtableSeparateChaining(int m) {
        super(m);
    }

    @Override
    public Item<V> delete(int key) {
        int hash = getHash(key);
        if (isList(array[hash])) {
            List<Item> itemList = (List<Item>) array[hash];
            return removeFromList(key, itemList);
        }
        return clearPosition(hash);
    }

    @Override
    public int insert(Item<V> item) {
        int hash = getHash(item.getKey());

        if(nonNull(array[hash])) {
            addToList(item, hash);
        } else {
            array[hash] = item;
        }
        return hash;
    }

    @Override
    public Item<V> search(int key) {
        int hash = getHash(key);
        if(nonNull(array[hash])) {
            if (isList(array[hash])) {
                List<Item> itemList = (List<Item>) array[hash];
                return getFromList(itemList, key);
            }
            Item item = (Item) array[hash];
            if (hasKey(item, key)) return item;
        }
        return null;
    }

    @Override
    public void print() {
        for (Object item: array) {
            if(isList(item)){
                System.out.print("[");
                for (Item collisionItem: (List<Item>) item)
                    System.out.print(collisionItem + " ");
                System.out.print("]");
            } else {
                System.out.print(item + " ");
            }
        }
    }

    private Item<V> getFromList(List<Item> itemList, int key) {
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (hasKey(item, key)) return item;
        }
        return null;
    }

    private Item<V> removeFromList(int key, List<Item> itemList) {
        Item toRemove = getFromList(itemList, key);
        if(nonNull(toRemove)) return clearPosition(itemList,toRemove);
        return null;
    }

    private Item<V> clearPosition(List<Item> itemList, Item item) {
        itemList.remove(item);
        return item;
    }

    private void addToList(Item<V> item, int index) {
        if (isList(array[index])) {
           ((List)array[index]).add(item);
        } else {
            startList(item, index);
        }
    }

    private void startList(Item<V> item, int index) {
        List<Item> itemList = new ArrayList<>();
        itemList.add((Item) array[index]);
        itemList.add(item);
        array[index] = itemList;
    }

    private boolean isList(Object o) {
        return o instanceof List;
    }

}