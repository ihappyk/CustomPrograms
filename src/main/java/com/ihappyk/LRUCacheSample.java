package com.ihappyk;

import java.util.LinkedHashSet;
import java.util.Set;

class LRU {
    private Set<Integer> cache;
    private int capacity;

    LRU(int MAX_SIZE){
        this.capacity = MAX_SIZE;
        this.cache = new LinkedHashSet<Integer>(capacity);
    }

    public void put(int key){
        if(capacity == cache.size()) {
             int remove = cache.iterator().next();
             cache.remove(remove);
        }
        cache.add(key);
    }

    public boolean get(int key){
        if(!cache.contains(key)) {
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }
}

public class LRUCacheSample
{

}
