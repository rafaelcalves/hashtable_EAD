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
        int index = getIndex(key);
        if (isList(array[index])) {
            List<Item> itemList = (List<Item>) array[index];
            return removeFromList(key, itemList);
        }
        return clearPosition(index);
    }

    @Override
    public int insert(Item<V> item) {
        int index = getIndex(item.getKey());

        if(nonNull(array[index])) {
            addToList(item, index);
        } else {
            array[index] = item;
        }
        return index;
    }

    @Override
    public Item<V> search(int key) {
        int index = getIndex(key);
        if(nonNull(array[index])) {
            if (isList(array[index])) {
                List<Item> itemList = (List<Item>) array[index];
                return getFromList(itemList, key);
            }
            Item item = (Item) array[index];
            if (hasKey(item, key)) return item;
        }
        return null;
    }

    @Override
    public void print() {
        for (Object item: array) {
            if(isList(item)){
                for (Item collisionItem: (List<Item>) item)
                    System.out.print(collisionItem + " ");
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