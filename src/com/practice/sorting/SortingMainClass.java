package com.practice.sorting;

import java.util.Arrays;

public class SortingMainClass {

	public static void main(String s[]) {

		int nut[]=new int[]{2,4,8,3,5};
		 int bolt[] = new int []{4,2,8,5,3};
		
		 NutsBoltsProblem nutBolt = new NutsBoltsProblem();
		 nutBolt.matchNutBolts(nut, bolt);
		 System.out.println("nuts"+Arrays.toString(nut));
		 System.out.println("bolts"+Arrays.toString(bolt));

		
	}

}
