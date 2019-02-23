package com.practice.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostFollower {
	
	public static void main(String s[]) {
		MyGraph socialGraph = new MyGraphImpl();
		BufferedReader reader =null;
		try {
			InputStreamReader file = new FileReader("D:\\Sarvesh-Study\\Followers.txt");
			reader = new BufferedReader(file);
			String str =null;
			while((str = reader.readLine()) !=null ) {
				//System.out.println("string "+str);
				if(str!=null && !str.isEmpty()) {
				String follower = str.split(",")[0];
				String followed = str.split(",")[1];
				socialGraph.addEdge(followed, follower,false);
				}
			}
			
			int max =0;
			String haveMaxfof = null;
			for (String user : socialGraph.getVertices().keySet()) {
				int fof = 0;
				for (String user1 : socialGraph.getNeighbour(user)) {
					fof += socialGraph.getNeighbour(user1).size();
				}
				if (fof > max) {
					max = fof;
					haveMaxfof = user;
				}
			}
			
			System.out.println("most follower of followers person is "+ haveMaxfof);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
