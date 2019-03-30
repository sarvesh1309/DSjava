package com.practice.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * sort the content of a file 
 * @author sarveshkumar
 *
 */
public class SortAFileContent {

	public void sort(File f) throws IOException {
		String path = f.getAbsolutePath();
		String outputfilePath = path.substring(0, path.lastIndexOf("/")) + "/output.txt";
		int[] input = new int[2000000];
		BufferedReader bf = null;
		BufferedWriter bfwriter = null;
		try {
			bf = new BufferedReader(new FileReader(f));
			int k = 0;
			while (true) {
				String str = null;
				if ((str = bf.readLine()) != null) {
					input[k] = Integer.parseInt(str);
					k++;
				} else {
					break;
				}
			}

			// count sort to sort input element
			int aux[] = new int[2000000];
			int sorted[] = new int[2000000];
			for (int i = 0; i < input.length; i++) {
				aux[input[i]] = aux[input[i]] + 1;
			}
			for (int i = 1; i < input.length; i++) {
				aux[i] = aux[i - 1] + aux[i];
			}
			for (int i = 0; i < input.length; i++) {
				sorted[aux[input[i]] - 1] = input[i];
				aux[input[i]] -= 1;
			}

			File output = new File(outputfilePath);
			bfwriter = new BufferedWriter(new FileWriter(output));
			for (int i = 0; i < sorted.length; i++) {
				bfwriter.write(Integer.toString(sorted[i]));
				bfwriter.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bf.close();
			bfwriter.close();
		}

	}

}
