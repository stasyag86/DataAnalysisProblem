package com.serviceNow.utils;

import java.util.List;

public class ConvertUtil {
	
	
	public static  char[][] convertToArray(List<char[]> matrix){
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
