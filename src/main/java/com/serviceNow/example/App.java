package com.serviceNow.example;

import java.util.ArrayList;
import java.util.List;

import com.serviceNow.fileReader.ReadFile;
import com.serviceNow.model.MatchProbability.ShapeMatchProbability;
import com.serviceNow.model.shapes.ShapeImage;
import com.serviceNow.model.shapes.ShapeType;
import com.serviceNow.processor.DataProcessor;
import com.serviceNow.utils.PrinterUtil;

public class App {
	
	private static final String test_data_file_path = "C:\\Users\\Stas\\Desktop\\ServiceNow\\TestData.snw";
	private static final String hp_ship_file_path = "C:\\Users\\Stas\\Desktop\\ServiceNow\\HPship.snw";
	private static final String hp_torpedo_file_path = "C:\\Users\\Stas\\Desktop\\ServiceNow\\HPTorpedo.snw";

	public static void main(String[] args) {
		List<ShapeMatchProbability> results = startProgram();
	}
	
	public static List<ShapeMatchProbability> startProgram(){
		List<ShapeMatchProbability> listOfMatches = new ArrayList<ShapeMatchProbability>();
		ReadFile readFile = new ReadFile();
		char[][] testDataArray = readFile.convertImageToArray(test_data_file_path);
		char[][] hpShipArray = readFile.convertImageToArray(hp_ship_file_path);
		char[][] hpTorpedoArray = readFile.convertImageToArray(hp_torpedo_file_path);
		ShapeImage hpShipeImage = new ShapeImage(hpShipArray, ShapeType.HP_SHIP);
		ShapeImage hpTorpedoImage = new ShapeImage(hpTorpedoArray, ShapeType.HP_TORPEDO);
		DataProcessor dataProcessorForShip = new DataProcessor(testDataArray, hpShipeImage);
		List<ShapeMatchProbability> listOfMatchesforShip = dataProcessorForShip.process();
		
		DataProcessor dataProcessorForTorpedo = new DataProcessor(testDataArray, hpTorpedoImage);
		List<ShapeMatchProbability> listOfMatchesForTorpedo = dataProcessorForTorpedo.process();
		
		
		listOfMatches.addAll(listOfMatchesforShip);
		listOfMatches.addAll(listOfMatchesForTorpedo);
		System.out.println("type : " + ShapeType.HP_SHIP);
		for (ShapeMatchProbability shape : listOfMatchesforShip){
			System.out.println("score : " + shape.getMatchProbability());
			PrinterUtil.printImage(shape.getShape());
		}
		
		System.out.println("type : " + ShapeType.HP_TORPEDO);
		for (ShapeMatchProbability shape : listOfMatchesForTorpedo){
			System.out.println("score : " + shape.getMatchProbability());
			PrinterUtil.printImage(shape.getShape());
		}
		return listOfMatches;
	}

}
