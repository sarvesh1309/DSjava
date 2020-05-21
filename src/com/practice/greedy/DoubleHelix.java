package com.practice.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoubleHelix {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		 String str1[] = br.readLine().split(" ");
		 int []first = new int[str.length];
		 int [] second = new int[str1.length];
		 for(int i =0;i<str.length;i++){
		 	first[i] =  Integer.parseInt(str[i]);
		 }
		 for(int j =0;j<str1.length;j++){
		 		second[j] =  Integer.parseInt(str1[j]);
		 }
		int i =0,j=0;
		int output = 0;
		int sfirst  = 0;
	    int ssecond = 0;
		while(i < first.length && j<second.length){
			if(first[i] == second[j]){
				output += Math.max(sfirst,ssecond);
				output += first[i];
				i++;
				j++;
				sfirst = 0;
				ssecond = 0;
			}else{
				sfirst = sfirst + first[i++];
				ssecond += second[j++];
			}
		}
		while(i < first.length){
				sfirst = sfirst + first[i++];
		}
		while(j < second.length){
			  ssecond += second[j++];
		}
		output += Math.max(sfirst,ssecond);
		System.out.println(output);
			
	}
		
}
