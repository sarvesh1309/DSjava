package com.practice.backtracking;

import java.util.Vector;

public class DiceSum {
	static int dice[];
	static int NoOfCall=0;
	public static void main(String s[]) {
		DiceSum ds = new DiceSum();
		int n=2;
		dice = new int[n];
		//ds.diceSum(n,8);
		
		Vector<Integer> v = new Vector<Integer>();
		ds.diceSumHelper(4, 14,0, v);
		System.out.println("No of call"+NoOfCall);
		
		
	}
	

	
	public void diceSum(int diceNum, int DesiredSum) {
		if(diceNum==0) {
			if(DesiredSum==0) {
			printArray(dice);
			}
		}else{
			for(int i=1;i<=6;i++) {
				dice[diceNum-1]=i;
				diceSum(diceNum-1,DesiredSum-i);
			}
		}
	}
	
	
	public void diceSumHelper(int diceNum,int DesiredSum,int SumSoFar,Vector<Integer> output) {
		NoOfCall++;
		if(diceNum==0) {
			System.out.println(output);
			
		}else {
			
			for(int i=1;i<=6;i++) {
				if((SumSoFar+i+(1*(diceNum-1))<=DesiredSum) && (SumSoFar+i+(6*(diceNum-1))>=DesiredSum)) {
				output.add(i);
				diceSumHelper(diceNum-1, DesiredSum,SumSoFar+i, output);
				output.remove(output.size()-1);
				}
			}
		}
	}
	
	
	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}

}
