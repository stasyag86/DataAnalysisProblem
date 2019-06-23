package com.serviceNow.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.serviceNow.analyzer.DataAnalyzer;
import com.serviceNow.analyzer.IDataAnalyzer;
import com.serviceNow.model.MatchProbability.ShapeMatchProbability;
import com.serviceNow.model.coordinates.ShapeCoordinates;
import com.serviceNow.model.shapes.ShapeImage;
import com.serviceNow.model.shapes.ShapeType;
import com.serviceNow.utils.ConvertUtil;

public class DataProcessor {
	
	private final double SCORE_LIMIT = 65.0;
	private char[][] originalImage;
	private char[][] shape;
	private ShapeType shapeType;
	private IDataAnalyzer dataAnalyzer;
	
	
	public DataProcessor(char[][] image, ShapeImage shapeImage) {
		this.originalImage = image;
		this.shape = shapeImage.getShape();
		this.shapeType = shapeImage.getShapeType();
		dataAnalyzer = new DataAnalyzer();
	}
	
	public List<ShapeMatchProbability> process(){
		int shapeLength = shape.length;
		int shapeWidth = shape[0].length;
		int xStartIndex = 0;
		int xEndIndex = shapeWidth;
		int yStartIndex = 0;
		int yEndIndex = shapeLength;
		
		List<ShapeMatchProbability> listOfMatches = new ArrayList<ShapeMatchProbability>();
		while (yEndIndex < originalImage.length){
			while (xEndIndex < originalImage[0].length){
				ShapeMatchProbability matchProbability = getPartFromImage(xStartIndex, xEndIndex, yStartIndex, yEndIndex);
				double similarityScore = dataAnalyzer.getSimilarityScore(matchProbability.getShape(), shape);
				matchProbability.setMatchProbability(similarityScore);
				listOfMatches.add(matchProbability);
				xStartIndex++;
				xEndIndex++;
			}
			yStartIndex++;
			yEndIndex++;
		}
		List<ShapeMatchProbability> filteredMatched = listOfMatches.stream().filter(m -> m.getMatchProbability() > SCORE_LIMIT).collect(Collectors.toList());
		return filteredMatched;
	}
	
	private ShapeMatchProbability getPartFromImage(int x1, int x2, int y1, int y2){
		List<char[]> partialShape = new ArrayList<char[]>();
		for (int i=y1; i >= y1 && i < y2; i++){
			char[] row = new char[x2-x1];
			int rowIndex = 0;
			for (int j=x1; j >= x1 && j < x2; j++){
				row[rowIndex] = originalImage[i][j];
				rowIndex++;
			}
			partialShape.add(row);
		}
		 char[][] partialShapeArray = ConvertUtil.convertToArray(partialShape);
		 ShapeCoordinates shapeCoordinates = new ShapeCoordinates(x1, x2, y1, y2);
		 ShapeMatchProbability matchProbability = new ShapeMatchProbability(partialShapeArray,this.shapeType, shapeCoordinates);
		 return matchProbability;
	}
	
	

}
