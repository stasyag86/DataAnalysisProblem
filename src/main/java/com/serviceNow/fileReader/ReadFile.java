package com.serviceNow.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public char[][] convertImageToArray(String filePath){
		List<char[]> shapeMatrix = new ArrayList<char[]>();
		BufferedReader reader;
		try {
			
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				shapeMatrix.add(line.toCharArray());
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convertToArray(shapeMatrix);
	}
	
	private char[][] convertToArray(List<char[]> matrix){
		char [][] matrixArray = null;
		try {
			int length = matrix.size();
			int width = matrix.get(0).length;
			matrixArray = new char [length][width];
			for (int i=0; i < length; i++){
				char[] rowInMatrix = matrix.get(i);
				for (int j=0; j < rowInMatrix.length; j++){
					matrixArray[i][j] = rowInMatrix[j];
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return matrixArray;
	}
	
}
