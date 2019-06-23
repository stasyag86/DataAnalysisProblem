package com.serviceNow.model.shapes;

public class ShapeImage {

	private char[][] shape;
	private ShapeType shapeType;
	
	public ShapeImage(char[][] shape, ShapeType shapeType) {
		this.shape = shape;
		this.shapeType = shapeType;
	}
	public char[][] getShape() {
		return shape;
	}
	public void setShape(char[][] shape) {
		this.shape = shape;
	}
	public ShapeType getShapeType() {
		return shapeType;
	}
	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}
	
	
}
