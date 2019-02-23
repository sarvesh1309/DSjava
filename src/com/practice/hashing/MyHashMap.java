package com.practice.hashing;

class MyHashMap {
    int bucketSize;
    Bucket[] bucketArray;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucketSize=1000;
        bucketArray = new Bucket[bucketSize];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = getHash(key);
        int hashValue = key/1000;
        Bucket b;
        if(bucketArray[hashKey]==null) {
        	b = new Bucket();
        	bucketArray[hashKey]=b;
        }else {
        	b = bucketArray[hashKey];
        }
        b.add(hashValue, new ListItem(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	 int hashKey = getHash(key);
    	 int hashValue = key/1000;
         int value =-1;
         if(bucketArray[hashKey]!=null) {
        	Bucket b = bucketArray[hashKey];
        	value = b.get(hashValue);
         }
         return value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	 int hashKey = getHash(key);
    	 int hashValue = key/1000;
         if(bucketArray[hashKey]!=null) {
        	 Bucket b = bucketArray[hashKey];
        	 b.remove(hashValue);
         }
    }
    
    private int getHash(int key) {
    	return key%bucketSize;
    }
}

class Bucket{
	public ListItem[] item ;
	public Bucket() {
		item = new ListItem[1000];
	}
	
	public void add(int pos, ListItem listitem) {
		item[pos]=listitem;
	}
	public int get(int pos) {
	   if(item[pos]!=null) {
		   return item[pos].getValue();
	   }
	   return -1;
	}
	public void remove(int pos) {
		 if(item[pos]!=null) {
			 item[pos]=null;
		 }
	}
}

class ListItem {
	 int key;
	 int value;
	
	public ListItem(int key,int value) {
		this.key=key;
		this.value=value;
	}
	
	public int getKey() {
		return key;
	}
	public int getValue() {
		return value;
	}

}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
