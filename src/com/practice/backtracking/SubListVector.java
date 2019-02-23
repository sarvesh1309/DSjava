package com.practice.backtracking;

import java.util.Vector;

public class SubListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubListVector PV = new SubListVector();
		Vector<String> c = new Vector<String>();
		c.add("a");
		c.add("b");
		c.add("c");
		//c.add("d");
		
		PV.sublist(c);

	}

	private void sublist(Vector<String> v) {
		Vector<String> c = new Vector<String>();
		sublisthelper(v, c);
		
	}
	
	private void sublisthelper(Vector<String> v, Vector<String> choosen) {
			if(v.isEmpty()) {
				System.out.println(choosen);
		}else {
			String s = v.get(0);
			v.remove(0);
			
			//explore without s
			sublisthelper(v, choosen);
			
			//explore with s
			choosen.addElement(s);
			sublisthelper(v, choosen);
			
			//unchoose
			
			v.add(0,s);
			choosen.remove(choosen.size()-1);
			
		}
	}
	
	

}
