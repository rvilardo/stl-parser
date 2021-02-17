package com.rvilardo.model;

/**
 * Vector3 defines a structure to store a 3d information about an object.
 * 
 * @author rafaelvilardo
 *
 */
public final class Vector3 {
	/**
	 * x coordinate.
	 */
	public final double x;

	/**
	 * y coordinate.
	 */
	public final double y;

	/**
	 * z coordinate.
	 */
	public final double z;

	/**
	 * Constructs a Vector3 (3D vector)
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Returns the difference vector of this vector and t (return = this - t) .
	 * 
	 * @param t the vector to be subtracted
	 * @return The vector <code>this - t</code>
	 */
	public Vector3 sub(Vector3 t) {
		return new Vector3(this.x - t.x, this.y - t.y, this.z - t.z);
	}

	/**
	 * Returns the length of this vector.
	 * 
	 * @return the length of this vector
	 */
	public double length() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	/**
	 * Returns the cross product of vectors v1 and v2.
	 * 
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @return The cross product
	 */
	public static Vector3 cross(Vector3 v1, Vector3 v2) {
		double tmpX;
		double tmpY;

		tmpX = v1.y * v2.z - v1.z * v2.y;
		tmpY = v2.x * v1.z - v2.z * v1.x;
		return new Vector3(v1.x * v2.y - v1.y * v2.x, tmpX, tmpY);
	}

	/**
	 * Returns a <code>String</code> that represents the value of this
	 * <code>Vector3</code>.
	 * 
	 * @return a string representation of this <code>Vector3</code>.
	 */
	@Override
	public String toString() {
		return "Vector3[" + x + ", " + y + ", " + z + "]";
	}

}