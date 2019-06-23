package com.serviceNow.analyzer;

public class DataAnalyzer implements IDataAnalyzer {

	public double getSimilarityScore(char[][] shape1, char[][] shape2) {
		int matchCounter = 0;
		int nonMatchCounter = 0;
		for (int i=0; i < shape1.length; i++){
			for (int j=0; j < shape1[i].length; j++){
				if (shape1[i][j] == shape2[i][j]){
					matchCounter++;
				}else{
					nonMatchCounter++;
				}
			}
		}
		return calcSimilarity(matchCounter, nonMatchCounter);		
	}
	
	private double calcSimilarity(int matches, int nonMatches){
		int total = matches + nonMatches;
		double similarity = (double)matches / (double)total;
		return similarity * 100;
	}



}
