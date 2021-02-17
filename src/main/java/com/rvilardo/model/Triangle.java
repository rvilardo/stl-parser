package com.rvilardo.model;

/**
 * Representation of a 3D triangle object.
 * 
 * @author rafaelvilardo
 *
 */
public class Triangle {
	private final Vector3[] vertices;

	/**
	 * Creates a triangle with the given vertices.
	 * 
	 * @param v1 A corner vertex
	 * @param v2 A corner vertex
	 * @param v3 A corner vertex
	 */
	public Triangle(Vector3 v1, Vector3 v2, Vector3 v3) {
		vertices = new Vector3[3];
		vertices[0] = v1;
		vertices[1] = v2;
		vertices[2] = v3;
	}

	/**
	 * Gets the vertices at the corners of this triangle
	 * 
	 * @return An array of vertices
	 */
	public Vector3[] getVertices() {
		return vertices;
	}

	/**
	 * Calculates the area of this triangle.
	 * 
	 * @return Area of the triangle
	 */
	public double getArea() {
		Vector3 edge0 = vertices[1].sub(vertices[0]);
		Vector3 edge1 = vertices[2].sub(vertices[0]);
		Vector3 cp = Vector3.cross(edge0, edge1);
		return .5 * cp.length();
	}

	/**
	 * @see java.lang.Object#toString()
	 * @return A string that provides some information about this triangle
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Triangle[");
		for (Vector3 v : vertices) {
			sb.append(v.toString());
		}
		sb.append("]");
		return sb.toString();
	}

}