package com.practice.backtracking;

import java.util.HashSet;
import java.util.Set;

public class PermuteString {
	
	
	Set<String> KString;
	Set<String> permString;

	//Permute All String
   public void Permute(String array) {
	  PermuteAllStringsII(array,"");
   }
   
   public void PermuteKStrings(String array,int k){
	   KString = new HashSet<String>();
	   PermuteKString("",array,k);
	   System.out.println(KString);
	   
   }
   
   private void PermuteKString(String choosen,String array,int k){
	   if(choosen.length()==k) {
		   KString.add(choosen);
	   }else {
		   for(int i=0;i<array.length();i++) {
			   PermuteKString(choosen+array.charAt(i),(array.substring(0, i)+array.substring(i+1,array.length())), k);
		   }
	   }
   }
	
	// Right solutions
	private void PermuteAllStringsII(String array,String choosen) {
		if(array.isEmpty()) {
			System.out.println(choosen);
		}else {
			for(int i=0;i<array.length();i++) {
			PermuteAllStringsII((array.substring(0, i)+array.substring(i+1,array.length())), choosen+array.charAt(i));
			}
		}
	}
	void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}
   
   
}
