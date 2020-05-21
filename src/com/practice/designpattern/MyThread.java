package com.practice.designpattern;

public class MyThread extends Thread {
	
	public void run(){
		Command cmd = CommandFactory.getCommand("ffmpeg");
		System.out.println("in my thread");
		System.out.println(cmd.hashCode());
	}
	
	

}
