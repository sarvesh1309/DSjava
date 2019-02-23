package com.practice.backtracking;

import java.util.Vector;

public class PermuteVector {

	public static void main(String[] args) {
		PermuteVector PV = new PermuteVector();
		Vector<String> c = new Vector<String>();
		c.add("a");
		c.add("b");
		c.add("c");
		//c.add("d");
		
		PV.Permute(c);

	}

	void Permute(Vector<String> v){
		Vector<String> c = new Vector<String>();
		System.out.println("below are the permutation for "+v);
		permuteHelper(v, c);
		
	}
	void permuteHelper(Vector<String> v, Vector<String> choosen){
		if(v.isEmpty()) {
			System.out.println(choosen);
		}else {
			for(int i=0 ; i<v.size();i++) {
				//choose
				String s = v.get(i);
				choosen.add(v.get(i));
				v.remove(i);
				//option
				permuteHelper(v, choosen);
				//unchoose
				String s1 = choosen.get(choosen.size()-1);
				choosen.removeElementAt(choosen.size()-1);
				v.add(i, s);
				
				
			}
		}
	}

}
