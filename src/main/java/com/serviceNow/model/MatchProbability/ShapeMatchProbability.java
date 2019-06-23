package com.serviceNow.model.MatchProbability;

import com.serviceNow.model.coordinates.ShapeCoordinates;
import com.serviceNow.model.shapes.ShapeType;

public class ShapeMatchProbability {
	
	private char[][] shape;
	private ShapeType serachType;
	private ShapeCoordinates shapeCoordinates;
	private double matchProbability;
	
	public ShapeMatchProbability(char[][] shape, ShapeType serachType, ShapeCoordinates shapeCoordinates) {
		super();
		this.shape = shape;
		this.serachType = serachType;
		this.shapeCoordinates = shapeCoordinates;
	}

	public char[][] getShape() {
		return shape;
	}

	public void setShape(char[][] shape) {
		this.shape = shape;
	}

	public ShapeType getSerachType() {
		return serachType;
	}

	public void setSerachType(ShapeType serachType) {
		this.serachType = serachType;
	}

	public ShapeCoordinates getShapeCoordinates() {
		return shapeCoordinates;
	}

	public void setShapeCoordinates(ShapeCoordinates shapeCoordinates) {
		this.shapeCoordinates = shapeCoordinates;
	}

	public double getMatchProbability() {
		return matchProbability;
	}

	public void setMatchProbability(double matchProbability) {
		this.matchProbability = matchProbability;
	}
	
	
	
	
	

}
