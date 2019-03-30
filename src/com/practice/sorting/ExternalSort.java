package com.practice.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalSort {

	int maxDataProcess = 1024;

	String folderPath = null;

	public void sort(File inputFile) throws IOException {

		long maxElem = 500000;
		List<File> files = createAndSortChunkFiles(maxElem, inputFile);

		MergeSortedFiles(files);

	}

	private void MergeSortedFiles(List<File> files) throws IOException {
		PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<BinaryFileBuffer>();
		for (File file : files) {
			BinaryFileBuffer bfb = new BinaryFileBuffer(file);
			pq.add(bfb);
		}
		String outputfile = folderPath + "/output.txt";
		BufferedWriter fbw = new BufferedWriter(new FileWriter(outputfile));
		try {
			while (pq.size() > 0) {
				BinaryFileBuffer bfb = pq.poll();
				String r = bfb.pop();
				fbw.write(r);
				fbw.newLine();
				if (bfb.empty()) {
					bfb.fbr.close();
					bfb.originalfile.delete();// we don't need you anymore
				} else {
					pq.add(bfb); // add it back
				}
			}
		} finally {
			fbw.close();
			for (BinaryFileBuffer bfb : pq)
				bfb.close();
		}

	}

	private List<File> createAndSortChunkFiles(long maxElem, File inputFile) throws NumberFormatException, IOException {
		long totalElem = 0;
		BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
		while (inputReader.readLine() != null) {
			totalElem++;
		}
		List<File> files = new ArrayList<File>();
		inputReader.close();
		String absPath = inputFile.getAbsolutePath();
		folderPath = absPath.substring(0, absPath.lastIndexOf("/"));

		int totalTmpFiles = (int) Math.ceil(totalElem / maxElem);
		int buffer[] = new int[500000];
		inputReader = new BufferedReader(new FileReader(inputFile));
		// created chunk tmp sorted files
		for (int i = 0; i < totalTmpFiles; i++) {
			String outputtmpfile = folderPath + "/tmp-file" + i + ".txt";
			for (int j = 0; j < maxElem; j++) {
				buffer[j] = Integer.parseInt(inputReader.readLine());
			}
			CountSort sort = new CountSort();
			buffer = sort.sort(buffer);
			File tmpFile = new File(outputtmpfile);
			files.add(tmpFile);
			BufferedWriter bfw = new BufferedWriter(new FileWriter(tmpFile));
			for (int k = 0; k < buffer.length; k++) {
				bfw.write(String.valueOf(buffer[k]));
				bfw.write("\n");
			}
			bfw.close();
		}
		return files;

	}

	class BinaryFileBuffer implements Comparable<BinaryFileBuffer> {
		public BufferedReader fbr;
		public File originalfile;
		private String cache;
		private boolean empty;

		public BinaryFileBuffer(File f) throws IOException {
			originalfile = f;
			fbr = new BufferedReader(new FileReader(f));
			reload();
		}

		public boolean empty() {
			return empty;
		}

		private void reload() throws IOException {
			try {
				if ((this.cache = fbr.readLine()) == null) {
					empty = true;
					cache = null;
				} else {
					empty = false;
				}
			} catch (Exception oef) {
				empty = true;
				cache = null;
			}
		}

		public void close() throws IOException {
			fbr.close();
		}

		public String peek() {
			if (empty())
				return null;
			return cache.toString();
		}

		public String pop() throws IOException {
			String answer = peek();
			reload();
			return answer;
		}

		@Override
		public int compareTo(BinaryFileBuffer o) {
			if (Integer.parseInt(this.peek()) < Integer.parseInt(o.peek())) {
				return -1;
			} else {
				return 1;
			}
		}

	}

}