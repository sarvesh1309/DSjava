package com.practice.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountMostRepeatedWordInFile {

	public String count(String filePath) {
		Map<String, Integer> words = new HashMap<>();
		String mostRepeated = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(filePath)));
			String str = null;
			while ((str = br.readLine()) != null) {
				String values[] = str.replace(".", " ").split(" ");
				for (String val : values) {
					if (words.containsKey(val)) {
						int i = words.get(val);
						words.put(val, (i + 1));
					} else {
						words.put(val, 0);
					}
				}
			}
			int max = 0;
			for (String s : words.keySet()) {
				if (words.get(s) > max) {
					mostRepeated = s;
					max = words.get(s);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mostRepeated;

	}

}
