package com.rvilardo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the collected data from a STL parser.
 * 
 * @author rafaelvilardo
 *
 */
public class Report {
	private String filePath;
	private List<Triangle> triangles = new ArrayList<>();
	private double area;

	public Report(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Adds a triangle and accumulates the total area.
	 * 
	 * @param t triangle from a 3D part
	 */
	public void addTriangule(Triangle t) {
		triangles.add(t);
		area += t.getArea();
	}

	/**
	 * Returns the surface area of the 3D part.
	 * 
	 * @return double
	 */
	public double getArea() {
		return area;
	}

	/**
	 * Returns the number of triangles processed.
	 * 
	 * @return int
	 */
	public int getNumberOfTriangles() {
		return triangles.size();
	}
	
	/**
	 * Returns the file path associated with the file parsed. 
	 * @return String
	 */
	public String getFilePath() {
		return filePath;
	}

}
