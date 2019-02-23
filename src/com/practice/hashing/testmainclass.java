package com.practice.hashing;

public class testmainclass {
	public static void main(String s[]) {
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		map.put(2, 2);
		
		HappyNumber num = new HappyNumber();
		System.out.println("isHappy : "+num.isHappy(19));
		
		IsoMorphic iso = new IsoMorphic();
		System.out.println(iso.isIsomorphic("add", "ehg"));
	}

}
