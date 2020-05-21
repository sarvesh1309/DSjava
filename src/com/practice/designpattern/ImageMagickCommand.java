package com.practice.designpattern;

public class ImageMagickCommand implements Command {

	@Override
	public String getCommandPath() {
		return "/usr/local/bin/convert";
	}
	
	

}
