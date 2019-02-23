package com.practice.hashing;

class MyHashSet {
    int bucketNum;
    int numOfBucket;
    boolean[][] bucketTable;

   /** Initialize your data structure here. */
   public MyHashSet() {
	   bucketNum =1000;
	   numOfBucket=1000;
	   bucketTable = new boolean[bucketNum][numOfBucket];

   }
   

	public void add(int key) {
		int keyVal = hashkey(key);
		int value = key/bucketNum;
		bucketTable[keyVal][value]=true;
		
	}
   
	public void remove(int key) {
		int keyVal = hashkey(key);
		int value = key / bucketNum;
		if (contains(key)) {
			bucketTable[keyVal][value] = false;
		}
	}
   
   /** Returns true if this set contains the specified element */
   public boolean contains(int key) {
	   int keyVal = hashkey(key);
		int value = key/bucketNum;
		if(bucketTable[keyVal][value]) {
			return true;
		}
		return false;
   }
   
   private int hashkey(int key){
       return key%bucketNum;
   }
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/
