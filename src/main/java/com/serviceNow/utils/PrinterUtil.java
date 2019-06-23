package com.serviceNow.utils;

public class PrinterUtil {
	
	public static void printImage(char[][] image){
		int length = image.length;
		int width = image[0].length;
		for (int i=0; i < length ; i++){
			for (int j=0; j < width ; j++){
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
	}

}
