package com.practice.designpattern;

public class CommandFactory {

	private static FfmpegCommand ffmpeg = null;

	private static ImageMagickCommand imgmagick = null;
	
	private CommandFactory(){
		
	}

	public static Command getCommand(String cmd) {
		if (cmd.equalsIgnoreCase("ffmpeg")) {
			if (ffmpeg == null){
				synchronized (CommandFactory.class) {
					ffmpeg = new FfmpegCommand();
				}
			}
			return ffmpeg;
		} else if (cmd.equalsIgnoreCase("imagemagick")) {
			if (imgmagick == null)
				imgmagick = new ImageMagickCommand();
			return imgmagick;
		}
		return null;

	}

}
