package com.practice.designpattern;

public class FfmpegCommand implements Command {
	
	
	@Override
	public String getCommandPath() {
		return "/usr/local/bin/ffmpeg";
	}

}
